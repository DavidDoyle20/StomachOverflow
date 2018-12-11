package application;

public final class RestaurantPasser {
	private static Restaurant pressed;
	
	public RestaurantPasser() {
		pressed = null;
	}
	public static Restaurant getPressed() {
		return pressed;
	}

	public static void setPressed(Restaurant pressed) {
		RestaurantPasser.pressed = pressed;
	}
	
	
	
}
