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
	public static int quantityOfRegularProducts=0;
	public static int quantityOfCustomProducts=0;
	private static double totalPrice=0;
	
	
	public static Map<String, List<ProductInOrder>> getCustomProductInOrderFinallCart() {
		return customProductInOrderFinallCart;
	}
	public static void addCustomProductInOrderFinallCart(String key, List<ProductInOrder> customProductInOrderFinallCart) {
		OrderHandleController.customProductInOrderFinallCart.put(key, customProductInOrderFinallCart);
	}
	
	public static Map<String, List<ProductInOrder>> getCustomProductInOrder() {
		return customProductInOrder;
	}
	
	public static void setCustomProductInOrder(Map<String, List<ProductInOrder>> customProductInOrder) {
		OrderHandleController.customProductInOrder = customProductInOrder;
	}
	
	public static void addCustomProductInOrder(String key ,List<ProductInOrder> productInOrderList) {
		OrderHandleController.customProductInOrder.put(key, productInOrderList);
		int price=0 ;
		for(ProductInOrder p: productInOrderList)
			price+=p.getProductQuantityInCart()*p.getPrice();
		OrderHandleController.totalPrice+=price;
	}
	
	
	public static List<ProductInOrder> getProductInOrder() {
		return productInOrder;
	}
	
	public static void addProductInOrder(ProductInOrder productInOrder) {
		OrderHandleController.productInOrder.add(productInOrder);
		//OrderHandleController.quantityOfRegularProducts += productInOrder.getProductQuantityInCart();
		OrderHandleController.totalPrice+=productInOrder.getProductQuantityInCart()*productInOrder.getPrice();
	}
		
	//to manage the custom item hashmap
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
		
		//price calculate to custom 
		OrderHandleController.totalPrice+=productInOrder.getProductQuantityInCart()*productInOrder.getPrice();
	}
	
	//to manage the not custom item list
	//add to regualr item quntity to same one. 
	public static void addToExistItemOnListNotCustom(ProductInOrder productInOrder2) {
		
			for(int i=0;i<productInOrder.size();i++) {
	
				if(productInOrder.get(i).equals(productInOrder2)) {
					System.out.println("List-Regualr->"+productInOrder);
				
					System.out.println("inside->order2" + productInOrder2.getProductQuantityInCart());
					System.out.println("inside->order1" + productInOrder.get(i).getProductQuantityInCart());
					
					Double totalQuntity=productInOrder.get(i).getProductQuantityInCart()+productInOrder2.getProductQuantityInCart();
					productInOrder.get(i).setProductQuantityInCart(totalQuntity);
					//price calculate to custom 
				
					System.out.println("quantityTotal"+totalQuntity);
				
					OrderHandleController.totalPrice+=productInOrder2.getProductQuantityInCart()*productInOrder2.getPrice();
				return;
				}
			
		}
		
	}
	
	public static int getQuantityOfCustomProducts() {
		return quantityOfCustomProducts;
	}

	public static int getQuantityOfRegularProducts() {
		return quantityOfRegularProducts;
	}
	
	public static double getTotalPrice() {
		return totalPrice;
	}
	
	public static void setTotalPrice(double totalPrice) {
		OrderHandleController.totalPrice = totalPrice;
	}
	
	
}
    