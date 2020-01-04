import java.util.ArrayList;

public class BaccaratGameLogic {

    public String whoWon(ArrayList<Card> hand1, ArrayList<Card> hand2){
        //hand1 --> player
        //hand2 ----> banker
        String winner;
        int sum_banker = 0;
        int sum_player = 0;
        int i;
        Card playerCard;
        //Player
        for(i = 0; i < hand1.size(); i++){
            sum_player += hand1.get(i).getValue();
            if(sum_player > 9)
                sum_player = sum_player - 10;
        }
        playerCard = hand1.get(hand1.size()-1);//Last card dealt

        //Banker
        for(i = 0; i < hand2.size(); i++){
            sum_banker += hand2.get(i).getValue();
            if(sum_banker > 9)
                sum_banker = sum_banker - 10;
        }

        //Player wins
        if(sum_player > 7 && sum_banker < 7){
            winner = "Player";
            return winner;
        }
        else if(!evaluateBankerDraw(hand2,playerCard)){
            winner = "Banker";
            return winner;
        }
        else{
            winner = "Draw";
            return winner;
        }

    }
    public int handTotal(ArrayList<Card> hand){

        return 0;
    }
    public boolean evaluateBankerDraw(ArrayList<Card> hand, Card playerCard){
        int sum_banker = 0,i;
        for(i = 0; i < hand.size(); i++){
            sum_banker += hand.get(i).getValue();
            if(sum_banker > 9)
                sum_banker = sum_banker - 10;
        }

        if(sum_banker==playerCard.getValue())
            return true;
        return false;

    }
    public boolean evaluatePlayerDraw(ArrayList<Card> hand){
        if(hand.size() == 3)
            return true;
        return false;
    }

}
