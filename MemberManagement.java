

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MemberManagement{
	static List<User> members = new ArrayList<User>();

	//        public MemberManagement(){
	//            members.add(dummy);
	//        }

	public void signIn(String id, String pw, String name, int age){
		//members.add
		User temp = new User(id, pw, name, age);
		members.add(temp);
		//ID 중복 처리
	}
	public static User logIn(String id, String pw){

		for(int i=0; i<members.size(); i++){
			User checkUser = members.get(i);
			if(checkUser.getID().compareTo(id)==0){
				if(checkUser.getPW().compareTo(pw)==0){
					return checkUser;
				}
			}
		}
		return null;

		//            Iterator<User> itr  = members.iterator();

		//            while(itr.hasNext()){
		//                User checkUser = itr.next();
		//
		//                if(checkUser.getID().compareTo(id)==0){
		//
		//                    if(checkUser.getPW().compareTo(pw)==0) {  System.out.println("test???");return checkUser;}
		//                }
		//            }
		//            return null;
	}

	public static void initMemberManagement() {
		User dummy = new User("liam","00", "hi", 14);
		members.add(dummy);

		members.add(new User("dum","11","bye",10));
	}
} 

class User{
	private String id;
	private String pw;
	private String name;
	private int age;

	public User(String id, String pw, String name, int age){
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
	}

	public void setPW(String pw){
	}
	public void setName(String name){
	}
	public void setAge(int age){}

	public String getID(){return id;}
	public String getPW(){return pw;}
	public String getName(){return name;}
	public int getAge(){return age;}

}