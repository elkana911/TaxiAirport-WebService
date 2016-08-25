package com.ppu.taxi.ws.DAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ppu.taxi.ws.domain.MstParam;
import com.ppu.taxi.ws.domain.TRX_ORDER;
import com.ppu.taxi.ws.domain.driver.MstDeviceDriver;
import com.ppu.taxi.ws.domain.pnr.MstUserPassenger;
import com.ppu.taxi.ws.pojo.Coordinate;

public interface ITaxiDao {

	List<TRX_ORDER> getNearbyTaxiDrivers(Coordinate coordinate);

	
	List<TRX_ORDER> getTaxiRequestByPhone(String phone);

	List<TRX_ORDER> getTaxiRequestByDriverPhone(String driverPhone);

	List<TRX_ORDER> requestTaxi(Coordinate coordinate, String address, String passengerPhone);

	boolean deleteTaxiRequestByPhone(String driverPhone);

	MstDeviceDriver registerDevice(String id, String imei, String email);

	MstUserPassenger signUpPassenger(String email, String name, String pwd, String phone,
						String deviceId, String gender, Date birthDate, String location, String status, String regId, String facebookId, String googleId);

	MstUserPassenger login(final String email, final String password);

	boolean isPnrExists(String email);


	void addOrder(Date acquired_date, String cancel_by, Date cancel_date, String cust_id, Date delivered_date,
			String distance, String driver_id, String drop_lat, String drop_loc, String drop_lon, String est_price_high,
			String est_price_low, Date order_date, String order_name, String order_phone, Date pick_date,
			String pick_lat, String pick_loc, String pick_lon, String real_price, String status, String urgency,
			String payment_type);

	List<MstParam> getPickupLocations();


	List<TRX_ORDER> getOrderHistory(String customer_id);


	BigDecimal getEstimatePrice(Double distance);


	void setUpdateOrderStatus(String order_id, String status);


	void setUpdateRegId(String p_cust_id, String p_reg_id);


}
