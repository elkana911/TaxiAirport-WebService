package com.ppu.taxi.ws.adapter;

import com.ppu.taxi.ws.service.response.LoginInfo;
import com.ppu.taxi.ws.service.response.LoginWebResponse;
import com.ppu.taxi.ws.service.response.TokenWebResponse;

public interface IUserAdapter {

	LoginWebResponse convertToLoginWebResponse(LoginInfo data);
	TokenWebResponse convertToTokenWebResponse(String data);

}
