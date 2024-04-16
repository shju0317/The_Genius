package View;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Controller.SameNumController;
import Model.SameNumDAO;
import Model.SameNumDTO;

public class SameNumMain {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    int score = 0;

    public void startGame() {
        System.out.println("같은숫자아스키아트");
        System.out.println("게임 설명문");

        SameNumController controller = new SameNumController();
        
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<12; i++) {
			list.add(i+1);
		}

        // 로그인 기능 구현
        System.out.println("로그인");

        while (true) {
            // 데이터베이스에서 가져온 문제 번호
            int problem = new SameNumDAO().SameNumMain();
            // 문제 번호 출력
            System.out.println("문제 제시: " + problem);
            // 숫자 풀 출력
            System.out.println("숫자 풀입니다: " + list);

            // 플레이어가 선택: 첫 번째 숫자, 사칙 연산자, 두 번째 숫자
            System.out.println("첫 번째 숫자를 입력하세요");
            System.out.println("첫 번째 입력한 숫자는 풀에서 제외됩니다");
            int num1 = sc.nextInt();
            list.remove((Integer) num1);
                                    
            System.out.println("사칙 연산자를 입력하세요");
            String str = sc.next();
            
            System.out.println("두 번째 숫자를 입력하세요");
            System.out.println("두 번째 입력한 숫자는 풀에서 제외되지 않습니다");
            int num2 = sc.nextInt();
            

            // 계산 결과
            int result = controller.calculate(num1, str, num2);
            System.out.println("계산 결과: " + result);

            // 입력한 숫자들은 숫자 풀에서 제거
            

            // 점수 계산 및 게임 종료 여부 확인
            if (problem == result) {
                System.out.println("1점 득점합니다");
                score++;
            } else {
                System.out.println("게임을 종료합니다");
                System.out.println("점수는 " + score + "입니다");
                break;
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        SameNumMain game = new SameNumMain();
        game.startGame();
    }
}
