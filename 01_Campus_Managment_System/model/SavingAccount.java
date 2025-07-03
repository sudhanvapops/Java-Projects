package model;

public class SavingAccount extends BankAccount{

    public SavingAccount(String accountNumber, double balance){
        super(accountNumber, balance);
    }

    public void giveIntrest(){
        // ! Yet to implemet
    }


    @Override
    public String toString() {
        return "Savings BankAccount { accountNumber: " + accountNumber + ", balance: " + balance + " }";
    }


}
