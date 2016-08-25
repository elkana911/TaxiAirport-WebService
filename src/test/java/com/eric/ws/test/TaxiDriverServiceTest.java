package com.eric.ws.test;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ppu.taxi.ws.pojo.Coordinate;
import com.ppu.taxi.ws.service.ITaxiDriverService;
import com.ppu.taxi.ws.service.request.NearbyTaxiRequestsRequest;
import com.ppu.taxi.ws.service.request.RegisterDeviceRequest;
import com.ppu.taxi.ws.service.request.TaxiRequestByOrderRequest;
import com.ppu.taxi.ws.service.request.driver.CheckInRequest;
import com.ppu.taxi.ws.service.request.driver.LoginDriverRequest;
import com.ppu.taxi.ws.service.request.driver.OrderHistoryRequest;
import com.ppu.taxi.ws.service.request.driver.OrderStatusRequest;
import com.ppu.taxi.ws.service.request.driver.QueueInfoRequest;
import com.ppu.taxi.ws.service.request.driver.RegistrationTokenRequest;
import com.ppu.taxi.ws.service.response.NearbyTaxiRequestsResponse;
import com.ppu.taxi.ws.service.response.OrderHistoryResponse;
import com.ppu.taxi.ws.service.response.StringResponse;
import com.ppu.taxi.ws.service.response.TaxiRequestByOrderResponse;
import com.ppu.taxi.ws.service.response.driver.LoginDriverResponse;
import com.ppu.taxi.ws.service.response.driver.QueueInfoResponse;
import com.ppu.taxi.ws.util.Utils;

public class TaxiDriverServiceTest extends BaseManagerTestCase{

	@Autowired ITaxiDriverService taxi;
	
	@Ignore
	@Test
	public void testGetTaxiRequestByOrderId() throws Exception{
		
		TaxiRequestByOrderRequest request = new TaxiRequestByOrderRequest();
		request.setOrder_id("O123");
		
		TaxiRequestByOrderResponse taxiRequestByOrderId = taxi.getTaxiRequestByOrderId(request);
		
		assertNotNull(taxiRequestByOrderId.getData());
	}

	@Ignore
	@Test
	public void testGetNearbyTaxiRequests() throws Exception{
		
		NearbyTaxiRequestsRequest request = new NearbyTaxiRequestsRequest();
		Coordinate coord = new Coordinate();
		coord.setLatitude("-6.129388");
		coord.setLongitude("106.655492");
		request.setCoordinate(coord);
		
		NearbyTaxiRequestsResponse nearbyTaxiRequests = taxi.getNearbyTaxiRequests(request);
		
		Utils.print(nearbyTaxiRequests.getData());
		
	}
	
	@Ignore
	@Test
	public void testRegisterDevice() throws Exception{

		RegisterDeviceRequest request = new RegisterDeviceRequest();
		request.setId("ftd14KpyW3U:APA91bE64TMJupgzYI8j6_ZM2iDd8_7IMVRpZAyVBkG-jYbFkYqvv-unAB4fOnbsySUrPW7N6coVcDP8UDptrryyzBX7MmZnHL-DybNGact4Vi3sacGDWdYmBg8ngwBrYbYaFWusLFr-");
		request.setImei("ABC123");
		StringResponse resp = taxi.registerDevice(request);
		
		assertNotNull(resp);
	}
	
	@Ignore
	@Test
	public void testCheckIn() throws Exception{
		
		CheckInRequest request = new CheckInRequest();
		request.setDriver_id("D123");

		Coordinate coord = new Coordinate();
		coord.setLatitude("-6.129388");
		coord.setLongitude("106.655492");
		request.setCoordinate(coord);
		
		StringResponse response = taxi.checkIn(request);
		
		System.out.println(response);
		
		
	}

	@Ignore
	@Test
	public void testGetOrderHistory() throws Exception{
		OrderHistoryRequest request = new OrderHistoryRequest();
		request.setDriver_id("ABC123");
		
		OrderHistoryResponse orderHistory = taxi.getOrderHistory(request);
		
		System.out.println(orderHistory.getData());
	}

	@Ignore
	@Test
	public void testGetQueueInfo() throws Exception{
		QueueInfoRequest request = new QueueInfoRequest();
		request.setDriver_id("ABC123");
		QueueInfoResponse resp = taxi.getQueueInfo(request);
		
		System.out.println(resp.getData());
	}
	
	@Ignore
	@Test
	public void testLogin() throws Exception{
		LoginDriverRequest request = new LoginDriverRequest();
		request.setDevice_id("1234567890");
		request.setAndroid_id("12345");
		
		LoginDriverResponse resp = taxi.login(request);
		
		System.out.println(resp.getData());
	}
	
	@Ignore
	@Test
	public void testUpdateOrderStatus() throws Exception{
		OrderStatusRequest request = new OrderStatusRequest();
		request.setDriver_id("D123");
		request.setOrder_id("O123");
		request.setReal_price(new BigDecimal("150000"));
		request.setStatus("A");
		
		StringResponse resp = taxi.updateOrderStatus(request);
		
		System.out.println(resp.getData());
	}

	@Ignore
	@Test
	public void testSaveUpdateOrderStatus() throws Exception{
		RegistrationTokenRequest request = new RegistrationTokenRequest();
		request.setDevice_id("D123");
		request.setAndroid_id("O123");
		request.setReg_token("ABC123");
		
		StringResponse resp = taxi.save_gcm_registration_token(request);
		
		System.out.println(resp.getData());
	}
	
	@Test
	public void testGetNewOrders() throws Exception{
		taxi.getNewOrders(false);
	}
}
