package Model;

import java.util.ArrayList;

public class TableInfo {

	private Integer num;
	private Customer cus;
	private Employee emp;
	private boolean customerSet = false;
	public TableInfo()
	{
	}
	public void addCus(Customer cus)
	{
		this.cus = cus;
	}
	public void addEmp(Employee emp)
	{
		this.emp = emp;
	}
	public void setCus(boolean v)
	{
		customerSet = v;
	}
	public boolean cusIsSet()
	{
		return customerSet;
	}
	public Customer getCus()
	{
		return cus;
	}
	//public ArrayList<Dish> getList()
	{
		//return foodList;
	}
	public void addDish(Dish dish)
	{
		//foodList.add(dish);
	}
	public void removeDish(Dish dish)
	{
		//foodList.remove(dish);
	}
}
