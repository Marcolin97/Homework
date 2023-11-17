package homework;

import java.util.Random;

public class FindPrimeNums {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberCheck = rand.nextInt(100) + 1;

        if (prime(numberCheck)) {
            System.out.println("Il numero da verificare è:  " + numberCheck + " ed è un numero primo.");
        }else {
            System.out.println("Il numero da verificare è:  " + numberCheck + " e non è un numero primo.");
        }
    }
    public static boolean prime(int number){
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
