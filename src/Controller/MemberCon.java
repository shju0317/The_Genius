package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.MemberDAO;
import Model.MemberDTO;



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
		int num = 1;
		MemberDAO dao = new MemberDAO();
		ArrayList <MemberDTO> top = dao.rank();
		System.out.println("===============랭킹=================");
		for(MemberDTO i : top) {
			System.out.println(num+"등\t"+i.getID()+"\t"+i.getPoint());
			num++;
		}
		
	}
}
