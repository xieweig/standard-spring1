package org.anyway.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 ** note:当传入参数为null时候跳过该方法 而不因为传入参数为空而报异常
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface NullSkip {
	
	String value() default "skip";
}
