package model;

public class SavingAccount extends BankAccount{

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

    @Override
    public String toString() {
        return "Savings BankAccount { accountNumber: " + accountNumber + ", balance: " + balance + " }";
    }


}
