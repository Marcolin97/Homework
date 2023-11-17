package homework;

public class FattorialeRicor {
    public static void main(String[] args) {
        System.out.println(fattorialeRicor(7));
    }
    public static int fattorialeRicor(int n){
        if (n == 1){
            return 1;
        }else{
            return n * fattorialeRicor(n-1);
        }
    }
}
