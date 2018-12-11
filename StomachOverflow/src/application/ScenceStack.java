package application;

import javafx.scene.Scene;
import java.util.Stack;
public final class ScenceStack extends Object{
	
	private static Stack<Scene> sceneStack = new Stack<Scene>();
	
	public ScenceStack() {
		
	}
	
	public static void pop() {
		sceneStack.pop();
	}
	
	public static void push(Scene s) {
		sceneStack.push(s);
	}
	
	public static Scene top() {
		return sceneStack.peek();
	}

}
