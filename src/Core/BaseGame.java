package Core;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;

import javax.swing.JFrame;

import requiredComponents.SpriteRenderer;
import requiredComponents.Transform;
import basicComponents.Jump;
import basicComponents.Movement;
import basicComponents.Physics;

public class BaseGame extends Canvas implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		//Window creates a new BaseGame
		new BaseGame();
		System.out.println("done");
		}
	
	private boolean running = true;
	private GameManager gm;
	private Window win;
	private LevelLoader levelLoader;
	
	public BaseGame() {
		new Window(this);
	}
	
	public void setUp(BaseGame bg,Window win) {
		this.win = win;
		
		Thread thread = new Thread(bg);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		gm = new GameManager(win);
		levelLoader = new LevelLoader(gm);
		
		levelLoader.loadLevel();
	
		while(running) {
			//NOTE MAKE SURE TO REMOVE THIS IF AFTER A QUIT GAME THING IS MADE ALSO 
			//REMOVE ISOPEN FROM WINDOW CLASS
			if(!win.isOpen())
				break;
			
			tick();
			render();
		}
		System.out.println("ending run");
	}
	public void stop () {
		running = false;
	}
	private void tick() {
		gm.tick();
	}
	private void render() {
		//gets the graphics set up to be passed out to all objects
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        //makes background
        Graphics g = bs.getDrawGraphics();
        g.fillRect(0,0,1800,1100);
        g.setColor(Color.black);
        //renders all objects
        gm.render(g);
        g.dispose();
        bs.show();
	}

	
}
