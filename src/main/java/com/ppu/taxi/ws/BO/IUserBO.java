package com.ppu.taxi.ws.BO;

import com.ppu.taxi.ws.service.response.LoginWebResponse;
import com.ppu.taxi.ws.service.response.TokenWebResponse;

public interface IUserBO {
	LoginWebResponse getLoginInfo(String username, String password);
	TokenWebResponse checkToken(String token, String ip);
	TokenWebResponse generateToken(String ip);
}
