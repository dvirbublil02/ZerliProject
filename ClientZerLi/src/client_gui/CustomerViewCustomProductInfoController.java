package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import entities_catalog.ProductInOrder;
import entities_general.OrderCustomCartPreview;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CustomerViewCustomProductInfoController implements Initializable {

    @FXML
    private TableView<ProductInOrder> customProductTable;

    @FXML
    private TableColumn<ProductInOrder, Double> priceCol;

    @FXML
    private TableColumn<ProductInOrder, String> productNameCol;

    @FXML
    private TableColumn<ProductInOrder, Integer> quantityInCartCol;

    @FXML
    private Button removeBtn;
    
    @FXML
    private Label massageLabel;

    @FXML
    private TableColumn<ProductInOrder, Integer> totalquantityCol;

    private static ObservableList<ProductInOrder> productDetails = FXCollections.observableArrayList();
    
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/CustomerViewCustomProductInfo.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Custom Product Details Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		//need to update list of product inside OrderHandleController 
		primaryStage.setOnCloseRequest(event ->{
			
			});	
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Cart Table Initialize
		productNameCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, String>("name"));
		totalquantityCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, Integer>("quantity"));
		quantityInCartCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, Integer>("productQuantityInCart"));
		priceCol.setCellValueFactory(new PropertyValueFactory<ProductInOrder, Double>("price"));
		customProductTable.setItems(productDetails);
	}
	
	
	@FXML
    void remove(ActionEvent event) {
		
		ObservableList<ProductInOrder> productSelected , allProducts;
		allProducts=customProductTable.getItems();
		productSelected=customProductTable.getSelectionModel().getSelectedItems();
		
		if(allProducts.isEmpty())
			massageLabel.setText("Table Allready Empty");
		try {
			productSelected.forEach(allProducts::remove);
		} catch (NoSuchElementException e) {
			massageLabel.setText("Table empty!!");
		}
		
		
    }
    
    public ObservableList<ProductInOrder> getProductDetails() {
		return productDetails;
	}


	public void setProductDetails(ObservableList<ProductInOrder> productDetails) {
		CustomerViewCustomProductInfoController.productDetails.addAll(productDetails);
		//set table to show products 
		System.out.println("here-->"+productDetails);
	}







}