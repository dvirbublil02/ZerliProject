package entities_reports;

public class Complaint {
	String complaintID, customerID, customerServiceID, description, branchID;

	public Complaint(String complaintID, String customerID, String customerServiceID, String description,
			String branchID) {
		super();
		this.complaintID = complaintID;
		this.customerID = customerID;
		this.customerServiceID = customerServiceID;
		this.description = description;
		this.branchID = branchID;
	}
	
	public String getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(String complaintID) {
		this.complaintID = complaintID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerServiceID() {
		return customerServiceID;
	}

	public void setCustomerServiceID(String customerServiceID) {
		this.customerServiceID = customerServiceID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBranchID() {
		return branchID;
	}

	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complaintID == null) ? 0 : complaintID.hashCode());
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
		Complaint other = (Complaint) obj;
		if (complaintID == null) {
			if (other.complaintID != null)
				return false;
		} else if (!complaintID.equals(other.complaintID))
			return false;
		return true;
	}
	
}
