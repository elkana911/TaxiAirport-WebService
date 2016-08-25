package com.ppu.taxi.ws.BO;

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
import com.ppu.taxi.ws.service.response.NearbyTaxiDriversResponse;
import com.ppu.taxi.ws.service.response.OrderHistoryResponse;
import com.ppu.taxi.ws.service.response.PickupLocationResponse;
import com.ppu.taxi.ws.service.response.RequestTaxiResponse;
import com.ppu.taxi.ws.service.response.StringResponse;
import com.ppu.taxi.ws.service.response.TaxiRequestByDriverPhoneResponse;
import com.ppu.taxi.ws.service.response.TaxiRequestByPhoneResponse;
import com.ppu.taxi.ws.service.response.pnr.LoginPassengerResponse;
import com.ppu.taxi.ws.service.response.pnr.SignUpPassengerResponse;

public interface ITaxiBO {

	NearbyTaxiDriversResponse getNearbyTaxiDrivers(NearbyTaxiDriversRequest request);

	TaxiRequestByPhoneResponse getTaxiRequestByPhone(TaxiRequestByPhoneRequest request);

	TaxiRequestByDriverPhoneResponse getTaxiRequestByDriverPhone(TaxiRequestByDriverPhoneRequest request);

	StringResponse deleteTaxiRequestByPhone(TaxiRequestByDriverPhoneRequest request);

	RequestTaxiResponse requestTaxi(RequestTaxiRequest request);

	SignUpPassengerResponse signUpPassenger(SignUpPassengerRequest request);

	StringResponse registerDevice(RegisterDeviceRequest request);

	LoginPassengerResponse login(LoginRequest loginRequest);

	StringResponse isPnrExists(CheckPnrExistsRequest request);

	StringResponse addOrder(OrderRequest request);

	PickupLocationResponse getPickupLocations();

	OrderHistoryResponse getOrderHistory(OrderHistoryRequest request);

	BigDecimalResponse getEstimatePrice(EstimatePriceRequest request);

	StringResponse setUpdateOrderStatus(OrderStatusRequest request);

	StringResponse setUpdateRegId(UpdateRegRequest request);


}
