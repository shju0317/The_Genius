package controller;

import java.util.Scanner;

import model.MemberDAO;
import model.MemberDTO;



public class MemberCon {
	Scanner sc = new Scanner(System.in);
	public void joinmember() {
		System.out.println("id");
		String ID = sc.next();
		System.out.println("pw");
		String PW = sc.next();
		MemberDTO dto = new MemberDTO(ID,PW);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.joinmember(dto);
		if(cnt>0 ) {
			System.out.println("등록 완료");
		}else {
			System.out.println("등록 실패");
		}
	};
	public MemberDTO login(MemberDTO dto) {
		MemberDAO dao = new MemberDAO();
		System.out.println("로그인 성공");
		return dto;
	}
}
