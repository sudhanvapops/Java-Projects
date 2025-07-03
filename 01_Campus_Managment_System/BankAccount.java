public abstract class BankAccount {
    
    protected String accountNumber;
    protected double balance;

    public String getAccountNumber(){
        return accountNumber;
    }
    
    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    abstract public void deposit(double amount);
    
    abstract public void withdraw(double amount);
}


class SavingAccount extends BankAccount{

    public SavingAccount(String accountNumber, double balance){
        super(accountNumber, balance);
    }

    public void giveIntrest(){
        // ! Yet to implemet
    }

    @Override
    public void deposit(double amount) {
        double balance = getBalance();
        setBalance(balance + amount);
    }

    @Override
    public void withdraw(double amount) {
        double rBalance = getBalance() - amount;
        if (rBalance >= 0){
            setBalance(rBalance);
        }

        // ! Show the message Not enough balance and display the balance

    }


}