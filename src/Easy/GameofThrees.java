package Easy; /**
 * Created by terryhanoman on 6/3/17.
 */
import java.util.*;
public class GameofThrees {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter number");
        int number = scan.nextInt();
        Threes(number);
    }
    public static void Threes(int n)
    {
        if(n == 1)
        {
            System.out.println(n);
        }
        else
        {
            if(n%3 == 0)
            {
                System.out.println(n + " 0");
                Threes(n/3);
            }
            else
            {
                if((n+1)%3 == 0)
                {
                    System.out.println(n + " 1");
                    Threes((n+1)/3);
                }
                else
                {
                    System.out.println(n + " -1");
                    Threes((n-1)/3);
                }
            }
        }
    }
}
