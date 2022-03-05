public class Cafe{
    public static void main( String [] args) {
        String greetGeneral = "Welcome to Cafe Java,"; 
        String  PendingMessage ="your order will be ready shortly";
        String  MessagingReady = "your order is ready";
        String  MensajeMostrarTotal  =  "Your total is " ;
        double  MochaPrice  =  3.5;
        double cupotchino=11.5;
        double latte=14.5;
        double coffee=12.5;
        String client1 ="Cindhuri";
        String client2="Sam";
        String client3="Jimmy";
        String client4="Noah";
        boolean isOrderready1=false;
        boolean isOrderready2=true;
        boolean isOrderready3=false;
        boolean isOrderready4=true;

        if  (isOrderready4) {
            System.out.println( client4 + " "+ MessagingReady + "," + " "+ MensajeMostrarTotal + cupotchino+ "$");
        }
        else {
        System.out.println(client4 +" "+  PendingMessage );
        }

        if  (isOrderready2) {
            System.out.println( client2 + " "+ MessagingReady + "," + " "+ MensajeMostrarTotal + (latte+latte) + "$");
        }
        else {
        System.out.println(client2 + " "+ PendingMessage );
        }
        if  (isOrderready3) {
            System.out.println( client3 + " "+ MessagingReady + "," + " "+ MensajeMostrarTotal + (latte-coffee) + "$");
        }
        else {
        System.out.println(client3 + " "+ PendingMessage );
        }
    }
}