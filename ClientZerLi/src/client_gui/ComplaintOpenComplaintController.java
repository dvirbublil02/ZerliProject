package client_gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import client.ClientController;
import client.ClientHandleTransmission;
import communication.Response;
import entities_reports.Complaint;
import entities_users.CustomerService;
import enums.Branches;
import enums.ComplaintsStatus;
import javafx.animation.AnimationTimer;
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
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * Controller for customerService for open complaint for customer
 * on specific order
 * @author Mor Ben Haim
 *
 */
public class ComplaintOpenComplaintController implements Initializable {
	@FXML
	private Button backBtn;

	@FXML
	private Label employeeName;
	@FXML
	private Label phoneNumber;
	@FXML
	private Label accountStatus;
	@FXML
	private Label timer;
	@FXML
	private Label entryGreeting;
	@FXML
	private Label feedbackMessage;
	@FXML
	private TextField customerID;
	@FXML
	private TextField customerServiceID;
	@FXML
	private Label numberValidationCheck;
	@FXML
	private TextField description;
	@FXML
	private TextField orderID;

	@FXML
	private Label numberValidationCheck2;

	@FXML
	private Label numberValidationCheck3;
	@FXML
	private Label employeeType;
	@FXML
	private ComboBox<Branches> branches = new ComboBox<>();;

	@FXML
	private ObservableList<Branches> branchName = FXCollections.observableArrayList(Branches.KARMIEL);

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ComplaintOpenComplaintControllerPage.fxml"));

		Scene scene = new Scene(root);

		primaryStage.setTitle("Open Complaint Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event -> {
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
		});
	}

	/**
	 * go back the customerService menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void back(ActionEvent event) throws IOException {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CustomerServicePageController customerServicePageController = new CustomerServicePageController();
		customerServicePageController.start(primaryStage);

	}

	/**
	 * create new complaint case and and insert him to the DB
	 * 
	 * @param event
	 */
	@FXML
	void create(ActionEvent event) {

		if (!checkFillField() && !checkValidField()) {
			resetValidationCheck();
			Complaint c = new Complaint(null, customerID.getText(), orderID.getText(), customerServiceID.getText(),
					description.getText(), String.valueOf(Branches.KARMIEL.getNumber()), timer.getText(), null, ComplaintsStatus.OPEN, null);
			if (ClientHandleTransmission.createComplaint(c) == Response.OPEN_COMPLAINT_SUCCEED) {
				feedbackMessage.setText("Open Complaint Succeed");
				feedbackMessage.setTextFill(Color.GREEN);
			} else {
				feedbackMessage.setText("Open Complaint Failed");
				feedbackMessage.setTextFill(Color.RED);
			}
		}

	}
	/**
	 * reset all in valid field,this method called
	 * when all field are fill and valid
	 */
	private void resetValidationCheck() {
		resetEmtyFillBorder();

		resetCheckValidField();

	}
	/**
	 * reset all border fill
	 */
	private void resetEmtyFillBorder() {
		
		branches.setStyle("-fx-border-color: white");
		customerID.setStyle("-fx-border-color: white");
		customerServiceID.setStyle("-fx-border-color: white");
		orderID.setStyle("-fx-border-color: white");
		description.setStyle("-fx-border-color: white");
	}
	/**
	 * reset all text fill
	 */
	private void resetCheckValidField() {

		numberValidationCheck.setText("");
		numberValidationCheck.setTextFill(Color.WHITE);
		numberValidationCheck2.setText("");
		numberValidationCheck2.setTextFill(Color.WHITE);
		numberValidationCheck3.setText("");
		numberValidationCheck3.setTextFill(Color.WHITE);
	}
	/**
	 * check if one of the field is in valid
	 * @return
	 */
	private boolean checkValidField() {
		resetEmtyFillBorder();
		boolean flag = false;

		if (!customerID.getText().matches("[0-9]+")) {
			flag = true;
			numberValidationCheck.setText("Insert Numbers Only!");
			numberValidationCheck.setTextFill(Color.RED);
		}else {
			numberValidationCheck.setText("");
			numberValidationCheck.setTextFill(Color.WHITE);
		}
		if (!customerServiceID.getText().matches("[0-9]+")) {
			flag = true;
			numberValidationCheck2.setText("Insert Numbers Only!");
			numberValidationCheck2.setTextFill(Color.RED);
		}else {
			numberValidationCheck2.setText("");
			numberValidationCheck2.setTextFill(Color.WHITE);
		}
		if (!orderID.getText().matches("[0-9]+")) {
			flag = true;
			numberValidationCheck3.setText("Insert Numbers Only!");
			numberValidationCheck3.setTextFill(Color.RED);
		}else {
			numberValidationCheck3.setText("");
			numberValidationCheck3.setTextFill(Color.WHITE);
		}
		return flag;
	}
	/**
	 * check if one of the field is empty
	 * @return
	 */
	private boolean checkFillField() {
		boolean flag = false;
		if (branches.getValue()==null) {
			branches.setStyle("-fx-border-color: red");
		}else {
			branches.setStyle("-fx-border-color: white");
		}
		
		if (customerID.getText().equals("")) {
			flag = true;
			customerID.setStyle("-fx-border-color: red");
		}else {
			customerID.setStyle("-fx-border-color: white");
		}
		if (customerServiceID.getText().equals("")) {
			flag = true;
			customerServiceID.setStyle("-fx-border-color: red");
		}else {
			customerServiceID.setStyle("-fx-border-color: white");
		}
		if (orderID.getText().equals("")) {
			flag = true;
			orderID.setStyle("-fx-border-color: red");
		}else {
			orderID.setStyle("-fx-border-color: white");
		}

		if (description.getText().equals("")) {
			flag = true;
			description.setStyle("-fx-border-color: red");
		}else {
			description.setStyle("-fx-border-color: white");
		}
		return flag;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		AnimationTimer time = new AnimationTimer() {
			@Override
			public void handle(long now) {
				timer.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			}
		};

		time.start();
		customerServiceID.setText(ClientController.user.getID());
		branches.setItems(branchName);
		ClientController.initalizeUserDetails(employeeName, phoneNumber, accountStatus, entryGreeting, employeeType,
				((CustomerService) ClientController.user).toString());

	}
}
