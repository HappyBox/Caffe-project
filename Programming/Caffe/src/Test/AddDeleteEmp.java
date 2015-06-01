package Test;

import Control.CtrEmp;
import Model.Employee;

public class AddDeleteEmp {

	public static void main(String[] args) {   // works only one time
		// TODO Auto-generated method stub
		CtrEmp ctrEmp = new CtrEmp();
		Employee emp = new Employee("Default","Default","Default","11111111","Default","Default","Default");
		ctrEmp.insertNew(emp);
	}

}
