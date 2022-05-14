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
    private boolean firstTimeLoadAddtoCard=true;
    private static ProductInOrder productInOrder;
    
    /**
     * 
     * @param primaryStage main of catalog screen 
     * @throws Exception if there is problem with start of this stage
     */
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
	
	
	
	/** Get Products data information to preview on screen.
	 * 	Can bring Product with Filter or with them. 
	 * @param color filter of color (blue,green..)
	 * @param price filter of price (10 to 100 .. )
	 * @param type  filter of type (Product or Item)
	 * @return List of Product by this parameters
	 */
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
	
		
	
	/** initialize Screen and all Features to preview in start
	 *  Catalog Products , ComboBox of filters , setChosenItemCard on left side 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		//initialize setChosenItemCard
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
		
    	//Close Button until first chosen of Product
    	addToCartBtn.setDisable(true);
    	
    	//change Add to button to Add to (Text)
    	customTextField.textProperty().addListener((observable, oldValue, newValue) -> {
    	    //System.out.println("textfield changed from " + oldValue + " to " + newValue);
    	    addToCustomBtn.setText("ADD TO "+ customTextField.getText().toUpperCase());
    	});
		
		//Progress bar state - 50%
		progressIndicator.setStyle("-fx-color: #D0F6DD ; -fx-accent: green;");
		progressIndicator.setProgress(0.50f);
		
		// catalog item initialize
		InitilizeProductGrid("None","None","None");
		
	}

	
	/** Initialize Products Grid by filter or without.
	 * 	Grid of 3 Products in each line . 
	 * 
	 * @param color filter of color (blue,green..)
	 * @param price filter of price (10 to 100 .. )
	 * @param type  filter of type (Product or Item)
	 */
	private void InitilizeProductGrid(String color,String price,String type) {
		try {
			  itemInCatalog.addAll(getDataItems(color,price,type));
		}catch (NullPointerException e) {
				// here will be popup massage no products !!
		}
		
		if(itemInCatalog.size()>0)
		{
			Product p=new Product("0", "No Item Choosen", 0, "172D42", "/javafx_images/CustomOrderPicture.png", 0, "Product", "Blue", false, 0);
			//setChosenItemCard(itemInCatalog.get(0));
			setChosenItemCard(p);
			myListener = new MyListenerCatalog() {
				@Override
				public void onClickListener(Product item) {
					
					//open addToCart button first time 
					if(firstTimeLoadAddtoCard)
						addToCartBtn.setDisable(false);
					//load chosenCard and ProductInOrder that chosen
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

	
	/** Click On Radio Button on open the option for custom order.
	 * @param event click on Custom Button 
	 */
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
	
    
	/** This Back Button will bring us Back to previous screen 
	 * @param event back to previous screen .
	 * @throws Exception
	 */
    @FXML
    void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CustomerPageController customerPage = new CustomerPageController();
		customerPage.start(primaryStage);
    }

    /**
     * will be using in the future for searching .
     * @param event
     */
    @FXML
    void Search(ActionEvent event) {

    }

    /** Add to Cart the custom\regular product
     * 
     * @param event click on Add to cart button
     */
    @FXML
    void addToCart(ActionEvent event) {
    	Integer tmp= Integer.parseInt(cartItemCounter.getText())+1;
    	cartItemCounter.setText(tmp.toString());
    	if(!customClickRadioBtn.isSelected()) {
    		productInOrder.setProductQuantityInCart(Double.parseDouble(quantityTextLable.getText()));
    		if(OrderHandleController.getProductInOrder().contains(productInOrder)) {
    			OrderHandleController.addToExistItemOnListNotCustom(productInOrder);
    		}
    		else {
    			OrderHandleController.getProductInOrder().add(productInOrder);
    			}    	
    	}
    	else {
    		List<ProductInOrder> moveToCart=new ArrayList<>();
    		moveToCart=OrderHandleController.getCustomProductInOrder().get(customTextField.getText().toUpperCase());
    		OrderHandleController.setCustomProductInOrderFinallCart(customTextField.getText().toUpperCase(),moveToCart);
    		System.out.println(OrderHandleController.getCustomProductInOrderFinallCart().toString());
    		
    		//clear custom selection
    		vboxAddToCustom.setVisible(false);
    		customTextField.setText("");
    		customTextField.setDisable(true);
    		customClickRadioBtn.setSelected(false);
    	}
    	
    }

    
    /** click on minus button to decrease product quantity value
     * 
     * @param event click on minus button
     */
    @FXML
    void minusBtnClick(ActionEvent event) {
    	int quantityValue=Integer.valueOf(quantityTextLable.getText());
    	
    	if(quantityValue!=0)
    	{
    		quantityValue-=1;
    		quantityTextLable.setText(Integer.toString(quantityValue));
    	}
    }

    
    /** click on minus button to increase product quantity value
     * 
     * @param event click on minus button
     */
    @FXML
    void pluseBtnClick(ActionEvent event) {
    	int quantityValue=Integer.valueOf(quantityTextLable.getText());
    	
    	if(quantityValue!=100)
    	{
    		quantityValue+=1;
    		quantityTextLable.setText(Integer.toString(quantityValue));
    	}
    }

    
    /** Update products on catalog by filter that collected or without him  
     * 
     * @param event update the products on catalog 
     */
    @FXML
    void update(ActionEvent event) {
    	ObservableList<Node> productCards = grid.getChildren();
    	productCards.clear();
    	itemInCatalog.clear();
    	InitilizeProductGrid(itemColorComboBox.getValue(),itemPriceComboBox.getValue(),itemTypeComboBox.getValue());  	
    }
    
    /**	Clear and Update screen to all Products in Network
     * 
     * @param event clear previous and load all Product
     */
    @FXML
    void clear(ActionEvent event) {
    	itemColorComboBox.setValue("None");
    	itemPriceComboBox.setValue("None");
    	itemTypeComboBox.setValue("None");
    	update(event);
    }
    
   
    /** Open Cart Page screen with all Products preview.
     * 
     * @param event click on cart will open here .
     * @throws Exception  when page will not bring well.
     */
    @FXML
    void cartPageMove(MouseEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding window
		Stage primaryStage = new Stage();
		CartPageController cartPage = new CartPageController();
		cartPage.start(primaryStage);
		
    }
    
    /** Add product to dynamic Map the store all custom products.
     * 	Only when user will add the custom product to cart it will move the relevant one to the cart Map.
     * @param event add products to custom product .
     */
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
    
    
}