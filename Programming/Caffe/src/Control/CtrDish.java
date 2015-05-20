package Control;

import DataBase.DBDish;
import DataBase.IFDBDish;
import Model.Dish;

public class CtrDish {
    
    /** Creates a new instance of CtrDish */
    public CtrDish() {
    	
    }
  
      public Dish findByName(String name)
    {
        IFDBDish dbDish = new DBDish();
        return dbDish.searchByName( name, true);
    }
      public int updateDish(Integer id, String name, String info,Integer cost, Integer price, Integer available)
      {
          IFDBDish dbDish = new DBDish();
          Dish dish = new Dish();
          dish.setId(id);
          dish.setName(name);
          dish.setInfo(info);
          dish.setCost(cost);
          dish.setPrice(price);
          dish.setAvailable(available);

          return  dbDish.updateDish(dish);
          
      }
      public void insertOrder(Dish dishObj)
      {
           IFDBDish dbDish = new DBDish();
           dbDish.insertDish(dishObj);
      }
      public void insertNew(Dish dishObj)
      {
           IFDBDish dbDish = new DBDish();
           dbDish.insertDish(dishObj);
      }
    
      public void delete(String name)
      {
    	  IFDBDish dbDish = new DBDish();
    	  dbDish.delete(name);
      }
}
