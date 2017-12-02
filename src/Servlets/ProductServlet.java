package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductArrayDAO;
import DAO.database;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/base")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductArrayDAO obj;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher disp = request.getRequestDispatcher("products.jsp");
		obj = database.getInstance().getProducts();
		
		request.setAttribute("products", obj.getAll());
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session =  request.getSession();
		ArrayList<Integer> arr;
		try {
		arr = (ArrayList<Integer>)session.getAttribute("cart");
		if(arr==null)
		{
			arr = new ArrayList<>();
			session.setAttribute("cart", arr);
		}
	 
		}
		catch(Exception e)
		{
			arr = new ArrayList<>();
			session.setAttribute("cart", arr);
		}
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		 if(!arr.contains(id)&&id!=4)
			 	arr.add(id);
		 
		doGet(request, response);
	}

}
