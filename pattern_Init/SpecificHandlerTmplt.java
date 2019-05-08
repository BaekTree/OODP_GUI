/**
 * 	
 * 
 * change log: 
 * 
 * Date: May 7th
 * separated from Handler class

	adjusted template method design pattern

	template method: handle()
	hook method: setPane()
 * 
 * 
 * */

package pattern_Init;

import javafx.event.ActionEvent;
import javafx.scene.Scene;

/**Template Method**/
abstract class SpecificHandler extends Handler{
	protected int index;
	HomePane rootPane;
	public SpecificHandler(int i) {
		this.index = i;
	}
	@Override
	public void handle(ActionEvent event){
		setPane();
		scene = new Scene(rootPane,1000,400);
		window.setScene(scene);
	}
	abstract protected void setPane(); 
}


class TaskSpecificHandler extends SpecificHandler{
	private int index;
	public TaskSpecificHandler(int i){
		super(i);
	}
	@Override
	protected void setPane() {
		TaskPane taskPane = new TaskPane(index);
		rootPane = new HomePane(new MainLeftPane(),taskPane);
		
	}
}

class RecordSpecificHandler extends SpecificHandler{
	public RecordSpecificHandler(int i){
		super(i);
	}
	@Override
	protected void setPane() {
		RecordPane recordPane = new RecordPane(index);
		rootPane = new HomePane(new MainLeftPane(),recordPane);
		
	}
}

class SchSpecificHandler extends SpecificHandler{
	public SchSpecificHandler(int i){
		super(i);
	}
	@Override
	protected void setPane() {
		SchPane schPane = new SchPane(index);
		rootPane = new HomePane(new MainLeftPane(),schPane);
		
	}
}
