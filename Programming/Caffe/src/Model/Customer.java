package Model;

public class Customer {
	private String phone;
	private String name;
	private String address;
	private String city = "Aalborg";
	public Customer()
	{
		
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
