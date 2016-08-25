package com.ppu.taxi.ws.gcm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Message.Builder;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;

public class PushNotification {

	// change this if development account has changed
	public static final String DRIVER_SENDER_ID = "AIzaSyBsc1nCHzmYM01ZeS1dg9DqfP4axcc2WkU";	// api keynya eric halim
//	public static final String PASSENGER_SENDER_ID = "AIzaSyBHQuW9n9SK8X8q2OkZmnzGdJgMS0RJz4o";	// api keynya didik
	public static final String PASSENGER_SENDER_ID = "AIzaSyBAplwlkk4UropcagM46uVqGPNSKJqFUwM";	// api keynya didik per 5 april 2016
	
	public static boolean sendMessage(String SENDER_ID, List<String> deviceKeyList, HashMap<String, String> msgList){
		String collapseKey = "CollapseKey";
		Sender sender = new Sender(SENDER_ID);
		Builder messageBuilder = new Message.Builder()
						.collapseKey(collapseKey)
						.timeToLive(30)
						.delayWhileIdle(true);
		
//						.addData("message", msg)
//						.build();
	  for(Map.Entry m: msgList.entrySet()){  
//		   System.out.println(m.getKey()+" "+m.getValue());
		  messageBuilder = messageBuilder.addData((String)m.getKey(), (String)m.getValue());
	  }  
	  
		boolean success = false;
		try {
			
			MulticastResult result = sender.send(messageBuilder.build(), deviceKeyList, 1);
			
			if (result.getResults() != null){
				int canonicalRegId = result.getCanonicalIds();
				if (canonicalRegId != 0){
					
				}
				success = true;
				
				System.out.println("Broadcast success. canonicalRegId=" + canonicalRegId);
				
			}else{
				int error = result.getFailure();
				System.out.println("Broadcast failure " + error);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
		
	}
	
	public static boolean sendMessage(String SENDER_ID, List<String> deviceKeyList, String msg){
		String collapseKey = "CollapseKey";
		Sender sender = new Sender(SENDER_ID);
		Builder messageBuilder = new Message.Builder()
						.collapseKey(collapseKey)
						.timeToLive(30)
						.delayWhileIdle(true)
						.addData("message", msg);
//						.build();
		
		boolean success = false;
		try {
			
			MulticastResult result = sender.send(messageBuilder.build(), deviceKeyList, 1);
			
			if (result.getResults() != null){
				int canonicalRegId = result.getCanonicalIds();
				if (canonicalRegId != 0){
					
				}
				success = true;
				
				System.out.println("Broadcast success. canonicalRegId=" + canonicalRegId);
				
			}else{
				int error = result.getFailure();
				System.out.println("Broadcast failure " + error);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	public static boolean sendMessage(String SENDER_ID, String deviceKeyTarget, String msg){

		List<String> androidTargets = new ArrayList<String>();
		
//		androidTargets.add("ftd14KpyW3U:APA91bE64TMJupgzYI8j6_ZM2iDd8_7IMVRpZAyVBkG-jYbFkYqvv-unAB4fOnbsySUrPW7N6coVcDP8UDptrryyzBX7MmZnHL-DybNGact4Vi3sacGDWdYmBg8ngwBrYbYaFWusLFr-");
		androidTargets.add(deviceKeyTarget);
		
		return sendMessage(SENDER_ID, androidTargets, msg); 
	}
	
	public static boolean sendMessage(String SENDER_ID, String deviceKeyTarget, HashMap<String, String> msg){
		
		List<String> androidTargets = new ArrayList<String>();
		
//		androidTargets.add("ftd14KpyW3U:APA91bE64TMJupgzYI8j6_ZM2iDd8_7IMVRpZAyVBkG-jYbFkYqvv-unAB4fOnbsySUrPW7N6coVcDP8UDptrryyzBX7MmZnHL-DybNGact4Vi3sacGDWdYmBg8ngwBrYbYaFWusLFr-");
		androidTargets.add(deviceKeyTarget);
		
		return sendMessage(SENDER_ID, androidTargets, msg); 
	}
}
