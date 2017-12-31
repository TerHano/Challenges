package Interview.Registration;

import java.util.ArrayList;

public class UniClass {
    ArrayList<UniClass> PreReq = new ArrayList<>();
    private int MAX;
    private int classSize;
    String className;
    private ArrayList<Student> roster;
    UniClass(String className, int MAX){
        this.MAX = MAX;
        this.className = className;
        classSize = 0;
        roster = new ArrayList<>();
    }
    void printRoster(){
        System.out.print(this.className+" Roster -> | ");
        if(roster.isEmpty()){
            System.out.println("Empty |");
            return;
        }
        for(Student x: roster){
            System.out.print(x.name+" | ");
        }
        System.out.println();
    }
    void addPreReq(UniClass co){
        PreReq.add(co);
    }
    void addStudent(Student stu){
        if(!stu.prevCLasses.containsAll(this.PreReq)){
            System.out.println(stu.name+" does not have the necessary PreReqs to take this course");
            return;
        }
        if(this.roster.contains(stu)){
            System.out.println("Already in class");
            return;
        }
        if(this.classSize + 1 > this.MAX){
            System.out.println(this.className+" is full, " + stu.name + " was not added");
            return;
        }
        stu.getSchedule().add(this);
        this.roster.add(stu);
        System.out.println(this.className+" added to "+stu.name+"'s Schedule");
        this.classSize++;
    }
    void removeStudent(Student stu){
        if(!stu.getSchedule().contains(this)){
            System.out.println(stu.name+", you are not enrolled in that course");
            return;
        }
        this.roster.remove(stu);
        stu.getSchedule().remove(this);
        this.classSize--;
    }



}
