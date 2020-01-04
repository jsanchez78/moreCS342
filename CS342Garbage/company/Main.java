
package com.company;
import java.sql.Time;
import java.util.Iterator;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;
import javax.swing.JOptionPane;
import javafx.scene.paint.Color;

import static javafx.application.Application.launch;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED_TARGET;

public class Main extends Application {
    Text text;
    Button start;
    Button twoPlayer, threePlayer, fourPlayer;
    Button Exit;
    Button back;
    Button bid2, bid3, bid4, smudge, pass;
    Button card1, card2, card3, card4, card5, card6, card7,card8,card9;
    HashMap<String, Scene> sceneMap;
    Stage myStage;
    Scene scene, scene2;
    Pitch newGame = new Pitch();
    HBox player1 = new HBox();
    VBox player2 = new VBox();
    HBox player3 = new HBox();
    VBox player4 = new VBox();
    HBox playedCards = new HBox();
    BorderPane pane2 = new BorderPane();
    BackgroundFill grayBG = new BackgroundFill(Color.GREEN, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
    BackgroundFill darkGrayBG = new BackgroundFill(Color.GREEN, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
    ImageView card = new ImageView();
    Image img = new Image("/PNG/back_cards-07.png");
    ImageView v = new ImageView(img);
    ImageView w = new ImageView(img);
    ImageView x = new ImageView(img);
    Button reset = new Button();
    BorderPane pane = new BorderPane();
    HBox paneCenter = new HBox();
    HBox displayName = new HBox();
    Text displayP1Bid = new Text();
    Text displayP2Bid = new Text();
    Text displayP3Bid = new Text();
    Text displayP4Bid = new Text();
    VBox bidss = new VBox();
    HBox cards2 = new HBox();
    VBox bidd = new VBox();
    VBox options = new VBox();
    boolean resetpressed = false;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        myStage = primaryStage;
        primaryStage.setTitle("Pitch");
        start = new Button("Start Game");
        start.setMinSize(90, 160);
        reset.setText("Reset Game");
        text = new Text("PITCH");
        text.setFont(new Font("Times New Roman", 150));
        twoPlayer = new Button("Two player");
        twoPlayer.setMinSize(90, 160);
        threePlayer = new Button("Three Player");
        threePlayer.setMinSize(90, 160);
        fourPlayer = new Button("Four Player");
        fourPlayer.setMinSize(90, 160);
        Exit = new Button("Exit Game");
        Exit.setMinSize(90, 160);
        back = new Button("Clear Pile");
        bid2 = new Button("2 Bid");
        bid2.setMinSize(30, 30);
        bid3 = new Button("3 Bids");
        bid3.setMinSize(30, 30);
        bid4 = new Button("4 Bids");
        bid4.setMinSize(30, 30);
        smudge = new Button("Smudge");
        smudge.setMinSize(30, 30);
        pass = new Button("Pass");
        pass.setMinSize(30, 30);
        card1 = new Button();
        card1.setMinSize(50, 120);
        card2 = new Button();
        card2.setMinSize(50, 120);
        card3 = new Button();
        card3.setMinSize(50, 120);
        card4 = new Button();
        card4.setMinSize(50, 120);
        card5 = new Button();
        card5.setMinSize(50, 120);
        card6 = new Button();
        card6.setMinSize(50, 120);
        card.setFitWidth(10);
        card.setFitHeight(20);
        sceneMap = new HashMap<>();
        pane2.setBackground(new Background(darkGrayBG));
        start.setDisable(true);
        //**************************************Start of StartGame Event Handler*************************************
        start.setOnAction(e -> {
            myStage.setScene(sceneMap.get("gamePlay"));
            primaryStage.setScene(scene2);
            card1.setDisable(true);
            card2.setDisable(true);
            card3.setDisable(true);
            card4.setDisable(true);
            card5.setDisable(true);
            card6.setDisable(true);
        });
        //***************************************End of Start game handler****************************************


        reset.setOnAction(e-> {
            myStage.setScene(sceneMap.get("welcome"));
            primaryStage.setScene(scene);
            player1.getChildren().removeAll(player1.getChildren());
            player2.getChildren().removeAll(player2.getChildren());
            player3.getChildren().removeAll(player3.getChildren());
            player4.getChildren().removeAll(player4.getChildren());
            newGame.inPlay.removeAll(newGame.inPlay);
            bidss.getChildren().removeAll(bidss.getChildren());
            bidss.setVisible(false);
            start.setDisable(true);
            for (Player A:newGame.playas) {
                A.setBid(0);
                A.resetScore();
                A.totalSCore=0;
                A.jack=0;
                A.low=0;
                A.high=0;
                A.setID(0);
                for(Card card:A.hand){
                    card = null;
                }
                A = null;
            }
            newGame.playas.removeAll(newGame.playas);
            twoPlayer.setDisable(false);
            threePlayer.setDisable(false);
            fourPlayer.setDisable(false);
            resetpressed = true;

        });

        //************************************Start of Exit Button Handler*******************************************
        Exit.setOnAction(e -> {
            // get a handle to the stage
            Stage stage = (Stage) primaryStage.getScene().getWindow();
            // do what you have to do
            stage.close();
        });
        //**************************************End of Exit Button Handler********************************************************


        //*********************************Start of Number of Player Handler********************************************************************
        EventHandler<ActionEvent> numberOfPlayers = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Button b = (Button) event.getSource();
                newGame.clearHands();
                start.setDisable(false);
                if (b == twoPlayer) {
                    newGame.setPlayers(2);
                } else if (b == threePlayer) {
                    newGame.setPlayers(3);
                } else if (b == fourPlayer) {
                    newGame.setPlayers(4);
                }
                if(resetpressed=true){
                    newGame.clearHands();
                    playedCards.getChildren().removeAll(playedCards.getChildren());
                    newGame.setCards(card1, card2, card3, card4, card5, card6);
                    player1.getChildren().addAll(card1,card2,card3,card4,card5,card6,back,reset);
                    bidss.getChildren().addAll(bidd,bid2,bid3,bid4,smudge,pass);
                    displayCardsAgain();
                    setAIbids();
                    newGame.resetTurn();
                    resetpressed=false;
                }else {
                    newGame.setCards(card1, card2, card3, card4, card5, card6);
                    displayCardsAgain();
                    twoPlayer.setDisable(true);
                    threePlayer.setDisable(true);
                    fourPlayer.setDisable(true);
                }
            }
        };
        twoPlayer.setOnAction(numberOfPlayers);
        threePlayer.setOnAction(numberOfPlayers);
        fourPlayer.setOnAction(numberOfPlayers);
        //********************End of Number of Players Button Handler*****************************


        //*****************Start of Each card in player hand event handler************************
        EventHandler<ActionEvent> cards = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                AIPLay();
                int counter = 0;
                Button b = (Button) event.getSource();
                b.setDisable(true);
                b.setMinSize(30, 80);
                playedCards.getChildren().add(b);
                playedCards.setSpacing(-10);
                playedCards.setAlignment(Pos.CENTER);
                pane2.setCenter(playedCards);
                newGame.inPlay.add((Card) b.getUserData());
                if (counter == 0) {
                    newGame.trumpCard = newGame.inPlay.get(0);
                    counter++;
                    for (Card A:newGame.dealer.getDeck().cards
                    ) {
                        if(A.getSuitH() == newGame.trumpCard.getSuitH()){
                            A.setSuitH(20);
                        }
                    }

                }
                newGame.setTurn(newGame.getTurn());
                //******************************TWO PLAYER*****************
                if (newGame.playas.size() == 2) {
                    card7 = new Button();
                    newGame.AiPlayHand();
                    card7.setUserData(newGame.inPlay.get(1));
                    card7.setGraphic(newGame.inPlay.get(1).getCardImage());
                    card7.setMinSize(30, 80);
                    playedCards.getChildren().add(card7);
                    newGame.print();
                    newGame.twoplayacheckWin();
                    newGame.inPlay.removeAll(newGame.inPlay);
                    back.setOnAction(e -> {
                        playedCards.getChildren().removeAll(playedCards.getChildren());
                    });

                    if (newGame.getTurn() == 6) {
                        playedCards.getChildren().removeAll(playedCards.getChildren());
                        if(newGame.allPlayerWinner()){
                            reset.fire();
                        }else {
                            newGame.clearHands();
                            newGame.setCards(card1, card2, card3, card4, card5, card6);
                            displayCardsAgain();
                            setAIbids();
                            newGame.resetTurn();
                        }
                    }
                }
                //************************THREE PLAYER*************************
                else if (newGame.playas.size() == 3) {
                    card7 = new Button();
                    card8 = new Button();
                    newGame.AiPlayHand();
                    if(newGame.inPlay.size()==3) {
                        card7.setUserData(newGame.inPlay.get(1));
                        card7.setGraphic(newGame.inPlay.get(1).getCardImage());
                        card7.setMinSize(30, 80);
                        card7.setTranslateX(30);
                        card7.setTranslateY(30);
                        card8.setUserData(newGame.inPlay.get(2));
                        card8.setGraphic(newGame.inPlay.get(2).getCardImage());
                        card8.setMinSize(30, 80);
                        card8.setTranslateX(30);
                        card8.setTranslateY(30);
                        playedCards.getChildren().addAll(card7, card8);
                    }
                    newGame.print();
                    newGame.threePlayerCheckWin();
                    newGame.inPlay.removeAll(newGame.inPlay);
                    System.out.println(newGame.inPlay.size());
                    back.setOnAction(e -> {
                        playedCards.getChildren().removeAll(playedCards.getChildren());
                    });
                    if (newGame.getTurn() == 6) {
                        playedCards.getChildren().removeAll(playedCards.getChildren());
                        if(newGame.allPlayerWinner()){
                            reset.fire();
                        }else {
                            newGame.clearHands();
                            newGame.setCards(card1, card2, card3, card4, card5, card6);
                            displayCardsAgain();
                            setAIbids();
                            newGame.resetTurn();
                        }
                    }
                }
                //*****************************FOUR PLAYER**********************************
                else if (newGame.playas.size() == 4) {
                    card7 = new Button();
                    card8 = new Button();
                    card9 = new Button();
                    newGame.AiPlayHand();
                    if(newGame.inPlay.size()==4) {
                        card7.setUserData(newGame.inPlay.get(1));
                        card7.setGraphic(newGame.inPlay.get(1).getCardImage());
                        card7.setMinSize(30, 80);
                        card7.setTranslateX(30);
                        card7.setTranslateY(30);
                        card8.setUserData(newGame.inPlay.get(2));
                        card8.setGraphic(newGame.inPlay.get(2).getCardImage());
                        card8.setMinSize(30, 80);
                        card8.setTranslateX(30);
                        card8.setTranslateY(30);
                        card9.setUserData(newGame.inPlay.get(3));
                        card9.setGraphic(newGame.inPlay.get(3).getCardImage());
                        card9.setMinSize(30, 80);
                        card9.setTranslateX(30);
                        card9.setTranslateY(30);
                        playedCards.getChildren().addAll(card7,card8,card9);
                    }
                    newGame.print();
                    newGame.fourPlayerCheckWin();
                    newGame.inPlay.removeAll(newGame.inPlay);
                    System.out.println(newGame.inPlay.size());
                    back.setOnAction(e -> {
                        playedCards.getChildren().removeAll(playedCards.getChildren());
                    });
                    if (newGame.getTurn() == 6) {
                        playedCards.getChildren().removeAll(playedCards.getChildren());
                        if(newGame.allPlayerWinner()){
                            reset.fire();
                        }else {
                            newGame.clearHands();
                            newGame.setCards(card1, card2, card3, card4, card5, card6);
                            displayCardsAgain();
                            setAIbids();
                            newGame.resetTurn();
                        }
                    }
                }
            }
        };
        card1.setOnAction(cards);
        card1.setTranslateX(10);
        card1.setTranslateY(30);
        card2.setOnAction(cards);
        card2.setTranslateX(10);
        card2.setTranslateY(30);
        card3.setOnAction(cards);
        card3.setTranslateX(10);
        card3.setTranslateY(30);
        card4.setOnAction(cards);
        card4.setTranslateX(10);
        card4.setTranslateY(30);
        card5.setOnAction(cards);
        card5.setTranslateX(10);
        card5.setTranslateY(30);
        card6.setOnAction(cards);
        card6.setTranslateX(10);
        card6.setTranslateY(30);
        //********************End of cards event handler***************************************


        //***************Bidding button event handler ******************************************
        EventHandler<ActionEvent> biddings = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int checkBids=0;
                Button b = (Button) event.getSource();
                if (b == bid2) {
                    newGame.playas.get(0).setBid(2);
                } else if (b == bid3) {
                    newGame.playas.get(0).setBid(3);
                } else if (b == bid4) {
                    newGame.playas.get(0).setBid(4);
                } else if (b == smudge) {
                    newGame.playas.get(0).setBid(5);
                } else if (b == pass) {
                    newGame.playas.get(0).setBid(0);
                }

                newGame.AIPlaceBid();
                for(Player A:newGame.playas){
                    if(A.getBid()==0){
                        checkBids++;
                    }
                }
                System.out.println(checkBids);
                if(checkBids==newGame.playas.size()){
                    newGame.clearHands();
                    newGame.setCards(card1, card2, card3, card4, card5, card6);
                    displayCardsAgain();
                    setAIbids();
                    checkBids=0;
                }else {

                    if (newGame.playas.size() == 2) {
                        displayP1Bid.setText("Player " + newGame.playas.get(0).getID() + " placed " + newGame.playas.get(0).getBid() + "Bids\n");
                        displayP2Bid.setText("Player " + newGame.playas.get(1).getID() + " Placed " + newGame.playas.get(1).getBid() + " Bids\n");
                        bidss.getChildren().addAll(displayP1Bid, displayP2Bid);
                    } else if (newGame.playas.size() == 3) {
                        displayP1Bid.setText("Player " + newGame.playas.get(0).getID() + " placed " + newGame.playas.get(0).getBid() + "Bids\n");
                        displayP2Bid.setText("Player " + newGame.playas.get(1).getID() + " Placed " + newGame.playas.get(1).getBid() + " Bids\n");
                        displayP3Bid.setText("Player " + newGame.playas.get(2).getID() + " Placed " + newGame.playas.get(2).getBid() + " Bids\n");
                        bidss.getChildren().addAll(displayP1Bid, displayP2Bid, displayP3Bid);
                    } else if (newGame.playas.size() == 4) {
                        displayP1Bid.setText("Player " + newGame.playas.get(0).getID() + " placed " + newGame.playas.get(0).getBid() + "Bids\n");
                        displayP2Bid.setText("Player " + newGame.playas.get(1).getID() + " Placed " + newGame.playas.get(1).getBid() + " Bids\n");
                        displayP3Bid.setText("Player " + newGame.playas.get(2).getID() + " Placed " + newGame.playas.get(2).getBid() + " Bids\n");
                        displayP4Bid.setText("Player " + newGame.playas.get(3).getID() + " Placed " + newGame.playas.get(3).getBid() + " Bids\n");
                        bidss.getChildren().addAll(displayP1Bid, displayP2Bid, displayP3Bid, displayP4Bid);
                    }

                    card1.setDisable(false);
                    card2.setDisable(false);
                    card3.setDisable(false);
                    card4.setDisable(false);
                    card5.setDisable(false);
                    card6.setDisable(false);
                    bid2.setDisable(true);
                    bid3.setDisable(true);
                    bid4.setDisable(true);
                    smudge.setDisable(true);
                    pass.setDisable(true);
                    bidss.setVisible(true);
                }
            }
        };
        bid2.setOnAction(biddings);
        bid3.setOnAction(biddings);
        bid4.setOnAction(biddings);
        smudge.setOnAction(biddings);
        pass.setOnAction(biddings);
        //****************End of bidding event handler**************************************8


        //******************Two scene panes and storing it into the Hashmap*******************
        pane.setBackground(new Background(grayBG));
        paneCenter.setAlignment(Pos.CENTER);
        pane.setCenter(paneCenter);
        pane.setTop(displayName);
        displayName.setAlignment(Pos.TOP_CENTER);
        displayName.getChildren().removeAll();
        displayName.getChildren().addAll(text);
        paneCenter.getChildren().removeAll();
        paneCenter.getChildren().addAll(start, twoPlayer, threePlayer, fourPlayer, Exit);
        scene = new Scene(pane, 800, 700);
        primaryStage.setScene(scene);
        scene2 = new Scene(pane2, 800, 700);
        sceneMap.put("welcome", scene);
        sceneMap.put("gamePlay", scene2);
        primaryStage.show();
        //*********************End of the scenes*******************************************
    }

    //**************************Display the playing cards
    public void displayCardsAgain() {
        cards2.getChildren().removeAll(cards2.getChildren());
        v.setFitHeight(400);
        v.setFitWidth(200);
        v.setRotate(90);
        v.setPreserveRatio(true);
        w.setFitHeight(400);
        w.setFitWidth(200);
        w.setRotate(180);
        w.setPreserveRatio(true);
        x.setFitHeight(400);
        x.setFitWidth(200);
        x.setRotate(270);
        x.setPreserveRatio(true);
        pane2.setBackground(new Background(darkGrayBG));
        pane2.setBottom(bidd);
        bidss.getChildren().removeAll(displayP1Bid,displayP2Bid,displayP3Bid,displayP4Bid);
        pane2.setTop(bidss);
        bidss.setAlignment(Pos.TOP_LEFT);
        bidss.setVisible(false);
        bidd.getChildren().removeAll(bidd.getChildren());
        bidd.getChildren().addAll(bid2, bid3, bid4, smudge, pass);
        bidd.setAlignment(Pos.BASELINE_LEFT);
        bidd.setTranslateY(-15);
        cards2.setAlignment(Pos.BASELINE_CENTER);
        options.setAlignment(Pos.BASELINE_RIGHT);
        pane2.setBottom(options);
        pane2.setBottom(cards2);
        cards2.getChildren().removeAll(cards2.getChildren());
        options.getChildren().removeAll(options.getChildren());
        cards2.getChildren().addAll(card1, card2, card3, card4, card5, card6);
        options.getChildren().addAll(back,reset);
        if (newGame.playas.size() == 2) {
            bidss.getChildren().removeAll(displayP1Bid,displayP2Bid);
            pane2.setBottom(player1);
            pane2.setLeft(player2);
            player1.setAlignment(Pos.BASELINE_CENTER);
            player2.setAlignment(Pos.CENTER_LEFT);
            player1.setSpacing(40);
            player1.getChildren().removeAll();
            player1.getChildren().addAll(bidd, cards2,options);
            player2.getChildren().remove(v);
            player2.getChildren().add(v);
        } else if (newGame.playas.size() == 3) {
            bidss.getChildren().removeAll(displayP1Bid,displayP2Bid,displayP3Bid);
            pane2.setBottom(player1);
            pane2.setLeft(player2);
            pane2.setTop(player3);
            player1.setAlignment(Pos.BASELINE_CENTER);
            player2.setAlignment(Pos.CENTER_LEFT);
            player3.setAlignment(Pos.TOP_CENTER);
            player1.setSpacing(40);
            player1.getChildren().removeAll(bidd, cards2,options);
            player1.getChildren().addAll(bidd, cards2,options);
            player2.getChildren().remove(v);
            player2.getChildren().add(v);
            player3.getChildren().removeAll(bidss,w);
            player3.getChildren().addAll(bidss,w);
            bidss.setTranslateX(-200);
        } else if (newGame.playas.size() == 4) {
            bidss.getChildren().removeAll(displayP1Bid,displayP2Bid,displayP3Bid,displayP4Bid);
            pane2.setBottom(player1);
            pane2.setLeft(player2);
            pane2.setTop(player3);
            pane2.setRight(player4);
            player1.setAlignment(Pos.BASELINE_CENTER);
            player2.setAlignment(Pos.CENTER_LEFT);
            player3.setAlignment(Pos.TOP_CENTER);
            player4.setAlignment(Pos.CENTER_RIGHT);
            player1.setSpacing(40);
            player1.getChildren().removeAll(bidd, cards2,options);
            player1.getChildren().addAll(bidd, cards2,options);
            player2.getChildren().remove(v);
            player2.getChildren().add(v);
            player3.getChildren().removeAll(bidss,w);
            player3.getChildren().addAll(bidss,w);
            bidss.setTranslateX(-200);
            player4.getChildren().remove(x);
            player4.getChildren().add(x);
        }
    }//*******************************End of Display Cards


    //*****************************Ask for bids******************************
    public void setAIbids() {
        card.setDisable(true);
        card1.setDisable(true);
        card2.setDisable(true);
        card3.setDisable(true);
        card4.setDisable(true);
        card5.setDisable(true);
        card6.setDisable(true);
        bid2.setDisable(false);
        bid3.setDisable(false);
        bid4.setDisable(false);
        smudge.setDisable(false);
        pass.setDisable(false);
    }//***********************************End of Bidding

    public boolean AIPLay(){
        if(newGame.playas.get(0).getID()!=1) {
            int counter = 0;
            newGame.inPlay.add(newGame.playas.get(0).hand.get(0));
            card7 = new Button();
            card7.setUserData(newGame.inPlay.get(0));
            card7.setGraphic(newGame.inPlay.get(0).getCardImage());
            card7.setMinSize(30, 80);
            playedCards.getChildren().add(card7);
            playedCards.setAlignment(Pos.CENTER);
            pane2.setCenter(playedCards);
            if (counter == 0) {
                newGame.trumpCard = newGame.inPlay.get(0);
                counter++;
                for (Card A : newGame.dealer.getDeck().cards
                ) {
                    if (A.getSuitH() == newGame.trumpCard.getSuitH()) {
                        A.setSuitH(20);
                    }
                }

            }
            newGame.setTurn(newGame.getTurn());
        }
        return true;
    }
}
