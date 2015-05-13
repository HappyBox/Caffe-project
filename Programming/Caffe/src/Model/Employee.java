package Model;

/**
*
* @author group 6
* @version 16.03.2015
*/

public class Employee {

	//instance variables 
	private String e_phoneno;
	private String e_name;
	private String e_address;

public Employee() {
        
    }
    public Employee(String e_phoneno){
        this.e_phoneno = e_phoneno;
    }
    public Employee (String e_phoneno,String e_name, String e_address)
    {
    	this.e_phoneno = e_phoneno;
        this.e_name = e_name;
        this.e_address = e_address;
    }
    //set methods
    public void setPhoneno(String e_phoneno)
    {
    	this.e_phoneno = e_phoneno;
    }
    public void setName(String e_name)
    {
        this.e_name = e_name;
    }
    public void setAddress(String e_address)
    {
        this.e_address = e_address;
    }
    //get method
    public String getPhoneno()
    {
    	return e_phoneno;
    }
    public String getName()
    {
        return e_name;
    }
    public String getAddress()
    {
        return e_address;
    }
	public String getPassword() {
		// TODO Auto-generated method stub
		return "2";
	}
}