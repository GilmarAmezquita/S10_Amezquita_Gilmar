package model;

public class Tower {
	private int number;
	private int disks;
	
	public Tower(int n){
		number = n;
		disks = 0;
	}
	public int getNumber() {
		return number;
	}
	public int getDisks() {
		return disks;
	}
	public void setDisks(int n) {
		disks = n;
	}
	public void increaseDisks() {
		disks++;
	}
	public void decreaseDisks() {
		disks--;
	}
	public void passDisk(Tower other) {
		this.decreaseDisks();
		other.increaseDisks();
	}
}
