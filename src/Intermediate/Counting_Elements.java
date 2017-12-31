package Intermediate;

import java.util.*;

/**
 * Created by terryhanoman on 7/20/17.
 */
public class Counting_Elements {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter element");
        String userElement = scan.nextLine();
        HashMap<String,Element> result = Count(userElement);
        for(Element e: result.values()){
            System.out.println(e.name+": "+e.am);
        }
    }
    /**
     *
     * @param line The user-inputted Elements to count
     * @return Hashmap containing elements
     */
    public static HashMap<String, Element> Count(String line){
        int bracket = 0;
        HashMap<String, Element> list = new HashMap<>();
        boolean track = false;
        String name = "";
        String amount = "";
        for(int i = 0; i<line.length();i++){
            char ch = line.charAt(i);
            if(ch == '('){
                if(!name.equals("")) {
                    if (list.containsKey(name)) {
                        list.get(name).am += (amount.equals("")) ? 1 : Integer.parseInt(amount);
                    } else {
                        list.put(name, new Element(name, (amount.equals("")) ? 1 : Integer.parseInt(amount)));
                    }
                }
                bracket = i;
                track = true;
            }
            if(ch == ')')
            {
                name = "";
                track = false;
                continue;
            }
            if(track){
                continue;
            }
            if(Character.isDigit(ch)){
                if (line.charAt(i-1) == ')') {
                    HashMap<String,Element> temp = Count(line.substring(bracket+1,i-1));
                    for(String x: temp.keySet()){
                        temp.get(x).am = temp.get(x).am*(Integer.parseInt(ch+""));
                        if(list.containsKey(x)){
                            list.get(x).am = list.get(x).am += temp.get(x).am;
                        }
                        else{
                            list.put(x,temp.get(x));
                        }

                    }
                }
                else{
                    amount += ch+"";
                }
            }
            else {
                if (((ch == Character.toUpperCase(ch)) && name.equals("")) || ch == Character.toLowerCase(ch)) {
                    name += ch + "";
                }
                else{
                        if(list.containsKey(name)){
                            list.get(name).am += (amount.equals("")) ? 1 : Integer.parseInt(amount);
                        }
                        else{
                            list.put(name,new Element(name,(amount.equals("")) ? 1 : Integer.parseInt(amount)));
                        }
                        name = "";
                        amount = "";
                        i--;
                }
            }


        }
        if(!name.equals("")) {
            if (list.containsKey(name)) {
                list.get(name).am += (amount.equals("")) ? 1 : Integer.parseInt(amount);
            } else {
                list.put(name, new Element(name, (amount.equals("")) ? 1 : Integer.parseInt(amount)));
            }
        }
        return list;
    }
    public static void MultiplyEle(Map<String, Element> list,ArrayList<String> names, int multiple){
        for(String x: names){
            list.get(x).am = list.get(x).am * multiple;
        }
    }

}
 class Element{
    String name;
    int am;

     /**
      *
      * @param name The name of the element
      * @param am The amount of the element
      */
    public Element(String name, int am){
        this.name = name;
        this.am = am;
    }
}
