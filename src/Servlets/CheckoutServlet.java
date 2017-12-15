package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Product;
import DAO.ProductArrayDAO;
import DAO.database;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher disp = request.getRequestDispatcher("checkout.jsp");
		disp.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 
		ProductArrayDAO products = database.getInstance().getProducts();
		ArrayList<Integer> arr = (ArrayList<Integer>)request.getSession().getAttribute("cart");

		System.out.println(arr.size());
		for(int i=0;i<arr.size();i++)
		{
			System.out.println("hello");
			Product p= products.getProduct(arr.get(i));
			int quantity = Integer.parseInt(request.getParameter(arr.get(i)+""));
			quantity = p.getNumberInstock()-quantity;
			System.out.println(quantity);
			if(quantity==0)
			{

			p.setAvailable(false);
					
			}
		 
			p.setNumberInstock(quantity);
			
			 
			request.getSession().setAttribute("cart", null);
			response.sendRedirect("base");
			
		}
	}

}
