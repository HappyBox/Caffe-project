package Model;

/**
*
* @author group 6
* @version 16.03.2015
*/

public class Employee {

	//instance variables 
	private String e_password;
	private String e_name;
	private String e_order;
	private String e_address;
	private String e_phoneno;

public Employee() {
        
    }
    public Employee(String e_phoneno){
        this.e_phoneno = e_phoneno;
    }
    public Employee (String e_password, String e_name, String e_order, String e_address, String e_phoneno)
    {	
    	this.e_password = e_password;
    	this.e_name = e_name;
    	this.e_order = e_order;
        this.e_address = e_address;
    	this.e_phoneno = e_phoneno;
    }
    //set methods
    public void setPassword(String e_password)
    {
    	this.e_password = e_password;
    }
    public void setName(String e_name)
    {
        this.e_name = e_name;
    }
    public void setOrder(String e_order)
    {
    	this.e_order = e_order;
    }
    public void setAddress(String e_address)
    {
        this.e_address = e_address;
    }
    public void setPhoneno(String e_phoneno)
    {
    	this.e_phoneno = e_phoneno;
    }
    
   
    //get method
    public String getPassword()
    {
    	return e_password;
    }
    public String getName()
    {
        return e_name;
    }
    public String getOrder()
    {
    	return e_order;
    }
    public String getAddress()
    {
        return e_address;
    }
    public String getPhoneno()
    {
    	return e_phoneno;
    }
	
}