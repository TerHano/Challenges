package Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class PathtoPhilosophy {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("Enter word");
        String l = scan.nextLine();
        Path(l);

    }
    public static void Path(String word) throws IOException {
        URL temp = new URL("www.google.com");
       // URLConnection connect = temp.openConnection();
        BufferedReader read = new BufferedReader(new InputStreamReader(temp.openStream()));
        String now;
        String page = "";
        while((now = read.readLine())!=null){
          //  page += now;
            System.out.println(now);
        }


    }
}
