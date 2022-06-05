package entities_general;

import entities_users.ShopWorker;
import enums.AccountStatus;
import enums.ShopworkerRole;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class WorkersPreview extends ShopWorker
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComboBox<ShopworkerRole> activityStatus=new ComboBox<>();
	
	
	public ComboBox<ShopworkerRole> getActivityStatusCB() {
		return activityStatus;
	}

	public void setActivityStatusCB(ComboBox<ShopworkerRole> activityStatus) {
		this.activityStatus = activityStatus;
	}



	public WorkersPreview(String iD, String firstName, String lastName, String email, String phoneNumber,
			AccountStatus accountStatus, boolean isLoggedIn, String branchID,ShopworkerRole activityStatus) {
		super(iD, firstName, lastName, email, phoneNumber, accountStatus, isLoggedIn, branchID,activityStatus);
		
		ObservableList<ShopworkerRole> activityList=FXCollections.observableArrayList(ShopworkerRole.SURVEY,ShopworkerRole.GENERAL);
		this.activityStatus.setItems(activityList);
		this.activityStatus.setValue(activityStatus);
		
	
	}
	
	
	

}
