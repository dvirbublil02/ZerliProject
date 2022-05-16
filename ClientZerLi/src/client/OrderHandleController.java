package client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import entities_catalog.ProductInOrder;

public class OrderHandleController {
	
	//this table will handle only custom products.
	private static Map<String,List<ProductInOrder>> customProductInOrder=new HashMap<>();
	private static Map<String,List<ProductInOrder>> customProductInOrderFinallCart=new HashMap<>();
	private static List<ProductInOrder> productInOrder=new ArrayList<>();
	
	
	public static Map<String, List<ProductInOrder>> getCustomProductInOrderFinallCart() {
		return customProductInOrderFinallCart;
	}
	public static void setCustomProductInOrderFinallCart(String key, List<ProductInOrder> customProductInOrderFinallCart) {
		OrderHandleController.customProductInOrderFinallCart.put(key, customProductInOrderFinallCart);
	}
	
	public static Map<String, List<ProductInOrder>> getCustomProductInOrder() {
		return customProductInOrder;
	}
	public static void setCustomProductInOrder(Map<String, List<ProductInOrder>> customProductInOrder) {
		OrderHandleController.customProductInOrder = customProductInOrder;
	}
	public static List<ProductInOrder> getProductInOrder() {
		return productInOrder;
	}
	
	
	public static void setProductInOrder(ProductInOrder productInOrder) {
		OrderHandleController.productInOrder.add(productInOrder);
		//OrderHandleController.quantityOfRegularProducts += productInOrder.getProductQuantityInCart();
	}
	
	//to manage the custome item hashmap
	// add productInOrder to Custom product that exist. 
	public static void addToExistItemOnList(String key ,ProductInOrder productInOrder){
		List<ProductInOrder> productlist=customProductInOrder.get(key);
		if(productlist.contains(productInOrder)) {
			for(ProductInOrder i:productlist) {
				if(i.equals(productInOrder)) {
					i.setProductQuantityInCart(productInOrder.getProductQuantityInCart()+i.getProductQuantityInCart());
					customProductInOrder.get(key).remove(productInOrder);
					productInOrder.setProductQuantityInCart(i.getProductQuantityInCart());
					customProductInOrder.get(key).add(productInOrder);
					return;
				}
			}
		}else {
			customProductInOrder.get(key).add(productInOrder);
		}
		
	}
	
	//to manage the not custom item list
	//add to regualr item quntity to same one. 
	public static void addToExistItemOnListNotCustom(ProductInOrder productInOrder2) {
		
			for(int i=0;i<productInOrder.size();i++) {
				if(productInOrder.get(i).equals(productInOrder2)) {
				Double temp=productInOrder.get(i).getProductQuantityInCart()+productInOrder2.getProductQuantityInCart();
				productInOrder.get(i).setProductQuantityInCart(temp);
				
				// add to total quantity of regular item 
				//OrderHandleController.quantityOfRegularProducts+=productInOrder2.getProductQuantityInCart();
				return;
				}
			
		}
		
	}
	
	public static int getQuantityOfCustomProducts() {
		return customProductInOrder.size();
	}

	public static int getQuantityOfRegularProducts() {
		return productInOrder.size();
	}	
}
    