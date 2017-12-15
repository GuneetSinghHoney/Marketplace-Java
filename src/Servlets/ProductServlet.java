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
		request.setAttribute("flag", "F");
		obj = database.getInstance().getProducts();
		
		request.setAttribute("products", obj.getAll());
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		HttpSession session =  request.getSession();
		ArrayList<Integer> arr;
		
		request.setAttribute("flag", "T");
		
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
		try {
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println(id);
		 if(!arr.contains(id))
			 	arr.add(id);
		}catch(Exception e)
		{
			
		}
		doGet(request, response);
	}

}
