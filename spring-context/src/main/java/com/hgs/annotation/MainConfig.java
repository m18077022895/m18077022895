package com.hgs.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.hgs.annotation")
@EnableAspectJAutoProxy
public class MainConfig {

	@Autowired
	Car car;
}
