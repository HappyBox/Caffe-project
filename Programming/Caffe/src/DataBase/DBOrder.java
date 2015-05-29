package DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Dish;


public class DBOrder implements IFDBOrder{
    private  Connection con;
    /** Creates a new instance 
     * of DBDish */
    public DBOrder() {
      con = DbConnection.getInstance().getDBcon();
    }
  
  //get one Dish having the name
    //insert a new Dish
    public int insertDish(Dish dish)
    {  
       int rc = -1;
	   String query="INSERT INTO Orders(Name, Price, ready, id) VALUES('"+
			   dish.getName()  + "','"  +
	   				dish.getPrice() + "','"+
	   					dish.getAvailable() + "','"+
	   						dish.getId() +"')";

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

		String query="UPDATE Orders SET "+
			"Name ='"+ DishObj.getName()+"', "+
						"Price='"+ DishObj.getPrice() + "', "+                    //incase of error remove ' '
							"ready='"+ DishObj.getAvailable() + "', "+	
								"id='"+ DishObj.getId() + "' "+                   //incase of error remove ' '
									"WHERE id = '"+ DishObj.getId() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Dish
  			con.setAutoCommit(false);                                           //remove?
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);
	 	 	stmt.close();
	 	 	con.commit();
	        con.setAutoCommit(true);
		}//end try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Dish db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(Integer id)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Orders WHERE id = '" +
				id + "'";
                System.out.println(query);
	  	try{ // delete from Dish
	  		con.setAutoCommit(false);
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
	 	  	con.commit();
	        con.setAutoCommit(true);
  		}//end try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Dish db: "+ex);
   	        }
		return(rc);
	}
	
		
	private ArrayList<Dish> singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Dish DishObj = new Dish();
        ArrayList<Dish> dishList = new ArrayList<Dish>();
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Dish from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		while( results.next() ){
	 			
                DishObj = buildDish(results);
                dishList.add(DishObj);
	 		}
	 		stmt.close();
		}//end try	
	 	catch(Exception ex){
	 		System.out.println("Query exception: "+ex);
	 	}
		return dishList;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT Name, Price, ready, id FROM Orders";
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Dish object
	private Dish buildDish(ResultSet results)
      {   Dish DishObj = new Dish();
          try{ // the columns from the table Dish  are used
        	  DishObj.setId(Integer.valueOf(results.getString("id")));
        	  DishObj.setName(results.getString("Name"));
        	  DishObj.setPrice(Integer.valueOf(results.getString("Price")));
        	  DishObj.setAvailable(Integer.valueOf(results.getString("ready")));
        	 }
         catch(Exception e)
         {
             System.out.println("error in building the Dish object");
         }
         return DishObj;
      }

	@Override
	public ArrayList<Dish> searchOne(Integer i) {
		// TODO Auto-generated method stub
		String wClause = "ready = " + i;
        return singleWhere(wClause, true);
	}	
}  
    

