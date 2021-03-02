package com.au.aop.model;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Setting circle name..");
		this.name = name;
	}
	
	public void printThrowException(){
	      System.out.println("Exception raised");
	      throw new IllegalArgumentException();
	   }
}
