package com.company;

import java.awt.*;
import java.io.CharArrayReader;
import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.Button;

import javax.swing.*;

public class Pitch {
    PitchDealer dealer = new PitchDealer();
    ArrayList<Player> playas = new ArrayList<>();
    ArrayList<Card> inPlay = new ArrayList<>();
    Card trumpCard = new Card();
    private int checks=0;
    private int turn;

    Pitch(){}


    public int getChecks() {
        return checks;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn+1;
    }

    public void resetTurn(){
        this.turn =0;
    }

    void setPlayers(int numPlayers){
        dealer.shufle();
        Player player1 = new Player();
        player1.setID(1);
        player1.hand = dealer.dealHand();
        playas.add(player1);
        for(int i = 2; i <= numPlayers; i++) {
            Player aiplayer = new Player();
            aiplayer.setID(i);
            aiplayer.hand = dealer.dealHand();
            playas.add(aiplayer);
        }
    }

    ArrayList<Player>  getPlayer(){
        return this.playas;
    }

    //set player 1's Hand
    void setCards(Button card1, Button card2, Button card3, Button card4, Button card5, Button card6){
        for(int i =0;i<playas.size();i++){
            getPlayer().get(i).printHand();
            if(getPlayer().get(i).getID() == 1){
                for(int j=0;j<getPlayer().get(i).hand.size();j++){
                    if(j==0){
                        card1.setUserData(getPlayer().get(0).hand.get(j));
                        //card1.setText(getPlayer().get(i).hand.get(j).getSuit()+ " of " + getPlayer().get(i).hand.get(j).getNumber());
                        card1.setGraphic(getPlayer().get(i).hand.get(j).getCardImage());
                    }
                    else if(j==1){
                        card2.setUserData(getPlayer().get(0).hand.get(j));
                        //card2.setText(getPlayer().get(i).hand.get(j).getSuit()+ " of " + getPlayer().get(i).hand.get(j).getNumber());
                        card2.setGraphic(getPlayer().get(i).hand.get(j).getCardImage());
                    }
                    else if(j==2){
                        card3.setUserData(getPlayer().get(0).hand.get(j));
                        //card3.setText(getPlayer().get(i).hand.get(j).getSuit()+ " of " + getPlayer().get(i).hand.get(j).getNumber());
                        card3.setGraphic(getPlayer().get(i).hand.get(j).getCardImage());
                    }
                    else if(j==3){
                        card4.setUserData(getPlayer().get(0).hand.get(j));
                        //card4.setText(getPlayer().get(i).hand.get(j).getSuit()+ " of " + getPlayer().get(i).hand.get(j).getNumber());
                        card4.setGraphic(getPlayer().get(i).hand.get(j).getCardImage());
                    }
                    else if(j==4){
                        card5.setUserData(getPlayer().get(0).hand.get(j));
                        //card5.setText(getPlayer().get(i).hand.get(j).getSuit()+ " of " + getPlayer().get(i).hand.get(j).getNumber());
                        card5.setGraphic(getPlayer().get(i).hand.get(j).getCardImage());
                    }
                    else if(j==5){
                        card6.setUserData(getPlayer().get(0).hand.get(j));
                        //card6.setText(getPlayer().get(i).hand.get(j).getSuit()+ " of " + getPlayer().get(i).hand.get(j).getNumber());
                        card6.setGraphic(getPlayer().get(i).hand.get(j).getCardImage());
                    }
                }
            }
        }
    }



    void print(){
        for(int i=0;i<inPlay.size();i++){
            System.out.println("card" + i );
            System.out.println(inPlay.get(i).getNumber());
            System.out.println(inPlay.get(i).getSuit());
            System.out.println("******");
        }
    }


    void AIPlaceBid() {
        int counter = 0;
        int counter2 = 0;
        int counter3 = 0;
        for (Player aiPlayer: playas) {
            for(Card card: aiPlayer.hand) {
                if(aiPlayer.getID()==2){
                    if (card.getValue() >= 11) {
                        counter++;
                    }
                }
                else if(aiPlayer.getID()==3){
                    if (card.getValue() >= 11) {
                        counter2++;
                    }
                }
                else if(aiPlayer.getID()==4){
                    if (card.getValue() >= 11) {
                        counter3++;
                    }
                }
            }

            if(aiPlayer.getID()==2){
                if(counter > 5){
                    aiPlayer.setBid(5);
                }
                else if(counter > 4){
                    aiPlayer.setBid(4);
                }
                else if(counter > 3){
                    aiPlayer.setBid(3);
                }
                else if(counter > 2){
                    aiPlayer.setBid(2);
                }
                else if(counter < 2){
                    aiPlayer.setBid(0);
                }
                //System.out.println("AI BID"+aiPlayer.getBid());
            }

            else if(aiPlayer.getID()==3){
                if(counter2 > 5){
                    aiPlayer.setBid(5);
                }
                else if(counter2 > 4){
                    aiPlayer.setBid(4);
                }
                else if(counter2 > 3){
                    aiPlayer.setBid(3);
                }
                else if(counter2 > 2){
                    aiPlayer.setBid(2);
                }
                else if(counter2 < 2){
                    aiPlayer.setBid(0);
                }
                //System.out.println("AI BID"+aiPlayer.getBid());
            }

            else if(aiPlayer.getID()==4){
                if(counter3 > 5){
                    aiPlayer.setBid(5);
                }
                else if(counter3 > 4){
                    aiPlayer.setBid(4);
                }
                else if(counter3 > 3){
                   aiPlayer.setBid(3);
                }
                else if(counter3 > 2){
                    aiPlayer.setBid(2);
                }
                else if(counter3 < 2){
                    aiPlayer.setBid(0);
                }
                //System.out.println("AI BID"+aiPlayer.getBid());
            }
        }

        //Sort by highes bid
//        Collections.sort(playas, new Comparator<Player>() {
//            @Override
//            public int compare(Player o1, Player o2) {
//                if (o1.getBid() > o2.getBid()) {
//                    return 1;
//                } else if (o1.getBid() < o2.getBid()) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        });
    }





    void AiPlayHand(){
        checks=0;
        for (Player player:playas){
            Collections.sort(player.hand, new Comparator<Card>() {
                @Override
                public int compare(Card o1, Card o2) {
                    if (o1.getSuitH() > o2.getSuitH()) {
                        return -1;
                    }
                    else if(o2.getSuitH() < o2.getSuitH()){
                        return 1;
                    }
                    else if(o1.getSuitH() == o2.getSuitH()){
                        return 0;
                    }
                    else {
                        if (o1.getValue() > o2.getValue()) {
                            return -1;
                        } else if (o1.getValue() < o2.getValue()) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
            });
        }
        //For each player
        for(Player player: playas) {
            //System.out.println(player.getID());
            //Only play for the aiplayer wich are always ID 2,3,or 4
            if(player.getID()==2||player.getID()==3||player.getID()==4) {
                //if The first card that is played is a Heart always try and match to the first card played and play the highest card
                if (player.hand.get(0).getSuit() == trumpCard.getSuit()) {
                    inPlay.add(player.hand.get(0));
                    player.setPlayedCard(player.hand.get(0));
                    player.hand.remove(player.hand.get(0));
                }
                else{
                    if (inPlay.get(0).getSuit() == "H") {
                        checks=0;
                        for (int i = 0; i < player.hand.size(); i++) {
                            checks++;
                            if (player.hand.get(i).getSuit() == "H") {
                                inPlay.add(player.hand.get(i));
                                player.setPlayedCard(player.hand.get(i));
                                player.hand.remove(player.hand.get(i));
                                break;
                            } else if (checks == player.hand.size()) {
                                inPlay.add(player.hand.get(0));
                                player.setPlayedCard(player.hand.get(i));
                                player.hand.remove(player.hand.get(0));
                            }
                        }
                    }
                    //else if its a Diamond
                    else if (inPlay.get(0).getSuit() == "D") {
                        checks=0;
                        for (int i = 0; i < player.hand.size(); i++) {
                            checks++;
                            if (player.hand.get(i).getSuit() == "D") {
                                inPlay.add(player.hand.get(i));
                                player.setPlayedCard(player.hand.get(i));
                                player.hand.remove(player.hand.get(i));
                                break;
                            } else if (checks == player.hand.size()) {
                                inPlay.add(player.hand.get(0));
                                player.setPlayedCard(player.hand.get(i));
                                player.hand.remove(player.hand.get(0));
                            }
                        }
                    }

                    //else if its a Spade
                    else if (inPlay.get(0).getSuit() == "S") {
                        checks=0;
                        for (int i = 0; i < player.hand.size(); i++) {
                            checks++;
                            if (player.hand.get(i).getSuit() == "S") {
                                inPlay.add(player.hand.get(i));
                                player.setPlayedCard(player.hand.get(i));
                                player.hand.remove(player.hand.get(i));
                                break;
                            } else if (checks == player.hand.size()) {
                                inPlay.add(player.hand.get(0));
                                player.setPlayedCard(player.hand.get(i));
                                player.hand.remove(player.hand.get(0));
                            }
                        }
                    }

                    //Else if its a Club
                    else if (inPlay.get(0).getSuit() == "C") {
                        checks=0;
                        for (int i = 0; i < player.hand.size(); i++) {
                            checks++;
                            if (player.hand.get(i).getSuit() == "C") {
                                inPlay.add(player.hand.get(i));
                                player.setPlayedCard(player.hand.get(i));
                                player.hand.remove(player.hand.get(i));
                                break;
                            } else if (checks == player.hand.size()) {
                                inPlay.add(player.hand.get(0));
                                player.setPlayedCard(player.hand.get(i));
                                player.hand.remove(player.hand.get(0));
                            }
                        }
                    }
                }
            }
        }
    }


    public boolean allPlayerWinner(){
        int min=0;
        int max=0;
        //***********CHECK FOR THE HIGHEST SCORE**********************
        for (Player dude:playas) {
            for (Card A: dude.getWinningHand()) {
                if(A.getValue() == 10){
                    dude.setScore(10);
                }
                else if(A.getValue() == 11){
                    dude.setScore(1);
                }
                else if(A.getValue() == 12){
                    dude.setScore(2);
                }
                else if(A.getValue() == 13){
                    dude.setScore(3);
                }
                else if(A.getValue() == 13){
                    dude.setScore(4);
                }
            }
        }
        Collections.sort(playas, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.getScore() > o2.getScore()) {
                    return -1;
                } else if (o1.getScore() < o2.getScore()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        playas.get(0).totalSCore+=1;
        System.out.println("ADDED FOR SCORE "+playas.get(0).totalSCore);
        //********************** END OF GAME SCORE**************************

        //*********************BID CHECK*********************************
        for (Player dude2:playas) {
            if ((dude2.getBid() * 2) == dude2.getWinningHand().size()) {
                dude2.totalSCore += dude2.getBid();
                System.out.println("ADDED "+dude2.getBid());
            } else if (dude2.getWinningHand().size()>(dude2.getBid()*2)) {
                dude2.totalSCore+=0;
                System.out.println("NOTHINGG");
            }else if(dude2.getWinningHand().size()<(dude2.getBid()*2)){
                dude2.totalSCore -= dude2.getBid();
                System.out.println("SUBTRACTED "+dude2.getBid());
            }
        }
        //**********************END OF BID CHECK******************************

        //**********************CONTAINS THE TRUMP JACK************************
        for (Player dude3:playas) {
            Card trumpJack = new Card();
            trumpJack.setSuit(trumpCard.getSuit());
            trumpJack.setValue(11);
            boolean retval = dude3.getWinningHand().contains(trumpJack);
            if (retval == true) {
                dude3.totalSCore+=1;
                System.out.println("Player "+dude3.getID() + " has jack of trump");
            }
        }
        //**********************END OF TRUMP JACK******************************

        //**********************FIND LOW AND HIGH TRUMP CARD********************
        for(Player dude4:playas) {
            for (int i = 0; i < dude4.getWinningHand().size(); i++) {
                if(dude4.getWinningHand().get(i).getSuit() == trumpCard.getSuit()) {
                    min = dude4.getWinningHand().get(i).getValue();
                    max = dude4.getWinningHand().get(i).getValue();
                    if (dude4.getWinningHand().get(i).getValue() < min) {
                        min = dude4.getWinningHand().get(i).getValue();
                        dude4.low = min;
                        System.out.println("LOW FOR TRUMP SUIT " + dude4.low);
                    } else if (dude4.getWinningHand().get(i).getValue() > max) {
                        max = dude4.getWinningHand().get(i).getValue();
                        dude4.high = max;
                        System.out.println("HIGHT FOR TRUMP SUIT "+dude4.high);
                    }
                }
            }
        }


        //*********************END OF LOW AND HIGH*******************************


        //********************SORT AND PUT THE PLAYER WITH THE HIGHEST TRUMP CARD IN THE FRONT*************
        Collections.sort(playas, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.high > o2.high) {
                    return -1;
                } else if (o1.high < o2.high) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        playas.get(0).totalSCore+=1;
        System.out.println(playas.get(0).getID()+" HAD GHIFH TRUMP CARD"+playas.get(0).totalSCore);
        //***************************ADD POINT FOR HAVING HIGH TRUMP CARD*****************************

        //********************SORT AND PUT THE PLAYER WITH THE LOWEST TRUMP CARD IN THE FRONT*************
        Collections.sort(playas, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.low < o2.low) {
                    return 1;
                } else if (o1.low > o2.low) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        playas.get(0).totalSCore+=1;
        System.out.println(playas.get(0).getID()+" HAD LOW TRUMP CARD"+playas.get(0).totalSCore);
        //***************************ADD POINT FOR HAVING LOW TRUMP CARD*****************************


        //*************************SORT PLAYERS BY THE HIGHEST TOTALSCORE*************************
        Collections.sort(playas, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.totalSCore > o2.totalSCore) {
                    return -1;
                } else if (o1.totalSCore < o2.totalSCore) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(playas.get(0).getID()+" HAD HIGHES SCORE "+playas.get(0).totalSCore);
        System.out.println();
        //***********************************END OF SORT BY HIGHSCORE*******************************

        //******************************CONDITION WILL KEEP RUNNING UNTILL SOME PLAYER OBTAINS 7 POINTS**
        if (playas.get(0).totalSCore > 7) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pitch");
            alert.setHeaderText("Stats: Player "+ playas.get(0).getID()+ " Won with total of " + playas.get(0).totalSCore + "\n");
            alert.setContentText("Player " + playas.get(0).getID() +" WON THE GAME");
            alert.showAndWait();
            return true;
        }
        else{
            if(playas.size() == 2) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("Stats: Player "+ playas.get(0).getID()+ " has " + playas.get(0).totalSCore + "\n");
                alert.setContentText("Stats: Player "+ playas.get(1).getID()+ " has " + playas.get(1).totalSCore + "\n");
                alert.showAndWait();
                return false;
            }
            else if(playas.size()==3){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("Stats: Player "+ playas.get(0).getID()+ " has " + playas.get(0).totalSCore + "\n");
                alert.setContentText("Stats: Player "+ playas.get(1).getID()+ " has " + playas.get(1).totalSCore + "\n"+"Stats: Player "+ playas.get(2).getID()+ " has " + playas.get(2).totalSCore + "\n");
                alert.showAndWait();
                return false;
            }
            else if(playas.size()==4){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("Stats: Player "+ playas.get(0).getID()+ " has " + playas.get(0).totalSCore + "\n"+"Stats: Player "+ playas.get(1).getID()+ " has " + playas.get(1).totalSCore + "\n");
                alert.setContentText("Stats: Player "+ playas.get(2).getID()+ " has " + playas.get(2).totalSCore + "\n"+"Stats: Player "+ playas.get(3).getID()+ " has " + playas.get(3).totalSCore + "\n");
                alert.showAndWait();
                return false;
            }
        }

        return false;
    }//************************END OF CHECK WINNER************************************

    //*************************CEHCK WIN FOR TWO PLAYERS***************************
    void twoplayacheckWin(){
        //check the in play
        //if the first card i > then second first player (two player)
        if(inPlay.get(1).getSuit()!=inPlay.get(0).getSuit()||inPlay.get(1).getSuit()!=trumpCard.getSuit()){
            playas.get(0).getWinningHand().add(inPlay.get(0));
            playas.get(0).getWinningHand().add(inPlay.get(1));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pitch");
            alert.setHeaderText("PLAYER ONE WON TRICK");
            alert.show();
        }else {
            if (inPlay.get(0).getValue() < inPlay.get(1).getValue()) {
                playas.get(1).getWinningHand().add(inPlay.get(0));
                playas.get(1).getWinningHand().add(inPlay.get(1));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("AI ONE WON TRICK");
                alert.show();
            } else {
                playas.get(0).getWinningHand().add(inPlay.get(0));
                playas.get(0).getWinningHand().add(inPlay.get(1));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("PLAYER ONE WON TRICK");
                alert.show();
            }
        }
        inPlay.removeAll(inPlay);
    }//**********************END OF TWO PLAYER WINNER********************

    //***********************START OF CLEAR ALL HANDS*********************
    void clearHands(){
        for (Player A: playas) {
            A.hand.removeAll(A.hand);
        }
        dealer.resetDeck();
        dealer.shufle();
        for (Player B: playas
             ) {
            B.hand = dealer.dealHand();
        }
    }//*************************CLEAR HANDS******************************


    void threePlayerCheckWin() {
        //System.out.println(inPlay.size());
        if(inPlay.get(1).getSuit()!=inPlay.get(0).getSuit()||inPlay.get(1).getSuit()!=trumpCard.getSuit()||inPlay.get(2).getSuit()!=inPlay.get(0).getSuit()||inPlay.get(2).getSuit()!=trumpCard.getSuit()){
            playas.get(0).getWinningHand().add(inPlay.get(0));
            playas.get(0).getWinningHand().add(inPlay.get(1));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pitch");
            alert.setHeaderText("PLAYER ONE WON TRICK");
            //alert.showAndWait();
            alert.show();
        }else {
            if (inPlay.get(0).getValue() > inPlay.get(1).getValue() && inPlay.get(0).getValue() > inPlay.get(2).getValue()) {
                playas.get(0).getWinningHand().add(inPlay.get(0));
                playas.get(0).getWinningHand().add(inPlay.get(1));
                playas.get(0).getWinningHand().add(inPlay.get(2));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("PLAYER ONE WON TRICK");
                alert.showAndWait();
            } else if (inPlay.get(1).getValue() > inPlay.get(0).getValue() && inPlay.get(1).getValue() > inPlay.get(2).getValue()) {
                playas.get(1).getWinningHand().add(inPlay.get(0));
                playas.get(1).getWinningHand().add(inPlay.get(1));
                playas.get(1).getWinningHand().add(inPlay.get(2));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("AI ONE WON TRICK");
                alert.showAndWait();
            } else if (inPlay.get(2).getValue() > inPlay.get(0).getValue() && inPlay.get(2).getValue() > inPlay.get(1).getValue()) {
                playas.get(2).getWinningHand().add(inPlay.get(0));
                playas.get(2).getWinningHand().add(inPlay.get(1));
                playas.get(2).getWinningHand().add(inPlay.get(2));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("AI ONE WON TRICK");
                alert.showAndWait();
            }
        }
        inPlay.removeAll(inPlay);
    }

    public void fourPlayerCheckWin(){
        //System.out.println(inPlay.size());
        if(inPlay.get(1).getSuit()!=inPlay.get(0).getSuit()||inPlay.get(1).getSuit()!=trumpCard.getSuit()||inPlay.get(2).getSuit()!=inPlay.get(0).getSuit()||inPlay.get(2).getSuit()!=trumpCard.getSuit()||inPlay.get(3).getSuit()!=inPlay.get(0).getSuit()||inPlay.get(3).getSuit()!=trumpCard.getSuit()){
            playas.get(0).getWinningHand().add(inPlay.get(0));
            playas.get(0).getWinningHand().add(inPlay.get(1));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pitch");
            alert.setHeaderText("PLAYER ONE WON TRICK");
            alert.showAndWait();
        }else {
            if (inPlay.get(0).getValue() > inPlay.get(1).getValue() && inPlay.get(0).getValue() > inPlay.get(2).getValue() && inPlay.get(0).getValue() > inPlay.get(3).getValue()) {
                playas.get(0).getWinningHand().add(inPlay.get(0));
                playas.get(0).getWinningHand().add(inPlay.get(1));
                playas.get(0).getWinningHand().add(inPlay.get(2));
                playas.get(0).getWinningHand().add(inPlay.get(3));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("PLAYER ONE WON TRICK");
                alert.showAndWait();
            } else if (inPlay.get(1).getValue() > inPlay.get(0).getValue() && inPlay.get(1).getValue() > inPlay.get(2).getValue() && inPlay.get(1).getValue() > inPlay.get(3).getValue()) {
                playas.get(1).getWinningHand().add(inPlay.get(0));
                playas.get(1).getWinningHand().add(inPlay.get(1));
                playas.get(1).getWinningHand().add(inPlay.get(2));
                playas.get(1).getWinningHand().add(inPlay.get(3));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("AI ONE WON TRICK");
                alert.showAndWait();
            } else if (inPlay.get(2).getValue() > inPlay.get(0).getValue() && inPlay.get(2).getValue() > inPlay.get(1).getValue() && inPlay.get(2).getValue() > inPlay.get(3).getValue()) {
                playas.get(2).getWinningHand().add(inPlay.get(0));
                playas.get(2).getWinningHand().add(inPlay.get(1));
                playas.get(2).getWinningHand().add(inPlay.get(2));
                playas.get(2).getWinningHand().add(inPlay.get(3));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("AI TWO WON TRICK");
                alert.showAndWait();
            } else {
                playas.get(3).getWinningHand().add(inPlay.get(0));
                playas.get(3).getWinningHand().add(inPlay.get(1));
                playas.get(3).getWinningHand().add(inPlay.get(2));
                playas.get(3).getWinningHand().add(inPlay.get(3));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pitch");
                alert.setHeaderText("AI THREE WON TRICK");
                alert.showAndWait();
            }
        }
        inPlay.removeAll(inPlay);

    }

}
