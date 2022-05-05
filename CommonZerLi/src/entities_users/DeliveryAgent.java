package entities_users;

import entities_general.Login;

@SuppressWarnings("serial")
public class DeliveryAgent extends Login {
	private String deliveryAgentID, branchID, orderID, FirstName, LastName, email, phoneNumber, isLoggedIn;

	public DeliveryAgent(String deliveryAgentID, String branchID, String orderID, String firstName, String lastName,
			String email, String phoneNumber, String isLoggedIn, String userName, String password) {
		super(userName, password);
		this.deliveryAgentID = deliveryAgentID;
		this.branchID = branchID;
		this.orderID = orderID;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isLoggedIn = isLoggedIn;
	}

	public String getDeliveryAgentID() {
		return deliveryAgentID;
	}

	public void setDeliveryAgentID(String deliveryAgentID) {
		this.deliveryAgentID = deliveryAgentID;
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
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
		result = prime * result + ((branchID == null) ? 0 : branchID.hashCode());
		result = prime * result + ((deliveryAgentID == null) ? 0 : deliveryAgentID.hashCode());
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
		DeliveryAgent other = (DeliveryAgent) obj;
		if (branchID == null) {
			if (other.branchID != null)
				return false;
		} else if (!branchID.equals(other.branchID))
			return false;
		if (deliveryAgentID == null) {
			if (other.deliveryAgentID != null)
				return false;
		} else if (!deliveryAgentID.equals(other.deliveryAgentID))
			return false;
		return true;
	}

}
