package com.hgs.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

@Service
public class Car {

	public String name = "Car-hgs";

	@Autowired
	MainConfig mainConfig;
}
