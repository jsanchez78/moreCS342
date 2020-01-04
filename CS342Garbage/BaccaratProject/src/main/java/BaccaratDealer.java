import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import javafx.application.Application;
class BaccaratDealer{

    private ArrayList<Card> deck;

    private int top;//topCardIndex

    BaccaratDealer(){

        this.top = 0;
        this.deck = new ArrayList<>();
    }
    public int getTop(){

        return this.top;
    }

    public void setTop(int new_top){
        this.top = new_top;
    }
    public ArrayList<Card> getDeck(){
        return this.deck;
    }
    public void generateDeck(){
        ///These are my values for the deck
        int i,j,k;
        String suite = "heart";
        this.deck = new ArrayList<Card>(52);
        for (j=1;j<=4;j++){
            for (i=1;i<=13;i++){
                switch (j){
                    case 2:
                        suite = "spade";
                        break;
                    case 3:
                        suite = "diamond";
                        break;
                    case 4:
                        suite = "club";
                }
                Card new_card = new Card();
                if(i < 11){
                    k = i;
                    new_card.setValue(k);
                }
                else
                    new_card.setValue(0);
                new_card.setSuite(suite);
                this.deck.add(new_card);
                System.out.println("Suite: " + suite + "\nValue: " + new_card.getValue());
            }
        }
        shuffleDeck();
    }

    public ArrayList<Card> dealHand(){
        int i;
        ArrayList<Card> hand = new ArrayList<Card>(2);
        for (i=0;i<2;i++){
            hand.add(drawOne());
        }
        return hand;
    }

    public Card drawOne(){
        /*
        Card drawnCard = this.deck.get(this.top);
        this.deck.remove(this.top);
        this.setTop(this.top+1);//this.top--;
        return drawnCard;
        */
       if(deckSize() != 0)
           return deck.remove(0);
       return null;

    }

    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }

    public int deckSize()
    {

        return deck.size();
    }

}