package DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Dish;


public class DBOrder implements IFDBOrder{
    private  Connection con;
    /** Creates a new instance 
     * of DBDish */
    public DBOrder() {
      con = DbConnection.getInstance().getDBcon();
    }
  
  //get one Dish having the name
    public Dish searchByName(String name, boolean retriveAssociation)
    {   String wClause = "  dName = '" + name + "'";
        return singleWhere(wClause, retriveAssociation);
    }
     //insert a new Dish
    public int insertDish(Dish dish)
    {  
       int rc = -1;
	   String query="INSERT INTO Dish(d_id, dName, dIn, dCost, dPrice, dAvailable) VALUES('"+
		   dish.getId() + "','"  +
			   dish.getName()  + "','"  +
			   		dish.getInfo() + "','" +
			   			dish.getCost() + "','" +
			   				dish.getPrice() + "','"+
			   					dish.getAvailable() + "')" ;

       try{ // insert new Dish
          con.setAutoCommit(false);
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
          con.commit();
          con.setAutoCommit(true);
       }//end try
       catch(SQLException ex){
          System.out.println("Dish not inserted");
          System.out.println("Insert exception in Dish db: "+ex);
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

	public int updateDish(Dish Dish)
	{
		Dish DishObj  = Dish;
		int rc=-1;

		String query="UPDATE Dish SET "+
		"d_id ='"+ DishObj.getId() + "'," +
			"dName ='"+ DishObj.getName()+"', "+
				"dIn ='"+ DishObj.getInfo() + "', " +
					"dCost ='"+ DishObj.getCost() + "', " +
						"dPrice='"+ DishObj.getPrice() + "', "+
							"dAvailable='"+ DishObj.getAvailable() + "' "+				
									"WHERE dName = '"+ DishObj.getName() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Dish
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//end try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Dish db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String name)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Dish WHERE dName = '" +
				name + "'";
                System.out.println(query);
	  	try{ // delete from Dish
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//end try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Dish db: "+ex);
   	        }
		return(rc);
	}
	
		
	private Dish singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Dish DishObj = new Dish();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Dish from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            DishObj = buildDish(results);
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception ex){
	 		System.out.println("Query exception: "+ex);
	 	}
		return DishObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT d_id, dName, dIn, dCost, dPrice, dAvailable FROM Dish";
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Dish object
	private Dish buildDish(ResultSet results)
      {   Dish DishObj = new Dish();
          try{ // the columns from the table Dish  are used
        	  DishObj.setId(Integer.valueOf(results.getString("d_id")));
        	  DishObj.setName(results.getString("dName"));
        	  DishObj.setInfo(results.getString("dIn"));
        	  DishObj.setCost(Integer.valueOf(results.getString("dCost")));
        	  DishObj.setPrice(Integer.valueOf(results.getString("dPrice")));
        	  DishObj.setAvailable(Integer.valueOf(results.getString("dAvailable")));
        	 }
         catch(Exception e)
         {
             System.out.println("error in building the Dish object");
         }
         return DishObj;
      }
	
}  
    

