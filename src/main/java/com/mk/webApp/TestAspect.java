package com.mk.webApp;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	
	@Before(value = "execution(* SampleController.before(..))")
	public void before(JoinPoint joinPoint) throws Throwable{
		System.out.println("Before -"+joinPoint.getSignature().getName());
	}
	
	@Before(value = "execution(* SampleController.after(..))")
	public void after(JoinPoint joinPoint) throws Throwable{
		System.out.println("After -"+joinPoint.getSignature().getName());
	}

	@Around(value = "execution(* SampleController.around(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		
		long startTime = new Date().getTime();
		Object result= joinPoint.proceed();
		long endTime = new Date().getTime();
		System.out.println("Execution Time -"+ (endTime - startTime) + ",Result:"+ result);
		return result;
	}
}
