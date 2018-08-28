/*
	Name:Dipayan
	Roll:CS1726
	Date:18-May-2018
	Comment:Bhabatu sarba Mangalam

*/
package com.dipayan.Process;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.dipayan.constant.Constant;
import com.dipayan.exception.ProcessException;
import com.dipayan.osType.OSType;

public class ProcessKill implements ProcessInterface {

	private static Runtime processRunTime=null;
	
	public ProcessKill() {
		this.processRunTime=Runtime.getRuntime();
	}
	
	@Override
	public int startProcess() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int killProcess() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int killProcess(int processId) {
		/*if system is linux or ubuntu then Linux kill or windows kill or other kill you can think off*/
		int result=1;
		/*here be if condition to check the System type then according tll*/
		OSType os=new OSType();
		String osType=os.getOSType();
		String instruction="";
		if(Constant.LINUX.equalsIgnoreCase(osType)){
			//instruction=Constant.LINUX_KILL_INSTRUCTION+processId;
			result=linuxKill(processId);
		}else if(Constant.MAC.equalsIgnoreCase(osType) ) {
			//instruction=Constant.MAC_KILLING_INSTRUCTION+processId;
			result=macKill(processId);
		}else if(Constant.WINDOWS.equalsIgnoreCase(osType)) {
			//instruction=Constant.WINDOWS_KILLING_INSTRUCTION+processId;
			result=windowsKill(processId);
		}else if(Constant.FEDORAD.equalsIgnoreCase(osType)) {
			//instruction=Constant.FEDORA_KILLING_INSTRUCTION+processId;
			result=fedoraKill(processId);
		}else if(Constant.SOLARIS.equalsIgnoreCase(osType)) {
			//instruction=Constant.SOLARIS_KILLING_INSTRUCTION+processId;
			result=windowsKill(processId);
		}else if(Constant.REDHAT.equalsIgnoreCase(osType)) {
			instruction=Constant.REDHAT_KILLING_INSTRUCTION+processId;
			result=redHatKill(processId);
		}else {
			System.out.println("There is some problem please fix asap ");
			return 0;
		}
		
		//result =KillProcess(instruction);
		return result;
	}
	
	
	/*If its a  System then  kill ,if 1 then success else 0 for failure */
	private int KillProcess(String instruction) {
		Runtime processRunTime=Runtime.getRuntime();
		try {
			processRunTime.exec(instruction);
		} catch (IOException   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	/*If its a redhat System then  kill ,if 1 then success else 0 for failure */
	private int redHatKill(int processId) {


		try {
			processRunTime.exec("kill -TERM "+processId);
		} catch (IOException   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	/*If its a fedora System then  kill ,if 1 then success else 0 for failure */
	private int fedoraKill(int processId) {

		try {
			processRunTime.exec("kill -TERM "+processId);
		} catch (IOException   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}		return 1;
	}

	/*If its a mac System then  kill ,if 1 then success else 0 for failure */
	private int windowsKill(int processId) {
		
		try {
			processRunTime.exec("Taskkill /PID  "+processId+" /F");
		} catch (IOException   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

	/*If its a mac System then  kill ,if 1 then success else 0 for failure */
	private int macKill(int processId) {


		try {
			processRunTime.exec("kill -TERM "+processId);
		} catch (IOException   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	/*if positive number then its killed else not killed
	 * */
	private int linuxKill(int processId) {
		
		try {
			processRunTime.exec("kill -TERM "+processId);
		} catch (IOException   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public void getRunningProcesses() {

		 	Process process=null;
		 	Scanner scanner=null;
		 	try {
			 	process= Runtime.getRuntime().exec("top -p 2041");
			     scanner= new Scanner(new InputStreamReader(process.getInputStream()));
			     System.out.println(scanner.toString());
			     while (scanner.hasNext()) {
			        System.out.println(scanner.toString());
			    }
			    
		 	}catch(Exception e){
		 		System.out.println(e);
		 	}finally {
				if(null!=scanner) {
					scanner.close();
				}
			}
		
	}

}
