package com.example.exception;

public class OwmRequestException extends Exception {

	static final long serialVersionUID=0; //implementazione consigliata (warning) da classe exception
	
	public OwmRequestException(){
		super("By the orders of the fookin peaky blinders");
	}
}
