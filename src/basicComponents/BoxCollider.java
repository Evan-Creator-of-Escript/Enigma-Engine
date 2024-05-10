package basicComponents;

import java.util.LinkedList;

import Core.GameManager;
import Core.GameObject;
import Listners.Collision;
import Listners.CollisionListner;

public class BoxCollider extends Component{
	
	private double length;
	private double height;
	private String tag;
	LinkedList<CollisionListner> listners = new LinkedList();
	private GameManager gm;

	public BoxCollider(GameObject object,int[] args) {
		super("boxCollider", object,args);
		this.length = TypeConversionPal.toDouble(args[0]);
		this.height = TypeConversionPal.toDouble(args[1]);
		this.tag = TypeConversionPal.toString(args[2]);
		gm = object.getGameManager();
	}

	@Override
	public void tick() {
		//check for collision
	}
	private void getOutOfCollider() {
		
	}
	private void collisionEvent(BoxCollider incoming) {
		for(CollisionListner cl : listners) {
			cl.onCollision(new Collision(incoming));
		}
	}
	
}
