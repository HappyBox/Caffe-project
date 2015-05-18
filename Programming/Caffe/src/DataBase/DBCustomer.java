package DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Customer;


public class DBCustomer implements IFDBCus{
    private  Connection con;
    /** Creates a new instance 
     * of DBCustomer */
    public DBCustomer() {
      con = DbConnection.getInstance().getDBcon();
    }
  
  //get one Customer having the cPhone
    public Customer searchCustomerPhone(String cPhone, boolean retriveAssociation)
    {   String wClause = "  cPhone = '" + cPhone + "'";
        return singleWhere(wClause, retriveAssociation);
    }
     //insert a new Customer
    public int insertCustomer(Customer Cus)
    {  
       int rc = -1;
	   String query="INSERT INTO Customer(c_id, cName, cAddress, cCity, cPhone) VALUES('"+
			   Cus.getid()  + "','"  +
			   Cus.getName()  + "','"  +
			   		Cus.getAddress() + "','" +
			   			Cus.getCity() + "','" +
			   				Cus.getPhone() + "')" ;

       try{ // insert new Customer
          con.setAutoCommit(false);
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
          con.commit();
          con.setAutoCommit(true);
       }//end try
       catch(SQLException ex){
          System.out.println("Customer not inserted");
          System.out.println("Insert exception in Customer db: "+ex);
	  try{
             rc=-1;
             con.rollback();
             con.setAutoCommit(true);
          }
          catch(Exception ex1)
          {
             System.out.println("Error rolling back"+ ex1);
          }
       }
       return(rc);
    }

	public int updateCustomer(Customer Cus)
	{
		Customer CusObj  = Cus;
		int rc=-1;

		String query="UPDATE Customer SET "+
			"cName ='"+ CusObj.getName()+"', "+
				"cAddress ='"+ CusObj.getAddress() + "', " +
					"cCity ='"+ CusObj.getCity() + "', " +		
										" WHERE cPhone = '"+ CusObj.getPhone() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Customer
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//end try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Customer db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String cPhone)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Customer WHERE cPhone = '" +
				cPhone + "'";
                System.out.println(query);
	  	try{ // delete from Customer
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//end try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Customer db: "+ex);
   	        }
		return(rc);
	}
	
		
	private Customer singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Customer CusObj = new Customer();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Customer from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            CusObj = buildCustomer(results);
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return CusObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT cName, cAddress, cCity, cPhone FROM Customer";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Customer object
	private Customer buildCustomer(ResultSet results)
      {   Customer CusObj = new Customer();
          try{ // the columns from the table Customer  are used
        	  CusObj.setName(results.getString("cName"));
        	  CusObj.setAddress(results.getString("cAddress"));
        	  CusObj.setCity(results.getString("cCity"));
        	  CusObj.setPhone(results.getString("cPhone"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Customer object");
         }
         return CusObj;
      }
	
}  
    

