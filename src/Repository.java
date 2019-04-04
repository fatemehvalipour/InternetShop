import java.util.HashMap;

public class Repository {
    private int id;
    private int capacity;

    public Repository(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {

        return id;
    }

    public int getCapacity() {

        return capacity;
    }

    public int getFreeCapacity() {
        int totalnum = 0;
        for(Good key : getGoods().keySet()){
            totalnum +=  getGoods().get(key);
        }
        int FreeCapacity = capacity - totalnum;
        return FreeCapacity;
    }
    public HashMap<Good,Integer> getGoods(){
        HashMap<Good,Integer> getgoods = new HashMap<>();
        return getgoods;
    }
    public void addGood(Good g,int amount){

        if(getGoods().containsKey(g)){
            getGoods().replace(g,getGoods().get(g) + amount);
        }else{
            getGoods().put(g,amount);
        }
    }
    public void removeGood(Good g,int amount) {

        getGoods().replace(g, getGoods().get(g) - amount);
    }
}
