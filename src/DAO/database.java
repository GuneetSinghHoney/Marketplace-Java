/**
 * 
 */
package DAO;

/**
 * This class is just to add the 5 sample products !
 *
 */
public class database
{
	private ProductArrayDAO x;
	private database()
	{
		x = new ProductArrayDAO();
		
		x.addProduct("Laptop", "1111", "Sony pavillion", 5, 1200.50, true);
		x.addProduct("Samsung s8", "22222", "Samsung new S8 phone", 10, 1000, true);
		x.addProduct("Iphone", "3333","IPHONE 6", 15, 450, true);
		x.addProduct("Protein Powder", "4444", "Popoyes pure protein", 20, 10.50, true);
		x.addProduct("Shampoo", "5555", "tresemme shampoo for good hair", 50, 5, true);
		x.addProduct("Sample ", "666", "Free samples", 100, 0.00, false);
		
	}
	
	public ProductArrayDAO getProducts()
	{
		return x;
	}
	
	public static database getInstance()
	{
		return new database();
	}

}
