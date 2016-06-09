package com.designpattern.singleton;
/*
*author:Anil Kumar
*email:anitowrite@hotmail.com
*/

public class EnumSingleton {

	public static void main(String[] args) {
		EnumSingletonExample.SingletonEnum.INSTANCE.printAppLog("Application logg");
		EnumSingletonExample.SingletonEnum.INSTANCE.printErrLog("Error Logg");
	}

}
class  EnumSingletonExample{
	
	public enum SingletonEnum{
		INSTANCE;
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
}
