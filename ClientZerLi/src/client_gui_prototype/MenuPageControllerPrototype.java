package client_gui_prototype;

import java.io.IOException;

import client.ClientHandleTransmission;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**This class is controller to the menuPage screen , we handling here with all the menu screen operations
 * 
 *
 */
public class MenuPageControllerPrototype {

	@FXML
	private Button addBtn;

	@FXML
	private Button getOrEditBtn;
	


	/** In this method we loading the menu screen (FXML)
	 * @param primaryStage
	 * @throws Exception
	 */
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/MenuPage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("ZerLi Menu Prototype");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		
		primaryStage.setOnCloseRequest(event ->{
		ClientHandleTransmission.DISCONNECT_FROM_SERVER();
		});

	}

	/**In this method we loading the add new item screen
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void ADD(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
		Pane root = loader.load(getClass().getResource("/client_gui/AddOrder.fxml").openStream());
		Scene scene = new Scene(root); // create a scene
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Add Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		primaryStage.setOnCloseRequest(event1 ->{
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
			});

	}

	/**In this method we loading the GetORder/edit screen
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void GETOREDIT(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
		Pane root = loader.load(getClass().getResource("/client_gui/GetOrders.fxml").openStream());
		Scene scene = new Scene(root); // create a scene
		scene.getStylesheets().add(getClass().getResource("/client_gui/GetOrdersScreenDesign.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Get / Edit Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		primaryStage.setOnCloseRequest(event2 ->{
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
			});

	}
	
	
}