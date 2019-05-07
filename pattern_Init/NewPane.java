package pattern_Init;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

abstract class NewPane extends GridPane{
	public NewPane() {
		showGUI();
	}
	
	abstract protected void showGUI(); 
}


class NewTaskPane extends NewPane{
	public NewTaskPane() {
		showGUI();
	}
	protected void showGUI(){
		setAlignment((Pos.TOP_CENTER));
		setPadding(new Insets(10,10,10,10));
		setHgap(5.5);
		setVgap(5.5);

		TextField lbTitle = new TextField();
		TextField lbContent = new TextField();

		add(new Label("title"),0,1);
		add(lbTitle, 1,1);
		add(new Label("Content"),0,2);
		add(lbContent, 1,2);


		Button saveBt = new Button("save");
		Button restBt = new Button("Reset");
		add(saveBt,2,1);
		add(restBt, 2, 2);

		saveBt.setOnAction(new SaveTaskBtHandler(lbTitle, lbContent));
		restBt.setOnAction(new AddTaskBtHandler());
	}
}//NewTaskPane

class NewRecordPane extends NewPane{
	public NewRecordPane() {
		showGUI();
	}
	protected void showGUI() {
		setAlignment((Pos.TOP_CENTER));
		setPadding(new Insets(10,10,10,10));
		setHgap(5.5);
		setVgap(5.5);

		TextField lbTitle = new TextField();
		TextField lbDate = new TextField();
		TextField lbSpace = new TextField();
		TextField lbAgenda = new TextField();
		TextField lbDecided = new TextField();
		TextField lbnextTask = new TextField();
		TextField lbLeader = new TextField();

		add(new Label("title"),0,1);
		add(lbTitle, 1,1);
		add(new Label("date"),0,2);
		add(lbDate, 1,2);
		add(new Label("space"),0,3);
		add(lbSpace, 1,3);
		add(new Label("agenda"),0,4);
		add(lbAgenda, 1,4);
		add(new Label("decided"),0,5);
		add(lbDecided, 1,5);
		add(new Label("nextTask"),0,6);
		add(lbnextTask, 1,6);
		add(new Label("leader"),0,7);
		add(lbLeader, 1,7);


		Button saveBt = new Button("save");
		Button restBt = new Button("Reset");
		add(saveBt,0,8);
		add(restBt, 1, 8);

		saveBt.setOnAction(new SaveRecordBtHandler(lbTitle, lbDate,lbSpace,lbAgenda, lbDecided,lbnextTask,lbLeader));
		restBt.setOnAction(new AddRecBtHandler());
	}
}//NewRecordPane


class NewSchedulePane extends NewPane{
	public NewSchedulePane() {
		showGUI();
	}

	protected void showGUI() {
		setAlignment((Pos.TOP_CENTER));
		setPadding(new Insets(10,10,10,10));
		setHgap(5.5);
		setVgap(5.5);

		TextField lbTitle = new TextField();
		TextField lbDate = new TextField();
		TextField lbLeader = new TextField();
		TextField lbContent = new TextField();
		TextField lbTime = new TextField();


		add(new Label("title"),0,1);
		add(lbTitle, 1,1);
		add(new Label("date"),0,2);
		add(lbDate, 1,2);
		add(new Label("Content"),0,3);
		add(lbContent, 1,3);
		add(new Label("leader"),0,4);
		add(lbLeader, 1,4);
		add(new Label("Time"),0,5);
		add(lbTime, 1,5);




		Button saveBt = new Button("save");
		Button restBt = new Button("Reset");
		add(saveBt,0,6);
		add(restBt, 1, 6);

		saveBt.setOnAction(new SaveSchBtHandler(lbTitle, lbContent,lbDate,lbLeader,lbTime));
		restBt.setOnAction(new AddSchBtHandler());
	}
}