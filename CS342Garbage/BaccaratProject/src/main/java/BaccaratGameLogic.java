import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
public class BaccaratGameLogic extends BaccaratDealer{
    ////Natural Card 8 or 9
    ///Natural Draw Function

    /**
     *
     *
     *
     * natural vs naturalDraw
     *
     *
     * **/
    public boolean natural_draw(int player1,int player2){
        return (player1 == 8 || player1 == 9 && (player1 == player2));///8 or 9 Draw
        //return (player1 >= 8 && (player1 == player2));
    }
    public String whoWon(ArrayList<Card> hand1, ArrayList<Card> hand2){

        ///sumPlayer >= 6 No more receiving cards

        //sumBanker >= 7  No more receiving cards


        ///Max amount of turns 3



        //hand1 --> player
        //hand2 ----> banker

        String winner = "Draw";
        int sum_player = handTotal(hand1);
        int sum_banker = handTotal(hand2);

        Card playerCard;

        ////May NOT cover all cases for DRAW
        ////Order matters ------> Natural must be checked first
        if (!natural_draw(sum_player,sum_banker)){
           if(sum_player > sum_banker){
               winner = "Player wins";
           }
           else
               winner = "Banker wins";
        }
        System.out.println(winner);
        return winner;
    }
    public int handTotal(ArrayList<Card> hand){

        Iterator<Card> hand_it = hand.iterator();
        int total = 0;
        int total_mod = 0;
        while (hand_it.hasNext()){
            total += hand_it.next().getValue();
            total_mod = total % 10;
            System.out.println("Total: "+ total_mod);
        }
        return total_mod;
    }

    //Take one more card
    public boolean evaluateBankerDraw(ArrayList<Card> hand, Card playerCard){
        return (handTotal(hand) == 0 && playerCard.getValue() < 7 || handTotal(hand) < 7);

    }

    //Take one more card
    public boolean evaluatePlayerDraw(ArrayList<Card> hand){
        return (handTotal(hand) < 6);
    }
}
