/*
 * 	Name:Dipayan Das
 *  Roll:cs1726
 *  Department:CS
 *  Comment:Bhabatu Sarba Mangalam
 * */


package com.dipayan.Process;

public interface ProcessInterface {

	/*this will create a process and and return some constant value 
	 * for successful or unsuccessful */
	public int startProcess();
	
	/*this will kill a process and and return some constant value 
	 * for successful or unsuccessful this */
	public int killProcess();
	
	/*it will kill the process of certain process id */
	public int killProcess(int processId);

	public void getRunningProcesses();
	
	/*check the existing processes */
	//
}
