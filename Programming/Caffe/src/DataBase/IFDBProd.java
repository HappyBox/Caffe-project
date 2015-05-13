package DataBase;
import Model.Product;

public interface IFDBProd {
    // find a Product by phone
    public Product searchProductp_name( String p_name, boolean retriveAssociation);
    //insert a new Product
    public int insertProduct(Product Prod);
    //update information about an Product
    public int updateProduct(Product Prod);
    //delete customer
    public int delete(String p_name);
    
}
