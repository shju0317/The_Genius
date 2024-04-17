package model;

public class gameDTO {

	private int game1;
	private int game2;
 	private int game3;
 	private int total;
 	
 	

	public gameDTO(int game1, int game2, int game3, int total) {
		super();
		this.game1 = game1;
		this.game2 = game2;
		this.game3 = game3;
		this.total = total;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
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
 	
 	
}
