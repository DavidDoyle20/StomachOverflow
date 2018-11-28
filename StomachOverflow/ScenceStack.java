package application;

import javafx.scene.Scene;

public final class ScenceStack extends Object{
	
	private static DSLinkedStack<Scene> sceneStack = new DSLinkedStack<Scene>();
	
	public ScenceStack() {
		
	}
	
	public static void pop() {
		sceneStack.pop();
	}
	
	public static void push(Scene s) {
		sceneStack.push(s);
	}
	
	public static Scene top() {
		return sceneStack.top();
	}

}
