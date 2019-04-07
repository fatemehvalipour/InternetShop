import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private int ID;
    private Customer customer;
    private String status = "pending";
    private HashMap <Good,Integer> itemList =  new HashMap<>();
    public Order(int ID, Customer c){
        this.ID = ID;
        customer = c;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getID() {

        return ID;
    }

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public void addItem(Good good, int amount) {
        itemList.put(good,amount);

    }

    public void removeItem(Good good) {

        getItems().remove(good);
    }

    public HashMap<Good , Integer> getItems() {

       return itemList;
    }

    public int calculatePrice() {
        int totalPrice = 0;

        for(Good key : itemList.keySet()){
            totalPrice += key.getPrice() * getItems().get(key);
        }
        return totalPrice;
    }

    /*public void addDiscount(Discount discount,int price) {
        int totalDiscount = (discount.getPercentage() / 100) * price;
        return totalDiscount;

    }*/


}
