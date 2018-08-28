/*
	Name:Dipayan
	Roll:CS1726
	Date:22-May-2018
	Comment:Bhabatu sarba Mangalam

*/
package com.dipayan.osType;

public class OSType {
	private static String OS = System.getProperty("os.name").toLowerCase();
	public String getOSType() {
		System.out.println(System.getProperty("os.name"));
		
		if (isWindows()) {
			System.out.println("This is Windows");
		} else if (isMac()) {
			System.out.println("This is Mac");
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
		} else if (isSolaris()) {
			System.out.println("This is Solaris");
		} else {
			System.out.println("Your OS is not support!!");
		}
		
		
		return System.getProperty("os.name"); 
	}
	
	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		
	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}
	
	
	
	
}
