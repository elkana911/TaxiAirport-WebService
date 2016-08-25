package com.ppu.taxi.ws.DAO;

import java.math.BigDecimal;
import java.util.List;

import com.ppu.taxi.ws.domain.NotificationGit;
import com.ppu.taxi.ws.domain.TRX_ORDER;
import com.ppu.taxi.ws.domain.driver.MstDeviceDriver;
import com.ppu.taxi.ws.domain.driver.MstUserDriver;
import com.ppu.taxi.ws.pojo.Coordinate;
import com.ppu.taxi.ws.pojo.QueueInfo;

public interface ITaxiDriverDao {

	List<TRX_ORDER> getNearbyTaxiRequests(Coordinate coordinate);
	List<TRX_ORDER> getTaxiRequestByOrderId(String order_id);
	
	List<TRX_ORDER> getNearbyTaxiDrivers(Coordinate coordinate);

	List<TRX_ORDER> getTaxiRequestByPhone(String phone);

	List<TRX_ORDER> getTaxiRequestByDriverPhone(String driverPhone);

	boolean deleteTaxiRequestByPhone(String driverPhone);

	boolean pickupPassengerByPhone(String passengerPhone, String driverPhone);

	List<TRX_ORDER> requestTaxi(Coordinate coordinate, String address, String passengerPhone);

	MstUserDriver signUpDriver(String phone, String imei);

	MstDeviceDriver registerDevice(String id, String imei, String email);
	String checkIn(String driver_id, Coordinate coordinate);
	List<TRX_ORDER> getOrderHistory(String driver_id);
	
	QueueInfo getQueueInfo(String driver_id);
	
	MstUserDriver login(String device_id, String android_id);

	void updateOrderStatus(String order_id, String status, String driver_id, BigDecimal real_price);
	void save_gcm_registration_token(String device_id, String android_id, String reg_token);

	List<NotificationGit> getNewOrders();

}
