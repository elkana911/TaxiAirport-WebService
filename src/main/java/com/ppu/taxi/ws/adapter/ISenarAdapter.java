package com.ppu.taxi.ws.adapter;

import com.ppu.taxi.ws.service.response.StringResponse;

public interface ISenarAdapter {

	StringResponse convertToStringResponse(String data);

//	PositionResponse convertToPositionResponse(List<Position> list);

}
