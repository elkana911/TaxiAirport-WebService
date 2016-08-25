package com.ppu.taxi.ws.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.ppu.taxi.ws.service.response.LoginWebResponse;

@Path("/user")
@Produces({ "application/xml", "application/json" })
public interface IUserService {

	@GET
	@Path("/login")
	public LoginWebResponse getUser(@QueryParam("user") String username, @QueryParam("pass") String password);
}
