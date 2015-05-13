package DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Product;


public class DBProduct implements IFDBProd{
    private  Connection con;
    /** Creates a new instance 
     * of DBProduct */
    public DBProduct() {
      con = DbConnection.getInstance().getDBcon();
    }
  
  //get one Product having the p_name
    public Product searchProductp_name(String p_name, boolean retriveAssociation)
    {   String wClause = "  p_name = '" + p_name + "'";
        return singleWhere(wClause, retriveAssociation);
    }
     //insert a new Product
    public int insertProduct(Product Prod)
    {  
       int rc = -1;
	   String query="INSERT INTO Productp_name,p_details,p_price)  VALUES('"+
	  		Prod.getName()  + "','"  +
	  			Prod.getDetails() + "','" +
	  			Prod.getPrice() + "','";

       try{ // insert new Product
          con.setAutoCommit(false);
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
          con.commit();
          con.setAutoCommit(true);
       }//end try
       catch(SQLException ex){
          System.out.println("Product ikke oprettet");
          System.out.println("Insert exception in Product db: "+ex);
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

	public int updateProduct(Product Prod)
	{
		Product ProdObj  = Prod;
		int rc=-1;

		String query="UPDATE Product SET "+
	"p_name ='"+ ProdObj.getName()+"', "+
		"p_details ='"+ ProdObj.getDetails() + "', " +
			"p_price='"+ ProdObj.getPrice() + "', "+
		 	  
		 	  
		 	  	"WHERE p_name = '"+ ProdObj.getName() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Product
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//end try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Product db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String p_name)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Product WHERE p_name = '" +
				p_name + "'";
                System.out.println(query);
	  	try{ // delete from Product
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//end try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Product db: "+ex);
   	        }
		return(rc);
	}
	
		
	private Product singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Product ProdObj = new Product();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Product from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            ProdObj = buildProduct(results);
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return ProdObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT p_name, p_details, p_price FROM Product";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Product object
	private Product buildProduct(ResultSet results)
      {   Product ProdObj = new Product();
          try{ // the columns from the table Product  are used
        	  	ProdObj.setName(results.getString("p_name"));
                ProdObj.setDetails(results.getString("p_details"));
                ProdObj.setPrice(results.getString("p_price"));
	  	ProdObj.setName(results.getString("p_name"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Product object");
         }
         return ProdObj;
      }
 
}  
    

