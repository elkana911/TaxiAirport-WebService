package com.ppu.taxi.ws.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.ppu.taxi.ws.service.request.CheckPnrExistsRequest;
import com.ppu.taxi.ws.service.request.EstimatePriceRequest;
import com.ppu.taxi.ws.service.request.NearbyPassengersRequest;
import com.ppu.taxi.ws.service.request.NearbyTaxiDriversRequest;
import com.ppu.taxi.ws.service.request.RegisterDeviceRequest;
import com.ppu.taxi.ws.service.request.RequestTaxiRequest;
import com.ppu.taxi.ws.service.request.SignUpPassengerRequest;
import com.ppu.taxi.ws.service.request.TaxiRequestByDriverPhoneRequest;
import com.ppu.taxi.ws.service.request.TaxiRequestByPhoneRequest;
import com.ppu.taxi.ws.service.request.pnr.LoginRequest;
import com.ppu.taxi.ws.service.request.pnr.OrderHistoryRequest;
import com.ppu.taxi.ws.service.request.pnr.OrderRequest;
import com.ppu.taxi.ws.service.request.pnr.OrderStatusRequest;
import com.ppu.taxi.ws.service.request.pnr.UpdateRegRequest;
import com.ppu.taxi.ws.service.response.BigDecimalResponse;
import com.ppu.taxi.ws.service.response.NearbyPassengersResponse;
import com.ppu.taxi.ws.service.response.NearbyTaxiDriversResponse;
import com.ppu.taxi.ws.service.response.OrderHistoryResponse;
import com.ppu.taxi.ws.service.response.PickupLocationResponse;
import com.ppu.taxi.ws.service.response.RequestTaxiResponse;
import com.ppu.taxi.ws.service.response.StringResponse;
import com.ppu.taxi.ws.service.response.TaxiRequestByDriverPhoneResponse;
import com.ppu.taxi.ws.service.response.TaxiRequestByPhoneResponse;
import com.ppu.taxi.ws.service.response.pnr.LoginPassengerResponse;
import com.ppu.taxi.ws.service.response.pnr.SignUpPassengerResponse;

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

@Path("/taxi-pnr")
@Produces({ "application/xml", "application/json" })
public interface ITaxiService {

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-pnr/sign_in.json
	 {"email": "didik@ppu.co.id", "pwd": "password123"}
	 or
	 {"id": "didik123", "pwd": "password123"}
	 */
	@POST
	@Path("/sign_in")
	public LoginPassengerResponse login(LoginRequest loginRequest);

	/**
	 * last update 17 mar 2016 11:00
	 http://203.128.70.66:6060/taxi-ws/taxi-pnr/sign_up.json
	 {"name": "eric", "pwd":"passwordabc", "email":"eric@ppu.co.id", "phone": "021-343423423", "deviceId":"123ABC", "gender":"male", "birthDate":"22-11-2015", "location":"semarang", "status":"active",
	 "regId": "abc123", "facebookId": "abc123", "googleId":"abc123"}
	 */
	@POST
	@Path("/sign_up")
	public SignUpPassengerResponse signUpPassenger(SignUpPassengerRequest request);

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-pnr/getNearbyTaxiDrivers.json
	 {"coordinate":{"lat": "-6.129388", "lng":"106.655492"}}
	 */
	@POST
	@Path("/getNearbyTaxiDrivers")
	public NearbyTaxiDriversResponse getNearbyTaxiDrivers(NearbyTaxiDriversRequest request);


	//	getNearbyPassenger krn ga mungkin konek terus menerus, hanya bisa cek 5 menit terakhir yg akses app ?
	
	/**
	 * http://203.128.70.66:6060/taxi-drv-ws/getNearbyPassengers.json
	 * mencari penumpang yg sedang buka aplikasi
	 */
	@POST
	@Path("/getNearbyPassengers")
	public NearbyPassengersResponse getNearbyPassengers(NearbyPassengersRequest request);

	
	@POST
	@Path("/getTaxiRequestByPhone")
	public TaxiRequestByPhoneResponse getTaxiRequestByPhone(TaxiRequestByPhoneRequest request);
	
	/**
	 * http://203.128.70.66:6060/taxi-drv-ws/getTaxiRequestByDriverPhone.json
	 * Ada datanya jika no telp supir taxi direquest oleh passenger
	 * @param request
	 * @return
	 */
	@POST
	@Path("/getTaxiRequestByDriverPhone")
	public TaxiRequestByDriverPhoneResponse getTaxiRequestByDriverPhone(TaxiRequestByDriverPhoneRequest request);
	
	/**
	 * Passenger cancel request.
	 * @param request
	 * @return
	 */
	@POST
	@Path("/deleteTaxiRequestByPhone")
	public StringResponse deleteTaxiRequestByPhone(TaxiRequestByDriverPhoneRequest request);
	
	@POST
	@Path("/requestTaxi")
	public RequestTaxiResponse requestTaxi(RequestTaxiRequest request);
	
	@POST
	@Path("/registerDevice")
	public StringResponse registerDevice(RegisterDeviceRequest request);

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-pnr/check_exists.json
	 {"email":"didik@ppu.co.id"}
	 * @param request
	 * @return
	 */
	@POST
	@Path("/check_exists")
	public StringResponse isPnrExists(CheckPnrExistsRequest request);

	/**
	 last update 17 mar 2016 11:50
	 http://203.128.70.66:6060/taxi-ws/taxi-pnr/add_order.json
	 {"cust_id":"ABC123", "driver_id":"ABC123", "pick_loc":"Mall Summarecon", "drop_loc":"Artha Gading", "urgency":"high", "status":"Available", "est_price_low":"12000", "est_price_high":"20000", "real_price":"16500"
	 , "order_date":"22-12-2015", "acquired_date":"22-12-2015", "cancel_date": "null", "delivered_date":"22-12-2015", "cancel_by":"driver", "distance":"1452.23", "pick_date":"22-12-2015", "order_name":"something", "order_phone":"08473834343"
	 , "pick_lat":"23.243434", "pick_lon":"-44.13510", "drop_lat": "33.13101", "drop_lon":"-31.03344"
	 , "payment_type": "CASH" 
	 }
	 * @param request
	 * @return
	 */
	@POST
	@Path("/add_order")
	public StringResponse addOrder(OrderRequest request);

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-pnr/get_pickup_loc.json
	 */
	@POST
	@Path("/get_pickup_loc")
	public PickupLocationResponse pickup_loc();

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-pnr/get_order_hist.json
	 {"customer_id":"ABC123"}
	 */
	@POST
	@Path("/get_order_hist")
	public OrderHistoryResponse getOrderHistory(OrderHistoryRequest request);

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-pnr/get_estimate_price.json
	 {"distance":"1200"}
	 */
	@POST
	@Path("get_estimate_price")
	public BigDecimalResponse getEstimatePrice(EstimatePriceRequest request);

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-pnr/set_update_order_status.json
	 {"order_id":"ABC123",
	  "status":"A"
	 }
	 */
	@POST
	@Path("set_update_order_status")
	public StringResponse setUpdateOrderStatus(OrderStatusRequest request);

	/**
	 http://203.128.70.66:6060/taxi-ws/taxi-pnr/update_reg_id.json
	 {"p_cust_id":"ABC123",
	  "p_reg_id":"ABC123"
	 }
	 */
	@POST
	@Path("update_reg_id")
	public StringResponse setUpdateRegId(UpdateRegRequest request);
}
