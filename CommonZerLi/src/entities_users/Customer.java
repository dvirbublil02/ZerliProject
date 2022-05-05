package entities_users;

import entities_general.CreditCard;
import entities_general.Login;
import enums.AccountStatus;

@SuppressWarnings("serial")
public class Customer extends Login {
	private String customerID, FirstName, LastName, email, phoneNumber, credit, isNewCustomer, isLoggedIn, accountStatus;
	private CreditCard creditCard;

	public Customer(String customerID, String FirstName, String LastName, String email, String phone, String credit,
			CreditCard creditCard, String isNewCustomer, String isLoggedIn, String userName, String password, AccountStatus accountStatus) {
		super(userName, password);
		this.customerID = customerID;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.email = email;
		this.phoneNumber = phone;
		this.credit = credit;
		this.creditCard = creditCard;
		this.isNewCustomer = isNewCustomer;
		this.isLoggedIn = isLoggedIn;
		this.accountStatus = accountStatus.toString();
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

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getIsNewCustomer() {
		return isNewCustomer;
	}

	public void setIsNewCustomer(String isNewCustomer) {
		this.isNewCustomer = isNewCustomer;
	}

	public String getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(String isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
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
