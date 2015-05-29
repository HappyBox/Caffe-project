package Control;

import java.util.ArrayList;

import DataBase.DBDish;
import DataBase.DBOrder;
import DataBase.IFDBDish;
import DataBase.IFDBOrder;
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
      public int updateOrder(Integer id, String name, Integer price, Integer available)
      {
          IFDBOrder dbDish = new DBOrder();
          Dish dish = new Dish();
          dish.setId(id);
          dish.setName(name);
          dish.setPrice(price);
          dish.setAvailable(available);

          return  dbDish.updateDish(dish);
          
      }

      public ArrayList<Dish> findOne(Integer i)
      {
          IFDBOrder dbDish = new DBOrder();
          return dbDish.searchOne(i);
      }
      public void insertOrder(Dish dishObj)
      {
           IFDBOrder dbDish = new DBOrder();
           dbDish.insertDish(dishObj);
      }
    
      public void deleteOrder(Integer id)
      {
          IFDBOrder dbDish = new DBOrder();
          dbDish.delete(id);
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
