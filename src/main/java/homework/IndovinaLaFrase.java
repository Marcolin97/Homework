package homework;

import java.util.Random;
import java.util.Scanner;

public class IndovinaLaFrase {

    public static void main(String[] args) {
        String[] frasi = {              //chiedere per i caratteri speciali
                "Marco è Simpatico",
                "Mike è il miglior prefetto",
                "Severus Piton suca",
                "Lunghissimo Basilisco",
                "Mi sono perso per Diagon Alley",
                "Viva la Pizza Napoletana",
                "Pluto è un Cane ma Pippo no",
                "Benvenuti nella casa di topolino",
                "FinalFantasy Nove miglior Final Fantasy",
                "Dark Souls Due non è un vero Souls"
        };

        Random rand = new Random();
        //scegliamo randomicamente una delle frasi da noi scelte
        String fraseDaIndovinare = frasi[rand.nextInt(frasi.length)].toUpperCase();
        //definiamo un array di caratteri composto al massimo dalla lungezza della frase da indovinare
        char[] indovinato = new char[fraseDaIndovinare.length()];
        //ciclo for per sostituire i caratteri della frase con spazi e _
        for (int i = 0; i < fraseDaIndovinare.length(); i++) {
            if (fraseDaIndovinare.charAt(i) == ' ') {
                indovinato[i] = ' ';
            } else {
                indovinato[i] = '_';
            }
        }

        Scanner scanner = new Scanner(System.in);

        int tentativiRimasti = 5;
        while (tentativiRimasti > 0) {
            System.out.println("La frase da indovinare è: " + new String(indovinato));
            System.out.println("I tuoi Tentativi rimasti: " + tentativiRimasti);
            System.out.print("Inserisci una lettera: ");
            char lettera = scanner.next().toUpperCase().charAt(0);

            boolean indovinatoCorrettamente = false;
            for (int i = 0; i < fraseDaIndovinare.length(); i++) {
                if (fraseDaIndovinare.charAt(i) == lettera) {
                    indovinato[i] = lettera;
                    indovinatoCorrettamente = true;
                }
            }

            if (!indovinatoCorrettamente) {
                tentativiRimasti--;
            }

            if (fraseIndovinata(indovinato)) {
                System.out.println("Complimenti! Hai indovinato la frase: " + fraseDaIndovinare);
                break;
            }
        }

        if (tentativiRimasti == 0) {
            System.out.println("Mi dispiace, hai fallito. La frase era: " + fraseDaIndovinare);
        }

        scanner.close();
    }

    private static boolean fraseIndovinata(char[] indovinato) {
        for (char c : indovinato) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
