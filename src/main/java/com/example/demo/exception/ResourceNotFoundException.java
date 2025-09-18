package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException{

	  String msg;
	  
	  public ResourceNotFoundException(String msg) {
		  super(msg);
	  }
}
