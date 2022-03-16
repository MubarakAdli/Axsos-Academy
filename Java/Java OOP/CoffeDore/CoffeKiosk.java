import java.util.ArrayList;

public class CoffeKiosk {
    public ArrayList<Items> menu ;
    public ArrayList<Order> order ;

    // constructor 
    public CoffeKiosk(){
        menu=new ArrayList<Items>();
        order=new ArrayList<Order>();
    }
        //methods
        public void addMenuItem(Items item){
            menu.add(item);
            item.setIndex(menu.size()-1);
            
        }

        public void displayMenu(){
            for (int i =0 ; i<menu.size();i++){
                System.out.println(i +" "+ menu.get(i).getName() + " "+menu.get(i).getPrice() );
            }
        }

        public void newOrder(){
        System.out.println("Please enter customer name for new order:");
        String Name = System.console().readLine();
        Order order1= new Order(Name);
        order.add(order1);
        displayMenu();
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        while(! itemNumber.equals("q")){
            order1.addItems(menu.get(Integer.parseInt(itemNumber)));
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        order1.display();
        }
    
}