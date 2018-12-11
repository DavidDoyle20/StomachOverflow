package application;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.scene.image.ImageView;

public class Restaurant implements Comparable<Restaurant> {
    private DecimalFormat f; 
	private String name;
	private int id;
	private String address;
	private String number;
	private String email;
	private String hours;
	private String genre;
	private String priceRange;
	private double averagePrice = 0;
	private double averageRating = 0;
	private ImageView image;
	private double numericalRating = 0;
	private ArrayList<Review> review = new ArrayList<Review>();
	private ArrayList<FoodItem> menuItems = new ArrayList<FoodItem>();

	public Restaurant(String name, String address, String number, String email, String hours, String genre,
			String priceRange, ImageView photo, ArrayList<FoodItem> menuItems) {
		f = new DecimalFormat("##.00");
		this.name = name;
		this.id = name.hashCode();
		this.address = address;
		this.number = number;
		this.email = email;
		this.hours = hours;
		this.genre = genre;
		this.priceRange = priceRange;
		this.image = photo;
		image.setFitWidth(120);
		image.setPreserveRatio(true);
		image.setSmooth(true);
		image.setCache(true);
		this.menuItems = menuItems;
		for(FoodItem x: menuItems) {
			averagePrice += x.getPrice();
		}
		averagePrice /= menuItems.size();
		averagePrice = Double.parseDouble(f.format(averagePrice));
		
	}

	public double getNumericalRating() {
		return numericalRating;
	}

	public void setNumericalRating(double numericalRating) {
		this.numericalRating = numericalRating;
	}

	public ArrayList<Review> getReviews() {
		return review;
	}
	public void addReview(Review toAdd) {
		review.add(toAdd);
	}
	public void refreshNumericalRating() {
		double sum = 0;
		for(Review x: review) {
			sum += x.getRating();
		}
		numericalRating = (double)Math.round((sum / review.size()) * 100.0) / 100.0;
		averageRating = Double.parseDouble(f.format(numericalRating / review.size()));
	}
	
	public ArrayList<Review> getReview() {
		return review;
	}

	public void setReview(ArrayList<Review> review) {
		this.review = review;
	}

	public double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.review = reviews;
	}

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

	public ImageView getImage() {
		return image;
	}

	public void setImage(ImageView image) {
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
