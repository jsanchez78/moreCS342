package com.company;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.Scanner;
import java.io.File;

public class Deck extends Card {

    ArrayList<Card> cards = new ArrayList<>();
    String Name;
    String Num;

    int val=0;
    int suit=0;
//    int suitH=0;
//    int suitS=0;
//    int suitC=0;


    Deck(){
        for(int i = 0;i<4;i++){
            if(i == 0){
                Name = "H";
                suit =1;
            }
            else if(i == 1){
                Name = "D";
                suit=2;
            }
            else if(i == 2){
                Name = "S";
                suit=3;
            }
            else if(i == 3){
                Name = "C";
                suit=4;
            }
            for(int j = 0;j<13;j++) {
                if(j==0){
                    Num = "2";
                    val = 2;
                }
                else if(j==1){
                    Num = "3";
                    val = 3;
                }
                else if(j==2){
                    Num = "4";
                    val =4;
                }
                else if(j==3){
                    Num = "5";
                    val = 5;
                }
                else if(j==4){
                    Num = "6";
                    val = 6;
                }
                else if(j==5){
                    Num = "7";
                    val = 7;
                }
                else if(j==6){
                    Num = "8";
                    val = 8;
                }
                else if(j==7){
                    Num = "9";
                    val = 9;
                }
                else if(j==8){
                    Num = "10";
                    val = 10;
                }
                else if(j==9){
                    Num = "J";
                    val = 11;
                }
                else if(j==10){
                    Num = "Q";
                    val = 12;
                }
                else if(j==11){
                    Num = "K";
                    val = 13;
                }
                else if(j==12){
                    Num = "A";
                    val = 14;
                }
                Card c = new Card(Num,Name);
                Image pic = new Image("/PNG/" + Num + Name + ".png");
                ImageView img = new ImageView(pic);
                img.setFitWidth(70);
                img.setFitHeight(140);
                c.setCardImage(img);
                c.setValue(val);
                c.setSuit(Name);
                c.setSuitH(suit);
                cards.add(c);
            }
        }
    }


}
