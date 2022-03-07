public class OrderTest {
    public static void main(String[] args){

        Order order1=new Order();
        Order order2=new Order();
        Order order3=new Order("Mubarak");
        Order order4=new Order("Ahmed");
        Order order5=new Order("Mohammed");

        Item item1=new Item("drip coffee",1.50);
        Item item2=new Item("capuccino",3.50); 

        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item1);
        order2.addItem(item2);
        order3.addItem(item1);
        order3.addItem(item2);
        order4.addItem(item1);
        order4.addItem(item2);
        order5.addItem(item1);
        order5.addItem(item2);

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        order1.setReady(false);
        order2.setReady(true);
        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());
    }
    
}
