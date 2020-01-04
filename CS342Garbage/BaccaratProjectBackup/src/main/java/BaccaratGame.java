import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class BaccaratGame extends Application {


	TextField text;
	Button btn;
	VBox paneCenter;
	Scene scene;
	MenuBar menuBar;
	PauseTransition pause = new PauseTransition(Duration.seconds(3));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Let's Play Baccarat!!!");

		scene = new Scene(new HBox(),600,600);
		primaryStage.setScene(scene);
		primaryStage.show();
		paneCenter = new VBox(20, menuBar,text, btn);

		btn.setOnAction(e->text.setText("hello from the lambda version of EventHandler"));

		//how to pause action: see above for pause variable: basically it stops for the
		//set amount of time then calls an EventHandler
		//	btn.setOnAction(e->pause.play());




	}


	//Data Members
	private ArrayList<Card> playerHand;
	private ArrayList<Card> bankerHand;
	private BaccaratDealer theDealer;
	private BaccaratGameLogic gameLogic;
	private double currentBet;
	private double totalWinnings;

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

	public double evaluateWinnings(){
		return 0;
	}

}
