import java.util.HashMap;

public class Order {
    private int ID;
    private Customer c;//private or not??
    private String status;

    public int getID() {
        return ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void addItem(Good good, int amount){

    }
    public void removeItem(Good good){

    }
    public HashMap<Good,Integer> getItems(){

    }
    public int calculatePrice(){

    }
    public void addDiscount(Discount discount){

    }



}
