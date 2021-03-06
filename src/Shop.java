import java.util.ArrayList;
import java.util.HashMap;

public class Shop {
    private String name;
    private int Income = 0;
    ArrayList<Customer> customer = new ArrayList<>();
    ArrayList<Repository> repositories = new ArrayList<>();
    ArrayList<Good> goods = new ArrayList<>();
    ArrayList<Discount> discounts = new ArrayList<>();
    private HashMap<Good, Integer> itemSold = new HashMap<>();

    public Shop(String name) {

        this.name = name;
    }

    public void addCustomer(Customer c) {

        customer.add(c);
    }

    public ArrayList<Customer> getCustomer() {
        /*int ArraylistSizeC = customer.size();
        Customer[] customes = new Customer[ArraylistSizeC];
        for (int i = 0; i < ArraylistSizeC; i++) {
            customes[i] = customer.get(i);
        }*/
        return customer;
    }

    public ArrayList<Discount> getdiscount() {
        /*int ArraylistSizeD = discounts.size();
        Discount[] discount = new Discount[ArraylistSizeD];
        for (int i = 0; i < ArraylistSizeD; i++) {
            discount[i] = discounts.get(i);
        }*/
        return discounts;
    }

    public void addRepository(Repository r) {
        repositories.add(r);

    }

    public ArrayList<Repository> getRepositories() {
        /*int ArraylistSizeR = repositories.size();
        Repository[] reposes = new Repository[ArraylistSizeR];
        for (int i = 0; i < ArraylistSizeR; i++) {
            reposes[i] = repositories.get(i);
        }
        Repository repo = null;
        for (int i = 0; i < reposes.length; i++) {
            for (int j = 1; j < reposes.length - i; j++) {
                if (reposes[j].getId() > reposes[j + 1].getId()) {
                    repo = reposes[j];
                    reposes[j] = reposes[j + 1];
                    reposes[j + 1] = repo;
                }
            }
        }*/
        return repositories;
    }

    public ArrayList<Repository> getRepositoriesCapacity() {
        /*int ArraylistSizeR = repositories.size();
        Repository[] reposes = new Repository[ArraylistSizeR];
        for (int i = 0; i < ArraylistSizeR; i++) {
            reposes[i] = repositories.get(i);
        }
        Repository repo = null;
        for (int i = 0; i < reposes.length; i++) {
            for (int j = 1; j < reposes.length - i; j++) {
                if (reposes[j].getCapacity() > reposes[j + 1].getCapacity()) {
                    repo = reposes[j];
                    reposes[j] = reposes[j + 1];
                    reposes[j + 1] = repo;
                }
            }
        }*/
        return repositories;
    }

    public int getIncome() {
        return Income;
    }

    public void setIncome(int Income) {
        this.Income = Income;

    }

    public void addGood(Good g) {
        goods.add(g);


    }

    public ArrayList<Good> getGoods() {
       /* int ArraylistSizeG = goods.size();
        Good[] good = new Good[ArraylistSizeG];
        for (int i = 0; i < ArraylistSizeG; i++) {
            good[i] = goods.get(i);
        }*/
        return goods;

    }

    public void increamentGood(Good g, int amount) {
        //Repository[] repo = getRepositoriesCapacity();
        for (Repository r : getRepositories()) {
            if (r.getFreeCapacity() >= amount) {
                r.addGood(g, amount);
                getItemSold().put(g, amount);
                //r.setFreeCapacity(r.getFreeCapacity() - amount);
                break;
            }
        }
    }

    public void addDiscount(Discount d, Order o) {
        o.addDiscount(d);
    }

    public HashMap<Good, Integer> getItemSold() {

        return itemSold;
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);

    }

}