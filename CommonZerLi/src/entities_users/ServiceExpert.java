package entities_users;

import entities_general.Login;

@SuppressWarnings("serial")
public class ServiceExpert extends Login {
	private String serviceExpertID, FirstName, LastName, email, phoneNumber, isLoggedIn;

	public ServiceExpert(String serviceExpert, String firstName, String lastName, String email, String phoneNumber,
			String isLoggedIn, String userName, String password) {
		super(userName, password);
		this.serviceExpertID = serviceExpert;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isLoggedIn = isLoggedIn;
	}

	public String getServiceExpertID() {
		return serviceExpertID;
	}

	public void setServiceExpertID(String serviceExpertID) {
		this.serviceExpertID = serviceExpertID;
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
		result = prime * result + ((serviceExpertID == null) ? 0 : serviceExpertID.hashCode());
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
		ServiceExpert other = (ServiceExpert) obj;
		if (serviceExpertID == null) {
			if (other.serviceExpertID != null)
				return false;
		} else if (!serviceExpertID.equals(other.serviceExpertID))
			return false;
		return true;
	}

}
