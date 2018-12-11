package application;

import java.io.IOException;
import java.util.Stack;
import application.ScenceStack;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.HashMap;

public class RestaurantController implements Initializable {

	private Button back;
	@FXML
	private TableView<FoodItem> menuTable;
	@FXML
	private TableColumn<FoodItem, String> names;
	@FXML
	private TableColumn<FoodItem, ImageView> images;
	@FXML
	private TableColumn<FoodItem, Double> prices;
	@FXML
	private TableColumn<FoodItem, String> amount;

	
	@FXML
	private TableView<Review> reviewTable;
	@FXML
	private TableColumn<Review, String> userName;
	@FXML
	private TableColumn<Review, Integer> rating;
	@FXML
	private TableColumn<Review, String> reviewDescription;
	@FXML
	private Label restaurantName;
	@FXML
	private Label address;
	@FXML
	private Label number;
	@FXML
	private Label emails;
	@FXML
	private Label hours;
	@FXML
	private Label genre;
	@FXML
	private Label total;
	@FXML
	private Label totalTax;
	@FXML
	private Label OrderConfirmation;
	@FXML
	private Label averageRating;
	@FXML
	private ImageView restaurantImage;
	@FXML
	private TextArea reviewText;
	@FXML
	private ChoiceBox<Integer> userRating;
	@FXML
	private Button submit;

	private ObservableList<FoodItem> fooditems;

	private ObservableList<Review> userRatings;
	
	protected Stack<Scene> sceneStack;

	public void initialize(URL arg0V, ResourceBundle arg1) {
		sceneStack = new Stack<Scene>();
		fooditems = FXCollections.observableArrayList();
		userRating.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
		System.out.println(RestaurantPasser.getPressed().getName());
		System.out.println(RestaurantPasser.getPressed().getMenuItems());
		for (FoodItem x : RestaurantPasser.getPressed().getMenuItems()) {
			fooditems.add(x);
		}
		menuTable.setItems(fooditems);
		menuTable.setEditable(true);
		names.setCellValueFactory(new PropertyValueFactory("name"));
		images.setCellValueFactory(new PropertyValueFactory("image"));
		prices.setCellValueFactory(new PropertyValueFactory("price"));
		amount.setCellValueFactory(new PropertyValueFactory("amount"));
		//Referenced https://docs.oracle.com/javafx/2/ui_controls/table-view.htm#CJAEHEBD when making this
		amount.setCellFactory(TextFieldTableCell.forTableColumn());
		amount.setOnEditCommit(new EventHandler<CellEditEvent<FoodItem, String>>(){
			public void handle(CellEditEvent<FoodItem, String> t) {
                ((FoodItem) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAmount((t.getNewValue()));
		}
		});
		
		
		
		
		userRatings = FXCollections.observableArrayList(RestaurantPasser.getPressed().getReviews());
		reviewTable.setItems(userRatings);
		
		userName.setCellValueFactory(new PropertyValueFactory("username"));
		rating.setCellValueFactory(new PropertyValueFactory("rating"));
		reviewDescription.setCellValueFactory(new PropertyValueFactory("reviewText"));
		
		
		
		
		restaurantName.setText(RestaurantPasser.getPressed().getName());
		address.setText(RestaurantPasser.getPressed().getAddress());
		number.setText(RestaurantPasser.getPressed().getNumber());
		emails.setText(RestaurantPasser.getPressed().getEmail());
		hours.setText(RestaurantPasser.getPressed().getHours());
		genre.setText(RestaurantPasser.getPressed().getGenre());
		restaurantImage.setImage(RestaurantPasser.getPressed().getImage().getImage());
		if(RestaurantPasser.getPressed().getNumericalRating() != 0) {
		averageRating.setText(RestaurantPasser.getPressed().getNumericalRating() + "");
		}
		else {
			averageRating.setText("No previous reviews");
		}
	}

	public void search(ActionEvent e) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("RestaurantList.fxml"));
			ScenceStack.push(((Node) e.getSource()).getScene());
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root, 1280, 720));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void homePage(Event e) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			ScenceStack.push(((Node) e.getSource()).getScene());
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root, 1280, 720));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void back(ActionEvent e) {
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.setScene(ScenceStack.top());
		ScenceStack.pop();

	}

	public void createReview(ActionEvent e) {
		if (AccountState.getCurrAcc() != null) {
			String reviewData = reviewText.getText();
			if (userRating.getValue() != null) {
				int score = userRating.getValue();
				System.out.println(score);
				Review userSubmission = new Review(reviewData, AccountState.getCurrAcc().getUsername(), score);
				RestaurantPasser.getPressed().addReview(userSubmission);
				RestaurantPasser.getPressed().refreshNumericalRating();
				averageRating.setText(RestaurantPasser.getPressed().getNumericalRating() + "");
				reviewTable.setItems(null);
				userRatings.add(userSubmission);
				reviewTable.setItems(userRatings);
			}
		}

	}
	public void sum(ActionEvent e) {
	    DecimalFormat f = new DecimalFormat("##.00");
		double sum = 0;
		for(FoodItem x: RestaurantPasser.getPressed().getMenuItems()) {
			sum += x.getPrice() * Integer.parseInt(x.getAmount());
		}
		
		total.setText("$" + f.format(sum));
		totalTax.setText("$" + f.format((sum+ (sum * 0.05))));
	}

	public void submitOrder(ActionEvent e) {
		OrderConfirmation.setText("Order placed! Thank you for shopping with us.");
	}
}
