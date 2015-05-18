package Model;

public class Customer {
	private String cPhone;
	private String cName;
	private String cAddress;
	private String cCity = "Aalborg";
	public Customer()
	{
		
	}
	public void setName(String cName)
	{
		this.cName = cName;
	}
	public void setPhone(String cPhone)
	{
		this.cPhone = cPhone;
	}
	public void setAddress(String cAddress)
	{
		this.cAddress = cAddress;
	}
	public void setCity(String cCity)
	{
		this.cCity = cCity;
	}
	public int getid()
    {
    	return Integer.parseInt(cPhone);
    }
	public String getPhone()
	{
		return cPhone;
	}
	public String getName()
	{
		return cName;
	}
	public String getAddress()
	{
		return cAddress;
	}
	public String getCity()
	{
		return cCity;
	}
}
