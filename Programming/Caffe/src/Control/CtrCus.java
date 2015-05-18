package Control;

import DataBase.*;
import Model.Customer;
public class CtrCus {
	
	public Customer findByPhone(String phone)
	{
		IFDBCus ifdbcus = new DBCustomer();
		return ifdbcus.searchCustomerPhone(phone, true);
	}
	public int createCustomer(String name, String address, String phone)
	{
		Customer cus = new Customer();
		cus.setName(name);
		cus.setAddress(address);
		cus.setPhone(phone);
		IFDBCus ifdbcus = new DBCustomer();
		int x = ifdbcus.insertCustomer(cus);
		return x;
	}
	public Customer findCustomer(String phone)
	{
		IFDBCus ifdbcus = new DBCustomer();
		Customer cus = ifdbcus.searchCustomerPhone(phone, true);
		return cus;
	}
	public int updateCustomer(String name, String address, String phone)
	{
		Customer cus = new Customer();
		cus.setName(name);
		cus.setAddress(address);
		cus.setPhone(phone);
		IFDBCus ifdbcus = new DBCustomer();
		int x = ifdbcus.updateCustomer(cus);
		return x;
	}
}
