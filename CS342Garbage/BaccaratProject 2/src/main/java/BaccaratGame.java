import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.text.Element;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Function;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.SVGPath;


///sceneChangeBtn --> resetBtn
//addToListBtn ----> dealBtn
public class BaccaratGame extends Application{
	//Initialize variables accordingly


	TextField text;
	Button start;
	Button twoPlayer, threePlayer, fourPlayer;
	Button Exit;
	Button back;
	Button bid2, bid3, bid4, smudge, pass;
	Button card1, card2, card3, card4, card5, card6, card7,card8,card9;
	HashMap<String, Scene> sceneMap;
	Stage myStage;
	Scene scene, scene2;
	HBox player1 = new HBox();
	VBox player2 = new VBox();
	HBox player3 = new HBox();
	VBox player4 = new VBox();
	HBox playedCards = new HBox();
	BorderPane pane2 = new BorderPane();
	//BackgroundFill grayBG = new BackgroundFill(Color.GRAY,new CornerRadii(1),new Insets(0.0,0.0,0.0,0.0));
	//BackgroundFill darkGrayBG = new BackgroundFill(Color.GREEN, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
	ImageView card = new ImageView();
	Image img = new Image("/images/donpark-scalable-css-playing-cards-d05a022/assets/club.svg");
	ImageView v = new ImageView(img);
	ImageView w = new ImageView(img);
	ImageView x = new ImageView(img);
	Button reset = new Button();
	BorderPane pane = new BorderPane();
	HBox paneCenter = new HBox();
	HBox displayName = new HBox();
	TextField displayP1Bid = new TextField();
	TextField displayP2Bid = new TextField();
	TextField displayP3Bid = new TextField();
	TextField displayP4Bid = new TextField();
	VBox bidss = new VBox();
	HBox cards2 = new HBox();
	VBox bidd = new VBox();
	VBox options = new VBox();
	boolean resetpressed = false;
	//constant values java style
	static final int picHeight = 275;
	static final int picWidth = 250;
	EventHandler<ActionEvent> returnButtons;
	PauseTransition pause = new PauseTransition(Duration.seconds(3));


	Button addToListBtn, resetBtn, b4,b5,b6,b7, dealBtn;
	GenericQueue<String> myQueue;
	ListView<String> displayQueueItems;
	//use this to add and delete from ListView
	ObservableList<String> storeQueueItemsInListView;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

    //feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("JavaFx Scene change and ListView");

		text = new TextField();
		dealBtn = new Button("Deal");
		resetBtn = new Button("Reset");
		//dealBtn = new Button("PrintList");
		sceneMap = new HashMap<String,Scene>();
		//stores strings: from your project #1
		myQueue = new GenericQueue<String>(" ");
		displayQueueItems = new ListView<String>();
		//initialize to an observable list
		storeQueueItemsInListView = FXCollections.observableArrayList();


		//styling CSS way
		text.setStyle("-fx-font-size: 18;"+"-fx-border-size: 20;"+
				"-fx-border-color: green;");

		displayQueueItems.setStyle("-fx-font-size: 25;"+"-fx-border-size: 20;"+
				"-fx-border-color: green;");

		//using lambda for EventHandler: press enter adds info from text field to queue
		text.setOnKeyPressed(e -> {if(e.getCode().equals(KeyCode.ENTER)){
			myQueue.enqueue(text.getText());
			text.clear();
		}
		});
		//pause for 3 seconds then switch scene from picture buttons to original layout
		pause.setOnFinished(e->primaryStage.setScene(sceneMap.get("scene")));
		//this handler is used by multiple buttons
		returnButtons = new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				Button b = (Button)event.getSource();
				b.setDisable(true);
				//	primaryStage.setScene(sceneMap.get("scene"));
				pause.play(); //calls setOnFinished
			}
		};
		/*
		//add queue items to observable list and display inside of ListView
		dealBtn.setOnAction(e-> {displayQueueItems.getItems().removeAll(storeQueueItemsInListView);storeQueueItemsInListView.clear();
			Iterator<String> i = myQueue.createIterator();
			while(i.hasNext()) {
				storeQueueItemsInListView.add(i.next());
			}
			displayQueueItems.setItems(storeQueueItemsInListView);});
	*/
		resetBtn.setOnAction(e -> primaryStage.setScene(sceneMap.get("pics")));

		dealBtn.setOnAction(new EventHandler<ActionEvent>(){

			public void handle(ActionEvent event){
				myQueue.enqueue(text.getText());;
				text.clear();

			}
		});
		//two scenes returned from two methods; put in hashmap
		sceneMap.put("scene", createControlScene());
		sceneMap.put("pics", createPicScene());

		primaryStage.setScene(sceneMap.get("scene"));
		primaryStage.show();
	}


	//method to create our first scene with controls
	public Scene createControlScene() {

		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(70));

		VBox paneCenter = new VBox(10, text, dealBtn, displayQueueItems);

		pane.setCenter(paneCenter);
		pane.setLeft(resetBtn);
		pane.setStyle("-fx-background-color: #6DB47A;");

		dealBtn.setTranslateX(10);
		dealBtn.setTranslateY(10);

		resetBtn.setTranslateX(10);
		resetBtn.setTranslateY(10);
		return new Scene(pane, 850, 750);
	}

	//method to create second scene with clickable buttons
	public Scene createPicScene() {

		Image pic = new Image("/images/donpark-scalable-css-playing-cards-d05a022/assets/club.svg");
		ImageView v = new ImageView(pic);
		v.setFitHeight(picHeight);
		v.setFitWidth(picWidth);
		v.setPreserveRatio(true);

		Image pic2 = new Image("/images/donpark-scalable-css-playing-cards-d05a022/assets/spade.svg");
		ImageView v2 = new ImageView(pic2);
		v2.setFitHeight(picHeight);
		v2.setFitWidth(picWidth);
		v2.setPreserveRatio(true);

		Image pic3 = new Image("/images/donpark-scalable-css-playing-cards-d05a022/assets/diamond.svg");
		ImageView v3 = new ImageView(pic3);
		v3.setFitHeight(picHeight);
		v3.setFitWidth(picWidth);
		v3.setPreserveRatio(true);

		Image pic4 = new Image("/images/donpark-scalable-css-playing-cards-d05a022/assets/heart.svg");
		ImageView v4 = new ImageView(pic4);
		v4.setFitHeight(picHeight);
		v4.setFitWidth(picWidth);
		v4.setPreserveRatio(true);

		b4 = new Button();
		b4.setOnAction(returnButtons);
		b4.setGraphic(v);
		b5 = new Button();
		b5.setOnAction(returnButtons);
		b5.setGraphic(v2);
		b6 = new Button();
		b6.setGraphic(v3);
		b6.setOnAction(returnButtons);
		b7 = new Button();
		b7.setGraphic(v4);
		b7.setOnAction(returnButtons);

		HBox root = new HBox(5, b7,b5,b6,b4);
		root.setStyle("-fx-background-color: #6DB47A;");

		return new Scene(root, 900,800);

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



