package homework;

import java.util.Random;
import java.util.Scanner;

public class IndovinaNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Creiamo un oggetto che genererà un numero casuale tra 0 e 1000
        Random random = new Random();
        int numeroSegreto = random.nextInt(1001); // Genera un numero tra 0 e 1000
        int tentativo, tentativi = 0;
        boolean indovinato = false;

        System.out.println("Giochiamo insieme! Vediamo se indovini un numero da 0 a 1000");

        while (!indovinato) {
            System.out.print("Allora, che numero scegli?: ");
            tentativo = scanner.nextInt();
            // Contatore di Tentativi
            tentativi++;
            
            if (tentativo == numeroSegreto) {
                System.out.println("Bravo, Hai indovinato il numero " + numeroSegreto + " in " + tentativi + " tentativi.");
            } else {
                if (tentativo < numeroSegreto) {
                    System.out.println("Il numero è più grande.");
                } else {
                    System.out.println("Il numero è più piccolo.");
                }
            }
        }

        scanner.close();
    }
}