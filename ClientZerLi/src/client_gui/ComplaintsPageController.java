package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import client.ClientController;
import client.ClientHandleTransmission;
import entities_reports.Complaint;
import entities_users.CustomerService;
import enums.OrderStatus;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ComplaintsPageController implements Initializable{
	@FXML
	private Button Back;
	@FXML
	private Label employeeName;
	@FXML
	private Label entryGreeting;

	@FXML
	private Label accountStatus;
	@FXML
	private Label phoneNumber;
    @FXML
    private Label employeeType;

	@FXML
	private TableView<Complaint> Complaints;

	@FXML
	private TableColumn<Complaint, String> complaintIDCol;

	@FXML
	private TableColumn<Complaint, String> customerIDCol;

	@FXML
	private TableColumn<Complaint, String> complaintOpeningCol;

	@FXML
	private TableColumn<Complaint, String> treatmentUntilCol;

	

	@FXML
	private TableColumn<Complaint, String> priceCol;

	@FXML
	private TableColumn<Complaint, Button> showCol;

	@FXML
	private TableColumn<Complaint, ComboBox<OrderStatus>> statusCol;

	private ObservableList<Complaint> listView = FXCollections.observableArrayList();

	@FXML
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/ComplaintsPage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Complaints");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event -> {
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
		});
	}

	@FXML
	void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CustomerServicePageController customerServicePageController = new CustomerServicePageController();
		customerServicePageController.start(primaryStage);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		showCol.setCellFactory(ShowButtonTableCell.<Complaint>forTableColumn("description", (Complaint c) -> {

			// need to send list to screen
			// ObservableList<Product>
			// listToNextScreen=FXCollections.observableArrayList(o.getItems());

			// open screen of details -- > need to init before starting
			Stage primaryStage = new Stage();
			ComplaintsDescriptionPageController complaintsDescriptionPageController = new ComplaintsDescriptionPageController();

			
//				
				try {
					complaintsDescriptionPageController.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

			return c;
		}));
		complaintIDCol.setCellValueFactory(new PropertyValueFactory<Complaint, String>("complaintID"));
		customerIDCol.setCellValueFactory(new PropertyValueFactory<Complaint, String>("customerID"));
		complaintOpeningCol.setCellValueFactory(new PropertyValueFactory<Complaint, String>("complaintOpening"));
		treatmentUntilCol.setCellValueFactory(new PropertyValueFactory<Complaint, String>("treatmentUntil"));
		// show button function
	

//		
		ClientController.initalizeUserDetails(employeeName, phoneNumber, accountStatus,entryGreeting);
		System.out.println((CustomerService)ClientController.user);
		listView.addAll(ClientHandleTransmission.getComplaintsForCustomerService(ClientController.user.getID()));
		Complaints.setItems(listView);

	}
}
