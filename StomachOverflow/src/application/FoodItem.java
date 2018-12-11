package application;

import javafx.scene.image.ImageView;

public class FoodItem implements Comparable<FoodItem> {

	private String name;
	private double price;
	private ImageView image;
	private String amount;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public FoodItem(String name, double price, ImageView image) {
		this.name = name;
		this.price = price;
		this.image = image;
		this.amount = "0";
		image.setFitWidth(120);
		image.setPreserveRatio(true);
		image.setSmooth(true);
		image.setCache(true);
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

	public ImageView getImage() {
		return image;
	}

	public void setImage(ImageView image) {
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
