package application;

import javafx.scene.image.Image;

public class FoodItem implements Comparable<FoodItem> {

	private String name;
	private double price;
	private Image image;

	public FoodItem(String name, double price, Image image) {
		this.name = name;
		this.price = price;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public int compareTo(FoodItem o) {
		if (o.getPrice() < price) {
			return -1;
		} else if (o.getPrice() > price) {
			return 1;
		} else {
			return 0;
		}
	}

}
