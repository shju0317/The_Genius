package model;

public class MemberDTO {

	private String ID;
 	private String PW;
 	private int point;

 	



	public MemberDTO(String iD, String pW, int point) {
		ID = iD;
		PW = pW;
		this.point = point;
	}

	public MemberDTO(String iD, String pW) {
		ID = iD;
		PW = pW;
	}

	public MemberDTO(String iD, int point) {
		ID = iD;
		this.point = point;
	}

	//getter/setter
 	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
