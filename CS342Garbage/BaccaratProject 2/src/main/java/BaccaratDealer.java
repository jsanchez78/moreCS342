import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
class BaccaratDealer {

    private ArrayList<Card> deck;

    public void generateDeck(){
        ///These are my values for the deck
        String suite = null;
        int mod = 0,i,value;
        ///Loop to generate deck
        for(i=0;i<52;i++) {
            mod = i % 13;
            //Determine Suite
            if (mod == 0){
                switch (i) {
                    case 0:
                        suite = "Clubs";
                        break;
                    case 13:
                        suite = "Diamonds";
                        break;
                    case 26:
                        suite = "Hearts";
                        break;
                    default:
                        suite = "Spades";
                        break;
                }
            }
            //Determine value of card
            ///Ace has value 1
            //Implement Logic in your Card Constructor
            if(mod > 1 && mod < 11)
                value = mod;
            else
                value = 0;
            //Create card
            deck.add(new Card(suite,value));
        }

    }
    public ArrayList<Card> dealHand(){

        ArrayList<Card> deal = new ArrayList<>();

        Card card1 = deck.get(deckSize()-1);
        deck.remove(deckSize()-1);
        Card card2 = deck.get(deckSize()-1);

        deal.add(card1);
        deal.add(card2);

        return deal;

    }


    public Card drawOne(){

        Card card = new Card("Ace",8);
        return card;

    }
    public void shuffleDeck(){
        ArrayList<Card> new_deck = deck;
        Collections.shuffle(new_deck,new Random());
    }

    public int deckSize()
    {
        return deck.size();
    }

}
