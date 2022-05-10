package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import client.ClientHandleTransmission;
import entities_catalog.Product;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CatalogScreenController implements Initializable{

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
    private ComboBox<String> customProductComboBox;
    
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
    

    private String CURRENCY="¤";
    private Image imageCardTmp;
    private MyListenerCatalog myListener;
    private List<Product> itemInCatalog = new ArrayList<Product>();
    private ObservableList<String> customType ;
    private ObservableList<String> colorFilter ;
    private ObservableList<String> priceFilter ;
    private ObservableList<String> typeFilter ;
    
    
    
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
	
	
	
	// build list of item
	private List<Product> getDataItems()
	{
		List<Product> itemInCatalog = new ArrayList<>();
		Product item;
	
		item = new Product ("1","Rose Bouquet",25.55,"920000","/javafx_images/Catalog/Rose.png","53");
		itemInCatalog.add(item);
		
		item = new Product ("2","Cactus Flower",15.55,"526354","/javafx_images/Catalog/cactusflower.png","23");
		itemInCatalog.add(item);
		
		item = new Product ("3","Diamond Flower",23.55,"005063","/javafx_images/Catalog/diamondflower.png","89");
		itemInCatalog.add(item);
		
		item = new Product ("4","Violet Flower",18.55,"29174E","/javafx_images/Catalog/violetflower.png","50");
		itemInCatalog.add(item);
		
//		
//		item = new Product ("Spa Flower","/javafx_images/Catalog/spaflower.png",35.55,"A45814");
//		itemInCatalog.add(item);
//		
//		item = new Product ("Sun Flower","/javafx_images/Catalog/sunflower.png",45.55,"A07D10");
//		itemInCatalog.add(item);
//		
//		
//		item = new Product ("3Leaf clover","/javafx_images/Catalog/threeleafclover.png",38.55,"3E684E");
//		itemInCatalog.add(item);
//		
//		
//		item = new Product ("Violet Flower","/javafx_images/Catalog/violetflower.png",18.55,"29174E");
//		itemInCatalog.add(item);
		
		return itemInCatalog;
	}
	
	
	private void setChosenItemCard(Product item) {
		itemCardNameLable.setText(item.getName());
		itemCardPriceLable.setText(CURRENCY + item.getPrice());
		imageCardTmp =  new Image(getClass().getResourceAsStream(item.getImgSrc()));
		itemImageCard.setImage(imageCardTmp);
		ChosenItemCard.setStyle("-fx-background-color: #"+item.getbackGroundColor()+ "; -fx-background-radius: 30;" );
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		vboxAddToCustom.setVisible(false);

		//filter ComboBox section - color , price , type -- > check for release type here!! 
		colorFilter=FXCollections.observableArrayList("None","Black","Yellow","Red","Blue");
		itemColorComboBox.setItems(colorFilter);
		priceFilter=FXCollections.observableArrayList("None","10-100 ¤","100-200 ¤","200-500 ¤");
		itemPriceComboBox.setItems(priceFilter);
		typeFilter=FXCollections.observableArrayList("None","Flowers","Plant");
		itemTypeComboBox.setItems(typeFilter);
		
		//Progress bar state - 50%
		progressIndicator.setStyle("-fx-color: #D0F6DD ; -fx-accent: green;");
		progressIndicator.setProgress(0.50f);
		
		
		// custom product type ComboBox 
		customType=FXCollections.observableArrayList("Bouquet","Pot","Collection") ;
		customProductComboBox.setItems(customType);
		customProductComboBox.setValue("Bouquet");
		customProductComboBox.setDisable(true);
			
		
		// catalog item initialize
		itemInCatalog.addAll(getDataItems());
		
		if(itemInCatalog.size()>0)
		{
			setChosenItemCard(itemInCatalog.get(0));
			myListener = new MyListenerCatalog() {
				@Override
				public void onClickListener(Product item) {
					setChosenItemCard(item);
					
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
    		customProductComboBox.setDisable(false);
    		addToCustomBtn.setText("ADD TO BOUQUET");
    		vboxAddToCustom.setVisible(true);
    	}
    	else
    	{
    		customProductComboBox.setDisable(true);
    		vboxAddToCustom.setVisible(false);
    		//addToCartBtn.setText("ADD TO CART");
    	}
    }
	
	
    @FXML
    void customProductTypeChoice(ActionEvent  event) {
    	addToCustomBtn.setText("ADD TO "+ customProductComboBox.getValue().toUpperCase());
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

    @FXML
    void update(ActionEvent event) {

    }
    
    @FXML
    void clear(ActionEvent event) {
    	itemColorComboBox.setValue("None");
    	itemPriceComboBox.setValue("None");
    	itemTypeComboBox.setValue("None");
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

    }
    
    
    
    @FXML
    void quantityTextLableUpdate(ActionEvent event) {

    }
    
    

}