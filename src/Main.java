import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Shop shop = new Shop("shop");
        ArrayList<Order> mainOrders = new ArrayList<>();
        /*System.out.println("what do you want to do?");
        System.out.println("1.add");
        System.out.println("2.report");
        System.out.println("3.remove");
        System.out.println("4.submit");
        System.out.println("5.terminate");*/
        while (true) {
            String req = scan.nextLine();
            if (req.equals("add")) {
                String reqAdd = scan.nextLine();
                if (reqAdd.equals("customer")) {
                    int customerID = scan.nextInt();
                    scan.nextLine();
                    String customerName = scan.next();
                    scan.nextLine();
                    Customer customer = new Customer(customerName, customerID);
                    shop.addCustomer(customer);
                }
                if (reqAdd.equals("good")) {
                    int goodID = scan.nextInt();
                    String goodName = scan.nextLine();
                    scan.nextLine();
                    int goodPrice = scan.nextInt();
                    int goodNum = scan.nextInt();
                    Good good = new Good(goodName, goodID, goodPrice);
                    for (int i = 0; i < goodNum; i++) {
                        shop.addGood(good);//na malmoos
                    }
                    shop.increamentGood(good, goodNum);
                    shop.getItemSold().put(good, 0);
                }
                if (reqAdd.equals("repository")) {
                    int repoID = scan.nextInt();
                    int repoCapacity = scan.nextInt();
                    Repository repository = new Repository(repoID, repoCapacity, repoCapacity);
                    shop.addRepository(repository);
                }
                if (reqAdd.equals("order")) {
                    int orderID = scan.nextInt();
                    int CustomerOrderID = scan.nextInt();
                    Customer[] CustomerArray = shop.getCustomer();
                    for (int i = 0; i < shop.getCustomer().length; i++) {
                        if (CustomerOrderID == CustomerArray[i].getID()) {
                            Order order = new Order(orderID, CustomerArray[i]);
                            CustomerArray[i].addOrder(order);
                            mainOrders.add(order);
                            break;

                        }
                    }
                }
                if (reqAdd.equals("balance")) {
                    int balanceID = scan.nextInt();
                    int balance = scan.nextInt();
                    Customer[] CustomerArray = shop.getCustomer();
                    for (int i = 0; i < shop.getCustomer().length; i++) {
                        if (balanceID == CustomerArray[i].getID()) {
                            CustomerArray[i].setBalance(balance);
                        }
                    }
                }
                if (reqAdd.equals("item")) {

                    int itemOrderID = scan.nextInt();
                    int itemGoodID = scan.nextInt();
                    int itemGoodNum = scan.nextInt();
                    Good good = null;
                    for (Good g : shop.getGoods()) {
                        if (itemGoodID == g.getID()) {
                            //numbers++;
                            good = g;
                            break;
                        }
                    }
                    for (Order order : mainOrders) {
                        if (itemOrderID == order.getID()) {
                            order.addItem(good, itemGoodNum);
                            break;
                        }
                    }

                }
                if (reqAdd.equals("discount")) {
                    int discountID = scan.nextInt();//???
                    int discountPercent = scan.nextInt();//????????
                }
            }
            if (req.equals("report")) {
                String reqReport = scan.nextLine();
                if (reqReport.equals("customers")) {
                    Customer[] CustomerArray = shop.getCustomer();
                    for (int i = 0; i < CustomerArray.length; i++) {
                        //System.out.println();
                        System.out.println(CustomerArray[i].getID() + "," + CustomerArray[i].getName() + "," + CustomerArray[i].getBalance() + "," + CustomerArray[i].getTotalOreders().length + "," + CustomerArray[i].getSubmittedOrders().length);
                    }
                }
                if (reqReport.equals("repositories")) {
                    for (Repository repo : shop.getRepositories()) {
                        //System.out.println();
                        System.out.println(repo.getId() + "," + repo.getCapacity() + "," + repo.getFreeCapacity());
                    }
                }
                if (reqReport.equals("income")) {
                    System.out.println(shop.getIncome());
                }
            }
            if (req.equals("remove")) {
                String reqRemove = scan.nextLine();
                if (reqRemove.equals("item")) {
                    int OrderIDToRemove = scan.nextInt();
                    int goodIDToRemove = scan.nextInt();
                    Good good = null;
                    for (Good g : shop.getGoods()) {
                        if (g.getID() == goodIDToRemove) {
                            good = g;
                            break;
                        }
                    }
                    for (Order o : mainOrders) {
                        if (o.getID() == OrderIDToRemove) {
                            o.removeItem(good);
                            o.getItems().remove(good);
                            break;
                        }
                    }
                }
            }
            if (req.equals("submit")) {
                String reqSubmit = scan.nextLine();
                if (reqSubmit.equals("order")) {
                    //int GoodCounter = 0;
                    int OrderIDToSubmit = scan.nextInt();
                    for (Order o : mainOrders) {
                        if (OrderIDToSubmit == o.getID()) {
                            /*for (Good g : o.getItems().keySet()) {
                                for (Repository r : shop.getRepositories()) {
                                    if (r.getGoods().containsKey(g)) {
                                        if (o.getItems().get(g) <= r.getGoods().get(g)) {
                                            GoodCounter++;
                                            break;
                                        }
                                    }
                                }
                            }*/
                            if (o.calculatePrice() <= o.getCustomer().getBalance()) {
                                o.getCustomer().submitOrder(o);
                                shop.setIncome(o.calculatePrice());
                                o.getCustomer().setBalance(-o.calculatePrice());
                                for (Good g : o.getItems().keySet()) {
                                    for (Repository r : shop.getRepositories()) {
                                        if (r.getGoods().containsKey(g)) {
                                            r.removeGood(g, o.getItems().get(g));
                                            //shop.getItemSold().replace(g, o.getItems().get(g));
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //System.out.println();
                }
                if (reqSubmit.equals("discount")) {
                    int orderforDiscount = scan.nextInt();
                    int discountID = scan.nextInt();
                    //moooooooooonde
                }
            }
            if (req.equals("terminate")) {
                //System.out.println();
                //scan.nextLine();
                break;
            }
        }
    }
}
