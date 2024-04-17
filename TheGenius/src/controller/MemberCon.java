package controller;

import java.util.ArrayList;
import java.util.Scanner;


import model.MemberDAO;
import model.MemberDTO;



public class MemberCon {
	Scanner sc = new Scanner(System.in);
	public void joinmember() {
		MemberDAO dao = new MemberDAO();
		System.out.println("id");
		String ID = sc.next();
		MemberDTO idto = new MemberDTO(ID);
		dao.checkID(idto);
		if(dao.checkID(idto)==false) {
		System.out.println("pw");
		String PW = sc.next();
		MemberDTO dto = new MemberDTO(ID,PW);
		int cnt = dao.joinmember(dto);
		if(cnt>0 ) {
			System.out.println("등록 완료");
			
		}else {
			System.out.println("등록 실패");
		}
		}else {
			System.out.println("중복된 id가 있습니다.");
		}
	}
	public MemberDTO join(MemberDTO dto) {
		MemberDAO dao = new MemberDAO();
		dto = dao.join(dto);
		return dto;
	}
	public boolean login(MemberDTO dto) {
		MemberDAO dao = new MemberDAO();
		if(dao.login(dto)) {
			return true;
		}else{
			return false;
		}
		
	
	}

	
	public void delete(MemberDTO dto) {
		MemberDAO dao = new MemberDAO();
		int cnt = dao.delete(dto);
		if(cnt>0 ) {
			System.out.println("삭제 완료");
		}
	}

	public void rank() {
		System.out.println("[1]1번게임랭킹 [2]2번게임랭킹 [3]3번게임랭킹 [4]토탈랭킹");
		int selectrank = sc.nextInt();
		if(selectrank==1) {
			game1rank();
		}else if(selectrank==2) {
			game2rank();
		}else if(selectrank==3) {
			game3rank();
		}else if(selectrank==4) {
			totalrank();
		}else {
			System.out.println("다시입력해주세요");
		}

	}
	
	public void game1rank() {
		int num = 1;
		MemberDAO dao = new MemberDAO();
		ArrayList <MemberDTO> top = dao.game1rank();
		System.out.println("=============1번게임랭킹=================");
		for(MemberDTO i : top) {
			System.out.println(num+"등\t"+i.getID()+"\t"+i.getGame1());
			num++;
		}
		
	}
	
	public void game2rank() {
		int num = 1;
		MemberDAO dao = new MemberDAO();
		
		ArrayList <MemberDTO> top = dao.game2rank();
		System.out.println("============2번게임랭킹=================");
		for(MemberDTO i : top) {
			System.out.println(num+"등\t"+i.getID()+"\t"+i.getGame2());
			num++;
		}
		
	}
	
	public void game3rank() {
		int num = 1;
		MemberDAO dao = new MemberDAO();
		ArrayList <MemberDTO> top = dao.game3rank();
		System.out.println("============3번게임랭킹=================");
		for(MemberDTO i : top) {
			System.out.println(num+"등\t"+i.getID()+"\t"+i.getGame3());
			num++;
		}
		
	}
	
	public void totalrank() {
		int num = 1;
		MemberDAO dao = new MemberDAO();
		ArrayList <MemberDTO> top = dao.totalrank();
		System.out.println("=============종합랭킹=================");
		for(MemberDTO i : top) {
			System.out.println(num+"등\t"+i.getID()+"\t"+i.getTotal());
			num++;
		}
		
	}
	
	public MemberDTO game1point(MemberDTO dto) {
		MemberDAO dao = new MemberDAO();
		dto = dao.game1point(dto);
		return dto;
}
	
	public void upscore1(MemberDTO dto,int score,int total) {
		MemberDAO dao = new MemberDAO();
		int cnt = dao.upscore1(dto,score,total);
		if(cnt>0 ) {
			System.out.println("수정 완료");
		}else {
			System.out.println("수정 실패");
		}
		
	}
	public MemberDTO game2point(MemberDTO dto) {
		MemberDAO dao = new MemberDAO();
		dto = dao.game2point(dto);
		return dto;
}
	
	public void upscore2(MemberDTO dto,int score,int total) {
		MemberDAO dao = new MemberDAO();
		int cnt = dao.upscore2(dto,score,total);
		if(cnt>0 ) {
			System.out.println("수정 완료");
		}else {
			System.out.println("수정 실패");
		}
		
	}
//	public MemberDTO game3point(MemberDTO dto) {
//		MemberDAO dao = new MemberDAO();
//		dto = dao.game1point(dto);
//		return dto;
//}
//	
//	public void upscore3(MemberDTO dto,int score) {
//		MemberDAO dao = new MemberDAO();
//		int cnt = dao.upscore1(dto,score);
//		if(cnt>0 ) {
//			System.out.println("수정 완료");
//		}else {
//			System.out.println("수정 실패");
//		}
//		
//	}
}
