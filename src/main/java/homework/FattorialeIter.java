package homework;

public class FattorialeIter {
    public static void main(String[] args) {
        System.out.println(fattorialeIterativo(7));
    }

    public static int fattorialeIterativo(int n) {
        int fatt = 1;
        for (int i = 1; i <= n; i++) {
            fatt *= i;
        }
        return fatt;
    }
}