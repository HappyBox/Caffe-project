package Model;

public class Dish {
	private Integer price;
	private String name;
	public Dish(int price, String name)
	{
		this.price = price;
		this.name = name;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public int getPrice()
	{
		return price;
	}
}
