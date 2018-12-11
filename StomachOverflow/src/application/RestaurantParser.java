package application;

import java.util.ArrayList;
import javafx.scene.image.ImageView;

public final class RestaurantParser {
	//This class parses the restaurant info txt file to create restaurant objects
	
	public static ArrayList<Restaurant> ParseRestaurants() {
		ArrayList<String> info = InputArrayList.createArrayList("RestaurantInfo.txt");
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		for (String x : info) {
			//Splitting all the different characteristics of each restaurant
			String[] restchar = x.split("[|]");
			
			//Getting all of the menu items into a seperate array.
			String[] items  = restchar[8].split(",");

			//Creating a menuItem object out of the array and adding it to the menuItems ArrayList
			ArrayList<FoodItem> menuItems = new ArrayList<FoodItem>();
			for(String food: items){
				String[] foodChar = food.split("[*]");	
				
				FoodItem menuItem = new FoodItem(foodChar[0], Double.parseDouble(foodChar[1]), new ImageView(foodChar[2]));
				menuItems.add(menuItem);
			}
			
			Restaurant toAdd = new Restaurant(restchar[0], restchar[1], restchar[2], restchar[3], 
					restchar[4], restchar[5], restchar[6], new ImageView(restchar[7]), menuItems);
			restaurants.add(toAdd);
			
		}
		return restaurants;
	}
	
	
}
