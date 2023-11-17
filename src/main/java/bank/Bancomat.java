package bank;

import java.util.ArrayList;
import java.util.Scanner;



public class Bancomat {
    static ArrayList<Client> clientList = new ArrayList<>();
    static ArrayList<Account> accountList= new ArrayList<>();

    public static void main(String[] args) {
        Bancomat myBancomat = new Bancomat();
        myBancomat.menu();

    }

    private void menu() {
        Scanner tastierino = new Scanner(System.in);
        int choice;


        do {
            printMenu();
            choice = tastierino.nextInt();
            switch (choice) {
                case 1:
                    createClient();
                    break;
                case 2:
                    createAccount();
                    showAllAccount();
                    break;
                case 3:
                    addAccountToClient();
                    break;
                case 4:
                    showAllClient();
                    break;
                case 5:
                    searchClientById();
                    break;
                case 6:
                    System.out.println("Grazie per aver utilizzato Banca Generation. Arrivederci!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        } while (choice != 6);

    }

    private void printMenu() {
        System.out.println("Benvenuto in Banca Generation.");
        System.out.println("Inserire il tasto per eseguire l'apposita funzione.");
        System.out.println("1 : Crea un nuovo profilo Cliente.");
        System.out.println("2 : Crea un nuovo Account per il tuo profilo Cliente");
        System.out.println("3 : Associa un nuovo account a un Cliente esistente.");
        System.out.println("4 : Mostra la lista dei Clienti.");
        System.out.println("5 : Mostra un utente inserendo il suo NomeUtente.");
        System.out.println("6 : Esci.");


    }

    static void createClient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisca il proprio ID: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inserisca il suo Nome:  ");
        String firstName = scanner.nextLine();

        System.out.println("Inserisca il suo Cognome:  ");
        String lastName = scanner.nextLine();
        clientList.add(new Client(clientId, firstName, lastName));

    }
    void showAllAccount(){
        System.out.println("Lista di tutti gli Account:");
        for (Account account : accountList) {
            System.out.println("Id: " + account.getId() + "  con Bilancio:  " + account.getBalance());
        }
    }
    void showAllClient() {
        System.out.println("Lista di tutti i Client:");
        for (Client client : clientList) {
            System.out.println("Nome:  " + client.firstName + "///Cognome:  " + client.lastName + "///ID:  " + client.id);
        }
    }
    public void createAccount(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisca il suo Saldo:  ");
        double balance = scanner.nextDouble();

        Account account = new Account(balance);
        accountList.add(account);
        System.out.println("Questo è il tuo accountId:  "+ account.getId());
    }
    private void addAccountToClient(){
        showAllClient();
        showAllAccount();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleziona un IdCliente:  ");
        int idClient = scanner.nextInt();
        System.out.println("Seleziona un IdAccount da associare:  ");
        int idAccount = scanner.nextInt();
        Account accountToAdd = null;
        Client selectedClient = null;
        for (Account account : accountList){
            if (account != null && account.getId() == idAccount){
                accountToAdd = account;
            }
        }
        for (Client client : clientList){
            if (client != null && client.getId() == idClient) {
                selectedClient = client;
            }
        }
        if (accountToAdd == null || selectedClient == null){
            System.out.println("dati non esistenti");
            return;
        }
        int indexInsert = selectedClient.addAccountToClient(accountToAdd);
        if (indexInsert == -1) {
            System.out.println("il cliente sta pieno di soldi");
        } else {
            System.out.println("L'account è stato associato al cliente" + indexInsert);
            accountList.remove(accountToAdd);
        }
    }
    private void searchClientById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire l'Id da analizzare: ");
        int idClient = scanner.nextInt();
        for (Client client : clientList){
            if (client != null && client.getId() == idClient) {
                System.out.println(client);
            }
        }
    }
}