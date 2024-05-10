package requiredComponents;

import basicComponents.TypeConversionPal;

public class Transform {
	private double x;
	private double y;
	private double length;
	private double height;
	//the parent is what 0,0 should be for x,y if there is no parent then 0,0 is parent transform
	private Transform parent;
	public Transform(int x, int y, int length,int height) {

		this.x = TypeConversionPal.toDouble(x);
		this.y = TypeConversionPal.toDouble(y);
		this.length = TypeConversionPal.toDouble(length);
		this.height = TypeConversionPal.toDouble(height);
	}
	public Transform(double x,double y) {
			this.x = x;
			this.y = y;
	}
	public void teleport(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void move(double velX,double velY) {
		this.x += velX;
		this.y -= velY;
	}
	public void neutralPosition() {
		x = 0;
		y = 0;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y ;
	}
	//x relative to 0
	public double getActualX() {
		if(parent == null) {
			return x;
			}
		return x + parent.getActualX();
	}
	//y relative to 0
	public double getActualY() {
		if(parent == null)
			return y;
		return y + parent.getActualY();
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getHeight() {
		return height;
	}
	public double getLength() {
		return length;
	}
	public void setParent(Transform parent) {
		this.parent = parent;
	}
}
