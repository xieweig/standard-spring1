package org.anyway.manager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.anyway.StandardSpringApplicationTests;
import org.anyway.domain.TrainingMember;
import org.anyway.domain.vo.IndividualPrivacy;
import org.anyway.infrastructure.TrainingMemberRepo;
import org.anyway.infrastructure.enmus.TrainingRole;
import org.hamcrest.CoreMatchers;
import org.anyway.infrastructure.enmus.Sex;
import org.anyway.infrastructure.enmus.TrainingGrade;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class MemberTests extends StandardSpringApplicationTests {
	@Resource(name="alwaysRandom")
	private Random random;
	@Resource
	private TrainingMemberRepo memberRepo;
	
	@Test
	public void save() {
		for (int i = 0; i <2; i++) {
			
			memberRepo.saveAndFlush(this.born());		
		}
		memberRepo.findAll().stream().forEach(System.out::println);
	}
	
	private TrainingMember born() {
		
		TrainingMember trainingMember = new TrainingMember();
		IndividualPrivacy individualPrivacy = new IndividualPrivacy();
		
		individualPrivacy.setBirthday(LocalDate.now().minusYears(random.nextInt(5)+15));
		individualPrivacy.setChineseName("zhang"+random.nextInt());
		individualPrivacy.setEnglishName("Tommy"+random.nextInt(200));
		individualPrivacy.setMobilephone("13911110"+(random.nextInt(900)+100));
		individualPrivacy.setPlaceOfBirth("shandongProvince"+random.nextInt(10)+"city");
		individualPrivacy.setSex(Sex.values()[random.nextInt(Sex.values().length)]);
		individualPrivacy.setWeChatCode("weixin"+random.nextInt(1000));
		individualPrivacy.setIntrests("nongyao");
		individualPrivacy.setPlaceOfLiving("room:"+random.nextInt(800)+100);
		individualPrivacy.setQQCode("888"+(random.nextInt(8900)+1000));
		
		trainingMember.setIndividualPrivacy(individualPrivacy);

		trainingMember.setMemberCode("020202"+(random.nextInt(8999)+1000));
		trainingMember.setLastModifyTime(LocalDateTime.now());
	//	trainingMember.setRemarks("hello kitty");
	//	trainingMember.setTrainingRole(TrainingRole.values()[random.nextInt(TrainingRole.values().length)]);
	//	trainingMember.setTrainingGrade(TrainingGrade.values()[random.nextInt(TrainingGrade.values().length)]);
		
		
		return trainingMember;
	}
	
	//@Test
	public void testQueryIn() {
		List<String> codes = new ArrayList<>();
		
		for (int i = 0; i <5; i++) {
			
			TrainingMember member =	memberRepo.saveAndFlush(this.born());
			
			codes.add(member.getMemberCode());
		}
		
		System.out.println(codes);
	
		memberRepo.findByMemberCodeIn(codes).stream().forEach(System.out::println);
	}
	@Ignore
	@Test
	public void test01() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "/opt/jdk-8/bin/chromedriver");
		WebDriver driver = new ChromeDriver();

	     driver.get("http://baidu.com");  
	     TimeUnit.SECONDS.sleep(2);
	     System.out.println("Page title is:"+driver.getTitle());  
	      
	     driver.close(); 
		
	}

	
	//@Test
	//public void test011() {
		
		/*
		 * WebTester webTester = new WebTester();
		webTester.setBaseUrl("http://localhost:8080/");
		webTester.beginAt("/welcome.html");
		webTester.assertButtonNotPresent("1");
		webTester.assertTitleEquals("welcome");
		System.out.println("==????");
		webTester.clickButton("goto");
	
		*/
	//}

}
