/**
 * Date: May 7th
 * change log: 
 * 
 * Create AddEachEntityButton class
 * Create the abstract class to inherit the same part to its children
 * 
 * Adjust template method pattern
 * class: AddEachBtHandler
 * template method: handle
 * hook method: setPane()
 * */
package pattern_Init;

import javafx.event.ActionEvent;
import javafx.scene.Scene;

abstract class AddEachBtHanlder extends Handler{
	HomePane rootPane;
	@Override
	public void handle(ActionEvent event) {
		setPane();
		scene = new Scene(rootPane,1000,400);
		window.setScene(scene);
	}
	
	abstract protected void setPane(); 
}

class AddTaskBtHandler extends AddEachBtHanlder{

	@Override
	public void setPane() {
		// TODO Auto-generated method stub
		NewTaskPane textListPane = new NewTaskPane();
		rootPane = new HomePane(new MainLeftPane(),textListPane);		
	}
}

class AddSchBtHandler extends AddEachBtHanlder{

	@Override
	public void setPane() {
		// TODO Auto-generated method stub
		NewSchedulePane SchListPane = new NewSchedulePane();
		rootPane = new HomePane(new MainLeftPane(),SchListPane);
	}
}

class AddRecBtHandler extends AddEachBtHanlder{

	@Override
	public void setPane() {
		// TODO Auto-generated method stub
		NewRecordPane RecListPane = new NewRecordPane();
		rootPane = new HomePane(new MainLeftPane(),RecListPane);
	}
}