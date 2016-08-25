package com.ppu.taxi.ws.BO;

import com.ppu.taxi.ws.service.request.NearbyTaxiRequestsRequest;
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

public interface ITaxiDriverBO {

	NearbyTaxiRequestsResponse getNearbyTaxiRequests(NearbyTaxiRequestsRequest request);
	TaxiRequestByOrderResponse getTaxiRequestByOrderId(TaxiRequestByOrderRequest request);

	PickupPassengerByPhoneResponse pickupPassengerByPhone(PickupPassengerByPhoneRequest request);

	LoginDriverResponse login(LoginDriverRequest loginRequest);
	SignUpDriverResponse signUpDriver(String phone, String imei);

	StringResponse registerDevice(RegisterDeviceRequest request);
	StringResponse checkIn(CheckInRequest request);
	OrderHistoryResponse getOrderHistory(OrderHistoryRequest request);
	QueueInfoResponse getQueueInfo(QueueInfoRequest request);
	StringResponse updateOrderStatus(OrderStatusRequest request);
	StringResponse save_gcm_registration_token(RegistrationTokenRequest request);
	OrderNewResponse getNewOrders(Boolean notifyDriver);

}
