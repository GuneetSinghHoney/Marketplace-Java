package DAO;

public class Product
{
	String SKU,Description,name;
	int numberInstock;
	double unitPrice;
	boolean available;
	int id;
	
	public Product(String name, String sKU, String description, int numberInstock, double unitPrice, boolean available, int id) {
		super();
		this.name = name;
		SKU = sKU;
		Description = description;
		this.numberInstock = numberInstock;
		this.unitPrice = unitPrice;
		this.available = available;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getNumberInstock() {
		return numberInstock;
	}
	public void setNumberInstock(int numberInstock) {
		this.numberInstock = numberInstock;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
}
