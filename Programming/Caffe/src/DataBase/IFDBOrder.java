package DataBase;

import Model.Dish;

public interface IFDBOrder {
    
	//insert a new Dish
    public int insertDish(Dish dish);
    //update information about an Dish
    public int updateDish(Dish dish);
    //delete dish
    public int delete(String name);
    
}
