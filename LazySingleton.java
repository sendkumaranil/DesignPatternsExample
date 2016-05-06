package com.designpattern.singleton;

/**
 * 
 * @author Anil Kumar (anitowrite@hotmail.com)
 * This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. 
 *
 */
public class LazySingleton {

	public static void main(String[] args) {
		
		CustomLogger customLog=CustomLogger.getLogger();
		customLog.printAppLog("writing Application Logging...");
		customLog.printErrLog("writing Error logging...");
		customLog.printLog("writing general logging...");
		
		CustomLogger customLog2=CustomLogger.getLogger();
		
		System.out.println((customLog==customLog2)+"(if true then same instance else different instances.)");
		

	}

}
class CustomLogger{
	
	private static volatile CustomLogger logger=null;
	
	private CustomLogger(){} /*make constructor as private to avoid instantiate*/
	
	
	protected Object clone()throws CloneNotSupportedException{ //prevent different object creation during object cloning process 
		throw new CloneNotSupportedException();
	}
	
	protected Object readResolve(){ //prevent different object creation during deserilazation process 
		return logger;
	}
	
	public static CustomLogger getLogger(){
		
		if(logger == null){
			synchronized(CustomLogger.class){ //double check locking for concurrent thread restrict to create multiple object
				if(logger == null){
					logger= new CustomLogger();
				}
			}
		}
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