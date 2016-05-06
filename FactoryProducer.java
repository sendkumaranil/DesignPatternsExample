package com.designpattern.abstractfactory;

/**
 * 
 * @author Anil Kumar (anitowrite@hotmail.com)
 * Abstract Factory patterns work around a super-factory which creates other factories. This factory is also called as factory of factories.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 * We are going to create a Shape and Color interfaces and concrete classes implementing these interfaces. 
 * We create an abstract factory class AbstractFactory as next step. 
 * Factory classes ShapeFactory and ColorFactory are defined where each factory extends AbstractFactory. 
 * A factory creator/generator class FactoryProducer is created.
 */


public class FactoryProducer {

	public static AbstractFactory getFactory(String choice){
		String factory=choice.toUpperCase();
		switch(factory){
		case "SHAPE":return new ShapeFactory();
		case "COLOR":return new ColorFactory();
		default: return null;
		}
	}
	
	public static void main(String[] args) {
		AbstractFactory shapeFactory=FactoryProducer.getFactory("shape");
		
		Shape circle=shapeFactory.getShape("circle");
		circle.draw();
		Shape squire=shapeFactory.getShape("squire");
		squire.draw();
		Shape rectangle=shapeFactory.getShape("rectangle");
		rectangle.draw();
		
		AbstractFactory colorFactory=FactoryProducer.getFactory("color");
		Color red=colorFactory.getColor("red");
		red.fill();
		Color green=colorFactory.getColor("green");
		green.fill();
		
	}
}

interface Shape{
	void draw();
}
class Circle implements Shape{

	@Override
	public void draw() {
		
		System.out.println("Circle drawing...");
	}
}
class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Rectangle drawing...");
	}
}
class Squire implements Shape{

	@Override
	public void draw() {
		System.out.println("Squire drawing...");
	}
}
interface Color{
	void fill();
}
class Red implements Color{

	@Override
	public void fill() {
		System.out.println("filling RED color...");
	}
}
class Green implements Color{

	@Override
	public void fill() {
		System.out.println("filling GREEN color...");
	}
}
abstract class AbstractFactory{
	abstract public Shape getShape(String shapeType);
	abstract public Color getColor(String color);
}
class ShapeFactory extends AbstractFactory{

	@Override
	public Shape getShape(String shapeType) {
		String shape=shapeType.toUpperCase();
		switch(shape){
			case "CIRCLE": return new Circle();
			case "RECTANGLE":return new Rectangle();
			case "SQUIRE":return new Squire();
			default: return null;
		}
	}

	@Override
	public Color getColor(String color) {
		return null;
	}
	
	
}
class ColorFactory extends AbstractFactory{

	@Override
	public Shape getShape(String shapeType) {
		return null;
	}

	@Override
	public Color getColor(String color) {
		String colorCode=color.toUpperCase();
		switch(colorCode){
			case "RED": return new Red();
			case "GREEN":return new Green();
			default: return null;
		}
	}
}
