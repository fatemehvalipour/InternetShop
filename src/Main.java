import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Shop shop = new Shop("shop");
        System.out.println("what do you want to do?");
        System.out.println("1.add");
        System.out.println("2.report");
        System.out.println("3.remove");
        System.out.println("4.submit");
        System.out.println("5.terminate");
        String req = scan.nextLine();
        if(req.equals("add")){
            String reqAdd = scan.nextLine();
            if(reqAdd.equals("customer")){
                int customerID = scan.nextInt();
                String customerName = scan.nextLine();
                Customer customer = new Customer(customerName,customerID);
                shop.addCustomer(customer);
            }
            if(reqAdd.equals("good")){
                int goodID = scan.nextInt();
                String goodName = scan.nextLine();
                int goodPrice = scan.nextInt();
                int goodNum = scan.nextInt();
                Good good = new Good(goodName,goodID,goodPrice);
                for(int i = 0; i < goodNum ; i++){
                    shop.addGood(good);
                }
            }
            if(reqAdd.equals("repository")){
                int repoID = scan.nextInt();
                int repoCapaity = scan.nextInt();
                Repository repository = new Repository(repoID,repoCapaity);
                shop.addRepository(repository);
            }
            if(reqAdd.equals("order")){
                int orderID = scan.nextInt();
                int CustomerOrderID = scan.nextInt();
                Customer[] CustomerArray = new Customer[shop.getCustomer().length];
                CustomerArray = shop.getCustomer();
                for(int i = 0 ;i < shop.getCustomer().length ; i++){
                    if(CustomerOrderID == CustomerArray[i].getID()){
                        Order order = new Order(orderID,CustomerArray[i]);
                        break;
                        
                    }
                }

            }
            if(reqAdd.equals("balance")){
                int balanceID = scan.nextInt();
                int balance = scan.nextInt();
                Customer[] CustomerArray = new Customer[shop.getCustomer().length];
                CustomerArray = shop.getCustomer();
                for(int i = 0 ;i < shop.getCustomer().length ; i++){
                    if(balanceID == CustomerArray[i].getID()){
                        CustomerArray[i].setBalance(balance);
                    }
                }
            }
            if(reqAdd.equals("item")){
                int itemOrderID = scan.nextInt();
                int itemGoodID = scan.nextInt();
                int itemGoodnum = scan.nextInt();

            }
            if(reqAdd.equals("discount")){
                int discountID = scan.nextInt();
                int discountPercent = scan.nextInt();
            }
        }


    }
}
