package Model;


public class Manager {

	//instance variables 
	private String mName;
	private String mAddress;
	private String mCity;
	private String mPhone_no;
	private String mPassword;
	private String mEmail;
	private String mAccNum;



public Manager() {
        
    }
    public Manager(String mPhone_no){
        this.mPhone_no = mPhone_no;
    }
    public Manager (String mName, String mAddress, String mCity, String mPhone_no, String mPassword, String mEmail, String mAccNum)
    {	
    	this.mName = mName;
        this.mAddress = mAddress;
        this.mCity = mCity;
        this.mPhone_no = mPhone_no;
    	this.mPassword = mPassword;
    	this.mEmail = mEmail;
    	this.mAccNum = mAccNum;

    }
    //set methods
    public void setName(String mName)
    {
        this.mName = mName;
    }
    public void setAddress(String mAddress)
    {
        this.mAddress = mAddress;
    }
    public void setCity(String mCity)
    {
    	this.mCity = mCity;
    }
    public void setPhone_no(String mPhone_no)
    {
    	this.mPhone_no = mPhone_no;
    }
    public void setPassword(String mPassword)
    {
    	this.mPassword = mPassword;
    }
    public void setEmail(String mEmail)
    {
    	this.mEmail = mEmail;
    }
    public void setAccNum(String mAccNum)
    {
    	this.mAccNum = mAccNum;
    }
    
    
    
   
    //get method
    public int getid()
    {
    	return Integer.parseInt(mPhone_no);
    }
    public String getName()
    {
        return mName;
    }
    public String getAddress()
    {
        return mAddress;
    }
    public String getCity()
    {
    	return mCity;
    }
    public String getPhone_no()
    {
    	return mPhone_no;
    }
    public String getPassword()
    {
    	return mPassword;
    }
    public String getEmail()
    {
    	return mEmail;
    }
    public String getAccNum()
    {
    	return mAccNum;
    }
	
}