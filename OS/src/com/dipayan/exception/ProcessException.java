/*
	Name:Dipayan
	Roll:CS1726
	Date:21-May-2018
	Comment:Bhabatu sarba Mangalam

*/
package com.dipayan.exception;

public class ProcessException extends Exception{
	
	public ProcessException(String message){
		super(message);
		System.out.println("Exception is thrown due to illegal ProcessHandaling-Bydevelopper");
	}
	
}
