package com.ppu.taxi.ws.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppu.taxi.ws.gcm.PushNotification;
import com.ppu.taxi.ws.service.IHelloService;
import com.ppu.taxi.ws.service.request.TestPushNotificationRequest;
import com.ppu.taxi.ws.service.response.HelloWebResponse;
import com.ppu.taxi.ws.service.response.StringResponse;
import com.ppu.taxi.ws.util.Utils;

@Service("helloService")
@Transactional
public class HelloServiceImpl implements IHelloService {
    private static Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

	@Override
	public HelloWebResponse hello(String name) {
		HelloWebResponse helloWebResponse = new HelloWebResponse();
		
		helloWebResponse.setData("Hello " + name);
		helloWebResponse.setError(null);
		helloWebResponse.setIp(Utils.getClientIP());
		
		return helloWebResponse;
	}

	@Override
	public HelloWebResponse hello() {
		HelloWebResponse helloWebResponse = new HelloWebResponse();
		
		helloWebResponse.setData("Hello World");
		helloWebResponse.setError(null);
		helloWebResponse.setIp(Utils.getClientIP());
		
		return helloWebResponse;
	}

	@Override
	public StringResponse testPushNotification(TestPushNotificationRequest request) {
		StringResponse resp = new StringResponse();

		resp.setIp(Utils.getClientIP());
		try {
			if (Utils.isEmpty(request.getMsg()))
				request.setMsg("Hi, This is a test message for passenger");
			if (Utils.isEmpty(request.getId()))
				request.setMsg("ftd14KpyW3U:APA91bE64TMJupgzYI8j6_ZM2iDd8_7IMVRpZAyVBkG-jYbFkYqvv-unAB4fOnbsySUrPW7N6coVcDP8UDptrryyzBX7MmZnHL-DybNGact4Vi3sacGDWdYmBg8ngwBrYbYaFWusLFr-");
			
			boolean ret = PushNotification.sendMessage(PushNotification.PASSENGER_SENDER_ID, request.getId(), request.getMsg());

			resp.setData("message " + (ret ? "" : "not ") + "sent");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}


}
