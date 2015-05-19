package Model;

import java.util.ArrayList;

public class Customer {
	private String phone;
	private String name;
	private String address;
	private String city = "Aalborg";
	private ArrayList<String> orders = new ArrayList<String>();
	private Integer bill = 0;
	public Customer()
	{
		
	}
	public void addDish(String name, int price)
	{
		while(name.length()<20)
		{
			name+=" ";
		}
		orders.add(name+price);
		bill+=price;
	}
	public ArrayList<String> getOrders()
	{
		return orders;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setPhone(String name)
	{
		this.phone = name;
	}
	public void setAddress(String name)
	{
		this.address = name;
	}
	public void setCity(String name)
	{
		this.city = name;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getName()
	{
		return name;
	}
	public String getAddress()
	{
		return address;
	}
	public String getCity()
	{
		return city;
	}
}
