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
  
  //get one Employee having the e_phoneno
    public Employee searchEmployeee_phoneno(String e_phoneno, boolean retriveAssociation)
    {   String wClause = "  e_phoneno = '" + e_phoneno + "'";
        return singleWhere(wClause, retriveAssociation);
    }
     //insert a new Employee
    public int insertEmployee(Employee Emp)
    {  
       int rc = -1;
	   String query="INSERT INTO Employee(e_phoneno,e_name,e_address)  VALUES('"+
       Emp.getPhoneno() + "','" +
	  		Emp.getName()  + "','"  +
	  			Emp.getAddress() + "','";

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
          System.out.println("Employee ikke oprettet");
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
			"e_phoneno='"+ EmpObj.getPhoneno() + "', "+
		 	  "e_name ='"+ EmpObj.getName()+"', "+
		 	  "e_address ='"+ EmpObj.getAddress() + "', " +
		 	  	"WHERE e_phoneno = '"+ EmpObj.getPhoneno() + "'";
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
	
	public int delete(String e_phoneno)
	{
               int rc=-1;
	  
	  	String query="DELETE FROM Employee WHERE e_phoneno = '" +
				e_phoneno + "'";
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
	    String query="SELECT e_phoneno, e_name, e_address FROM Employee";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an Employee object
	private Employee buildEmployee(ResultSet results)
      {   Employee EmpObj = new Employee();
          try{ // the columns from the table Employee  are used
        	  	EmpObj.setPhoneno(results.getString("e_phoneno"));
                EmpObj.setName(results.getString("e_name"));
                EmpObj.setAddress(results.getString("e_address"));
	  	EmpObj.setPhoneno(results.getString("e_phoneno"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Employee object");
         }
         return EmpObj;
      }
 
}  
    

