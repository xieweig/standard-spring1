package org.anyway.manager;

import java.util.concurrent.TimeUnit;


import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleTest {
	private WebDriver driver;
//	@Ignore
	@Test
	public void simpleSelenium() throws InterruptedException {
		//driver = new FirefoxDriver();
		
		driver = new ChromeDriver();
	    driver.get("http://localhost:8080/index");  
	    TimeUnit.SECONDS.sleep(2);
	    System.out.println("Page title is:"+driver.getTitle());
	    WebElement element = driver.findElement(By.id("go"));
	    element.click();
	    TimeUnit.SECONDS.sleep(3);
	    WebElement store = driver.findElement(By.id("store"));
	    Assert.assertThat(store.getText(), CoreMatchers.containsString("0202025040"));
	    }
	@After
	public void closeAll() {
		if (webDriver !=null) webDriver.quit();	
	}
	
	private WebDriver webDriver;
	//@Ignore
	@Test
	public void test03() throws InterruptedException {
		webDriver = new ChromeDriver();
	    webDriver.get("http://localhost:8080/index");  
		    

			TimeUnit.SECONDS.sleep(2);
	/*
	 ** note:driver.manage().window().maximize();  //*[@id="user"]
         driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
      */
	     
	     webDriver.findElement(By.xpath("//*[@id=\"user\"]")).sendKeys("Spring Aspect");
	     webDriver.findElement(By.xpath("//div[@id='second']/input[@name='password']")).sendKeys("123456789");
	     
	     TimeUnit.SECONDS.sleep(4);
	     webDriver.findElement(By.xpath("//*[@id=\"goto\"]")).click();
	     TimeUnit.SECONDS.sleep(4);
	     Alert alt = webDriver.switchTo().alert();
	     alt.accept();
	     TimeUnit.SECONDS.sleep(3);
	     /*
	      * alert.dismiss(); 点取消  alert.getText();获取alert的内容
	      * */
	     Assert.assertThat(webDriver.findElement(By.id("show")).getText(), CoreMatchers.containsString("Hello"));
	     TimeUnit.SECONDS.sleep(2);
	    // webDriver.close();
	    // webDriver.quit();
	    // webDriver.findElement(By.id("go")).click();
	   //if (driver != null) driver.quit();
	}

	
	
	
	
}
