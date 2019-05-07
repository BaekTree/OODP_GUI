

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
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

public class Login_bt_sep extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception{
		GridPane grid = new GridPane();
		grid.setAlignment((Pos.CENTER));
		grid.setPadding(new Insets(11.5, 12.5,13.5,14.5));
		grid.setHgap(5.5);
		grid.setVgap(5.5);

		Button btEnt = new Button("Enter");
		TextField lbID = new TextField();
		TextField lbPW = new TextField();
		grid.add(new Label("ID"),0,1);
		grid.add(lbID,1,1);
		grid.add(new Label("PW"),0,2);
		grid.add(lbPW,1,2);
		grid.add(btEnt,0,3);


		btEnt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {	//btEnt Hander

				String id = lbID.getText();
				String pw = lbPW.getText();
				//				System.out.println(id + pw);

				if ( !(MemberManagement.logIn(id,pw) instanceof User )) {	//if the id and pw not matched
					grid.add(new Label("fail. Try again!"),0,0);//System.out.println("fail!");
					lbID.clear();
					lbPW.clear();

				}


				else {	//when id and pw matched


					///MainScreen
					VBox leftPan = new VBox();
					leftPan.setSpacing(10);
					leftPan.setPrefWidth(300);
					Button bttask = new Button("Task Management");
					Button btcal = new Button("MeetingScheduleManagement");
					Button btrec = new Button("Record Management");
					leftPan.getChildren().addAll(bttask,btcal,btrec);

					VBox rightPan = new VBox(new Label("Welcome!"));

					//Buttons for new record
					btrec.setOnAction(new EventHandler<ActionEvent>(){	//record management button setOnAction method
						@Override
						public void handle(ActionEvent event) {	//record menagement button handler

							HBox rootPane = new HBox();
							rootPane.setSpacing(50);
							rootPane.getChildren().add(leftPan);

							Button addBt = new Button("ADD");
							rootPane.getChildren().add(1, addBt);;



							// print out datas.
							int N = MeetingRecordManagement.getRecordList().size();	//how many datas?
							for(int i = 0 ; i < N; i ++) {
								GridPane grid = new GridPane();
								grid.setAlignment((Pos.TOP_CENTER	));
								grid.setPadding(new Insets(10,10,10,10));
								grid.setHgap(5.5);
								grid.setVgap(5.5);


								String title = MeetingRecordManagement.getRecordList().get(i).getTitle();
								int date = MeetingRecordManagement.getRecordList().get(i).getDate();
								String space = MeetingRecordManagement.getRecordList().get(i).getSpace();
								String member = MeetingRecordManagement.getRecordList().get(i).getMember();
								String agenda = MeetingRecordManagement.getRecordList().get(i).getAgenda();
								String decided = MeetingRecordManagement.getRecordList().get(i).getDecided();
								String nextTask = MeetingRecordManagement.getRecordList().get(i).getNextTast();
								grid.add(new Label("Title: "),0,0);
								grid.add(new Label(title),1,0);

								grid.add(new Label("Date: "),0,1);
								grid.add(new Label(""+date),1,1);

								grid.add(new Label("Space: "),0,2);
								grid.add(new Label(space),1,2);

								grid.add(new Label("Member: "),0,3);
								grid.add(new Label(member),1,3);

								grid.add(new Label("Agenda: "),0,4);
								grid.add(new Label(agenda),1,4);

								grid.add(new Label("Decided: "),0,5);
								grid.add(new Label(decided),1,5);

								grid.add(new Label("Next Task: "),0,6);
								grid.add(new Label(nextTask),1,6);


								rootPane.getChildren().add(grid);


							}



							addBt.setOnAction(new EventHandler<ActionEvent>(){	//add button set on action

								@Override
								public void handle(ActionEvent event) {	//add button handler
									// TODO Auto-generated method stub
									GridPane grid = new GridPane();
									grid.setAlignment((Pos.TOP_CENTER));
									grid.setPadding(new Insets(10,10,10,10));
									grid.setHgap(5.5);
									grid.setVgap(5.5);

									TextField lbTitle = new TextField();
									TextField lbDate = new TextField();
									TextField lbSpace = new TextField();
									TextField lbAgenda = new TextField();
									TextField lbDecided = new TextField();
									TextField lbnextTask = new TextField();
									TextField lbLeader = new TextField();

									grid.add(new Label("title"),0,1);
									grid.add(lbTitle, 1,1);
									grid.add(new Label("date"),0,2);
									grid.add(lbDate, 1,2);
									grid.add(new Label("space"),0,3);
									grid.add(lbSpace, 1,3);
									grid.add(new Label("agenda"),0,4);
									grid.add(lbAgenda, 1,4);
									grid.add(new Label("decided"),0,5);
									grid.add(lbDecided, 1,5);
									grid.add(new Label("nextTask"),0,6);
									grid.add(lbnextTask, 1,6);
									grid.add(new Label("leader"),0,7);
									grid.add(lbLeader, 1,7);


									Button saveBt = new Button("save");
									Button restBt = new Button("Reset");


									saveBt.setOnAction(new EventHandler<ActionEvent>(){	//save button set on action
										@Override
										public void handle(ActionEvent event) {	//save button handler
											// TODO Auto-generated method stub
											MeetingRecord newRecord = new MeetingRecord(lbTitle.getText(),
													Integer.parseInt(lbDate.getText()),
													lbSpace.getText(), 
													lbAgenda.getText(),
													lbDecided.getText(),
													lbnextTask.getText(),
													lbLeader.getText()
													);
											MeetingRecordManagement.addMeetingRecord(newRecord);
										}//save buttons handler
									});//save buttons set on actions




									HBox rootPane = new HBox();
									rootPane.setSpacing(50);
									rootPane.getChildren().addAll(leftPan,grid,saveBt);

									Scene scene = new Scene(rootPane,700,700);
									primaryStage.setScene(scene);
								}//addBt handlers

							});//add buttons set on action buttons







							Scene scene = new Scene(rootPane,700,700);
							primaryStage.setScene(scene);
						}//record buttons handler


					});//record buttons setOnAction method







					//buttons for new ones.
					btcal.setOnAction(new EventHandler<ActionEvent>(){
						@Override
						public void handle(ActionEvent event) {
							FlowPane flow = new FlowPane();
							flow.setAlignment((Pos.TOP_LEFT));
							flow.setPadding(new Insets(11.5, 12.5,13.5,14.5));
							flow.setHgap(5.5);
							flow.setVgap(5.5);



							HBox rootPane = new HBox();
							rootPane.setSpacing(50);
							rootPane.getChildren().add(leftPan);

							Button addBt = new Button("ADD");
							rootPane.getChildren().add(1, addBt);;


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


								rootPane.getChildren().add(grid);


							}
							addBt.setOnAction(new EventHandler<ActionEvent>(){

								@Override
								public void handle(ActionEvent event) {
									// TODO Auto-generated method stub
									GridPane grid = new GridPane();
									grid.setAlignment((Pos.TOP_CENTER));
									grid.setPadding(new Insets(10,10,10,10));
									grid.setHgap(5.5);
									grid.setVgap(5.5);

									TextField lbTitle = new TextField();
									TextField lbDate = new TextField();
									TextField lbLeader = new TextField();
									TextField lbContent = new TextField();
									TextField lbTime = new TextField();


									grid.add(new Label("title"),0,1);
									grid.add(lbTitle, 1,1);
									grid.add(new Label("date"),0,2);
									grid.add(lbDate, 1,2);
									grid.add(new Label("Content"),0,3);
									grid.add(lbContent, 1,3);
									grid.add(new Label("leader"),0,4);
									grid.add(lbLeader, 1,4);
									grid.add(new Label("Time"),0,5);
									grid.add(lbTime, 1,5);




									Button saveBt = new Button("save");
									Button restBt = new Button("Reset");


									saveBt.setOnAction(new EventHandler<ActionEvent>(){


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
										}
									});




									HBox rootPane = new HBox();
									rootPane.setSpacing(50);
									rootPane.getChildren().addAll(leftPan,grid,saveBt);

									Scene scene = new Scene(rootPane,700,700);
									primaryStage.setScene(scene);
								}//addBt handlers

							});//add buttons


							Scene scene = new Scene(rootPane,700,700);
							primaryStage.setScene(scene);
						}//handlers

					});////new buttons . schedule?





					//Buttons for new Task
					bttask.setOnAction(new EventHandler<ActionEvent>(){
						@Override
						public void handle(ActionEvent event) {
							FlowPane flow = new FlowPane();
							flow.setAlignment((Pos.TOP_LEFT));
							flow.setPadding(new Insets(11.5, 12.5,13.5,14.5));
							flow.setHgap(5.5);
							flow.setVgap(5.5);



							HBox rootPane = new HBox();
							rootPane.setSpacing(50);
							rootPane.getChildren().add(leftPan);

							Button addBt = new Button("ADD");
							rootPane.getChildren().add(1, addBt);;


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



								rootPane.getChildren().add(grid);


							}


							addBt.setOnAction(new EventHandler<ActionEvent>(){

								@Override
								public void handle(ActionEvent event) {
									// TODO Auto-generated method stub
									GridPane grid = new GridPane();
									grid.setAlignment((Pos.TOP_CENTER));
									grid.setPadding(new Insets(10,10,10,10));
									grid.setHgap(5.5);
									grid.setVgap(5.5);

									TextField lbTitle = new TextField();
									TextField lbContent = new TextField();									

									grid.add(new Label("title"),0,1);
									grid.add(lbTitle, 1,1);
									grid.add(new Label("Content"),0,2);
									grid.add(lbContent, 1,2);




									Button saveBt = new Button("save");
									Button restBt = new Button("Reset");


									saveBt.setOnAction(new EventHandler<ActionEvent>(){


										@Override
										public void handle(ActionEvent event) {
											// TODO Auto-generated method stub
											MainTask newMainTask = new MainTask(lbTitle.getText(),
													lbContent.getText()
													);
											TaskManagement.addMainTask(newMainTask);
										}
									});

									HBox rootPane = new HBox();
									rootPane.setSpacing(50);
									rootPane.getChildren().addAll(leftPan,grid,saveBt);

									Scene scene = new Scene(rootPane,700,700);
									primaryStage.setScene(scene);
								}//addBt handlers

							});//addBt buttons;




							Scene scene = new Scene(rootPane,700,700);
							primaryStage.setScene(scene);
						}//task buttons handlers

					});//Task buttons ends



					// Scene rightScene = new Scene(rightPan, 200, 200);

					HBox rootPane = new HBox();
					rootPane.setSpacing(50);
					rootPane.getChildren().addAll(leftPan,rightPan);

					Scene scene = new Scene(rootPane,700,700);



					//MainWelcom ��
					//                Scene scene2 = new Scene(grid);
					primaryStage.setTitle("Login");
					primaryStage.setScene(scene);



				}

			}//btEnt Hander
		});


		Scene scene = new Scene(grid);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}





	public static void main(String[] args) {
		MemberManagement.initMemberManagement();
		TaskManagement.initTaskManagement();
		MeetingRecordManagement.initRecordManagement();
		MeetingScheduleManagement.initScheduleManagement();
		launch(args);
	}


}