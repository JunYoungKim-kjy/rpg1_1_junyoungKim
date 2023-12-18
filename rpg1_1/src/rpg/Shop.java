package rpg;

import java.util.ArrayList;

public class Shop {
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	public Shop() {
		Item temp = new Item(Item.WEPON, "나무검",3,1000);
		itemList.add(temp);
		
		temp = new Item(Item.WEPON, "철검",5,2000);
		itemList.add(temp);
		
		temp = new Item(Item.WEPON, "레이피어",7,2500);
		itemList.add(temp);

		temp = new Item(Item.ARMOR, "티셔츠",1,1000);
		itemList.add(temp);

		temp = new Item(Item.ARMOR, "가죽갑옷",3,2000);
		itemList.add(temp);
	
		temp = new Item(Item.ARMOR, "철갑옷",7,10000);
		itemList.add(temp);
		
		temp = new Item(Item.RING, "은반지",10,10000);
		itemList.add(temp);

		temp = new Item(Item.RING, "금반지",17,30000);
		itemList.add(temp);
		
		temp = new Item(Item.RING, "다이아반지",35,50000);
		itemList.add(temp);
		
	}
	
	public void shopMng() {
		while(true) {
			System.out.println("================ [상점] ================");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
			int selKind = Game.getValue(">>", 0, 3);
			if(selKind == 0)return;
			while(true) {
				if(selKind == Item.WEPON)
					System.out.println("==============[무기]===============");
				else if(selKind == Item.ARMOR)
					System.out.println("==============[방어구]===============");
				else if(selKind == Item.RING)
					System.out.println("==============[반지]===============");
//				printItems(selKind);
//				int cnt = getItemCnt(selKind);
				System.out.println("[보유골드 : "+Player.getMoney()+"]");
				System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
//				int buyNum = Game.getValue(">>", 0, cnt);
				Item buyItem = getBuyItem(selKind);
				for(int i=0; i < itemList.size(); i+=1) {
					if(itemList.get(i).getKind() == selKind) {
//						if(cnt == buyNum)
					}
				}
				
			}
			
		}
	}
	private Item getBuyItem(int kind) {
		printItems(kind);
		int cnt = getItemCnt(kind);
		System.out.println("[보유골드 : "+Player.getMoney()+"]");
		System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
		int buyNum = Game.getValue(">>", 0, cnt);
		if(buyNum==0)return null;
		int num=0;
		for(int i=0; i < itemList.size(); i++) {
			if(itemList.get(i).getKind() != kind)continue;
			if(num == buyNum) {
				return itemList.get(i); 
			}
			num++;
		}
		return null;
	}
	private int getItemCnt(int kind) {
		int cnt = 0;
		for(int i=0; i < itemList.size(); i++) {
			if(itemList.get(i).getKind() != kind)continue;
			cnt+=1;
		}
		return cnt;
	}
	private void printItems(int kind) {
		int num = 1;
		for(int i=0; i < itemList.size(); i++) {
			if(itemList.get(i).getKind() != kind)continue;
			System.out.print("[" + num++ +"번]");
			System.out.print("[이름 : " + itemList.get(i).getName()+"]");
			System.out.print("[능력 : " + itemList.get(i).getPower()+"]");
			System.out.print("[가격 : " + itemList.get(i).getPrice()+"]");
			System.out.println();
		}
	}
}
