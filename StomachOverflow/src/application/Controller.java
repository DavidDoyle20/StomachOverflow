package application;

import java.io.IOException;

import application.ScenceStack;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.HashMap;

public class Controller implements Initializable {
	
	private Account testAccount = new Account("david", "doyle");
	private String testKey = testAccount.getUsername().hashCode() + "";
	private Button back;
	private Button faq;
	private Button help;
	private Button searchLocation;
	private Button about;
	private Button reviews;
	private Button logInHome;
	private Button homeLogIn;
	@FXML
	private TextField userNameLogIn;
	@FXML
	private TextField passwordLogIn;
	@FXML
	private TextField userNameSignUp;
	@FXML
	private TextField passwordSignUp;
	@FXML
	private TextField passwordSignUpConfirm;  
	
	protected DSLinkedStack<Scene> sceneStack;

	public void initialize(URL arg0V, ResourceBundle arg1) {
		sceneStack = new DSLinkedStack<Scene>();
		AccountHashMap.put(testKey, testAccount);
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
			root = FXMLLoader.load(getClass().getResource("Rest.fxml"));
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
	
	public void signUpAction(ActionEvent e) {
		String key = userNameSignUp.getText().hashCode() + "";
		Account newAccount = new Account(userNameSignUp.getText() , passwordSignUp.getText());
		AccountHashMap.put(key, newAccount);
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
	
	public void login(ActionEvent e) {
		String key = userNameLogIn.getText().hashCode() + "";
		if(AccountHashMap.get(key) == null) {
			System.out.println("no name");
		}
		else {
			if(AccountHashMap.get(key).getPassword().equals(passwordLogIn.getText())) {
				System.out.println("yes");
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
			else {
				System.out.println(AccountHashMap.get(key).getPassword());
				System.out.println(passwordLogIn.getText());
				userNameLogIn.setText("Wrong Password");
				passwordLogIn.setText("Wrong Password");
				System.out.println("no");
			}
		}
		
	}
}
