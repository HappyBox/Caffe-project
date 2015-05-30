package Test;
import Model.*;
import Control.*;

public class AddDeleteCus {

	public static void main(String[] args) {        // works only once because of unique
		// TODO Auto-generated method stub			//delete customer from sql and try again
		CtrCus ctrCus = new CtrCus();
		int x = ctrCus.createCustomer("Default", "Default", "00000000");
		if (x != -1)
		{
			System.out.println("customer added");
		}
		else
		{
			System.out.println("customer NOT added");
		}
		
	}

}
