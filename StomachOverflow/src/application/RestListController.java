package application;

import java.io.IOException;
import java.util.Stack;

import application.ScenceStack;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.HashMap;

public class RestListController implements Initializable {
	@FXML
	private TableView<Restaurant> RestaurantTable; 
	@FXML
	private TableColumn<Restaurant, String> RestaurantName; 
	@FXML
	private TableColumn<Restaurant, ImageView> images;
	@FXML
	private TableColumn<Restaurant, String> desc;
	@FXML
	private TableColumn<Restaurant, Double> averagePrice;
	@FXML
	private TableColumn<Restaurant, Double> ratingDesc;
	@FXML
	private TableColumn<Restaurant, String> hours;
	
	private ObservableList <Restaurant> restaurants;
	
	protected Stack<Scene> sceneStack;

	public void initialize(URL arg0V, ResourceBundle arg1) {
		sceneStack = new Stack<Scene>();
		restaurants = FXCollections.observableArrayList();
		for(Restaurant x : RestaurantParser.ParseRestaurants()){
			restaurants.add(x);
		}
		RestaurantTable.setItems(restaurants);
		RestaurantName.setCellValueFactory(new PropertyValueFactory("name"));
		images.setCellValueFactory(new PropertyValueFactory("image"));
		desc.setCellValueFactory(new PropertyValueFactory("genre"));
		averagePrice.setCellValueFactory(new PropertyValueFactory("averagePrice"));
		ratingDesc.setCellValueFactory(new PropertyValueFactory("averageRating"));
		hours.setCellValueFactory(new PropertyValueFactory("hours"));

		
		
		
		
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

	public void logInPage(ActionEvent e) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
			ScenceStack.push(((Node) e.getSource()).getScene());
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root, 1280, 720));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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


	public void back(ActionEvent e) {
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.setScene(ScenceStack.top());
		ScenceStack.pop();
		
	}
	//Received some help from keven leng on figuring out how to pass the restaurant object from the list
	//to the restaurant description page
	public void seeRestaurant(ActionEvent e) {
		Parent root;

		RestaurantPasser.setPressed(RestaurantTable.getSelectionModel().getSelectedItem());
		try {
			root = FXMLLoader.load(getClass().getResource("Rest.fxml"));
			ScenceStack.push(((Node) e.getSource()).getScene());
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root, 1280, 720));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	
	
	
	
		
	}
