package com.ppu.taxi.ws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppu.taxi.ws.BO.ITaxiBO;
import com.ppu.taxi.ws.service.ITaxiService;
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

@Service("taxiService")
public class TaxiServiceImpl implements ITaxiService {

	@Autowired ITaxiBO taxiBO;

	@Override
	public NearbyPassengersResponse getNearbyPassengers(NearbyPassengersRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public TaxiRequestByDriverPhoneResponse getTaxiRequestByDriverPhone(TaxiRequestByDriverPhoneRequest request) {
		TaxiRequestByDriverPhoneResponse resp = null;
		try {
			resp = taxiBO.getTaxiRequestByDriverPhone(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	@Transactional
	@Override
	public NearbyTaxiDriversResponse getNearbyTaxiDrivers(NearbyTaxiDriversRequest request) {
		NearbyTaxiDriversResponse resp = null;
		try {
			resp = taxiBO.getNearbyTaxiDrivers(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@Transactional
	@Override
	public TaxiRequestByPhoneResponse getTaxiRequestByPhone(TaxiRequestByPhoneRequest request) {
		TaxiRequestByPhoneResponse resp = null;
		try {
			resp = taxiBO.getTaxiRequestByPhone(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@Transactional
	@Override
	public StringResponse deleteTaxiRequestByPhone(TaxiRequestByDriverPhoneRequest request) {
		StringResponse resp = null;
		try {
			resp = taxiBO.deleteTaxiRequestByPhone(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}

	@Transactional
	@Override
	public RequestTaxiResponse requestTaxi(RequestTaxiRequest request) {
		RequestTaxiResponse resp = null;
		try {
			resp = taxiBO.requestTaxi(request);
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

	@Transactional
	@Override
	public LoginPassengerResponse login(LoginRequest loginRequest) {
		LoginPassengerResponse resp = null;
		try{
			resp = taxiBO.login(loginRequest);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resp;
	}

	@Transactional
	@Override
	public SignUpPassengerResponse signUpPassenger(SignUpPassengerRequest request) {
		SignUpPassengerResponse resp = null;
		try {
			resp = taxiBO.signUpPassenger(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resp;
	}

	@Transactional
	@Override
	public StringResponse isPnrExists(CheckPnrExistsRequest request) {
		StringResponse resp = null;
		try{
			resp = taxiBO.isPnrExists(request);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return resp;
	}

	@Transactional
	@Override
	public StringResponse addOrder(OrderRequest request) {
		StringResponse resp = null;
		try{
			resp = taxiBO.addOrder(request);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return resp;
	}

	@Transactional
	@Override
	public PickupLocationResponse pickup_loc() {
		PickupLocationResponse resp = null;
		try{
			resp = taxiBO.getPickupLocations();
		}catch (Exception e){
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
	public BigDecimalResponse getEstimatePrice(EstimatePriceRequest request) {
		BigDecimalResponse resp = null;
		try{
			resp = taxiBO.getEstimatePrice(request);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return resp;
	}

	@Transactional
	@Override
	public StringResponse setUpdateOrderStatus(OrderStatusRequest request) {
		StringResponse resp = null;
		try{
			resp = taxiBO.setUpdateOrderStatus(request);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return resp;
	}

	@Transactional
	@Override
	public StringResponse setUpdateRegId(UpdateRegRequest request) {
		StringResponse resp = null;
		try{
			resp = taxiBO.setUpdateRegId(request);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return resp;
	}

}
