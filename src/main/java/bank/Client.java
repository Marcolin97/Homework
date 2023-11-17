package bank;

public class Client extends Bancomat{
    public int id;
    public String firstName;
    public String lastName;
    private Account[] accounts;
    private static Client c;
    final int DIM_ARRAY = 2;


    public Client(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new Account[DIM_ARRAY];

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String result;
        result = "Il nome e cognome dell'utente:  " + firstName + " " + lastName + ".\n";
        for (Account account : accounts){
            if (account != null){
                result += "conto " + account.getId() + " con saldo : " + account.getBalance() + "\n";
            }
        }
        return result;
    }

    public int searchAccount(){
        int x = 0;
        for (Account account : accounts){
            if (account != null){
                x++;
            }
        }
        return x;
    }


    public int addAccountToClient(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                continue;
            }
            this.accounts[i]= account;
            return i + 1;
        }
        return -1;
    }
}