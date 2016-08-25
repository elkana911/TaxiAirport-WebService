package com.eric.ws.test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

import com.ning.http.util.Base64;

/**
 * Must use json 20140107 because compatible with jdk7
 * @author Eric
 *
 */
public class Main {
	private static final String WS_URL = "http://localhost:8090/taxi";
//	private static final String WS_URL = "http://203.128.70.66:6060/taxi-ws/taxi";
    private static final int CONNECTION_TIMEOUT = 180000;
    private static final int DATARETRIEVAL_TIMEOUT = 180000;
    private static final String WS_USER = "taxi_driver";
    private static final String WS_PWD = "12taxi3";

    public static JSONObject requestWebService(String url, Map<String,Object> par) {

        HttpURLConnection urlConnection = null;

        try {

            //Get parameters
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String,Object> param : par.entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            // create connection
            URL urlToRequest = new URL(WS_URL + url);
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();

            //authenticate
            byte[] auth = (WS_USER + ":" + WS_PWD).getBytes();
            String basic = Base64.encode(auth);
//            String basic = Base64.encodeToString(auth, Base64.NO_WRAP);
            urlConnection.setRequestProperty("Authorization", "Basic " + basic);

            //properties
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            urlConnection.setRequestProperty("Accept", "application/json");
//            urlConnection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            urlConnection.setDoOutput(true);
            
            
            urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            urlConnection.setReadTimeout(DATARETRIEVAL_TIMEOUT);

            JSONObject cred = new JSONObject();
            cred.put("usr", "eric");
            cred.put("pwd", "elkana");

            
            urlConnection.getOutputStream().write(cred.toString().getBytes());
            urlConnection.getOutputStream().flush();
            // handle issues
            int statusCode = urlConnection.getResponseCode();

            if (statusCode == HttpURLConnection.HTTP_OK){
                // create JSON object from content
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                System.out.println("hasil json: " + new JSONObject(getResponseText(in)).toString());
                return new JSONObject(getResponseText(in));
            }
            else{
                throw new Exception("Error Status Code: " + statusCode);
            }


        } catch (MalformedURLException e) {
            // URL is invalid

        } catch (SocketTimeoutException e) {
            // data retrieval or connection timed out
        } catch (IOException e) {
            // could not read response body
            // (could not create input stream)
        } catch (JSONException e) {
            // response body is no valid JSON string
        } catch (Exception e) {
        }

        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return null;
    }

    private static String getResponseText(InputStream inStream) {
        // very nice trick from
        // http://weblogs.java.net/blog/pat/archive/2004/10/stupid_scanner_1.html
        return new Scanner(inStream).useDelimiter("\\A").next();
    }
    
    public static JSONObject sendObject(String url, JSONObject data) {
    	
    	HttpURLConnection urlConnection = null;
    	
    	try {
    		
    		// create connection
    		URL urlToRequest = new URL(url);
    		urlConnection = (HttpURLConnection) urlToRequest.openConnection();
    		
    		//authenticate
    		byte[] auth = (WS_USER + ":" + WS_PWD).getBytes();
    		String basic = Base64.encode(auth);
    		urlConnection.setRequestProperty("Authorization", "Basic " + basic);
    		urlConnection.setRequestProperty("Accept", "application/json");
    		//properties
    		urlConnection.setRequestMethod("POST");
    		urlConnection.setRequestProperty("Content-Type", "application/json");
    		urlConnection.setDoInput(true);
    		urlConnection.setDoOutput(true);

    		if (data != null){
    			OutputStream os = urlConnection.getOutputStream();
    			os.write(data.toString().getBytes("UTF-8"));
    			os.close();
    		}
    		
    		// handle issues
    		int statusCode = urlConnection.getResponseCode();
    		
    		if (statusCode == HttpURLConnection.HTTP_OK){
    			// create JSON object from content
    			InputStream in = new BufferedInputStream(urlConnection.getInputStream());
    			
    			System.out.println("hasil json: " + new JSONObject(getResponseText(in)).toString());
    			return new JSONObject(getResponseText(in));
    		}
    		else{
    			throw new Exception("Error Status Code: " + statusCode);
    		}
    		
    	} catch (Exception e) {
    	}
    	
    	finally {
    		if (urlConnection != null) {
    			urlConnection.disconnect();
    		}
    	}
    	
    	return null;
    }

    
    public static void tesLogin(){
        JSONObject cred = new JSONObject();
        cred.put("email", "eric.pramudya@gmail.com");
        cred.put("pwd", "test");
        
//		sendObject("http://localhost:8090/senar/login.json");
		sendObject("http://203.128.70.66:6060/senar-ws/senar/login.json", cred);
    	
    }
    public static void tesGetPos(){
    	JSONObject cred = new JSONObject();
    	cred.put("user_id", "eric123");
    	
//		sendObject("http://localhost:8090/senar/login.json");
//    	sendObject("http://203.128.70.66:6060/senar-ws/senar/login.json", cred);
//    	sendObject("http://localhost:8090/senar/getpos.json", cred);
    	sendObject("http://203.128.70.66:6060/senar-drv-ws/senar/getpos.json", cred);
    	
    }
    
    public static void testGetMapPoints(){
    	sendObject("http://203.128.70.66:6060/senar-ws/senar/getmappoints.json", null);
    	
//    	{"error":null,"data":[{"created_by":null,"created_date":null,"updated_date":null,"seq_no":1,"parking_id":"MAG001","updated_by":null,"longitude":"106.893498","latitude":"-6.145029"},{"created_by":null,"created_date":null,"updated_date":null,"seq_no":2,"parking_id":"MAG001","updated_by":null,"longitude":"106.893557","latitude":"-6.145063"},{"created_by":null,"created_date":null,"updated_date":null,"seq_no":3,"parking_id":"MAG001","updated_by":null,"longitude":"106.891756","latitude":"-6.148361"},{"created_by":null,"created_date":null,"updated_date":null,"seq_no":4,"parking_id":"MAG001","updated_by":null,"longitude":"106.891688","latitude":"-6.148335"},{"created_by":null,"created_date":null,"updated_date":null,"seq_no":5,"parking_id":"MAG001","updated_by":null,"longitude":"106.893498","latitude":"-6.145029"}],"ip":"202.152.33.46"}

    }
    
    
	public static void main(String[] args) {
		System.out.println("Hello world");
		
//		tesLogin();
//		tesGetPos();
//		testGetMapPoints();
//		testGetParkingLot();
//		testGetAvailLot();
		
		testRegisterDevice();
		
//		http://203.128.70.66:6060/senar-ws/senar/getmappoints.json
	}

	private static void testGetParkingLot() {
    	sendObject("http://203.128.70.66:6060/senar-ws/senar/getparkinglot.json", null);
	}

	private static void testRegisterDevice() {
    	JSONObject cred = new JSONObject();
    	cred.put("id", "MAG001");
    	
    	sendObject(WS_URL + "/registerDevice.json", cred);
	}

}
