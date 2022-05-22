package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Set;

import client.ClientHandleTransmission;
import client.OrderHandleController;
import entities_catalog.Cart;
import entities_catalog.ProductInOrder;
import entities_general.Order;
import entities_general.OrderCartPreview;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class CartPageController implements Initializable {

	
	
	
    // IDorder / (nameOfProdcut) zerli dvir / (nameOfItem) rose bouget /
    // IDorder / regular / rose / 
	// OrderCustomCartPreview - > Image , Name , Quantity , Description 
	
    @FXML
    private TableColumn<OrderCartPreview, ImageView> ImgColRegularTbl;

    @FXML
    private TableColumn<OrderCustomCartPreview, ImageView> ImgCustomColTbl;

    @FXML
    private TableColumn<OrderCartPreview, String> ItemNameColRegularTbl;

    @FXML
    private TableColumn<OrderCustomCartPreview, String> ItemNameCustomColTbl;

    @FXML
    private TableColumn<OrderCartPreview, Double> QuantityColRegularTbl;

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
    private Label massageLabel;
    
    @FXML
    private Label massageLabelRegular;
    
    @FXML
    private Label priceLabel;

    @FXML
    private TableColumn<OrderCustomCartPreview, Button> showCustomTbl;

    @FXML
    private TableView<OrderCustomCartPreview> tableCustom;

    @FXML
    private TableView<OrderCartPreview> tableRegular;

    @FXML
    private TableColumn<OrderCartPreview, Double> priceColRegularTbl;

    @FXML
    private TableColumn<OrderCustomCartPreview, Double> priceCustomColTbl;
    
	private ObservableList<OrderCustomCartPreview> listViewCustom = FXCollections.observableArrayList();
	private ObservableList<OrderCartPreview> listViewRegular = FXCollections.observableArrayList();

	//Cart is the publisher , orderHandelController is the subscriber
	private List<OrderHandleController> subscribers = new ArrayList<>();

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
		
		
		//Cart Table Initialize custom
		ImgCustomColTbl.setCellValueFactory(new PropertyValueFactory<OrderCustomCartPreview, ImageView>("imgSrc"));
		ItemNameCustomColTbl.setCellValueFactory(new PropertyValueFactory<OrderCustomCartPreview, String>("name"));
		QuantityCustomColTbl.setCellValueFactory(new PropertyValueFactory<OrderCustomCartPreview, Integer>("quantity"));
		priceCustomColTbl.setCellValueFactory(new PropertyValueFactory<OrderCustomCartPreview, Double>("totalprice"));
		//Cart Table Initialize regular
		ImgColRegularTbl.setCellValueFactory(new PropertyValueFactory<OrderCartPreview, ImageView>("imgSrc"));
		ItemNameColRegularTbl.setCellValueFactory(new PropertyValueFactory<OrderCartPreview, String>("name"));
		QuantityColRegularTbl.setCellValueFactory(new PropertyValueFactory<OrderCartPreview, Double>("quantity"));
		priceColRegularTbl.setCellValueFactory(new PropertyValueFactory<OrderCartPreview, Double>("price"));
		
		
		//add all Custom product to screen 
		Map<String,List<ProductInOrder>> customProductInOrderFinallCart = OrderHandleController.getCustomProductInOrderFinallCart();
		for(String customName : customProductInOrderFinallCart.keySet())
		{
			Image image1 = new Image("/javafx_images/CustomOrderPicture.png", 60, 60, true, true);
			ImageView imageView1 = new ImageView(image1);
			imageView1.setImage(image1);
			listViewCustom.add(new OrderCustomCartPreview(imageView1,customName, 1, 0, customProductInOrderFinallCart.get(customName)));
		}
				
		//add all regular product to regular list
		for(ProductInOrder p : OrderHandleController.getProductInOrder())
		{
			Image image1 = new Image(p.getImgSrc(), 60, 60, true, true);
			ImageView imageView1 = new ImageView(image1);
			imageView1.setImage(image1);
			listViewRegular.add(new OrderCartPreview(imageView1, p.getName(),(int)p.getProductQuantityInCart(),p.getPrice() ,p));
		}
		
		//set tables to show products 
		tableRegular.setItems(listViewRegular);
		tableCustom.setItems(listViewCustom);
		priceLabel.setText(OrderHandleController.getTotalPrice()+"");
		
		//add listener to OrderHandleController to perform remove on background
		addSubscriber(new OrderHandleController());
	}
	
	
	@FXML
	void back(ActionEvent event) {
		
		// remove all listener in background 
		removeSubscribers();
		
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
    	ObservableList<OrderCustomCartPreview> productSelected , allProducts;
		allProducts=tableCustom.getItems();
		productSelected=tableCustom.getSelectionModel().getSelectedItems();
		
		System.out.println("productSelected regular->"+productSelected);
		
		if(allProducts.isEmpty())
			massageLabel.setText("Cart Allready Empty");
		try {
			
			
			//remove all custom product in orderHandler
			notifyRemoveCustomProduct(productSelected);
		
			//remove preview on screen
			productSelected.forEach(allProducts::remove);
			System.out.println("productSelected regular->"+productSelected);
			
		} catch (NoSuchElementException e) {
			massageLabel.setText("Cart empty!!");
		}
    }
    
 
    @FXML
    void removeRegular(ActionEvent event) {
    	ObservableList<OrderCartPreview> productSelected , allProducts;
		allProducts=tableRegular.getItems();
		productSelected=tableRegular.getSelectionModel().getSelectedItems();
		
		System.out.println("productSelected regular->"+productSelected);
		
		if(allProducts.isEmpty())
			massageLabelRegular.setText("Cart Allready Empty");
		try {
			
			//remove all regular productInOrder in orderHandler
			notifyRemoveRegularProductInOrder(productSelected);
			
			//remove preview on screen
			productSelected.forEach(allProducts::remove);
			System.out.println("productSelected regular->"+productSelected);

		} catch (NoSuchElementException e) {
			massageLabelRegular.setText("Cart empty!!");
		}
    }
    
    
    // add Subscriber
	public void addSubscriber(OrderHandleController s) {
		subscribers.add(s);
	}
	
	// remove Subscriber
	public void removeSubscribers() {
		subscribers.clear();
	
	}
	
	// notify all subscribers to remove productSelected list from there local list
	public void notifyRemoveRegularProductInOrder(ObservableList<OrderCartPreview> productSelected) {
		for( OrderHandleController s : subscribers)
			s.removeFromOrderRegular(productSelected);
	}
	
	// notify all subscribers to remove productSelected list from there local hashMap
	public void notifyRemoveCustomProduct(ObservableList<OrderCustomCartPreview> productSelected) {
		for( OrderHandleController s : subscribers)
			s.removeFromOrderCustom(productSelected);
	}
    
}