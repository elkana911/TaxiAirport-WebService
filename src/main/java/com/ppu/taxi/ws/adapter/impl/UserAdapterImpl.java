package com.ppu.taxi.ws.adapter.impl;

import org.springframework.stereotype.Component;

import com.ppu.taxi.ws.adapter.IUserAdapter;
import com.ppu.taxi.ws.service.response.LoginInfo;
import com.ppu.taxi.ws.service.response.LoginWebResponse;
import com.ppu.taxi.ws.service.response.TokenWebResponse;
import com.ppu.taxi.ws.util.Utils;

@Component("userAdapter")
public class UserAdapterImpl implements IUserAdapter {

	@Override
	public LoginWebResponse convertToLoginWebResponse(LoginInfo data) {
		LoginWebResponse response = new LoginWebResponse();
		response.setIp(Utils.getClientIP());
		
		response.setData(data);
		
		return response;
	}

	@Override
	public TokenWebResponse convertToTokenWebResponse(String data) {
		TokenWebResponse response = new TokenWebResponse();
		
		response.setIp(Utils.getClientIP());
		response.setData(data);
		
		return response;
	}

}
