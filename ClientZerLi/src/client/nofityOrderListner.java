package client;

import entities_catalog.ProductInOrder;
import entities_general.OrderCartPreview;
import entities_general.OrderCustomCartPreview;
import javafx.collections.ObservableList;

public interface nofityOrderListner {
	public void removeFromOrderCustom (ObservableList<OrderCustomCartPreview> productSelected);
	public void removeFromOrderRegular (ObservableList<OrderCartPreview> productSelected);
	public void removeProductInOrderInsideCustom (ObservableList<ProductInOrder> productSelected,String customName);
}