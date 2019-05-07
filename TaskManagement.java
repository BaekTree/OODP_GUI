

import java.util.ArrayList;

public class TaskManagement{
	static ArrayList<MainTask> mainTasks = new ArrayList<MainTask>();

	
	public static ArrayList<MainTask> getTaskList(){
		return mainTasks;
	}
	
	public static void initTaskManagement() {
		MainTask dumdum = new MainTask("convention", "codingtalk");
		mainTasks.add(dumdum);
	}
	public static void addMainTask(MainTask task) {
		mainTasks.add(task);
	}
	
} 

class MainTask{
	private String title;
	private String content;


	public MainTask(String title, String content){
		this.title = title;
		this.content = content;
	}

	public void setTitle(String title){}
	public void setNextTask(String content){}

	public String getTitle(){return title;}
	public String getContent() {return content;}
}

