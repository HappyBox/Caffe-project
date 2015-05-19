package Model;

public class Dish {
	private Integer id;
	private Integer price;
	private String name;
	private String info;
	private Integer cost;
	private Integer available;
	
	public Dish() 
	{
		
	}
	
	public Dish(String name){
		this.name = name;
	}
	public Dish(Integer id, String name, String info, Integer cost, Integer price, Integer available)
	{
		this.id = id;
		this.name = name;
		this.info = info;
		this.cost = cost;
		this.price = price;
		this.available = available;
	}
	//set methods
	public void setId(Integer id) 
	{
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setInfo(String info)
	{
		this.info = info;
	}
	public void setCost(Integer cost)
	{
		this.cost = cost;
	}
	public void setPrice(Integer price)
	{
		this.price = price;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
	//get methods
	public Integer getId() 
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getInfo() 
	{
		return info;
	}
	public Integer getCost() 
	{
		return cost;
	}
	public Integer getPrice()
	{
		return price;
	}
	public Integer getAvailable()
	{
		return available;
	}

	
}
