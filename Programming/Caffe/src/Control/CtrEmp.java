
// This class is for manager to control employees!

package Control;

import DataBase.DBEmployee;
import DataBase.IFDBEmp;
import Model.Employee;

public class CtrEmp {
   
    
    /** Creates a new instance of CtrEmp */
    public CtrEmp() {
        
    }
  
      public Employee findByPhone(String e_phoneno)
    {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.searchEmployeee_phoneno( e_phoneno, true);
    }
      public int updateEmp(String e_phoneno, String e_name, String e_address)
      {
          IFDBEmp dbEmp = new DBEmployee();
          Employee Emp = new Employee();
          Emp.setPhoneno(e_phoneno);
          Emp.setName(e_name);
          Emp.setAddress(e_address);
          return  dbEmp.updateEmployee(Emp);
          
          
      }
      public void insertNew(Employee EmpObj)
      {
           IFDBEmp dbEmp = new DBEmployee();
           dbEmp.insertEmployee(EmpObj);
      }
    
      public void delete(String e_phoneno)
      {
    	  IFDBEmp dbEmp = new DBEmployee();
    	  dbEmp.delete(e_phoneno);
      }
}
