import java.util.HashMap;

public class Repository {
    private int id;
    private int capacity;
    private int FreeCapacity;
    private HashMap<Good,Integer> getgoods = new HashMap<>();
    public Repository(int id, int capacity,int FreeCapacity) {
        this.id = id;
        this.capacity = capacity;
        this.FreeCapacity = FreeCapacity;
    }

    public int getId() {

        return id;
    }

    public int getCapacity() {

        return capacity;
    }

    public int getFreeCapacity() {
       /* int totalnum = 0;
        for(Good key : getGoods().keySet()){
            totalnum +=  getGoods().get(key);
        }*/
        //FreeCapacity = capacity - totalnum;
        return FreeCapacity;
    }

    public void setFreeCapacity(int freeCapacity) {

        FreeCapacity = freeCapacity;
    }

    public HashMap<Good,Integer> getGoods(){

        return getgoods;
    }
    public void addGood(Good g,int amount){

        if(getGoods().containsKey(g)){
            getGoods().replace(g,getGoods().get(g) + amount);
        }else{
            getGoods().put(g,amount);
        }
        setFreeCapacity(getFreeCapacity() - amount);
    }
    public void removeGood(Good g,int amount) {

        getGoods().replace(g, getGoods().get(g) - amount);
        setFreeCapacity(getFreeCapacity() + amount);
    }
}
