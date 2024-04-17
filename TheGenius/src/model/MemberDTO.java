package model;

public class MemberDTO {

	private String ID;
 	private String PW;
 	
	private int game1;
	private int game2;
 	private int game3;
 	private int total;
 	
 

	

 	



	

	public MemberDTO(String iD, int game1, int game2, int game3, int total) {
		super();
		ID = iD;
		this.game1 = game1;
		this.game2 = game2;
		this.game3 = game3;
		this.total = total;
	}


	public MemberDTO(String iD) {
		ID = iD;
	}
//	public MemberDTO(int game1) {
//		this.game1 = game1;
//	}


	public MemberDTO(String iD, String pW) {
		ID = iD;
		PW = pW;
	}



	//getter/setter
	public int getGame1() {
		return game1;
	}
	
	public void setGame1(int game1) {
		this.game1 = game1;
	}
	
	public int getGame2() {
		return game2;
	}
	
	public void setGame2(int game2) {
		this.game2 = game2;
	}
	
	public int getGame3() {
		return game3;
	}
	
	public void setGame3(int game3) {
		this.game3 = game3;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
 	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public MemberDTO(String iD, String pW, int game1, int game2, int game3, int total) {
		super();
		ID = iD;
		PW = pW;
		this.game1 = game1;
		this.game2 = game2;
		this.game3 = game3;
		this.total = total;
	}


	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	
	
}
