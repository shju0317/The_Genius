package model;

public class SameNumDTO {

	private int num;
	private String str;


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}



	public SameNumDTO(int num) {
		this.num=num;
	}
	
	public SameNumDTO(String str) {
		this.str=str;
	}
	
	

}
