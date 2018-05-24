package org.anyway.config;


import java.awt.Color;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import org.anyway.infrastructure.enmus.Sex;
import org.springframework.stereotype.Component;

@Component
public class RandomUtil {
	
	@Resource 
	private Random random;
	
	public Color randomColor() {
		return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
	
	}
	/*
	public Enum randomEnum(Enum<?> e){
		e.getClass().
		return null;
	}
	*/
	public String random4Number() {
		return String.format("%04d", random.nextInt(10000));
	}
	
	public String randomId() {
		// todo : uuid
		return String.valueOf(System.currentTimeMillis()).substring(4)+this.random4Number();
	}
}
