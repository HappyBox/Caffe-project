package DataBase;
import Model.TPU;

public interface IFDBTpu {
    // find a Product by phone
    public TPU searchTPU();
      //update information about an Product
    public int updatePrice(TPU Tpu);
}
