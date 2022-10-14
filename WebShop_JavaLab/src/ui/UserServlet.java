package ui;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import bo.CartHandler;
import bo.Item;
import bo.ItemHandler;
import bo.User;
import bo.UserHandler;
import db.ItemDB;
import db.UserDB;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //private UserDB userDB = new UserDB();
	private UserHandler userHandler = new UserHandler();
	private ItemHandler itemHandler;
	private CartHandler cartHandler = new CartHandler();
	private static int userId;
	private static int cartId;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		switch(action) {
			case "/register":
				registerUser(request,response);
				break;
			case "/login":
			try {
				loginUser(request,response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case "/listItems":
			try {
				listItems(request,response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
				
			case "/buy":
				try {
					buy(request,response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/add":
			try {
				itemChoosen(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case "/addToCart":
			try {
				addToCart(request,response);
			} catch (ClassNotFoundException | IOException | SQLException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case "/shoppingCart":
			try {
				shoppingCart(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			default:
				break;
		}
	}

	private void shoppingCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		CartInfo cartInfo = cartHandler.getCartItems(cartId);
		ArrayList<Item> items = cartInfo.getItemList();
		request.setAttribute("items", items);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shoppingCart.jsp");
	    dispatcher.forward(request, response);
	     
		
	}

	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
		
		int subCount = Integer.parseInt(request.getParameter("amount"));
		int itemId = Integer.parseInt(request.getParameter("id"));
		int count = Integer.parseInt(request.getParameter("count"));
		
		int newCount = count - subCount;
		
		if(newCount >= 0){
			itemHandler.updateItem(itemId,newCount);
			itemHandler.getItem(itemId);
			cartHandler.updateCart(itemId,subCount,userId,cartId);
			
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("NoMore.jsp");
			dispatcher.forward(request, response);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("buy.jsp");
		buy(request,response);
		dispatcher.forward(request, response);
	}

	private void itemChoosen(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		ItemInfo itemInfo = itemHandler.getItem(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addToCart.jsp");
        request.setAttribute("itemToCart", itemInfo);
        dispatcher.forward(request, response);
       
		
	}

	private void buy(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		ArrayList<ItemInfo> items = itemHandler.getItems();
		request.setAttribute("items", items);
        RequestDispatcher dispatcher = request.getRequestDispatcher("buy.jsp");
        dispatcher.forward(request, response);
	}
	

	private void listItems(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		ArrayList<ItemInfo> items = itemHandler.getItems();
		request.setAttribute("items", items);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listItems.jsp");
        dispatcher.forward(request, response);
		
	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException {
		
		String userName = request.getParameter("user_name");
		String userPassword = request.getParameter("user_password");
		UserInfo userInfo = new UserInfo(userName,userPassword);
		userId=userHandler.loginUser(userInfo);
		cartId=cartHandler.loginCart(userId);
		
		if(userId != 0) {
			response.sendRedirect("inside.jsp");
			
			return;
		}else {
			System.out.println("FALSE");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}
	
	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String userName = request.getParameter("user_name");
		String userPassword = request.getParameter("user_password");
		UserInfo userInfo = new UserInfo(userName,userPassword);
		
		try {
			userHandler.registerUser(userInfo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
