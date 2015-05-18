package Control;

import DataBase.DBCustomer;
import DataBase.IFDBCus;
import Model.Customer;
public class CtrCus {
	
	public Customer findByPhone(String cPhone)
	{
		IFDBCus ifdbcus = new DBCustomer();
		return ifdbcus.searchCustomerPhone(cPhone, true);
	}
	public int createCustomer(String cName, String cAddress, String cCity, String cPhone)
	{
		Customer cus = new Customer();
		cus.setName(cName);
		cus.setAddress(cAddress);
		cus.setCity(cCity);
		cus.setPhone(cPhone);
		IFDBCus ifdbcus = new DBCustomer();
		int x = ifdbcus.insertCustomer(cus);
		return x;
	}
	public Customer findCustomer(String cPhone)
	{
		IFDBCus ifdbcus = new DBCustomer();
		Customer cus = ifdbcus.searchCustomerPhone(cPhone, true);
		return cus;
	}
	public int updateCustomer(String cName, String cAddress,String cCity, String cPhone)
	{
		Customer cus = new Customer();
		cus.setName(cName);
		cus.setAddress(cAddress);
		cus.setCity(cCity);
		cus.setPhone(cPhone);
		IFDBCus ifdbcus = new DBCustomer();
		int x = ifdbcus.updateCustomer(cus);
		return x;
	}
}
