package rpg;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class Game {
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();
	
	public static int getValue(String msg, int start, int end) {
		while (true) {
			try {
				System.out.println(msg);
				int input = scan.nextInt();
				if (input < start || input > end) {
					System.out.println("입력 범위 오류");
					continue;
				}
				return input;
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("숫자만 입력가능합니다.");
			}
		}
	}

	public Game() {
		Player player = new Player();
		Shop shop = new Shop();
		FileData fileData = new FileData();
		Guild guild = new Guild();
		
		
		while (true) {
			System.out.println("=============== [메인메뉴] ================");
			System.out.println("[1.길드관리] [2.상점] [3.인벤토리]");
			System.out.println("[4.저장] [5.로드] [0.종료]");
			int sel = getValue(">>", 0, 5);
			if (sel == 1) {
				Player.guildMenu();
			} else if (sel == 2) {
				shop.shopMng();
			} else if (sel == 3) {
				Player.inventoryMenu();
			} else if (sel == 4) {
//				try {
//					FileData.save();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			} else if (sel == 5) {
//				try {
//					FileData.loadData();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			} else if(sel==0){
				System.out.println("게임을 종료 합니다.");
				break;
			} else {
				System.out.println("입력 범위 오류");
			}
		}
		Game.scan.close();
	}

}

