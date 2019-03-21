public class Customer {
    private String name;
    private int ID;
    private int Balance;

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

    public int getBalance() {
        return Balance;
    }
    public void addOrder(Order order){

    }
    public Order[] getTotalOreders(){

    }
    public Order[] getPendingOrders(){

    }
    public Order[] getSubmittedOrders(){

    }
    public void submitOrder(Order order){

    }

}
