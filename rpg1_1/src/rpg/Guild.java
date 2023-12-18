package rpg;


public class Guild {
	public void guildMenu() {
		while (true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원교체] [5.정렬]  [0.뒤로가기]");
			int sel = Game.scan.nextInt();
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
	private void printAllUnitStatus() {
//		for(Unit unit : Unit.unitList) {
//			
//		}
	}
	private void buyUnit() {
		
	}
	private void removeUnit() {
		
	}
	private void partyChange() {}
	
}
