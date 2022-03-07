import java.util.ArrayList;
public class Order{
    private String name;
    private boolean ready;
    private ArrayList<Item> items=new ArrayList<Item>();

    public Order(){
        name="Guest";
        items=new ArrayList<Item>();

    }
    public Order(String name){
        this.name=name;
        items=new ArrayList<Item>();
    }

// Setters & Getters

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public boolean getReady(){
        return ready;
    }
    public void setReady(boolean ready){
        this.ready=ready;
    }

    public ArrayList<Item> getItems(){
        return items;
    }
    public void setItems(ArrayList<Item> items){
        this.items=items;
        
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage() {
        if (ready) {
            return "Your order is ready";
        } 
        else {
            return "Thank you for waiting. Your order will be ready soon";
        }
    }

    public void display(){
        System.out.println("Customer name:" +" "+ name);
        for(Item item : items){
            System.out.println( item.getName()+"-" +item.getPrice());

        }
    }
}
