/*
 * Author:Dipayan
 * Roll:cs1726
 * Department:CS
 * ISI Kolkata
 * Be Happy; :)
 * */
package com.dipayan.main;

import com.dipayan.Process.ProcessKill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.dipayan.Process.ProcessInterface;

public class CS1726MainOS {
	
	/*Its the Interface killing or viewing the processes */
	static ProcessInterface  process;
	public static void main(String[] args) {
		process =new ProcessKill();
		processInterface();
	}

	/*here all things are being done basic interface with while loop check and run
	 * */
	private static void processInterface() {
		int choice=1;
		try{
			while(0!=choice) {
				showOptions();
				choice=getOptionOrProcessId();
				operateOnOptionOfChoice(choice);
			}
			
		}catch(Exception exception) {
			System.out.println("Please do it according to Instruction");
		}
		
	}

	private static void operateOnOptionOfChoice(int choice) {
		switch(choice) {
			case 1:
				System.out.println("In Check the processes");
				process.getRunningProcesses();
				break;
			case 2:
				System.out.println("In Kill the processes");
				System.out.println("Please engter a process id");
				int processId=getOptionOrProcessId();
				int success=0;
				success=process.killProcess(processId);
				if(0==success) {
					System.out.println("No Such Procss found:"+processId);
				}
				break;	
			case 3:
				System.out.println("In for further use may not been Implemented");
				break;
			case 0:
				System.out.println("TATA, Happy Doing Work  with you");
				break;
			default:
				System.out.println("Try again");
				break;
		}
		
	}

	private static void showOptions() {
		System.out.println("Enter 1 to check Process");
		System.out.println("Enter 2 to kill Process");
		System.out.println("Enter 3 for further use(Maintainance)");
		System.out.println("Enter 0 to Quit");
		
		
	}
	/*It only takes one input and returns it*/
	private static int getOptionOrProcessId() {
		int input=-1;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in) );
		try {
			
			input=Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException | NullPointerException  e) {
			System.out.println("Please enter proper input:"+e.getMessage());
			//e.printStackTrace();
		}
		
		return input;
	}

}
