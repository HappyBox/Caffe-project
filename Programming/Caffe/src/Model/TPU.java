package Model;

public class TPU {
	//instance variables 
	private String tpu_price;

	

public TPU() {
        
    }
    public TPU(String tpu_price){
        this.setPrice(tpu_price);
    }
	public String getPrice() {
		return tpu_price;
	}
	public void setPrice(String tpu_price) {
		this.tpu_price = tpu_price;
	}


}
