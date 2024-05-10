package Core;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.LinkedList;

import basicComponents.BoxCollider;


public class GameManager {
	public LinkedList<GameObject>  gameObjects = new LinkedList<GameObject>();
	public LinkedList<BoxCollider> colliders = new LinkedList<BoxCollider>();	
	
	Window win;
	public GameManager(Window win) {
		this.win = win;
	}
	

	public void render(Graphics g) {
		for(GameObject object : gameObjects){
			object.render(g);
		}
	}
	public void tick() {
		for(GameObject object : gameObjects){
			object.tick();
		}
	}
	public void addGameObject(GameObject gameObject) {
		int i = 0;
		
		if(!gameObjects.isEmpty()) {
			GameObject current = gameObjects.get(i);
			while(current.getLayer() <= gameObject.getLayer() && !(i == gameObjects.size())) {
				current = gameObjects.get(i);
				i++;
			}
		}
		gameObjects.add(i,gameObject);
	}
	public void removeGameObject(String name) {
		for(int i = 0;i < gameObjects.size();i++) {
			if(gameObjects.get(i).getName() == name) {
				gameObjects.remove(i);
			}
		}
	}
	public void removeGameObject(GameObject object) {
		gameObjects.remove(object);
	}
	public GameObject getGameObject(String name) {
		for(GameObject object: gameObjects) {
			if(name.equals(object.getName()));
				return object;
		}
		return null;
	}
	//returns null if the given collider does not collide other wise returns what it is colliding with
	public BoxCollider isColliding(BoxCollider collider){
		//NOTE FIX LATER
		return null;
	}
	public void addKeyListner(KeyListener kl) {
		win.addKeyListener(kl);
	}
}
