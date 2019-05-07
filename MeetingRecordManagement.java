

import java.util.ArrayList;

public class MeetingRecordManagement{
	static ArrayList<MeetingRecord> meetings = new ArrayList<MeetingRecord>();

//	public MeetingRecordManagement(){
//		meetings.add(dumdum);
//	}
	public static ArrayList<MeetingRecord> getRecordList(){
		return meetings;
	}
	
	public static void initRecordManagement() {
		MeetingRecord dumdum = new MeetingRecord("convention", 20190501, "codingtalk", "topic","none","none","none");
		meetings.add(dumdum);
	}
	public static void addMeetingRecord(MeetingRecord record) {
		meetings.add(record);
	}
	
} 

class MeetingRecord{
	private String title;
	private int date;
	private String space;
	private String agenda;
	private String decided;
	private String nextTask;
	private String leader;


	public MeetingRecord(String title, int date, String space, String agenda, String decided, String nextTask, String leader){
		this.title = title;
		this.date = date;
		this.space = space;
		this.agenda = agenda;
		this.decided = decided;
		this.nextTask = nextTask;
		this.leader = leader;
	}

	public void setTitle(String title){}
	public void setDate(int date){}
	public void setSpace(String space){}
	public void setAgenda(String agenda){}
	public void setDecided(String decided){}
	public void setNextTask(String nextTask){}
	public void setMember(String leader) {}


	public String getTitle(){return title;}
	public int getDate(){return date;}
	public String getSpace(){return space;}
	public String getAgenda(){return agenda;}
	public String getDecided() {return decided;}
	public String getNextTast() {return nextTask;}
	public String getMember() {return leader;}
}