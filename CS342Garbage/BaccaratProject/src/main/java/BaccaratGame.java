import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.FileNotFoundException;
import javafx.scene.control.MenuItem;

///sceneChangeBtn --> resetBtn
//addToListBtn ----> dealBtn
public class BaccaratGame extends Application{

    //Data Members
    ArrayList<Card> playerHand;
    ArrayList<Card> bankerHand;
    BaccaratDealer theDealer;
    BaccaratGameLogic gameLogic;
    double currentBet;
    double totalWinnings;
    String who_we_bet_on;
    Stage primaryStage;


    BaccaratGame(){
        this.totalWinnings = 1000;
        this.currentBet = 0;
        this.theDealer = new BaccaratDealer();
        this.theDealer.generateDeck();
        //this.playerHand = new ArrayList<>();
        //this.bankerHand = new ArrayList<>();
        this.playerHand = theDealer.dealHand();
        this.bankerHand = theDealer.dealHand();
        this.gameLogic = new BaccaratGameLogic();
        this.who_we_bet_on = null;
    }
    /*****
     *
     *
     *
     *
     *
     * Methods
     *
     *
     *
     *
     *
     * **********/
    public double evaluateWinnings(){

        if(gameLogic.whoWon(this.playerHand,this.bankerHand).equals("Player" ) && who_we_bet_on.equals("Player"))
            this.totalWinnings = this.currentBet * 2;
        else if(gameLogic.whoWon(this.playerHand,this.bankerHand).equals("Banker")  && who_we_bet_on.equals("Banker"))
            this.totalWinnings = this.currentBet * 0.95;
        else if(gameLogic.whoWon(this.playerHand,this.bankerHand).equals("Draw") && who_we_bet_on.equals("Draw")){///Draw
            this.totalWinnings = this.currentBet*8;
        }
        else{
            this.totalWinnings -= this.currentBet;
        }
        System.out.println(this.totalWinnings);
        return this.totalWinnings;
    }
	/**
	 *
	 *
	 *
	 *
	 * Variables all initialized here
	 * Mainly variables to get started with the GUI
	 *
	 *
	 *
	 *
	 *
	 *
	 * */
	TextField text;
	Button btn;
	VBox paneCenter;
	Scene scene;
    MenuItem exit;
    MenuItem restart;
	HashMap<String, Scene> sceneMap;
	BorderPane pane;
    MenuBar menuBar;
    MenuBar menu;
    Image spades_img;
   // Menu options;
    PauseTransition pause = new PauseTransition(Duration.seconds(3));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //launch(args);
        
	}
    /*****************************************
	 *
	 *
	 *
	 * Event Driven Programming goes here
	 *
	 *
	 *
	 *
	 *****************************************/
	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {
        this.primaryStage = primaryStage;
        // TODO Auto-generated method stub

        primaryStage.setTitle("Let's play Baccarat");
        //Background
        BorderPane root = new BorderPane();
        Region board = new Region();
        //board.setStyle("");



        //Define menu exist and restart
        menuBar = new MenuBar();
        Menu options = new Menu("Options");


        MenuItem exit = new MenuItem("Exit");
        MenuItem restart = new MenuItem("Restart");
        HBox bottom = new HBox();


        /********************************/
        /*****Event Handler for Menu   *****/
        //Set actions for items in menu


        exit.setOnAction(e->primaryStage.close());
        restart.setOnAction(e-> {
            try {
                restart(primaryStage);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                //e1.printStackTrace();
            }
        });


        //add menu to stage
        options.getItems().addAll(exit, restart);
        menu.getMenus().add(options);

        pane.setTop(menu);

        BackgroundImage myBI= new BackgroundImage(new Image("/Users/jsanch75/CS342/BaccaratProject/src/main/resources/images/donpark-scalable-css-playing-cards-d05a022/assets/background-table.png",1300,700,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));
        pane.setBottom(bottom);


        //sceneMap.put("scene", createControlScene());
        //sceneMap.put("pics", createPicScene());

        primaryStage.setScene(sceneMap.get("scene"));
        primaryStage.show();
    }
    //Restarts the Game
    void restart(Stage primaryStage) throws FileNotFoundException{
	    start(primaryStage);
    }




    //Methods
    public ArrayList<Card> getBankerHand(){

        return this.bankerHand;
    }
    public void  setBankerHand(Card card){

        bankerHand.add(card);
    }
    public ArrayList<Card> getPlayerHand(){

        return this.playerHand;
    }
    public void  setPlayerHandHand(Card card){
        playerHand.add(card);
    }


}