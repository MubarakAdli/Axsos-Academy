import java.util.ArrayList;

public class ListOfExceptions {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hello World");
        myList.add(48);
        myList.add("Goodbye World");
        for (int i = 0; i < myList.size(); i++) {
            try {
                int castedValue = (int) myList.get(i);
                System.out.println(castedValue);
            } 
            catch (Exception e) {
                
                System.out.println(e.getMessage());
                System.out.println("Error at" +" " +i);
            }
        }
    }
}