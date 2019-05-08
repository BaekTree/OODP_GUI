package pattern_Init;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


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

		bttask.setOnAction(new TaskMainBtHandler());
		btsch.setOnAction(new SchMainBtHandler());
		btrec.setOnAction(new RecordMainBtHandler());


	}
}//MainLeftPane






class HomePane extends HBox{
	public HomePane(Pane leftpane, Pane rightpane) {
		showGUI(leftpane, rightpane);
	}
	void showGUI(Pane leftpane, Pane rightpane){
		setSpacing(50);
		getChildren().addAll(leftpane,rightpane);
	}
}//HomePane
