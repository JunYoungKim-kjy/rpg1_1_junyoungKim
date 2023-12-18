package rpg;


public class Unit {
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int att;
	private int def;
	private int exp;
	private boolean party;
	Item weapon;
	Item armor;
	Item ring;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getDef() {
		return def;
	}
	public void setDft(int def) {
		this.def = def;
	}
	public String getName() {
		return name;
	}
	public void setParty(boolean party) {
		this.party = party;
	}
	Unit(String n, int l, int hp, int a, int d, int e) {
		this.name = n;
		this.level = l;
		this.maxHp = hp;
		this.att = a;
		this.def = d;
		this.exp = e;
		this.hp = maxHp;
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	Unit(String n, int l, int hp, int a, int d, int e,boolean p) {
		this.name = n;
		this.level = l;
		this.maxHp = hp;
		this.att = a;
		this.def = d;
		this.exp = e;
		this.hp = maxHp;
		this.party = p;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	public void setItem(Item w,Item a,Item r) {
		weapon = w;
		armor = a;
		ring = r;
	}
	public void printStatus() {
		System.out.print("[이름 : " + name + "] ");
		System.out.print("[레벨 : " + level+ "] ");
		if(ring != null) {
			System.out.print("[체력 : "+ hp + " + " + ring.getPower());
		} else {
			System.out.print("[체력 : "+ hp +"]");
		}
		if( ring != null) {
			System.out.println(" / " + maxHp + " + " + ring.getPower()+ "]");
		}else {
			System.out.println(" / " + maxHp + " ]");
		}
		if(weapon != null) {
			System.out.print("[공격력 : " + att + " + " + weapon.getPower() + "]");
		}else {
			System.out.print("[공격력 : " + att + " ] ");
		}
		if(armor != null) {
			System.out.print("[방어력 : " + def + " + " + armor.getPower() + "]");
		}else {
			System.out.print("[방어력 : " + def + " ] ");
		}
		System.out.print("[파티중 : " + party + " ]");
	}
	
	public void printEquitedItem() {
		if ( weapon == null) {
			System.out.println("[무기 : 없음 ]");
		}else {
			System.out.println("[무기 : " + weapon.getName() + " ]");
		}
		if ( armor == null) {
			System.out.println("[방어구 : 없음 ]");
		}else {
			System.out.println("[방어구 : " + armor.getName() + " ]");
		}
		if ( ring == null) {
			System.out.println("[반지 : 없음 ]");
		}else {
			System.out.println("[반지 : " + ring.getName() + " ]");
		}
	}
}
