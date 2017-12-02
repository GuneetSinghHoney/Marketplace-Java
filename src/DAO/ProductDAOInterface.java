package DAO;

import java.util.ArrayList;

public interface ProductDAOInterface 
{	
	public int addProduct(String name,String SKU,String Description,int numberInstock, double unitPrice,
			boolean available);
	public boolean buyProduct(int id);
	public boolean changeAvailability(int id, boolean avail);
	public boolean changeProductName(int id, String name);
	public boolean changeSKU(int id,String SKU);
	public boolean changeDescription(int id,String desc);
	public boolean changeNumberInStock(int id,int stock);
	public boolean changeUnitPrice(int id,double price);	
	public boolean deleteProduct(int id);
	public Product getProduct(int id);
	public ArrayList<Product> find(String name);
	public ArrayList<Product> getAll();

}
