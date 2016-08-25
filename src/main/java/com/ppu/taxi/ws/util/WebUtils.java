package com.ppu.taxi.ws.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {
	
	public static boolean isRadio(WebElement element){
		return element.getTagName().equals("input")
			&& element.getAttribute("type").equals("radio"); 
	}

	public static void selectRadio(WebElement radio) {
		if (radio.isEnabled() && isRadio(radio)){
			radio.click();
		}
	}
	
	/**
	 * 
	 * @param element 4.811.000 (9)
	 * @return
	 */
	public static BigDecimal parseLabelRate(WebElement element){
		String sRate = element.getText();

		//hilangkan titik, koma dan spasi
		sRate = sRate.replaceAll("[,. ]", "");
		
		//jika ada informasi seat ... (9)
//		if (sRate.indexOf("(")> -1)
//			sRate = sRate.substring(0, sRate.indexOf("("));
		
		// is it a number
		if (!Utils.isNumeric(sRate)) return BigDecimal.ZERO;
		
		return new BigDecimal(sRate);
	}
	
	public static WebElement waitForElementPresent(WebDriver driver, final By by, int timeOutInSeconds) {

        WebElement element; 

        try{
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait() 

            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds); 
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //reset implicitlyWait
            return element; //return the element
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null; 
    }
	
	public static WebElement waitForElementVisible(WebDriver driver, final By by, int timeOutInSeconds) {
		
		WebElement element; 
		
		try{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait() 
			
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds); 
			element = wait.until(ExpectedConditions.elementToBeClickable(by));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //reset implicitlyWait
			return element; //return the element
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null; 
	}
	
	public static void waitForAjax(WebDriver driver, String action) {
	        
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
	        
	    ((JavascriptExecutor) driver).executeAsyncScript(
	                "var callback = arguments[arguments.length - 1];" +
	                        "var xhr = new XMLHttpRequest();" +
	                        "xhr.open('POST', '/" + action + "', true);" +
	                        "xhr.onreadystatechange = function() {" +
	                        "  if (xhr.readyState == 4) {" +
	                        "    callback(xhr.responseText);" +
	                        "  }" +
	                        "};" +
	                        "xhr.send();");
	}

	
	public static boolean isElementExists(WebElement parentNode, String tagName, String attributeName, String attributeValue){
//	public static boolean isElementExists(WebElement parentNode, String xpathExpression){
		
//		parentNode.findElement(By.xpath(".//" + tagName + "[@" + attributeName + "='" + attributeValue + "']"))
		
		List<WebElement> list = parentNode.findElements(By.xpath(".//" + tagName)); // isinya div semua
//		List<WebElement> list = parentNode.findElements(By.xpath(xpathExpression)); // isinya div semua
//		List<WebElement> list = driver.findElements(parent); // isinya div semua
		for (WebElement webElement : list) {
			String attrValue = webElement.getAttribute(attributeName);
			
			if (attrValue.equalsIgnoreCase(attributeValue)){
				return true;
			}
		}
		return false;
	}

	public static void skipAlert(WebDriver driver) {
		try {
			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			// Alert present; set the flag
			// if present consume the alert
			alert.accept();

		} catch (NoAlertPresentException ex) {
			// Alert not present
		}
	}
}
