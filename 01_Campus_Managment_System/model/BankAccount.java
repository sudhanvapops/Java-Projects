package model;
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
