package assignment;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class task1 {

	public static void main(String[] args) throws MalformedURLException {
		
		// To run on remote machine grid is used
				DesiredCapabilities cap  = new DesiredCapabilities();
								
				//Common capabilities require to test app
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Yogita");
		        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		        
		        //to test web app we need to ads capability to web app
		        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		        
		        
		        //chrome driver executable will not be available in mobilecapability//androidcapability 
		        cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE_DIR, "C:\\work\\chromedriver_win32");
		        
		       // WebDriver driver = new WebDriver
		        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		        driver.get("http://www.cricbuzz.com");
		        driver.findElement(By.xpath("//a[contains(@href,'menu')]")).click();;
				 driver.findElement(By.xpath("//a[text()='Home']")).click();
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 WebElement element = driver.findElement(By.xpath("(//span[@class='cbz-ui-home-headline'])[1]"));
				 js.executeScript("arguments[0].scrollIntoView(true);", element);
				 element.click();
      
       
        

	}

}
