package entities_users;

import entities_general.Login;

@SuppressWarnings("serial")
public class BranchManager extends Login {
	private String branchManagerID, BranchID, firstName, lastName, email, phoneNumber, isLoggedIn;

	public BranchManager(String branchManagerID, String branchID, String firstName, String lastName, String email,
			String phoneNumber, String isLoggedIn, String userName, String password) {
		super(userName, password);
		this.branchManagerID = branchManagerID;
		this.BranchID = branchID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isLoggedIn = isLoggedIn;
	}

	public String getBranchManagerID() {
		return branchManagerID;
	}

	public void setBranchManagerID(String branchManagerID) {
		this.branchManagerID = branchManagerID;
	}

	public String getBranchID() {
		return BranchID;
	}

	public void setBranchID(String branchID) {
		BranchID = branchID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(String isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BranchID == null) ? 0 : BranchID.hashCode());
		result = prime * result + ((branchManagerID == null) ? 0 : branchManagerID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BranchManager other = (BranchManager) obj;
		if (BranchID == null) {
			if (other.BranchID != null)
				return false;
		} else if (!BranchID.equals(other.BranchID))
			return false;
		if (branchManagerID == null) {
			if (other.branchManagerID != null)
				return false;
		} else if (!branchManagerID.equals(other.branchManagerID))
			return false;
		return true;
	}
}
