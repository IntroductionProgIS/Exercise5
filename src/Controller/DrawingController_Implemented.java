package Controller;

import java.util.ArrayList;

import EventHandlers.ClickEventHandler;
import EventHandlers.ColorEventHandler;
import EventHandlers.DragEventHandler;
import EventHandlers.ModeEventHandler;
import EventHandlers.OperationEventHandler;

import Model.DrawingModel;
import Model.Mode;
import Model.Operation;

import View.DrawingEditorMainPane;
import View.DrawingPane;
import View.MenuPane;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

//TODO 0a: Read the classes associated to DrawingController_Implemented
public class DrawingController_Implemented implements DrawingController{
	
	//Variables
	private DrawingModel drawingModel;
	private DrawingEditorMainPane drawingEditorMainPane;
	
	private EventHandler<MouseEvent> clickEventHandler;
	private EventHandler<MouseEvent> dragEventHandler;
	
	private int indexSelectedShape;
	
	public DrawingController_Implemented(DrawingModel drawingModel, DrawingEditorMainPane drawingEditorMainPane) {
		
		this.drawingEditorMainPane = drawingEditorMainPane;
		this.drawingModel = drawingModel;
		
		this.setButtonsActions();
		
		// TODO 4: Set the actions for the mouse to let users move shapes in the canvas
		/*
		 * 
		 */
	}

	@Override
	public void setButtonsActions() {
		
		MenuPane menuPane = drawingEditorMainPane.getMenuPane();
				
		// TODO 1: When the user clicks on a radio button, the mode should change accordingly. The window title should change also. 
		/*
		 * 
		 */	

		// TODO 3: Set the appropriate actions for the `Delete` and `Clone` buttons so that the user can delete 
		//			or clone (and translate a bit) the selected shape.
		/*
		 * 
		 */
		
		// TODO 5: Enable the color setters that set the fill and stroke color of the currently selected shape and also future shapes.
		/*
		 * 
		 */
		
	}
	
	@Override
	public void setMode(String mode) {
		
		// TODO 1: Implement behavior to set a mode
	}
	
	@Override
	public void setColor(Color color) {
		// TODO 5: Make sure that when the user selects a shape, the color setters should be updated to reflect the fill and stroke colors of this shape.	
	}
	
	@Override
	public void doOperation(String operation) {
		
		DrawingPane drawingPane = drawingEditorMainPane.getDrawingPane();
		
		if(operation.equals(Operation.OPERATION_DELETE)) {
			
			if(indexSelectedShape >= 0 && indexSelectedShape < drawingModel.getShapesList().size()) {
				
				drawingModel.getShapesList().remove(indexSelectedShape);
				drawingPane.drawShapes(drawingModel.getShapesList());
				indexSelectedShape = -1;
				
			}
			
		}
		else if(operation.equals(Operation.OPERATION_CLONE)) {
			
			if(indexSelectedShape >= 0 && indexSelectedShape < drawingModel.getShapesList().size()) {
				
				Shape oldShape = drawingModel.getShapesList().get(indexSelectedShape);
				
				duplicateShape(oldShape);
				
				indexSelectedShape = drawingModel.getShapesList().size() - 1;
				drawingEditorMainPane.getDrawingPane().drawShapes(drawingModel.getShapesList());
				
			}
			
		}
	}
	
	@Override
	public void newShape(String mode, double mousePositionX, double mousePostionY) {
		
		DrawingPane drawingPane = drawingEditorMainPane.getDrawingPane();
		
		switch(mode) {
		
		case Mode.MODE_ELLIPSE:
			drawingModel.addEllipse(mousePositionX, mousePostionY, 1, 1, drawingModel.getColor());
			break;
			
		case Mode.MODE_RECTANGLE:
			drawingModel.addRectangle(mousePositionX, mousePostionY, 1, 1, drawingModel.getColor());
			break;
			
		case Mode.MODE_LINE:
			drawingModel.addLine(mousePositionX, mousePostionY, 1, drawingModel.getColor());
			break;
			
		default:
			break;
		
		}
		
		drawingPane.drawShapes(drawingModel.getShapesList());
		
	}
	
	@Override
	public Shape shapeSelected(double mousePositionX, double mousePositionY) {
		
		ArrayList<Shape> shapesList = drawingModel.getShapesList();
		Shape shape;
		indexSelectedShape = -1;
		
		// TODO 2: Implement the shape Selected function, so that if a shape is under the mouse, it is selected and remembered in indexSelectedShape 
		/*
		 * Tip : Use the declared variables before
		 */
		
		
		return null;
	}
	
	@Override
	public void duplicateShape(Shape oldShape) {
		
		//If the shape that we want to duplicate is an Ellipse
		if (oldShape instanceof Ellipse) {
				
			// TODO 6: 	Add the support of other shapes by implementing the addEllipse function
			//			They should support the same features: move, delete, color change, etc. 
			
		}
		else if (oldShape instanceof Rectangle) {
				
			Rectangle oldRectangle = (Rectangle) oldShape;
			
			//We create a new Rectangle that copy the old one
			Rectangle newRectangle = new Rectangle(oldRectangle.getX() + 10, oldRectangle.getY() + 10, oldRectangle.getWidth(), oldRectangle.getHeight());
			newRectangle.setFill(oldRectangle.getFill());
			newRectangle.setTranslateX(0);
			newRectangle.setTranslateY(0);
			
			//We add this Rectangle to our list of shapes
			drawingModel.addShape(newRectangle);
		
		}
		else if (oldShape instanceof Line) {
				
			// TODO 6: 	Add the support of other shapes by implementing the addLine function
			//			They should support the same features: move, delete, color change, etc. 
			
		}
				
	}
	
	@Override
	public void bringShapeToFront(Shape shape) {
		
		drawingModel.bringShapeToFront(shape);
		drawingEditorMainPane.getDrawingPane().drawShapes(drawingModel.getShapesList());
		
	}

	@Override
	public String getMode() {

		return drawingModel.getMode();	
		
	}

	@Override
	public ArrayList<Shape> getShapesList() {

		return this.drawingModel.getShapesList();
		
	}

	@Override
	public Shape getSelectedShape() {
		
		if(indexSelectedShape >= 0) {
			
			return drawingModel.getShapesList().get(indexSelectedShape);
			
		}
		
		return null;
		
	}    

}