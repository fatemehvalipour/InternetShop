import java.util.ArrayList;
import java.util.HashMap;

public class Shop {
    private String name;
    private int Income = 0;
    ArrayList<Customer> customer = new ArrayList<>();
    ArrayList<Repository> repositories = new ArrayList<>();
    ArrayList<Good> goods = new ArrayList<>();
    ArrayList<Discount> discounts = new ArrayList<>();

    public Shop(String name) {

        this.name = name;
    }

    public void addCustomer(Customer c) {
        customer.add(c);
    }

    public Customer[] getCustomer() {
        int ArraylistSizeC = customer.size();
        Customer[] customes = new Customer[ArraylistSizeC];
        for (int i = 0; i < ArraylistSizeC; i++) {
            customes[i] = customer.get(i);
        }
        return customes;
    }

    public void addRepository(Repository r) {
        repositories.add(r);

    }

    public Repository[] getRepositories() {
        int ArraylistSizeR = repositories.size();
        Repository[] reposes = new Repository[ArraylistSizeR];
        for (int i = 0; i < ArraylistSizeR; i++) {
            reposes[i] = repositories.get(i);
        }
        Repository repo = null;
        for(int i = 0 ; i <reposes.length ; i++){
            for(int j = 1 ; j < reposes.length - i ;j++){
                if(reposes[j].getId() > reposes[j+1].getId()){
                    repo = reposes[j];
                    reposes[j] = reposes[j+1];
                    reposes[j+1] = repo;
                }
            }
        }
        return reposes;
    }
    public Repository[] getRepositoriesCapacity() {
        int ArraylistSizeR = repositories.size();
        Repository[] reposes = new Repository[ArraylistSizeR];
        for (int i = 0; i < ArraylistSizeR; i++) {
            reposes[i] = repositories.get(i);
        }
        Repository repo = null;
        for(int i = 0 ; i <reposes.length ; i++){
            for(int j = 1 ; j < reposes.length - i ;j++){
                if(reposes[j].getCapacity() > reposes[j+1].getCapacity()){
                    repo = reposes[j];
                    reposes[j] = reposes[j+1];
                    reposes[j+1] = repo;
                }
            }
        }
        return reposes;
    }
    public int getIncome() {
        for(Customer c : getCustomer()){
            for(Order o : c.getSubmittedOrders()){
                Income += o.calculatePrice();
            }
        }
        return Income;
    }

    public void setIncome(int Income) {//voice hast
        this.Income = Income;

    }

    public void addGood(Good g) {
        goods.add(g);

    }

    public Good[] getGoods() {
        int ArraylistSizeG = goods.size();
        Good[] good = new Good[ArraylistSizeG];
        for (int i = 0; i < ArraylistSizeG; i++) {
            good[i] = goods.get(i);
        }
        return good;

    }

    public void increamentGood(Good g, int amount) {
        Repository[] repo = getRepositoriesCapacity();
        for(Repository r : repo){
            if(r.getFreeCapacity() >= amount){
                r.addGood(g,amount);
                break;
            }
        }
    }

    /*public void addDiscount(Discount d, Order o) {

    }*///after order

    public HashMap<Good,Integer> getItemSold() {
        HashMap<Good,Integer> itemSold = new HashMap<>();
        return itemSold;
    }

    /*public void addDiscount(Discount discount) {
       // discounts.add(discount);

    }*/

}

