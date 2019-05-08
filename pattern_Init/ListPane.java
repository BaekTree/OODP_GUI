/**
 * change log:

 * Date: May 7th
 * Pattern Adjustment:
 * Template Method Pattern
 * class: ListPane and its children classes
 * template method: showGUI()
 * Hook method: showList()
 * 
 * Factory Pattern
 * class: Children classes of ListPane
 * Working on...
 * It turned out that it is impossible since the handlers themselves
 *  are the key specifier to distinguish which buttons are pressed. 
 * 
 * */

package pattern_Init;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

abstract class ListPane extends FlowPane{
	Button addBt;
//	AddEachBtHanlder handler; -> seems impossible to implement the factory method in handlers since the handlers themselves are the key specifier to distinguish which 
	//buttons are pressed. 
//	AddEachBtFactory BtFactory = new staticAddEachBtFactory();
//	handler = BtFactory.makeBtHandler();
	
	public ListPane() {
		showGUI();
	}
	
	protected void showGUI() {	//template method
		setAlignment((Pos.TOP_LEFT));
		setPadding(new Insets(10, 10,10,10));
		setHgap(5.5);
		setVgap(5.5);
		
		addBt = new Button("ADD");
		getChildren().add(0,addBt);
		showList();	//Hook Method

	}
	
	abstract protected void showList();
	
}


class TaskListPane extends ListPane{
	protected void showList() {
				
		int N = TaskManagement.getTaskList().size();// How many Tasks
		for(int i = 0 ; i < N; i ++) {

			Button TaskTitle = new Button("" + TaskManagement.getTaskList().get(i).getTitle() );
			TaskTitle.setOnAction(new TaskSpecificHandler(i));
			getChildren().add(TaskTitle);

		}
		addBt.setOnAction(new AddTaskBtHandler());


	}
}//TaskListPane


class SchListPane extends ListPane{
	
	protected void showList() {
		int N = MeetingScheduleManagement.getScheduleList().size();// How many Calendars
		for(int i = 0 ; i < N; i ++) {
			Button SchTitle = new Button(""+MeetingScheduleManagement.getScheduleList().get(i).getTitle());
			SchTitle.setOnAction(new SchSpecificHandler(i));
			
			getChildren().add(SchTitle);
		}
		addBt.setOnAction(new AddSchBtHandler());


	}
}

class RecordListPane extends ListPane{
	
	protected void showList() {
		

		int N = MeetingRecordManagement.getRecordList().size();// How many Tasks
		for(int i = 0 ; i < N; i ++) {
			Button RecordTitle = new Button("" + MeetingRecordManagement.getRecordList().get(i).getTitle());
			RecordTitle.setOnAction(new RecordSpecificHandler(i));

			getChildren().add(RecordTitle);
		}
		addBt.setOnAction(new AddRecBtHandler());

		
	}
}//RecordListPane