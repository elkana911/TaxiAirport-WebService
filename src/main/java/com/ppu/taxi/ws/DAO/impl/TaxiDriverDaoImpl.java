package com.ppu.taxi.ws.DAO.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.ppu.taxi.ws.DAO.ITaxiDriverDao;
import com.ppu.taxi.ws.domain.NotificationGit;
import com.ppu.taxi.ws.domain.TRX_ORDER;
import com.ppu.taxi.ws.domain.driver.MstDeviceDriver;
import com.ppu.taxi.ws.domain.driver.MstUserDriver;
import com.ppu.taxi.ws.domain.driver.QueueDriver;
import com.ppu.taxi.ws.pojo.Coordinate;
import com.ppu.taxi.ws.pojo.QueueInfo;

import oracle.jdbc.OracleTypes;

@Repository("taxiDriverDao")
public class TaxiDriverDaoImpl extends BasicHibernate implements ITaxiDriverDao {

	@Override
	public List<TRX_ORDER> getNearbyTaxiRequests(Coordinate coordinate) {
		double lat = Double.parseDouble(coordinate.getLatitude());
		double lng = Double.parseDouble(coordinate.getLongitude());

		double min_lat = lat - .285;
		double max_lat = lat + .285;
		double min_long = lng - .285;
		double max_long = lng + .285;

//		$q = "SELECT * FROM taxiRequests WHERE (latitude BETWEEN $min_lat AND $max_lat) AND (longitude BETWEEN $min_long AND $max_long) AND (driverPhone = 0)";
		String sql = "select * from TRX_ORDER where (pick_lat between :minlat and :maxlat) AND (pick_lon between :minlong and :maxlong) AND status = 'O'";
//		String sql = "select * from TRX_ORDER";
		SQLQuery q = getSession().createSQLQuery(sql);
		
		q.addScalar("order_id", StandardBasicTypes.STRING);
		q.addScalar("cust_id", StandardBasicTypes.STRING);
		q.addScalar("driver_id", StandardBasicTypes.STRING);
		q.addScalar("pick_loc", StandardBasicTypes.STRING);
		q.addScalar("drop_loc", StandardBasicTypes.STRING);
		q.addScalar("urgency", StandardBasicTypes.STRING);
		q.addScalar("status", StandardBasicTypes.STRING);
		q.addScalar("est_price_low", StandardBasicTypes.DOUBLE);
		q.addScalar("est_price_high", StandardBasicTypes.DOUBLE);
		q.addScalar("real_price", StandardBasicTypes.DOUBLE);
		q.addScalar("order_date", StandardBasicTypes.TIMESTAMP);
		q.addScalar("acquired_date", StandardBasicTypes.TIMESTAMP);
		q.addScalar("cancel_date", StandardBasicTypes.TIMESTAMP);
		q.addScalar("delivered_date", StandardBasicTypes.TIMESTAMP);
		q.addScalar("cancel_by", StandardBasicTypes.STRING);
		q.addScalar("distance", StandardBasicTypes.LONG);
		q.addScalar("pick_date", StandardBasicTypes.TIMESTAMP);
		q.addScalar("order_name", StandardBasicTypes.STRING);
		q.addScalar("order_phone", StandardBasicTypes.STRING);
		q.addScalar("pick_lat", StandardBasicTypes.STRING);
		q.addScalar("pick_lon", StandardBasicTypes.STRING);
		q.addScalar("drop_lat", StandardBasicTypes.STRING);
		q.addScalar("drop_lon", StandardBasicTypes.STRING);
		
		q.setResultTransformer(Transformers.aliasToBean(TRX_ORDER.class));
		
		q.setParameter("minlat", min_lat);
		q.setParameter("maxlat", max_lat);
		q.setParameter("minlong", min_long);
		q.setParameter("maxlong", max_long);
		
		
		List<TRX_ORDER> list = q.list();
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<TRX_ORDER> getTaxiRequestByOrderId(final String order_id) {
		List<TRX_ORDER> list;
			list = getSession().doReturningWork(new ReturningWork<List<TRX_ORDER>>() {

				@Override
				public List<TRX_ORDER> execute(Connection arg0) throws SQLException {
					
					List<TRX_ORDER> _list = new ArrayList<TRX_ORDER>();
					CallableStatement statement = null;
                    String sqlString ="{call d_pkg.get_order_by_id(?, ?)}";
                    statement = arg0.prepareCall(sqlString);
                    statement.registerOutParameter(1, OracleTypes.CURSOR);
                    
                    statement.setString(2, order_id);
                    
                    statement.execute();	//selalu false
                    
                    ResultSet rs = (ResultSet) statement.getObject(1);
                    
                    if (rs == null)
                    	return _list;
                    
                    /*
                    int colCount = rs.getMetaData().getColumnCount();
                    System.out.println("getPositions");
                    for (int i = 0; i < colCount; i++){
                    	System.out.println(rs.getMetaData().getColumnLabel(i+1));
                    }
                    */
                    while (rs.next()){
                    	TRX_ORDER _pm = new TRX_ORDER();
                    	_pm.setAcquired_date(rs.getTimestamp("ACQUIRED_DATE"));
                    	_pm.setCancel_by(rs.getString("CANCEL_BY"));
                    	_pm.setCancel_date(rs.getTimestamp("CANCEL_DATE"));
                    	_pm.setCust_id(rs.getString("CUST_ID"));
                    	_pm.setDelivered_date(rs.getTimestamp("DELIVERED_DATE"));
                    	_pm.setDistance(rs.getLong("DISTANCE"));
                    	_pm.setDriver_id(rs.getString("DRIVER_ID"));
                    	_pm.setDrop_lat(rs.getString("DROP_LAT"));
                    	_pm.setDrop_loc(rs.getString("DROP_LOC"));
                    	_pm.setDrop_lon(rs.getString("DROP_LON"));
                    	_pm.setEst_price_high(rs.getDouble("EST_PRICE_HIGH"));
                    	_pm.setEst_price_low(rs.getDouble("EST_PRICE_LOW"));
                    	_pm.setOrder_date(rs.getTimestamp("ORDER_DATE"));
                    	_pm.setOrder_id(rs.getString("ORDER_ID"));
                    	_pm.setOrder_name(rs.getString("ORDER_NAME"));
                    	_pm.setOrder_phone(rs.getString("ORDER_PHONE"));
                    	_pm.setPick_date(rs.getTimestamp("PICK_DATE"));
                    	_pm.setPick_lat(rs.getString("PICK_LAT"));
                    	_pm.setPick_loc(rs.getString("PICK_LOC"));
                    	_pm.setPick_lon(rs.getString("PICK_LON"));
                    	_pm.setReal_price(rs.getDouble("REAL_PRICE"));
                    	_pm.setStatus(rs.getString("STATUS"));
                    	_pm.setUrgency(rs.getString("URGENCY"));

                    	_list.add(_pm);
                    }
                    
                    return _list;
				}
			});			
			
			return list;

	}


	@Override
	public List<TRX_ORDER> getNearbyTaxiDrivers(Coordinate coordinate) {
		
		double lat = Double.parseDouble(coordinate.getLatitude());
		double lng = Double.parseDouble(coordinate.getLongitude());

		double min_lat = lat - .285;
		double max_lat = lat + .285;
		double min_long = lng - .285;
		double max_long = lng + .285;
		
//		$q = "SELECT * FROM taxiDrivers WHERE (latitude BETWEEN $min_lat AND $max_lat) AND (longitude BETWEEN $min_long AND $max_long)";
		SQLQuery q = getSession().createSQLQuery("select * from TRX_ORDER where (latitude between :minlat and :maxlat) AND (longitude between :minlong and :maxlong)");
//		q.addEntity("a", );
		q.setParameter("minlat", min_lat);
		q.setParameter("maxlat", max_lat);
		q.setParameter("minlong", min_long);
		q.setParameter("maxlong", max_long);
		
		List<TRX_ORDER> list = q.list();
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<TRX_ORDER> getTaxiRequestByPhone(String phone) {
//		$q = "SELECT * FROM taxiRequests WHERE phone = '123' 
		SQLQuery q = getSession().createSQLQuery("select * from TRX_ORDER where phone = :phone");
//		q.addEntity("a", );
		q.setParameter("phone", phone);
		
		List<TRX_ORDER> list = q.list();
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<TRX_ORDER> getTaxiRequestByDriverPhone(String driverPhone) {
//		$q = "SELECT * FROM taxiRequests WHERE phone = '123' 
		SQLQuery q = getSession().createSQLQuery("select * from TRX_ORDER where driverPhone = :phone");
//		q.addEntity("a", );
		q.setParameter("phone", driverPhone);
		
		List<TRX_ORDER> list = q.list();
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public boolean deleteTaxiRequestByPhone(String driverPhone) {
        Query q = getSession().createQuery("delete from TRX_ORDER where driverPhone = :phone");
        q.setParameter("phone", driverPhone);
        
        int i = q.executeUpdate();
        
		return i > 0;
	}

	@Override
	public boolean pickupPassengerByPhone(String passengerPhone, String driverPhone) {
        Query q = getSession().createQuery("update TRX_ORDER set driverPhone = :driverPhone where phone = :phone");
        q.setParameter("driverPhone", driverPhone);
        q.setParameter("phone", passengerPhone);
        
        int i = q.executeUpdate();
        
		return i > 0;
	}

	@Override
	public List<TRX_ORDER> requestTaxi(Coordinate coordinate, String address, String passengerPhone) {
		
		double lat = Double.parseDouble(coordinate.getLatitude());
		double lng = Double.parseDouble(coordinate.getLongitude());
		
		String insertedId = "123";
		String sql = "insert into TRX_ORDER(id, latitude, longitude, address, phone) values (:id, :latitude, :longitude, :address, :phone)";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("id", insertedId);
		q.setParameter("latitude", lat);
		q.setParameter("longitude", lng);
		q.setParameter("address", address);
		q.setParameter("phone", passengerPhone);
		q.executeUpdate();
		
		q = getSession().createSQLQuery("select * from TRX_ORDER where id=:id");
		q.setParameter("id", insertedId);
		
		List<TRX_ORDER> list = q.list();
		
		return list;
	}

	@Override
	public MstUserDriver signUpDriver(String phone, String imei) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MstDeviceDriver registerDevice(String id, String imei, String email) {
		
		MstDeviceDriver bean = new MstDeviceDriver();
		bean.setId(id);
		bean.setImei(imei);
		bean.setEmail(email);

		getSession().saveOrUpdate(bean);

		return bean;
	}

	@Override
	public String checkIn(final String driver_id, final Coordinate coordinate) {
			
		String ret;
		ret = getSession().doReturningWork(new ReturningWork<String>() {

			@Override
			public String execute(Connection connection) throws SQLException {
                CallableStatement statement = null;
                String sqlString ="{call d_pkg.check_in(?, ?, ?, ?)}";
                statement = connection.prepareCall(sqlString);

        		double lat = Double.parseDouble(coordinate.getLatitude());
        		double lng = Double.parseDouble(coordinate.getLongitude());

        		statement.setString(1, driver_id);
                statement.setDouble(2, lat);
                statement.setDouble(3, lng);
                statement.registerOutParameter(4, OracleTypes.VARCHAR);

                statement.execute();    //selalu false
                
                String ret = statement.getString(4);

                return ret;
			}
		});
		return ret;
	}

	@Override
	public List<TRX_ORDER> getOrderHistory(final String driver_id) {
		List<TRX_ORDER> list;
			list = getSession().doReturningWork(new ReturningWork<List<TRX_ORDER>>() {

				@Override
				public List<TRX_ORDER> execute(Connection arg0) throws SQLException {
					
					List<TRX_ORDER> _list = new ArrayList<TRX_ORDER>();
					CallableStatement statement = null;
                    String sqlString ="{? = call d_pkg.get_order_hist(?)}";
                    statement = arg0.prepareCall(sqlString);
                    statement.registerOutParameter(1, OracleTypes.CURSOR);
                    
                    statement.setString(2, driver_id);
                    
                    statement.execute();	//selalu false
                    
                    ResultSet rs = (ResultSet) statement.getObject(1);
                    
                    if (rs == null)
                    	return _list;
                    
                    /*
                    int colCount = rs.getMetaData().getColumnCount();
                    System.out.println("getPositions");
                    for (int i = 0; i < colCount; i++){
                    	System.out.println(rs.getMetaData().getColumnLabel(i+1));
                    }
                    */
                    while (rs.next()){
                    	TRX_ORDER _pm = new TRX_ORDER();
                    	_pm.setAcquired_date(rs.getTimestamp("ACQUIRED_DATE"));
                    	_pm.setCancel_by(rs.getString("CANCEL_BY"));
                    	_pm.setCancel_date(rs.getTimestamp("CANCEL_DATE"));
                    	_pm.setCust_id(rs.getString("CUST_ID"));
                    	_pm.setDelivered_date(rs.getTimestamp("DELIVERED_DATE"));
                    	_pm.setDistance(rs.getLong("DISTANCE"));
                    	_pm.setDriver_id(rs.getString("DRIVER_ID"));
                    	_pm.setDrop_lat(rs.getString("DROP_LAT"));
                    	_pm.setDrop_loc(rs.getString("DROP_LOC"));
                    	_pm.setDrop_lon(rs.getString("DROP_LON"));
                    	_pm.setEst_price_high(rs.getDouble("EST_PRICE_HIGH"));
                    	_pm.setEst_price_low(rs.getDouble("EST_PRICE_LOW"));
                    	_pm.setOrder_date(rs.getTimestamp("ORDER_DATE"));
                    	_pm.setOrder_id(rs.getString("ORDER_ID"));
                    	_pm.setOrder_name(rs.getString("ORDER_NAME"));
                    	_pm.setOrder_phone(rs.getString("ORDER_PHONE"));
                    	_pm.setPick_date(rs.getTimestamp("PICK_DATE"));
                    	_pm.setPick_lat(rs.getString("PICK_LAT"));
                    	_pm.setPick_loc(rs.getString("PICK_LOC"));
                    	_pm.setPick_lon(rs.getString("PICK_LON"));
                    	_pm.setReal_price(rs.getDouble("REAL_PRICE"));
                    	_pm.setStatus(rs.getString("STATUS"));
                    	_pm.setUrgency(rs.getString("URGENCY"));

                    	_list.add(_pm);
                    }
                    
                    return _list;
				}
			});			
			
			return list;

	}

	@Override
	public QueueInfo getQueueInfo(final String driver_id) {
		QueueInfo ret;
		ret = getSession().doReturningWork(new ReturningWork<QueueInfo>() {

			@Override
			public QueueInfo execute(Connection connection) throws SQLException {
                CallableStatement statement = null;
                String sqlString ="{call d_pkg.get_queue_info(?, ?, ?)}";
                statement = connection.prepareCall(sqlString);

                statement.registerOutParameter(1, OracleTypes.CURSOR);
                statement.registerOutParameter(2, OracleTypes.NUMBER);
                statement.setString(3, driver_id);

                statement.execute();    //selalu false

                List<QueueDriver> list = null;
                ResultSet rs = (ResultSet) statement.getObject(1);
                if (rs != null){
                	list = new ArrayList<QueueDriver>();
                	while (rs.next()){
                		QueueDriver _obj = new QueueDriver();
                		_obj.setCheck_in_time(rs.getTimestamp("CHECK_IN_TIME"));
                		_obj.setDriver_id(rs.getString("DRIVER_ID"));
                		_obj.setLocation(rs.getString("LOCATION"));
                		_obj.setQueue_no(rs.getLong("QUEUE_NO"));
                		
                		list.add(_obj);
                	}
                }
                
                Long ret1 = statement.getLong(2);
                
                QueueInfo queueInfo = new QueueInfo();
                
                if (list.size() > 0)
                	queueInfo.setQueueinfo(list.get(0));
                
                queueInfo.setCurr_queue_no(ret1);

                return queueInfo;
			}
		});
		return ret;
	}

	@Override
	public MstUserDriver login(final String device_id, final String android_id) {
        List<MstUserDriver> list;
             list = getSession().doReturningWork(new ReturningWork<List<MstUserDriver>>() {

                  @Override
                  public List<MstUserDriver> execute(Connection arg0) throws SQLException {
                	  
                  List<MstUserDriver> _list = new ArrayList<MstUserDriver>();
                       CallableStatement statement = null;
                  String sqlString ="{call d_pkg.auth_driver(?, ?, ?)}";
                  statement = arg0.prepareCall(sqlString);

                  statement.registerOutParameter(1, OracleTypes.CURSOR);
                  statement.setString(2, device_id);
                  statement.setString(3, android_id);
                  
                  statement.execute();     //selalu false
                 
                  ResultSet rs = (ResultSet) statement.getObject(1);
                  
                  if (rs == null)
                       return _list;
                 
                  while (rs.next()){
                	   MstUserDriver _pm = new MstUserDriver();
                	   _pm.setBilling_id(rs.getString("BILLING_ID"));
                	   _pm.setCompany_id(rs.getString("COMPANY_ID"));
                	   _pm.setDriver_id(rs.getString("DRIVER_ID"));
                	   _pm.setEmail(rs.getString("EMAIL"));
                	   _pm.setFull_name(rs.getString("FULL_NAME"));
                	   _pm.setAndroid_id(rs.getString("ANDROID_ID"));
                	   _pm.setPassword(rs.getString("PASSWORD"));
                	   _pm.setPhone(rs.getString("PHONE"));
                	   _pm.setReg_id(rs.getString("REG_ID"));
                	   _pm.setVehicle_id(rs.getString("VEHICLE_ID"));
                	   
                	   _pm.setCreated_by(rs.getString("CREATED_BY"));
                	   _pm.setCreated_date(rs.getDate("CREATED_DATE"));
                	   _pm.setModified_by(rs.getString("MODIFIED_BY"));
                	   _pm.setModified_date(rs.getDate("MODIFIED_DATE"));
                	   _pm.setDevice_id(rs.getString("DEVICE_ID"));
                	   _pm.setStatus(rs.getString("STATUS"));
                       
                       _list.add(_pm);
                  }
                 
                  return _list;
                  }
             });              
            
             if (list.size() > 0)
     			return (MstUserDriver) list.get(0);
     		
        return null;
	}

	@Override
	public void updateOrderStatus(final String order_id, final String status, final String driver_id, final BigDecimal real_price) {
        getSession().doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
                CallableStatement statement = null;
                String sqlString ="{call bus_pkg.update_order_status(?, ?, ?, ?)}";
                statement = connection.prepareCall(sqlString);

                statement.setString(1, order_id);
                statement.setString(2, status);
                statement.setString(3, driver_id);
                statement.setBigDecimal(4, real_price);

                statement.execute();    //selalu false
			}
		});
	}

	@Override
	public void save_gcm_registration_token(final String device_id, final String android_id, final String reg_token) {
        getSession().doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
                CallableStatement statement = null;
                String sqlString ="{call d_pkg.save_gcm_registration_token(?, ?, ?)}";
                statement = connection.prepareCall(sqlString);

                statement.setString(1, device_id);
                statement.setString(2, android_id);
                statement.setString(3, reg_token);

                statement.execute();    //selalu false
			}
		});
	}

	@Override
	public List<NotificationGit> getNewOrders() {
		 List<NotificationGit> list;
		 
	             list = getSession().doReturningWork(new ReturningWork<List<NotificationGit>>() {

	                  @Override
	                  public List<NotificationGit> execute(Connection arg0) throws SQLException {
	                	  
		                  List<NotificationGit> _list = new ArrayList<NotificationGit>();
		                 
		                  CallableStatement statement = null;
		                  String sqlString ="{call bus_pkg.p_order_to_driver(?)}";
	               
		                  statement = arg0.prepareCall(sqlString);
	
		                  statement.registerOutParameter(1, OracleTypes.CURSOR);
		              	              
		                  statement.execute();     //selalu false
		                  
		                  ResultSet rs = (ResultSet) statement.getObject(1);
		                  
		                  if (rs == null)
		                       return _list;
		                 
		                  while (rs.next()){
		                	   NotificationGit _pm = new NotificationGit();
		                	   _pm.setOrder_id(rs.getString("ORDER_ID"));
		                	   _pm.setCust_reg_id(rs.getString("CUST_REG_ID"));
		                	   _pm.setCust_id(rs.getString("CUST_ID"));
		                	   _pm.setDriver_id(rs.getString("DRIVER_ID"));
		                	   _pm.setVehicle_id(rs.getString("VEHICLE_ID"));
		                	   _pm.setCust_name(rs.getString("CUST_NAME"));
		                	   _pm.setDriver_name(rs.getString("DRIVER_NAME"));
		                	   _pm.setDriver_reg_id(rs.getString("DRIVER_REG_ID"));
		                       
		                       _list.add(_pm);
		                  }
		                 
		                  return _list;
	                  
	                  }
	                });              
	             
	        return list;
	}

}
