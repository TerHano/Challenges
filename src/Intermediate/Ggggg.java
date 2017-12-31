package Intermediate;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Ggggg {
    static HashMap<String, String> key = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Encode or Decode?(e/d)");
        String answer = scan.nextLine();
        if (answer.equals("d")) {
            System.out.println("Enter key");
            //String keyLine = scan.nextLine();
            String keyLine = "a gGGggg r GGgGGg d gggGgG e ggGGg u GgGgGGG w GGGggg g GGggGG h ggggGg y GggGG i gGGGgg n gGgggg o gGgGGG ";
            System.out.println("Enter message");
            //String message = scan.nextLine();
            String message = "ggggGggGgGGGGGGggg gGGgggGGgGGgggGGg GggGGgGgGGGGgGgGGG gggGgGgGgGGGgGGGgggGggggGGggGG";
            String[] temp = keyLine.split(" ");
            for (int i = 0; i < temp.length; i += 2) {
                key.put(temp[i + 1], temp[i]);
            }
            String result = decode(message);
            System.out.println(result);
        } else {
            System.out.println("Enter message");
            String message = scan.nextLine();
            String result = encode(message);
            for (String x : key.keySet()) {
                System.out.print(x + " ");
                System.out.print(key.get(x) + " ");
            }
            System.out.println("\n" + result);
        }
    }

    public static String decode(String message) {
        StringBuilder decodedMessage = new StringBuilder();
        String letter = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (key.containsKey(letter)) {
                decodedMessage.append(key.get(letter));
                letter = "";
                i--;
            } else {
                if (!Character.isLetter(ch)) {
                    decodedMessage.append(ch);
                } else {
                    letter += ch;
                }
            }
        }
        if (key.containsKey(letter)) {
            decodedMessage.append(key.get(letter));
        }
        return String.valueOf(decodedMessage);
    }

    public static String encode(String message) {
        StringBuilder encodedMessage = new StringBuilder();
        int length = 3;
        int check = 3;
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (!Character.isLetter(ch)) {
                encodedMessage.append(ch + "");
            } else {
                if (!key.containsKey(ch + "")) {
                    StringBuilder en = new StringBuilder();
                    Random ran = new Random();
                    //int length = (ran.nextInt(4) + 4);
                    if(key.size()>factorial(check)){
                        check++;
                        length++;
                    }
                    for (int j = 0; j < length; j++) {
                        int g = ran.nextInt(2);
                        en.append((g == 1) ? "G" : "g");
                        if(en.length()>=check) {
                            for (String x : key.values()) {
                                boolean a = x.matches("^"+en.toString());
                                boolean b = x.matches("^"+en.toString()+"\\w+");
                                boolean c = en.toString().matches("^"+x+"\\w+");
                                boolean d = en.toString().matches("^"+x);
                                if ((a||b||c||d))
                                {
                                    en = new StringBuilder();
                                    j = -1;
                                    break;
                                }
                            }
                        }
                    }
                    key.put(ch + "", String.valueOf(en));
                    //encodedMessage.append(key.get(ch + ""));
                }
                    encodedMessage.append(key.get(ch+""));

            }
        }
        return String.valueOf(encodedMessage);
    }
public static int factorial(int n) {
    if (n == 1) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}
}
