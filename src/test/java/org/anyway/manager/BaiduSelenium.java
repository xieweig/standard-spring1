package org.anyway.manager;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaiduSelenium {
	private WebDriver driver; 
	@Test
	public void test01() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		// System.setProperty("webdriver.chrome.bin", "/usr/bin/google-chrome");
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");

		//driver = new ChromeDriver();
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("http://www.baidu.com");
		TimeUnit.SECONDS.sleep(5);
		//随意ｃｏｐｙ一个进行修改
		//driver.findElement(By.xpath("//*[@id=\"u1\"]/a[3]"));
		//String result = driver.findElement(By.xpath("//*[@id=\"u1\"]/a[3]")).getAttribute("href");
		List<String> result = new LinkedList<String>();
		String path = null;
		for (int i = 1; i <= 6; i++) {
			path="//*[@id=\"u1\"]/a["+ i +"]";
			//System.out.println(path);
			result.add(driver1.findElement(By.xpath(path)).getAttribute("href"));
		}
		result.stream().forEach(System.out::println);

	}
	
	/*
	 ** note:	//*[@id="kw"]
	 *			//*[@id="homeSearchForm"]/input[25]
	 *			//*[@id="imgid"]/div/ul/li[2]/div[1]/a/img 
	 * 			//*[@id="imgid"]/div/ul/li[3]/div/a/img  
	 * 			//*[@id="imgid"]/div/ul/li[4]/div[1]/a/img
	 **/
	private WebDriver driverForPicture;
	String searchContent ="龙芯";
	String target = null;
	@Test
	public void test02() throws InterruptedException {
		driverForPicture = new ChromeDriver();
		//driverForPicture = new FirefoxDriver();
		driverForPicture.get("http://image.baidu.com/");
		TimeUnit.SECONDS.sleep(4);
		driverForPicture.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys(searchContent);
		driverForPicture.findElement(By.xpath("//*[@id=\"homeSearchForm\"]/span[2]")).click();
		TimeUnit.SECONDS.sleep(2);
		target = "//*[@id=\"imgid\"]/div/ul/li[2]/div[1]/a/img";
		System.out.println(driverForPicture.findElement(By.xpath(target)).getTagName());
		for (int i = 2; i <= 10; i++) {
			//熟悉后就是个对称的"+i+" 
			target="//*[@id=\"imgid\"]/div/ul/li[" +i+ "]/div/a/img";
			System.out.println(driverForPicture.findElement(By.xpath(target)).getAttribute("data-imgurl"));
			System.out.println(driverForPicture.findElement(By.xpath(target)).getAttribute("src"));
			TimeUnit.SECONDS.sleep(1);
		}
		
		
	}
	@After
	public void down() {
		if(driver!=null) driver.quit();
		if(driverForPicture!=null) driverForPicture.quit();
	}
}
