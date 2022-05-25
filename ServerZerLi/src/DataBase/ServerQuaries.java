package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import communication.Response;
import communication.TransmissionPack;
import entities_catalog.Product;
import entities_catalog.ProductInOrder;
import entities_general.CreditCard;
import entities_general.Login;
import entities_general.Order;
import entities_users.BranchManager;
import entities_users.Customer;
import entities_users.CustomerService;
import entities_users.DeliveryAgent;
import entities_users.MarketingWorker;
import entities_users.NetworkManager;
import entities_users.ServiceExpert;
import entities_users.ShopWorker;
import entities_users.User;
import enums.AccountStatus;
import enums.OrderStatus;
import enums.ShopWorkerActivity;


/**
 * In this class there are all the server quarries
 *@author Mor Ben Haim
 *
 */
public class ServerQuaries {
	private static  Random rndOrderNum = new Random();
    
	

	/**
	 * In this method we Insert an order into the DB . (the order that we got from
	 * the client, in the transmission information) and after that we success or
	 * failed we setting the obj.Response
	 * 
	 * @param obj - the transmission that we got
	 * @param con - the connection instance for the sql
	 */
//	public static void AddOrderToDB(TransmissionPack obj, Connection con) {
//		if (obj.getInformation() != null) {
//			if (obj instanceof TransmissionPack) {
//				Order order = (Order) obj.getInformation();
//				Statement stmt, stmt2;
//				try {
//					stmt2 = con.createStatement();
//					ResultSet rs = stmt2.executeQuery("SELECT orderNumber FROM orders;");
//					while (rs.next()) {
//						if (order.getOrderNumber().equals(rs.getString(1)) || order.getOrderNumber().equals("")) {
//							obj.setResponse(Response.INSERT_ORDER_FAILD);
//							return;
//						}
//						if (order.getOrderNumber().equals("") || order.getPrice().equals("")
//								|| order.getColor().equals("") || order.getShop().equals("")
//								|| order.getDate().equals("") || order.getOrderDate().equals("")) {
//							obj.setResponse(Response.INSERT_ORDER_FAILD);
//							return;
//						}
//					}
//					stmt = con.createStatement();
//					stmt.executeUpdate(String.format(
//							"INSERT INTO zerli.orders(orderNumber, price, greetingCard, color, dOrder, shop, date, orderDate) VALUES ('%s', '%s', '%s', '%s','%s', '%s', '%s', '%s');",
//							order.getOrderNumber(), order.getPrice(), order.getGreetingCard(), order.getColor(),
//							order.getDorder(), order.getShop(), order.getDate(), order.getOrderDate()));
//
//				} catch (SQLException e) {
//					e.printStackTrace();
//					obj.setResponse(Response.INSERT_ORDER_FAILD);
//					return;
//				}
//				obj.setResponse(Response.INSERT_ORDER_SUCCESS);
//			}
//		} else
//			obj.setResponse(Response.INSERT_ORDER_FAILD);
//	}

	/**
	 * In this method we Edit an order in the DB . (the order and the details that
	 * he want to edit) that we got from the client, (in the transmission
	 * information) and after that we success or failed we setting the obj.Response
	 * 
	 * @param obj - the transmission that we got
	 * @param con - the connection instance for the sql
	 */
//	public static void EditOrderOnDB(TransmissionPack obj, Connection con) {
//		if (obj instanceof TransmissionPack) {
//			Order order = (Order) obj.getInformation();
//			try {
//				if (order.getOrderNumber().equals("") || order.getColor().equals("") || order.getDate().equals("")) {
//					obj.setResponse(Response.EDIT_ORDER_FAILD);
//					return;
//				}
//				PreparedStatement pstmt = con
//						.prepareStatement("UPDATE orders SET Color=? , Date=? WHERE OrderNumber=?;");
//				pstmt.setString(1, order.getColor());
//				pstmt.setString(2, order.getDate());
//				pstmt.setString(3, order.getOrderNumber());
//				if (pstmt.executeUpdate() == 0) {
//					obj.setResponse(Response.EDIT_ORDER_FAILD);
//					return;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//				obj.setResponse(Response.EDIT_ORDER_FAILD);
//				return;
//			}
//			obj.setResponse(Response.EDIT_ORDER_SUCCESS);
//		}
//	}

	/**
	 * In this method we getting orders from the DB . we putting all the orders that
	 * we taking from the DB into the obj.information. and after that we success or
	 * failed we setting the obj.Response
	 * 
	 * @param obj - the transmission that we got
	 * @param con - the connection instance for the sql
	 */
//	public static void GetOrderFromDB(TransmissionPack obj, Connection con) {
//		if (obj instanceof TransmissionPack) {
//			List<Order> list = new ArrayList<>();
//			Statement stmt;
//			try {
//				stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery("SELECT * FROM orders;");
//				while (rs.next()) {
//					Order order = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
//							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
//					list.add(order);
//				}
//
//				obj.setInformation(list);
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//				obj.setResponse(Response.DIDNT_FOUND_ORDERS);
//				return;
//			}
//			obj.setResponse(Response.FOUND_ORDERS);
//		} else
//			obj.setResponse(Response.DIDNT_FOUND_ORDERS);
//	}

//	public static ResultSet getUserLoginDetail(Connection con, Login login) throws SQLException {
//
//		ResultSet rs = null;
//		PreparedStatement pstmt = null;
//		;
//
//		String query = "SELECT * FROM zerli.login WHERE userName=" + "'" + login.getUserName() + "'" + " AND "
//				+ "password=" + "'" + login.getPassword() + "'";
//		System.out.println(query);
//		pstmt = con.prepareStatement(query);
//		rs = pstmt.executeQuery(query);
//
//		System.out.println("here2");
//		return rs;
//
//	}
//
//	public static void getUser(TransmissionPack obj, Connection con) {
//		System.out.println("here1");
//		if (obj instanceof TransmissionPack) {
//			Login user = (Login) obj.getInformation();
//			Response response = null;
//			try {
//				ResultSet rs = getUserLoginDetail(con, user);
//
//				System.out.println("here3");
//
//				response = getUserLogInResponse(user, response, rs);
//
//				obj.setResponse(response);
//				return;
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//				obj.setResponse(Response.USER_NOT_EXIST);
//				return;
//			}
//
//		}
//	}
//
//	/**
//	 * get the response of the login from the details the user where sent to the db
//	 */
//	private static Response getUserLogInResponse(Login user, Response response, ResultSet rs) throws SQLException {
//		while (rs.next()) {
//			System.out.println(rs.getString(1));
//			/** check if the user name or the password are incorrect */
//			if (!(rs.getString(1).equals(user.getUserName())) || !(rs.getString(2).equals(user.getPassword()))) {
//				System.out.println("here4");
//				response = Response.USER_NAME_OR_PASSWORD_INCORRECT;
//
//			}
//			if (rs.getString(1).equals(user.getUserName()) && rs.getString(2).equals(user.getPassword())) {
//				System.out.println("here5");
//				response = Response.USER_EXIST;
//
//			} else {
//				response = Response.USER_NOT_EXIST;
//			}
//
//		}
//		System.out.println("here6");
//		rs.close();
//		return response;
//	}

	public static void Login(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			Login user = (Login) obj.getInformation();
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT userName , password , userType, ID FROM login;");
				while (rs.next()) {
					System.out.println(rs.getString(4));
					if (user.getUserName().equals(rs.getString(1)) && user.getPassword().equals(rs.getString(2))) {
						if (checkIfLoggedin(user, rs.getString(3), rs.getString(4), obj, con) == false) {
							obj.setResponse(Response.USER_EXIST);

							return;
						} else {
							obj.setResponse(Response.USER_ALREADY_LOGGEDIN);
							return;
						}
					}
					if (user.getUserName().equals(rs.getString(1)) && !user.getPassword().equals(rs.getString(2))) {
						obj.setResponse(Response.USER_NAME_OR_PASSWORD_INCORRECT);
						return;
					}
				}

				obj.setResponse(Response.USER_NOT_EXIST);
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				obj.setResponse(Response.USER_NOT_EXIST);
				return;
			}
		}
	}

	/**
	 * checking if login if yes we don't do anything , else we updating that he can
	 * login and update the table that he logged in
	 * 
	 * @param user
	 * @param type
	 * @param userID
	 * @param obj
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("resource")
	public static boolean checkIfLoggedin(Login user, String type, String userID, TransmissionPack obj, Connection con)
			throws SQLException {
		boolean isLogin = false;
		String table, userRow, updateSpecificRow;
		ResultSet rs;
		PreparedStatement pstmt, pstmt2;
		table = "zerli." + type;
		userRow = "SELECT isLoggedIn FROM" + " " + table + " WHERE "+type+"ID=" + "'" + userID + "'" + ";";
		updateSpecificRow = "UPDATE" + " " + table + " SET isLoggedIn=? WHERE "+type+"ID=" + "'" + userID
				+ "'" + ";";
		pstmt = con.prepareStatement(userRow);
		rs = pstmt.executeQuery(userRow);
		rs.next();
		if (rs.getString(1).equals("1"))
			isLogin = true;
		else if (rs.getString(1).equals("0")) {
			isLogin = false;
			pstmt2 = con.prepareStatement(updateSpecificRow);
			pstmt2.setString(1, "1");
			pstmt2.executeUpdate();
			upadateUserInformation(type, userID, obj, pstmt);//Update the obj to specific userType and his specific information

		}

		return isLogin;

	}

	/**
	 * this method is updating the specific userType and his specific information
	 * it will be update on the client side as well using trancimissionPack setInformation method
	 * @param type 
	 * @param userID
	 * @param obj
	 * @param pstmt
	 * @throws SQLException
	 */
	private static void upadateUserInformation(String type, String userID, TransmissionPack obj,
			PreparedStatement pstmt) throws SQLException {
		ResultSet rs;
		switch (type) {
		case "customer": {

			rs = getRowFromTable(userID, type, pstmt);
			Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7), rs.getString(8),
					rs.getBoolean(9), (new CreditCard(rs.getString(6), null, null)));
			obj.setInformation(customer);
			break;
		}
		case "branchmanager": {

			rs = getRowFromTable(userID, type, pstmt);
			BranchManager branchmanager = new BranchManager(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7), rs.getString(8));
			obj.setInformation(branchmanager);
			break;
		}
		case "customerservice":{
			rs = getRowFromTable(userID, type, pstmt);
			CustomerService customerservice = new CustomerService(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7));
			obj.setInformation(customerservice);
			break;
		}
		case "deliveryagent":{
			rs = getRowFromTable(userID, type, pstmt);
			List<String>ordersID=Arrays.asList(rs.getString(9).split("[\\s,]+"));
			DeliveryAgent deliveryagent = new DeliveryAgent(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7),rs.getString(8),ordersID);
			obj.setInformation(deliveryagent);
			break;
		}
		case "marketingworker":{
			rs = getRowFromTable(userID, type, pstmt);
			
			MarketingWorker marketingworker = new MarketingWorker(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7));
			obj.setInformation(marketingworker);
			break;
		}
		case "networkmanager":{
			rs = getRowFromTable(userID, type, pstmt);
			
			NetworkManager networkmanager = new NetworkManager(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7));
			obj.setInformation(networkmanager);
			break;
		}
		case "serviceexpert":{
			rs = getRowFromTable(userID, type, pstmt);
			
			ServiceExpert serviceexpert = new ServiceExpert(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7));
			obj.setInformation(serviceexpert);
			break;
		}
		case "shopworker":{
			rs = getRowFromTable(userID, type, pstmt);
			
			ShopWorker shopworker = new ShopWorker(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7),rs.getString(8),ShopWorkerActivity.valueOf(rs.getString(9)));
			obj.setInformation(shopworker);
			break;
		}
		}
	}

	/**
	 * this method return specific row of user from his tale
	 * 
	 * @param userID
	 * @param type
	 * @param pstmt
	 * @return
	 * @throws SQLException
	 */
	private static ResultSet getRowFromTable(String userID, String type, PreparedStatement pstmt) throws SQLException {
		ResultSet rs;
		String getrow = "SELECT * FROM zerli." + type + " WHERE " + type + "ID='" + userID + "'";
		rs = pstmt.executeQuery(getrow);
		rs.next();
		return rs;
	}

	public static void logout(TransmissionPack obj, Connection con) {
		ResultSet rs;
		PreparedStatement pstmt;
		Statement stmt;
		try {
			stmt = con.createStatement();
			String query = "SELECT userType FROM login WHERE ID='" + ((User) obj.getInformation()).getID() + "'";
			rs = stmt.executeQuery(query);
			rs.next();
			String table = "zerli." + rs.getString(1);
			String table2 = rs.getString(1) + "ID";

			String query2 = "UPDATE" + " " + table + " SET isLoggedIn=? WHERE " + table2 + "='"
					+ ((User) obj.getInformation()).getID() + "'";
			System.out.println(query2);
			pstmt = con.prepareStatement(query2);
			pstmt.setString(1, "0");
			pstmt.executeUpdate();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void GetShopWorkersFromDB(TransmissionPack obj, Connection con) {
		//the method gets workers from the specific branch of the connected user(branch manager), from DB
		if(obj instanceof TransmissionPack)
		{
			List<ShopWorker> list= new ArrayList<>();
			Statement stmt;
			User user= (User)obj.getInformation();//user=branch manager
			String branchID=getBranchId(user,con);
			if(branchID==null)
			{
				obj.setResponse(Response.SHOP_WORKER_NOT_ARRIVED);
				return;
			}
			
			try {
				stmt = con.createStatement();
				ResultSet rs;
				//String getColumns = "SELECT shopworkerID,firstName, lastName,accountStatus, branchID FROM shopworker;";
				String getColumns = "SELECT * FROM zerli.shopworker WHERE branchID='"+branchID+"';";
				rs = stmt.executeQuery(getColumns);
				
				while (rs.next()) {
					ShopWorker sw= new ShopWorker(rs.getString(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),(AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7), rs.getString(8),
							ShopWorkerActivity.valueOf(rs.getString(9)));
					
					list.add(sw);
				}
				if(list.size()>0)
				{
					obj.setResponse(Response.SHOP_WORKER_ARRIVED);
					obj.setInformation(list);
				}
				else
					obj.setResponse(Response.SHOP_WORKER_NOT_ARRIVED);
				rs.close();

				
				
			}catch(SQLException e) {
				obj.setResponse(Response.SHOP_WORKER_NOT_ARRIVED);
			}	
		}
	}

	
	// get products to catalog without filter .
	public static void GetProducts(TransmissionPack obj, Connection con) {
		// TODO Auto-generated method stub
		if (obj instanceof TransmissionPack) {
			List<Product> list = new ArrayList<>();
			
			Statement stmt;
		    try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM product;");
			while (rs.next()) {
				Product product = new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4),rs.getString(5),
						rs.getInt(6),rs.getString(7),rs.getString(8),rs.getBoolean(9),rs.getDouble(10));
						
				list.add(product);
			}			
			
			if(list.size()==0)
				throw new SQLException();

			obj.setInformation(list);
			rs.close();
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    	obj.setResponse(Response.FAILD_DATA_PRODUCTS);
		    	return;
		    }
		    obj.setResponse(Response.GET_DATA_PRODUCTS);
			}
		
		else
			obj.setResponse(Response.FAILD_DATA_PRODUCTS);
	}

	
	//get products by filter of color \ price \ type
	public static void GetProductsByFilter(TransmissionPack obj, Connection con) {
		
		if (obj instanceof TransmissionPack) {
			@SuppressWarnings("unchecked")
			Map<String,String> filters = (Map<String, String>) obj.getInformation();
			List<Product> products = new ArrayList<>();
			int lowValuePrice=0 , highValuePrice=0;
			String colorFilter , priceFilter , typeFilter;
			String query; 
		
			//get Filters from HashMap
			colorFilter=filters.get("color");
			priceFilter=filters.get("price");
			typeFilter=filters.get("type");
		
		
			//split price to 2 section lowValuePrice and highValuePrice
			if(!priceFilter.equals("None"))
			{	
				String [] tmp = priceFilter.split("-");
				int lastIndex=tmp[1].length()-1;
				lowValuePrice=Integer.parseInt(tmp[0]);
				highValuePrice=Integer.parseInt(tmp[1].substring(0,lastIndex));
			}
		
		
			// query of color + price + filter
			if(!colorFilter.equals("None") && !priceFilter.equals("None") && !typeFilter.equals("None") ) {
				query = "SELECT * FROM zerli.product WHERE dominateColor = '"+ colorFilter +"' AND price > "+ lowValuePrice +" AND price<"+highValuePrice +" AND itemType = '"+typeFilter+"' ;";
			}
			// color + price
			else if(!colorFilter.equals("None") && !priceFilter.equals("None")) {
	    		query = "SELECT * FROM zerli.product WHERE dominateColor = '"+ colorFilter +"' AND price > "+ lowValuePrice +" AND price<"+highValuePrice +";";
	    	}
			//color + type
	    	else if (!colorFilter.equals("None") && !typeFilter.equals("None") ) {
	    		query = "SELECT * FROM zerli.product WHERE dominateColor = '"+ colorFilter +"' AND itemType = '"+typeFilter+"' ;";
	    	}
			//price + type
	    	else if(!priceFilter.equals("None") && !typeFilter.equals("None") ) {
	    		 query = "SELECT * FROM zerli.product WHERE price > "+ lowValuePrice +" AND price<"+highValuePrice +" AND itemType = '"+typeFilter+"' ;";
	    	}
			//color
	    	else if(!colorFilter.equals("None")) {
	    		query = "SELECT * FROM zerli.product WHERE dominateColor = '"+ colorFilter +"';";
	    	}
			//price
	    	else if(!priceFilter.equals("None")) {
	    		query = "SELECT * FROM zerli.product WHERE  price > "+ lowValuePrice +" AND price<"+highValuePrice +";";
	    	}
			//type
	    	else 
	    		query = "SELECT * FROM zerli.product WHERE itemType = '"+typeFilter+"' ;";
	    		
	    	System.out.println(query);
            
            
			Statement stmt;
			try {
			    	stmt = con.createStatement();
			    	ResultSet rs = stmt.executeQuery(query);
			    	while (rs.next()) {
			    	Product product = new Product(rs.getString(1), rs.getString(2),rs.getDouble(3), rs.getString(4),rs.getString(5),
							rs.getInt(6),rs.getString(7),rs.getString(8),rs.getBoolean(9),rs.getDouble(10));
							
			    	products.add(product);
				}			
			
			    	if(products.size()==0)
					throw new SQLException();
			    	obj.setInformation(products);
			    	rs.close();
			    } catch (SQLException e) {
			    	e.printStackTrace();
			    	obj.setResponse(Response.FAILD_DATA_PRODUCTS_BY_FILTER);
			    	return;
			    }
			    	obj.setResponse(Response.GET_DATA_PRODUCTS_BY_FILTER);
			}
		else
			obj.setResponse(Response.FAILD_DATA_PRODUCTS_BY_FILTER);
		}
	/**
	 * this method is getting the colors for the catalog screen for choosing
	 * dominate color for filtering
	 * @param obj
	 * @param con
	 */
	public static void getColors(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			ResultSet rs;
			Statement stmt;
			List<String>colors=new ArrayList<>();
			/**
			 * Distinct query to getting colors from product table
			 */
			String query="SELECT DISTINCT dominateColor FROM zerli.product";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					colors.add(rs.getString(1));/**add the color to the the arrayList*/
					
					
					
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(colors.toString());
			if(colors.size()>0) {
				
			obj.setInformation(colors);
			obj.setResponse(Response.FOUND_COLORS);
			}
			else {
				obj.setResponse(Response.DID_NOT_FIND_COLORS);
			}
			
				
		}
		
	}

	/**
	 * this method is insert order that customer performed and save it to wate for branch manger for improving
	 * it save also the order details that in progress 
	 * @param obj
	 * @param con
	 */
	@SuppressWarnings("null")
	public static void addOrderInDB(TransmissionPack obj, Connection con) {
		
		
		if (obj instanceof TransmissionPack) {
			
			Statement stmt=null;
			if(obj.getInformation() instanceof Order) {
				Order order=(Order)obj.getInformation();
				Map<String,List<ProductInOrder>>productInOrderFinallCart=order.getItems();
				
				
			String query=String.format("INSERT INTO zerli.order(orderID, customerID, branchID,price, greetingCard,status, orderDate,expectedDelivery) VALUES ('%s', '%s', '%s','%s', '%s', '%s', '%s', '%s');", null,order.getCustomerID(),order.getBranchID(),order.getPrice(),order.getGreetingCard(),order.getStatus(),order.getOrderDate(),order.getExpectedDelivery());
			
			try {
				stmt = con.createStatement();
				System.out.println(query);
				stmt.executeUpdate(query);
				int i=0;
				for(String p:productInOrderFinallCart.keySet()) {
					ProductInOrder pr=productInOrderFinallCart.get(p).get(i);
					stmt = con.createStatement();

					String query2=String.format("INSERT INTO zerli.productinorder(productID, orderID, nameOfproduct, price, backGroundColor, picture, quantity, itemType, dominateColor, cartID, productQuantityInOrder, nameOfItem) VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",pr.getNameOfproduct(), order.getOrderID(),pr.getNameOfproduct(),pr.getPrice(),pr.getBackGroundColor(),pr.getImgSrc(),pr.getQuantity(),pr.getItemType(),pr.getDominateColor(),pr.getProductQuantityInCart(),pr.getName());

					System.out.println(query2);
					stmt.executeUpdate(query2);
					i++;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			
//			stmt.executeUpdate(String.format(
//					"INSERT INTO zerli.orders(orderNumber, price, greetingCard, color, dOrder, shop, date, orderDate) VALUES ('%s', '%s', '%s', '%s','%s', '%s', '%s', '%s');",
//					order.getOrderNumber(), order.getPrice(), order.getGreetingCard(), order.getColor(),
//					order.getDorder(), order.getShop(), order.getDate(), order.getOrderDate()));
			try {
				stmt = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void getOrders(TransmissionPack obj, Connection con) {
		System.out.println(6);
		if (obj instanceof TransmissionPack) {
			ResultSet rs,rs2;
			Statement stmt,stmt2;

			List<Order>orders=new ArrayList<>();
			
			String query="SELECT * FROM zerli.order WHERE status='PENDING'";
			String query1="SELECT * FROM zerli.productinorder WHERE orderID='";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while(rs.next()) {
					
					Map<String,List<ProductInOrder>>products=new HashMap<>();
					
					stmt2 = con.createStatement();
					
					rs2 = stmt2.executeQuery(query1+rs.getString(1)+"'");
					while(rs2.next()) {
						
						ProductInOrder newProduct=new ProductInOrder(rs2.getString(1),rs.getString(2),rs2.getString(3), rs2.getDouble(4), rs2.getString(5), rs2.getString(6), rs2.getInt(7), rs2.getString(8), rs2.getString(9), rs2.getInt(10), rs2.getString(11), rs2.getBoolean(12),rs.getDouble(13));
						if(!products.containsKey(rs2.getString(3))) {
							List<ProductInOrder>product=new ArrayList<>();
							product.add(newProduct);
							products.put(rs2.getString(3), product);
						}else {
							products.get(rs2.getString(3)).add(newProduct);
						}
						
					}
					rs2.close();
					
					
					Order order=new Order(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5),rs.getTimestamp(7).toString(),rs.getTimestamp(8).toString(),products);
					order.setStatus(OrderStatus.valueOf(rs.getString(6)));
					
					orders.add(order);
				}
		
				
				rs.close();
//				System.out.println(orders);
				if(orders.size()>0) {
					obj.setResponse(Response.FOUND_ORDER);
					obj.setInformation(orders);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

		
	

	private static String getBranchId(User user, Connection con) {
		ResultSet rs;
		Statement stmt;
		String branchId=null;
		String getBranchID = "SELECT branchID FROM zerli.branchmanager WHERE branchmanagerID='"+user.getID()+"';";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(getBranchID);
			rs.next();
			branchId=rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branchId;
	}
}
//	public static void GetProductFromDB(TransmissionPack obj, Connection con) {
//		if (obj instanceof TransmissionPack) {
//			List<Product> list = new ArrayList<>();
//			Statement stmt;
//			try {
//				stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery("SELECT * FROM product;");
//				while (rs.next()) {
//					Product product = new Product(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4),rs.getString(5));
//							
//					list.add(product);
//				}
//
//				obj.setInformation(list);
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//				obj.setResponse(Response.DIDNT_FOUND_ORDERS);
//				return;
//			}
//			obj.setResponse(Response.FOUND_ORDERS);
//		} else
//			obj.setResponse(Response.DIDNT_FOUND_ORDERS);
//	}
