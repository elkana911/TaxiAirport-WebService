# BigWS - CONTRACT LAST. using Apache CXF to expose REST and SOAP web services

https://github.com/metallicatony/EmployeeWebApp
http://metallicatony.blogspot.co.id/2013/11/crud-services-restsoap-using-java.html

TEAMVIEWER Oracle 12c:
221940797/@dmin@dmin
taksi/devtaksi1

logic based on taxiapp:
http://oparowski.github.io/taxicab/

push notification:
projectid:1017878451982
https://console.developers.google.com/home/dashboard?project=1017878451982
tutorial: http://avilyne.com/?p=267

user/pwd: taxi_driver/12taxi3
http://203.128.70.66:6060/taxi-ws/taxi/signup_driver.json
http://203.128.70.66:6060/taxi-ws/taxi/registerDevice.json
	id="ftd14KpyW3U:APA91bE64TMJ...."
	email="yourmail@mail.com"
	imei="ABC123"
http://203.128.70.66:6060/taxi-ws/taxi/testPushNotification.json
	
```
H2U:
http://localhost:8090/flight/b2c/scrap/schedule.json?airlineCode=JT&ori=CGK&dest=BTH&dateDepart=24/10/2015&adt=1&chd=0&inf=0
```

$.ajax({
			type : "GET",
			url : 'http://192.168.1.103:8080/BigEngine-XmlJson-Server/flights/getFlights.json',
			dataType : "json",
			data:{
				username : 'admin',
				password : 'admin',
			},
			contentType: "application/json; charset=utf-8",
			success : processSuccess,
			error : processError
		});

```
import org.json.JSONException;
import org.json.JSONObject;
import com.ning.http.util.Base64;
   public static JSONObject sendObject() {
    	HttpURLConnection urlConnection = null;
    	try {    		
    		// create connection
    		URL urlToRequest = new URL("http://localhost:8090/senar/login.json");
    		
    		urlConnection = (HttpURLConnection) urlToRequest.openConnection();
    		
    		//authenticate
    		byte[] auth = ("admin" + ":" + "admin").getBytes();
    		String basic = Base64.encode(auth);
    		urlConnection.setRequestProperty("Authorization", "Basic " + basic);
    		urlConnection.setRequestProperty("Accept", "application/json");
    		//properties
    		urlConnection.setRequestMethod("POST");
    		urlConnection.setRequestProperty("Content-Type", "application/json");
    		urlConnection.setDoInput(true);
    		urlConnection.setDoOutput(true);
    		
            JSONObject cred = new JSONObject();
            cred.put("email", "eric@gmail.com");
            cred.put("pwd", "elkana");

            OutputStream os = urlConnection.getOutputStream();
            os.write(cred.toString().getBytes("UTF-8"));
            os.close();
    		
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
```



jika menggunakan chrome selama debug, jangan lupa gunakan setting --disable-web-security

response:
"{"error":null,"ip":"192.168.1.102","flightWebResponse":[{"flightdetid":"1e1a2e95-8377-42f1-9b8f-7b6bdd8243f1","flightnum":"ID 6580","origin":"CGK","destination":"SUB","dep_time":1414673100000,"arr_time":1414678500000,"promo_rate":"Habis Terjual","economi_rate":"Habis Terjual","bisnis_rate":"1143700","transitId":null,"airline":"Batik Air","isTransit":"0","departure":"CGK","arrival":"SUB","currency":null,"basic_rate":0,"iwjr":0,"pajak":0,"surcharge_fee":0,"tambahan":0,"biaya_admin":0,"basic_rate_eco":850000,"pajak_eco":91700,"surcharge_fee_eco":67000,"tambahan_eco":0,"biaya_admin_eco":10000,"basic_bisnis":0,"pajak_bisnis":0,"surcharge_bisnis":0,"tambahan_bisnis":0,"admin_bisnis":10000,"ins_serv_fee_promo":null,"fuel_serv_promo":null,"ins_serv_fee_eco":null,"fuel_serv_eco":null,"ins_serv_bis":null,"fuel_serv_bis":null,"originDescription":"Soekarno Hatta Intl, Jakarta","destDescription":"Juanda, Surabaya","departureDescription":"Soekarno Hatta Intl, Jakarta","arrivalDescription":"Juanda, Surabaya","secondFlight":null,"transitCount":0,"lastUpdate":1414594434000},{"flightdetid":"eff55eb2-a858-4984-8d1f-4b313b97ab44","flightnum":"JT 590","origin":"CGK","destination":"SUB","dep_time":1414676700000,"arr_time":1414682100000,"promo_rate":"Habis Terjual","economi_rate":"Habis Terjual","bisnis_rate":"N/A","transitId":null,"airline":"Lion Air","isTransit":"0","departure":"CGK","arrival":"SUB","currency":null,"basic_rate":0,"iwjr":25000,"pajak":0,"surcharge_fee":0,"tambahan":0,"biaya_admin":10000,"basic_rate_eco":0,"pajak_eco":0,"surcharge_fee_eco":0,"tambahan_eco":0,"biaya_admin_eco":0,"basic_bisnis":0,"pajak_bisnis":0,"surcharge_bisnis":0,"tambahan_bisnis":0,"admin_bisnis":0,"ins_serv_fee_promo":null,"fuel_serv_promo":null,"ins_serv_fee_eco":null,"fuel_serv_eco":null,"ins_serv_bis":null,"fuel_serv_bis":null,"originDescription":"Soekarno Hatta Intl, Jakarta","destDescription":"Juanda, Surabaya","departureDescription":"Soekarno Hatta Intl, Jakarta","arrivalDescription":"Juanda, Surabaya","secondFlight":null,"transitCount":0,"lastUpdate":1414594434000},{"flightdetid":"ed45bff7-0093-48fc-afe9-bc18f0c111ec","flightnum":"ID 6584","origin":"CGK","destination":"SUB","dep_time":1414681800000,"arr_time":1414687200000,"promo_rate":" 582700","economi_rate":" 670700","bisnis_rate":"1143700","transitId":null,"airline":"Batik Air","isTransit":"0","departure":"CGK","arrival":"SUB","currency":null,"basic_rate":0,"iwjr":0,"pajak":0,"surcharge_fee":0,"tambahan":0,"biaya_admin":0,"basic_rate_eco":0,"pajak_eco":0,"surcharge_fee_eco":0,"tambahan_eco":0,"biaya_admin_eco":0,"basic_bisnis":0,"pajak_bisnis":0,"surcharge_bisnis":0,"tambahan_bisnis":0,"admin_bisnis":0,"ins_serv_fee_promo":null,"fuel_serv_promo":null,"ins_serv_fee_eco":null,"fuel_serv_eco":null,"ins_serv_bis":null,"fuel_serv_bis":null,"originDescription":"Soekarno Hatta Intl, Jakarta","destDescription":"Juanda, Surabaya","departureDescription":"Soekarno Hatta Intl, Jakarta","arrivalDescription":"Juanda, Surabaya","secondFlight":null,"transitCount":0,"lastUpdate":1414594434000},{"flightdetid":"c314feff-83d7-46fc-abf8-43f47eaa9b66","flightnum":"ID 6587","origin":"SUB","destination":"CGK","dep_time":1414673400000,"arr_time":1414678800000,"promo_rate":" 582700","economi_rate":" 670700","bisnis_rate":"1143700","transitId":null,"airline":"Batik Air","isTransit":"0","departure":"SUB","arrival":"CGK","currency":null,"basic_rate":0,"iwjr":0,"pajak":0,"surcharge_fee":0,"tambahan":0,"biaya_admin":0,"basic_rate_eco":0,"pajak_eco":0,"surcharge_fee_eco":0,"tambahan_eco":0,"biaya_admin_eco":0,"basic_bisnis":0,"pajak_bisnis":0,"surcharge_bisnis":0,"tambahan_bisnis":0,"admin_bisnis":0,"ins_serv_fee_promo":null,"fuel_serv_promo":null,"ins_serv_fee_eco":null,"fuel_serv_eco":null,"ins_serv_bis":null,"fuel_serv_bis":null,"originDescription":"Juanda, Surabaya","destDescription":"Soekarno Hatta Intl, Jakarta","departureDescription":"Juanda, Surabaya","arrivalDescription":"Soekarno Hatta Intl, Jakarta","secondFlight":null,"transitCount":0,"lastUpdate":1414594299000},{"flightdetid":"3b8fb9bd-837d-4277-9f11-951dbbce7f51","flightnum":"ID 6309","origin":"SUB","destination":"CGK","dep_time":1414678200000,"arr_time":1414683600000,"promo_rate":" 582700","economi_rate":" 670700","bisnis_rate":"1143700","transitId":null,"airline":"Batik Air","isTransit":"0","departure":"SUB","arrival":"CGK","currency":null,"basic_rate":0,"iwjr":0,"pajak":0,"surcharge_fee":0,"tambahan":0,"biaya_admin":0,"basic_rate_eco":0,"pajak_eco":0,"surcharge_fee_eco":0,"tambahan_eco":0,"biaya_admin_eco":0,"basic_bisnis":0,"pajak_bisnis":0,"surcharge_bisnis":0,"tambahan_bisnis":0,"admin_bisnis":0,"ins_serv_fee_promo":null,"fuel_serv_promo":null,"ins_serv_fee_eco":null,"fuel_serv_eco":null,"ins_serv_bis":null,"fuel_serv_bis":null,"originDescription":"Juanda, Surabaya","destDescription":"Soekarno Hatta Intl, Jakarta","departureDescription":"Juanda, Surabaya","arrivalDescription":"Soekarno Hatta Intl, Jakarta","secondFlight":null,"transitCount":0,"lastUpdate":1414594299000},{"flightdetid":"60097bc9-a965-43b2-a7d7-c3cb4727dc4b","flightnum":"JT 595","origin":"SUB","destination":"CGK","dep_time":1414679400000,"arr_time":1414684800000,"promo_rate":"Habis Terjual","economi_rate":"Habis Terjual","bisnis_rate":"N/A","transitId":null,"airline":"Lion Air","isTransit":"0","departure":"SUB","arrival":"CGK","currency":null,"basic_rate":0,"iwjr":0,"pajak":0,"surcharge_fee":0,"tambahan":0,"biaya_admin":0,"basic_rate_eco":0,"pajak_eco":0,"surcharge_fee_eco":0,"tambahan_eco":0,"biaya_admin_eco":0,"basic_bisnis":0,"pajak_bisnis":0,"surcharge_bisnis":0,"tambahan_bisnis":0,"admin_bisnis":0,"ins_serv_fee_promo":null,"fuel_serv_promo":null,"ins_serv_fee_eco":null,"fuel_serv_eco":null,"ins_serv_bis":null,"fuel_serv_bis":null,"originDescription":"Juanda, Surabaya","destDescription":"Soekarno Hatta Intl, Jakarta","departureDescription":"Juanda, Surabaya","arrivalDescription":"Soekarno Hatta Intl, Jakarta","secondFlight":null,"transitCount":0,"lastUpdate":1414594299000},{"flightdetid":"3c3520aa-7c80-4234-baec-38f78aeb22d6","flightnum":"ID 6583","origin":"SUB","destination":"CGK","dep_time":1414681200000,"arr_time":1414686600000,"promo_rate":"Habis Terjual","economi_rate":"Habis Terjual","bisnis_rate":"1143700","transitId":null,"airline":"Batik Air","isTransit":"0","departure":"SUB","arrival":"CGK","currency":null,"basic_rate":0,"iwjr":0,"pajak":0,"surcharge_fee":0,"tambahan":0,"biaya_admin":0,"basic_rate_eco":0,"pajak_eco":0,"surcharge_fee_eco":0,"tambahan_eco":0,"biaya_admin_eco":0,"basic_bisnis":0,"pajak_bisnis":0,"surcharge_bisnis":0,"tambahan_bisnis":0,"admin_bisnis":0,"ins_serv_fee_promo":null,"fuel_serv_promo":null,"ins_serv_fee_eco":null,"fuel_serv_eco":null,"ins_serv_bis":null,"fuel_serv_bis":null,"originDescription":"Juanda, Surabaya","destDescription":"Soekarno Hatta Intl, Jakarta","departureDescription":"Juanda, Surabaya","arrivalDescription":"Soekarno Hatta Intl, Jakarta","secondFlight":null,"transitCount":0,"lastUpdate":1414546739000},{"flightdetid":"d9c72b7d-1beb-45df-b556-ccb9852de1b6","flightnum":"JT 821","origin":"SUB","destination":"CGK","dep_time":1414683300000,"arr_time":1414688100000,"promo_rate":" 506200","economi_rate":" 610700","bisnis_rate":"N/A","transitId":null,"airline":"Lion Air","isTransit":"0","departure":"SUB","arrival":"CGK","currency":null,"basic_rate":0,"iwjr":0,"pajak":0,"surcharge_fee":0,"tambahan":0,"biaya_admin":0,"basic_rate_eco":0,"pajak_eco":0,"surcharge_fee_eco":0,"tambahan_eco":0,"biaya_admin_eco":0,"basic_bisnis":0,"pajak_bisnis":0,"surcharge_bisnis":0,"tambahan_bisnis":0,"admin_bisnis":0,"ins_serv_fee_promo":null,"fuel_serv_promo":null,"ins_serv_fee_eco":null,"fuel_serv_eco":null,"ins_serv_bis":null,"fuel_serv_bis":null,"originDescription":"Juanda, Surabaya","destDescription":"Soekarno Hatta Intl, Jakarta","departureDescription":"Juanda, Surabaya","arrivalDescription":"Soekarno Hatta Intl, Jakarta","secondFlight":null,"transitCount":0,"lastUpdate":1414594299000},{"flightdetid":"9589f661-e4c0-4ab0-aa25-4068f12d4920","flightnum":"SJ255","origin":"SUB","destination":"CGK","dep_time":1414674000000,"arr_time":1414678800000,"promo_rate":"477200","economi_rate":"649900","bisnis_rate":"Habis","transitId":null,"airline":"Sriwijaya air","isTransit":"0","departure":"SUB","arrival":"CGK","currency":"IDR       ","basic_rate":452000,"iwjr":5000,"pajak":452000,"surcharge_fee":85000,"tambahan":0,"biaya_admin":0,"basic_rate_eco":509000,"pajak_eco":50900,"surcharge_fee_eco":85000,"tambahan_eco":0,"biaya_admin_eco":0,"basic_bisnis":0,"pajak_bisnis":0,"surcharge_bisnis":0,"tambahan_bisnis":0,"admin_bisnis":0,"ins_serv_fee_promo":0,"fuel_serv_promo":0,"ins_serv_fee_eco":0,"fuel_serv_eco":0,"ins_serv_bis":0,"fuel_serv_bis":0,"originDescription":"Juanda, Surabaya","destDescription":"Soekarno Hatta Intl, Jakarta","departureDescription":"Juanda, Surabaya","arrivalDescription":"Soekarno Hatta Intl, Jakarta","secondFlight":null,"transitCount":0,"lastUpdate":1414593997000}]}"



TO WAR: (cek database.properties first, version in pom.xml)
mvn clean install
TO SKIP TEST:
mvn clean install -Dmaven.test.skip=true
TO TEST:
mvn tomcat7:run	

STEPs to scrap an airline:
1. Always begin from test module


QUESTIONS
jadi sebenernya project ini mengenai web service server json atau soap sih 
	BOTH!
	(JSON)../service/EmployeeService.java
	(SOAP)../service/EmployeeServiceWS.java

class mana dulu yg dilihat pertama kali
	(JSON)../service/EmployeeService.java
	(SOAP)../service/EmployeeServiceWS.java

cara tau service/url jalan ?
.../hello/elkana
.../hello/eric

apa sih beda BO dan DAO ?
BO diakses oleh web service dan DAO bertanggung jawab dengan database.
sehingga membutuhkan konversi, itulah gunanya package ADAPTER


HOW TO import oracle packages ?
1. Use TOAD, Login
2. select Packages
3. select a source, Ctrl+A, menu Edit>Copy, paste into target window, then press F9


referensi

dikarenakan tidak selalu bisa jalan di tomcat eclipse as server, selalu gunakan di pom.xml:
	<plugin>
      <groupId>org.apache.tomcat.maven</groupId>
      <artifactId>tomcat7-maven-plugin</artifactId>
      <version>2.1</version>
                <configuration>
                    <path>/</path>
                    <port>8090</port>
		  </configuration>
    </plugin>
    ...
</plugins>
lalu jalankan maven command prompt: mvn tomcat7:run	

pastikan di log tidak ada masalah dengan koneksi ke database, maka aplikasi akan aktif di localhost:8090	
contoh:
http://localhost:8090/flight/calendar.json	
http://localhost:8090/flight/b2c/scrap/route.json?max=5

DONT DO right click project Run On Server Nor Debug On Server 


PRODUCTION CHECKLIST:
../applicationContext.xml lihat bagian default_schema
edit database.properties




	
