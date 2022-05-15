package client_gui;

import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BranchManagerEditUserController implements Initializable{


    @FXML
    private TableView<?> Orders;

    @FXML
    private TableView<?> Orders1;

    @FXML
    private Button approveEditBTN;

    @FXML
    private Button approveEditBTN1;

    @FXML
    private Button backBTN;

    @FXML
    private TableColumn<?, ?> branchIDCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> nameCol1;

    @FXML
    private TableColumn<?, ?> productIDCol;

    @FXML
    private TableColumn<?, ?> productIDCol1;

    @FXML
    private TableColumn<?, ?> quantityInCartCol;

    @FXML
    private TableColumn<?, ?> quantityInCartCol1;

    @FXML
    private TableColumn<?, ?> totalquantityCol;

    @FXML
    private TableColumn<?, ?> totalquantityCol1;


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
	public void initialize(URL location, ResourceBundle resources) {

	}
    @FXML
    void approveEdit(ActionEvent event) {

    }
    
    @FXML
    void freezeOrDefreezeAccount(ActionEvent event) {

    }
    
    
    
    
}