package client_gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import entities_catalog.Cart;
import entities_catalog.ProductInOrder;
import entities_general.Order;
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

    @FXML
    private TableColumn<Cart,List<ProductInOrder>> DescriptionColTbl;

    @FXML
    private TableColumn<Cart,ImageView> ImgColTbl;

    @FXML
    private TableColumn<Cart, String> ItemNameColTbl;

    @FXML
    private TableColumn<Cart, Integer> QuantityColTbl;
    
    @FXML
    private TableView<Cart> table;

    @FXML
    private TableColumn<Cart, Double> totalPriceColTbl;

    @FXML
    private TableColumn<ProductInOrder, String> nameProductInOrderColTbl;

    @FXML
    private TableColumn<ProductInOrder, Double> priceProductInOrderColTbl;

    @FXML
    private TableColumn<ProductInOrder, Integer> quantityProducInOrderColTbl;
    
    @FXML
    private Button backBtn;

    @FXML
    private Button confirmBtn;

    @FXML
    private Button removeBtn;


	ObservableList<Cart> listView = FXCollections.observableArrayList();

	

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

	@FXML
	void back(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//cart
		ImgColTbl.setCellValueFactory(new PropertyValueFactory<Cart, ImageView>("ImgSrc"));
		ItemNameColTbl.setCellValueFactory(new PropertyValueFactory<Cart, String>("Name"));
		DescriptionColTbl.setCellValueFactory(new PropertyValueFactory<Cart,List<ProductInOrder>>("Description"));
		QuantityColTbl.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("Quantity"));
		totalPriceColTbl.setCellValueFactory(new PropertyValueFactory<Cart, Double>("Price"));
		//productInOrder
		nameProductInOrderColTbl.setCellValueFactory(new PropertyValueFactory<ProductInOrder, String>("name"));
		priceProductInOrderColTbl.setCellValueFactory(new PropertyValueFactory<ProductInOrder, Double>("price"));
		quantityProducInOrderColTbl.setCellValueFactory(new PropertyValueFactory<ProductInOrder,Integer>("productQuantityInCart"));
		
		Image image1 = new Image("/javafx_images/Catalog/Rose.png", 50, 200, true, true);
		ImageView imageView1 = new ImageView(image1);
		imageView1.setImage(image1);

		//listView.add(new Cart("Rose Bouquet", imageView1, 22.55, 1));
		
		
		ProductInOrder p = new ProductInOrder("1","Rose Bouquet",25.55, "920000","/javafx_images/Catalog/Rose.png", 53, "Product", "Red","5", 5.0, false, 0);
		ObservableList<ProductInOrder>products=FXCollections.observableArrayList(p);
		listView.addAll(new Cart("Almog Zerli", imageView1,85.0, 1.0, products,"hello"));
		table.setItems(listView);

	}

	@FXML
	void confirm(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		OrderPageController orderPage = new OrderPageController();
		orderPage.start(primaryStage);
	}

	@FXML
	void remove(ActionEvent event) {

	}
}