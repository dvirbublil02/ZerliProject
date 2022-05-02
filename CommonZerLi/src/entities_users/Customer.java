package entities_users;

public class Customer {

	private String FirstName, LastName, ID, Email, Phone, CreditCard;

	// enum of new customer
	public Customer(String FirstName, String LastName, String ID, String Phone, String Email, String CreditCard) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.ID = ID;
		this.Phone = Phone;
		this.Email = Email;
		this.CreditCard = CreditCard;
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

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCreditCard() {
		return CreditCard;
	}

	public void setCreditCard(String creditCard) {
		CreditCard = creditCard;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public Customer getCustomer() {
		return this;
	}
}
