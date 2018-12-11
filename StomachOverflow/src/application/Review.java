package application;

public class Review {
	private String reviewText;
	private String username;
	private int rating;
	
	public Review(String reviewText, String username, int rating) {
		this.reviewText = reviewText;
		this.username = username;
		this.rating = rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
