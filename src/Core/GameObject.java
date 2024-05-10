package Core;

import java.util.HashMap;
import java.util.LinkedList;

import basicComponents.Component;
import basicComponents.TypeConversionPal;
import requiredComponents.*;

import java.awt.Graphics;


public class GameObject {
	
	protected GameManager gm;
	protected Transform transform;
	protected SpriteRenderer spriteRenderer;
	private String name;
	private String tag;
	
	private GameObject parent;
	
	/*
	 * layer as increases goes closer to screen can go forever bothb ways
	 * 0 back
	 * 5 mid
	 * 9 front
	 */
	private int layer;
	
	//Note make sure it is only pointer not a duplicate that is in each
	private HashMap<String,Component> componentsHashed;
	private LinkedList<Component> componentsListed;
	

	public GameObject(String name,int layer,String tag,SpriteRenderer spriteRenderer, Transform transform,GameManager gm) {
		parent = null;
		this.name = name;  
		this.layer = layer;
		this.spriteRenderer = spriteRenderer;
		this.transform = transform;
		this.gm = gm;
		this.tag = tag;
		componentsHashed = new HashMap <>();
		componentsListed = new LinkedList<>();
	}
	
	//ticks all the components
	public void tick() {
		for(Component c : componentsListed) {
			c.tick();
		}
	}
	//passes off to spriteRender
	public void render(Graphics g) {
		spriteRenderer.render(g);
	}
	public void addComponent(Component component) {
		componentsHashed.put(component.getName(), component);
		componentsListed.add(component);
	}
	//For getting Components by using name through hashmap
	public Component getComponent(String name) {
		return componentsHashed.get(name);
	}
	public boolean hasComponent(String name) {
		return componentsHashed.containsKey(name);
	}
	public Transform getTransform() {
		return transform;
	}
	public SpriteRenderer getSpriteRenderer() {
		return spriteRenderer;
	}
	public String getName() {
	return name;
	}
	public int getLayer() {
		return layer;
	}
	public GameManager getGameManager() {
		return gm;
	}
	public GameObject getParent() {
		return parent;
	}
	public void setParent(GameObject parent) {
		this.parent = parent;
		transform.setParent(parent.getTransform());
	}
}
