package Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;

import basicComponents.*;
import requiredComponents.SpriteRenderer;
import requiredComponents.Transform;

public class LevelLoader {
	private FileInputStream currentLevel;
	private GameManager gm;
	
	//this is the GameObject that is being the made the parent of all marked till changed or removed
	
	public LevelLoader(GameManager gm) {
		this.gm = gm;
		try {
			currentLevel = new FileInputStream("C:\\Users\\emast\\eclipse-workspace\\EndlessEscape\\LevelTest");
		} catch (FileNotFoundException e) {
			System.out.println("Level file is missing");
			e.printStackTrace();
		}
	}
	
/*
 *  This should read the text file and when it should 
 *  read a name for the GameObject
 *  and then add components 
 *  reads a number for how many ints each comp will receive
 */
	private char nextChar() {
		try {
			return (char) currentLevel.read();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return (char)-1;
	}
	
	/*
	 * NOTE all numbers are reversed when put in level editor so 12 = 21
	 */
	public void loadLevel() {		
		while(true) {
		String name;
		name = readName();
		//System.out.println(name + "<- name object");
		Transform t = new Transform(readNumber(),readNumber(),readNumber(),readNumber());
		GameObject building = new GameObject(name,readNumber(),readName(),new SpriteRenderer(t,readNumber()),t,gm);
		if(compSet(building))
			break;
		}
		
	}
	private boolean compSet(GameObject building) {
		String name;
		int compsLeft = readNumber();
		int[] args = new int[readNumber()];
		while(compsLeft != 0) {
			name = readName();
			for(int i = 0;i < args.length;i++) {
				args[i] = readNumber();
			}
			building.addComponent(generateComponent(args,name,building));
			compsLeft--;
			if(compsLeft == 0) {
				break;
				}
			args = new int[readNumber()];
		}
		if(nextChar() == '^') {
			building.setParent(gm.getGameObject(readName()));
		}
		gm.addGameObject(building);
		return nextChar() == '#';
	}
	private Component generateComponent(int[] args,String name,GameObject object) {
		if(name.equals("physics")) 
			return new Physics(object,args);
		else if(name.equals("box_collider"))
			return new BoxCollider(object,args);
		else if(name.equals("movement")) {
			Movement m = new Movement(object,args);
			gm.addKeyListner(m);
			return m;
			}
		else if(name.equals("jump")) {
			Jump j = new Jump(object,args);
			gm.addKeyListner(j);
			return j;
		}
		else
			System.out.println("this is not the name of a component");
		return null;
			
	}
	private int charToRegularInt(char c) {
		return c - 48;
	}
	private String readName() {
		StringBuilder name = new StringBuilder();
		char current = nextChar();
		while(true) {
		if(current == '%') {
			break;
		}
		else {
			name.append((char)current);
		}
		current = nextChar();
		}
		//System.out.println(name.toString());
		return name.toString();
	}
	private int readNumber() {
		int numBuilder = 0;
		Stack<Integer> numHolder = new Stack<>();
		boolean isNeg = nextChar() == '-';
		char current = nextChar();
		int i = 1;
		while(current != ',') {
			numHolder.push(current - 48);
			current = nextChar();
			}
		while(!numHolder.isEmpty()) {
			numBuilder += numHolder.pop() * i;
			i *= 10;
		}
		if(isNeg)
			return -numBuilder;
		//System.out.println(numBuilder);
		return numBuilder;
	}
}
