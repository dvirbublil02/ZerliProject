/** In this class we are handling with the Transmissions , we creating client transmission (with specific mission ) 
 * And sending it to the server by using ClientUI.chat.accept method, and getting back the response (Transmission)
 * And after that doing the specific task.
 * 
 *
 */
package client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import client_gui.BranchManagerPageController;
import client_gui.CartPageController;
import client_gui.CustomerPageController;
import client_gui.DeliveryAgentPageController;
import client_gui.CustomerServicePageController;
import client_gui.LoginController;
import client_gui.NetworkManagerPageController;
import communication.Mission;
import communication.Response;
import communication.TransmissionPack;
import entities_catalog.Product;
import entities_catalog.ProductInOrder;
import entities_general.CreditCard;
import entities_general.CustomersPreview;
import entities_general.Login;
import entities_general.Order;
import entities_general.OrderPreview;
import entities_general.WorkersPreview;
import entities_reports.Complaint;
import entities_reports.ComplaintPreview;
import entities_users.BranchManager;
import entities_users.Customer;
import entities_users.ShopWorker;
import entities_users.User;
import enums.BranchNames;
import enums.OrderStatus;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ClientHandleTransmission {
	
	/**
	 * In this method we are creating TransmissionPack that will contain ADDORDER
	 * mission ,and the information (order)- to insert into the DB, that will be
	 * send to the server by ClientUI.chat.accept , and the server will handle with
	 * the order
	 * 
	 * @param orderIdTxt      - order text field on the gui
	 * @param priceTxt        - price text field on the gui
	 * @param greetingCardTxt - greeting card text field on the gui
	 * @param colorTxt        - color text field on the gui
	 * @param dOrderTxt       - dOrder text field on the gui
	 * @param shopTxt         - shop text field on the gui
	 * @param dateTxt         - date text field on the gui
	 * @param orderDate       - order date text field on the gui
	 * @param statusTxt       - status text field on the gui
	 */
	/*
	 * public static void ADD_ORDER(TextField orderIdTxt, TextField priceTxt,
	 * TextField greetingCardTxt, TextField colorTxt, TextField dOrderTxt, TextField
	 * shopTxt, TextField dateTxt, TextField orderDate, Label statusTxt) { Order
	 * order = new Order(orderIdTxt.getText(), priceTxt.getText(),
	 * greetingCardTxt.getText(), colorTxt.getText(), dOrderTxt.getText(),
	 * shopTxt.getText(), dateTxt.getText(), orderDate.getText()); TransmissionPack
	 * obj = new TransmissionPack(Mission.ADD_ORDER, null, order);
	 * ClientUI.chat.accept(obj); obj = ClientUI.chat.getObj(); if
	 * (obj.getResponse() == Response.INSERT_ORDER_SUCCESS) {
	 * statusTxt.setTextFill(Color.GREEN); statusTxt.setText("Insert Success"); }
	 * else { statusTxt.setTextFill(Color.RED); statusTxt.setText("Insert Failed");
	 * }
	 * 
	 * }
	 */

	/**
	 * In this method we are creating Transmission that will contain GETORDERS
	 * mission , then we sending it to the server by using ClientUI.chat.accept ,
	 * after that we getting back the result (response and the information-the order
	 * table from the sql)
	 * 
	 * @param listView-listView that will contain the orders from the sql table
	 * @param table             - tableView contain orders
	 * @param statusLabel       - label that present the status (success or failed)
	 * @param list              - temp list to handle with the orders on the method
	 */
	@SuppressWarnings("unchecked")
	public static void GET_ORDERS(ObservableList<Order> listView, TableView<Order> table, Label statusLabel) {
		TransmissionPack obj = new TransmissionPack(Mission.GET_ORDER, null, null);
		ClientUI.chat.accept(obj);
		obj = ClientUI.chat.getObj();
		if (obj.getResponse() == Response.FOUND_ORDER) {
			listView.clear();
			List<Order> list = new ArrayList<Order>();
			list = (List<Order>) obj.getInformation();
			for (int i = 0; i < list.size(); i++) {
				listView.add(list.get(i));
			}
			table.setItems(listView);
			statusLabel.setTextFill(Color.GREEN);
			statusLabel.setText("Upload Success");
		} else {
			statusLabel.setTextFill(Color.RED);
			statusLabel.setText("Upload Failed");
		}
	}

	/**
	 * In this method we are creating Transmission that will contain EDITORDER
	 * mission , and the information that the user want to edit. then we sending it
	 * to the server by using ClientUI.chat.accept , after that we getting back the
	 * result (response) and doing the specific task according to the
	 * server-response.
	 * 
	 * @param statusLabel        - label that will contain the status of the request
	 * @param lblEditColor       - text field that contain the color to edit
	 * @param lblEditDate        - text field that contain the date to edit
	 * @param lblEditOrderNumber - text field that contain the order number to edit
	 */
	/*
	 * public static void EDIT_ORDER(Label statusLabel, TextField lblEditColor,
	 * TextField lblEditDate, TextField lblEditOrderNumber) { Order order = new
	 * Order(); order.setColor(lblEditColor.getText());
	 * order.setDate(lblEditDate.getText());
	 * order.setOrderNumber(lblEditOrderNumber.getText());
	 * System.out.println(order.getOrderNumber() + order.getColor() +
	 * order.getDate()); TransmissionPack obj = new
	 * TransmissionPack(Mission.EDIT_ORDER, null, order); ClientUI.chat.accept(obj);
	 * obj = ClientUI.chat.getObj(); if (obj.getResponse() ==
	 * Response.EDIT_ORDER_FAILD) { statusLabel.setTextFill(Color.RED);
	 * statusLabel.setText("Edit Failed"); } else {
	 * statusLabel.setTextFill(Color.GREEN); statusLabel.setText("Edit Success"); }
	 * 
	 * }
	 */

	public static void CONNECT_TO_SERVER(ActionEvent event, String ip, String port) throws Exception {
		ClientUI.chat = new ClientController(ip, Integer.parseInt(port));// logic

		TransmissionPack obj = new TransmissionPack(Mission.SEND_CONNECTION_DETAILS, null, null);
		List<String> details = new ArrayList<>();
		// gui for design
		details.add(InetAddress.getLocalHost().getHostAddress());
		details.add(InetAddress.getLocalHost().getHostName());
		obj.setInformation(details);
		// logic: check the response
		ClientUI.chat.accept(obj);
		obj = ClientUI.chat.getObj();
		if (obj.getResponse() == Response.UPDATE_CONNECTION_SUCCESS) {
			((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
			Stage primaryStage = new Stage();
			LoginController login = new LoginController();
			login.start(primaryStage);
		} else {
			//
		}
	}

	public static void logoutFromZerLi() {
		TransmissionPack tp = new TransmissionPack(Mission.USER_LOGOUT, null, ClientController.user);
		ClientUI.chat.accept(tp);
	}

	public static void DISCONNECT_FROM_SERVER() {
		logoutFromZerLi();
		TransmissionPack obj = new TransmissionPack(Mission.SEND_DISCONNECT_DETAILS, null, null);
		List<String> details = new ArrayList<>();
		try {
			details.add(InetAddress.getLocalHost().getHostAddress());
			details.add(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		obj.setInformation(details);
		ClientUI.chat.accept(obj);
	}

	public static void USER_LOGIN(TextField userTxt, TextField passwordTxt, Label errorLabel, MouseEvent event) {
		userTxt.setStyle(null);
		passwordTxt.setStyle(null);
		Login login = new Login(userTxt.getText(), passwordTxt.getText());

		if (checkLoginValidationFilling(login, userTxt, passwordTxt, errorLabel)) {
			TransmissionPack tp = new TransmissionPack(Mission.USER_LOGIN, null, login);
			ClientUI.chat.accept(tp);
			tp = ClientUI.chat.getObj();
			switch (tp.getResponse()) {
			case USER_NAME_OR_PASSWORD_INCORRECT: {
				errorLabel.setTextFill(Color.RED);
				errorLabel.setText("User name or password incorrect");
				break;
			}
			case USER_EXIST:
				try {
					loadTheRightScreen(event, tp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case USER_NOT_EXIST: {
				errorLabel.setTextFill(Color.RED);
				errorLabel.setText("User doesn't exist");
				break;
			}
			case USER_ALREADY_LOGGEDIN: {
				errorLabel.setTextFill(Color.RED);
				errorLabel.setText("User Already loggedin");
				break;
			}
			default:
				break;
			}
		}
	}

	private static boolean checkLoginValidationFilling(Login login, TextField userTxt, TextField passwordTxt,
			Label errorLabel) {
		if (login.getUserName().equals(""))
			userTxt.setStyle("-fx-border-color: red");
		if (login.getPassword().equals("")) { // checking if the user didn't enter both username and password.
			passwordTxt.setStyle("-fx-border-color: red");
		}
		if (login.getUserName().equals("") || login.getPassword().equals("")) {
			errorLabel.setText("Please fill all the fields on the screen");
			return false;
		} else
			return true;
	}
	/**
	 * get the colors filter for catalog initilizedProductGrid
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getColorsForFilter() {
		TransmissionPack tp=new TransmissionPack(Mission.GET_COLORS,null,null);
		ClientUI.chat.accept(tp);
		tp = ClientUI.chat.getObj();
		if(tp.getResponse()==Response.DID_NOT_FIND_COLORS) {
			//adding pop screen
		}
		return (ArrayList<String>)tp.getInformation();
	}
	/**
	 * this method is adding the pending order of the specific customer
	 * the order is waiting for approve from the branch manager
	 */


	public static void addOrder(BranchNames branchName,String greetingCard) {
	
		Map<String,List<ProductInOrder>> productInOrderFinallCart=OrderHandleController.getCustomProductInOrder();
		
		Order order =new Order(null,ClientController.user.getID(),branchName.name(),OrderHandleController.getTotalPrice(),
				greetingCard,OrderStatus.PENDING.name(),LocalDateTime.now().toString().toString(),productInOrderFinallCart);

		
	   
		productInOrderFinallCart.put("RegularProducts", OrderHandleController.getProductInOrder());

		TransmissionPack tp=new TransmissionPack(Mission.ADD_ORDER,null,order);
		ClientUI.chat.accept(tp);
	}
	/**
	 * this method return the ObserverList of the order that was not approved yet
	 * @return
	 */
	public static List<OrderPreview> getListOrderPreview() {
		TransmissionPack tp = new TransmissionPack(Mission.GET_ORDER, null, null);
		ClientUI.chat.accept(tp);
		tp = ClientUI.chat.getObj();
		List<OrderPreview> orderPreview = new ArrayList<>();
		if (tp.getResponse() == Response.FOUND_ORDER) {

			@SuppressWarnings("unchecked")
			List<Order> orders = (List<Order>) tp.getInformation();
			for (Order order : orders) {
				OrderPreview screen = new OrderPreview(order.getOrderID(), order.getCustomerID(), order.getBranchID(),
						order.getPrice(), order.getGreetingCard(), order.getOrderDate(), order.getExpectedDelivery(),
						order.getItems());
				screen.getComboStatus().setValue(order.getStatus());
				orderPreview.add(screen);

			}

		}
		return orderPreview;
	}

	private static void loadTheRightScreen(MouseEvent event, TransmissionPack tp) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		System.out.println(tp.getInformation().toString());
		ClientController.user = (User) tp.getInformation();
		switch (tp.getInformation().toString()) {
		case "Customer": {
			CustomerPageController menu = new CustomerPageController();
			menu.start(primaryStage);
			break;
		}
		case "Branch Manager": {
			BranchManagerPageController menu = new BranchManagerPageController();
			menu.start(primaryStage);
			break;
		}
//		case "Customer Service": {
//			CustomerServicePageController menu = new CustomerServiceController();
//			menu.start(primaryStage);
//			break;
//		}
		case "Delivery Agent": {
			DeliveryAgentPageController menu = new DeliveryAgentPageController();
			menu.start(primaryStage);
			break;
		}
//		case "Marketing Worker": {
//			MarketingWorkerPageController menu = new MarketingWorkerPageController();
//			menu.start(primaryStage);
//			break;
//		}
		case "Network Manager": {
			NetworkManagerPageController menu = new NetworkManagerPageController();
			menu.start(primaryStage);
			break;
		}
//		case "Service Expert": {
//			ServiceExpertPageController menu = new ServiceExpertPageController();
//			menu.start(primaryStage);
//			break;
//		}
//		case "Shop Worker": {
//			ShopWorkerPageController menu = new ShopWorkerPageController();
//			menu.start(primaryStage);
//			break;
//		}
		}

	}


	@SuppressWarnings("unchecked")
	public static List<Product> getDataProduct() {
		TransmissionPack tp = new TransmissionPack(Mission.DATA_PRODUCTS, null, null);
		ClientUI.chat.accept(tp);
		tp = ClientUI.chat.getObj();

		switch (tp.getResponse()) {
		case GET_DATA_PRODUCTS: {
			return (List<Product>) tp.getInformation();
		}

		case FAILD_DATA_PRODUCTS: {
			return null;
		}
		}
		return null;
	}

	// COLLCET PRODUCT BY FILTERS
	public static List<Product> getDataProductByFilter(String color, String price, String type) {
		TransmissionPack tp = new TransmissionPack(Mission.DATA_PRODUCTS_BY_FILTER, null, null);
		// initilaze filters 
				Map<String,String> filters = new HashMap<>();
				filters.put("color",color);
				filters.put("price",price);
				filters.put("type",type);

				//send to server side and get information.
				tp.setInformation(filters);
				ClientUI.chat.accept(tp);
				tp = ClientUI.chat.getObj();

				switch (tp.getResponse()) {
					case GET_DATA_PRODUCTS_BY_FILTER: {
						return (List<Product>) tp.getInformation();
					}

					case FAILD_DATA_PRODUCTS_BY_FILTER: {
						return null;
					}
				}
				return null;
	}

	public static List<ShopWorker> getShopWorkers() {
		TransmissionPack tp= new TransmissionPack(Mission.GET_SHOP_WORKERS,null,ClientController.user);
		ClientUI.chat.accept(tp);//tp sent to server and list of workers in the specific branch enters the tp
		tp= ClientUI.chat.getObj();
		return (List<ShopWorker>) tp.getInformation();
	}
	
	
	
	/**
	 * Get all the customers who has PENDING_APPROVAL status
	 * @return return the list of those customers 
	 */
	public static List<Customer> getPendingCustomers() {
		TransmissionPack tp= new TransmissionPack(Mission.GET_PENDING_CUSTOMERS,null,ClientController.user); // The user is Branch manager
		ClientUI.chat.accept(tp);
		tp= ClientUI.chat.getObj();
		return (List<Customer>)tp.getInformation();
	}
	
	/**
	 * Send an updated customer after changed his status and added him credit card, to the DB
	 * @param updatedCustomer
	 */
	public static boolean approveNewCustomer(Customer updatedCustomer) {
		TransmissionPack tp= new TransmissionPack(Mission.APPROVE_NEW_CUSTOMER,null,updatedCustomer); // The user is Branch manager
		ClientUI.chat.accept(tp);
		tp= ClientUI.chat.getObj();
		if (tp.getResponse() == Response.APPROVE_NEW_CUSTOMER_SUCCESS) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Get a list of the Credit cards we have in the DB 
	 * @return return the list of the credit cards numbers
	 */
	public static List<String> getCreditCards() {
		TransmissionPack tp= new TransmissionPack(Mission.GET_CREDIT_CARDS,null,ClientController.user); // The user is Branch manager
		ClientUI.chat.accept(tp);
		tp= ClientUI.chat.getObj();
		return (List<String>)tp.getInformation();
		
	}
	
	public static List<Customer> getApprovedCustomers() {
		TransmissionPack tp= new TransmissionPack(Mission.GET_APPROVED_CUSTOMERS,null,ClientController.user);
		ClientUI.chat.accept(tp);//tp sent to server through accept method, there its going through mission analyze  
		tp= ClientUI.chat.getObj();//the tp updated after the quarry and saved
		if(tp.getResponse()==Response.CUSTOMER_ARRIVED)
			return (List<Customer>) tp.getInformation();
		else
			return new ArrayList<Customer>();
	}

	public static boolean sendEditedCustomersFromBranchManager(ObservableList<CustomersPreview> customersListView) 
	{//the method sends a list of Customers from the list of CustomerPreview it gets, with the updated information
		List<Customer> customersToSendToDB= new ArrayList<>();//we can't send list of previewCustomers to DB so we create customers list
		
		for(CustomersPreview cp: customersListView)
		{
			customersToSendToDB.add(new Customer(cp.getID(), cp.getFirstName(), cp.getLastName(), cp.getEmail(), 
			cp.getPhoneNumber(),cp.getAccountStatusCB().getValue(), cp.getIsLoggedIn(), cp.getBalance(), cp.getIsNewCustomer(), cp.getCreditCard()));
		
		}
		TransmissionPack tp= new TransmissionPack(Mission.UPDATE_EDITED_CUSTOMERS,null,customersToSendToDB);
		ClientUI.chat.accept(tp);
		tp= ClientUI.chat.getObj();
		if(tp.getResponse()==Response.CUSTOMER_EDITS_UPDATED)
			return true;
		else
			 return false;
	}

	public static boolean sendEditedWorkersFromBranchManager(ObservableList<WorkersPreview> workersListView) 
	{//the method sends a list of ShopWorkers from the list of WorkerPreview it gets, with the updated information
		List<ShopWorker> workersToSendToDB= new ArrayList<>();//we can't send list of previewWorkers to DB so we create workers list
		
		for(WorkersPreview wp: workersListView)
		{
			workersToSendToDB.add(new ShopWorker(wp.getID(), wp.getFirstName(), wp.getLastName(), wp.getEmail(), 
			wp.getPhoneNumber(),wp.getAccountStatus(), wp.getIsLoggedIn(),wp.getBranchID(),wp.getActivityStatusCB().getValue()));
		
		}
		TransmissionPack tp= new TransmissionPack(Mission.UPDATE_EDITED_WORKERS,null,workersToSendToDB);
		ClientUI.chat.accept(tp);
		tp= ClientUI.chat.getObj();
		if(tp.getResponse()==Response.WORKER_EDITS_UPDATED)
			return true;
		else
			 return false;
		
	}
	/**
	 * sending mission the the server for get all the complaints of the specific 
	 * Customer Service employee
	 * @param ID-CustomerSerive ID
	 * @return- list of Complaints of Complaints for the screen
	 */
	public static List<ComplaintPreview> getComplaintsForCustomerService(String ID) {
		System.out.println(ID);
		TransmissionPack tp = new TransmissionPack(Mission.GET_COMPLAINTS, null, ID);
		ClientUI.chat.accept(tp);
		tp = ClientUI.chat.getObj();
		List<Complaint> complaints = (List<Complaint>) tp.getInformation();
		List<ComplaintPreview>complainPreview=new ArrayList<>();
		for(Complaint c:complaints) {
			ComplaintPreview cp=new ComplaintPreview(c.getComplaintID(),c.getCustomerID(),c.getOrderID() , c.getCustomerServiceID(), c.getDescription(), c.getBranchID(), c.getComplaintOpening(), c.getTreatmentUntil(), c.getComplainState(), c.getComplaintsStatus());
			cp.getStatus().setValue(c.getComplainState());
			complainPreview.add(cp);
		}
		ComplaintsDataHandle.setComlaints(complainPreview);
		
		return complainPreview;
	}
	/**
	 * sending mission to the server to update all the complaints cases
	 * and if there is refund amount it will create new refund row in the
	 * refund row and update to the specific customer his new balance
	 * @param complaintsUpdate
	 * @return
	 */
	public static Response updateComplaints(List<ComplaintPreview> complaintsUpdate) {
		
		List<ComplaintPreview> complainPreview =complaintsUpdate;
		List<Complaint>complain=new ArrayList<>();
		for(ComplaintPreview c:complainPreview) {
			Complaint cp=new Complaint(c.getComplaintID(),c.getCustomerID(),c.getOrderID() , c.getCustomerServiceID(), c.getDescription(), c.getBranchID(), c.getComplaintOpening(), c.getTreatmentUntil(), c.getComplainState(), c.getComplaintsStatus());
			cp.setComplainState(c.getStatus().getValue());
			System.out.println(c.getRefoundAmount());
			if(c.getRefoundAmount()!=null) {
			cp.setRefoundAmount(c.getRefoundAmount());
			}
			complain.add(cp);
		}
		
		TransmissionPack tp = new TransmissionPack(Mission.UPDATE_COMPLAINTS, null, complain);
		ClientUI.chat.accept(tp);
		tp = ClientUI.chat.getObj();
		return tp.getResponse();
		
	}
	/**
	 * create new mission to the server to create new complaint case
	 * @param c
	 * @return
	 */
	public static Response createComplaint(Complaint c) {
		TransmissionPack tp = new TransmissionPack(Mission.OPEN_COMPLAINT, null,c);
		ClientUI.chat.accept(tp);
		tp = ClientUI.chat.getObj();
		return tp.getResponse();
		
	}
}












