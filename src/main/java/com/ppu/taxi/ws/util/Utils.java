package com.ppu.taxi.ws.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.lucene.spatial.geometry.FloatLatLng;
import org.apache.lucene.spatial.geometry.LatLng;
import org.springframework.util.StringUtils;

public class Utils {
	public static final String TODAY = "today";
	public static final String[] todayWords = { TODAY, "hari ini", "hariini",
			"sekarang" };
	public static final String[] tommorrowWords = { "tommorrow", "besok" };
	
	//must lowercase
	public static final String[] seatClasses = { "o", "u", "x", "e", "g", "v", "t", "q", "n", "m", "l", "k", "h", "b", "w", "s", "y", "i", "d", "c"};

	public static final String TZ_JAKARTA = "Asia/Jakarta";
	public static final String TZ_SINGAPORE = "Asia/Singapore";
	
	public static int countChar(String param){
	     return param.length() - param.replace("(", "").length();     //jadi lbh simple ga perlu pake split/loop2an
	}
	
	public static String getLastWord(String param) {
		return param.substring(param.lastIndexOf(" ")+1);
	}

	/**
	 * 
	 * @return 30/12/2014
	 */
	public static String today() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}
	
	public static String prettyDate(Date date) {
		return new SimpleDateFormat("EEEE, dd MMM yyyy").format(date);
	}
	
	/**
	 * 
	 * @param value
	 * @return true if TODAY, 08/12/2014
	 */
	public static boolean isToday(String value) {
		if (StringUtils.isEmpty(value)) return false;
		
		if (value.equalsIgnoreCase(TODAY) || value.equals(today())) return true;
		return false;
	}

	/**
	 * ada kebutuhan utk pencarian waktu sekarang ditambah 2 jam
	 * @param offsetHours
	 * @param offsetMinutes
	 * @return
	 */
	public static String getCurrentHoursMinutes(int offsetHours, int offsetMinutes) {
		Date oldDate = new Date();
		long newTime = oldDate.getTime() + TimeUnit.HOURS.toMillis(offsetHours) + TimeUnit.MINUTES.toMillis(offsetMinutes);
		
		return new SimpleDateFormat("HH:mm").format(new Date(newTime));
	}
	
	public static Date getTommorrow(Date startFrom) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startFrom);
		cal.add(Calendar.DAY_OF_YEAR, 1); // <--
		return cal.getTime();
	}

	public static void delay(long millis) {
    	try {
    	    Thread.sleep(millis);                 //1000 milliseconds is one second.
    	} catch(InterruptedException ex) {
    	    Thread.currentThread().interrupt();
    	}
		
	}
	
	public static String getBetween(String begin, String end, String value) {
		if (StringUtils.isEmpty(value)) return "";
			
		int startPosition = value.indexOf(begin) + begin.length();  
		int endPosition = value.indexOf(end, startPosition);
		return value.substring(startPosition, endPosition);
	}

	public static String cleanRate(String rate) {
		//clean up first utk menjamin datanya angka (tanpa cent tentunya)
		if (StringUtils.isEmpty(rate)) rate = "0";

		//buang titik di 2.044.900
		rate = rate.trim().replaceAll("\\.", "");;
		
		if (rate.equalsIgnoreCase("n/a") || rate.toLowerCase().indexOf("habis") > -1) rate= "0";

		return rate;
	}

	public static String getClientIP() {
		try {
			Message message = PhaseInterceptorChain.getCurrentMessage();
			HttpServletRequest request = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);

			return request.getRemoteAddr();
		} catch (Exception e) {
//			e.printStackTrace();
			return "0.0.0.0";
		}
	}
	public static boolean isEmpty(String val){
		if (val == null) return true;
		
		if (val.trim().length() < 1) return true;
		
		return org.springframework.util.StringUtils.isEmpty(val);
	}

	public static boolean isEmpty(Object[] val){
		if (val == null) return true;
		
		if (val.length < 1) return true;
		
		return false;
	}

	public static boolean isEmpty(Collection list){
		if (list == null) return true;
		
		if (list.size() < 1) return true;
		
		return false;
	}

	/**
	 * <p>
	 * return empty string if date = null
	 * @param date
	 * @param pattern dd/MM/yyyy
	 * @param timeZoneID GMT, UTC, Asia/Singapore, Asia/Jakarta
	 * @return 
	 */
	public static String Date2String(Date date, String pattern, String timeZoneID) {
        if (date == null)
             return "";
        else{
			SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
			sdf.setTimeZone(TimeZone.getTimeZone(timeZoneID));
        	
			return sdf.format(date);
//        	return new SimpleDateFormat(pattern, Locale.US).format(date);
        }
   }
	
	public static String Date2String(Date date, String pattern) {
        if (date == null)
             return "";
        else{
			SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
        	
			return sdf.format(date);
        }
   }
	/**
	 * 
	 * @param date
	 * @param fromPattern
	 * @param toPattern
	 * @param timeZoneID GMT, UTC, Asia/Singapore, Asia/Jakarta
	 * @return
	 */
	   public static String changeDatePattern(String date, String fromPattern,
	             String toPattern, String timeZoneID) {
	        return Date2String(String2Date(date, fromPattern, timeZoneID), toPattern, timeZoneID);
	   }
	   
	   public static String changeDatePattern(String date, String fromPattern,
	             String toPattern) {
	        return Date2String(String2Date(date, fromPattern), toPattern);
	   }
	   /*
	   public static Date String2Date(String date, String pattern) {
	        try {
	             return new SimpleDateFormat(pattern, Locale.US).parse(date);
	        } catch (Exception ignore) {
	        }
	
	        return null;
	   }*/


		public static Date String2Date(String date, String pattern) {
			   try {
				   SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
				   Date d = sdf.parse(date);
				   
				   return d;
			   } catch (Exception ignore) {
			   }
			   
			   return null;
		}

		
	   /**
	    * 
	    * @param date
	    * @param pattern
	    * @param timeZoneID GMT, UTC, Asia/Singapore, Asia/Jakarta
	    * <p> jadi {@code date} akan dianggap sebagai jam singapura, sehingga returnnya akan membaca sebagai jam di lokal
	    * @return
	    */
	   public static Date String2Date(String date, String pattern, String timeZoneID) {
		   try {
			   SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
			   sdf.setTimeZone(TimeZone.getTimeZone(timeZoneID));
			   Date d = sdf.parse(date);
			   
			   return d;
		   } catch (Exception ignore) {
		   }
		   
		   return null;
	   }

		public static Date addHours(Date from, int offset) {
			Calendar cal = Calendar.getInstance();
			
		    cal.setTime(from); 
		    cal.add(Calendar.HOUR_OF_DAY, offset); // adds two hour
		    return cal.getTime(); 
		}

		public static Date addMinutes(Date from, int offset) {
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(from); 
			cal.add(Calendar.MINUTE, offset); // adds two hour
			return cal.getTime(); 
		}

		/**
		 * 
		 * @param from
		 * @param offsetNegative -1 to subtract 1 minutes
		 * @return
		 */
		public static Date subtractMinutes(Date from, int offsetNegative){
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(from);
			cal.add(Calendar.MINUTE, offsetNegative);
			
			return cal.getTime();
		}

		/**
		 * MST_AIRPORTS menggunakan timezone offset
		 * @param cal
		 * @return 7 (jika timezonenya Asia/Jakarta). Be advised, may return minus value
		 */
		public long getTimeZone(Calendar cal){

			return TimeUnit.HOURS.convert(cal.getTimeZone().getRawOffset(), TimeUnit.MILLISECONDS);

		}
		
		/**
		 * Converts the given <code>date</code> from the <code>fromTimeZone</code> to the
		 * <code>toTimeZone</code>.  Since java.util.Date has does not really store time zome
		 * information, this actually converts the date to the date that it would be in the
		 * other time zone.
		 * @param date
		 * @param fromTimeZone
		 * @param toTimeZone
		 * @return
		 */
		public static Date convertTimeZone(Date date, TimeZone fromTimeZone, TimeZone toTimeZone)
		{
		    long fromTimeZoneOffset = getTimeZoneUTCAndDSTOffset(date, fromTimeZone);
		    long toTimeZoneOffset = getTimeZoneUTCAndDSTOffset(date, toTimeZone);

		    return new Date(date.getTime() + (toTimeZoneOffset - fromTimeZoneOffset));
		}
		/**
		 * Calculates the offset of the <code>timeZone</code> from UTC, factoring in any
		 * additional offset due to the time zone being in daylight savings time as of
		 * the given <code>date</code>.
		 * @param date
		 * @param timeZone
		 * @return
		 */
		private static long getTimeZoneUTCAndDSTOffset(Date date, TimeZone timeZone)
		{
		    long timeZoneDSTOffset = 0;
		    if(timeZone.inDaylightTime(date))
		    {
		        timeZoneDSTOffset = timeZone.getDSTSavings();
		    }

		    return timeZone.getRawOffset() + timeZoneDSTOffset;
		}
		/*
		public static Date parseFlightDate(String ddMMyyyy) {
			if (StringUtils.isEmpty(ddMMyyyy)) return new Date();

			for (String s : Utils.todayWords) {
				if (s.equalsIgnoreCase(ddMMyyyy)){					
					ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
					break;
				}
			}
			for (String s : Utils.tommorrowWords) {
				if (s.equalsIgnoreCase(ddMMyyyy)){					
					Date _dt = new Date(new Date().getTime() + TimeUnit.DAYS.toMillis(1));
					ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy").format(_dt);
					break;
				}
			}	

			try {
				return new SimpleDateFormat("dd/MM/yyyy").parse(ddMMyyyy);
			} catch (ParseException e) {
				e.printStackTrace();
				return new Date();
			}
		}*/
		
		public static BigDecimal parseLabelRate(String str){

			//hilangkan titik, koma dan spasi
			str = str.replaceAll("[,. ]", "");
			
			// is it a number
			if (!Utils.isNumeric(str)) return BigDecimal.ZERO;
			
			return new BigDecimal(str);
		}
		
	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}
	
	public static List<?> arrayToList(Object[] array){
		return Arrays.asList(array);
	}
		
	public static String capitalizeWords(String words){
		return org.apache.commons.lang.WordUtils.capitalizeFully(words);
	}
	public static String[] csvToArray(String csv) {
		// TODO Auto-generated method stub
		return StringUtils.commaDelimitedListToStringArray(csv);
	}
	public static void main(String[] args){
		double mat = 5;
		double min_mat = mat - .285;
		double max_mat = mat + .285;

		System.out.println(min_mat);
		System.out.println(max_mat);
	}

	public static String getFullName(String firstName, String middleName, String lastName){
		StringBuffer sb = new StringBuffer(firstName);
		
		if (!isEmpty(middleName))
			sb.append(" ").append(middleName);

		if (!isEmpty(lastName))
			sb.append(" ").append(lastName);
		
		return sb.toString(); 

	}

	public static String getDayName(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("EEEE");
		return format.format(date);
	}
	
	public static String printFlightTime(Date date, String timeZoneID){
		return Date2String(date, "EEE HH:mm", timeZoneID);
	}

	/**
	 * http://stackoverflow.com/questions/120283/how-can-i-measure-distance-and-create-a-bounding-box-based-on-two-latitudelongi
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static double distance(double lat1, double lng1, double lat2, double lng2) {
	    double earthRadius = 3958.75; // miles (or 6371.0 kilometers)
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double sindLat = Math.sin(dLat / 2);
	    double sindLng = Math.sin(dLng / 2);
	    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
	            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;

	    return dist;
	  }
	
	public static void print(List<?> list){
		System.out.println("PRINT LIST (" + (list == null ? "null" : list.size()) + ")");
		System.out.flush();
		
		for (Object obj : list){
			System.out.println(obj);
		}
	}
}
