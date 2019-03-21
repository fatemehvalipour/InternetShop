import java.util.HashMap;

public class Repository {
    private int id;
    private int capacity;
    private int FreeCapacity;

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
        return FreeCapacity;
    }
    public HashMap<Good,Integer> getGoods(){

    }
    public void addGood(Good g,int amount){

    }
    public void removeGood(Good g,int amount){

    }

}
