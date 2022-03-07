
public class OrdersTest {
    public static void main(String[] args){
        Items item1 = new Items();
        Items item2 = new Items();
        Items item3 = new Items();
        Items item4 = new Items();

        item1.name="mocha"; 
        item1.price=10.0;
        item2.name="latte"; 
        item2.price=12.0;
        item3.name="drip cofee"; 
        item3.price=14.0;
        item4.name="capuccino";
        item4.price=16.0;

        Orders order1=new Orders();
        Orders order2=new Orders();
        Orders order3=new Orders();
        Orders order4=new Orders();
        
        order1.name="Cindhuri";
        order2.name="Jimmy";
        order3.name="Noah";
        order4.name="Sam";
        
        order2.items.add(item2);
        order2.total+=item1.price;
        order3.items.add(item4);
        order3.total+=item4.price;
        order4.items.add(item2);
        order4.total+=item2.price;
        order1.ready=true;
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total+=2*(item2.price);
        System.out.println(order4.total);
        System.out.println(order1.total);
        order2.ready=true;
        
    }
    
}
