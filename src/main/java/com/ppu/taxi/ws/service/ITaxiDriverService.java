package com.ppu.taxi.ws.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.ppu.taxi.ws.service.request.NearbyTaxiRequestsRequest;
import com.ppu.taxi.ws.service.request.NotifyDriverRequest;
import com.ppu.taxi.ws.service.request.PickupPassengerByPhoneRequest;
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
import com.ppu.taxi.ws.service.response.OrderNewResponse;
import com.ppu.taxi.ws.service.response.PickupPassengerByPhoneResponse;
import com.ppu.taxi.ws.service.response.StringResponse;
import com.ppu.taxi.ws.service.response.TaxiRequestByOrderResponse;
import com.ppu.taxi.ws.service.response.driver.LoginDriverResponse;
import com.ppu.taxi.ws.service.response.driver.QueueInfoResponse;
import com.ppu.taxi.ws.service.response.driver.SignUpDriverResponse;

/**
 * Process Flow di Client:
 * onCreate -> get current GPS
 * onStart -> getTaxiRequestByDriverPhone(driverPhone)
 * 
 * Driver Actions:
 * getNearbyTaxiRequests
 * 
 * Passenger Actions:
 * requestTaxi
 * getTaxiRequestByPhone
 * getNearbyTaxiDrivers
 * deleteTaxiRequestByPhone utk cancel
 * 
 * @author Eric
 *
 */

@Path("/taxi-drv")
@Produces({ "application/xml", "application/json" })
public interface ITaxiDriverService {
	
	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-drv/sign_in.json
	 {"device_id": "ABC123", "android_id": "ABC123"}
	 */
	@POST
	@Path("/sign_in")
	public LoginDriverResponse login(LoginDriverRequest loginRequest);
	
	@POST
	@Path("/signup_driver")
	public SignUpDriverResponse signUpDriver(@QueryParam("phone") String phone
			, @QueryParam("imei") String imei);

	
	/**
	 * http://203.128.70.66:6060/taxi-ws/taxi-drv/getNearbyTaxiRequests.json
	 * {"coordinate":{"lat": "-6.129388", "lng":"106.655492"}}
	 * mencari penumpang sekitar yg sedang request taxi
	 */
	@POST
	@Path("/getNearbyTaxiRequests")
	public NearbyTaxiRequestsResponse getNearbyTaxiRequests(NearbyTaxiRequestsRequest request);

	/**
	 * http://203.128.70.66:6060/taxi-ws/taxi-drv/getTaxiRequestByOrderId.json
	 * {"order_id":"O123"}
	 * mencari penumpang berdasar nomor pesanan
	 */
	@POST
	@Path("/getTaxiRequestByOrderId")
	public TaxiRequestByOrderResponse getTaxiRequestByOrderId(TaxiRequestByOrderRequest request);

	/**
	 * http://203.128.70.66:6060/taxi-drv-ws/pickupPassengerByPhone.json
	 * Ada datanya jika passenger sudah menunjuk suatu driver, jadi linked by phonenumber
	 * @param request
	 * @return
	 */	
	@POST
	@Path("/pickupPassengerByPhone")
	public PickupPassengerByPhoneResponse pickupPassengerByPhone(PickupPassengerByPhoneRequest request);

	@POST
	@Path("/registerDevice")
	public StringResponse registerDevice(RegisterDeviceRequest request);

	/**
	 * http://203.128.70.66:6060/taxi-ws/taxi-drv/notifyDriver.json
	 {"id":"ftd14KpyW3U:APA91bE64TMJupgzYI8j6_ZM2iDd8_7IMVRpZAyVBkG-jYbFkYqvv-unAB4fOnbsySUrPW7N6coVcDP8UDptrryyzBX7MmZnHL-DybNGact4Vi3sacGDWdYmBg8ngwBrYbYaFWusLFr-"
	  ,"order_id":"O123"
	  ,"coordinate":{"lat": "-6.129388", "lng":"106.655492"}
	  ,"message":"Anda dapat order baru"
	  }
	 */
	@POST
	@Path("/notifyDriver")
	public StringResponse notifyDriver(NotifyDriverRequest request);

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-drv/checkIn.json
	 {"driver_id":"ABC123"
	  ,"coordinate":{"lat": "-6.129388", "lng":"106.655492"}
	  }
	 */
	@POST
	@Path("/checkIn")
	public StringResponse checkIn(CheckInRequest request);

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-drv/get_order_hist.json
	 {"driver_id":"ABC123"}
	 */
	@POST
	@Path("/get_order_hist")
	public OrderHistoryResponse getOrderHistory(OrderHistoryRequest request);

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-drv/get_queue_info.json
	 {"driver_id":"ABC123"}
	 */
	@POST
	@Path("/get_queue_info")
	public QueueInfoResponse getQueueInfo(QueueInfoRequest request);

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-drv/update_order_status.json
	 {"order_id":"ABC123",
	 "status":"A",
	 "driver_id":"ABC123",
	 "real_price":"150000"
	 }
	 */
	@POST
	@Path("/update_order_status")
	public StringResponse updateOrderStatus(OrderStatusRequest request);
	
	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-drv/save_gcm_registration_token.json
	 {"device_id":"ABC123",
	 "android_id":"ABC123",
	 "reg_token":"ABC123"
	 }
	 */
	@POST
	@Path("/save_gcm_registration_token")
	public StringResponse save_gcm_registration_token(RegistrationTokenRequest request);
	
	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-drv/get_new_orders.json
	 */
	@GET
	@Path("/get_new_orders")
	public OrderNewResponse getNewOrders(@QueryParam("notifyDriver") Boolean notifyDriver);


}
