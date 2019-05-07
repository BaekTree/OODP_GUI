package pattern_Init;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

abstract class EachPane extends GridPane{
	public EachPane(int i) {
		showGUI(i);
	}
	
	abstract protected void showGUI(int i);
}

class TaskPane extends EachPane{
	public TaskPane(int i) {
		super(i);
	}
	
	protected void showGUI(int i){
		setAlignment((Pos.TOP_CENTER	));
		setPadding(new Insets(10,10,10,10));
		setHgap(5.5);
		setVgap(5.5);

		String title = TaskManagement.getTaskList().get(i).getTitle();
		String content = TaskManagement.getTaskList().get(i).getContent();

		add(new Label("Title: "),0,0);
		add(new Label(title),1,0);

		add(new Label("conent: "),0,2);
		add(new Label(content),1,2);

		// getChildren().add(grid);

	}
}

class RecordPane extends EachPane{
	public RecordPane(int i) {
		super(i);
	}
	protected void showGUI(int i){
		setAlignment((Pos.TOP_CENTER	));
		setPadding(new Insets(10,10,10,10));
		setHgap(5.5);
		setVgap(5.5);

		String title = MeetingRecordManagement.getRecordList().get(i).getTitle();
		int Date = MeetingRecordManagement.getRecordList().get(i).getDate();
		String space = MeetingRecordManagement.getRecordList().get(i).getSpace();
		String agenda = MeetingRecordManagement.getRecordList().get(i).getAgenda();
		String decided = MeetingRecordManagement.getRecordList().get(i).getDecided();
		String nextTask = MeetingRecordManagement.getRecordList().get(i).getNextTast();
		String leader = MeetingRecordManagement.getRecordList().get(i).getMember();

		add(new Label("Title: "),0,0);
		add(new Label(title),1,0);

		add(new Label("Date: "),0,1);
		add(new Label(""+ Date),1,1);

		add(new Label("Space: "),0,2);
		add(new Label(""+ space),1,2);
		add(new Label("Agenda: "),0,3);
		add(new Label(""+ agenda),1,3);
		add(new Label("Decided: "),0,4);
		add(new Label(""+ decided),1,4);
		add(new Label("nextTask: "),0,5);
		add(new Label(""+ nextTask),1,5);
		add(new Label("Leader: "),0,6);
		add(new Label(""+ leader),1,6);
	}
}

class SchPane extends EachPane{
	public SchPane(int i){
		super(i);
	}
	protected void showGUI(int i){
		setAlignment((Pos.TOP_CENTER	));
		setPadding(new Insets(10,10,10,10));
		setHgap(5.5);
		setVgap(5.5);


		String title = MeetingScheduleManagement.getScheduleList().get(i).getTitle();
		int date =  MeetingScheduleManagement.getScheduleList().get(i).getDate();
		String content =  MeetingScheduleManagement.getScheduleList().get(i).getContent();
		String leader = MeetingScheduleManagement.getScheduleList().get(i).getLeader();
		int time =  MeetingScheduleManagement.getScheduleList().get(i).getTime();

		add(new Label("Title: "),0,0);
		add(new Label(title),1,0);

		add(new Label("Date: "),0,1);
		add(new Label(""+date),1,1);

		add(new Label("conent: "),0,2);
		add(new Label(content),1,2);

		add(new Label("leader: "),0,3);
		add(new Label(leader),1,3);

		add(new Label("Time: "),0,4);
		add(new Label(""+time),1,4);

	}
}
