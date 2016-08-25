package com.eric.ws.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ppu.taxi.ws.service.ITaxiService;
import com.ppu.taxi.ws.service.request.CheckPnrExistsRequest;
import com.ppu.taxi.ws.service.request.EstimatePriceRequest;
import com.ppu.taxi.ws.service.request.RegisterDeviceRequest;
import com.ppu.taxi.ws.service.request.SignUpPassengerRequest;
import com.ppu.taxi.ws.service.request.pnr.LoginRequest;
import com.ppu.taxi.ws.service.request.pnr.OrderHistoryRequest;
import com.ppu.taxi.ws.service.request.pnr.OrderRequest;
import com.ppu.taxi.ws.service.request.pnr.OrderStatusRequest;
import com.ppu.taxi.ws.service.response.BigDecimalResponse;
import com.ppu.taxi.ws.service.response.OrderHistoryResponse;
import com.ppu.taxi.ws.service.response.PickupLocationResponse;
import com.ppu.taxi.ws.service.response.StringResponse;
import com.ppu.taxi.ws.service.response.pnr.LoginPassengerResponse;
import com.ppu.taxi.ws.service.response.pnr.SignUpPassengerResponse;

public class TaxiServiceTest extends BaseManagerTestCase{

	@Autowired ITaxiService taxi;
	
	@Ignore
	@Test
	public void testRegisterDevice() throws Exception{

		RegisterDeviceRequest request = new RegisterDeviceRequest();
		request.setId("ftd14KpyW3U:APA91bE64TMJupgzYI8j6_ZM2iDd8_7IMVRpZAyVBkG-jYbFkYqvv-unAB4fOnbsySUrPW7N6coVcDP8UDptrryyzBX7MmZnHL-DybNGact4Vi3sacGDWdYmBg8ngwBrYbYaFWusLFr-");
		request.setImei("ABC123");
		StringResponse resp = taxi.registerDevice(request);
		
		System.out.println(resp);
	}
	
	@Ignore
	@Test
	public void testSignUp() throws Exception{
		SignUpPassengerRequest request = new SignUpPassengerRequest();
		
		request.setBirthDate("22-11-2015");
		request.setDeviceId("abc123");
		request.setEmail("elkana@ppu.co.id");
		request.setGender("male");
		request.setLocation("jakarta");
		request.setName("eric elkana");
		request.setPhone("081343423423");
		request.setPwd("password");
		request.setStatus("Active");
		
//		{"name": "didik", "pwd":"testtest", "email":"didik@ppu.co.id", "phone": "081343423423", "deviceId":"123ABC", "gender":"male", "birthDate":"22-11-2015", "location":"semarang", "status":"active"}
		
		SignUpPassengerResponse resp = taxi.signUpPassenger(request);
		
		System.out.println(resp);
		
	}
	
	@Ignore
	@Test
	public void testGetEstimatePrice() throws Exception{
		EstimatePriceRequest request = new EstimatePriceRequest();
		request.setDistance((double)37.4);
		
		BigDecimalResponse resp = taxi.getEstimatePrice(request);
		
		System.out.println(resp);
	}
	
	@Ignore
	@Test
	public void testLogin() throws Exception{
		LoginRequest request = new LoginRequest();
		request.setEmail("didik.sudarsono@ppu.co.id");
		request.setPassword("test1234");
		LoginPassengerResponse login = taxi.login(request);
		
		System.out.println(login);
	}

	/*
{"cust_id":"didik.sudarsono@gmail.com", "driver_id":"", "pick_loc":"Soekarno-Hatta Airport - Terminal 1C", "drop_loc":"Jalan Poncol Raya No.42", "urgency":"", "status":"", "est_price_low":"160800.0", "est_price_high":"", "real_price":""
  , "order_date":"17-03-2016 16:15", "acquired_date":"null", "cancel_date": "null", "delivered_date":"null", "cancel_by":"null", "distance":"43.8", "pick_date":"17-03-2016 17:05", "order_name":"Edit", "order_phone":"081234567890"
  , "pick_lat":"-6.126694", "pick_lon":"106.654681", "drop_lat": "-6.243291049392135", "drop_lon":"106.90504979342222", "payment_type":"1"}
	 */
	@Test
	public void testAddOrder() throws Exception{
		
		OrderRequest request = new OrderRequest();
		
		request.setAcquired_date("17-02-2015");
		request.setCancel_by("");
		request.setCancel_date("");
		request.setCust_id("ABC123");
		request.setDelivered_date("17-02-2015");
		request.setDistance("17200");
		request.setDriver_id("D123");
		request.setDrop_lat("10.234545");
		request.setDrop_loc("artha gading");
		request.setDrop_lon("-22.523434");
		request.setEst_price_high("120000");
		request.setEst_price_low("50000");
		request.setOrder_date("17-02-2015 07:50");
		request.setOrder_name("eric");
		request.setOrder_phone("021234343");
		request.setPick_date("17-02-2015 13:00");
		request.setPick_lat("333.21312");
		request.setPick_loc("summarecon");
		request.setPick_lon("-78.12332");
		request.setReal_price("55000");
		request.setStatus("A");
		request.setUrgency("high");
		request.setPayment_type("1");
		
		StringResponse response = taxi.addOrder(request);
		
		System.out.println(response);
	}

	@Ignore
	@Test
	public void testIsCustExists() throws Exception{
		CheckPnrExistsRequest request = new CheckPnrExistsRequest();
		request.setEmail("eric@ppu.co.id");
		
		StringResponse pnrExists = taxi.isPnrExists(request);
		
		System.out.println(pnrExists);
	}
	
	@Ignore
	@Test
	public void testPickupLoc() throws Exception{
		
		PickupLocationResponse pickup_loc = taxi.pickup_loc();
		
		System.out.println(pickup_loc.getData());
	}
	
	@Ignore
	@Test
	public void testGetOrderHistory() throws Exception{
		OrderHistoryRequest request = new OrderHistoryRequest();
		request.setCustomer_id("ABC123");
		
		OrderHistoryResponse orderHistory = taxi.getOrderHistory(request);
		
		System.out.println(orderHistory.getData());
	}

	@Ignore
	@Test
	public void testSetUpdateOrderStatus() throws Exception{
		OrderStatusRequest request = new OrderStatusRequest();
		request.setOrder_id("ABC123");
		request.setStatus("A");
		
		StringResponse updateStatus = taxi.setUpdateOrderStatus(request);
		
		System.out.println(updateStatus.getData());
	}
	
}
