package Interview.Registration;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private static HashMap<Integer,String> StudentLog = new HashMap<>();
    String name;
    private int ID;
    private ArrayList<UniClass> Schedule;
    ArrayList<UniClass> prevCLasses = new ArrayList<>();
    Student(String name,int ID){
        StudentLog.put(ID,name);
        Schedule = new ArrayList<>();
        this.name = name;
        this.ID = ID;
    }
    static String LookUp(int ID){
        if(!StudentLog.containsKey(ID)){
            return null;
        }
        return StudentLog.get(ID);
    }
    void printSchedule(){
        if(Schedule.isEmpty()){
            System.out.println("No classes");
            return;
        }
        System.out.print(this.name +"'s Schedule -> | ");
        for(UniClass temp: Schedule){
            System.out.print(temp.className+" | ");
        }
        System.out.println();
    }
    void removeStudent(){
        StudentLog.remove(this.ID);
    }
    ArrayList<UniClass> getSchedule(){
        return Schedule;
    }

}
