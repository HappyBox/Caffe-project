package DataBase;
import Model.Customer;

public interface IFDBCus {
    // find a Customer by phone
    public Customer searchCustomerPhone( String cPhone, boolean retriveAssociation);
    //insert a new Customer
    public int insertCustomer(Customer Cus);
    //update information about an Customer
    public int updateCustomer(Customer Cus);
    //delete customer
    public int delete(String cPhone);
    
}
