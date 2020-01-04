package com.company;
import java.util.ArrayList;

public class Player {
    ArrayList<Card> hand = new ArrayList<>();
    private int Bid;
    private int ID;
    private Card playedCard;
    ArrayList<Card> winningHand = new ArrayList<>();
    private int score;
    int high=0;
    int low=0;
    int jack=0;
    int handScore=0;
    int totalSCore=0;


    Player(){
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public void resetScore(){this.score=0;}


    void setBid(int bid){
        this.Bid = bid;
    }

    int getBid(){return this.Bid;}

    public void setPlayedCard(Card carta){this.playedCard =carta;}

    public Card getPlayedCard() { return playedCard; }

    void setID(int id){
        this.ID = id;
    }

    int getID(){
        return this.ID;
    }

    public void setWinningHand(ArrayList<Card> winningHand) {
        this.winningHand = winningHand;
    }

    public ArrayList<Card> getWinningHand() {
        return winningHand;
    }

    void printHand(){
        for(int i =0;i<6;i++){
            System.out.println(hand.get(i).getSuit());
            System.out.println(hand.get(i).getNumber());
            //System.out.println(hand.get(i).isCardOut());
            System.out.println();
        }
    }


}
