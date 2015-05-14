package Model;

import java.util.ArrayList;

public class TableInfo {

	private Integer num;
	private Customer cus;
	private ArrayList<Dish> foodList = new ArrayList<Dish>();
	public TableInfo(int num)
	{
		this.num = num;
	}
	public void setCustomer(Customer cus)
	{
		this.cus = cus;
	}
	public int getNum()
	{
		return num;
	}
	public ArrayList<Dish> getList()
	{
		return foodList;
	}
	public void addDish(Dish dish)
	{
		foodList.add(dish);
	}
	public void removeDish(Dish dish)
	{
		foodList.remove(dish);
	}
}
