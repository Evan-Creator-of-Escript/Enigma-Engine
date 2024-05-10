package Core;

import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Window {
private JFrame windowHolder;
	public Window(BaseGame bg){
		windowHolder = new JFrame();
		windowHolder.setResizable(false);
		windowHolder.setSize(new Dimension(1800,1100));
		windowHolder.setVisible(true);
		windowHolder.add(bg);
		bg.setUp(bg,this);
	}
	public boolean isOpen() {
		return windowHolder.isActive();
	}
	public void addKeyListener(KeyListener key) {
		windowHolder.addKeyListener(key);
	}
	public JFrame getJFrame() {
		return windowHolder;
	}
}
