package client_gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities_catalog.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CatalogScreenCustomController implements Initializable{

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
    private ComboBox<?> itemColorComboBox;

    @FXML
    private ImageView itemImageCard;

    @FXML
    private ComboBox<?> itemPriceComboBox;

    @FXML
    private ComboBox<?> itemTypeComboBox;

    @FXML
    private Button minusBtn;

    @FXML
    private Button pluseBtn;

    @FXML
    private TextField quantityTextLable;

    @FXML
    private Button searchBtn;

    @FXML
    private TextField searchLabel;
    private String CURRENCY="¤";
    private Image imageCardTmp;
    private MyListenerCatalog myListener;
    
    
    
    private List<Product> itemInCatalog = new ArrayList<Product>();

    
	public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/client_gui/CatalogScreenCustom.fxml"));
				
		Scene scene = new Scene(root);
	
		primaryStage.setTitle("ZerLi Custom Catalog");
		primaryStage.setScene(scene);
		
		primaryStage.show();		
	}
	
	
	
	// build list of item
	private List<Product> getDataItems()
	{
		List<Product> itemInCatalog = new ArrayList<>();
		Product item;
		
		item = new Product ("1","Rose Bouquet",25.55,"920000","/javafx_images/Catalog/Rose.png");
		itemInCatalog.add(item);
		
		item = new Product ("2","Cactus Flower",15.55,"526354","/javafx_images/Catalog/cactusflower.png");
		itemInCatalog.add(item);
		
//		item = new Product ("Diamond Flower","/javafx_images/Catalog/diamondflower.png",23.55,"005063");
//		itemInCatalog.add(item);
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
    void Back(ActionEvent event) {

    }

    @FXML
    void Search(ActionEvent event) {

    }

    @FXML
    void addToCart(ActionEvent event) {

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
    void quantityTextLableUpdate(ActionEvent event) {

    }

}