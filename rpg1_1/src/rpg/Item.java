package rpg;

public class Item {
	private static final int WEPON = 1;
	private static final int ARMOR = 2;
	private static final int ring = 3;
	
	private int kind;
	private String name;
	private int power;
	public int getPower() {
		return power;
	}
	public String getName() {
		return name;
	}
	Item(int kind, String name, int power) {
		this.kind = kind;
		this.name = name;
		this.power = power;
	}
	
}
