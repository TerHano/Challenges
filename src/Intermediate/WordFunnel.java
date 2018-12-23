package Intermediate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordFunnel {
    private static HashMap<Integer, ArrayList<String>> English = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            scan = new Scanner(new File("Englishwords.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File doesnt exist");
            e.printStackTrace();
            System.exit(1);
        }
        while (scan.hasNext()) {
            String line = scan.next();
            if ((English.containsKey(line.length()) && (!English.get(line.length()).contains(line)))) {
                English.get(line.length()).add(line);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(line);
                English.put(line.length(), temp);
            }
        }
        System.out.println(FunnelDriver("gnash"));
        System.out.println(FunnelDriver("princesses"));
        System.out.println(FunnelDriver("turntables"));
        System.out.println(FunnelDriver("implosive"));
        System.out.println(FunnelDriver("programmer"));
    }

    private static boolean isRealWord(String x) {
        if (!English.containsKey(x.length())) return false;
        for (String word : English.get(x.length())) {
            if (x.equals(word)) {
                return true;
            }
        }
        return false;
    }

    private static int Funnel(String word, HashMap<String,Integer> memo) {
        if (word.equals("")) {
            return 0;
        }
        if(memo.containsKey(word)){
            return memo.get(word);
        }
        int max = 0;
        boolean wordlevel = false;
        for (int i = 0; i < word.length(); i++) {
            int count = 0;
            StringBuilder t = new StringBuilder(word);
            t.deleteCharAt(i);
            count = Funnel(t.toString(),memo);
            if(isRealWord(word)) {
                wordlevel = true;
                count++;
                if(!memo.containsKey(word)) {
                    //System.out.println(word);
                }
            }
            if (count > max) max = count;
        }
        if(!wordlevel){
            max = 0;
        }
        if(!memo.containsKey(word)){
            memo.put(word,max);
        }
        return max;
    }

    private static int FunnelDriver(String word){
        return Funnel(word, new HashMap<String,Integer>());
    }
}
