public class Test {
    public static void main(String[] args) {
        CoffeKiosk order = new CoffeKiosk();
        Items item1 = new Items("Coffee",2);
        Items item2 = new Items("Tea",1.5);
        Items item3 = new Items("Mocha",0.5);
        Items item4 = new Items("Milk",3);

        order.addMenuItem(item1);
        order.addMenuItem(item2);
        order.addMenuItem(item3);
        order.addMenuItem(item4);

        order.newOrder();
    }
}