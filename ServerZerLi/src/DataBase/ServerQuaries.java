package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import communication.Response;
import communication.TransmissionPack;
import entities_catalog.Product;
import entities_catalog.ProductInBranch;
import entities_catalog.ProductInOrder;
import entities_general.Cancellation;
import entities_general.CreditCard;
import entities_general.Deliveries;
import entities_general.Login;
import entities_general.Order;
import entities_general.Question;
import entities_reports.Complaint;
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
import enums.Branches;
import enums.ComplaintsStatus;
import enums.DeliveryStatus;
import enums.OrderStatus;
import enums.ShopWorkerActivity;

/**
 * In this class there are all the server quarries
 * 
 * @author Mor Ben Haim
 *
 */
public class ServerQuaries {

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
			Statement stmt, stmt2;
			try {
				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT userName , password , userType, ID FROM login;");
				while (rs.next()) {
					System.out.println(rs.getString(4));
					if (user.getUserName().equals(rs.getString(1)) && user.getPassword().equals(rs.getString(2))) {
						if (checkIfLoggedin(user, rs.getString(3), rs.getString(4), obj, con) == false) {
							if (rs.getString(4).equals("shopworker")) {
								stmt2 = con.createStatement();
								ResultSet rs2 = stmt2
										.executeQuery("SELECT branchID FROM zerli.shopworker WHERE shopworkerID='"
												+ rs.getString(3) + "'");

								((ShopWorker) obj.getInformation()).setBranchID(rs2.getString(1));
							}
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
		userRow = "SELECT isLoggedIn FROM" + " " + table + " WHERE " + type + "ID=" + "'" + userID + "'" + ";";
		updateSpecificRow = "UPDATE" + " " + table + " SET isLoggedIn=? WHERE " + type + "ID=" + "'" + userID + "'"
				+ ";";
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
			upadateUserInformation(type, userID, obj, pstmt);// Update the obj to specific userType and his specific
																// information

		}

		return isLogin;

	}

	/**
	 * this method is updating the specific userType and his specific information it
	 * will be update on the client side as well using trancimissionPack
	 * setInformation method
	 * 
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
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7),
					rs.getString(8));
			obj.setInformation(branchmanager);
			break;
		}
		case "customerservice": {
			rs = getRowFromTable(userID, type, pstmt);
			CustomerService customerservice = new CustomerService(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7));
			obj.setInformation(customerservice);
			break;
		}
		case "deliveryagent": {
			rs = getRowFromTable(userID, type, pstmt);
			List<String> ordersID = Arrays.asList(rs.getString(9).split("[\\s,]+"));
			DeliveryAgent deliveryagent = new DeliveryAgent(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7),
					rs.getString(8), ordersID);
			obj.setInformation(deliveryagent);
			break;
		}
		case "marketingworker": {
			rs = getRowFromTable(userID, type, pstmt);

			MarketingWorker marketingworker = new MarketingWorker(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7));
			obj.setInformation(marketingworker);
			break;
		}
		case "networkmanager": {
			rs = getRowFromTable(userID, type, pstmt);

			NetworkManager networkmanager = new NetworkManager(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7));
			obj.setInformation(networkmanager);
			break;
		}
		case "serviceexpert": {
			rs = getRowFromTable(userID, type, pstmt);

			ServiceExpert serviceexpert = new ServiceExpert(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7));
			obj.setInformation(serviceexpert);
			break;
		}
		case "shopworker": {
			rs = getRowFromTable(userID, type, pstmt);

			ShopWorker shopworker = new ShopWorker(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7), rs.getString(8),
					ShopWorkerActivity.valueOf(rs.getString(9)));
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
		// the method gets workers from the specific branch of the connected user(branch
		// manager), from DB
		if (obj instanceof TransmissionPack) {
			List<ShopWorker> list = new ArrayList<>();
			Statement stmt;
			User user = (User) obj.getInformation();// user=branch manager
			String branchID = getBranchId(user, con);
			if (branchID == null) {
				obj.setResponse(Response.SHOP_WORKER_NOT_ARRIVED);
				return;
			}

			try {
				stmt = con.createStatement();
				ResultSet rs;
				// String getColumns = "SELECT shopworkerID,firstName, lastName,accountStatus,
				// branchID FROM shopworker;";
				String getColumns = "SELECT * FROM zerli.shopworker WHERE branchID='" + branchID + "';";
				rs = stmt.executeQuery(getColumns);

				while (rs.next()) {
					ShopWorker sw = new ShopWorker(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7),
							rs.getString(8), ShopWorkerActivity.valueOf(rs.getString(9)));

					list.add(sw);
				}
				if (list.size() > 0) {
					obj.setResponse(Response.SHOP_WORKER_ARRIVED);
					obj.setInformation(list);
				} else
					obj.setResponse(Response.SHOP_WORKER_NOT_ARRIVED);
				rs.close();

			} catch (SQLException e) {
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
					Product product = new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getBoolean(9),
							rs.getDouble(10));

					list.add(product);
				}

				if (list.size() == 0)
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

	// get products by filter of color \ price \ type
	public static void GetProductsByFilter(TransmissionPack obj, Connection con) {

		if (obj instanceof TransmissionPack) {
			@SuppressWarnings("unchecked")
			Map<String, String> filters = (Map<String, String>) obj.getInformation();
			List<Product> products = new ArrayList<>();
			int lowValuePrice = 0, highValuePrice = 0;
			String colorFilter, priceFilter, typeFilter;
			String query;

			// get Filters from HashMap
			colorFilter = filters.get("color");
			priceFilter = filters.get("price");
			typeFilter = filters.get("type");

			// split price to 2 section lowValuePrice and highValuePrice
			if (!priceFilter.equals("None")) {
				String[] tmp = priceFilter.split("-");
				int lastIndex = tmp[1].length() - 1;
				lowValuePrice = Integer.parseInt(tmp[0]);
				highValuePrice = Integer.parseInt(tmp[1].substring(0, lastIndex));
			}

			// query of color + price + filter
			if (!colorFilter.equals("None") && !priceFilter.equals("None") && !typeFilter.equals("None")) {
				query = "SELECT * FROM zerli.product WHERE dominateColor = '" + colorFilter + "' AND price > "
						+ lowValuePrice + " AND price<" + highValuePrice + " AND itemType = '" + typeFilter + "' ;";
			}
			// color + price
			else if (!colorFilter.equals("None") && !priceFilter.equals("None")) {
				query = "SELECT * FROM zerli.product WHERE dominateColor = '" + colorFilter + "' AND price > "
						+ lowValuePrice + " AND price<" + highValuePrice + ";";
			}
			// color + type
			else if (!colorFilter.equals("None") && !typeFilter.equals("None")) {
				query = "SELECT * FROM zerli.product WHERE dominateColor = '" + colorFilter + "' AND itemType = '"
						+ typeFilter + "' ;";
			}
			// price + type
			else if (!priceFilter.equals("None") && !typeFilter.equals("None")) {
				query = "SELECT * FROM zerli.product WHERE price > " + lowValuePrice + " AND price<" + highValuePrice
						+ " AND itemType = '" + typeFilter + "' ;";
			}
			// color
			else if (!colorFilter.equals("None")) {
				query = "SELECT * FROM zerli.product WHERE dominateColor = '" + colorFilter + "';";
			}
			// price
			else if (!priceFilter.equals("None")) {
				query = "SELECT * FROM zerli.product WHERE  price > " + lowValuePrice + " AND price<" + highValuePrice
						+ ";";
			}
			// type
			else
				query = "SELECT * FROM zerli.product WHERE itemType = '" + typeFilter + "' ;";

			System.out.println(query);

			Statement stmt;
			try {

				stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					Product product = new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getBoolean(9),
							rs.getDouble(10));

					products.add(product);
				}

				if (products.size() == 0)
					throw new SQLException();
				obj.setInformation(products);
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				obj.setResponse(Response.FAILD_DATA_PRODUCTS_BY_FILTER);
				return;
			}
			obj.setResponse(Response.GET_DATA_PRODUCTS_BY_FILTER);
		} else
			obj.setResponse(Response.FAILD_DATA_PRODUCTS_BY_FILTER);
	}

	/**
	 * this method is getting the colors for the catalog screen for choosing
	 * dominate color for filtering
	 * 
	 * @param obj
	 * @param con
	 */
	public static void getColors(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			ResultSet rs;
			Statement stmt;
			List<String> colors = new ArrayList<>();
			/**
			 * Distinct query to getting colors from product table
			 */
			String query = "SELECT DISTINCT dominateColor FROM zerli.product";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);

				while (rs.next()) {
					colors.add(rs.getString(1));/** add the color to the the arrayList */

				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(colors.toString());
			if (colors.size() > 0) {

				obj.setInformation(colors);
				obj.setResponse(Response.FOUND_COLORS);
			} else {
				obj.setResponse(Response.DID_NOT_FIND_COLORS);
			}

		}

	}

	/**
	 * this method is insert order that customer performed and save it to wate for
	 * branch manger for improving it save also the order details that in progress
	 * 
	 * @param TransmissionPack obj - (Mission) + null + (Order)
	 * @param Connection       con - dataBase connection
	 * @author Almog Madar , Mor Ben-Haim
	 */
	@SuppressWarnings("null")
	public static void addOrderInDB(TransmissionPack obj, Connection con) {

		if (obj instanceof TransmissionPack) {

			if (obj.getInformation() instanceof Order) {
				PreparedStatement pstmt;
				int orderID = 0;
				Statement stmt1;
				ResultSet rs1;
				Order order = (Order) obj.getInformation();
				Map<String, List<ProductInOrder>> productInOrderFinallCart = order.getItems();
				String query = "INSERT INTO zerli.order(orderID, customerID, branchID,price, greetingCard,status, orderDate,expectedDelivery) "
						+ "VALUES (?,?,?,?,?,?,?,?);";
				String query2 = "SELECT MAX(orderID) FROM zerli.order;";
				String query3 = "INSERT INTO zerli.productinorder(productID, orderID , nameOfproduct, price, backGroundColor, picture, quantity, itemType, dominateColor, productQuantityInOrder, nameOfItem) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
				String query4 = "UPDATE zerli.customer SET isNewCustomer = '0' WHERE (customerID = (?));";

				try {
					// insert order to database
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, null);
					pstmt.setInt(2, Integer.parseInt(order.getCustomerID()));
					// System.out.println(order.getCustomerID());
					pstmt.setString(3, order.getBranchID());
					// System.out.println(order.getBranchID());
					pstmt.setString(4, String.valueOf(order.getPrice()));
					// System.out.println(String.valueOf(order.getPrice()));
					pstmt.setString(5, order.getGreetingCard());
					// System.out.println(order.getGreetingCard());
					pstmt.setString(6, order.getStatus().name());
					// System.out.println(order.getStatus());
					pstmt.setString(7, order.getOrderDate());
					// System.out.println(order.getOrderDate());
					pstmt.setString(8, order.getExpectedDelivery());
					// System.out.println(order.getExpectedDelivery());
					pstmt.executeUpdate();

					// get orderID
					stmt1 = con.createStatement();
					rs1 = stmt1.executeQuery(query2);
					while (rs1.next()) {
						orderID = rs1.getInt(1);
					}
					rs1.close();

					// insert (List<productInOrder>) products to table productInOrder
					for (Map.Entry<String, List<ProductInOrder>> entry : productInOrderFinallCart.entrySet()) {
						for (ProductInOrder productInOr : entry.getValue()) {
							pstmt = con.prepareStatement(query3);
							pstmt.setString(1, productInOr.getID());
							pstmt.setString(2, String.valueOf(orderID));
							pstmt.setString(3, entry.getKey()); // Regular or Custom key
							pstmt.setString(4, String.valueOf(productInOr.getPrice()));
							pstmt.setString(5, productInOr.getBackGroundColor());
							pstmt.setString(6, productInOr.getImgSrc());
							pstmt.setString(7, String.valueOf(productInOr.getQuantity()));
							pstmt.setString(8, productInOr.getItemType());
							pstmt.setString(9, productInOr.getDominateColor());
							pstmt.setString(10, String.valueOf(productInOr.getProductQuantityInCart()));
							pstmt.setString(11, productInOr.getNameOfItem());
							pstmt.executeUpdate();
						}

					}

					// if new customer clear flag in database
					pstmt = con.prepareStatement(query4);
					pstmt.setString(1, order.getCustomerID());
					pstmt.executeUpdate();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

					obj.setResponse(Response.INSERT_ORDER_FAILD);
					return;
				}
				obj.setInformation(orderID);
				obj.setResponse(Response.INSERT_ORDER_SUCCESS);
				return;
			}
		}
		obj.setResponse(Response.INSERT_ORDER_FAILD);

	}

	public static void getOrders(TransmissionPack obj, Connection con) {
		System.out.println(6);
		if (obj instanceof TransmissionPack) {
			ResultSet rs, rs2;
			Statement stmt, stmt2;

			List<Order> orders = new ArrayList<>();

			String query = "SELECT * FROM zerli.order WHERE status='PENDING' OR status='PENDING_WITH_DELIVERY' OR status='CANCEL_ORDER_DELIVERY_BY_CUSTOMER' OR status='CANCEL_ORDER_BY_CUSTOMER'";

			String query1 = "SELECT * FROM zerli.productinorder WHERE orderID='";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {

					System.out.println("rs->>");

					Map<String, List<ProductInOrder>> products = new HashMap<>();

					stmt2 = con.createStatement();

					rs2 = stmt2.executeQuery(query1 + rs.getString(1) + "'");
					while (rs2.next()) {

						System.out.println("rs2>>");
						ProductInOrder newProduct = new ProductInOrder(rs2.getString(1), rs2.getString(2),
								rs2.getString(3), rs2.getDouble(4), rs2.getString(5), rs2.getString(6), rs2.getInt(7),
								rs2.getString(8), rs2.getString(9), rs2.getInt(10), rs2.getString(11), false, 0.0);

						if (!products.containsKey(rs2.getString(3))) {
							List<ProductInOrder> product = new ArrayList<>();
							product.add(newProduct);
							products.put(rs2.getString(3), product);
						} else {
							products.get(rs2.getString(3)).add(newProduct);
						}

					}
					System.out.println(products);
					rs2.close();

					Order order = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
							rs.getString(5), rs.getTimestamp(7).toString(), rs.getTimestamp(8).toString(), products);
					order.setStatus(OrderStatus.valueOf(rs.getString(6)));

					orders.add(order);
				}

				rs.close();
//				System.out.println(orders);
				if (orders.size() > 0) {
					obj.setResponse(Response.FOUND_ORDER);
					obj.setInformation(orders);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	protected static String getBranchId(User user, Connection con) {

		ResultSet rs;
		Statement stmt;
		String branchId = null;
		String getBranchID = "SELECT branchID FROM zerli.branchmanager WHERE branchmanagerID='" + user.getID() + "';";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(getBranchID);
			rs.next();
			branchId = rs.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branchId;
	}

	/**
	 * <<<<<<< HEAD get all the branches ID for create the reports
	 * 
	 * @param user
	 * @param con
	 * @return
	 */
	public static List<String> getAllBranchId(Connection con) {
		ResultSet rs;
		Statement stmt;
		List<String> branchesId = new ArrayList<>();
		;

		String getBranchID = "SELECT branchID FROM zerli.branchs;";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(getBranchID);
			while (rs.next()) {
				branchesId.add(rs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branchesId;
	}

	/*
	 * * Get all the customers that their status is "PENDING_APPROVAL" and collect
	 * them in a list
	 * 
	 * @param obj
	 * 
	 * @param con
	 */

	@SuppressWarnings("null")
	public static void getPendingCustomersFromDB(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			List<Customer> PendingcustomersList = new ArrayList<Customer>();
			ResultSet rs;
			Statement stmt;
			String getCustomers = "SELECT * FROM zerli.customer WHERE accountStatus ='PENDING_APPROVAL';"; // The query
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(getCustomers);
				while (rs.next()) {
					// print all the customers to check if we get them right
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					System.out.println(rs.getString(5));
					System.out.println(AccountStatus.valueOf(rs.getString(6)));
					System.out.println(rs.getBoolean(7));
					System.out.println(rs.getString(8));
					System.out.println(rs.getBoolean(9));
					System.out.println(new CreditCard(rs.getString(10), null, null));

					// create new customer with the details from DB
					Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), AccountStatus.valueOf(rs.getString(6)), rs.getBoolean(7), rs.getString(8),
							rs.getBoolean(9), new CreditCard(rs.getString(10), null, null));
					// add to the pending customers list
					PendingcustomersList.add(customer);
				}
				rs.close();
				obj.setInformation(PendingcustomersList);
				obj.setResponse(Response.GET_PENDING_CUSTOMERS_SUCCESS);
				System.out.println(PendingcustomersList);
				return;
			} catch (SQLException e) {
				obj.setResponse(Response.GET_PENDING_CUSTOMERS_FAILED);
				return;
			}
		}
		obj.setResponse(Response.GET_PENDING_CUSTOMERS_FAILED);
	}

	public static void getCreditCardsFromDB(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			ResultSet rs;
			Statement stmt;
			List<String> cardsNumbers = new ArrayList<>();
			String getCards = "SELECT creditCardNumber FROM zerli.creditcards;";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(getCards);
				while (rs.next()) {
					String card = rs.getString(1);
					cardsNumbers.add(card);
				}
				rs.close();
				obj.setInformation(cardsNumbers);
				obj.setResponse(Response.GET_CREDIT_CARDS_SUCCESS);
//				System.out.println(cardsNumbers);
				return;
			} catch (SQLException e) {
				obj.setResponse(Response.GET_CREDIT_CARDS_FAILED);
				return;
			}
		}
		obj.setResponse(Response.GET_CREDIT_CARDS_FAILED);
	}

	public static void approveNewCustomerToDB(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			Customer customer = (Customer) obj.getInformation(); // get the customer updated
			String approveCuStomer = "UPDATE zerli.customer SET accountStatus= 'CONFIRMED', balance= '0', isNewCustomer= '1', creditCardNumber="
					+ customer.getCreditCard().getCreditCardNumber() + " WHERE customerID=" + customer.getID() + ";";
			String addCreditCard = String.format(
					"INSERT INTO zerli.creditcards(creditCardNumber, creditCardCvvCode, creditCardDateOfExpiration) VALUES ('%s','%s', '%s');",
					customer.getCreditCard().getCreditCardNumber(), customer.getCreditCard().getCreditCardCvvCode(),
					customer.getCreditCard().getCreditCardDateOfExpiration());
			System.out.println(addCreditCard); // check string
			try {
				PreparedStatement pstmt1 = con.prepareStatement(approveCuStomer);
				PreparedStatement pstmt2 = con.prepareStatement(addCreditCard);
				if (pstmt1.executeUpdate() == 0) { // check if the query failed
					System.out.println("query 1 failed");
					obj.setResponse(Response.APPROVE_NEW_CUSTOMER_FAILED);
					return;
				} else if (pstmt2.executeUpdate() == 0) { // check if the query failed
					System.out.println("query 2 failed");
					obj.setResponse(Response.APPROVE_NEW_CUSTOMER_FAILED);
					return;
				} else {
					obj.setResponse(Response.APPROVE_NEW_CUSTOMER_SUCCESS);
					return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				obj.setResponse(Response.APPROVE_NEW_CUSTOMER_FAILED);
				return;
			}
		} else {
			obj.setResponse(Response.APPROVE_NEW_CUSTOMER_FAILED);
		}
	}

	public static void updateCustomersAfterEdit(TransmissionPack obj, Connection con) {// the method updates the
																						// customers that are in the
																						// list we got from obj's
																						// information
		if (obj instanceof TransmissionPack) {

			PreparedStatement pstmt;
			List<Customer> listAfterEdit = (ArrayList<Customer>) obj.getInformation();
			try {
				for (Customer c : listAfterEdit) {
					String getApprovedCustomers = "UPDATE zerli.customer SET accountStatus='" + c.getAccountStatus()
							+ "' WHERE customerID='" + c.getID() + "';";
					pstmt = con.prepareStatement(getApprovedCustomers);
					pstmt.executeUpdate(getApprovedCustomers);
				}
				obj.setResponse(Response.CUSTOMER_EDITS_UPDATED);
				return;

			} catch (SQLException e) {
				obj.setResponse(Response.CUSTOMER_EDITS_FAILED);
				obj.setInformation(null);
				return;
			}
		}

	}

	public static void updateWorkersAfterEdit(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			PreparedStatement pstmt;
			List<ShopWorker> listAfterEdit = (ArrayList<ShopWorker>) obj.getInformation();
			try {
				for (ShopWorker sw : listAfterEdit) {
					String getApprovedWorkers = "UPDATE zerli.shopworker SET acctivityStatus='" + sw.getActivityStatus()
							+ "' WHERE shopworkerID='" + sw.getID() + "';";
					System.out.println(getApprovedWorkers);
					pstmt = con.prepareStatement(getApprovedWorkers);
					pstmt.executeUpdate(getApprovedWorkers);
				}
				obj.setResponse(Response.WORKER_EDITS_UPDATED);
				return;

			} catch (SQLException e) {
				obj.setResponse(Response.WORKER_EDITS_FAILED);
				obj.setInformation(null);
				return;
			}
		}
	}

	public static void GetCustomersFromDB(TransmissionPack obj, Connection con) {
		// the method gets workers from the specific branch of the connected user(branch
		// manager), from DB
		if (obj instanceof TransmissionPack) {
			List<Customer> listOfCustomers = new ArrayList<>();
			Statement stmt;

			try {
				stmt = con.createStatement();
				ResultSet rs;
				String getApprovedCustomers = "SELECT * FROM zerli.customer WHERE accountStatus='CONFIRMED' OR accountStatus='FROZEN'";
				rs = stmt.executeQuery(getApprovedCustomers);

				while (rs.next()) {
					CreditCard cc = getCreditCard(rs.getString(10), con);
					if (cc == null) {
						obj.setResponse(Response.CUSTOMER_NOT_ARRIVED);
						obj.setInformation(null);
						return;
					}
					Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), (AccountStatus.valueOf(rs.getString(6))), rs.getBoolean(7),
							rs.getString(8), rs.getBoolean(9), cc);

					listOfCustomers.add(customer);
				}
				if (listOfCustomers.size() > 0) {
					obj.setResponse(Response.CUSTOMER_ARRIVED);
					obj.setInformation(listOfCustomers);// updating the mission info to the wanted list of customers
				} else {
					obj.setResponse(Response.CUSTOMER_NOT_ARRIVED);
					obj.setInformation(null);
				}

				rs.close();

			} catch (SQLException e) {
				obj.setResponse(Response.CUSTOMER_NOT_ARRIVED);
				obj.setInformation(null);
			}
		}
	}

	private static CreditCard getCreditCard(String cardNum, Connection con) {
		ResultSet rs;
		Statement stmt;
		CreditCard cc = null;
		String getCardDetails = "SELECT creditCardCvvCode,creditCardDateOfExpiration FROM zerli.creditcards WHERE creditCardNumber='"
				+ cardNum + "';";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(getCardDetails);
			rs.next();
			cc = new CreditCard(cardNum, rs.getString(1), rs.getString(2));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cc;
	}

	/**
	 * update all the complaint status in the DB
	 * 
	 * @param obj
	 * @param con
	 */
	@SuppressWarnings("unchecked")
	public static void updateComplaints(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			ResultSet rs;
			PreparedStatement pstmt, pstmt2, pstmt3;
			System.out.println("here3->");
			List<Complaint> complaintsToUpdate = (List<Complaint>) obj.getInformation();
			System.out.println(obj.getInformation());
			String updateSpecificRow = "UPDATE zerli.complaints SET status=? WHERE complaintID='";
			for (Complaint c : complaintsToUpdate) {

				try {

					updateComlaint(con, updateSpecificRow, c);
					System.out.println(c.getRefoundAmount());
					if (c.getRefoundAmount() != null) {
						insertNewRefund(con, c);
						updateRefundInSpecificCustomer(con, c);

					}
				} catch (SQLException e) {
					obj.setResponse(Response.COMPLAINTS_UPDATE_FAILED);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			obj.setResponse(Response.COMPLAINTS_UPDATE_SUCCEED);

		}

	}

	/**
	 * update specific complaint row
	 * 
	 * @param con
	 * @param updateSpecificRow
	 * @param c
	 * @throws SQLException
	 */
	private static void updateComlaint(Connection con, String updateSpecificRow, Complaint c) throws SQLException {
		System.out.println("here4->");
		PreparedStatement pstmt;
		pstmt = con.prepareStatement(updateSpecificRow + c.getComplaintID() + "'");
		pstmt.setString(1, c.getComplainState().name());
		pstmt.executeUpdate();
	}

	/**
	 * if there is refund in the complaint it will update the customer balance
	 * 
	 * @param con
	 * @param c
	 * @throws SQLException
	 */
	private static void updateRefundInSpecificCustomer(Connection con, Complaint c) throws SQLException {
		PreparedStatement pstmt3;
		String query2 = "UPDATE zerli.customer SET balance=balance+? WHERE customerID='" + c.getCustomerID() + "'";
		pstmt3 = con.prepareStatement(query2);
		pstmt3.setString(1, c.getRefoundAmount());
		pstmt3.executeUpdate();
	}

	/**
	 * if in the complaint have a refund it create new refund row in the refung row
	 * 
	 * @param con
	 * @param c
	 * @throws SQLException
	 */
	private static void insertNewRefund(Connection con, Complaint c) throws SQLException {
		PreparedStatement pstmt2;
		String query = "INSERT INTO zerli.refunds(refundID,orderID, customerID, ammount, reason, date) VALUES (?,?,?,?,?,?)";
		pstmt2 = con.prepareStatement(query);
		pstmt2.setString(1, null);
		pstmt2.setString(2, c.getOrderID());
		pstmt2.setString(3, c.getCustomerID());
		pstmt2.setString(4, c.getRefoundAmount());
		pstmt2.setString(5, "Complaint");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		pstmt2.setString(6, dateFormat.format(Calendar.getInstance().getTime()));
		pstmt2.executeUpdate();
	}

	/**
	 * insert new complaint to the DB from
	 * 
	 * @param obj
	 * @param con
	 * @throws ParseException
	 */
	public static void openComplaint(TransmissionPack obj, Connection con) throws ParseException {
		if (obj instanceof TransmissionPack) {
			System.out.println("here->Open");
			Complaint c = (Complaint) obj.getInformation();
			PreparedStatement pstmt;

			try {
				String query = "INSERT INTO zerli.complaints(complaintID, customerID, orderID, customerserviceID, description, branchID, complaintOpening, treatmentUntil, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, null);
				pstmt.setString(2, c.getCustomerID());
				pstmt.setString(3, c.getOrderID());
				pstmt.setString(4, c.getCustomerServiceID());
				pstmt.setString(5, c.getDescription());
				pstmt.setString(6, c.getBranchID());
				pstmt.setString(7, c.getComplaintOpening());
				Date d = new Date();
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				d = sdf.parse(c.getComplaintOpening());

				Calendar cl = Calendar.getInstance();
				cl.setTime(d);
				cl.add(Calendar.DATE, 1);
				Date currentDatePlusOne = cl.getTime();
				pstmt.setString(8, sdf.format(currentDatePlusOne));
				pstmt.setString(9, c.getComplainState().name());
				pstmt.executeUpdate();
				System.out.println("here=->>OPenComplaint " + obj.getInformation());
			} catch (SQLException e) {
				obj.setResponse(Response.OPEN_COMPLAINT_FAILED);
				e.printStackTrace();
			}

			obj.setResponse(Response.OPEN_COMPLAINT_SUCCEED);

		} else {
			obj.setResponse(Response.OPEN_COMPLAINT_FAILED);
		}

	}

	public static void getComlaints(TransmissionPack obj, Connection con) {
		System.out.println(6);
		if (obj instanceof TransmissionPack) {
			ResultSet rs;
			Statement stmt;
			List<Complaint> complaints = new ArrayList<>();

			String query = "SELECT * FROM zerli.complaints WHERE customerserviceID='" + obj.getInformation()
					+ "' AND status='OPEN'";
			System.out.println(query);
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					System.out.println(rs.toString());

					Complaint complaint = new Complaint(rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							ComplaintsStatus.valueOf(rs.getString(9)), getSatus(rs.getString(7)));

					complaints.add(complaint);
				}
				rs.close();
				System.out.println(complaints);
				if (complaints.size() > 0) {
					obj.setResponse(Response.FOUND_COMPLAINTS);
					obj.setInformation(complaints);
				} else {
					obj.setResponse(Response.DID_NOT_FOUND_COMPLAINTS);
					obj.setInformation(complaints);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private static String complaintsHanldeTimeLimit(Date currentDate) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

		dateFormat.format(currentDate);

		// convert date to calendar
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);

		// manipulate date

		c.add(Calendar.DATE, 1); // same with c.add(Calendar.DAY_OF_MONTH, 1);

		// convert calendar to date
		Date currentDatePlusOne = c.getTime();
		return dateFormat.format(currentDatePlusOne);
	}

	private static ComplaintsStatus getSatus(String start_date) {
		long difference_In_Days = 0;
		// SimpleDateFormat converts the
		// string format to date object

		// Try Class
		try {

			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// parse method is used to parse
			// the text from a string to
			// produce the date
			Date d1 = sdf.parse(start_date);
			Date d2 = Calendar.getInstance().getTime();
			System.out.println(sdf.format(d1));

			// Calucalte time difference
			// in milliseconds
			long difference_In_Time = d2.getTime() - d1.getTime();

			difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (difference_In_Days >= 1) {

			System.out.println("here 'DELAY'");

			return ComplaintsStatus.DELAY;
		}

		return ComplaintsStatus.STILL_GOT_TIME;
	}

	/*
	 * get all branches
	 * 
	 * @author Almog Madar
	 */

	public static void getBranches(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			ResultSet rs;
			Statement stmt;
			List<Branches> branches = new ArrayList<>();

			String query = "SELECT * FROM zerli.branchs;";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);

				while (rs.next()) {
					branches.add(Branches.valueOf(rs.getString(3).toUpperCase()));
				}
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (branches.size() > 0) {

				obj.setInformation(branches);
				obj.setResponse(Response.FOUND_BRANCHES);
			} else {
				obj.setResponse(Response.NOT_FOUND_BRANCHES);
			}

		}
	}

	/*
	 * get product in specific branch
	 * 
	 * @author Almog Madar
	 */
	public static void getProductInBranch(TransmissionPack obj, Connection con) {
		// TODO Auto-generated method stub
		if (obj instanceof TransmissionPack) {
			ResultSet rs;
			Statement stmt;
			Branches branch = (Branches) obj.getInformation();
			List<ProductInBranch> productsInBranch = new ArrayList<>();

			System.out.println(branch.getNumber());
			String query = "SELECT * FROM zerli.productinbranch where branchID='" + branch.getNumber() + "';";
			System.out.println(query);
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);

				while (rs.next()) {
					ProductInBranch product = new ProductInBranch(rs.getString(1), rs.getString(2), rs.getInt(3));
					productsInBranch.add(product);
				}
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(productsInBranch.toString());

			if (productsInBranch.size() > 0) {
				obj.setInformation(productsInBranch);
				obj.setResponse(Response.FOUND_PRODUCT_IN_BRANCH);
			} else {
				obj.setResponse(Response.NOT_FOUND_PRODUCT_IN_BRANCH);
			}

		}

	}

	/*
	 * add delivery of order and update order price = regular price + shipment price
	 * .
	 * 
	 * @ author Almog Madar
	 */
	public static void addDelivery(TransmissionPack obj, Connection con) {
		// TODO Auto-generated method stub
		if (obj instanceof TransmissionPack) {
			if (obj.getInformation() instanceof Deliveries) {

				Statement stmt1;
				ResultSet rs1;
				PreparedStatement pstmt;
				Deliveries deliveries = (Deliveries) obj.getInformation();
				String query = "INSERT INTO zerli.deliveries (deliveryID, orderID, branchID, customerID,price,orderDate, expectedDelivery, arrivedDate, receiverName, address, phoneNumber, status) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ? , ? , ? , ? , ? , ? );";

				try {
					// insert order to database
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, null);
					pstmt.setString(2, deliveries.getOrderID());
					pstmt.setString(3, deliveries.getBranchID());
					pstmt.setString(4, deliveries.getCustomerID());
					pstmt.setDouble(5, deliveries.getPrice());
					pstmt.setString(6, deliveries.getOrderDate());
					pstmt.setString(7, deliveries.getExpectedDelivery());
					pstmt.setString(8, "");
					pstmt.setString(9, deliveries.getReceiverName());
					pstmt.setString(10, deliveries.getAddress());
					pstmt.setString(11, deliveries.getPhoneNumber());
					pstmt.setString(12, deliveries.getDeliveryStatus().name());
					pstmt.executeUpdate();

					// get price and update after delivery
					String query2 = "SELECT price FROM zerli.order where orderID=" + deliveries.getOrderID() + ";";
					double previusPrice = 0;
					stmt1 = con.createStatement();
					rs1 = stmt1.executeQuery(query2);
					while (rs1.next()) {
						previusPrice = rs1.getDouble(1);
					}
					rs1.close();

					// update price in order with delivery
					String query3 = "UPDATE zerli.order SET price = (?) WHERE orderID = '" + deliveries.getOrderID()
							+ "' AND customerID = '" + deliveries.getCustomerID() + "' AND branchID = '"
							+ deliveries.getBranchID() + "';";
					pstmt = con.prepareStatement(query3);
					pstmt.setDouble(1, previusPrice + deliveries.getPrice());
					pstmt.executeUpdate();

				} catch (SQLException e) {
					obj.setResponse(Response.FAILD_ADD_DELIVERY);
					e.printStackTrace();
					return;
				} catch (NullPointerException e) {
					obj.setResponse(Response.FAILD_ADD_DELIVERY);
					e.printStackTrace();
					return;
				}
				obj.setResponse(Response.ADD_DELIVERY_SUCCEED);
				return;
			} else {
				obj.setResponse(Response.FAILD_ADD_DELIVERY);
			}
		}
	}

	/**
	 * get customer orders for cancellation process and products view of relevant
	 * orders
	 * 
	 * @param obj
	 * @param con
	 */
	public static void getCustomerOrdersCancelation(TransmissionPack obj, Connection con) {
		// TODO Auto-generated method stub

		if (obj instanceof TransmissionPack) {
			ResultSet rs, rs2;
			Statement stmt, stmt2;
			List<Order> orders = new ArrayList<>();
			String customerID;

			if (obj.getInformation() == null)
				throw new NullPointerException();
			else
				customerID = (String) obj.getInformation();

			String query = "SELECT * FROM zerli.order  WHERE (customerID = '" + customerID
					+ "') AND (status = 'PENDING') OR (status = 'PENDING_WITH_DELIVERY') OR (status = 'APPROVE_WITH_DELIVERY');";
			String query1 = "SELECT * FROM zerli.productinorder WHERE orderID='";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {

					Map<String, List<ProductInOrder>> products = new HashMap<>();

					stmt2 = con.createStatement();

					rs2 = stmt2.executeQuery(query1 + rs.getString(1) + "';");
					while (rs2.next()) {

						ProductInOrder newProduct = new ProductInOrder(rs2.getString(1), rs2.getString(2),
								rs2.getString(3), rs2.getDouble(4), rs2.getString(5), rs2.getString(6), rs2.getInt(7),
								rs2.getString(8), rs2.getString(9), rs2.getInt(10), rs2.getString(11), false, 0);
						if (!products.containsKey(rs2.getString(3))) {
							List<ProductInOrder> product = new ArrayList<>();
							product.add(newProduct);
							products.put(rs2.getString(3), product);
						} else {
							products.get(rs2.getString(3)).add(newProduct);
						}

					}
					rs2.close();

					Order order = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
							rs.getString(5), rs.getString(7), rs.getString(8), products);
					order.setStatus(OrderStatus.valueOf(rs.getString(6)));

					orders.add(order);
				}

				rs.close();
				System.out.println(orders);
				if (orders.size() > 0) {
					obj.setInformation(orders);
					obj.setResponse(Response.GET_CUSTOMER_ORDERS_SUCCESS);
					return;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				obj.setResponse(Response.GET_CUSTOMER_ORDERS_FAILD);
				return;
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				obj.setResponse(Response.GET_CUSTOMER_ORDERS_FAILD);
				return;
			}

		}
		obj.setResponse(Response.GET_CUSTOMER_ORDERS_FAILD);
	}

	/**
	 * get customer orders for history of orders and products view of relevant
	 * orders
	 * 
	 * @param obj
	 * @param con
	 */
	public static void getCustomerOrdersHistory(TransmissionPack obj, Connection con) {
		// TODO Auto-generated method stub

		if (obj instanceof TransmissionPack) {
			ResultSet rs, rs2;
			Statement stmt, stmt2;
			List<Order> orders = new ArrayList<>();
			String customerID;

			if (obj.getInformation() == null)
				throw new NullPointerException();
			else
				customerID = (String) obj.getInformation();

			String query = "SELECT * FROM zerli.order  WHERE (customerID = '" + customerID
					+ "') AND (status = 'ARRIVED') OR (status = 'APPROVE') OR (status = 'APPROVE_ORDER_CANCELATION') OR ('DECLINE_ORDER_CANCELATION') OR "
					+ " (status = 'APPROVE_ORDER_DELIVERY_CANCELATION') OR (status = 'DECLINE_ORDER_DELIVERY_CANCELATION') ;";
			String query1 = "SELECT * FROM zerli.productinorder WHERE orderID='";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {

					Map<String, List<ProductInOrder>> products = new HashMap<>();

					stmt2 = con.createStatement();

					rs2 = stmt2.executeQuery(query1 + rs.getString(1) + "';");
					while (rs2.next()) {

						ProductInOrder newProduct = new ProductInOrder(rs2.getString(1), rs2.getString(2),
								rs2.getString(3), rs2.getDouble(4), rs2.getString(5), rs2.getString(6), rs2.getInt(7),
								rs2.getString(8), rs2.getString(9), rs2.getInt(10), rs2.getString(11), false, 0);
						if (!products.containsKey(rs2.getString(3))) {
							List<ProductInOrder> product = new ArrayList<>();
							product.add(newProduct);
							products.put(rs2.getString(3), product);
						} else {
							products.get(rs2.getString(3)).add(newProduct);
						}

					}
					rs2.close();

					Order order = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
							rs.getString(5), rs.getString(7), rs.getString(8), products);
					order.setStatus(OrderStatus.valueOf(rs.getString(6)));

					orders.add(order);
				}

				rs.close();
				System.out.println(orders);
				if (orders.size() > 0) {
					obj.setInformation(orders);
					obj.setResponse(Response.GET_CUSTOMER_ORDERS_SUCCESS);
					return;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				obj.setResponse(Response.GET_CUSTOMER_ORDERS_FAILD);
				return;
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				obj.setResponse(Response.GET_CUSTOMER_ORDERS_FAILD);
				return;
			}

		}
		obj.setResponse(Response.GET_CUSTOMER_ORDERS_FAILD);
	}

	/**
	 * this method notify all customerService that still have OPEN complaint after
	 * 24 hours
	 * 
	 * @param obj
	 * @param con
	 */
//	public static void notifyCustomerService(TransmissionPack obj, Connection con) {
//		System.out.println("get to ->notifyCustomerService");
//		if (obj instanceof TransmissionPack) {
//			ResultSet rs;
//			Statement stmt;
//			String query = "SELECT complaintOpening FROM zerli.complaints WHERE status='OPEN'";
//			try {
//				if(con!=null) {
//				stmt = con.createStatement();
//				rs = stmt.executeQuery(query);
//				while (rs.next()) {
//					 if(getSatus(rs.getString(1))==ComplaintsStatus.DELAY) {
//					obj.setResponse(Response.NOTIFY_CUSTOMER_SERVICE);
//					System.out.println("here");
//					ServerUI.sv.notifyCustomer(obj);
//					 }
//
//				}
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//
//		} else {
//			obj.setResponse(null);
//		}
//	}

	/**
	 * update the order status in the DB
	 * 
	 * @param obj
	 * @param con
	 */
	@SuppressWarnings("unchecked")
	public static void updateOrder(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			List<Order> order = (List<Order>) obj.getInformation();
			Statement stmt;
			PreparedStatement pstmt;
			ResultSet rs;
			String updateOrderID = "UPDATE zerli.order SET status=? WHERE orderID='";
			String updateDeliveryStatus = "UPDATE zerli.deliveries SET status='READY_TO_GO' WHERE orderID='";
			String getRefund = "SELECT expectedRefund FROM zerli.cancelation WHERE orderID='";
			String updateCusomerBalance = "UPDATE zerli.customer SET balance=balance+? WHERE customerID='";
			String updateQuantityInAllZerLi = "UPDATE zerli.product SET quantity=quantity-? WHERE productID='";
			String updateQuantityInBranch = "UPDATE zerli.productinbranch SET quantity=quantity-? WHERE productID='";
			String deleteProductformOrder = "DELETE FROM zerli.productinorder WHERE orderID='";
			String deleteProductformDelivery = "DELETE FROM zerli.deliveries WHERE orderID='";

			for (Order o : order) {
				try {
					switch (o.getStatus()) {
					case APPROVE: {
						updateOrderIDStatus(con, updateOrderID, o);
						/**
						 * loop run on all the product in the specific order
						 */
						updateProducts(con, updateQuantityInAllZerLi, updateQuantityInBranch, o);
						break;
					}
					case APPROVE_WITH_DELIVERY: {
						updateDelivryStatusToReadyToGo(con, updateDeliveryStatus, o);
						updateOrderIDStatus(con, updateOrderID, o);
						updateProducts(con, updateQuantityInAllZerLi, updateQuantityInBranch, o);
						break;
					}
					case CANCEL_WITH_DELIVERY: {
						deleteDelivery(con, deleteProductformDelivery, o);
						updateOrderIDStatus(con, updateOrderID, o);
						break;
					}

					case CANCEL: {
						updateOrderIDStatus(con, updateOrderID, o);
						deleteProductInOrder(con, deleteProductformOrder, o);
						break;
					}
					case DECLINE_ORDER_CANCELATION: {
						updateOrderIDStatus(con, updateOrderID, o);
						/**
						 * loop run on all the product in the specific order
						 */
						updateProducts(con, updateQuantityInAllZerLi, updateQuantityInBranch, o);
						break;
					}
					case DECLINE_ORDER_DELIVERY_CANCELATION: {
						updateDelivryStatus(con, updateDeliveryStatus, o);
						updateOrderIDStatus(con, updateOrderID, o);
						updateProducts(con, updateQuantityInAllZerLi, updateQuantityInBranch, o);
						break;
					}
					case APPROVE_ORDER_DELIVERY_CANCELATION: {
						updateOrderIDStatus(con, updateOrderID, o);
						updateCustomerBalance(con, getRefund, updateCusomerBalance, o);
						deleteDelivery(con, deleteProductformDelivery, o);
						deleteProductInOrder(con, deleteProductformOrder, o);
						break;
					}
					case APPROVE_ORDER_CANCELATION: {
						updateCustomerBalance(con, getRefund, updateCusomerBalance, o);
						updateOrderIDStatus(con, updateOrderID, o);
						deleteProductInOrder(con, deleteProductformOrder, o);

						break;
					}
					default:
						break;
					}
				} catch (SQLException e) {
					obj.setResponse(Response.UPDATE_ORDER_FAILED);
					e.printStackTrace();
				}

			}
			obj.setResponse(Response.UPDATE_ORDER_SUCCEED);
		} else {
			obj.setResponse(Response.UPDATE_ORDER_FAILED);
		}

	}

	/**
	 * this method get all customers details that there order were cancel or approve
	 * 
	 * @param obj
	 * @param con
	 */
	public static void getCustomerDetailsForNotify(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			List<List<String>> cutomers = (List<List<String>>) obj.getInformation();
			List<List<User>> cutomersCallBack = new ArrayList<>();
			Statement stmt;
			for (List<String> list : cutomers) {
				List<User> users = new ArrayList<>();
				for (String detail : list) {
					try {
						stmt = con.createStatement();
						ResultSet rs;
						String getDetails = "SELECT firstName, email, phoneNumber FROM zerli.customer WHERE customerID='"
								+ detail + "';";
						rs = stmt.executeQuery(getDetails);
						while (rs.next() != false) {
							User u = new User(null, rs.getString(1), null, rs.getString(2), rs.getString(3), null,
									false);
							users.add(u);
						}
						rs.close();
					} catch (SQLException e) {
						obj.setResponse(Response.GET_ALL_CUTOMERS_TO_NOTIFIY_FAILED);
						e.printStackTrace();
					}
					System.out.println(users);
				}
				cutomersCallBack.add(users);
			}
			obj.setInformation(cutomersCallBack);
			obj.setResponse(Response.GET_ALL_CUTOMERS_TO_NOTIFIY_SUCCEED);

		} else {
			obj.setResponse(Response.GET_ALL_CUTOMERS_TO_NOTIFIY_FAILED);
		}
	}

	/**
	 * update the customer balance if the specific customer cancel request was
	 * approve and he is deserves it
	 * 
	 * @param con
	 * @param getRefund
	 * @param updateCusomerBalance
	 * @param o
	 * @throws SQLException
	 */
	private static void updateCustomerBalance(Connection con, String getRefund, String updateCusomerBalance, Order o)
			throws SQLException {
		Statement stmt;
		PreparedStatement pstmt;
		ResultSet rs;
		stmt = con.createStatement();
		rs = stmt.executeQuery(getRefund + o.getOrderID() + "'");
		while (rs.next()) {
			pstmt = con.prepareStatement(updateCusomerBalance + o.getCustomerID() + "'");
			pstmt.setString(1, rs.getString(1));
			pstmt.executeUpdate();
		}
	}

	/**
	 * update the delivery status if the status was change from pending to cancel
	 * 
	 * @param con
	 * @param updateDeliveryStatus
	 * @param o
	 * @throws SQLException
	 */
	private static void updateDelivryStatus(Connection con, String updateDeliveryStatus, Order o) throws SQLException {
		PreparedStatement pstmt1;

		pstmt1 = con.prepareStatement(updateDeliveryStatus + o.getOrderID() + "'");
		pstmt1.setString(1, o.getStatus().name());
		pstmt1.executeUpdate();
	}

	/**
	 * if the order delivery was approve it change his status to ready to go for the
	 * delivery agent
	 * 
	 * @param con
	 * @param updateDeliveryStatus
	 * @param o
	 * @throws SQLException
	 */
	private static void updateDelivryStatusToReadyToGo(Connection con, String updateDeliveryStatus, Order o)
			throws SQLException {
		PreparedStatement pstmt1;

		pstmt1 = con.prepareStatement(updateDeliveryStatus + o.getOrderID() + "'");

		pstmt1.executeUpdate();
	}

	/**
	 * Update the orders quantity if the orders was approve it update the product
	 * quantity
	 * 
	 * @param con
	 * @param updateQuantityInAllZerLi
	 * @param updateQuantityInBranch
	 * @param o
	 * @throws SQLException
	 */
	private static void updateProducts(Connection con, String updateQuantityInAllZerLi, String updateQuantityInBranch,
			Order o) throws SQLException {
		for (String key : o.getItems().keySet()) {
			for (ProductInOrder p : o.getItems().get(key)) {
				updateProductQuentity(con, updateQuantityInAllZerLi, p);
				updateProductQuentity(con, updateQuantityInBranch, p);
			}
		}
	}

	/**
	 * if the delivery request wasn't approve it delete the specific order from the
	 * the delivery table
	 * 
	 * @param con
	 * @param deleteProductformDelivery
	 * @param o
	 * @throws SQLException
	 */
	private static void deleteDelivery(Connection con, String deleteProductformDelivery, Order o) throws SQLException {
		PreparedStatement pstmt3;
		pstmt3 = con.prepareStatement(deleteProductformDelivery + o.getOrderID() + "'");
		pstmt3.executeUpdate();
	}

	/**
	 * delete the product form the order if the branch meager cancel the customer
	 * order
	 * 
	 * @param con
	 * @param query3
	 * @param o
	 * @throws SQLException
	 */
	private static void deleteProductInOrder(Connection con, String query3, Order o) throws SQLException {
		deleteDelivery(con, query3, o);
	}

	/**
	 * update quantity in the relevant table if the branch manager approve the order
	 * 
	 * @param con
	 * @param query2
	 * @param p
	 * @throws SQLException
	 */
	private static void updateProductQuentity(Connection con, String query2, ProductInOrder p) throws SQLException {
		PreparedStatement pstmt2;
		pstmt2 = con.prepareStatement(query2 + p.getID() + "'");
		pstmt2.setInt(1, p.getProductQuantityInCart());
		pstmt2.executeUpdate();
	}

	/**
	 * update the order status according to the branch manager decision
	 * 
	 * @param con
	 * @param query
	 * @param o
	 * @throws SQLException
	 */
	private static void updateOrderIDStatus(Connection con, String query, Order o) throws SQLException {
		updateDelivryStatus(con, query, o);
	}

	public static void getSurvyQuestions(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			Statement stmt;
			ResultSet rs;
			List<Question> questions = new ArrayList<>();
			String topic = (String) obj.getInformation();
			String getquestion = "SELECT * FROM zerli.surveyquestions WHERE topic='" + topic + "'";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(getquestion);
				while (rs.next()) {
					Question question = new Question(rs.getString(1), rs.getInt(2), rs.getString(3));
					questions.add(question);
				}
				System.out.println(questions);
				rs.close();
				if (questions.size() > 0) {
					System.out.println("here question query");
					obj.setInformation(questions);
					obj.setResponse(Response.GET_SURVY_QUESTION_SUCCEED);
				} else {
					obj.setResponse(Response.GET_SURVY_QUESTION_FAILED);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			obj.setResponse(Response.GET_SURVY_QUESTION_FAILED);
		}

	}

	/**
	 * inert the survey result of the specific survey
	 * 
	 * @param obj
	 * @param con
	 */
	@SuppressWarnings("unchecked")
	public static void insertSurvy(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			List<Question> questions = (List<Question>) obj.getInformation();

			String query = "INSERT INTO zerli.surveys(surveysresultsID, branchID, topic, questionNumber1, questionNumber2, questionNumber3, questionNumber4, questionNumber5, questionNumber6, answerNumber1, answerNumber2, answerNumber3, answerNumber4, answerNumber5, answerNumber6, targetAudience, date) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {

				insertSurveyResult(con, questions, query);
				obj.setResponse(Response.ISERT_SURVEY_SUCCEED);

			} catch (SQLException e) {
				obj.setResponse(Response.ISERT_SURVEY_FAILED);
				e.printStackTrace();
			}

		} else {
			obj.setResponse(Response.ISERT_SURVEY_FAILED);
		}

	}

	/**
	 * insert all the survey to the DB
	 * 
	 * @param con
	 * @param questions
	 * @param query
	 * @throws SQLException
	 */
	private static void insertSurveyResult(Connection con, List<Question> questions, String query) throws SQLException {
		PreparedStatement pstmt;
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, null);
		pstmt.setString(2, questions.get(0).getBranchID());
		pstmt.setString(3, questions.get(0).getTopic());

		pstmt.setInt(4, questions.get(0).getQuestionNumber());
		pstmt.setInt(5, questions.get(1).getQuestionNumber());
		pstmt.setInt(6, questions.get(2).getQuestionNumber());
		pstmt.setInt(7, questions.get(3).getQuestionNumber());
		pstmt.setInt(8, questions.get(4).getQuestionNumber());
		pstmt.setInt(9, questions.get(5).getQuestionNumber());
		pstmt.setInt(10, questions.get(0).getAnswer());
		pstmt.setInt(11, questions.get(1).getAnswer());
		pstmt.setInt(12, questions.get(2).getAnswer());
		pstmt.setInt(13, questions.get(3).getAnswer());
		pstmt.setInt(14, questions.get(4).getAnswer());
		pstmt.setInt(15, questions.get(5).getAnswer());
		pstmt.setString(16, questions.get(0).getTargetAudience());
		pstmt.setString(17, questions.get(0).getDate());
		pstmt.executeUpdate();
	}

	public static void GetDeliveriesFromDB(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			String branchID = (String) obj.getInformation();
			List<Deliveries> deliveries = new ArrayList<>();
			List<ProductInOrder> orderProducts = null;
			Statement stmt1, stmt2;
			try {
				stmt1 = con.createStatement();
				ResultSet rs1, rs2;
				String getDeliveries = "SELECT * FROM zerli.deliveries WHERE status = 'READY_TO_GO' AND branchID ='"
						+ branchID + "';";
				rs1 = stmt1.executeQuery(getDeliveries);
				while (rs1.next()) {
					// nameOfproduct, productQuantityInOrder, price
					Deliveries delivery = new Deliveries(rs1.getInt(1), rs1.getString(2), rs1.getString(3),
							rs1.getString(4), rs1.getDouble(5), rs1.getString(6), rs1.getString(7), rs1.getString(8),
							rs1.getString(9), rs1.getString(10), rs1.getString(11),
							DeliveryStatus.valueOf(rs1.getString(12)), null);
					deliveries.add(delivery);
					String getProductsInOrder = "SELECT * FROM zerli.productInOrder WHERE orderID = '"
							+ rs1.getString(2) + "';";
					System.out.println(getProductsInOrder);
					stmt2 = con.createStatement();
					rs2 = stmt2.executeQuery(getProductsInOrder);
					orderProducts = new ArrayList<>();
					while (rs2.next()) {
						ProductInOrder p = new ProductInOrder(rs2.getString(1), rs2.getString(2), rs2.getString(3),
								rs2.getDouble(4), rs2.getString(5), rs2.getString(6), rs2.getInt(7), rs2.getString(8),
								rs2.getString(9), rs2.getInt(10), rs2.getString(11), false, 0);
						System.out.println(p);
						orderProducts.add(p);
						delivery.setOrderProducts(orderProducts);
						System.out.println(orderProducts);
					}
					rs2.close();
				}
				rs1.close();
				obj.setInformation(deliveries);
				System.out.println(deliveries);
				obj.setResponse(Response.FOUND_DELIVERIES);
				return;
			} catch (Exception e) {
				e.printStackTrace();
				obj.setResponse(Response.NOT_FOUND_DELIVERIES);
				return;
			}
		}
		obj.setResponse(Response.NOT_FOUND_DELIVERIES);
	}

	@SuppressWarnings("unchecked")
	public static void UpdateDeliveriesStatusesInDB(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			List<Deliveries> deliveries = (List<Deliveries>) obj.getInformation();
			try {
				for (Deliveries d : deliveries) {
					System.out.println(d);
					String updateStatuses = "UPDATE zerli.deliveries SET status=?, arrivedDate =? WHERE deliveryID='"
							+ d.getDeliveryID() + "';";
					String updateOrderArrived = "UPDATE zerli.order SET status=? WHERE orderID='" + d.getOrderID()
							+ "';";
					// if (d.getDeliveryStatus() == DeliveryStatus.ARRIVED) {
					PreparedStatement pstmt1 = con.prepareStatement(updateStatuses);
					pstmt1.setString(1, d.getDeliveryStatus().name());
					pstmt1.setString(2, d.getArrivedDate());
					pstmt1.executeUpdate(); // check if the query failed

					PreparedStatement pstmt2 = con.prepareStatement(updateOrderArrived);
					pstmt2.setString(1, d.getDeliveryStatus().name());
					pstmt2.executeUpdate(); // check if the query failed

				}
				obj.setResponse(Response.UPDATE_DELIVERIES_STATUS_SUCCESS);
			} catch (Exception e) {
				obj.setResponse(Response.UPDATE_DELIVERIES_STATUS_FAILED);
				e.printStackTrace();
				return;
			}
		} else {
			obj.setResponse(Response.UPDATE_DELIVERIES_STATUS_FAILED);
			return;
		}
	}

	/**
	 * request to cancel order by user , create cancellation and update order status
	 * to CANCEL_ORDER_BY_CUSTOMER
	 * 
	 * @param obj
	 * @param con
	 */
	public static void cancelOrderByCustomer(TransmissionPack obj, Connection con) {
		// TODO Auto-generated method stub
		if (obj instanceof TransmissionPack) {
			if (obj.getInformation() instanceof Cancellation) {
				PreparedStatement pstmt;
				// Cancellation -> CancelationID, OrderID , CustomerID , expectedRefund
				Cancellation info = (Cancellation) obj.getInformation();
				String query = "UPDATE zerli.order SET status = ? WHERE orderID = ?;";
				String query2 = "INSERT INTO zerli.cancelation (CancelationID, orderID,customerID,expectedRefund) VALUES (?,?,?,?);";

				try {
					// update order status
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, info.getStatus().name());
					pstmt.setString(2, info.getOrderID());

					pstmt.executeUpdate();

					// refund information setup
					pstmt = con.prepareStatement(query2);
					pstmt.setString(1, null);
					pstmt.setString(2, info.getOrderID());
					pstmt.setString(3, info.getCustomerID());
					pstmt.setDouble(4, info.getExpectedRefund());
					pstmt.executeUpdate();

				} catch (SQLException e) {
					obj.setResponse(Response.CANCEL_ORDER_BY_CUSTOMER_FAILD);
					e.printStackTrace();
					return;
				}
				obj.setResponse(Response.CANCEL_ORDER_BY_CUSTOMER_SUCCESS);
				return;
			} else {
				obj.setResponse(Response.CANCEL_ORDER_BY_CUSTOMER_FAILD);
			}
		}

	}

	// get order on cancellation waiting progress - CANCEL_ORDER_BY_CUSTOMER.

	public static void UpdateDeliveryWasLateDB(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			Deliveries deliveries = (Deliveries) obj.getInformation();
			Statement stmt;
			double currentBalance, newBalance;
			String currBalance = null, getCurrentBalance, updateRefundTable;
			try {
				stmt = con.createStatement();
				ResultSet rs;
				/*
				 * get the current balance of the customer that we will be able to update it
				 * correct
				 */
				getCurrentBalance = "SELECT balance FROM zerli.customer WHERE customerID='" + deliveries.getCustomerID()
						+ "';";
				System.out.println("query 1: " + getCurrentBalance);
				rs = stmt.executeQuery(getCurrentBalance);
				while (rs.next()) {
					currBalance = rs.getString(1); /* the current balance of the customer */
					System.out.println(currBalance);
				}
				rs.close();
				currentBalance = Double.parseDouble(currBalance); /* parse the current balance to double */
				System.out.println(currentBalance);
				newBalance = currentBalance + deliveries.getPrice(); /* the real new balance of the customer */
				System.out.println(newBalance);
				/**
				 * Update the customer table - add the amount of the refund to the balance of
				 * the specific customer
				 */
				DeliveryLateRefundBalance(con, deliveries, newBalance);
				/**
				 * Update refund table with the refund details
				 */
				updateRefundsTable(con, deliveries);
				obj.setResponse(Response.UPDATE_DELIVERY_LATE_REFUND_SUCCESS);
				return;
			} catch (Exception e) {
				e.printStackTrace();
				obj.setResponse(Response.UPDATE_DELIVERY_LATE_REFUND_FAILED);
				return;
			}
		} else {
			obj.setResponse(Response.UPDATE_DELIVERY_LATE_REFUND_FAILED);
			return;
		}
	}

	private static void updateRefundsTable(Connection con, Deliveries deliveries) throws SQLException {
		String updateRefundTable;
		updateRefundTable = "INSERT INTO zerli.refunds(refundID, orderID, customerID, ammount, reason, date)VALUES(?,?,?,?,?,?);";
		PreparedStatement pstmt = con.prepareStatement(updateRefundTable);
		pstmt.setString(1, null);
		pstmt.setString(2, deliveries.getOrderID());
		pstmt.setString(3, deliveries.getCustomerID());
		pstmt.setString(4, String.valueOf(deliveries.getPrice()));
		pstmt.setString(5, "Delivery");
		Calendar c = Calendar.getInstance();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(c.getTimeInMillis());
		pstmt.setTimestamp(6, timestamp);
		pstmt.executeUpdate();
	}

	private static void DeliveryLateRefundBalance(Connection con, Deliveries deliveries, double newBalance)
			throws SQLException {
		String giveRefund;
		giveRefund = "UPDATE zerli.customer SET balance=(?) WHERE customerID='" + deliveries.getCustomerID() + "';";
		System.out.println("query 2: " + giveRefund);

		PreparedStatement pstmt = con.prepareStatement(giveRefund);
		pstmt.setString(1, String.valueOf(newBalance));
		pstmt.executeUpdate();
	}

	public static void getCustomerDetailsFromDB(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			String customerID = (String) obj.getInformation();
			System.out.println(customerID);
			List<String> details = new ArrayList<>();
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs;
				String getDetails = "SELECT firstName, email, phoneNumber FROM zerli.customer WHERE customerID='"
						+ customerID + "';";
				rs = stmt.executeQuery(getDetails);
				while (rs.next() != false) {
					details.add(rs.getString(1));
					details.add(rs.getString(2));
					details.add(rs.getString(3));
				}
				rs.close();
				System.out.println(details);
				obj.setInformation(details);
				obj.setResponse(Response.GET_CUSTOMER_DETAILS_SUCCESS);
				return;
			} catch (Exception e) {
				e.printStackTrace();
				obj.setResponse(Response.GET_CUSTOMER_DETAILS_FAILED);
				return;
			}
		} else {
			obj.setResponse(Response.GET_CUSTOMER_DETAILS_FAILED);
		}
	}

	/**
	 * Get the highest ID from the products we have.
	 * 
	 * 
	 * @param obj
	 * @param con
	 */

	public static void getCustomerOrdersCancelationWaiting(TransmissionPack obj, Connection con) {
		// TODO Auto-generated method stub
		if (obj instanceof TransmissionPack) {
			ResultSet rs, rs2;
			Statement stmt, stmt2;
			List<Order> orders = new ArrayList<>();
			String customerID;

			if (obj.getInformation() == null)
				throw new NullPointerException();
			else
				customerID = (String) obj.getInformation();

			String query = "SELECT * FROM zerli.order  WHERE (customerID = '" + customerID
					+ "') AND (status = 'CANCEL_ORDER_BY_CUSTOMER');";
			String query1 = "SELECT * FROM zerli.productinorder WHERE orderID='";
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {

					Map<String, List<ProductInOrder>> products = new HashMap<>();

					stmt2 = con.createStatement();

					rs2 = stmt2.executeQuery(query1 + rs.getString(1) + "';");
					while (rs2.next()) {

						ProductInOrder newProduct = new ProductInOrder(rs2.getString(1), rs2.getString(2),
								rs2.getString(3), rs2.getDouble(4), rs2.getString(5), rs2.getString(6), rs2.getInt(7),
								rs2.getString(8), rs2.getString(9), rs2.getInt(10), rs2.getString(11), false, 0);
						if (!products.containsKey(rs2.getString(3))) {
							List<ProductInOrder> product = new ArrayList<>();
							product.add(newProduct);
							products.put(rs2.getString(3), product);
						} else {
							products.get(rs2.getString(3)).add(newProduct);
						}

					}
					rs2.close();

					Order order = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
							rs.getString(5), rs.getString(7), rs.getString(8), products);
					order.setStatus(OrderStatus.valueOf(rs.getString(6)));

					orders.add(order);
				}

				rs.close();
				System.out.println(orders);
				if (orders.size() > 0) {
					obj.setInformation(orders);
					obj.setResponse(Response.GET_CUSTOMER_ORDERS_SUCCESS);
					return;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				obj.setResponse(Response.GET_CUSTOMER_ORDERS_FAILD);
				return;
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				obj.setResponse(Response.GET_CUSTOMER_ORDERS_FAILD);
				return;
			}

		}
		obj.setResponse(Response.GET_CUSTOMER_ORDERS_FAILD);
	}

	public static void getMaxProductIDFromDB(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			String maxID = null;
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs;
				String getMaxID = "SELECT MAX(CAST(productID AS SIGNED)) FROM zerli.product;";
				rs = stmt.executeQuery(getMaxID);
				if (rs.next()) {
					maxID = rs.getString(1);
				}
				rs.close();
				System.out.println(maxID);
				obj.setInformation(maxID);
				obj.setResponse(Response.GET_MAX_PRODUCT_ID_SUCCESS);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
				obj.setResponse(Response.GET_MAX_PRODUCT_ID_FAILED);
				return;
			}
		}
		obj.setResponse(Response.GET_MAX_PRODUCT_ID_FAILED);
	}

	/**
	 * in this method we editing an exist proudct on the catalog by his id
	 * 
	 * @param obj
	 * @param con
	 */
	@SuppressWarnings("unchecked")
	public static void marketingWorkerEditCatalog(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			List<Product> productsToAdd = new ArrayList<>();
			productsToAdd = (List<Product>) obj.getInformation();
			int countRemoving = 0;
			try {
				for (int i = 0; i < productsToAdd.size(); i++) {
					String updateStatuses = "UPDATE zerli.product SET name=(?), price =(?), backGroundColor=(?), picture=(?), quantity=(?), itemType=(?), dominateColor=(?), isOnSale=(?), fixPrice=(?) WHERE productID='"
							+ productsToAdd.get(i).getID() + "';";

					PreparedStatement pstmt = con.prepareStatement(updateStatuses);
					pstmt.setString(1, productsToAdd.get(i).getName());
					pstmt.setDouble(2, productsToAdd.get(i).getPrice());
					pstmt.setString(3, productsToAdd.get(i).getbackGroundColor());
					pstmt.setString(4, productsToAdd.get(i).getImgSrc());
					pstmt.setInt(5, productsToAdd.get(i).getQuantity());
					pstmt.setString(6, productsToAdd.get(i).getItemType());
					pstmt.setString(7, productsToAdd.get(i).getDominateColor());
					pstmt.setBoolean(8, productsToAdd.get(i).getIsOnSale());
					pstmt.setDouble(9, productsToAdd.get(i).getFixPrice());
					if (pstmt.executeUpdate() != 0) {
						countRemoving++;
					}
					if (countRemoving == productsToAdd.size()) {
						obj.setResponse(Response.EDIT_PRODUCTS_ON_THE_CATALOG_SUCCESS);
						return;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				obj.setResponse(Response.EDIT_PRODUCTS_ON_THE_CATALOG_FAILED);
				return;
			}
		} else {
			obj.setResponse(Response.EDIT_PRODUCTS_ON_THE_CATALOG_FAILED);
		}

	}

	/**
	 * in this method we remove the items that the marketingworker send to us ,by
	 * the product id.
	 * 
	 * @param obj
	 * @param con
	 */
	@SuppressWarnings("unchecked")
	public static void marketingWorkerRemoveFromCatalog(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			List<String> productsToRemove = new ArrayList<>();
			productsToRemove = (List<String>) obj.getInformation();
			int removeSucess = 0;
			try {
				for (int i = 0; i < productsToRemove.size(); i++) {
					PreparedStatement st = con.prepareStatement("DELETE FROM zerli.product WHERE productID= ?");
					st.setString(1, productsToRemove.get(i));
					if (st.executeUpdate() != 0) {
						removeSucess++;
					}
					if (removeSucess == productsToRemove.size()) {
						obj.setResponse(Response.REMOVE_FROM_THE_CATALOG_SUCCESS);
						return;
					}

					obj.setResponse(Response.REMOVE_FROM_THE_CATALOG_FAILED);
					return;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				obj.setResponse(Response.REMOVE_FROM_THE_CATALOG_FAILED);
				return;
			}
		} else {
			obj.setResponse(Response.REMOVE_FROM_THE_CATALOG_FAILED);
		}

	}

	/**
	 * in this method we adding new products into the catalog, we getting them on
	 * list of products and, adding one by one.
	 * 
	 * @param obj
	 * @param con
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public static void marketingWorkerAddToCatalog(TransmissionPack obj, Connection con) {
		if (obj instanceof TransmissionPack) {
			List<Product> productsToAdd = new ArrayList<>();
			productsToAdd = (List<Product>) obj.getInformation();
			int countInseration = 0;
			String insertNewItem = "INSERT INTO zerli.product(productID, name, price, backGroundColor, picture, quantity, itemType, dominateColor, isOnSale, fixPrice)VALUES(?,?,?,?,?,?,?,?,?,?);";
			try {
				for (int i = 0; i < productsToAdd.size(); i++) {
					PreparedStatement pstmt;
					pstmt = con.prepareStatement(insertNewItem);
					pstmt.setString(1, productsToAdd.get(i).getID());
					pstmt.setString(2, productsToAdd.get(i).getName());
					pstmt.setDouble(3, productsToAdd.get(i).getPrice());
					pstmt.setString(4, productsToAdd.get(i).getbackGroundColor());
					pstmt.setString(5, productsToAdd.get(i).getImgSrc());
					pstmt.setInt(6, productsToAdd.get(i).getQuantity());
					pstmt.setString(7, productsToAdd.get(i).getItemType());
					pstmt.setString(8, productsToAdd.get(i).getDominateColor());
					pstmt.setBoolean(9, productsToAdd.get(i).getIsOnSale());
					pstmt.setDouble(10, productsToAdd.get(i).getFixPrice());
					if (pstmt.executeUpdate() != 0) {
						countInseration++;
						System.out.println(productsToAdd.get(i));
					}
					if (countInseration == productsToAdd.size()) {
						obj.setResponse(Response.ADDING_TO_THE_CATALOG_SUCCESS);
						return;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				obj.setResponse(Response.ADDING_TO_THE_CATALOG_FAILED);
				return;
			}
		} else {
			obj.setResponse(Response.ADDING_TO_THE_CATALOG_FAILED);
		}

	}

}
