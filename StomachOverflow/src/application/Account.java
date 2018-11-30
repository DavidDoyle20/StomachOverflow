package application;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Account {
	//INSERT SHIT CODE HERE
	
	private String username;
	private String password;
	private String name;
	private Image userImage;
	
	//private Review reviews;
	private DSLinkedStack<Scene> visitedRestaurants = new DSLinkedStack<Scene>();

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DSLinkedStack<Scene> getVisitedRestaurants() {
		return visitedRestaurants;
	}

	public void setVisitedRestaurants(DSLinkedStack<Scene> visitedRestaurants) {
		this.visitedRestaurants = visitedRestaurants;
	}
	
	
	
}
