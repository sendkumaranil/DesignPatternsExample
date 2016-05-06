package com.designpattern.singleton;

public class EagerSingleton {

	public static void main(String[] args) {
		EagerCustomLogger customLog=EagerCustomLogger.getLogger();
		customLog.printAppLog("writing Application Logging...");
		customLog.printErrLog("writing Error logging...");
		customLog.printLog("writing general logging...");

		EagerCustomLogger customLog2=EagerCustomLogger.getLogger();
		
		System.out.println((customLog==customLog2)+"(if true then same instance else different instances.)");
	}

}
class EagerCustomLogger{
	private static EagerCustomLogger logger=new EagerCustomLogger();
	
	private EagerCustomLogger(){}
	
	public static EagerCustomLogger getLogger(){
		return logger;
	}
	
	public void printAppLog(String logMsg){
		System.out.println(logMsg);
	}
	public void printErrLog(String logMsg){
		System.out.println(logMsg);
	}
	public void printLog(String logMsg){
		System.out.println(logMsg);
	}
	
}