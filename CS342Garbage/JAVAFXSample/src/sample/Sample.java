package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.util.HashMap;

import java.awt.*;
import java.util.Scanner;

import java.util..function;

public class Sample extends Application {

    TextField text;
    Button btn;
    VBox paneCenter;
    Scene scene;
    Menu menuBar;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple JavaFX Application");
        text = new TextField();
        btn = new Button("Touch Me!");

        Image img_one = new Image(Home.jpg);//Need jpg in the same folder


        //Creating img view (Object)

        //Stick the img in there

        ImageView object = new ImageView(img_one);

        object.setFitWidth(250);
        object.setFitHeight(250);

        object.setPreserveRatio(true);

        //NOT IN SCENCE GRAPH YET





        menuBar = new MenuBar();

        Menu menuOne = new Menu("Option One");
        Menu menuTwo = new Menu("Option two");
        Menu menuThree = new Menu("Option three");


        MenuItem one = new MenuItem("Red");
        MenuItem two = new MenuItem("Green");
        MenuItem three = new MenuItem("CLEAR text");


        three.setOnAction(Parameter->text.clear());
        menuOne.getItem().addAll(one,two,three);

        menuBar.getMenus().addAll(menuOne,menuTwo,menuThree);


        ///Create change in color

        one.setOnAction(e->{paneCenter.setStyle("-fx-background-color: seagreen;" +
                        "-fx-border-color: aqua;" + "-fx-border-width: 4;");
                        text.setStyle();
        }

        );


        //Add Image to GUI




        //Create an instance of a class buttonStuff

        /*****
         * Observe how normally we would have to extend Event Handler to access buttonStuff
         *
         *****/


        /*

        Looonnnggg Wayy
        EventHandler<ActionEvent> buttonStuff = new EventHandler<ActionEvent>(){
            public void handle(ActiveEvent event){
                text.setText("Poke");
            }
        };

        btn.setOnAction(buttonStuff);
        */


        //Give no name

        ///Saying Hey attach handler to this button
        //Pass as a parameter

        //Give me this (A new Handler)


        /***
        btn.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActiveEvent event){
                text.setText("Poke");
            }
        };);
        ****/

        //The Best way
        //Lambda Expressions!
        //Parameter is an EventHandler
        //Parameter is an Interface

        //After -----> body of Method

        //Why?

        /****
         *
         *
         * EventHandler accepts only one method
         *
         *
         * Would not work if had three abstract methods.
         * ***/

        btn.setOnAction(functionParameter->text.setText("Implemeted using lambda expressions"));
        scene = new Scene(paneCenter,700,700);
        primaryStage.setScene(scene);//

        paneCenter = new VBox(200,text,btn,object);

        primaryStage.show();


        sceneMap = new HashMap<String,Scene>();
        //Store as many scenes as we want


    }
}
