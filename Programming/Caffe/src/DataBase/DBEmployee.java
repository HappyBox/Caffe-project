package DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Employee;


public class DBEmployee implements IFDBEmp{
    private  Connection con;
    /** Creates a new instance 
     * of DBEmployee */
    public DBEmployee() {
      con = DbConnection.getInstance().getDBcon();
    }
  
  //get one Employee having the ePhone_no
    public Employee searchEmployeeePhone_no(String ePhone, boolean retriveAssociation)
    {   String wClause = "  ePhone = '" + ePhone + "'";
        return singleWhere(wClause, retriveAssociation);
    }
    
    public Employee searchEmployeePassword(String ePassword, boolean retriveAssociation)
    {   String wClause = "  ePassword = '" + ePassword + "'";
        return singleWhere(wClause, retriveAssociation);
    }
     //insert a new Employee
    public int insertEmployee(Employee Emp)
    {  
       int rc = -1;
	   String query="INSERT INTO Employee(e_id, eName, eAddress, eCity, ePhone, ePassword, eEmail, eAccNum) VALUES('"+
			   Emp.getPhone_no().substring(0, 4)  + "','"  +
				   Emp.getName()  + "','"  +
				   		Emp.getAddress() + "','" +
				   			Emp.getCity() + "','" +
				   				Emp.getPhone_no() + "',' " +
				   					Emp.getPassword() + "','" +
				   						Emp.getEmail()+ "','" +
				   							Emp.getAccNum()  + "')" ;

       try{ // insert new Employee
          con.setAutoCommit(false);
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
          con.commit();
          con.setAutoCommit(true);
       }//end try
       catch(SQLException ex){
          System.out.println("Employee not inserted");
          System.out.println("Insert exception in Employee db: "+ex);
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

	public int updateEmployee(Employee Emp)
	{
		Employee EmpObj  = Emp;
		int rc=-1;

		String query="UPDATE Employee SET "+
			"eName ='"+ EmpObj.getName()+"', "+
				"eAddress ='"+ EmpObj.getAddress() + "', " +
					"eCity ='"+ EmpObj.getCity() + "', " +
						"ePhone='"+ EmpObj.getPhone_no() + "', "+
							"ePassword='"+ EmpObj.getPassword() + "', "+
								"eEmail='"+ EmpObj.getEmail() + "', "+
									"eAccNum='"+ EmpObj.getAccNum() + "', "+	
										"e_id ='"+ EmpObj.getPhone_no().substring(0, 4)  + "'"  +
											"WHERE ePhone = '"+ EmpObj.getPhone_no() + "'";
                System.out.println("Update query:" + query);
  		try{ // update Employee
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//end try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Employee db: "+ex);
	  	}
		return(rc);
	}
	
	public int delete(String ePhone_no)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Employee WHERE ePhone = '" +
				ePhone_no + "'";
                System.out.println(query);
	  	try{ // delete from Employee
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}//end try	
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in Employee db: "+ex);
   	        }
		return(rc);
	}
	
		
	private Employee singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Employee EmpObj = new Employee();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            EmpObj = buildEmployee(results);
                            stmt.close();
	 		}
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return EmpObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT eName, eAddress, eCity, ePhone, ePassword, eEmail, eAccNum FROM Employee";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Employee object
	private Employee buildEmployee(ResultSet results)
      {   Employee EmpObj = new Employee();
          try{ // the columns from the table Employee  are used
        	  EmpObj.setName(results.getString("eName"));
        	  EmpObj.setAddress(results.getString("eAddress"));
        	  EmpObj.setCity(results.getString("eCity"));
        	  EmpObj.setPhone_no(results.getString("ePhone"));
        	  EmpObj.setPassword(results.getString("ePassword"));
        	  EmpObj.setEmail(results.getString("eEmail"));
        	  EmpObj.setAccNum(results.getString("eAccNum"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Employee object");
         }
         return EmpObj;
      }
	
}  
    

