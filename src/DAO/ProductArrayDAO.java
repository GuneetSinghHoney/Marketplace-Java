/**
 * 
 */
package DAO;

import java.util.ArrayList;

/**
 * Main DAO
 *
 */
public class ProductArrayDAO implements ProductDAOInterface {

	static ArrayList<Product> products;
	
	/* (non-Javadoc)
	 * @see DAO.ProductDAOInterface#addProduct(java.lang.String, java.lang.String, int, double, boolean)
	 */
	@Override
	public synchronized int addProduct(String name, String SKU, String Description, int numberInstock, double unitPrice, boolean available) {
		int id = products.size();
		Product obj = new Product(name, SKU,Description,numberInstock,unitPrice,available,id);
		products.add(obj);
		return 0;
	}

	/* (non-Javadoc)
	 * @see DAO.ProductDAOInterface#buyProduct(int)
	 */
	@Override
	public boolean buyProduct(int id) {
		for(Product p:products)
		{
			if(p.getId()==id)
			{
				p.setNumberInstock(p.getNumberInstock()-1);
				return true;
			}
		}
		return false;
	}

	public ProductArrayDAO() {
		products = new ArrayList<>();
	}

	/* (non-Javadoc)
	 * @see DAO.ProductDAOInterface#changeAvailability(int, boolean)
	 */
	@Override
	public boolean changeAvailability(int id, boolean avail) {
		
		for(Product p:products)
		{
			if(p.getId()==id)
			{
				p.setAvailable(!p.isAvailable());
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see DAO.ProductDAOInterface#changeSKU(int, java.lang.String)
	 */
	@Override
	public boolean changeSKU(int id, String SKU) {
		
		for(Product p:products)
		{
			if(p.getId()==id)
			{
				p.setSKU(SKU);
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see DAO.ProductDAOInterface#changeDescription(int, java.lang.String)
	 */
	@Override
	public boolean changeDescription(int id, String desc) {
		
		for(Product p:products)
		{
			if(p.getId()==id)
			{
				p.setDescription(desc);
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see DAO.ProductDAOInterface#changeNumberInStock(int, int)
	 */
	@Override
	public boolean changeNumberInStock(int id, int stock) {
	
		for(Product p:products)
		{
			if(p.getId()==id)
			{
				p.setNumberInstock(stock);
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see DAO.ProductDAOInterface#changeUnitPrice(int, double)
	 */
	@Override
	public boolean changeUnitPrice(int id, double price) {
	
		for(Product p:products)
		{
			if(p.getId()==id)
			{
				p.setUnitPrice(price);
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see DAO.ProductDAOInterface#deleteProduct(int)
	 */
	@Override
	public boolean deleteProduct(int id)
	{

		for(Product p:products)
		{
			if(p.getId()==id)
			{
				return products.remove(p);
				
			}
		}
		return false;
	}

	@Override
	public Product getProduct(int id) {
	
		for(Product p:products)
		{
			if(p.getId()==id)
			{
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean changeProductName(int id, String name) {
		
		for(Product p:products)
		{
			if(p.getId()==id)
			{
				p.setName(name);
			}
		}
		return false;
	}

	@Override
	public ArrayList<Product> find(String name)
	{
	
		ArrayList<Product> x = new ArrayList<>();
		for(Product p:products)
		{
			 if(p.getName().startsWith(name)||p.getName().endsWith(name)||p.getName().contains(name))
			 {
				 x.add(p);
			 }
		}
		
		return x;
	}

	@Override
	public ArrayList<Product> getAll() {

		return products;
	}

}
