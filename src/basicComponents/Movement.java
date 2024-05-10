package basicComponents;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Core.GameObject;
import requiredComponents.Transform;

public class Movement extends Component implements KeyListener{

	private Transform transform;
	private double speed;
	
	private boolean dDown;
	private boolean aDown;
	
	public Movement(GameObject object,int[] args) {
		super("movement", object,args);
		this.transform = object.getTransform();
		
		speed = TypeConversionPal.toDouble(args[0]);
	}
	@Override
	public void tick() {
		if(dDown && aDown)
			return;
		else if(dDown) 
			moveRight();
		else if(aDown)
			moveLeft();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'd')
			dDown = true;
		else if(e.getKeyChar() == 'a')
			aDown = true;
	}
			
		

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'd')
			dDown = false;
		else if(e.getKeyChar() == 'a')
			aDown = false;
	}
	private void moveRight() {
		transform.move(speed,0);
	}
	private void moveLeft() {
		transform.move(-speed,0);
	}
}
