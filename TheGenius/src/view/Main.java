package view;

import java.util.Scanner;

import controller.MemberCon;
import controller.SameNumController;





public class Main {
	
	public static void main(String[] args) {
		//test
		// ttt
		Scanner sc = new Scanner(System.in);
		controller.MemberCon con = new controller.MemberCon();
		controller.picturecon Mcon = new controller.picturecon();
		Mcon.pictureMain();
		while(true) {
			System.out.println("[1]로그인 [2]회원가입 [3]종료");
			System.out.println("선택>> ");
			int select = sc.nextInt();
			
			if(select == 1) { // 로그인
				System.out.println("===== 로그인 =====");
				System.out.println("id");
				String ID = sc.next();
				System.out.println("pw");
				String PW = sc.next();
				model.MemberDTO dto = new model.MemberDTO(ID,PW);
				con.login(dto);
				if(con.login(dto)==true) {
					dto = con.join(dto);
					System.out.println("로그인 성공 "+ dto.getID()+"님 환영합니다");
					boolean a = true;
					while(a) {
					System.out.println("[1]로그아웃 [2]회원탈퇴 [3]게임선택 [4]랭킹확인");
					int select2 = sc.nextInt();
					if(select2 == 1) {
						System.out.println("로그아웃 하셨습니다");
						break;
					}else if (select2 == 2) {//회원탈퇴
						while(true) {
						System.out.println("정말 회원탈퇴를 하겠습니까?(Y/N)");
						String yesno = sc.next();
						if(yesno.equals("Y")) {
							System.out.println("아이디와 비밀번호를 입력해주세요");
							System.out.print("ID >> ");
							String DID = sc.next();
							System.out.print("PW >> ");
							String DPW = sc.next();
							if(dto.getID().equals(DID) && dto.getPW().equals(DPW)) {
								con.delete(dto);
								a = false;
								break;
							} else {
								System.out.println("다시입력");
								break;
							}
						}else if(yesno.equals("N")) {
							break;
						}else {
							System.out.println("Y/N중에 입력해주세요");
						}
					}
//===========================================게임선택=====================================
					}else if(select2 == 3) {
						System.out.println("[1]????게임 [2]????게임 [3]????게임");
						int selectgame = sc.nextInt();
						if(selectgame==1) {
							controller.SameNumController SNgame = new controller.SameNumController();
							SNgame.SNstartGame();
							con.game1point(dto);
							int score1 = dto.getGame1();
							int score2 = SNgame.getScore();
							System.out.println(score1+" dd "+score2);
							if(score1<score2){
								int total = score2+(int)dto.getGame2()+(int)dto.getGame3();
								con.upscore1(dto,score2,total);
							}
						}else if (selectgame==2) {
							controller.RockPaperScissors RPgame = new controller.RockPaperScissors();
							RPgame.RPgamestart();
							con.game2point(dto);
							int score1 = dto.getGame2();
							int score2 = RPgame.getSscore();
							System.out.println(score1+" dd "+score2);
							if(score1<score2){
								int total = (int)dto.getGame1()+score2+(int)dto.getGame3();
								con.upscore2(dto,score2,total);
							}
						}
					}else if(select2 == 4) {//랭킹확인
						con.rank();					}
					}
				}else {
					System.out.println("다시 시도하십시오");
				}
			}else if(select == 2){ // 회원가입 
				System.out.println("===== 회원가입 =====");
				con.joinmember();
								
			}else if(select == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else{
				System.out.println("로그인이 필요합니다 :)");
			}
			
		}
		
	
	
	
	}

    
}
