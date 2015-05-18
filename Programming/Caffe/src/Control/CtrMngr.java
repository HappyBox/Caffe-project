
// This class is for manager to control employees!

package Control;

import DataBase.DBManager;
import DataBase.IFDBMngr;
import Model.Manager;

public class CtrMngr {
   
    
    /** Creates a new instance of CtrMngr */
    public CtrMngr() {
        
    }
  
      public Manager findByPhone(String mPhone_no)
    {
        IFDBMngr dbMngr = new DBManager();
        return dbMngr.searchManagerPhone_no( mPhone_no, true);
    }
	  public Manager findByPassword(String mPassword)
	  {
	      IFDBMngr dbMngr = new DBManager();
	      return dbMngr.searchManagerPassword(mPassword, true);
	  }
      public int updateMngr(String mName, String mAddress, String mCity, String mPhone_no,String mPassword, String mEmail, String mAccNum )
      {
          IFDBMngr dbMngr = new DBManager();
          Manager Mngr = new Manager();
          Mngr.setName(mName);
          Mngr.setAddress(mAddress);
          Mngr.setCity(mCity);
          Mngr.setPhone_no(mPhone_no);
          Mngr.setPassword(mPassword);
          Mngr.setEmail(mEmail);
          Mngr.setAccNum(mAccNum);

          return  dbMngr.updateManager(Mngr);
          
          
      }
      public void insertNew(Manager MngrObj)
      {
           IFDBMngr dbMngr = new DBManager();
           dbMngr.insertManager(MngrObj);
      }
    
      public void delete(String mPhone_no)
      {
    	  IFDBMngr dbMngr = new DBManager();
    	  dbMngr.delete(mPhone_no);
      }
}
