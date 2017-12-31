package Interview.Registration;

import java.util.Scanner;

public class UniCLassDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UniClass Calc = new UniClass("Calculus",3);
        UniClass CS = new UniClass("Intro to Prog",200);
        UniClass intro = new UniClass("110",20);
        CS.addPreReq(intro);
        Student Terry = new Student("Terry",158008606);
        Student Yusuf = new Student("Yusuf",43432424);
        Student Darsh = new Student("Darsh",2131312);
        Terry.prevCLasses.add(intro);
        Calc.addStudent(Terry);
        Terry.printSchedule();
        CS.addStudent(Terry);
        Terry.printSchedule();
        Calc.addStudent(Yusuf);
      //  Yusuf.addClass(Calc);
        CS.printRoster();
        CS.addStudent(Yusuf);
        //Yusuf.addClass(CS);
        CS.printRoster();
        //Darsh.addClass(Calc);
        Calc.addStudent(Darsh);
        Calc.printRoster();
        Calc.removeStudent(Darsh);
        Calc.printRoster();
        System.out.println("Enter ID of student to look up");
        int find  = scan.nextInt();
        System.out.println((Student.LookUp(find) !=null) ? "Found "+Student.LookUp(find) : "Student does not exist");

    }
}
