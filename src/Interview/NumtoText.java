package Interview;

import java.util.Scanner;

public class NumtoText {
    static String[] text = {"hundred", "one","two","three","four","five","six","seven","eight","nine","thousand","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninty"};
    static String[] tens = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TextNum(scan.next());
    }
    public static void TextNum(String num){
        int check = Integer.parseInt(num);
        switch(num.length()){
            case 1:
                System.out.print(text[check]);
                break;
            case 2:
                if(check> 9 && check<20) {
                    System.out.print(tens[check-10]+" ");
                }
                else{
                    int dig = Integer.parseInt(num.charAt(0)+"");
                    System.out.print(text[(dig == 0) ? 0 : dig+10]+" ");
                    TextNum(num.substring(1));
                }
                break;
            case 3:
                int dig = Integer.parseInt(num.charAt(0)+"");
                System.out.print(text[dig]+" ");
                if(num.charAt(1) != '0'){
                    System.out.print(text[0]+" ");
                }
                TextNum(num.substring(1));
                break;
            case 4:
                System.out.println("one " + text[10]);
                break;

        }
        //return out;
    }
}
