package pattern_Init;


import java.util.ArrayList;

public class MeetingScheduleManagement{
	static ArrayList<MeetingSchedule> schedules = new ArrayList<MeetingSchedule>();

//	public MeetingScheduleManagement(){
//		schedules.add(dumdumdum);
//	}
	
	public static ArrayList<MeetingSchedule> getScheduleList(){
		return schedules;
	}
	
	public static void initScheduleManagement() {
		MeetingSchedule dumdumdum = new MeetingSchedule("schedule","recording","none",20190501,10);
		schedules.add(dumdumdum);
	}
	public static void addMeetingSchedule(MeetingSchedule schedule) {
		schedules.add(schedule);
	}
	
} 

class MeetingSchedule{
	private String title;
	private String content;
	private String leader;
	private int date;
	private int time;


	public MeetingSchedule(String title, String content, String leader, int date, int time){
		this.title = title;
		this.content = content;
		this.leader =  leader;
		this.date = date;
		this.time = time;
	}


	public String getTitle(){return title;}
	public String getContent(){return content;}
	public String getLeader() {return leader;}
	public int getDate() {return date;}
	public int getTime() {return time;}


}