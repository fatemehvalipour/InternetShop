import java.util.ArrayList;

public class Customer {
    private String name;
    private int ID;
    private int Balance;
    ArrayList<Order> orders = new ArrayList<>();
    public Customer(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public void setBalance(int amount) {

        Balance += amount;
    }

    public int getBalance() {

        return Balance;
    }
    public void addOrder(Order order){
        orders.add(order);

    }
    public Order[] getTotalOreders(){
        int ArraylistSizeO = orders.size();
        Order[] totalOrder = new Order[ArraylistSizeO];
        for (int i = 0; i < ArraylistSizeO; i++) {
            totalOrder[i] = orders.get(i);
        }
        return totalOrder;
    }
    /*public Order[] getPendingOrders(){

    }
    public Order[] getSubmittedOrders(){

    }
    public void submitOrder(Order order){

    }*/

}
