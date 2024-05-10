package requiredComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import Core.BaseGame;

public class SpriteRenderer {
	
	private Transform transform;
	private Image img;
	private int spriteID;

	private Color color;
	
	private JFrame frame;
	
	//Transform in here is different as it is for just the image
	public SpriteRenderer(Transform transform,int spriteID) {
		this.transform = transform;
		this.spriteID = spriteID;
		
		try {
			img = ImageIO.read(new File("C:\\Users\\emast\\eclipse-workspace\\EndlessEscape\\Sprites\\496-4960292_nerd-transparent-svg-nerd-emoji-twitter-clipart.png"));
			img = img.getScaledInstance((int)transform.getLength(),(int)transform.getHeight(), 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void render(Graphics g) {
		ImageObserver i = null;
		g.drawImage(img, (int)transform.getActualX(),(int)transform.getActualY(),i);
	}

}
