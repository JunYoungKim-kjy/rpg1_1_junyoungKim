package rpg;

public class Item {
	public static final int WEPON = 1;
	public static final int ARMOR = 2;
	public static final int RING = 3;
	private int kind;
	private String name;
	private int power;
	private int price;
	

 	public int getPower() {
		return power;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getKind() {
		return kind;
	}
	
	public Item(int kind, String name, int power,int price) {
		this.kind = kind;
		this.name = name;
		this.power = power;
		this.price = price;
	}
	
}
