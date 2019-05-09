/**
 * May 8th
 * 
 * Template Method pattern to Factory Pattern
 * 
 * Instruction:
 * Basically all the children class of SpecificHandlers have same formation to have pane instances. 
 * If we create these instances from factories...
 * 	factory class: EachPaneFactory
	how to call:
	� ��ư�� �����Ŀ� ���� �ڵ鷯�� factory Ŭ������ ������ string�� ������.
	���� string�� ���� factory class�� �ش��ϴ� pane instance�� �����ؼ� ��ȯ�Ѵ�.
	�� �ڵ鷯�� ��ȯ���� pane instance�� �޾Ƽ� ���ο� pane�� �����.
 
 * */

package pattern_Init;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import pattern_Init.EachPane;
import pattern_Init.Handler;
import pattern_Init.HomePane;
import pattern_Init.MainLeftPane;
import pattern_Init.RecordPane;
import pattern_Init.SchPane;
import pattern_Init.TaskPane;

abstract class SpecificHandler extends Handler{
	protected int index;
	HomePane rootPane;
	EachPane eachPane;
	EachPaneFactory paneFac;
	
	public SpecificHandler(int i) {
		this.index = i;
	}
	@Override
	public void handle(ActionEvent event){
		paneFac = new EachPaneFactory(index);
		setPane();
		rootPane = new HomePane(new MainLeftPane(),eachPane);

		scene = new Scene(rootPane,1000,400);
		window.setScene(scene);
	}
	abstract protected void setPane(); 
}


class TaskSpecificHandler extends SpecificHandler{
	public TaskSpecificHandler(int i){
		super(i);
	}
	@Override
	protected void setPane() {
		eachPane = paneFac.makeEachPane("T");
	}
}

class RecordSpecificHandler extends SpecificHandler{
	public RecordSpecificHandler(int i){
		super(i);
	}
	@Override
	protected void setPane() {
		eachPane = paneFac.makeEachPane("R");
	}
}

class SchSpecificHandler extends SpecificHandler{
	public SchSpecificHandler(int i){
		super(i);
	}
	@Override
	protected void setPane() {
		eachPane = paneFac.makeEachPane("S");		
	}
}

class EachPaneFactory{
	private int index;
	public EachPaneFactory(int i) {		
		this.index = i;
	}
	public EachPane makeEachPane(String key) {
		if(key.compareTo("T")==0)
			return new TaskPane(index);
		if(key.compareTo("R")==0)
			return new RecordPane(index);
		if(key.compareTo("S")==0)
			return new SchPane(index);
		else return null;
	}
}
