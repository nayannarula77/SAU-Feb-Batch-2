package com.au.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.au.aop.service.ShapeService;
//multiple advices inside aspect
@Aspect
public class LoggingAspect {
	
	//to write specifically for circle class write om.au.aop.model.Circle.getName()
//	@Before("execution(public String getName())")
//	public void LoggingAdvice() {
//		System.out.println("Logging Advice");
//	}
	
	//Apply before all methods start with get
	//execution(public * get*(*) - with parameter
	//execution(public * get*(..) - with any number of parameters
	//execution(* com.au.aop.model.*.get*()) - all get functions for class under model
	@Before("execution(public * get*())")
	public void LoggingAdvice() {
		System.out.println("Before Advice!");
		
	}
	
	
	//Define pointcut expression
	@Pointcut("execution(public * get*(..))")
	public void allGetters() { 
		/* this is a dummy method for holding pointcut expressions, so they can be referenced later in annotations @Before etc */
	}


	// run after execution complete of getCircle() method 
	@After("execution(public * getCircle())")
	public void afterSetName(){
		System.out.println("After advice!");
	}
	
	
	// show message after any setTrinagle() method
	 @Around("execution(public String getName())")
	 public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		 System.out.println("Around Advice! : " + joinPoint.getSignature().getName() + ": Before Method Execution");
	        try {
	            joinPoint.proceed();
	        } finally {
	            //Do Something useful, If you have
	        }
	        System.out.println("Around Advice! : " + joinPoint.getSignature().getName() + ": After Method Execution");
	 }
	
	
	// show message after execution public String get*() method and store returning value into value 
	 @AfterReturning(pointcut="execution(public String get*(..))", returning="value") 
	   public void afterReturning(String value) throws Throwable 
	    {
	        System.out.println("After returning advice! value returned= " + value);
	       
	    }
	 
	
	  // show message when getTriangle method  is called because getTriangle has throw new NullPointerException("Triangle not found");
     @AfterThrowing (pointcut = "execution(* *(..))", throwing = "error")
     public void afterThrowingAdvice(JoinPoint jp, Throwable error){
    	   System.out.println("afterThrowing advice!");  
    	   
    	}
	
}
