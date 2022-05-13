package client_gui;

import client.OrderHandleController;
import entities_catalog.Product;
import entities_catalog.ProductInOrder;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemInCatalogController {

    @FXML
    private ImageView itemImageScrollArea;

    @FXML
    private Label itemNameScrollArea;

    @FXML
    private Label itemPriceScrollArea;
      
    private Product item;
    private String CURRENCY="₪";
    private MyListenerCatalog myListener; 
   
    @FXML
    private void clickItem(MouseEvent mouseEvent) {
    	myListener.onClickListener(item);	
    
    }
    
    
    public void setDataItem(Product tmpItem , MyListenerCatalog tmpMyListner) {
    	item=tmpItem;
    	myListener=tmpMyListner;
    	itemNameScrollArea.setText(item.getName());
    	itemPriceScrollArea.setText(CURRENCY+item.getPrice());
    	Image image =  new Image(getClass().getResourceAsStream(item.getImgSrc()));
    	itemImageScrollArea.setImage(image);
    }

}
