package basicComponents;


import Core.GameObject;
import requiredComponents.Transform;

public class Physics extends Component{
	
	private double velX;
	private double velY;
	
	private double gravity = 0.00;
	
	private boolean grounded = false;
	
	private Transform transform;
	
	public Physics(GameObject object,int[] args) {
		super("physics", object,args);
		transform = object.getTransform();
	}

	@Override
	public void tick() {
		transform.move(velX, velY);
		if(!grounded)
			velY += gravity;
	}

}
