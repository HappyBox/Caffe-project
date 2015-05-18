package DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Manager;


public class DBManager implements IFDBMngr{
    private  Connection con;
    /** Creates a new instance 
     * of DBManager */
    public DBManager() {
      con = DbConnection.getInstance().getDBcon();
    }
  
  //get one Manager having the mPhone_no
    public Manager searchManagerPhone_no(String mPhone, boolean retriveAssociation)
    {   String wClause = "  mPhone = '" + mPhone + "'";
        return singleWhere(wClause, retriveAssociation);
    }
    
    public Manager searchManagerPassword(String mPassword, boolean retriveAssociation)
    {   String wClause = "  mPassword = '" + mPassword + "'";
        return singleWhere(wClause, retriveAssociation);
    }
     //insert a new Manager
    public int insertManager(Manager Mngr)
    {  
       int rc = -1;
	   String query="INSERT INTO Manager(m_id, mName, mAddress, mCity, mPhone, mPassword, mEmail, mAccNum) VALUES('"+
			   Mngr.getPhone_no().substring(0, 4)  + "','"  +
			   Mngr.getName()  + "','"  +
			   		Mngr.getAddress() + "','" +
			   			Mngr.getCity() + "','" +
			   				Mngr.getPhone_no() + "',' " +
			   					Mngr.getPassword() + "','" +
			   						Mngr.getEmail()+ "','" +
			   								Mngr.getAccNum()  + "')" ;

       try{ // insert new Manager
          con.setAutoCommit(false);
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
          con.commit();
          con.setAutoCommit(true);
       }//end try
       catch(SQLException ex){
          System.out.println("Manager not inserted");
          System.out.println("Insert exception in Manager db: "+ex);
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

	public int updateManager(Manager Mngr)
	{
		Manager MngrObj  = Mngr;
		int rc=-1;

		String query="UPDATE Manager SET "+
		"mName ='"+ MngrObj.getName()+"', "+
			"mAddress ='"+ MngrObj.getAddress() + "', " +
				"mCity ='"+ MngrObj.getCity() + "', " +
					"mPhone='"+ MngrObj.getPhone_no() + "', "+
						"mPassword='"+ MngrObj.getPassword() + "', "+
							"mEmail='"+ MngrObj.getEmail() + "', "+
								"mAccNum='"+ MngrObj.getAccNum() + "', "+
									"m_id ='"+ MngrObj.getPhone_no().substring(0, 4)  + "', "  +
										"WHERE mPhone = '"+ MngrObj.getPhone_no() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Manager
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//end try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Manager db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String mPhone_no)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Manager WHERE mPhone = '" +
				mPhone_no + "'";
                System.out.println(query);
	  	try{ // delete from Manager
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//end try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Manager db: "+ex);
   	        }
		return(rc);
	}
	
		
	private Manager singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Manager MngrObj = new Manager();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Manager from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            MngrObj = buildManager(results);
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return MngrObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT mName, mAddress, mCity, mPhone, mPassword, mEmail, mAccNum FROM Manager";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Manager object
	private Manager buildManager(ResultSet results)
      {   Manager MngrObj = new Manager();
          try{ // the columns from the table Manager  are used
        	  MngrObj.setName(results.getString("mName"));
        	  MngrObj.setAddress(results.getString("mAddress"));
        	  MngrObj.setCity(results.getString("mCity"));
        	  MngrObj.setPhone_no(results.getString("mPhone"));
        	  MngrObj.setPassword(results.getString("mPassword"));
        	  MngrObj.setEmail(results.getString("mEmail"));
        	  MngrObj.setAccNum(results.getString("mAccNum"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Manager object");
         }
         return MngrObj;
      }
	
}  
    

