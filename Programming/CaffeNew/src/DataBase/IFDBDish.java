package DataBase;

import Model.Dish;

public interface IFDBDish {
    // find a Dish by name
    public Dish searchByName( String name, boolean retriveAssociation);
    //insert a new Dish
    public int insertDish(Dish dish);
    //update information about an Dish
    public int updateDish(Dish dish);
    //delete dish
    public int delete(String name);
    
}
