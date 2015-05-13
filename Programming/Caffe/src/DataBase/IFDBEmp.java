package DataBase;
import Model.Employee;

public interface IFDBEmp {
    // find a Employee by phone
    public Employee searchEmployeee_phoneno( String e_phoneno, boolean retriveAssociation);
    //insert a new Employee
    public int insertEmployee(Employee Emp);
    //update information about an Employee
    public int updateEmployee(Employee Emp);
    //delete customer
    public int delete(String e_phoneno);
    
}
