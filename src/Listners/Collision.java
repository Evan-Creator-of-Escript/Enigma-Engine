package Listners;

import Core.GameObject;
import basicComponents.BoxCollider;

/*
 * this class stores collision data
 */
public class Collision {
	private BoxCollider collider;
	public Collision(BoxCollider collider) {
		this.collider = collider;
	}
	public BoxCollider getBoxCollider() {
		return collider;
	}
}
