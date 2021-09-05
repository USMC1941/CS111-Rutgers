public class Methods {

    public static void main(String[] args) {
        int x = add(3, 4); // calls add(int, int)

        float z = add(3f, 4f); // calls add(float, float)

        // Math class has a bunch of overloaded methods
        int q = Math.min(3, 4);
        float f = Math.min(3f, 4f);

        // call stuff
        int n = 5;
        stuff(n);

        System.out.println(n); // 5

        f = 5f;
        f = stuff(f);
        System.out.println(f); // 10

        {
            int a = 2; // a declared inside a block
        }
        {
            int a = 4; // a declared inside a block, the previous a is not visible outside its block
        }
        // System.out.println(a);   // this line won't compile because a is declared inside a block

    }

    private static int add(int a, int b) { // OVERLOADED add method
        System.out.println("In add(int, int)");
        return a + b;
    }

    private static float add(float a, float b) { // OVERLOAD add method
        System.out.println("In add(float, float)");
        return a + b;
    }

    private static void stuff(int n) {
        n = 10;
    }

    private static float stuff(float f) {
        f = 10f;
        return f;
    }
}
