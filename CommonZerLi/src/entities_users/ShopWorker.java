package entities_users;

import entities_general.Login;

@SuppressWarnings("serial")
public class ShopWorker extends Login {
	private String shopworkerID, branchID, FirstName, LastName, email, phoneNumber, isLoggedIn;

	public ShopWorker(String shopworkerID, String branchID, String firstName, String lastName, String email,
			String phoneNumber, String isLoggedIn, String userName, String password) {
		super(userName, password);
		this.shopworkerID = shopworkerID;
		this.branchID = branchID;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isLoggedIn = isLoggedIn;
	}

	public String getShopworkerID() {
		return shopworkerID;
	}

	public void setShopworkerID(String shopworkerID) {
		this.shopworkerID = shopworkerID;
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
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
		result = prime * result + ((shopworkerID == null) ? 0 : shopworkerID.hashCode());
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
		ShopWorker other = (ShopWorker) obj;
		if (shopworkerID == null) {
			if (other.shopworkerID != null)
				return false;
		} else if (!shopworkerID.equals(other.shopworkerID))
			return false;
		return true;
	}

}
