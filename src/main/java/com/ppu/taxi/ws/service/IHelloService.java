package com.ppu.taxi.ws.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.ppu.taxi.ws.service.request.TestPushNotificationRequest;
import com.ppu.taxi.ws.service.response.HelloWebResponse;
import com.ppu.taxi.ws.service.response.StringResponse;

@Path("/hello")
@Produces({ "application/xml", "application/json" })
public interface IHelloService {
	@GET
	@Path("/{name}")
	public HelloWebResponse hello(@PathParam("name") String name);

	@GET
	@Path("/world")
	public HelloWebResponse hello();

	/*
	 * http://203.128.70.66:6060/taxi-ws/hello/testPushNotification.json
	 {"id":"ftd14KpyW3U:APA91bE64TMJupgzYI8j6_ZM2iDd8_7IMVRpZAyVBkG-jYbFkYqvv-unAB4fOnbsySUrPW7N6coVcDP8UDptrryyzBX7MmZnHL-DybNGact4Vi3sacGDWdYmBg8ngwBrYbYaFWusLFr-"
	  ,"msg":"Anda dapat order baru"
	  }
	 */
	@POST
	@Path("/testPushNotification")
	public StringResponse testPushNotification(TestPushNotificationRequest request);

}
