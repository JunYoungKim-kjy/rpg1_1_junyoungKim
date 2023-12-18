package rpg;

import java.util.ArrayList;

public class Guild {
	final int PARTY_SIZE = 4;
	ArrayList<Unit> guildList = new ArrayList<Unit>();
	Unit[] partyList;
	Guild(){
		setGuild();
	}
	public void setGuild() {
		Unit temp = new Unit("스폰지밥", 1, 100, 3 , 10 , 0);
		guildList.add(temp);
		temp = new Unit("뚱이", 1, 70, 2 , 5 , 0);
		guildList.add(temp);
		temp = new Unit("징징이", 1, 50, 4 , 10 , 0);
		guildList.add(temp);
		temp = new Unit("집게사장", 1, 150, 2 , 75 , 0);
		guildList.add(temp);
		temp = new Unit("다람이", 1, 40, 6 , 30 , 0);
		guildList.add(temp);
		for(int i = 0; i < 4; i+=1) {
			guildList.get(i).setParty(true);
		}
		partyList = new Unit[PARTY_SIZE];
		int n=0;
		for(int i= 0 ; i < guildList. size(); i+=1) {
			if(guildList.get(i).getParty()) {
				partyList [n++] = guildList.get(i);
			}
		}
		
	}
	public Unit getGuildUnit(int num) {
		return guildList.get(num);
	}
	public void printAllUnitStatus() {
		System.out.println("==================================");
		System.out.println("[Gold : " + Player.getMoney() + "]");
		System.out.println("==================================");

		for (int i = 0; i < guildList.size(); i += 1) {
			System.out.print("[" + (i+1) + "번] ");
			System.out.print("[이름 : " + guildList.get(i).getName() + "] ");
			System.out.print("[레벨 : " + guildList.get(i).getLevel() + "] ");
			System.out.print("[체력 : " + guildList.get(i).getHp() );
			System.out.println(" / " + guildList.get(i).getMaxHp() +"]");
			System.out.print("[공격력 : " + guildList.get(i).getAtt() +"] ");
			System.out.print("[방어력 : " + guildList.get(i).getDef() +"] ");
			System.out.println("[파티중 : " + guildList.get(i).getParty() +"] ");
			System.out.println();
		}
		System.out.println("=========================================");
	}
	public void printUnitStatus(int num) {
		guildList.get(num).printStatus();
	}
	public void printUnitItem(int num) {
		guildList.get(num).printEquitedItem();
	}
	public void buyUnit() {
		if(Player.getMoney() < 5000) {
			System.out.println("구매 할 돈이 없습니다.");
			return;
		}
		String[] n1 = { "박", "이", "김", "최", "유", "지", "오" };
		String[] n2 = { "명", "기", "종", "민", "재", "석", "광" };
		String[] n3 = { "수", "자", "민", "수", "석", "민", "철" };
		
		String name = n1[Game.ran.nextInt(n1.length)];
		name += n2[Game.ran.nextInt(n1.length)];
		name += n3[Game.ran.nextInt(n1.length)];
		
		int ran = Game.ran.nextInt(8)+2;
		int hp = ran * 10;
		int att = ran * 2;
		int def = ran ;
		Unit temp = new Unit(name, 1, hp, att, def, 0);
		
		System.out.println("========================");
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격력 : " + att + "]");
		System.out.println(" [방어력 : " + def + "]");
		System.out.println("길드원을 영입합니다.");
		System.out.println("=========================");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		guildList.add(temp);
		Player.setMoney(Player.getMoney()-5000);
	}
	public void guildMenu() {
		while (true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원교체] [5.정렬]  [0.뒤로가기]");
			int sel = Game.getValue(">>", 0, 4);
			if (sel == 1) {
				printAllUnitStatus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				partyChange();
			} else if (sel == 0) {
				break;
			}
		}
	}
	private void removeUnit() {
		printAllUnitStatus();
		System.out.println("삭제할 번호를 입력하세요 [0.뒤로가기]:");
		int sel = Game.getValue(">>", 0, guildList.size())-1;
		if(guildList.get(sel).getParty()) {
			System.out.println("파티중인 멤버는 삭제 할 수 없습니다.");
		}else {
			System.out.println("=================================");
			System.out.print("[이름 : " + guildList.get(sel).getName() + "]");
			System.out.println("길드원을 삭제합니다.");
			System.out.println("=================================");
			guildList.remove(sel);
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void printParty() {
		System.out.println("================[파티원]==============");
		for( int i=0; i < PARTY_SIZE ; i+=1) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + partyList[i].getName() + "]");
			System.out.print(" [레벨 : " + partyList[i].getLevel() + "]");
			System.out.print(" [체력 : " + partyList[i].getHp());
			System.out.println(" / " + partyList[i].getMaxHp() + "]");
			System.out.print("[공격력 : " + partyList[i].getAtt() + "]");
			System.out.print(" [방어력 : " + partyList[i].getDef() + "]");
			System.out.println(" [파티중 : " + guildList.get(i).getParty() + "]");
			System.out.println("");
		}
		System.out.println("=====================================");
	}
	public void partyChange() {
		printParty();
		System.out.println("교체할 멤버의 번호를 입력하세요 [0.뒤로가기]");
		int partyNum = Game.getValue(">>", 0, PARTY_SIZE)-1;
		if(partyNum ==-1)return;
		printAllUnitStatus();
		System.out.println("참가할 멤버의 번호를 입력하세요 [0.뒤로가기]");
		int guildNum = Game.getValue(">>", 0, guildList.size())-1;
		if(guildNum==-1)return;
		partyList[partyNum].setParty(false);
		guildList.get(guildNum).setParty(true);
		
		System.out.println("===================================");
		System.out.print("[이름 : "+partyList[partyNum].getName() + "]");
		System.out.print("에서 ");
		System.out.print("[이름 : "+guildList.get(guildNum).getName() +"]");
		System.out.println("으로 교체 합니다.");
		System.out.println("====================================");
		
		int n = 0;
		for (int i=0; i< guildList.size(); i++) {
			if(guildList.get(i).getParty()) {
				partyList[n++] = guildList.get(i);
			}
		}
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
