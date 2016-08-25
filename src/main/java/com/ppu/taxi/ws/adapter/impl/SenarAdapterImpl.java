package com.ppu.taxi.ws.adapter.impl;

import org.springframework.stereotype.Component;

import com.ppu.taxi.ws.adapter.ISenarAdapter;
import com.ppu.taxi.ws.service.response.StringResponse;
import com.ppu.taxi.ws.util.Utils;

@Component("senarAdapter")
public class SenarAdapterImpl implements ISenarAdapter {

	@Override
	public StringResponse convertToStringResponse(String data) {
		StringResponse response = new StringResponse();
		
		response.setIp(Utils.getClientIP());
		
		response.setData(data);
		
		return response;
	}
//
//	@Override
//	public PositionResponse convertToPositionResponse(List<Position> list) {
//		PositionResponse resp = new PositionResponse();
//		resp.setIp(Utils.getClientIP());
//		resp.setData(list);
//				
//		return resp;
//	}

}
