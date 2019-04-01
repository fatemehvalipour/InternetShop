import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private int ID;
    private String status = "pending";
    public Order(int ID, Customer c){
        this.ID = ID;//??????????????????????????????
    }
    ArrayList <Good> goodOrders= new ArrayList<>();
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
        getItems().put(good,amount);

    }

    public void removeItem(Good good) {
        getItems().remove(good);
        /*for(int i = 0; i < goodOrders.size() ; i++){
            if(good.getID() == goodOrders.get(i).getID()){
                goodOrders.remove(goodOrders.get(i));
            }
        }*/
    }

    public HashMap<Good , Integer> getItems() {
       HashMap <Good,Integer> itemList =  new HashMap<>();
       return itemList;
    }

    public int calculatePrice() {
        int totalPrice = 0;
        //Set<Good> keySet = getItems().keySet();
        for(Good key : getItems().keySet()){
            totalPrice += key.getPrice() * getItems().get(key);
        }
        return totalPrice;
    }

    /*public void addDiscount(Discount discount,int price) {
        int totalDiscount = (discount.getPercentage() / 100) * price;
        return totalDiscount;

    }*/


}
