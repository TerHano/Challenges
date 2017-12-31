package Intermediate;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by terryhanoman on 7/21/17.
 */
public class War {
    static Queue<Integer> playerDeck = new LinkedList<>();
    static Queue<Integer> OppDeck = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       // System.out.println("Enter P1 deck");
        //String deck = scan.nextLine();
        String deck = "1 2 3 4 5 6 7 8 9 10 11 12 13 3 2 1 4 5 6 7 8 9 10 11 12 13";
        for(String x: deck.split(" ")){
            playerDeck.add(Integer.parseInt(x));
        }
     //   System.out.println("Enter P2 deck");
        //deck = scan.nextLine();
        deck = "13 2 3 4 5 6 7 8 9 10 11 12 13 1 2 3 4 5 6 7 8 9 10 11 12 1";
        for(String x: deck.split(" ")){
            OppDeck.add(Integer.parseInt(x));
        }
        while(!playerDeck.isEmpty() && !OppDeck.isEmpty()){
            int player = playerDeck.poll();
            int Opp = OppDeck.poll();
            if(player == Opp){
                    int result = warTime();
                    if (result == 1) {
                        playerDeck.add(player);
                        playerDeck.add(Opp);
                    } else if(result == 0) {
                        OppDeck.add(player);
                        OppDeck.add(Opp);
                    }
                    else{
                        break;
                    }
            }
            else {
                if (player > Opp) {
                    playerDeck.add(player);
                    playerDeck.add(Opp);
                }
                else
                {
                    OppDeck.add(Opp);
                    OppDeck.add(player);
                }
            }


        }
        if(playerDeck.isEmpty() && OppDeck.isEmpty()){
            System.out.println("Tie");
        }
        else{
            if (!playerDeck.isEmpty()) {
                System.out.println("P1 wins");
            } else {
                System.out.println("P2 wins");
            }
        }
    }
    public static int warTime() {
        Queue<Integer> playerWar = new LinkedList<>();
        Queue<Integer> OppWar = new LinkedList<>();
        Queue<Integer> equals = new LinkedList<>();
        int win = 0;//  0 = OPP Wins, | 1 = Player wins | 3 = Tie
            int draw = 4;
            if(playerDeck.isEmpty() && OppDeck.isEmpty()){
                return 3;
            }
            else {
                if (playerDeck.isEmpty() || OppDeck.isEmpty()) {
                    if (playerDeck.isEmpty()) {
                        return 0;
                    } else
                        return 1;
                }
                if (playerDeck.size() < draw || OppDeck.size() < draw) {
                    draw = (playerDeck.size() < OppDeck.size()) ? playerDeck.size() : OppDeck.size();
                }
                for (int i = 0; i <= draw - 2; i++) {
                    playerWar.add(playerDeck.poll());
                    OppWar.add(OppDeck.poll());
                }
                int player = playerDeck.poll();
                int Opp = OppDeck.poll();
                if (player == Opp) {
                    win = warTime();
                }
                if ((player > Opp) || win == 1) {
                    playerDeck.addAll(playerWar);
                    playerDeck.add(player);
                    playerDeck.addAll(OppWar);
                    playerDeck.add(Opp);
                    playerDeck.addAll(equals);
                    return 1;
                } else if (Opp > player || win == 0) {
                    OppDeck.addAll(OppWar);
                    OppDeck.add(Opp);
                    OppDeck.addAll(playerWar);
                    OppDeck.add(player);
                    OppDeck.addAll(equals);
                    return 0;

                }
            }
                return 3;
    }

}
