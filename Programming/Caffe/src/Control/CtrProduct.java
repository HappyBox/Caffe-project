
// This class is for manager to control products!

package Control;

import DataBase.DBProduct;
import DataBase.IFDBProd;
import Model.Product;

public class CtrProduct {
   
    
    /** Creates a new instance of CtrProduct */
    public CtrProduct() {
        
    }
  
      public Product findByName(String p_name)
    {
        IFDBProd dbProd = new DBProduct();
        return dbProd.searchProductp_name( p_name, true);
    }
      public int updateProduct(String p_name, String p_details, String p_price)
      {
          IFDBProd dbProd = new DBProduct();
          Product Prod = new Product();
          Prod.setName(p_name);
          Prod.setDetails(p_details);
          Prod.setPrice(p_price);

          return  dbProd.updateProduct(Prod);
          
      }
      public void insertNew(Product ProdObj)
      {
           IFDBProd dbProd = new DBProduct();
           dbProd.insertProduct(ProdObj);
      }
    
      public void delete(String p_name)
      {
    	  IFDBProd dbProd = new DBProduct();
    	  dbProd.delete(p_name);
      }
}
