package DataBase;
import Model.Manager;

public interface IFDBMngr {
    // find a Manager by phone
    public Manager searchManagerPhone_no( String mPhone_no, boolean retriveAssociation);
    // find by password
    public Manager searchManagerPassword(String mPassword, boolean retriveAssociation);
    //insert a new Manager
    public int insertManager(Manager Mngr);
    //update information about an Manager
    public int updateManager(Manager Mngr);
    //delete customer
    public int delete(String mPhone_no);
    
}
