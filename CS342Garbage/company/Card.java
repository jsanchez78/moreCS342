package com.company;

import javafx.scene.image.ImageView;

public class Card{
    private String Rank;
    private String Suit;
    ImageView cardImage;
    private boolean cardOut;
    private int value;
    private int suitH;


    Card(){}

    Card(String rank, String suit){
        this.Suit = suit;
        this.Rank = rank;
        this.cardOut=false;
    }

    public ImageView getCardImage() {
        return cardImage;
    }

    public void setCardImage(ImageView cardImage) {
        this.cardImage = cardImage;
    }

    void setNumber(String num){
        this.Rank = num;
    }

    String getNumber(){
        return this.Rank;
    }

    void setSuit(String suit){ this.Suit = suit; }

    String getSuit(){
        return this.Suit;
    }

    public void setCardOut(boolean cardOut) {
        this.cardOut = cardOut;
    }

    public boolean isCardOut() {
        return cardOut;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setSuitH(int suitH) { this.suitH = suitH; }

    public int getSuitH() { return this.suitH; }


}



