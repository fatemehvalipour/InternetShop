import java.util.ArrayList;

public class Customer {
    private String name;
    private int ID;
    private int Balance;
    ArrayList<Order> orders = new ArrayList<>();

    public Customer(String name,int ID) {
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
    public Order[] getPendingOrders(){
        ArrayList<Order> pendingOrders = new ArrayList<>();
        for(Order o : getTotalOreders()){
            if(o.getStatus().equals("pending")){
                pendingOrders.add(o);
            }
        }
        Order[] pendingOrder = new Order[pendingOrders.size()];
        for (int i = 0; i < pendingOrders.size(); i++) {
            pendingOrder[i] = pendingOrders.get(i);
        }
        return pendingOrder;
    }
    public Order[] getSubmittedOrders(){
        ArrayList<Order> submittedOrders = new ArrayList<>();
        for(Order o : getTotalOreders()){
            if(o.getStatus().equals("submitted")){
                submittedOrders.add(o);
            }
        }
        Order[] submitOrder = new Order[submittedOrders.size()];
        for (int i = 0; i < submittedOrders.size(); i++) {
            submitOrder[i] = submittedOrders.get(i);
        }
        return submitOrder;
    }
    public void submitOrder(Order order){

        order.setStatus("submitted");
    }

}
