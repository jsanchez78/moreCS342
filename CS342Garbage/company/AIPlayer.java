package com.company;

import java.util.ArrayList;

public class AIPlayer extends Player {
    ArrayList<Card> hand = new ArrayList<>();
    private int Bid;
    private int ID;
    private Card playedCard;
    private int score;
    Player setAiPLayer = new Player();
    ArrayList<Card> winningHand = new ArrayList<>();

    @Override
    public void setScore(int score) {
        this.score += score;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void resetScore(){this.score=0;}

    @Override
    public void setBid(int bid) {
        Bid = bid;
    }

    @Override
    public int getBid() {
        return Bid;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void setPlayedCard(Card playedCard) {
        this.playedCard = playedCard;
    }

    public Card getPlayedCard() {
        return playedCard;
    }

    public void setWinningHand(ArrayList<Card> winningHand) {
        this.winningHand = winningHand;
    }

    public ArrayList<Card> getWinningHand() {
        return winningHand;
    }

    public void setSetAiPLayer(Player setAiPLayer) {
        this.setAiPLayer = setAiPLayer;
    }

    public Player getSetAiPLayer() {
        return setAiPLayer;
    }
}
