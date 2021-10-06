package EventHandlers;

import Controller.DrawingController;

import Model.Mode;

import View.DrawingPane;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickEventHandler implements EventHandler<MouseEvent>{

	//Variables
	private DrawingController drawingController;
	
	public ClickEventHandler(DrawingController drawingController){
	
		this.drawingController = drawingController;
		
	}
	
	@Override
	public void handle(MouseEvent event) {
		
		if(event.getSource() instanceof DrawingPane) {

			double mousePositionX = event.getX();
			double mousePositionY = event.getY();
			
			String mode = drawingController.getMode();
			switch (mode) {
			
			case Mode.MODE_SELECTORMOVE:
				//TODO 2: The shape under the cursor should be directly selected when clicked
				/*
				 * You will also have to implement the function shapeSelected(double mousePositionX, double mousePositionY) in the Drawing_Controller
				 */
				break;
				
			case Mode.MODE_ELLIPSE:	
			case Mode.MODE_RECTANGLE:
			case Mode.MODE_LINE:
				drawingController.newShape(mode,mousePositionX,mousePositionY);
				break;
				
			default:
				break;
				
			}
			
		}
		
	}

}
