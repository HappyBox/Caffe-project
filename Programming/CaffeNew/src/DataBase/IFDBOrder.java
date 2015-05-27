package DataBase;

import java.util.ArrayList;

import Model.Dish;

public interface IFDBOrder {
    
	//insert a new Dish
    public int insertDish(Dish dish);
    //update information about an Dish
    public int updateDish(Dish dish);
    //delete dish
    public int delete(Integer id);
    public ArrayList<Dish> searchOne(Integer i);
}
