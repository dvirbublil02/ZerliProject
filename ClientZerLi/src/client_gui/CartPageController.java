package client_gui;

import java.net.URL;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import entities_catalog.Cart;
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
	private TableColumn<Cart, String> ItemNameColTbl;

	@FXML
	private TableColumn<Cart, Double> PriceColTbl;

	@FXML
	private TableColumn<Cart, ImageView> ImgColTbl;

	@FXML
	private TableColumn<Cart, Integer> QuantityColTbl;

	@FXML
	private Button backBtn;

	@FXML
	private Button confirmBtn;

	@FXML
	private Button removeBtn;

	@FXML
	private TableView<Cart> table;

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
		ItemNameColTbl.setCellValueFactory(new PropertyValueFactory<Cart, String>("Name"));
		PriceColTbl.setCellValueFactory(new PropertyValueFactory<Cart, Double>("Price"));
		ImgColTbl.setCellValueFactory(new PropertyValueFactory<Cart, ImageView>("ImgSrc"));
		QuantityColTbl.setCellValueFactory(new PropertyValueFactory<Cart, Integer>("Quantity"));

		Image image1 = new Image("/javafx_images/Catalog/Rose.png", 50, 200, true, true);
		ImageView imageView1 = new ImageView(image1);
		imageView1.setImage(image1);

	//	listView.add(new Cart("Rose Bouquet", imageView1, 22.55, 1));
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