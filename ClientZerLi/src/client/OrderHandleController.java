package client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import entities_catalog.ProductInBranch;
import entities_catalog.ProductInOrder;
import entities_general.OrderCartPreview;
import entities_general.OrderCustomCartPreview;
import entities_general.OrderPreview;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class OrderHandleController implements nofityOrderListner {

	// this table will handle only custom products.
	private static Map<String, List<ProductInOrder>> customProductInOrder = new HashMap<>();
	private static Map<String, List<ProductInOrder>> customProductInOrderFinallCart = new HashMap<>();
	private static List<ProductInOrder> productInOrder = new ArrayList<>();
	public static int quantityOfRegularProducts = 0;
	public static int quantityOfCustomProducts = 0;
	private static double totalPrice = 0;
	private static Label priceLabel = new Label("0");
	private static boolean detailsAllreadyOpen = false;
	
	//get product in branch view
	private static List<ProductInBranch> productInBranch = new ArrayList<ProductInBranch>();
	//map to view quantity chosen by customer-> <ProductID,quantity>
	//String nameProdcut(key) , List<Integer>=[productID,quantity]
	private static Map<String,List<Integer>> quntityImageInBranch =  new HashMap<String, List<Integer>>();
	//set to view product with problematic bigger quantity -> <ProductID>
	private static Set<String> problemticProducts = new HashSet<>();
	//Massage note to user if there is problem with quantity.
	private static String msg ;
	
	private static List<OrderPreview> ordersForBranchManager = new ArrayList<>();
	private static OrderPreview order;

	public static OrderPreview getOrder() {
		return order;
	}

	public static void setOrder(OrderPreview order) {
		OrderHandleController.order = order;
	}

	public static List<OrderPreview> getOrdersForBranchManager() {
		return ordersForBranchManager;
	}

	public static void setOrdersForBranchManager(List<OrderPreview> ordersForBranchManager) {
		OrderHandleController.ordersForBranchManager = ordersForBranchManager;
	}

	public static Map<String, List<ProductInOrder>> getCustomProductInOrderFinallCart() {
		return customProductInOrderFinallCart;
	}

	public static void addCustomProductInOrderFinallCart(String key,
			List<ProductInOrder> customProductInOrderFinallCart) {
		OrderHandleController.customProductInOrderFinallCart.put(key, customProductInOrderFinallCart);
	}

	public static Map<String, List<ProductInOrder>> getCustomProductInOrder() {
		return customProductInOrder;
	}

	public static void setCustomProductInOrder(Map<String, List<ProductInOrder>> customProductInOrder) {
		OrderHandleController.customProductInOrder = customProductInOrder;
	}

	public static void addCustomProductInOrder(String key, List<ProductInOrder> productInOrderList) {
		OrderHandleController.customProductInOrder.put(key, productInOrderList);
		int price = 0;
		for (ProductInOrder p : productInOrderList)
			price += (double) p.getProductQuantityInCart() * p.getPrice();
		OrderHandleController.totalPrice += price;
		priceLabel.setText(String.valueOf(totalPrice));
	}

	public static List<ProductInOrder> getProductInOrder() {
		return productInOrder;
	}

	public static void addProductInOrder(ProductInOrder productInOrder) {
		OrderHandleController.productInOrder.add(productInOrder);
		OrderHandleController.totalPrice += (double) productInOrder.getProductQuantityInCart()
				* productInOrder.getPrice();
		priceLabel.setText(String.valueOf(totalPrice));
	}

	// to manage the custom item hashmap
	// add productInOrder to Custom product that exist.
	public static void addToExistItemOnList(String key, ProductInOrder productInOrder) {
		List<ProductInOrder> productlist = customProductInOrder.get(key);
		if (productlist.contains(productInOrder)) {
			for (ProductInOrder i : productlist) {
				if (i.equals(productInOrder)) {
					i.setProductQuantityInCart(
							productInOrder.getProductQuantityInCart() + i.getProductQuantityInCart());
					customProductInOrder.get(key).remove(productInOrder);
					productInOrder.setProductQuantityInCart(i.getProductQuantityInCart());
					customProductInOrder.get(key).add(productInOrder);
					return;
				}
			}
		} else {
			customProductInOrder.get(key).add(productInOrder);
		}

		// price calculate to custom
		OrderHandleController.totalPrice += (double) productInOrder.getProductQuantityInCart()
				* productInOrder.getPrice();
		priceLabel.setText(String.valueOf(totalPrice));
	}

	// to manage the not custom item list
	// add to regular item quantity to same one.
	public static void addToExistItemOnListNotCustom(ProductInOrder productInOrder2) {

		for (int i = 0; i < productInOrder.size(); i++) {

			if (productInOrder.get(i).equals(productInOrder2)) {

				System.out.println("List-Regualr->" + productInOrder);

				System.out.println("inside->order2" + productInOrder2.getProductQuantityInCart());
				System.out.println("inside->order1" + productInOrder.get(i).getProductQuantityInCart());

				int totalQuntity = productInOrder.get(i).getProductQuantityInCart()
						+ productInOrder2.getProductQuantityInCart();
				productInOrder.get(i).setProductQuantityInCart(totalQuntity);
				// price calculate to custom

				System.out.println("quantityTotal" + totalQuntity);

				OrderHandleController.totalPrice += (double) productInOrder2.getProductQuantityInCart()
						* productInOrder2.getPrice();
				priceLabel.setText(String.valueOf(totalPrice));
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

	public static Label getPriceLabel() {
		return priceLabel;
	}

	public static void setPriceLabel(Label priceLabel) {
		OrderHandleController.priceLabel = priceLabel;
	}

	public static int getCartCounter() {
		return quantityOfRegularProducts + quantityOfCustomProducts;
	}

	// remove Custom product on the screen , need to remove on the back side also.
	@Override
	public void removeFromOrderCustom(ObservableList<OrderCustomCartPreview> productSelected) {
		// TODO Auto-generated method stub

		for (OrderCustomCartPreview ocp : productSelected) {
			totalPrice -= ocp.getTotalprice();
			customProductInOrderFinallCart.remove(ocp.getName());
			quantityOfCustomProducts--;
		}

		System.out.println("remove listner custom hashmap->" + customProductInOrderFinallCart);

	}

	// remove regular product on the screen , need to remove on the back side also.
	@Override
	public void removeFromOrderRegular(ObservableList<OrderCartPreview> productSelected) {
		// TODO Auto-generated method stub
		for (OrderCartPreview ocp : productSelected) {
			for (ProductInOrder pd : productInOrder) {
				System.out.println(pd.getName());
				System.out.println(ocp.getName());

				if (pd.getName().equals(ocp.getName())) {

					System.out.println("here!!");
					totalPrice -= ocp.getPrice() * ocp.getQuantity();
					productInOrder.remove(pd);
					quantityOfRegularProducts-=ocp.getQuantity();
					break;
				}

			}
		}

		System.out.println("remove listner regular list->" + productInOrder);
	}

	// remove productInOrder inside custom product on screen ,need to remove on the
	// back side also.
	@Override
	public void removeProductInOrderInsideCustom(ObservableList<ProductInOrder> productSelected, String customName) {
		// TODO Auto-generated method stub
		List<ProductInOrder> customProducts = customProductInOrderFinallCart.get(customName);
		List<ProductInOrder> productSelectedRegualrList = new ArrayList<ProductInOrder>();
		// change from ObservableList to List
		productSelectedRegualrList.addAll(productSelected);
		// remove on the back side it productInOrder inside custom
		customProducts.removeAll(productSelectedRegualrList);

		// if we remove the last one in custom product
		if (customProducts.size() == 0) {
			customProductInOrderFinallCart.remove(customName);
			quantityOfCustomProducts--;
		}

		// calculate total price
		for (ProductInOrder p : productSelectedRegualrList) {
			totalPrice -= p.getPrice() * (double) p.getProductQuantityInCart();
			priceLabel.setText(String.valueOf(totalPrice));
		}
		// testing print - need to remove
		System.out.println("customProducts list->" + customProducts);
		System.out.println("after remove deatails page ->" + customProductInOrderFinallCart.get(customName));
		System.out.println("total custom products ->" + customProductInOrderFinallCart);
		System.out.println("quantityOfCustomProducts->" + quantityOfCustomProducts);
		System.out.println("totalPrice->" + totalPrice);
	}

	public static void updateTotalPrice() {
		// update price label after remove regular product
		priceLabel.setText(OrderHandleController.getTotalPrice() + "");
		System.out.println("total price updated ->" + priceLabel.getText());
	}

	public static boolean isDetailsAllreadyOpen() {
		return detailsAllreadyOpen;
	}

	public static void setDetailsAllreadyOpen(boolean detailsAllreadyOpen) {
		OrderHandleController.detailsAllreadyOpen = detailsAllreadyOpen;
	}

	public static List<ProductInBranch> getProductInBranch() {
		return productInBranch;
	}

	public static void setProductInBranch(List<ProductInBranch> productInBranch) {
		OrderHandleController.productInBranch = productInBranch;
	}

	
	public static boolean checkQuantityInOrder() {
		StringBuilder sb = new StringBuilder();
		sb.append("There was an exception in the stock.\n");
		
		//clear all information before run
		quntityImageInBranch.clear();
		problemticProducts.clear();
		
		//collect total quantity MAP IMAGE for REGUALR.
		for(ProductInOrder productInOr :productInOrder)
		{
			addToMapQuntityInBranch(productInOr);
		}
		
		//collect total quantity MAP IMAGE for CUSTOM.
		for(List<ProductInOrder> customProductList : customProductInOrderFinallCart.values())
		{
			for(ProductInOrder productInOr :customProductList)
			{
				addToMapQuntityInBranch(productInOr);
			}
		}
		
		
		System.out.println("Map-view-> "+quntityImageInBranch);
			
		
		//check total quantity between mapQuntityInBranch and productInBranch 
		Set<String> productsNames = quntityImageInBranch.keySet();
		for(String productName : productsNames)
		{
			for(ProductInBranch productInB:productInBranch) {
				//check if same productId
				String productID=String.valueOf(quntityImageInBranch.get(productName).get(0));  
				int productQuantity=quntityImageInBranch.get(productName).get(1);
				
				if(productInB.getProductID().equals(productID))
				{
					//System.out.println("ProductInBranch-> " +productInB.getProductID());
					//System.out.println("ProductIDInMap-> "  +productID);
					
					// Quantity in branch is smaller then total Customer choose. 
					if(productInB.getQuantity()<productQuantity) {
						
						//add to problematic productID set
						problemticProducts.add(productName);
						System.out.println("problem-set:"+problemticProducts);
						//System.out.println("QunitityInBranch-> " +productInB.getQuantity());
						//System.out.println("CustomerTotalQuantity -> " +quntityImageInBranch.get(productID));
						
						//build massage view 
						sb.append("Total "+ productName+" in branch:\n");
						sb.append(productInB.getQuantity()+"\n");
						sb.append("You choose:\n");
						sb.append(productQuantity+"\n");
						sb.append("Please remove -> "+(productQuantity-productInB.getQuantity())+" product units."+"\n");
							
					}
				}
			}
		}
		
		sb.append("Or another option is to change branch :)\n");
		//set massage pop-up screen.
		msg=sb.toString();
		
		//if there is problem quantity.
		if(problemticProducts.size()!=0)
			return false;
		
		return true;
	}

	
	//add to map of quntityInBranch + set problemticProducts
	private static void addToMapQuntityInBranch(ProductInOrder productInOr) {
		int quntity;
		
		System.out.println("productInOr ProductID->"+productInOr.getName());
		// if not inside the map 
		if(!quntityImageInBranch.containsKey(productInOr.getName())) {
			quntityImageInBranch.put(productInOr.getName(),Arrays.asList(Integer.parseInt(productInOr.getID()),productInOr.getProductQuantityInCart()));
		}
		else // inside the map need to add quantity to same item 
		{
			quntity=quntityImageInBranch.get(productInOr.getName()).get(1);
			quntityImageInBranch.remove(productInOr.getName());
			quntityImageInBranch.put(productInOr.getName(),Arrays.asList(Integer.parseInt(productInOr.getID()),quntity+productInOr.getProductQuantityInCart()));
		}		
		
	}

	public static String getMsg() {
		return msg;
	}

	public static void setMsg(String msg) {
		OrderHandleController.msg = msg;
	}

	
	public static Set<String> getProblemticProducts() {
		return problemticProducts;
	}	

}
