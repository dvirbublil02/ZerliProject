package client_gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import entities_general.WorkersPreview;
import entities_users.ShopWorker;
import enums.ShopWorkerActivity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BranchManagerEditUserController implements Initializable{

//need to update colomns in gui
	   @FXML
	    private TableColumn<?, ?> accountStatusCol;

	    @FXML
	    private TableColumn<WorkersPreview, ComboBox<ShopWorkerActivity>> activityStatusCol;

	    @FXML
	    private Button approveEditBTN;//for worker edit

	    @FXML
	    private Button approveEditBTN1;//for customer edit

	    @FXML
	    private Button backBTN;

	    @FXML
	    private TableColumn<?, ?> balanceCol;

	    @FXML
	    private TableColumn<WorkersPreview, String> branchIDcol;

	    @FXML
	    private TableColumn<?, ?> customerIDCol;

	    @FXML
	    private TableColumn<?, ?> emailCol;//of customer

	    @FXML
	    private TableColumn<WorkersPreview, String> firstNameCol;//of worker

	    @FXML
	    private TableColumn<WorkersPreview, String> lastNameCol;

	    @FXML
	    private TableColumn<WorkersPreview, String> shopWorkerIDCol;

	    @FXML
	    private TableView<WorkersPreview> workers;
	    @FXML
	    private TableView<?> customer;
	    
	    private ObservableList<WorkersPreview> workersListView=FXCollections.observableArrayList();
	    
    @FXML
	void back(ActionEvent event) throws Exception {

		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		BranchManagerPageController branchPage = new BranchManagerPageController();
		branchPage.start(primaryStage);
	}
    public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/BranchManagerEditUserPage.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setTitle("edit user's deatails Page");
		primaryStage.setScene(scene);

		primaryStage.show();
	}
    
    @Override
	public void initialize(URL location, ResourceBundle resources) 
    {
    	firstNameCol.setCellValueFactory(new PropertyValueFactory<WorkersPreview,String>("firstName"));
    	lastNameCol.setCellValueFactory(new PropertyValueFactory<WorkersPreview,String>("lastName"));
    	shopWorkerIDCol.setCellValueFactory(new PropertyValueFactory<WorkersPreview,String>("ID"));
    	branchIDcol.setCellValueFactory(new PropertyValueFactory<WorkersPreview,String>("branchID"));
    	activityStatusCol.setCellValueFactory(new PropertyValueFactory<WorkersPreview,ComboBox<ShopWorkerActivity>>("activityStatusCB"));
    	List<ShopWorker> list=ClientHandleTransmission.getShopWorkers();
    	if(list.size()>0)
    	{
    		for(ShopWorker sw:list)
    		{
    			workersListView.add(new WorkersPreview(sw.getID(),sw.getFirstName(),sw.getLastName(),sw.getEmail(),sw.getPhoneNumber(),sw.getAccountStatus(),sw.getIsLoggedIn(),sw.getBranchID(),sw.getActivityStatus()));
    		}
    		
    		workers.setItems(workersListView);
    	}
	}
    @FXML
    void approveEdit(ActionEvent event) {

    }
    
    @FXML
    void freezeOrDefreezeAccount(ActionEvent event) {

    }
    
    
    
    
}