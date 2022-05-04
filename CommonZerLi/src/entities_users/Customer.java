package entities_users;

import entities_general.CreditCard;

public class Customer {
	private String customerID, FirstName, LastName, Email, Phone, credit, isNewCustomer, isLoggedIn;
	private CreditCard creditCard;

	enum AccountStatus {
		CONFIRMED, PENDING_APPROVAL, FROZEN;
	}

	public Customer(String customerID, String firstName, String lastName, String email, String phone, String credit,
			CreditCard creditCard, String isNewCustomer, String isLoggedIn) {
		super();
		this.customerID = customerID;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Phone = phone;
		this.credit = credit;
		this.creditCard = creditCard;
		this.isNewCustomer = isNewCustomer;
		this.isLoggedIn = isLoggedIn;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
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
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public String isNewCustomer() {
		return isNewCustomer;
	}

	public void setNewCustomer(String isNewCustomer) {
		this.isNewCustomer = isNewCustomer;
	}

	public String isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(String isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
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
		Customer other = (Customer) obj;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		return true;
	}
}
