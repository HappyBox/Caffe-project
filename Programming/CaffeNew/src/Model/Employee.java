package Model;

public class Employee {

	//instance variables 
	private String eName;
	private String eAddress;
	private String eCity;
	private String ePhone_no;
	private String ePassword;
	private String eEmail;
	private String eAccNum;



public Employee() {
        
    }
    public Employee(String ePhone_no){
        this.ePhone_no = ePhone_no;
    }
    public Employee (String eName, String eAddress, String eCity, String ePhone_no, String ePassword, String eEmail, String eAccNum)
    {	
    	this.eName = eName;
        this.eAddress = eAddress;
        this.eCity = eCity;
        this.ePhone_no = ePhone_no;
    	this.ePassword = ePassword;
    	this.eEmail = eEmail;
    	this.eAccNum = eAccNum;

    }
    //set methods
    public void setName(String eName)
    {
        this.eName = eName;
    }
    public void setAddress(String eAddress)
    {
        this.eAddress = eAddress;
    }
    public void setCity(String eCity)
    {
    	this.eCity = eCity;
    }
    public void setPhone_no(String ePhone_no)
    {
    	this.ePhone_no = ePhone_no;
    }
    public void setPassword(String ePassword)
    {
    	this.ePassword = ePassword;
    }
    public void setEmail(String eEmail)
    {
    	this.eEmail = eEmail;
    }
    public void setAccNum(String eAccNum)
    {
    	this.eAccNum = eAccNum;
    }
    
    
    
   
    //get method
    public int getid()
    {
    	return Integer.parseInt(ePhone_no);
    }
    public String getName()
    {
        return eName;
    }
    public String getAddress()
    {
        return eAddress;
    }
    public String getCity()
    {
    	return eCity;
    }
    public String getPhone_no()
    {
    	return ePhone_no;
    }
    public String getPassword()
    {
    	return ePassword;
    }
    public String getEmail()
    {
    	return eEmail;
    }
    public String getAccNum()
    {
    	return eAccNum;
    }
	
   
   
	
}