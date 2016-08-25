package com.ppu.taxi.ws.BO.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ppu.taxi.ws.BO.ITaxiBO;
import com.ppu.taxi.ws.DAO.ITaxiDao;
import com.ppu.taxi.ws.common.ErrorName;
import com.ppu.taxi.ws.domain.MstParam;
import com.ppu.taxi.ws.domain.TRX_ORDER;
import com.ppu.taxi.ws.domain.driver.MstDeviceDriver;
import com.ppu.taxi.ws.domain.pnr.MstUserPassenger;
import com.ppu.taxi.ws.pojo.Coordinate;
import com.ppu.taxi.ws.service.request.CheckPnrExistsRequest;
import com.ppu.taxi.ws.service.request.EstimatePriceRequest;
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
import com.ppu.taxi.ws.service.response.ErrorResponse;
import com.ppu.taxi.ws.service.response.NearbyTaxiDriversResponse;
import com.ppu.taxi.ws.service.response.OrderHistoryResponse;
import com.ppu.taxi.ws.service.response.PickupLocationResponse;
import com.ppu.taxi.ws.service.response.RequestTaxiResponse;
import com.ppu.taxi.ws.service.response.StringResponse;
import com.ppu.taxi.ws.service.response.TaxiRequestByDriverPhoneResponse;
import com.ppu.taxi.ws.service.response.TaxiRequestByPhoneResponse;
import com.ppu.taxi.ws.service.response.pnr.LoginPassengerResponse;
import com.ppu.taxi.ws.service.response.pnr.SignUpPassengerResponse;
import com.ppu.taxi.ws.util.Utils;

// tolong handle error disini

@Component("taxiBO")
public class TaxiBOImpl implements ITaxiBO {

	@Autowired ITaxiDao taxiDao;

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
	public NearbyTaxiDriversResponse getNearbyTaxiDrivers(NearbyTaxiDriversRequest request) {
		NearbyTaxiDriversResponse resp = new NearbyTaxiDriversResponse();
		resp.setIp(Utils.getClientIP());
		
		List<TRX_ORDER> list = null;
		try {
			list = taxiDao.getNearbyTaxiDrivers(request.getCoordinate());

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
	public TaxiRequestByPhoneResponse getTaxiRequestByPhone(TaxiRequestByPhoneRequest request) {
		TaxiRequestByPhoneResponse resp = new TaxiRequestByPhoneResponse();
		resp.setIp(Utils.getClientIP());
		
		List<TRX_ORDER> list = null;
		try {
			list = taxiDao.getTaxiRequestByPhone(request.getPhone());

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
	public TaxiRequestByDriverPhoneResponse getTaxiRequestByDriverPhone(TaxiRequestByDriverPhoneRequest request) {
		TaxiRequestByDriverPhoneResponse resp = new TaxiRequestByDriverPhoneResponse();
		resp.setIp(Utils.getClientIP());
		
		List<TRX_ORDER> list = null;
		try {
			list = taxiDao.getTaxiRequestByDriverPhone(request.getPhone());

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
	public StringResponse deleteTaxiRequestByPhone(TaxiRequestByDriverPhoneRequest request) {
		StringResponse response = new StringResponse();
		
		response.setIp(Utils.getClientIP());
		try {
			response.setData(taxiDao.deleteTaxiRequestByPhone(request.getPhone()) ? "success" : "failed");
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
	public RequestTaxiResponse requestTaxi(RequestTaxiRequest request) {
		RequestTaxiResponse resp = new RequestTaxiResponse();
		resp.setIp(Utils.getClientIP());
		
		List<TRX_ORDER> list = null;
		try {
			
			Coordinate coordinate = new Coordinate();
			coordinate.setLatitude(request.getLatitude());
			coordinate.setLongitude(request.getLongitude());
			
			list = taxiDao.requestTaxi(coordinate, request.getAddress(), request.getPassengerPhone());

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
	public SignUpPassengerResponse signUpPassenger(SignUpPassengerRequest request) {
		
		SignUpPassengerResponse resp = new SignUpPassengerResponse();
		resp.setIp(Utils.getClientIP());

		try {
			
			MstUserPassenger mstUser = null;
			
			String datePattern = "dd-MM-yyyy";
			mstUser = taxiDao.signUpPassenger(request.getEmail(), request.getName(), request.getPwd(), request.getPhone()
					, request.getDeviceId(), request.getGender()
					, Utils.String2Date(request.getBirthDate(),datePattern) , request.getLocation(), request.getStatus()
					, request.getRegId(), request.getFacebookId(), request.getGoogleId());
			
			if (mstUser != null){
				resp.setData(mstUser);
			}else{
				resp.setError(getErrorResponse(ErrorName.DATA_NOTPROCESSED));
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
	public StringResponse registerDevice(RegisterDeviceRequest request) {
		StringResponse resp = new StringResponse();
		resp.setIp(Utils.getClientIP());
		
		if (Utils.isEmpty(request.getId()) && Utils.isEmpty(request.getImei())){
			resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			
			return resp;
		}else{
			
			MstDeviceDriver mstDeviceDriver = null;

			try {
				mstDeviceDriver = taxiDao.registerDevice(request.getId(), request.getImei(), request.getEmail());

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
	public LoginPassengerResponse login(LoginRequest loginRequest) {
		// validate here
		
		LoginPassengerResponse resp = new LoginPassengerResponse();
		resp.setIp(Utils.getClientIP());
		
		if (Utils.isEmpty(loginRequest.getEmail())){
			resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			
			return resp;
		}else{
			MstUserPassenger mstUser = null;
			mstUser = taxiDao.login(loginRequest.getEmail(), loginRequest.getPassword());
		
			if (mstUser != null){
				resp.setData(mstUser);
			}else{
				resp.setError(getErrorResponse(ErrorName.UNAUTHORIZED_LOGIN));
			}
		}
		
		return resp;
	}

	@Override
	public StringResponse isPnrExists(CheckPnrExistsRequest request) {
		StringResponse resp = new StringResponse();
		resp.setIp(Utils.getClientIP());
		
		if (Utils.isEmpty(request.getEmail())){
			resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			
			return resp;
		}else{

			boolean ret = taxiDao.isPnrExists(request.getEmail());

			if (ret){
				resp.setData("ok");
			}else{
				resp.setError(getErrorResponse(ErrorName.DATA_NOTFOUND));
			}

		}
		
		return resp;
	}

	@Override
	public StringResponse addOrder(OrderRequest request) {
		StringResponse resp = new StringResponse();
		resp.setIp(Utils.getClientIP());

			try {
				String datePattern = "dd-MM-yyyy";
				taxiDao.addOrder(Utils.String2Date(request.getAcquired_date(), datePattern), request.getCancel_by()
						, Utils.String2Date(request.getCancel_date(), datePattern), request.getCust_id()
						, Utils.String2Date(request.getDelivered_date(), datePattern), request.getDistance(), request.getDriver_id(), request.getDrop_lat(), request.getDrop_loc(), request.getDrop_lon(), request.getEst_price_high(), request.getEst_price_low()
						, Utils.String2Date(request.getOrder_date(), "dd-MM-yyyy HH:mm"), request.getOrder_name(), request.getOrder_phone()
						, Utils.String2Date(request.getPick_date(), "dd-MM-yyyy HH:mm"), 
						request.getPick_lat(), request.getPick_loc(), request.getPick_lon(), request.getReal_price(), request.getStatus(), request.getUrgency(),
						request.getPayment_type());

				resp.setData("ok");
				
				//a background job should notify drivers
				
				/*
				String deviceKeyPassenger = "";
				HashMap<String, String> msgList = new HashMap<String, String>();
				msgList.put("id", request.getId());
				msgList.put("order_id", request.getOrder_id());

				PushNotification.sendMessage(deviceKeyPassenger, msgList);
				*/
				//notify driver / or just call
				/*
http://203.128.70.66:6060/taxi-ws/taxi-drv/notifyDriver.json				 
				String deviceKeyDriver = "";
				PushNotification.sendMessage(deviceKeyDriver , msgList);
				 */
				
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
	public PickupLocationResponse getPickupLocations() {
		PickupLocationResponse resp = new PickupLocationResponse();
		resp.setIp(Utils.getClientIP());
		
		List<MstParam> list = null;
			try {
				list = taxiDao.getPickupLocations();

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
	public OrderHistoryResponse getOrderHistory(OrderHistoryRequest request) {
		OrderHistoryResponse resp = new OrderHistoryResponse();
		resp.setIp(Utils.getClientIP());
		
		List<TRX_ORDER> list = null;
		try {
			
			list = taxiDao.getOrderHistory(request.getCustomer_id());

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
	public BigDecimalResponse getEstimatePrice(EstimatePriceRequest request) {
		BigDecimalResponse resp = new BigDecimalResponse();
		resp.setIp(Utils.getClientIP());
		
		if (request.getDistance() == null){
			resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			
			return resp;
		}else{
			
			BigDecimal price = null;

			try {
				price = taxiDao.getEstimatePrice(request.getDistance());

				if (price != null){
					resp.setData(price);
				}else{
					resp.setError(getErrorResponse(ErrorName.DATABASE_ERROR));
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
	public StringResponse setUpdateOrderStatus(OrderStatusRequest request) {
		// TODO Auto-generated method stub		
		StringResponse resp = new StringResponse();
		resp.setIp(Utils.getClientIP());

		try {
			if (Utils.isEmpty(request.getOrder_id())){
				resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			}else{
				taxiDao.setUpdateOrderStatus(request.getOrder_id(), request.getStatus());

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
	public StringResponse setUpdateRegId(UpdateRegRequest request) {
		// TODO Auto-generated method stub		
		StringResponse resp = new StringResponse();
		resp.setIp(Utils.getClientIP());

		try {
			if (Utils.isEmpty(request.getP_cust_id())){
				resp.setError(getErrorResponse(ErrorName.INPUT_MISSING));		
			}else{
				taxiDao.setUpdateRegId(request.getP_cust_id(), request.getP_reg_id());

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


}
