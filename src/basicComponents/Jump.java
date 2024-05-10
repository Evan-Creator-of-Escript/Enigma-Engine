package basicComponents;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Core.GameObject;
import requiredComponents.Transform;

public class Jump extends Component implements KeyListener{
	
	private boolean isJumping = false;
	private Transform transform;

	public Jump(GameObject object,int[] args) {
		super("jump",object,args);
		this.transform = object.getTransform();
	}

	@Override
	public void tick() {
		if(isJumping)
			transform.move(0, 1);
		else
			transform.move(0, -1);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == ' ')
			isJumping = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == ' ')
			isJumping = false;
	}

}
