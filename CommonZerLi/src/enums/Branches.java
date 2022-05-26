package enums;

/**
 * Constant Enum that contain all the branches in Zerli with there identify
 * numbers
 * 
 * @author Mor Ben Haim
 *
 */
public enum Branches {
	KARMIEL(1010);
	private int number;

	private Branches(int number) {
	this.number=number;
	}
	public int getNumber() {
		return number;
	}
	

}
