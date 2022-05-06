package entities_users;

import entities_general.Login;

@SuppressWarnings("serial")
public class CustomerService extends Login {
	private String customerServiceID, firstName, lastName, email, phoneNumber, isLoggedIn;

	public CustomerService(String customerServiceID, String firstName, String lastName, String email,
			String phoneNumber, String isLoggedIn, String userName, String password) {
		super(userName, password);
		this.customerServiceID = customerServiceID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isLoggedIn = isLoggedIn;
	}

	public String getCustomerServiceID() {
		return customerServiceID;
	}

	public void setCustomerServiceID(String customerServiceID) {
		this.customerServiceID = customerServiceID;
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
		result = prime * result + ((customerServiceID == null) ? 0 : customerServiceID.hashCode());
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
		CustomerService other = (CustomerService) obj;
		if (customerServiceID == null) {
			if (other.customerServiceID != null)
				return false;
		} else if (!customerServiceID.equals(other.customerServiceID))
			return false;
		return true;
	}

}
