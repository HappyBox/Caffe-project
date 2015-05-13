package Model;

/**
*
* @author group 6
* @version 16.03.2015
*/

public class Product {

	//instance variables 
	private String p_name;
	private String p_details;
	private String p_price;
	

public Product() {
        
    }
    public Product(String p_name){
        this.p_name = p_name;
    }
    public Product (String p_name, String p_details, String p_price)
    {
        this.p_name = p_name;
        this.p_details = p_details;
    	this.p_price = p_price;
    }
    //set methods
    public void setName(String p_name)
    {
        this.p_name = p_name;
    }
    public void setDetails(String p_details)
    {
        this.p_details = p_details;
    }
    public void setPrice(String p_price)
    {
    	this.p_price = p_price;
    }
    //get method
    public String getName()
    {
        return p_name;
    }
    public String getDetails()
    {
        return p_details;
    }
    public String getPrice()
    {
    	return p_price;
    }
}