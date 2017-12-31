package Easy;

import java.util.HashMap;
import java.util.Scanner;

public class FirstRecurringCharacter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            System.out.println("Enter String");
            String line = scan.next();
            HashMap<Character, Integer> list = new HashMap<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (list.containsKey(c)) {
                    System.out.println("First recurring character is " + c + " at index " + i + " with the first occurrence at index " + list.get(c));
                    return;
                }
                list.put(c, i);
            }
            System.out.println("String contains no recurring characters");
    }
}
