package com.designpattern.factory;
/**
 * @author Anil Kumar (anitowrite@hotmail.com)
 * Factory pattern is one of most used design pattern in Java. 
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 * In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.
 * We're going to create a Shape interface and concrete classes implementing the Shape interface. 
 * A factory class ShapeFactory is responsible to provide shape on demand
 */
public class ShapeProvider {

	public static void main(String[] args) {
		ShapeFactory shapeFactory=new ShapeFactory();
		Shape circle=shapeFactory.getShape("circle");
		circle.draw();
		Shape square=shapeFactory.getShape("square");
		square.draw();
		Shape rectangle=shapeFactory.getShape("rectangle");
		rectangle.draw();

	}
}
class ShapeFactory{
	public Shape getShape(String shapeType){
		String shape=shapeType.toUpperCase();
		switch(shape){
			case "CIRCLE": return new Circle();
			case "RECTANGLE":return new Rectangle();
			case "SQUARE":return new Square();
			default: return null;
		}
	}
}
interface Shape{
	public void draw();
}
class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Circle drawing..");		
	}
}
class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Rectangle drawing..");	
	}
}
class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("Square drawing..");	
	}
}
