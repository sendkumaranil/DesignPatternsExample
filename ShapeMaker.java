package com.designpattern.facade;
/*
*Author:Anil Kumar
*email:anitowrite@hotmail.com
*
*
*/

public class ShapeMaker {

	public static void main(String[] args) {
		ShapeFacade shape=new ShapeFacade();
		shape.shapeMaker();

	}

}
interface Shape{
	public void draw();
}
class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Circle Drawing...");
		
	}
}
class Rectangle implements Shape{

	@Override
	public void draw() {
		
		System.out.println("Rectangle Drawing...");
	}
}
class ShapeFacade{
	private Circle drawCircle;
	private Rectangle drawRectangle;
	
	public ShapeFacade(){
		drawCircle=new Circle();
		drawRectangle=new Rectangle();
	}
	public void shapeMaker(){
		System.out.println("Shape Maker Start..");
		drawCircle.draw();
		drawRectangle.draw();
	}
}
