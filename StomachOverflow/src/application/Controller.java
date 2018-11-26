package application;

import java.io.IOException;
import application.ScenceStack;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller implements Initializable {

	private Button back;
	private Button faq;
	private Button help;
	private Button searchLocation;
	private Button about;
	private Button reviews;
	private Button logInHome;
	private Button homeLogIn;
	
	protected DSLinkedStack<Scene> sceneStack;

	public void initialize(URL arg0V, ResourceBundle arg1) {
		sceneStack = new DSLinkedStack<Scene>();
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

	public void search(ActionEvent e) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("RestList.fxml"));
			ScenceStack.push(((Node) e.getSource()).getScene());
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root, 1280, 720));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void about(ActionEvent e) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("About.fxml"));
			ScenceStack.push(((Node) e.getSource()).getScene());
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root, 1280, 720));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void reviews(ActionEvent e) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Reviews.fxml"));
			ScenceStack.push(((Node) e.getSource()).getScene());
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root, 1280, 720));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void faq(ActionEvent e) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("FAQ.fxml"));
			ScenceStack.push(((Node) e.getSource()).getScene());
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root, 1280, 720));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void signUp(ActionEvent e) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
			ScenceStack.push(((Node) e.getSource()).getScene());
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root, 1280, 720));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void help(ActionEvent e) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Help.fxml"));
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
}
