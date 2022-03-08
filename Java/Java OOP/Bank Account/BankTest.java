public class BankTest {
    public static void main(String[] args){
        BankAccount account=new BankAccount(300.0,400.0);
        account.deposit(200.0,"savings");
        account.deposit(200.0,"checings");
        account.withdrawalSavings(100.0);
        account.withdrawalcheckings(200);
        account.displayBalance(); 
    }  
}
