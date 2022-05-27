package client_gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import client.ClientController;
import client.ClientHandleTransmission;
import client.ClientUI;
import client.OrderHandleController;
import client.popMessageHandler;
import entities_catalog.ProductInBranch;
import entities_general.Branch;
import enums.Branches;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * @author Mor Ben Haim , Almog Madar
 * */
public class OrderPageController implements Initializable{

	@FXML
	private Button backBtn;

	@FXML
	private Button confirmBtn;
	
	@FXML
	private TextField greetingCard;
	
	@FXML
    private ComboBox<Branches> getBranchName=new ComboBox<>();
	
    @FXML
    private RadioButton ImidiateOrderRadio;

    @FXML
    private Label OrderMassageLabel;
    
    @FXML
    private RadioButton bleesingCardRadio;
    
    @FXML
    private DatePicker datePickUP;
   
    @FXML
    private TextField deliveryAddressTxtField;
    
    @FXML
    private TextField deliveryPersonNameTxtField;
	
    @FXML
    private TextField deliveryPhoneEndTxtField;
	
    @FXML
    private TextField deliveryPhoneStartTxtField;
    
    
    @FXML
    private RadioButton deliveryRadio;
    
    
    @FXML
    private ComboBox<Time> hoursPickUpComboBox;
    
    @FXML
    private HBox hbox1;

    @FXML
    private HBox hbox2;

    @FXML
    private HBox hbox3;

    @FXML
    private HBox hbox4;
    
    
    @FXML
    private Label deliveryPriceLabel;
    
    @FXML
    private ProgressIndicator progressIndicator;
    
    private ObservableList<Branches> branchOptions=FXCollections.observableArrayList();
    //private List<Branch> branches = new ArrayList<>();
    
    
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/OrderPage.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setTitle("Order Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event ->{
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
			});	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Progress bar state - 85%
		progressIndicator.setStyle("-fx-color: #D0F6DD ; -fx-accent: green;");
		progressIndicator.setProgress(0.85f);
		// turn off blessing card 
		greetingCard.setVisible(false);
		deliveryOptionsSelection("close");
		// hours pick up comboBox 
		ObservableList<Time> orderTimesPickUp = FXCollections.observableArrayList();
		timeInit8To20(orderTimesPickUp);
		hoursPickUpComboBox.setItems(orderTimesPickUp);
	
		//get branches from database 
		
		List<Branches> branches = ClientHandleTransmission.getBranches();
		if(branches.size()!=0)
		{
				branchOptions.addAll(branches);
		}
		this.getBranchName.setItems(branchOptions);
		this.getBranchName.setValue(Branches.KARMIEL);
	}
	
	
	/**
	 * event when customer press confirm this event 
	 * adding the order to the DB after the customer 
	 * finish his order
	 * 
	 * @param event
	 * @author Almog Madar , Mor Ben-Haim
	 */
	@FXML
	void confirm(ActionEvent event) {

		//get product in branch and set on OrderHandleController .
		List<ProductInBranch> productInBranch =ClientHandleTransmission.getProductInSpecificBranch(getBranchName.getValue());
		System.out.println(productInBranch);
		if(productInBranch.size()==0)
		{
			System.out.println("popup -> no items in haifa");
		}
		else
		{
			OrderHandleController.setProductInBranch(productInBranch);
			
			if(!OrderHandleController.checkQuantityInOrder()) {
				System.out.println(OrderHandleController.getMsg());
				//set massage to pop-up screen
				popMessageHandler.setMessage(OrderHandleController.getMsg());
				popMessageHandler.setTitle("Wrong Quantity Problem");
				
				GenaralPopScroolBarUpController genaralPopScroolBarUpController = new GenaralPopScroolBarUpController();
				try {
					genaralPopScroolBarUpController.start(new Stage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			else
			{
				//getBranchName.getValue();
				//ClientHandleTransmission.addOrder(getBranchName.getValue(),greetingCard.getText());
				//OrderMassageLabel.setText("Order (12467) accepted and waiting to approved");
			}	
		}		
	}


	@FXML
	void back(ActionEvent event) throws Exception {
		//clear static screen
		CartPageController.listViewCustom.clear();
		
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CartPageController cartPageController = new CartPageController();
		cartPageController.start(primaryStage);
	}

	
    @FXML
    void bleesingCardRadioSelected(ActionEvent event) {
    	if(bleesingCardRadio.isSelected())
    		greetingCard.setVisible(true);
    	else
    		greetingCard.setVisible(false);
    }
	
    
    @FXML
    void ImidiateOrderSelected(ActionEvent event) {
    	if(ImidiateOrderRadio.isSelected()) {
    		//close Imidiate option
    		deliveryRadio.setSelected(false);
    		deliveryOptionsSelection("close");
    	}

    }
	
    @FXML
    void DeliverySelected(ActionEvent event) {
    	if(deliveryRadio.isSelected()) {
    		//close Imidiate option
    		ImidiateOrderRadio.setSelected(false);
    		//open options Visibility
    		deliveryOptionsSelection("open");
    	}
    }
    
    private void deliveryOptionsSelection(String mission) {
    	
    	if(mission.equals("open")) {
    		hbox1.setVisible(true);
    		hbox2.setVisible(true);
    		hbox3.setVisible(true);
    		hbox4.setVisible(true);
    		deliveryPriceLabel.setVisible(true);
    	}
    	else
    	{
    		hbox1.setVisible(false);
    		hbox2.setVisible(false);
    		hbox3.setVisible(false);
    		hbox4.setVisible(false);
    		deliveryPriceLabel.setVisible(false);
    	}

    }
    
    
	private void timeInit8To20(ObservableList<Time> orderTimesPickUp) {
		Time time;
		int hours=8,min=0;
		
		for(int i=0;i<12;i++) 
		{
			for(int j=0;j<3;j++) 
			{
				if(j==0){
					min=0;
					
				}
				else if(j==1){
					min=30;
				}
				else{
					hours++;
					min=0;
				}
				time = new Time(hours,min,0);
				orderTimesPickUp.add(time);
			}
		}
	}
   	

}