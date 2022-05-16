package entities_general;

import entities_users.ShopWorker;
import enums.AccountStatus;
import enums.ShopWorkerActivity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class WorkersPreview extends ShopWorker
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComboBox<ShopWorkerActivity> activityStatus=new ComboBox<>();
	
	
	public ComboBox<ShopWorkerActivity> getActivityStatusCB() {
		return activityStatus;
	}

	public void setActivityStatusCB(ComboBox<ShopWorkerActivity> activityStatus) {
		this.activityStatus = activityStatus;
	}



	public WorkersPreview(String iD, String firstName, String lastName, String email, String phoneNumber,
			AccountStatus accountStatus, boolean isLoggedIn, String branchID,ShopWorkerActivity activityStatus) {
		super(iD, firstName, lastName, email, phoneNumber, accountStatus, isLoggedIn, branchID,activityStatus);
		
		ObservableList<ShopWorkerActivity> activityList=FXCollections.observableArrayList(ShopWorkerActivity.ACTIVE,ShopWorkerActivity.NOT_ACTIVE);
		this.activityStatus.setItems(activityList);
		this.activityStatus.setValue(activityStatus);
		
	
	}
	
	
	

}
