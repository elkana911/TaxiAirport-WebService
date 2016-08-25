package com.ppu.taxi.ws.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppu.taxi.ws.BO.ITaxiDriverBO;
import com.ppu.taxi.ws.gcm.PushNotification;
import com.ppu.taxi.ws.service.ITaxiDriverService;
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
import com.ppu.taxi.ws.util.Utils;

@Service("taxiDriverService")
public class TaxiDriverServiceImpl implements ITaxiDriverService{
	@Autowired ITaxiDriverBO taxiBO;

	@Transactional
	@Override
	public SignUpDriverResponse signUpDriver(String phone, String imei) {
		SignUpDriverResponse resp = null;
		try {
			resp = taxiBO.signUpDriver(phone, imei);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resp;
	}
	
	@Transactional
	@Override
	public NearbyTaxiRequestsResponse getNearbyTaxiRequests(NearbyTaxiRequestsRequest request) {
		NearbyTaxiRequestsResponse resp = null;
		try {
			resp = taxiBO.getNearbyTaxiRequests(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	@Transactional
	@Override
	public TaxiRequestByOrderResponse getTaxiRequestByOrderId(TaxiRequestByOrderRequest request) {
		TaxiRequestByOrderResponse resp = null;
		try {
			resp = taxiBO.getTaxiRequestByOrderId(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@Transactional
	@Override
	public PickupPassengerByPhoneResponse pickupPassengerByPhone(PickupPassengerByPhoneRequest request) {
		PickupPassengerByPhoneResponse resp = null;
		try {
			resp = taxiBO.pickupPassengerByPhone(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	@Transactional
	@Override
	public StringResponse registerDevice(RegisterDeviceRequest request) {
		StringResponse resp = null;
		try {
			resp = taxiBO.registerDevice(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@Override
	public StringResponse notifyDriver(NotifyDriverRequest request) {
		StringResponse resp = new StringResponse();

		resp.setIp(Utils.getClientIP());
		try {
			
			HashMap<String, String> msgList = new HashMap<String, String>();
			msgList.put("id", request.getId());
			msgList.put("order_id", request.getOrder_id());
			if (request.getCoordinate() != null){
				msgList.put("lat", request.getCoordinate().getLatitude());
				msgList.put("lng", request.getCoordinate().getLongitude());
			}
			msgList.put("message", request.getMessage());
			
			//logic push notification harusnya taruh di BO ? see TaxiBOImpl#addOrder
			boolean ret = PushNotification.sendMessage(PushNotification.DRIVER_SENDER_ID, request.getId(), msgList);
			
			resp.setData("message " + (ret ? "" : "not ") + "sent");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@Transactional
	@Override
	public StringResponse checkIn(CheckInRequest request) {
		StringResponse resp = null;
		try {
			resp = taxiBO.checkIn(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@Transactional
	@Override
	public OrderHistoryResponse getOrderHistory(OrderHistoryRequest request) {
		OrderHistoryResponse resp = null;
		try{
			resp = taxiBO.getOrderHistory(request);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return resp;
	}

	@Transactional
	@Override
	public QueueInfoResponse getQueueInfo(QueueInfoRequest request) {
		QueueInfoResponse resp = null;
		try{
			resp = taxiBO.getQueueInfo(request);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return resp;
	}

	@Transactional
	@Override
	public LoginDriverResponse login(LoginDriverRequest loginRequest) {
		LoginDriverResponse resp = null;
		try {
			resp = taxiBO.login(loginRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resp;
	}

	@Transactional
	@Override
	public StringResponse updateOrderStatus(OrderStatusRequest request) {
		StringResponse resp = null;
		try {
			resp = taxiBO.updateOrderStatus(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@Transactional
	@Override
	public StringResponse save_gcm_registration_token(RegistrationTokenRequest request) {
		StringResponse resp = null;
		try {
			resp = taxiBO.save_gcm_registration_token(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@Transactional
	@Override
	public OrderNewResponse getNewOrders(Boolean notifyDriver) {
		OrderNewResponse resp = null;
		try {
			resp = taxiBO.getNewOrders(notifyDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

}
