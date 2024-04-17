package view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import controller.MainCon;
import controller.SameNumController;
import model.SameNumDAO;

public class SameNumMain {
    Scanner sc = new Scanner(System.in);
    MainCon mainCon = new MainCon();
    Random rd = new Random();
    int score = 0;

    public void startGame() {

    	String welcomeMent = "\r\n"
        		+ "______  _____  _   _ ______     _____   ___  ___  ___ _____     _   _  _   _ ___  _________  _____ ______ \r\n"
        		+ "|  ___||_   _|| \\ | ||  _  \\   /  ___| / _ \\ |  \\/  ||  ___|   | \\ | || | | ||  \\/  || ___ \\|  ___|| ___ \\\r\n"
        		+ "| |_     | |  |  \\| || | | |   \\ `--. / /_\\ \\| .  . || |__     |  \\| || | | || .  . || |_/ /| |__  | |_/ /\r\n"
        		+ "|  _|    | |  | . ` || | | |    `--. \\|  _  || |\\/| ||  __|    | . ` || | | || |\\/| || ___ \\|  __| |    / \r\n"
        		+ "| |     _| |_ | |\\  || |/ /    /\\__/ /| | | || |  | || |___    | |\\  || |_| || |  | || |_/ /| |___ | |\\ \\ \r\n"
        		+ "\\_|     \\___/ \\_| \\_/|___/     \\____/ \\_| |_/\\_|  |_/\\____/    \\_| \\_/ \\___/ \\_|  |_/\\____/ \\____/ \\_| \\_|\r\n"
        		+ "                                                                                                          \r\n"
        		+ "                                                                                                          \r\n"
        		+ "";
        System.out.println("┌플레이어는 1부터 12의 숫자와 사칙연산자를 받습니다\n"
        		+ "│매 라운드마다 연산 가능한 랜덤 숫자가 제시됩니다\n"
        		+ "│플레이어는 숫자, 연산자, 숫자 순서로 패를 조합합니다\n"
        		+ "│연산 결과가 제시된 숫자와 일치한다면 가넷를 얻습니다\n"
        		+ "└첫 번째로 낸 숫자는 숫자 풀에서 제외됩니다\n");

        mainCon.changeColor(welcomeMent, "cyan");
        SameNumController controller = new SameNumController();
        
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<12; i++) {
			list.add(i+1);
		}
        int round=1;
        while (true) {
            // 데이터베이스에서 가져온 문제 번호
            int problem = new SameNumDAO().SameNumMain();
            // 문제 번호 출력
            System.out.println("라운드 "+round+"// 문제는 "+problem+ "입니다" );
            // 숫자 풀 출력
            System.out.println("숫자 풀입니다: " + list);
            System.out.println();

            // 플레이어가 선택: 첫 번째 숫자, 사칙 연산자, 두 번째 숫자
            System.out.print("첫 번째 숫자를 입력하세요 >> ");
            
            int num1 = sc.nextInt();
            list.remove((Integer) num1);
            System.out.println("입력한 숫자 "+num1+"은 풀에서 제외됩니다");
            System.out.println();
                                    
            System.out.print("사칙 연산자를 입력하세요 >> ");
            String str = sc.next();
            System.out.println();
            
            System.out.print("두 번째 숫자를 입력하세요 >> ");
            int num2 = sc.nextInt();
            System.out.println();
            

            // 계산 결과
            int result = controller.calculate(num1, str, num2);
            System.out.println("계산 결과는 " + result+" 입니다");
            System.out.println();
            round++;

            // 입력한 숫자들은 숫자 풀에서 제거
            

            // 가넷 계산 및 게임 종료 여부 확인
            if (problem == result) {
                System.out.println("1점 득점합니다");
                System.out.println();
                score++;
            } else {
                System.out.println("게임을 종료합니다");
                String resultText = "______  _____  _____  _   _  _      _____ \r\n"
        				+ "| ___ \\|  ___|/  ___|| | | || |    |_   _|\r\n"
        				+ "| |_/ /| |__  \\ `--. | | | || |      | |  \r\n"
        				+ "|    / |  __|  `--. \\| | | || |      | |  \r\n"
        				+ "| |\\ \\ | |___ /\\__/ /| |_| || |____  | |  \r\n"
        				+ "\\_| \\_|\\____/ \\____/  \\___/ \\_____/  \\_/  ";
                mainCon.changeColor(resultText, "cyan");
                System.out.println("최종 가넷은 " + score + "개입니다");
                break;
            }
        }
        
    }

    public static void main(String[] args) {
        SameNumMain game = new SameNumMain();
        game.startGame();
    }
}
