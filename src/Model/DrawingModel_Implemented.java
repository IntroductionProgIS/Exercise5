package Model;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


// TODO 0a: Read the classes associated to DrawingModel_Implemented
public class DrawingModel_Implemented implements DrawingModel{

	//Parameters
	private String mode;
	private Color color;
	
	private ArrayList<Shape> shapesList = new ArrayList<Shape>();
	
	public DrawingModel_Implemented() {
		//TODO 0b: Initialize class variables
		/*
		 * 
		 */
	}
	
	@Override
	public void setMode(String mode) {

		this.mode = mode;
		
	}

	@Override
	public void setColor(Color color) {

		this.color = color;
		
	}

	@Override
	public void addEllipse(double mousePositionX, double mousePositionY, double radiusX, double radiusY, Color color) {		
		// TODO 6: 	Add the support of other shapes by implementing the addEllipse function
		//			They should support the same features: move, delete, color change, etc. 
	}

	@Override
	public void addRectangle(double mousePositionX, double mousePositionY, double height, double width, Color color) {

		Rectangle rectangle = new Rectangle(mousePositionX, mousePositionY, height, width);
		rectangle.setFill(color);
		rectangle.setStroke(color);
		this.shapesList.add(rectangle);
		
	}

	@Override
	public void addLine(double mousePositionX, double mousePositionY, double width, Color color) {		
		// TODO 6: 	Add the support of other shapes by implementing the addLine function
		//			They should support the same features: move, delete, color change, etc. 
	}
	
	@Override
	public void addShape(Shape shape) { 
		
		this.shapesList.add(shape);
	
	}
	
	@Override
	public void removeLastShape() {
		if(shapesList.size()>0) {
			
			this.shapesList.remove(this.shapesList.size() - 1);
			
		}
		
	}

	@Override
	public void bringShapeToFront(Shape shape) {
		
		for(int index = 0 ; index < shapesList.size() ; index++) {
			
			if(shape == shapesList.get(index)) {
				
				shapesList.remove(index);
				shapesList.add(shape);
				
			}
			
		}
		
	}

	@Override
	public ArrayList<Shape> getShapesList() {
		return shapesList;
	}
	
	@Override
	public String getMode() {
		return this.mode;
	}

	@Override
	public Color getColor() {
		return this.color;
	}
	
}
