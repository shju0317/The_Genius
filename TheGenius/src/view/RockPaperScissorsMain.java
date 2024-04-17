package view;

import java.util.Random;
import java.util.Scanner;


import controller.MainCon;
import controller.RockPaperScissorsCon;


public class RockPaperScissorsMain {
	public static void startGame() {
		RockPaperScissorsCon con = new RockPaperScissorsCon();
		MainCon mainCon = new MainCon();

		Scanner sc = new Scanner(System.in);

		String welcomeMent = "______  _____  _____  _____  _____  _   _  _____ \r\n"
				+ "| ___ \\|  ___||_   _||_   _||_   _|| \\ | ||  __ \\\r\n"
				+ "| |_/ /| |__    | |    | |    | |  |  \\| || |  \\/\r\n"
				+ "| ___ \\|  __|   | |    | |    | |  | . ` || | __ \r\n"
				+ "| |_/ /| |___   | |    | |   _| |_ | |\\  || |_\\ \\\r\n"
				+ "\\____/ \\____/   \\_/    \\_/   \\___/ \\_| \\_/ \\____/"
				+ "\n"
				+ "______  _____  _____  _   __   ______   ___  ______  _____ ______     _____  _____  _____  _____  _____  _____ ______  _____ \r\n"
				+ "| ___ \\|  _  |/  __ \\| | / /   | ___ \\ / _ \\ | ___ \\|  ___|| ___ \\   /  ___|/  __ \\|_   _|/  ___|/  ___||  _  || ___ \\/  ___|\r\n"
				+ "| |_/ /| | | || /  \\/| |/ /    | |_/ // /_\\ \\| |_/ /| |__  | |_/ /   \\ `--. | /  \\/  | |  \\ `--. \\ `--. | | | || |_/ /\\ `--. \r\n"
				+ "|    / | | | || |    |    \\    |  __/ |  _  ||  __/ |  __| |    /     `--. \\| |      | |   `--. \\ `--. \\| | | ||    /  `--. \\\r\n"
				+ "| |\\ \\ \\ \\_/ /| \\__/\\| |\\  \\   | |    | | | || |    | |___ | |\\ \\    /\\__/ /| \\__/\\ _| |_ /\\__/ //\\__/ /\\ \\_/ /| |\\ \\ /\\__/ /\r\n"
				+ "\\_| \\_| \\___/  \\____/\\_| \\_/   \\_|    \\_| |_/\\_|    \\____/ \\_| \\_|   \\____/  \\____/ \\___/ \\____/ \\____/  \\___/ \\_| \\_|\\____/ ";

		mainCon.changeColor(welcomeMent, "cyan");
		
		System.out.println("┌플레이어는 승패 결과를 예상하고 가위바위보를 진행합니다\n"
				+ "│예상한 결과와 승패가 일치하면 베팅한 가넷의 2배를 가져갑니다\n"
				+ "└만약 일치하지 않는다면 베팅한 가넷을 잃습니다");
		
		int bettingScore = 0;
		//현재 보유 중인 가넷 개수 보여주기

		do {
			System.out.println("5개 이상 30개 미만의 가넷만 베팅할 수 있습니다.");
			System.out.print("베팅할 가넷을 입력하세요> ");
			bettingScore = sc.nextInt();
		}while(bettingScore < 5 || bettingScore > 30);

		System.out.println("예상 결과를 입력하세요");
		System.out.println("[1]승 [2]패 [3]무승부");
		System.out.print(">> ");
		int bettingResult = sc.nextInt();

		System.out.println("제시할 표식을 입력하세요");
		System.out.println("[1]가위 [2]바위 [3]보");
		System.out.print(">> ");
		int playerMark = sc.nextInt() - 1;

		int score = 10; // db에서 가져온 사용자의 score

		// 컴퓨터 표식
		Random random = new Random();
		int computerMark = random.nextInt(3); // 0 이상 3 미만의 정수 반환

		con.showResult(playerMark, computerMark);
//		    System.out.println(getRealResult(playerMark, computerMark));
		int realResult = con.getRealResult(playerMark, computerMark);

		score = con.getBettingResult(realResult, bettingResult, bettingScore, score);
		System.out.println("최종 가넷은 " + score + "개입니다");

	}

}
