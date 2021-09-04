package examples;

public class Methods {

    /** Definition of method factorial */
    public static int factorial(int n) {
        int result = 1;
        for (int count = 1; count <= n; count++) {
            result = result * count;
        }
        return result;
    }

    /** Definition of method main */
    public static void main(String[] args) {
        int x = 4;
        int fact = factorial(x);
        System.out.println(fact);
    }
}
