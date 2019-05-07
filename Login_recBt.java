

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Login_recBt extends Application{
	private Stage window;
	private Scene scene;
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		LoginPane login = new LoginPane();
		scene = new Scene(login);
		
		window.setTitle("TeamWork");
		window.setScene(scene);
		window.show();
	}
	
	
	
	class LoginPane extends GridPane{
		private String id;
		private String pw;
		public LoginPane() {
			super();
			// TODO Auto-generated constructor stub
			showGUI();
		}

		void showGUI() {
			setAlignment((Pos.CENTER));
			setPadding(new Insets(11.5, 12.5,13.5,14.5));
			setHgap(5.5);
			setVgap(5.5);

			Button btEnt = new Button("Enter");
			TextField lbID = new TextField();
			TextField lbPW = new TextField();
			add(new Label("ID"),0,1);
			add(lbID,1,1);
			add(new Label("PW"),0,2);
			add(lbPW,1,2);
			add(btEnt,0,3);
			btEnt.setOnAction(new EntBtHandler(lbID,lbPW));

		}
	}//LoginPane
	
	
	class EntBtHandler implements EventHandler<ActionEvent> {
		private TextField id;
		private TextField pw;
		public EntBtHandler(TextField lbID, TextField lbPW) {
			this.id = lbID;
			this.pw = lbPW;
		}
		
		@Override
		public void handle(ActionEvent event) {	//btEnt Hander

			if ( !(MemberManagement.logIn(id.getText(),pw.getText()) instanceof User )) {	//if the id and pw not matched
					LoginPane login = new LoginPane();
				login.add(new Label("Log in failure. Try again!"),0,0);
				scene = new Scene(login);
			}
			
 			else {	//when id and pw matched		
				MainLeftPane leftMainPane = new MainLeftPane();
				VBox welcomePane = new VBox(new Label("Welcome!"));
				
				HomePane rootPane = new HomePane(leftMainPane,welcomePane);
				scene = new Scene(rootPane,1000,400);
			}
			window.setScene(scene);


		}
	}//EntBtHandler
	
	
	
	class TaskBtHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			HomePane rootPane;
			if(TaskManagement.getTaskList().size() <= 0)
				rootPane = new HomePane(new MainLeftPane(), new VBox(new Label("Welcome!")));
			else
				rootPane = new HomePane(new MainLeftPane(), new TaskListPane());
			
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}
	}	//TaskBtHandler
	
	class SchBtHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			HomePane rootPane;
			if(MeetingScheduleManagement.getScheduleList().size() <= 0)
				rootPane = new HomePane(new MainLeftPane(), new VBox(new Label("Welcome!")));
			else
				rootPane = new HomePane(new MainLeftPane(), new SchListPane());
			
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}
	}
	
	class RecordBtHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			HomePane rootPane;
			if(MeetingRecordManagement.getRecordList().size() <= 0)
				rootPane = new HomePane(new MainLeftPane(), new VBox(new Label("Welcome!")));
			else
				rootPane = new HomePane(new MainLeftPane(), new RecordListPane());
			
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}
	}
	
	
	
	class AddTaskBtHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			NewTaskPane textListPane = new NewTaskPane();
			
			HomePane rootPane = new HomePane(new MainLeftPane(),textListPane);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}
		
	}
	
	class AddSchBtHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			NewSchedulePane SchListPane = new NewSchedulePane();
			
			HomePane rootPane = new HomePane(new MainLeftPane(),SchListPane);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}
		
	}
	
	class AddRecBtHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			NewRecordPane RecListPane = new NewRecordPane();
			
			HomePane rootPane = new HomePane(new MainLeftPane(),RecListPane);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}
		
	}
	
	
		
	class SaveTaskBtHandler implements EventHandler<ActionEvent>{
		private TextField lbTitle;
		private TextField lbContent;
		public SaveTaskBtHandler(TextField tt, TextField ct) {
			// TODO Auto-generated constructor stub
			this.lbTitle = tt;
			this.lbContent = ct;
		}
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			MainTask newMainTask = new MainTask(lbTitle.getText(),
												lbContent.getText()
												);
			TaskManagement.addMainTask(newMainTask);
			
			TaskListPane textListPane = new TaskListPane();
			HomePane rootPane = new HomePane(new MainLeftPane(),textListPane);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
			
			
		}
			
	}
	
	class SaveSchBtHandler implements EventHandler<ActionEvent>{
		private TextField lbTitle;
		private TextField lbContent;
		private TextField lbDate;
		private TextField lbLeader;
		private TextField lbTime;
		public SaveSchBtHandler(TextField tt, TextField ct, TextField dt,  TextField ld,  TextField tm) {
			// TODO Auto-generated constructor stub
			this.lbTitle = tt;
			this.lbContent = ct;
			this.lbDate = dt;
			this.lbLeader = ld;
			this.lbTime = tm;
		}
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			MeetingSchedule newSchedule = new MeetingSchedule(lbTitle.getText(),
					lbContent.getText(),
					lbLeader.getText(),
					Integer.parseInt(lbDate.getText()),
					Integer.parseInt(lbTime.getText())
					);
			MeetingScheduleManagement.addMeetingSchedule(newSchedule);
			
			SchListPane schList = new SchListPane();
			HomePane rootPane = new HomePane(new MainLeftPane(),schList);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
			
			
		}
			
	}
	
	class SaveRecordBtHandler implements EventHandler<ActionEvent>{
		private TextField lbTitle;
		private TextField lbDate;
		private TextField lbSpace;
		private TextField lbAgenda;
		private TextField lbDecided;
		private TextField lbnextTask;
		private TextField lbLeader;
		public SaveRecordBtHandler(TextField tt, TextField dt, TextField sp, TextField ag, TextField dc, TextField nt, TextField ld) {
			// TODO Auto-generated constructor stub
			this.lbTitle = tt;
			this.lbDate = dt;
			this.lbSpace = sp;
			this.lbAgenda = ag;
			this.lbDecided = dc;
			this.lbnextTask = nt;
			this.lbLeader = ld;
		}
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			MeetingRecord newRecord = new MeetingRecord(lbTitle.getText(),
												Integer.parseInt( lbDate.getText()),
												lbSpace.getText(),
												lbAgenda.getText(),
												lbDecided.getText(),
												lbnextTask.getText(),
												lbLeader.getText()
												);
			MeetingRecordManagement.addMeetingRecord(newRecord);
			
			RecordListPane recordList = new RecordListPane();
			HomePane rootPane = new HomePane(new MainLeftPane(),recordList);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
			
			
		}
			
	}
	
	

	public static void main(String[] args) {
		MemberManagement.initMemberManagement();
		TaskManagement.initTaskManagement();
		MeetingRecordManagement.initRecordManagement();
		MeetingScheduleManagement.initScheduleManagement();
		launch(args);
	}


class MainLeftPane extends VBox{
	public MainLeftPane() {
		showGUI();
	}
	void showGUI() {
		///MainScreen
		setSpacing(10);
		setPrefWidth(300);
		Button bttask = new Button("Task Management");
		Button btsch = new Button("MeetingScheduleManagement");
		Button btrec = new Button("Record Management");
		getChildren().addAll(bttask,btsch,btrec);

		bttask.setOnAction(new TaskBtHandler());
		btsch.setOnAction(new SchBtHandler());
		btrec.setOnAction(new RecordBtHandler());


	}
}//MainLeftPane


class TaskListPane extends FlowPane{
	public TaskListPane() {
		showGUI();
	}


	void showGUI() {
		
		
		setAlignment((Pos.TOP_LEFT));
		setPadding(new Insets(11.5, 12.5,13.5,14.5));
		setHgap(5.5);
		setVgap(5.5);

		int N = TaskManagement.getTaskList().size();// How many Tasks
		for(int i = 0 ; i < N; i ++) {
			GridPane grid = new GridPane();
			grid.setAlignment((Pos.TOP_CENTER	));
			grid.setPadding(new Insets(10,10,10,10));
			grid.setHgap(5.5);
			grid.setVgap(5.5);

			String title = TaskManagement.getTaskList().get(i).getTitle();
			String content = TaskManagement.getTaskList().get(i).getContent();

			grid.add(new Label("Title: "),0,0);
			grid.add(new Label(title),1,0);

			grid.add(new Label("conent: "),0,2);
			grid.add(new Label(content),1,2);

			getChildren().add(grid);
		}
		Button addBt = new Button("ADD");
		getChildren().add(0,addBt);
		addBt.setOnAction(new AddTaskBtHandler());
	}
}//TaskListPane

class SchListPane extends FlowPane{
	public SchListPane() {
		showGUI();
	}
	void showGUI() {
		int N = MeetingScheduleManagement.getScheduleList().size();// How many Calendars
		for(int i = 0 ; i < N; i ++) {
			GridPane grid = new GridPane();
			grid.setAlignment((Pos.TOP_CENTER	));
			grid.setPadding(new Insets(10,10,10,10));
			grid.setHgap(5.5);
			grid.setVgap(5.5);


			String title = MeetingScheduleManagement.getScheduleList().get(i).getTitle();
			int date =  MeetingScheduleManagement.getScheduleList().get(i).getDate();
			String content =  MeetingScheduleManagement.getScheduleList().get(i).getContent();
			String leader = MeetingScheduleManagement.getScheduleList().get(i).getLeader();
			int time =  MeetingScheduleManagement.getScheduleList().get(i).getTime();

			grid.add(new Label("Title: "),0,0);
			grid.add(new Label(title),1,0);

			grid.add(new Label("Date: "),0,1);
			grid.add(new Label(""+date),1,1);

			grid.add(new Label("conent: "),0,2);
			grid.add(new Label(content),1,2);

			grid.add(new Label("leader: "),0,3);
			grid.add(new Label(leader),1,3);

			grid.add(new Label("Time: "),0,4);
			grid.add(new Label(""+time),1,4);


			getChildren().add(grid);
		}
		Button addBt = new Button("ADD");
		getChildren().add(0,addBt);
		addBt.setOnAction(new AddSchBtHandler());
		
	}
}

class RecordListPane extends FlowPane{
	public RecordListPane() {
		showGUI();
	}
	void showGUI() {
		setAlignment((Pos.TOP_LEFT));
		setPadding(new Insets(11.5, 12.5,13.5,14.5));
		setHgap(5.5);
		setVgap(5.5);
		
		int N = MeetingRecordManagement.getRecordList().size();// How many Tasks
		for(int i = 0 ; i < N; i ++) {
			GridPane grid = new GridPane();
			grid.setAlignment((Pos.TOP_CENTER	));
			grid.setPadding(new Insets(10,10,10,10));
			grid.setHgap(5.5);
			grid.setVgap(5.5);

			String title = MeetingRecordManagement.getRecordList().get(i).getTitle();
			int Date = MeetingRecordManagement.getRecordList().get(i).getDate();
			String space = MeetingRecordManagement.getRecordList().get(i).getSpace();
			String agenda = MeetingRecordManagement.getRecordList().get(i).getAgenda();
			String decided = MeetingRecordManagement.getRecordList().get(i).getDecided();
			String nextTask = MeetingRecordManagement.getRecordList().get(i).getNextTast();
			String leader = MeetingRecordManagement.getRecordList().get(i).getMember();
			
			grid.add(new Label("Title: "),0,0);
			grid.add(new Label(title),1,0);

			grid.add(new Label("Date: "),0,1);
			grid.add(new Label(""+ Date),1,1);
			
			grid.add(new Label("Space: "),0,2);
			grid.add(new Label(""+ space),1,2);
			grid.add(new Label("Agenda: "),0,3);
			grid.add(new Label(""+ agenda),1,3);
			grid.add(new Label("Decided: "),0,4);
			grid.add(new Label(""+ decided),1,4);
			grid.add(new Label("nextTask: "),0,5);
			grid.add(new Label(""+ nextTask),1,5);
			grid.add(new Label("Leader: "),0,6);
			grid.add(new Label(""+ leader),1,6);
			
			
			
			getChildren().add(grid);
		}
		Button addBt = new Button("ADD");
		getChildren().add(0,addBt);
		addBt.setOnAction(new AddRecBtHandler());
	}
}//RecordListPane

class NewTaskPane extends GridPane{
	public NewTaskPane() {
		showGUI();
	}
	void showGUI(){
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

class NewRecordPane extends GridPane{
	public NewRecordPane() {
		showGUI();
	}
	void showGUI() {
		GridPane grid = new GridPane();
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


class NewSchedulePane extends GridPane{
	public NewSchedulePane() {
		showGUI();
	}
	
	void showGUI() {
		GridPane grid = new GridPane();
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



class HomePane extends HBox{
	public HomePane(Pane leftpane, Pane rightpane) {
		showGUI(leftpane, rightpane);
	}
	void showGUI(Pane leftpane, Pane rightpane){
		setSpacing(50);
		getChildren().addAll(leftpane,rightpane);
	}
}//HomePane


}

