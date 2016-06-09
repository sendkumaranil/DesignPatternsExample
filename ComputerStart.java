package com.designpattern.facade;
/**
 * A facade is an object that provides a simplified interface to a larger body of code.
 * @author Anil Kumar
 * Agenda: Facade design pattern where all chunk task will be started together
 *
 * 
 */
public class ComputerStart {

	public static void main(String[] args) {
		
		ComputerFacade computer=new ComputerFacade();
		computer.start();
	}

}
class ComputerFacade{

	private CPU processor;
	private Memory ram;
	private HardDrive hd;
	
	public ComputerFacade(){
		processor=new CPU();
		ram=new Memory();
		hd=new HardDrive();
	}
	
	public void start(){
		processor.freeze();
		ram.load(1001, hd.read(120111l, 123));
		processor.jump(100223);
		processor.execute();
	}
	
}

class CPU{
	
	public void freeze(){
		System.out.println("freezing...");
	}
	public void jump(long position){
		System.out.println("Jump on position:"+position);
	}
	public void execute(){
		System.out.println("Program executing..");
	}
}
class Memory{
	public void load(long position, byte[] data){
		System.out.println("Data loading to memory...");
	}
}
class HardDrive{
	public byte[] read(long lba,int size){
		byte[] data=null;
		System.out.println("Data fetching from Hard Drive...");
		return data;
	}
}
