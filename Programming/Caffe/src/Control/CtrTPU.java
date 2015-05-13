
// This class is for manager to change the transport price!

package Control;

import DataBase.DBTPU;
import DataBase.IFDBTpu;
import Model.TPU;


public class CtrTPU {
   
    
    /** Creates a new instance of CtrTPU */
    public CtrTPU() {
        
    }
  
      public static TPU findPrice()
    {
        IFDBTpu dbTpu = new DBTPU();
        return dbTpu.searchTPU();
    }
      public static int updatePrice(String tpu_price)
      {
          IFDBTpu dbTpu = new DBTPU();
          TPU Tpu = new TPU();
          Tpu.setPrice(tpu_price);
          return  dbTpu.updatePrice(Tpu);
          
      }
}
