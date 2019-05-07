package pattern_Init;


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

public class Login_v2 extends Application{
	private static Stage window;
	private static Scene scene;
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		LoginPane login = new LoginPane();
		scene = new Scene(login);

		window.setTitle("TeamWork");
		window.setScene(scene);
		window.show();
	}



	public static void main(String[] args) {
		MemberManagement.initMemberManagement();
		TaskManagement.initTaskManagement();
		MeetingRecordManagement.initRecordManagement();
		MeetingScheduleManagement.initScheduleManagement();
		launch(args);
	}
	
	public static Stage getStage() {
		return window;
	}
	
	public static Scene getScene() {
		return scene;
	}
	
}
