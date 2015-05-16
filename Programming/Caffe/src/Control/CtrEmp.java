
// This class is for manager to control employees!

package Control;

import DataBase.DBEmployee;
import DataBase.IFDBEmp;
import Model.Employee;

public class CtrEmp {
   
    
    /** Creates a new instance of CtrEmp */
    public CtrEmp() {
        
    }
  
      public Employee findByPhone(String ePhone_no)
    {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.searchEmployeeePhone_no( ePhone_no, true);
    }
	  public Employee findByPassword(String ePassword)
	  {
	      IFDBEmp dbEmp = new DBEmployee();
	      return dbEmp.searchEmployeePassword(ePassword, true);
	  }
      public int updateEmp(String eName, String eAddress, String eCity, String ePhone_no,String ePassword, String eEmail, String eAccNum )
      {
          IFDBEmp dbEmp = new DBEmployee();
          Employee Emp = new Employee();
          Emp.setName(eName);
          Emp.setAddress(eAddress);
          Emp.setCity(eCity);
          Emp.setPhone_no(ePhone_no);
          Emp.setPassword(ePassword);
          Emp.setEmail(eEmail);
          Emp.setAccNum(eAccNum);

          return  dbEmp.updateEmployee(Emp);
          
          
      }
      public void insertNew(Employee EmpObj)
      {
           IFDBEmp dbEmp = new DBEmployee();
           dbEmp.insertEmployee(EmpObj);
      }
    
      public void delete(String ePhone_no)
      {
    	  IFDBEmp dbEmp = new DBEmployee();
    	  dbEmp.delete(ePhone_no);
      }
}
