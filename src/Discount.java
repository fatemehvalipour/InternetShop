public class Discount {
    private int ID;
    private int percent;

    public Discount(int ID, int percent) {
        this.ID = ID;
        this.percent = percent;
    }

    /*public void setOrder(Order order){

    }
    public Order getOrder(){

    }*/
    public int getPercentage(){
        return  percent;
    }
}
