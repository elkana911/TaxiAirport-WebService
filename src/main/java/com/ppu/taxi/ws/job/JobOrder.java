package com.ppu.taxi.ws.job;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ppu.taxi.ws.service.ITaxiDriverService;
import com.ppu.taxi.ws.service.response.OrderNewResponse;
import com.ppu.taxi.ws.util.Utils;

@Component
public class JobOrder {

	@Autowired ITaxiDriverService taxiDriver;
	
	@Scheduled(fixedRate=10000)
	public void work(){
		
		OrderNewResponse newOrders = taxiDriver.getNewOrders(true);

		if (newOrders.getData() != null && newOrders.getData().size() > 0){
			System.out.println("new orders " + new Date());
			Utils.print(newOrders.getData());
		}
	}
}
