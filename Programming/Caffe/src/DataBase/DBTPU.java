package DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.TPU;


public class DBTPU implements IFDBTpu{
    private  Connection con;
    /** Creates a new instance 
     * of DBTPU */
    public DBTPU() {
      con = DbConnection.getInstance().getDBcon();
    }
  
  //get price
    public TPU searchTPU()
    {   String wClause = "";
    	return singleWhere(wClause);
    }

	public int updatePrice(TPU Tpu)
	{
		TPU TpuObj  = Tpu;
		int rc=-1;

		String query="UPDATE TPU SET "+
	"tpu_price ='"+ TpuObj.getPrice()+"' " ;
                System.out.println("Update query:" + query);
  		try{ // update TPU
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//end try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in TPU db: "+ex);
	  	}
		return(rc);
	}
	
	private TPU singleWhere(String wClause)
	{
		ResultSet results;
		TPU TpuObj = new TPU();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the TPU from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            TpuObj = buildTPU(results);
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return TpuObj;
	}
	
		
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT tpu_price FROM TPU";	
		return query;
	}
	//method to build an TPU object
	private TPU buildTPU(ResultSet results)
      {   TPU TpuObj = new TPU();
          try{ // the columns from the table TPU  are used
        	  	TpuObj.setPrice(results.getString("tpu_price"));
	  	TpuObj.setPrice(results.getString("tpu_price"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the TPU object");
         }
         return TpuObj;
      }
 
}  
    

