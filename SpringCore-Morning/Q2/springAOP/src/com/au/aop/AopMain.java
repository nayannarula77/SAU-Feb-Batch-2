package com.au.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.au.aop.service.ShapeService;

import com.au.aop.model.Circle;
import com.au.aop.model.Triangle;

public class AopMain {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeservice", ShapeService.class);
		shapeService.getCircle().getName();
		try {
		shapeService.getCircle().printThrowException();}
		catch(Exception e) {}
		
		
	}

}
