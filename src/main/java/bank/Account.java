package bank;

public class Account {
    private double balance;
    private static int accountId;
    private int id;
    public Account (double balance){
        this.balance = balance;
        this.id = accountId;
        accountId ++;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }
}
