package entities_general;

public class Branch {
	private int branchID;
	private int branchManagerID;
	private String BranchName;
	
	
	public Branch(int branchID, int branchManagerID, String branchName) {
		this.branchID = branchID;
		this.branchManagerID = branchManagerID;
		BranchName = branchName;
	}


	public int getBranchID() {
		return branchID;
	}


	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}


	public int getBranchManagerID() {
		return branchManagerID;
	}


	public void setBranchManagerID(int branchManagerID) {
		this.branchManagerID = branchManagerID;
	}


	public String getBranchName() {
		return BranchName;
	}


	public void setBranchName(String branchName) {
		BranchName = branchName;
	}    
	
}
