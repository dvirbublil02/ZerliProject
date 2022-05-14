package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import client.ClientHandleTransmission;
import client.OrderHandleController;
import entities_catalog.Cart;
import entities_catalog.ProductInOrder;
import entities_general.Order;
import entities_general.OrderCustomCartPreview;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class CartPageController implements Initializable {

	
	
	//OrderCustomCartPreview - > Image , Name , Quantity , Description 
	
    @FXML
    private TableColumn<?, ?> ImgColRegularTbl;

    @FXML
    private TableColumn<OrderCustomCartPreview, ImageView> ImgCustomColTbl;

    @FXML
    private TableColumn<?, ?> ItemNameColRegularTbl;

    @FXML
    private TableColumn<OrderCustomCartPreview, String> ItemNameCustomColTbl;

    @FXML
    private TableColumn<?, ?> QuantityColRegularTbl;

    @FXML
    private TableColumn<OrderCustomCartPreview, Integer> QuantityCustomColTbl;

    @FXML
    private Button backBtn;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button removeCustomProductBtn;

    @FXML
    private Button removeRegularBtn;

    @FXML
    private TableColumn<OrderCustomCartPreview, Button> showCustomTbl;

    @FXML
    private TableView<OrderCustomCartPreview> tableCustom;

    @FXML
    private TableView<?> tableRegular;

    @FXML
    private TableColumn<?, ?> totalPriceColRegularTbl;

    @FXML
    private TableColumn<OrderCustomCartPreview, Double> totalPriceCustomColTbl;
    

	private ObservableList<OrderCustomCartPreview> listViewCustom = FXCollections.observableArrayList();

	

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/CartPage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Cart Page");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event ->{
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
			});	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// show button function
		showCustomTbl.setCellFactory(ShowButtonTableCell.<OrderCustomCartPreview>forTableColumn("Details", (OrderCustomCartPreview o) -> {

			// new windows add send him the productInOrder list with the info
			Stage primaryStage = new Stage();
			CustomerViewCustomProductInfoController customProductDetails = new CustomerViewCustomProductInfoController();
			try {
				System.out.println(o.getCartList());
				customProductDetails.setProductDetails(o.getCartList());
				customProductDetails.start(primaryStage);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return o;
		}));
		
		
		//Cart Table Initilaze
		ImgCustomColTbl.setCellValueFactory(new PropertyValueFactory<OrderCustomCartPreview, ImageView>("imgSrc"));
		ItemNameCustomColTbl.setCellValueFactory(new PropertyValueFactory<OrderCustomCartPreview, String>("name"));
		QuantityCustomColTbl.setCellValueFactory(new PropertyValueFactory<OrderCustomCartPreview, Integer>("quantity"));
		totalPriceCustomColTbl.setCellValueFactory(new PropertyValueFactory<OrderCustomCartPreview, Double>("totalprice"));
		
		
		//add all Custom product to screen 
		Map<String,List<ProductInOrder>> customProductInOrderFinallCart = OrderHandleController.getCustomProductInOrderFinallCart();
		for(String customName : customProductInOrderFinallCart.keySet())
		{
			Image image1 = new Image("/javafx_images/CustomOrderPicture.png", 60, 60, true, true);
			ImageView imageView1 = new ImageView(image1);
			imageView1.setImage(image1);
			listViewCustom.add(new OrderCustomCartPreview(imageView1,customName, 50, 50.0, customProductInOrderFinallCart.get(customName)));
		}
		
		//set table to show products 
		tableCustom.setItems(listViewCustom);

	}
	
	
	
	@FXML
	void back(ActionEvent event) {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CatalogScreenController catalogPage = new CatalogScreenController();
		try {
			catalogPage.start(primaryStage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@FXML
	void confirm(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		OrderPageController orderPage = new OrderPageController();
		orderPage.start(primaryStage);
	}

    @FXML
    void removeCustom(ActionEvent event) {

    }

    @FXML
    void removeRegular(ActionEvent event) {

    }
}