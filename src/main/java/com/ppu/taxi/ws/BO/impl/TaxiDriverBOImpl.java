package com.ppu.taxi.ws.BO.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ppu.taxi.ws.BO.ITaxiDriverBO;
import com.ppu.taxi.ws.DAO.ITaxiDriverDao;
import com.ppu.taxi.ws.common.ErrorName;
import com.ppu.taxi.ws.domain.NotificationGit;
import com.ppu.taxi.ws.domain.TRX_ORDER;
import com.ppu.taxi.ws.domain.driver.MstDeviceDriver;
import com.ppu.taxi.ws.domain.driver.MstUserDriver;
import com.ppu.taxi.ws.gcm.PushNotification;
import com.ppu.taxi.ws.pojo.QueueInfo;
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
import com.ppu.taxi.ws.service.response.ErrorResponse;
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

// tolong handle error disini

@Component("taxiDriverBO")
public class TaxiDriverBOImpl implements ITaxiDriverBO {

	@Autowired ITaxiDriverDao taxiDriverDao;

	protected ErrorResponse getErrorResponse(ErrorName errorCode) {
		ErrorResponse error = new ErrorResponse();
		
		error.setErrorCode(errorCode.getErrorCode());
		error.setErrorName(errorCode.getErrorName());
		error.setErrorDesc(errorCode.getErrorDesc());
		
		return error;
	}
	
	protected ErrorResponse getErrorResponse(ErrorName errorCode, String customMessage) {
		ErrorResponse error = new ErrorResponse();
		
		error.setErrorCode(errorCode.getErrorCode());
		error.setErrorName(errorCode.getErrorName());
		error.setErrorDesc(errorCode.getErrorDesc());
		
		return error;
	}

	@Override
	public NearbyTaxiRequestsResponse getNearbyTaxiRequests(NearbyTaxiRequestsRequest request) {
		NearbyTaxiRequestsResponse resp = new NearbyTaxiRequestsResponse();
		resp.setIp(Utils.getClientIP());
		
		List<TRX_ORDER> list = null;
		try {
			list = taxiDriverDao.getNearbyTaxiRequests(request.getCoordinate());

			resp.setData(list);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof GenericJDBCException){
				SQLException se = (SQLException)e.getCause();
				int errorCode = se.getErrorCode();
				String msg = se.getMessage();
				
				ErrorResponse errorResponse = getErrorResponse(ErrorName.DATABASE_ERROR);
				errorResponse.setErrorDesc(msg);
				errorResponse.setErrorCode(errorCode);
				resp.setError(errorResponse);
			}else
				resp.setError(getErrorResponse(ErrorName.FUNCTION_ERROR));
		}
		
		return resp;
	}


	@Override
	public TaxiRequestByOrderResponse getTaxiRequestByOrderId(TaxiRequestByOrderRequest request) {
		TaxiRequestByOrderResponse resp = new TaxiRequestByOrderResponse();
		resp.setIp(Utils.getClientIP());
		
		List<TRX_ORDER> data = null;
		try {
			data = taxiDriverDao.getTaxiRequestByOrderId(request.getOrder_id());

			resp.setData(data);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof GenericJDBCException){
				SQLException se = (SQLException)e.getCause();
				int errorCode = se.getErrorCode();
				String msg = se.getMessage();
				
				ErrorResponse errorResponse = getErrorResponse(ErrorName.DATABASE_ERROR);
				errorResponse.setErrorDesc(msg);
				errorResponse.setErrorCode(errorCode);
				resp.setError(errorResponse);
			}else
				resp.setError(getErrorResponse(ErrorName.FUNCTION_ERROR));
		}
		
		return resp;

	}

	@Override
	public PickupPassengerByPhoneResponse pickupPassengerByPhone(PickupPassengerByPhoneRequest request) {
		PickupPassengerByPhoneResponse response = new PickupPassengerByPhoneResponse();
		
		response.setIp(Utils.getClientIP());
		try {
			boolean b = taxiDriverDao.pickupPassengerByPhone(request.getPassengerPhone(), request.getDriverPhone());
			
			
			response.setData( b ? "success" : "failed");
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof GenericJDBCException){
				SQLException se = (SQLException)e.getCause();
				int errorCode = se.getErrorCode();
				String msg = se.getMessage();
				
				ErrorResponse errorResponse = getErrorResponse(ErrorName.DATABASE_ERROR);
				errorResponse.setErrorDesc(msg);
				errorResponse.setErrorCode(errorCode);
				response.setError(errorResponse);
			}else
				response.setError(getErrorResponse(ErrorName.FUNCTION_ERROR));
		}
		
		return response;
	}

	@Override
	public SignUpDriverResponse signUpDriver(String phone, String imei) {
		SignUpDriverResponse resp = new SignUpDriverResponse();
		resp.setIp(Utils.getClientIP());
		
		if (Utils.isEmpty(phone) && Utils.isEmpty(imei)){
			resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			
			return resp;
		}else{
			
			MstUserDriver mstUser = null;
			
			mstUser = taxiDriverDao.signUpDriver(phone, imei);

			if (mstUser != null){
				resp.setData(mstUser);
			}else{
				resp.setError(getErrorResponse(ErrorName.DATA_NOTPROCESSED));
			}
		}
		
		return resp;
	}

	@Override
	public StringResponse registerDevice(RegisterDeviceRequest request) {
		StringResponse resp = new StringResponse();
		resp.setIp(Utils.getClientIP());
		
		if (Utils.isEmpty(request.getId()) && Utils.isEmpty(request.getImei())){
			resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			
			return resp;
		}else{
			
			MstDeviceDriver mstDeviceDriver = null;

			try {
				mstDeviceDriver = taxiDriverDao.registerDevice(request.getId(), request.getImei(), request.getEmail());

				if (mstDeviceDriver != null){
					resp.setData("ok");
				}else{
					resp.setError(getErrorResponse(ErrorName.DATA_DUPLICATE));
				}

			} catch (Exception e) {
				e.printStackTrace();
				if (e instanceof GenericJDBCException){
					SQLException se = (SQLException)e.getCause();
					int errorCode = se.getErrorCode();
					String msg = se.getMessage();
					
					ErrorResponse errorResponse = getErrorResponse(ErrorName.DATABASE_ERROR);
					errorResponse.setErrorDesc(msg);
					errorResponse.setErrorCode(errorCode);
					resp.setError(errorResponse);
				}else
					resp.setError(getErrorResponse(ErrorName.FUNCTION_ERROR));
			}
			
		}
		
		return resp;

	}

	@Override
	public StringResponse checkIn(CheckInRequest request) {
		StringResponse resp = new StringResponse();
		resp.setIp(Utils.getClientIP());
		
		if (Utils.isEmpty(request.getDriver_id())){
			resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			
			return resp;
		}else{
			
			try {
				String ret = taxiDriverDao.checkIn(request.getDriver_id(), request.getCoordinate());
				resp.setData(ret);

			} catch (Exception e) {
				e.printStackTrace();
				if (e instanceof GenericJDBCException){
					SQLException se = (SQLException)e.getCause();
					int errorCode = se.getErrorCode();
					String msg = se.getMessage();
					
					ErrorResponse errorResponse = getErrorResponse(ErrorName.DATABASE_ERROR);
					errorResponse.setErrorDesc(msg);
					errorResponse.setErrorCode(errorCode);
					resp.setError(errorResponse);
				}else
					resp.setError(getErrorResponse(ErrorName.FUNCTION_ERROR));
			}
			
		}
		
		return resp;
	}

	@Override
	public OrderHistoryResponse getOrderHistory(OrderHistoryRequest request) {
		OrderHistoryResponse resp = new OrderHistoryResponse();
		resp.setIp(Utils.getClientIP());
		
		List<TRX_ORDER> list = null;
		try {
			
			list = taxiDriverDao.getOrderHistory(request.getDriver_id());

			resp.setData(list);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof GenericJDBCException){
				SQLException se = (SQLException)e.getCause();
				int errorCode = se.getErrorCode();
				String msg = se.getMessage();
				
				ErrorResponse errorResponse = getErrorResponse(ErrorName.DATABASE_ERROR);
				errorResponse.setErrorDesc(msg);
				errorResponse.setErrorCode(errorCode);
				resp.setError(errorResponse);
			}else
				resp.setError(getErrorResponse(ErrorName.FUNCTION_ERROR));
		}
		
		return resp;
	}

	@Override
	public QueueInfoResponse getQueueInfo(QueueInfoRequest request) {
		QueueInfoResponse resp = new QueueInfoResponse();
		resp.setIp(Utils.getClientIP());
		
		QueueInfo data;
		try {
			
			data = taxiDriverDao.getQueueInfo(request.getDriver_id());

			resp.setData(data);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof GenericJDBCException){
				SQLException se = (SQLException)e.getCause();
				int errorCode = se.getErrorCode();
				String msg = se.getMessage();
				
				ErrorResponse errorResponse = getErrorResponse(ErrorName.DATABASE_ERROR);
				errorResponse.setErrorDesc(msg);
				errorResponse.setErrorCode(errorCode);
				resp.setError(errorResponse);
			}else
				resp.setError(getErrorResponse(ErrorName.FUNCTION_ERROR));
		}
		
		return resp;
	}

	@Override
	public LoginDriverResponse login(LoginDriverRequest loginRequest) {
		LoginDriverResponse resp = new LoginDriverResponse();
		resp.setIp(Utils.getClientIP());
		
		if (Utils.isEmpty(loginRequest.getDevice_id()) && Utils.isEmpty(loginRequest.getAndroid_id())){
			resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			
			return resp;
		}else{
			
			MstUserDriver mstUser = null;
			
			mstUser = taxiDriverDao.login(loginRequest.getDevice_id(), loginRequest.getAndroid_id());

			if (mstUser != null){
				resp.setData(mstUser);
			}else{
				resp.setError(getErrorResponse(ErrorName.DATA_NOTFOUND));
			}
		}
		
		return resp;
	}

	@Override
	public StringResponse updateOrderStatus(OrderStatusRequest request) {
		StringResponse resp = new StringResponse();
		resp.setIp(Utils.getClientIP());

		try {
			if (Utils.isEmpty(request.getOrder_id())){
				resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			}else{
				taxiDriverDao.updateOrderStatus(request.getOrder_id(), request.getStatus(), request.getDriver_id(), request.getReal_price());

				resp.setData("ok");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof GenericJDBCException){
				SQLException se = (SQLException)e.getCause();
				int errorCode = se.getErrorCode();
				String msg = se.getMessage();
				
				ErrorResponse errorResponse = getErrorResponse(ErrorName.DATABASE_ERROR);
				errorResponse.setErrorDesc(msg);
				errorResponse.setErrorCode(errorCode);
				resp.setError(errorResponse);
			}else
				resp.setError(getErrorResponse(ErrorName.FUNCTION_ERROR));
		}
		
		return resp;
	}

	@Override
	public StringResponse save_gcm_registration_token(RegistrationTokenRequest request) {
		StringResponse resp = new StringResponse();
		resp.setIp(Utils.getClientIP());

		try {
			if (Utils.isEmpty(request.getDevice_id())){
				resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			}else{
				taxiDriverDao.save_gcm_registration_token(request.getDevice_id(), request.getAndroid_id(), request.getReg_token());

				resp.setData("ok");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof GenericJDBCException){
				SQLException se = (SQLException)e.getCause();
				int errorCode = se.getErrorCode();
				String msg = se.getMessage();
				
				ErrorResponse errorResponse = getErrorResponse(ErrorName.DATABASE_ERROR);
				errorResponse.setErrorDesc(msg);
				errorResponse.setErrorCode(errorCode);
				resp.setError(errorResponse);
			}else
				resp.setError(getErrorResponse(ErrorName.FUNCTION_ERROR));
		}
		
		return resp;
	}

	@Override
	public OrderNewResponse getNewOrders(Boolean notifyDriver) {
		OrderNewResponse resp = new OrderNewResponse();
		resp.setIp(Utils.getClientIP());

		try {

			List<NotificationGit> newOrders = taxiDriverDao.getNewOrders();

			if (notifyDriver && newOrders != null && newOrders.size() > 0){
				System.out.println("notify to drivers (" + newOrders.size() + ") at " + new Date());

				for (NotificationGit item : newOrders){

					HashMap<String, String> msg2Driver = new HashMap<String, String>();
//					msg2Driver.put("id", item.getDriver_reg_id());
					msg2Driver.put("order_id", item.getOrder_id());
					msg2Driver.put("message", "New Order !");
					
					boolean ret = PushNotification.sendMessage(PushNotification.DRIVER_SENDER_ID, item.getDriver_reg_id(), msg2Driver);
					
					System.out.println("message new order " + (ret ? "" : "NOT ") + "sent to driver:" + item.getDriver_name());
					
					if (ret){
						//notify passenger
						HashMap<String, String> msg2Customer = new HashMap<String, String>();
//						msg2Customer.put("id", item.getCust_reg_id());
//						msg2Customer.put("order_id", item.getOrder_id());
						msg2Customer.put("message", "Your Order accepted ! Driver: " + item.getDriver_name() + "(Taxi No.: " + item.getVehicle_id() + ")");
						
						boolean retCustomer = PushNotification.sendMessage(PushNotification.PASSENGER_SENDER_ID, item.getCust_reg_id(), msg2Customer);
						
						System.out.println("message new order " + (retCustomer ? "" : "NOT ") + "sent to customer:" + item.getCust_name());
					}

				}
				
				/*
				List<String> deviceKeyList = new ArrayList<String>();
				for (NotificationGit item : newOrders){
					deviceKeyList.add(item.getDriver_reg_id());
				}
				
				PushNotification.sendMessage(deviceKeyList, "New Passenger");
				*/
			}
			
			resp.setData(newOrders);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof GenericJDBCException){
				SQLException se = (SQLException)e.getCause();
				int errorCode = se.getErrorCode();
				String msg = se.getMessage();
				
				ErrorResponse errorResponse = getErrorResponse(ErrorName.DATABASE_ERROR);
				errorResponse.setErrorDesc(msg);
				errorResponse.setErrorCode(errorCode);
				resp.setError(errorResponse);
			}else
				resp.setError(getErrorResponse(ErrorName.FUNCTION_ERROR));
		}
		
		return resp;
	}


}
