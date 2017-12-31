package Easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Created by terryhanoman on 7/1/17.
 */
public class RackManage_Easy implements Runnable{
    private static HashMap<Integer,ArrayList<String>> English= new HashMap<>();

    private static double count = 0;
    public void run() {
        System.out.println("Building database");
        Scanner scan = null;
        try {
            scan = new Scanner(new File("Englishwords.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while(scan.hasNext()){
            count++;
            String line =scan.next();
            if((English.containsKey(line.length())&&(!English.get(line.length()).contains(line)))){
                English.get(line.length()).add(line);
            }
            else{
                ArrayList<String> temp = new ArrayList<>();
                temp.add(line);
                English.put(line.length(),temp);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread database = new Thread((new RackManage_Easy()));

        //Scanner sca = new Scanner(System.in);
        database.start();
       // System.out.print("Processing: ");
        while(database.isAlive()){
            Thread.sleep(1000);
            System.out.print((int)(Math.floor((count/172820)*100))+"% ");
        }
        System.out.println();
        System.out.println("Database done\nResults:");
        database.join();
        System.out.println(Scrabble("piizza?","pizzazz"));
        System.out.println(Longest("uruqrnytrois"));
        System.out.println(Longest("dcthoyueorza"));
        System.out.println(Longest("rryqeiaegicgeo??") );
        System.out.println(Longest("udosjanyuiuebr??") );
        System.out.println(Longest("vaakojeaietg????????") );
        System.out.println(Highest("vaakojeaietg????????"));

    }
    public static boolean Scrabble(String scatter, String word){
        if (scatter.length() != word.length()){
            return false;
        }
        for(int i = 0;i<word.length();i++){
            if(scatter.contains(word.charAt(i)+"")){
                scatter = scatter.replaceFirst(word.charAt(i)+"","");
            }
            else{
                if(scatter.contains("?")){
                    scatter = scatter.replaceFirst("\\?","");
                }
                else{
                    return false;
                }
            }

        }
        return false;
    }
    public static String Longest(String word){
        String q = "";
        int length = word.length();
        while (length > 1) {
            nextword:
            for (String text : English.get(length)) {
                String test  = word;
                for(int i = 0;i<text.length();i++){
                    if(test.contains(text.charAt(i)+"")){
                        test = test.replaceFirst(text.charAt(i)+"","");
                    }
                    else
                    if(test.contains("?")){
                        test = test.replaceFirst("\\?","");
                    }
                    else{
                        continue nextword;
                    }
                }
                if(text.length()>q.length()) {
                    q = text;
                    return q;
                }
            }
            --length;
        }
        return q;
    }
    public static String Highest(String word){
        String q = "";
        int points = 0;
        int length = word.length();
        while (length > 1) {
            nextword:
            for (String text : English.get(length)) {
                String test  = word;
                int total = 0;
                for(int i = 0;i<text.length();i++){
                    if(test.contains(text.charAt(i)+"")){
                        total += points(Character.toUpperCase(text.charAt(i)));
                        test = test.replaceFirst(text.charAt(i)+"","");
                    }
                    else
                    if(test.contains("?")){
                        test = test.replaceFirst("\\?","");
                    }
                    else{
                        continue nextword;
                    }
                }
                if(total>points) {
                    q = text;
                    points = total;
                }
                if(length == word.length()/2){
                    return q;
                }
            }
            --length;
        }
        return q;
    }
    public static int points(char word){
        //int total = 0;
            switch (word){
                case 'E':
                case 'A':
                case 'I':
                case 'O':
                case 'N':
                case 'R':
                case 'T':
                case 'L':
                case 'S':
                case 'U':
                    return 1;
                case 'D':
                case 'G':
                   return 2;
                case 'B':
                case 'C':
                case 'M':
                case 'P':
                   return 3;
                case 'F':
                case 'H':
                case 'V':
                case 'W':
                case 'Y':
                   return 4;
                case 'K':
                    return 5;
                case 'J':
                case 'X':
                    return 8;
                case 'Q':
                case 'Z':
                   return 10;
                case'?':
                    return 0;

            }
            return 100000;
    }

}
