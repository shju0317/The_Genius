package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.SameNumDAO;

public class SameNumController {

    public int calculate(int num1, String operator, int num2) {
        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
    
   

	    public void SNstartGame() {
	    	Scanner sc = new Scanner(System.in);
	    	Random rd = new Random();
	    	int score = 0;
	        controller.picturecon pic = new controller.picturecon();
	        pic.pictureSame();
	        System.out.println("┌플레이어는 1부터 12의 숫자와 사칙연산자를 받습니다\n"
	                + "│매 라운드마다 연산 가능한 랜덤 숫자가 제시됩니다\n"
	                + "│플레이어는 숫자, 연산자, 숫자 순서로 패를 조합합니다\n"
	                + "│연산 결과가 제시된 숫자와 일치한다면 점수를 얻습니다\n"
	                + "└첫 번째로 낸 숫자는 숫자 풀에서 제외됩니다\n");

	        controller.SameNumController controller = new controller.SameNumController();
	        
	        
	        ArrayList<Integer> list = new ArrayList<>();
	        for(int i=0; i<12; i++) {
				list.add(i+1);
			}

	        // 로그인 기능 구현
	        System.out.println("로그인");

	        while (true) {
	            // 데이터베이스에서 가져온 문제 번호
	            int problem = new model.SameNumDAO().SameNumMain();
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
	       
	    }
    

}
