package basicComponents;

public class TypeConversionPal {
	
	
	//first digit determines decimal places1 EX 2112 -> 2.11
	public static double toDouble(int value) {
		int temp = value;
		int power = temp % 10;
		temp = (temp - power)/ 10;
		return temp * Math.pow(10,-power);
	}
	public static String toString(int value) {
		StringBuilder sb = new StringBuilder();
		int temp = value;
		int current = 0;
		while(temp != 0) {
			current = value % 1000;
			sb.append((char) current);
			temp -= current;
			temp = temp / 1000;
		}
		return sb.toString();
	}
	
}
