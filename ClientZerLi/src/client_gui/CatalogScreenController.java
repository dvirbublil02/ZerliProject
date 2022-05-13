package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;


import client.OrderHandleController;

import client.ClientUI;
import communication.Mission;
import communication.TransmissionPack;


import client.ClientUI;
import communication.Mission;
import communication.TransmissionPack;

import entities_catalog.Product;
import entities_catalog.ProductInOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CatalogScreenController implements Initializable{

    private static final String Stage = null;

	@FXML
    private VBox ChosenItemCard;

    @FXML
    private Button addToCartBtn;

    @FXML
    private Button backBtn;

    @FXML
    private GridPane grid;

    @FXML
    private Label itemCardNameLable;

    @FXML
    private Label itemCardPriceLable;

    @FXML
    private ComboBox<String> itemColorComboBox;

    @FXML
    private ImageView itemImageCard;
    
    @FXML
    private ImageView cartPageImage;

    @FXML
    private ComboBox<String> itemPriceComboBox;

    @FXML
    private ComboBox<String> itemTypeComboBox;

    @FXML
    private Button minusBtn;

    @FXML
    private Button pluseBtn;

    @FXML
    private TextField quantityTextLable;

    @FXML
    private Button searchBtn;
    
    @FXML
    private ProgressIndicator progressIndicator;
    

    @FXML
    private RadioButton customClickRadioBtn;
    
    @FXML
    private Label cartItemCounter;
    
    @FXML
    private Button updateBtn;
    
    @FXML
    private Button clearBtn;
    
    @FXML
    private HBox vboxAddToCustom;
    
    @FXML
    private Button addToCustomBtn;
    @FXML
    private TextField customTextField;
   

    private String CURRENCY="₪";
    private Image imageCardTmp;
    private MyListenerCatalog myListener;
    private List<Product> itemInCatalog = new ArrayList<Product>();
    private ObservableList<String> customType ;
    private ObservableList<String> colorFilter ;
    private ObservableList<String> priceFilter ;
    private ObservableList<String> typeFilter ;
   
    private static ProductInOrder productInOrder;
    
	public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/CatalogScreen.fxml"));
				
		Scene scene = new Scene(root);
	
		primaryStage.setTitle("ZerLi Catalog");
		primaryStage.setScene(scene);
		primaryStage.show();	
		primaryStage.setOnCloseRequest(event ->{
			ClientHandleTransmission.DISCONNECT_FROM_SERVER();
			});	
	}
	
	
	
	// build list of item regular or by filter
	private List<Product> getDataItems(String color , String price , String type)
	{
		if( color.equals("None") && price.equals("None") && type.equals("None"))
			return ClientHandleTransmission.getDataProduct();
		
		return ClientHandleTransmission.getDataProductByFilter(color,price,type);
	}
		
	
	private void setChosenItemCard(Product item) {
		itemCardNameLable.setText(item.getName());
		itemCardPriceLable.setText(CURRENCY + item.getPrice());
		imageCardTmp =  new Image(getClass().getResourceAsStream(item.getImgSrc()));
		itemImageCard.setImage(imageCardTmp);
		ChosenItemCard.setStyle("-fx-background-color: #"+item.getbackGroundColor()+ "; -fx-background-radius: 30;" );
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		vboxAddToCustom.setVisible(false);


		customTextField.setDisable(true);

		


		//filter ComboBox section - color , price , type 
		colorFilter=FXCollections.observableArrayList("None");
		colorFilter.addAll(ClientHandleTransmission.getColorsForFilter());
		itemColorComboBox.setItems(colorFilter);
		itemColorComboBox.setValue("None");
		priceFilter=FXCollections.observableArrayList("None","10-100₪","100-200₪","200-500₪");
		itemPriceComboBox.setItems(priceFilter);
    	itemPriceComboBox.setValue("None");
		typeFilter=FXCollections.observableArrayList("None","Product","Item");
		itemTypeComboBox.setItems(typeFilter);
    	itemTypeComboBox.setValue("None");
		
		
		//Progress bar state - 50%
		progressIndicator.setStyle("-fx-color: #D0F6DD ; -fx-accent: green;");
		progressIndicator.setProgress(0.50f);
		
		
		
			
		// catalog item initialize
		InitilizeProductGrid("None","None","None");
		
	}





	
	// grid dynamic 
	private void InitilizeProductGrid(String color,String price,String type) {
		try {
			  itemInCatalog.addAll(getDataItems(color,price,type));
		}catch (NullPointerException e) {
				// here will be popup massage no products !!
		}
		
		if(itemInCatalog.size()>0)
		{
			setChosenItemCard(itemInCatalog.get(0));
			myListener = new MyListenerCatalog() {
				@Override
				public void onClickListener(Product item) {
					setChosenItemCard(item);
					 productInOrder=new ProductInOrder(item.getID(),
							 item.getName(),item.getPrice(),
							 item.getbackGroundColor(),item.getImgSrc(),
							 item.getQuantity(),item.getItemType(),item.getDominateColor(),
			    			null,Double.parseDouble(quantityTextLable.getText()),item.getIsOnSale(),item.getFixPrice());
				}
			};
			
		}
		
		
		int col  = 0;
		int row = 1;
		try {
			for(int i=0;i<itemInCatalog.size();i++) {
				FXMLLoader fxmlLoder=new FXMLLoader();
				fxmlLoder.setLocation(getClass().getResource("/client_gui/ItemInCatalog.fxml"));
				AnchorPane anchorPane = fxmlLoder.load();			
				ItemInCatalogController itemInCatalogController = fxmlLoder.getController();
				itemInCatalogController.setDataItem(itemInCatalog.get(i),myListener);
				
				
				
				if(col == 3) {                     // Position 3x3
					col=0;
					row++;
				}
				grid.add(anchorPane,col++,row);   // matrix (child , column , row);
				
				//set item grid width
				grid.setMinWidth(Region.USE_COMPUTED_SIZE);
				grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
				grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
				
				//set item grid height
				grid.setMinHeight(Region.USE_COMPUTED_SIZE);
				grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
				grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
				
				GridPane.setMargin(anchorPane, new Insets(10));    // topRightBottomLeft

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
    @FXML
    void customClickRadio(ActionEvent event) {
    	if(customClickRadioBtn.isSelected()==true) 
    	{
    		customTextField.setDisable(false);
    		addToCustomBtn.setVisible(true);
    		addToCustomBtn.setText("ADD TO ...");
    		vboxAddToCustom.setVisible(true);
    		
    	}
    	else
    	{
    		customTextField.setDisable(true);
    		vboxAddToCustom.setVisible(false);
    		addToCustomBtn.setVisible(false);
    		
    	}
    }
	
	

    
    @FXML
    void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CustomerPageController customerPage = new CustomerPageController();
		customerPage.start(primaryStage);
    }

    @FXML
    void Search(ActionEvent event) {

    }

    @FXML
    void addToCart(ActionEvent event) {
    	Integer tmp= Integer.parseInt(cartItemCounter.getText())+1;
    	cartItemCounter.setText(tmp.toString());
    	if(!customClickRadioBtn.isSelected()) {
    	productInOrder.setProductQuantityInCart(Double.parseDouble(quantityTextLable.getText()));
    	if(OrderHandleController.getProductInOrder().contains(productInOrder)) {
    		OrderHandleController.addToExistItemOnListNotCustom(productInOrder);
    		
    	}else {
    		
    		OrderHandleController.getProductInOrder().add(productInOrder);
    	}
    	}
    	else {
    		List<ProductInOrder> moveToCart=new ArrayList<>();
    		moveToCart=OrderHandleController.getCustomProductInOrder().get(customTextField.getText().toUpperCase());
    		OrderHandleController.setCustomProductInOrderFinallCart(customTextField.getText().toUpperCase(),moveToCart);
    		System.out.println(OrderHandleController.getCustomProductInOrderFinallCart().toString());
    	}
    	
    	
    }

    @FXML
    void minusBtnClick(ActionEvent event) {
    	int quantityValue=Integer.valueOf(quantityTextLable.getText());
    	
    	if(quantityValue!=0)
    	{
    		quantityValue-=1;
    		quantityTextLable.setText(Integer.toString(quantityValue));
    	}
    }

    @FXML
    void pluseBtnClick(ActionEvent event) {
    	int quantityValue=Integer.valueOf(quantityTextLable.getText());
    	
    	if(quantityValue!=100)
    	{
    		quantityValue+=1;
    		quantityTextLable.setText(Integer.toString(quantityValue));
    	}
    }

    
    // update screen release all productCards 
    @FXML
    void update(ActionEvent event) {
    	ObservableList<Node> productCards = grid.getChildren();
    	productCards.clear();
    	itemInCatalog.clear();
    	InitilizeProductGrid(itemColorComboBox.getValue(),itemPriceComboBox.getValue(),itemTypeComboBox.getValue());  	
    }
    
    
    //clear and update screen
    @FXML
    void clear(ActionEvent event) {
    	itemColorComboBox.setValue("None");
    	itemPriceComboBox.setValue("None");
    	itemTypeComboBox.setValue("None");
    	update(event);
    }
    
   
    @FXML
    void cartPageMove(MouseEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CartPageController cartPage = new CartPageController();
		cartPage.start(primaryStage);
    }
    
    @FXML
    void addToCustom(ActionEvent event) {
    	productInOrder.setProductQuantityInCart(Double.parseDouble(quantityTextLable.getText()));
    	if(OrderHandleController.getCustomProductInOrder().containsKey(customTextField.getText().toUpperCase())) {
    		OrderHandleController.addToExistItemOnList(customTextField.getText().toUpperCase(),productInOrder);
    		
    	}else {
    		List<ProductInOrder> productInOrderList=new ArrayList<>();
    		productInOrderList.add(productInOrder);
    		OrderHandleController.getCustomProductInOrder().put(customTextField.getText().toUpperCase(), productInOrderList);
    	}
    	
    }
    
    
    
    @FXML
    void quantityTextLableUpdate(ActionEvent event) {

    }
    //fix this action
    @FXML
    void customField(ActionEvent event) {
    	addToCustomBtn.setText("ADD TO "+ customTextField.getText().toUpperCase());
    	
    }

  

}