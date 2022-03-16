public class Items {
    private String name;
    private double price;
    private int index;

    // constructor
    public Items(String name , double price){
        this.name=name;
        this.price=price;
    }

    // getter and setter
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setIndex(int index){
        this.index=index;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getIndex(){
        return index;
    }
}