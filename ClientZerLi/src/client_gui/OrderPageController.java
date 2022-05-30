package client_gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import client.ClientController;
import client.ClientHandleTransmission;
import client.ClientUI;
import client.OrderHandleController;
import client.popMessageHandler;
import entities_catalog.ProductInBranch;
import entities_general.Branch;
import entities_general.Order;
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
    private Label totalPriceLabel;
    
    @FXML
    private ProgressIndicator progressIndicator;
    
    private ObservableList<Branches> branchOptions=FXCollections.observableArrayList();
    int orderID;
    String reciverName , phoneNumber , address ;
    boolean successCreateDeilivery=false , successImidiateOrder=false ;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	StringBuilder expectedDelivery = new StringBuilder();
	Date orderDate = new Date();
    
    
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
		hoursPickUpComboBox.setValue(new Time(LocalTime.now().getHour(),0,0));
		datePickUP.setValue(LocalDate.now());
		totalPriceLabel.setText(String.valueOf(OrderHandleController.getTotalPrice()));
		
    	//cancel date option pickup 
    	datePickUP.setDisable(true);
    	hoursPickUpComboBox.setDisable(true);
	
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
	 * adding delivers also if necessary 
	 * @param event
	 * @author Almog Madar , Mor Ben-Haim
	 */
	@FXML
	void confirm(ActionEvent event) {

		//get product in branch and set on OrderHandleController .
		List<ProductInBranch> productInBranch = ClientHandleTransmission.getProductInSpecificBranch(getBranchName.getValue());
		System.out.println(productInBranch);
		if(productInBranch.size()==0)
		{
			OrderMassageLabel.setText("Products out of stock in "+ getBranchName.getValue().name());
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
			else  // everything is OK ready to send order to database and create delivery.
			{
				if(ImidiateOrderRadio.isSelected())
				{
					Date d1 = new Date();
					Date d2 = new Date();
					Calendar c1 = Calendar.getInstance();
					// d1 current time
					d1=c1.getTime();
					c1.add(Calendar.HOUR,3);
					// d2 current time
					d2=c1.getTime();
					
					System.out.println("current->" + dateFormat.format(d1));
					System.out.println("3 later ->" + dateFormat.format(d2));
					
				
					orderID=ClientHandleTransmission.addOrder(getBranchName.getValue(),greetingCard.getText(),dateFormat.format(d1),dateFormat.format(d2),false);
					successImidiateOrder=true;
				}	
				else if(deliveryRadio.isSelected()) {
							
					expectedDelivery.append(datePickUP.getValue().toString()+" ");
					expectedDelivery.append(hoursPickUpComboBox.getValue().toString());
					System.out.println(expectedDelivery.toString());
					orderDate=Calendar.getInstance().getTime();
					System.out.println(dateFormat.format(orderDate));
					orderID=ClientHandleTransmission.addOrder(getBranchName.getValue(),greetingCard.getText(),dateFormat.format(orderDate),expectedDelivery.toString(),true);
				}
				
				
				//order fine 
				if(orderID!=0)
					if(deliveryRadio.isSelected())
					{
						reciverName = deliveryPersonNameTxtField.getText();
						address=deliveryAddressTxtField.getText();
						phoneNumber=deliveryPhoneStartTxtField.getText()+deliveryPhoneEndTxtField.getText();						
						successCreateDeilivery = ClientHandleTransmission.addDelivery(0,orderID,getBranchName.getValue(),dateFormat.format(orderDate),expectedDelivery.toString()
								,reciverName,address,phoneNumber);
						
						if(!successCreateDeilivery) {
							System.out.println("problem with create delivery ");
						}
					}
					

					progressIndicator.setProgress(1f);
					//label order screen
					OrderMassageLabel.setText("Order("+ orderID +") accepted and waiting to approved ");
					//pop-up massage init
					popMessageHandler.setMessage("Order("+ orderID +") accepted and waiting to approved ");
					popMessageHandler.setTitle("Order Completed");

					//open Customer Main screen 
					((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
					Stage primaryStage = new Stage();
					CustomerPageController custom = new CustomerPageController();
					try {
						custom.start(primaryStage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
					//open PopUp with approved about order. 
					GenaralPopScroolBarUpController genaralPopScroolBarUpController = new GenaralPopScroolBarUpController();
					try {
						genaralPopScroolBarUpController.start(new Stage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
					
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

	
	
	/**  customer request 
	 * 
	 * @param event - request blessing card ticket
	 */
    @FXML
    void bleesingCardRadioSelected(ActionEvent event) {
    	if(bleesingCardRadio.isSelected())
    		greetingCard.setVisible(true);
    	else
    		greetingCard.setVisible(false);
    }
	
    /**   click radio button to request TakeAway  
     * 
     * @param event of click on TakeAway radio button 
     */
    @FXML
    void ImidiateOrderSelected(ActionEvent event) {
    	//step progress 
    	progressIndicator.setProgress(0.92f);
    	
    	//cancel date option pickup 
    	datePickUP.setDisable(true);
    	hoursPickUpComboBox.setDisable(true);    	
    	
    	if(ImidiateOrderRadio.isSelected()) {
    		//close Immediate option
    		deliveryRadio.setSelected(false);
    		deliveryOptionsSelection("close");
    	}
    	else {
    		deliveryRadio.setSelected(true);
    	}

    }
    
    /**   click radio button to request delivery 
     * 
     * @param event of click on delivery radio button 
     */
    @FXML
    void DeliverySelected(ActionEvent event) {
  
    	//step progress 
    	progressIndicator.setProgress(0.92f);
    	
    	//open date option pickup 
    	datePickUP.setDisable(false);
    	hoursPickUpComboBox.setDisable(false); 
    	
    	
    	if(deliveryRadio.isSelected()) {
    		//close Immediate option
    		ImidiateOrderRadio.setSelected(false);
    		//open options Visibility
    		deliveryOptionsSelection("open");
    	}
    	else {
    		ImidiateOrderRadio.setSelected(true);
    	}
    }
    
    /** open or close  delivery options on screen 
     * 
     * 	@param mission - open or close hbox area
     */
    private void deliveryOptionsSelection(String mission) {
    	
    	if(mission.equals("open")) {
    		hbox1.setVisible(true);
    		hbox2.setVisible(true);
    		hbox3.setVisible(true);
    		hbox4.setVisible(true);
    		deliveryPriceLabel.setVisible(true);
    		totalPriceLabel.setText(String.valueOf(OrderHandleController.getTotalPrice()+OrderHandleController.getShippingPrice()));
    	}
    	else
    	{
    		hbox1.setVisible(false);
    		hbox2.setVisible(false);
    		hbox3.setVisible(false);
    		hbox4.setVisible(false);
    		deliveryPriceLabel.setVisible(false);
    		totalPriceLabel.setText(String.valueOf(OrderHandleController.getTotalPrice()));
    	}

    }
    
    
    
    /**Initialize time comboBox with object of Time (08:00 until 20:00)
     * 
     * @param orderTimesPickUp - list to add time Initialize
     */
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