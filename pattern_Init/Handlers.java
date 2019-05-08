package pattern_Init;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


	abstract class Handler implements EventHandler<ActionEvent>{
		protected Scene scene = Login_v2.getScene();	//���⼭ ��°�� �ҷ��ͼ� �ڽĵ鿡�� �� ������ش�. 
		protected Stage window = Login_v2.getStage();
		@Override
		public abstract void handle(ActionEvent event);
	}


	class EntBtHandler extends Handler {
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



	class TaskBtHandler extends Handler{

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

	class SchBtHandler extends Handler{
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

	class RecordBtHandler extends Handler{
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



	class AddTaskBtHandler extends Handler{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			NewTaskPane textListPane = new NewTaskPane();

			HomePane rootPane = new HomePane(new MainLeftPane(),textListPane);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}

	}

	class AddSchBtHandler extends Handler{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			NewSchedulePane SchListPane = new NewSchedulePane();

			HomePane rootPane = new HomePane(new MainLeftPane(),SchListPane);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}

	}

	class AddRecBtHandler extends Handler{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			NewRecordPane RecListPane = new NewRecordPane();

			HomePane rootPane = new HomePane(new MainLeftPane(),RecListPane);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}

	}



	class SaveTaskBtHandler extends Handler{
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

	class SaveSchBtHandler extends Handler{
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

	class SaveRecordBtHandler extends Handler{
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

	class TaskSpecificHandler extends Handler{
		private int index;
		public TaskSpecificHandler(int i){
			this.index = i;
		}
		@Override
		public void handle(ActionEvent event){
			TaskPane taskPane = new TaskPane(index);
			HomePane rootPane = new HomePane(new MainLeftPane(),taskPane);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}
	}

	class RecordSpecificHandler extends Handler{
		private int index;
		public RecordSpecificHandler(int i){
			this.index = i;
		}
		@Override
		public void handle(ActionEvent event){
			RecordPane recordPane = new RecordPane(index);
			HomePane rootPane = new HomePane(new MainLeftPane(),recordPane);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}
	}

	class SchSpecificHandler extends Handler{
		private int index;
		public SchSpecificHandler(int i){
			this.index = i;
		}
		@Override
		public void handle(ActionEvent event){
			SchPane schPane = new SchPane(index);
			HomePane rootPane = new HomePane(new MainLeftPane(),schPane);
			scene = new Scene(rootPane,1000,400);
			window.setScene(scene);
		}
	}
