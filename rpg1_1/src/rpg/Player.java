package rpg;

public class Player {
	static private int money;
	static private Guild guild = new Guild();
	static private Inventory inven = new Inventory();
	static private Player instance = new Player();
	Player (){
		money = 100000;
		guild.setGuild();
	}
	
	public static void setMoney(int money) {
		Player.money = money;
	}
	public static int getMoney() {
		return money;
	}
	public static void guildMenu() {
		guild.guildMenu();
	}
	public static void inventoryMenu() {
		inven.inventoryMenu();
	}
	public static Inventory getInven() {
		return inven;
	}
}
