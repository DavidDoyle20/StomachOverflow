package application;

import java.util.ArrayList;
import javafx.scene.image.Image;
import java.util.PriorityQueue;

public class Restaurant implements Comparable<Restaurant> {
	private String name;
	private int id;
	private String address;
	private String number;
	private String email;
	private String hours;
	private String genre;
	private String priceRange;
	private Image image;

	// private ArrayList<Review> rewiews = new ArrayList<Review>;
	private ArrayList<FoodItem> menuItems = new ArrayList<FoodItem>();

	public Restaurant(String name, String id, String address, String number, String email, String hours, String genre,
			String priceRange, Image image, ArrayList<FoodItem> menuItems) {
		this.name = name;
		this.id = name.hashCode();
		this.address = address;
		this.number = number;
		this.email = email;
		this.hours = hours;
		this.genre = genre;
		this.priceRange = priceRange;
		this.image = image;
		this.menuItems = menuItems;
	}

	/*
	 * public ArrayList<Review> getReviews() { return reviews; }
	 * 
	 * public void setReviews(ArrayList<Review> reviews) { this.reviews = reviews; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ArrayList<FoodItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(ArrayList<FoodItem> menuItems) {
		this.menuItems = menuItems;
	}
	
	public void AddMenuItem(FoodItem x) {
		menuItems.add(x);
	}
	@Override
	public int compareTo(Restaurant o) {
		if (o.getName().compareTo(name) < 0) {
			return -1;
		} else if (o.getName().compareTo(name) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
