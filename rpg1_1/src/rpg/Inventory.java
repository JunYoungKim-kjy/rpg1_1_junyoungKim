package rpg;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> itemList = new ArrayList<Item>();
	public void addItem(Item item) {
		itemList.add(item);
	}
	public void inventoryMenu() {
		while(true) {
			System.out.println("===========[인벤메뉴]=========");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = Game.getValue(">>", 0, 2);
			if(sel == 0) {
				break;
			}
			if(sel == 1) {
				equipMenu();
			}else {
				sellMenu();
			}
			
		}
	}
	private void equipMenu() {
		
	}
	private void sellMenu() {
		
	}
	private void printItemList() {
		System.out.println("============ [아이템리스트] ==============");
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print("[이름 : " + itemList.get(i).getName() + "]");
			System.out.print("[능력 : " + itemList.get(i).getPower() + "]");
			System.out.print("[가격 : " + itemList.get(i).getPrice() + "]");
			System.out.println();
		}
	}
}
