package pattern_Init;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

abstract class ListPane extends FlowPane{
	public ListPane() {
		showGUI();
	}
	
	protected abstract void showGUI(); 
}


class TaskListPane extends ListPane{
	protected void showGUI() {


		setAlignment((Pos.TOP_LEFT));
		setPadding(new Insets(11.5, 12.5,13.5,14.5));
		setHgap(5.5);
		setVgap(5.5);

		int N = TaskManagement.getTaskList().size();// How many Tasks
		for(int i = 0 ; i < N; i ++) {

			Button TaskTitle = new Button("" + TaskManagement.getTaskList().get(i).getTitle() );
			TaskTitle.setOnAction(new TaskSpecificHandler(i));
			getChildren().add(TaskTitle);

		}
		Button addBt = new Button("ADD");
		getChildren().add(0,addBt);
		addBt.setOnAction(new AddTaskBtHandler());
	}
}//TaskListPane


class SchListPane extends ListPane{
	
	protected void showGUI() {
		int N = MeetingScheduleManagement.getScheduleList().size();// How many Calendars
		for(int i = 0 ; i < N; i ++) {
			Button SchTitle = new Button(""+MeetingScheduleManagement.getScheduleList().get(i).getTitle());
			SchTitle.setOnAction(new SchSpecificHandler(i));
			
			getChildren().add(SchTitle);
		}
		Button addBt = new Button("ADD");
		getChildren().add(0,addBt);
		addBt.setOnAction(new AddSchBtHandler());

	}
}

class RecordListPane extends ListPane{
	
	protected void showGUI() {
		setAlignment((Pos.TOP_LEFT));
		setPadding(new Insets(11.5, 12.5,13.5,14.5));
		setHgap(5.5);
		setVgap(5.5);

		int N = MeetingRecordManagement.getRecordList().size();// How many Tasks
		for(int i = 0 ; i < N; i ++) {
			Button RecordTitle = new Button("" + MeetingRecordManagement.getRecordList().get(i).getTitle());
			RecordTitle.setOnAction(new RecordSpecificHandler(i));



			getChildren().add(RecordTitle);
		}
		Button addBt = new Button("ADD");
		getChildren().add(0,addBt);
		addBt.setOnAction(new AddRecBtHandler());
	}
}//RecordListPane