package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import entities_catalog.ProductInOrder;
import entities_general.DeliveryPreview;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DeliveryAgentViewOrderController implements Initializable {

    @FXML
    private Button closeBtn;

    @FXML
    private TableView<ProductInOrder> customProductTable;

    @FXML
    private Label customSelectionDetailsLabel;

    @FXML
    private TableColumn<ProductInOrder, String> productNameCol;

    @FXML
    private TableColumn<ProductInOrder, Integer> quantityCol;

	@FXML
	private TableColumn<ProductInOrder, Double> priceCol;
	
	ObservableList<ProductInOrder> products = FXCollections.observableArrayList();
   
    public void start(Stage stage) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/client_gui/DeliveryAgentViewOrder.fxml"));
    	Scene scene = new Scene(root);
    	stage.setTitle("Delivery Agent View Order");
    	stage.setScene(scene);
    	stage.show();
    }
    	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	productNameCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, String>("nameOfProduct"));
    	quantityCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, Integer>("productQuantityInCart"));
		priceCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, Double>("price"));    	
		
		
    }

    @FXML
    void Close(ActionEvent event) {
    	
    }

}
    
  
