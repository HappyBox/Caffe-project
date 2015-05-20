package Model;

import java.util.ArrayList;

public class Customer {
	private String phone;
	private String name;
	private String address;
	private String city = "Aalborg";
	private ArrayList<Dish> orders = new ArrayList<Dish>();
	private Integer bill = 0;
	public Customer()
	{
		bill = 0;
	}
	public void removeDish(int i)
	{
		bill -= orders.get(i).getPrice();
		orders.remove(i);
	}
	public void addDish(Dish dish)
	{
		while(dish.getName().length()<20)
		{
			dish.setName(dish.getName()+" ");
		}
		orders.add(dish);
		bill+=dish.getPrice();
	}
	public Integer getBill()
	{
		return bill;
	}
	public ArrayList<Dish> getOrders()
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
