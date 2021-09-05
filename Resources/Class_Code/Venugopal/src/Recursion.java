public class Recursion {

    /** n is assumed to be >= 1 */
    public static int fact(int n) {
        // termination condition (also known as base case)
        if (n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    /** n is assumed to be >= 0. sequence is 0,1,1,2,3,5,8,13,21,34.... */
    public static int fib(int n) {
        // fib(0)=0 and fib(1)=1
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static boolean palindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return palindrome(s.substring(1, s.length() - 1));
    }

    /** called by any application that needs to find max */
    public static int max(int[] arr) {
        // call recursive helper method with 0 as start index
        return max(arr, 0);
    }

    private static int max(int[] arr, int start) {
        // termination
        if (start == (arr.length - 1)) {
            return arr[start];
        }
        return Math.max(arr[start], max(arr, start + 1));
    }

    // version 2
    private static int max2(int[] arr, int previous, int start) {
        // termination
        if (start == (arr.length - 1)) {
            return Math.max(previous, arr[start]);
        }
        return Math.max(previous, max2(arr, arr[start], start + 1));
    }

    private static void printLine(int n) {
        System.out.print('k');
        for (int i = 0; i < n - 1; i++) {
            System.out.print(' ');
        }
        System.out.println('k');
    }

    public static void bigK(int size) {
        // termination
        if (size == 1) {
            System.out.println('k');
            return;
        }
        // print top line
        printLine(size);

        // recurse to build smaller nested big K
        bigK(size - 1);

        // print bottom line
        printLine(size);
    }

    /** called by any application that needs to search */
    public static boolean binarySearch(int[] arr, int target) {
        // call recursive helper method
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    private static boolean binarySearch(int[] arr, int target, int lo, int hi) {
        // termination if there is only one thing left
        if (lo == hi) {
            return target == arr[lo];
        }
        int mid = (lo + hi) / 2;
        // termination if target matches mid
        if (target == arr[mid]) {
            return true;
        }
        if (target < arr[mid]) {
            // recurse on left half
            return binarySearch(arr, target, lo, mid - 1);
        } else {
            // recurse on right half
            return binarySearch(arr, target, mid + 1, hi);
        }
    }

    /** move n disks from t1 to t2 using t3 */
    public static void hanoi(int n, char t1, char t2, char t3) {
        if (n == 1) {
            System.out.println("Move disk from " + t1 + " to " + t2);
            return;
        }
        hanoi(n - 1, t1, t3, t2);
        System.out.println("Move disk from " + t1 + " to " + t2);
        hanoi(n - 1, t3, t2, t1);
    }

    public static void main(String[] args) {
        System.out.print(
                "(f)act, f(i)b, (p)alindrome, big(k), (m)ax, (b)inary search, (h)anoi, or (q)uit? ");
        char ch = Character.toLowerCase(IO.readChar());
        while (ch != 'q') {
            if (ch == 'h') {
                System.out.print("Enter n (1 or more): ");
                int n = IO.readInt();
                hanoi(n, 'A', 'B', 'C');
            }
            if (ch == 'f') {
                System.out.print("Enter n (1 or more): ");
                int n = IO.readInt();
                System.out.println(fact(n));
            } else if (ch == 'i') {
                System.out.print("Enter n (0 or more): ");
                int n = IO.readInt();
                System.out.println(fib(n));
            } else if (ch == 'p') {
                System.out.print("Enter string: ");
                System.out.println(palindrome(IO.readString()));
            } else if (ch == 'k') {
                System.out.print("Enter size: ");
                int size = IO.readInt();
                bigK(size);
            } else if (ch == 'm') {
                int[] arr = {19, 2, 15, 41, 72, 59, 12};
                System.out.println("max = " + max(arr));
            } else if (ch == 'b') {
                int[] arr = {2, 5, 14, 19, 41, 52, 59, 72};
                System.out.println("52 in array? : " + binarySearch(arr, 52));
                System.out.println("100 in array? : " + binarySearch(arr, 100));
            }
            System.out.print(
                    "(f)act, f(i)b, (p)alindrome, big(k), (m)ax, (b)inary search, (h)anoi, or (q)uit? ");
            ch = Character.toLowerCase(IO.readChar());
        }
    }
}
