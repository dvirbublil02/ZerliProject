package server_gui;
 
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import communication.TransmissionPack;
import communication.msgClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import server.ServerUI;

/**
 * This Class is controller to control the server screen, and to handle with all
 * this screen operations
 *
 */
public class ServerScreenController implements Initializable {

	@FXML
	private Button BTNConnect;

	@FXML
	private Button BTNDisconnect;

	@FXML
	private Button BTNImport;

	@FXML
	private Pane ServerPane;

	@FXML
	private TextField TxtDataBase;

	@FXML
	private TextField TxtIp;

	@FXML
	private PasswordField TxtPassword;

	@FXML
	private TextField TxtPort;

	@FXML
	private TextField TxtUserName;

	@FXML
	private TableColumn<ClientDetails, String> hostCol;

	@FXML
	private TableColumn<ClientDetails, String> ipCol;

	@FXML
	private TableColumn<ClientDetails, String> statusCol;

	@FXML
	private TableView<ClientDetails> table;

	@FXML
	private TableColumn<msgClass, String> msgCol;

	@FXML
	private TableView<msgClass> msgTable;

	private static boolean ifFirstConnector;
	private static boolean ifFirstMsg;
	private List<String> data = new ArrayList<String>();
	static ObservableList<ClientDetails> clients = FXCollections.observableArrayList();
	static ObservableList<msgClass> listView2 = FXCollections.observableArrayList();

	/**
	 * in this method we loading the server screen (FXML)
	 * 
	 * @param primaryStage
	 * @throws Exception
	 */
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/server_gui/ServerFXML.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setTitle("ZerLi Server");
		primaryStage.setScene(scene);

		primaryStage.show();
		primaryStage.setResizable(false);
	}

	/**
	 * In this method we handling with the connect button click , we getting the
	 * host details ,then we calling SErverUI.RunServer with this details to connect
	 * him into the DB.
	 * 
	 * @param event
	 */
	@FXML
	void Connect(ActionEvent event) {
		String p;
		data.add(TxtDataBase.getText());
		data.add(TxtUserName.getText());
		data.add(TxtPassword.getText());

		System.out.println(data.toString());
		p = getport();
		if (p.trim().isEmpty()) {
			System.out.println("You must enter a port number");

		} else {

			if (ServerUI.runServer(p, data)) {
				BTNConnect.setDisable(true);
				BTNDisconnect.setDisable(false); // only if there is host connected he can press discon

			}

		}

	}

	/**
	 * In this method we updating the clients list that connected to server
	 * (observable list)
	 * 
	 * @param obj - the transmission
	 */
	@SuppressWarnings("unchecked")
	public static boolean SetObser(TransmissionPack obj) {
		ArrayList<String> list = (ArrayList<String>) obj.getInformation();
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).getIp().equals(list.get(0)))
				return false;
		}
		ClientDetails client = new ClientDetails(list.get(0), list.get(1), "Connected");
		clients.add(client);
		if (ifFirstConnector == true) {
			clients.remove(0);
			ifFirstConnector = false;
		}
		return true;

	}

	/**
	 * In this method we handling with the disconnect button click, we clearing the
	 * tables that on the screen , stopping the server listening ,and the
	 * connection.
	 * 
	 * @param event
	 */
	@FXML
	void Disconnect(ActionEvent event) {

		listView2.clear();
		clients.clear();
		ServerUI.stopServer();
		BTNDisconnect.setDisable(true);
		BTNConnect.setDisable(false);

	}

	// to be continued
	@FXML
	void Import(ActionEvent event) {
		// to be continued
	}

	/**
	 * In this method we loading the started information , straight after the screen
	 * loaded
	 *
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadInformation();

	}

	/**
	 * In this method we loading information that need to be initialize , the tables
	 * on the screen and the textFields
	 * 
	 */
	private void loadInformation() {
		ClientDetails client = new ClientDetails("", "", "");
		clients.add(client);
		table.setItems(clients);
		ifFirstConnector = true;

		BTNDisconnect.setDisable(true);
		this.TxtPort.setText(String.valueOf(5556));
		try {
			this.TxtIp.setText(InetAddress.getLocalHost().getHostAddress());
			this.TxtIp.setDisable(true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		this.TxtDataBase.setText("jdbc:mysql://localhost/zerli?serverTimezone=IST");
		this.TxtUserName.setText("root");
		this.TxtPassword.setText("************");
		this.BTNImport.setDisable(true);
		try {
			InetAddress.getLocalHost().getHostName();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hostCol.setCellValueFactory(new PropertyValueFactory<ClientDetails, String>("hostName"));
		ipCol.setCellValueFactory(new PropertyValueFactory<ClientDetails, String>("ip"));
		statusCol.setCellValueFactory(new PropertyValueFactory<ClientDetails, String>("status"));
		msgCol.setCellValueFactory(new PropertyValueFactory<msgClass, String>("msg"));
		msgClass msg = new msgClass("");
		listView2.add(msg);
		ifFirstMsg = true;
		msgTable.setItems(listView2);

	}

	/**
	 * this method will update the messages that will be shown on the table(data
	 * base report) on the screen.
	 * 
	 * @param string - the string that will be on the data base report table on the
	 *               screen
	 */
	public static void SetMsg(String string) {

		msgClass msg = new msgClass(string.toString());
		listView2.add(msg);

		if (ifFirstMsg == true) {
			listView2.remove(0);
			ifFirstMsg = false;
		}

	}

	private String getport() {
		return TxtPort.getText();
	}

	// in this method we remove client that exist from the program
	public static void RemoveObser(TransmissionPack obj) {
		@SuppressWarnings("unchecked")
		ArrayList<String> list = (ArrayList<String>) obj.getInformation();
		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i).getIp().equals(list.get(0))) {
				clients.remove(i);
				break;
			}
		}
	}
}
