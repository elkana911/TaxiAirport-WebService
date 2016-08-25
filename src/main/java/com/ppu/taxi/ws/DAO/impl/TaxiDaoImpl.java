package com.ppu.taxi.ws.DAO.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;

import com.ppu.taxi.ws.DAO.ITaxiDao;
import com.ppu.taxi.ws.domain.MstParam;
import com.ppu.taxi.ws.domain.TRX_ORDER;
import com.ppu.taxi.ws.domain.driver.MstDeviceDriver;
import com.ppu.taxi.ws.domain.pnr.MstUserPassenger;
import com.ppu.taxi.ws.pojo.Coordinate;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

@Repository("taxiDao")
public class TaxiDaoImpl extends BasicHibernate implements ITaxiDao {

	@Override
	public List<TRX_ORDER> getNearbyTaxiDrivers(Coordinate coordinate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TRX_ORDER> getTaxiRequestByPhone(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TRX_ORDER> getTaxiRequestByDriverPhone(String driverPhone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTaxiRequestByPhone(String driverPhone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TRX_ORDER> requestTaxi(Coordinate coordinate, String address, String passengerPhone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MstDeviceDriver registerDevice(String id, String imei, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MstUserPassenger login(final String email, final String password) {
		
        List<MstUserPassenger> list;
             list = getSession().doReturningWork(new ReturningWork<List<MstUserPassenger>>() {

                  @Override
                  public List<MstUserPassenger> execute(Connection arg0) throws SQLException {
                	  
                  List<MstUserPassenger> _list = new ArrayList<MstUserPassenger>();
                       CallableStatement statement = null;
                  String sqlString ="{? = call p_pkg.sign_in(?, ?)}";
                  statement = arg0.prepareCall(sqlString);

                  statement.registerOutParameter(1, OracleTypes.CURSOR);
                  statement.setString(2, email);
                  statement.setString(3, password);
                  
                  statement.execute();     //selalu false
                 
                  ResultSet rs = ((OracleCallableStatement)statement).getCursor(1);
                  
//                  ResultSet rs = statement.getResultSet();
                 
                  if (rs == null)
                       return _list;
                 
                  while (rs.next()){
                	   MstUserPassenger _pm = new MstUserPassenger();
                       _pm.setBirthDate(rs.getDate("BIRTHDATE"));
                       _pm.setCreated_by(rs.getString("CREATED_BY"));
                       _pm.setCreated_date(rs.getDate("CREATED_DATE"));
                       _pm.setCust_id(rs.getString("CUST_ID"));
                       _pm.setCust_name(rs.getString("CUST_NAME"));
                       _pm.setCust_pwd(rs.getString("CUST_PWD"));
                       _pm.setDevice_id(rs.getString("DEVICE_ID"));
                       _pm.setGender(rs.getString("GENDER"));
                       _pm.setLocation(rs.getString("LOCATION"));
                       _pm.setModified_by(rs.getString("MODIFIED_BY"));
                       _pm.setModified_date(rs.getDate("MODIFIED_DATE"));
                       _pm.setPhone_no(rs.getString("PHONE_NO"));
                       _pm.setStatus(rs.getString("STATUS"));
                       
                       _list.add(_pm);
                  }
                 
                  return _list;
                  }
             });              
            
             if (list.size() > 0)
     			return (MstUserPassenger) list.get(0);
             else
            	 return null;
	}

	@Override
	public boolean isPnrExists(final String email) {
		Long ret;
        	ret = getSession().doReturningWork(new ReturningWork<Long>() {

				@Override
				public Long execute(Connection connection) throws SQLException {
					CallableStatement statement = null;
                    String sqlString ="{? = call p_pkg.is_exists_cust(?)}";
                    statement = connection.prepareCall(sqlString);
                    statement.registerOutParameter(1, OracleTypes.NUMBER);
                    
                    statement.setString(2, email);
                    
                    statement.execute();	//selalu false
                    

                    return statement.getLong(1);

				}
        		
			});

        	return ret > 0;
	}

	@Override
	public MstUserPassenger signUpPassenger(final String email, final String name, final String pwd, final String phone, final String deviceId,
			final String gender, final Date birthDate, final String location, final String status,
			final String regId, final String facebookId, final String googleId) {
		
		MstUserPassenger ret;
        	ret = getSession().doReturningWork(new ReturningWork<MstUserPassenger>() {

				@Override
				public MstUserPassenger execute(Connection connection) throws SQLException {
					CallableStatement statement = null;
                    String sqlString = "{? = call p_pkg.sign_up(?, ?, ?, ?, ?,"
                    										+ " ?, ?, ?, ?, ?,"
                    										+ " ?, ?)}";
                    statement = connection.prepareCall(sqlString);
                    statement.registerOutParameter(1, OracleTypes.CURSOR);
                    
                    statement.setString(2, email);
                    statement.setString(3, name);
                    statement.setString(4, pwd);
                    statement.setString(5, phone);
                    statement.setString(6, deviceId);
                    statement.setString(7, gender);
                    statement.setDate(8, birthDate == null ? null : new java.sql.Date(birthDate.getTime()));
                    statement.setString(9, location);
                    statement.setString(10, status);
                    statement.setString(11, regId);
                    statement.setString(12, facebookId);
                    statement.setString(13, googleId);
                    
                    statement.execute();	//selalu false

                    ResultSet rs = ((OracleCallableStatement)statement).getCursor(1);
                    
                    if (rs != null)
	                	while (rs.next()){
	                 	   MstUserPassenger _pm = new MstUserPassenger();
	                 	   
	                       _pm.setBirthDate(rs.getDate("BIRTHDATE"));
	                       _pm.setCreated_by(rs.getString("CREATED_BY"));
	                       _pm.setCreated_date(rs.getDate("CREATED_DATE"));
	                       _pm.setCust_id(rs.getString("CUST_ID"));
	                       _pm.setCust_name(rs.getString("CUST_NAME"));
	                       _pm.setCust_pwd(rs.getString("CUST_PWD"));
	                       _pm.setDevice_id(rs.getString("DEVICE_ID"));
	                       _pm.setGender(rs.getString("GENDER"));
	                       _pm.setLocation(rs.getString("LOCATION"));
	                       _pm.setModified_by(rs.getString("MODIFIED_BY"));
	                       _pm.setModified_date(rs.getDate("MODIFIED_DATE"));
	                       _pm.setPhone_no(rs.getString("PHONE_NO"));
	                       _pm.setStatus(rs.getString("STATUS"));
	                       _pm.setReg_id(rs.getString("REG_ID"));
	                       _pm.setFacebook_id(rs.getString("FACEBOOK_ID"));
	                       _pm.setGoogle_id(rs.getString("GOOGLE_ID"));
	                		
	                		return _pm;
	                	}
                    
                    return null;
                    	
				}
        		
			});

        	return ret;
	}

	@Override
	public void addOrder(final Date acquired_date, final String cancel_by, final Date cancel_date, final String cust_id,
			final Date delivered_date, final String distance, final String driver_id, final String drop_lat, final String drop_loc, final String drop_lon,
			final String est_price_high, final String est_price_low, final Date order_date, final String order_name, final String order_phone,
			final Date pick_date, final String pick_lat, final String pick_loc, final String pick_lon, final String real_price, final String status,
			final String urgency, final String payment_type) {
            getSession().doWork(new Work() {
				
				@Override
				public void execute(Connection connection) throws SQLException {
                    CallableStatement statement = null;
                    String sqlString ="{call p_pkg.add_order(?, ?, ?, ?, ?,"
                    		+ "?, ?, ?, ?, ?,"
                    		+ "?, ?, ?, ?, ?,"
                    		+ "?, ?, ?, ?, ?,"
                    		+ "?, ?, ?)}";
                    statement = connection.prepareCall(sqlString);

                    statement.setString(1, cust_id);
                    statement.setString(2, driver_id);
                    statement.setString(3, pick_loc);
                    statement.setString(4, drop_loc);
                    statement.setString(5, urgency);
                    statement.setString(6, status);
                    statement.setString(7, est_price_low);
                    statement.setString(8, est_price_high);
                    statement.setString(9, real_price);
                    statement.setDate(10, order_date == null ? null : new java.sql.Date(order_date.getTime()));
                    statement.setDate(11, acquired_date == null ? null : new java.sql.Date(acquired_date.getTime()));
                    statement.setDate(12, cancel_date == null ? null : new java.sql.Date(cancel_date.getTime()));
                    statement.setDate(13, delivered_date == null ? null : new java.sql.Date(delivered_date.getTime()));
                    statement.setString(14, cancel_by);
                    statement.setString(15, distance);
                    
                    statement.setTimestamp(16, pick_date == null ? null : new java.sql.Timestamp(pick_date.getTime()));
                    
                    statement.setString(17, order_name);
                    statement.setString(18, order_phone);
                    statement.setString(19, pick_lat);
                    statement.setString(20, pick_lon);
                    statement.setString(21, drop_lat);
                    statement.setString(22, drop_lon);
                    statement.setString(23, payment_type);

                    statement.execute();    //selalu false
				}
			});

	}

	@Override
	public List<MstParam> getPickupLocations() {
		 List<MstParam> list;
	             list = getSession().doReturningWork(new ReturningWork<List<MstParam>>() {

	                  @Override
	                  public List<MstParam> execute(Connection arg0) throws SQLException {
	                	  
	                  List<MstParam> _list = new ArrayList<MstParam>();
	                  
	                  CallableStatement statement = null;
	                  
	                  String sqlString ="{? = call p_pkg.get_pickup_location()}";
	                  statement = arg0.prepareCall(sqlString);

	                  statement.registerOutParameter(1, OracleTypes.CURSOR);
	                  
	                  statement.execute();     //selalu false

	                  ResultSet rs = ((OracleCallableStatement)statement).getCursor(1);

	                  if (rs == null)
	                       return _list;
	                 
	                  while (rs.next()){
	                	  MstParam obj = new MstParam();
	                	  
	                	  obj.setPar_desc(rs.getString("PAR_DESC"));
	                	  obj.setPar_group(rs.getString("PAR_GROUP"));
	                	  obj.setPar_id(rs.getString("PAR_ID"));
	                	  obj.setPar_value(rs.getString("PAR_VALUE"));
	                	  
	                       _list.add(obj);
	                  }
	                 
	                  return _list;
	                  }
	             });              
	            
	             return list;
	     		
	}

	@Override
	public List<TRX_ORDER> getOrderHistory(final String customer_id) {
		List<TRX_ORDER> list;
			list = getSession().doReturningWork(new ReturningWork<List<TRX_ORDER>>() {

				@Override
				public List<TRX_ORDER> execute(Connection arg0) throws SQLException {
					
					List<TRX_ORDER> _list = new ArrayList<TRX_ORDER>();
					CallableStatement statement = null;
                    String sqlString ="{? = call p_pkg.my_order_hist(?)}";
                    statement = arg0.prepareCall(sqlString);
                    statement.registerOutParameter(1, OracleTypes.CURSOR);
                    
                    statement.setString(2, customer_id);
                    
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
                    	
                    	_pm.setDriver_name(rs.getString("DRIVER_NAME"));
                    	_pm.setVehicle_id(rs.getString("VEHICLE_ID"));

                    	_list.add(_pm);
                    }
                    
                    return _list;
				}
			});			
			
			return list;
	}

	@Override
	public BigDecimal getEstimatePrice(final Double distance) {
		BigDecimal ret;
        	ret = getSession().doReturningWork(new ReturningWork<BigDecimal>() {

				@Override
				public BigDecimal execute(Connection connection) throws SQLException {
					CallableStatement statement = null;
                    String sqlString ="{? = call p_pkg.get_estimate_price(?)}";
                    statement = connection.prepareCall(sqlString);
                    statement.registerOutParameter(1, OracleTypes.NUMBER);
                    
                    statement.setDouble(2, distance);
                    
                    statement.execute();	//selalu false
                    

                    return statement.getBigDecimal(1);

				}
        		
			});


        return ret;
	}

	@Override
	public void setUpdateOrderStatus(final String order_id, final String status) {
            getSession().doWork(new Work() {
				
				@Override
				public void execute(Connection connection) throws SQLException {
                    CallableStatement statement = null;
                    String sqlString ="{call p_pkg.update_order_status(?, ?)}";
                    statement = connection.prepareCall(sqlString);

                    statement.setString(1, order_id);
                    statement.setString(2, status);

                    statement.execute();    //selalu false
				}
			});

	}

	@Override
	public void setUpdateRegId(final String p_cust_id, final String p_reg_id) {
        getSession().doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
                CallableStatement statement = null;
                String sqlString ="{call p_pkg.update_reg_id(?, ?)}";
                statement = connection.prepareCall(sqlString);

                statement.setString(1, p_cust_id);
                statement.setString(2, p_reg_id);

                statement.execute();    //selalu false
			}
		});
	}


}
