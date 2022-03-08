public class BankAccount{
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts;
    private static int totalAmount;
  

    public BankAccount(double checkingBalance,double savingsBalance){
        this.checkingBalance=checkingBalance;
        this.savingsBalance=savingsBalance;
        numberOfAccounts++;
    }
    public double checkingBalance(){
        return checkingBalance;
    }

    public double savingsBalance(){
        return savingsBalance;
    }
    
    public void deposit(double amount, String account) {
        if (account.equals("savings")) {
            savingsBalance += amount;
        }
         else {
             checkingBalance+= amount;
        }
        totalAmount += amount;
    }

    public void withdrawalSavings(double amount){
        if (savingsBalance - amount > 0){
            savingsBalance -=amount;
        }
        else {
            System.out.println("You cannot withdraw");
        }
            
        }

        public void withdrawalcheckings(double amount){
            if (checkingBalance - amount > 0){
                checkingBalance -=amount;
        }
            else {
                System.out.println("You cannot withdraw");
        }  
        }
        public double displayBalance() {
        return totalAmount;
        }
        }
