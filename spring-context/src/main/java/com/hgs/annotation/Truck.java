package com.hgs.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class Truck extends AbstractTest implements ProxyInterface{

	@Autowired
	Car car;

	@Pointcut("execution (* com.hgs.annotation.Truck.*(..))")
	public void pointCut(){}

	@Before(value = "pointCut()")
	public void test(){
		System.out.println("Before ----------------");
	}
}
