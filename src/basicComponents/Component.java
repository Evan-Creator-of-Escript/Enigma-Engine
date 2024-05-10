package basicComponents;

import Core.GameObject;

public abstract class Component {
	//name must be set in each child of this class and should not be allowed to be change
	protected String name;
	protected GameObject object;
	
	//in all children of this class make them set name without an argument so all children of a class like jump for example
	//will be called jump
	//PLEASE Never take any other arguments than these three put all values as int and then convert them
	public Component(String name,GameObject object,int[] args) {
		this.name = name;
		this.object = object;
	}
	//ticks this gameComponent
	public abstract void tick();
	public String getName() {
		return name;
	}
	public GameObject getGameObject() {
		return object;
	}
}
