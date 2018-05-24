package org.anyway.config;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;




//@Component
//@Aspect
public class NullSkipDriven {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Pointcut("@annotation(org.anyway.config.NullSkip)")
	public  void nullSkipPointCut() {
	}

	@Before("nullSkipPointCut()")
	public void driven(JoinPoint joinPoint) {
	       MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
	       Method method = sign.getMethod();
	       NullSkip nullSkip = method.getDeclaredAnnotation(NullSkip.class);
	       logger.info("打印："+nullSkip.value()+" 日志");
	       
	       // todo if heal ==null return
	    
	}
}
