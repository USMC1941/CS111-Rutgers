public class MultTable {

    public static void main(String[] args) {
        int num = IO.readInt();
        for (int count2 = 1; count2 <= num; count2++) {
            for (int count = 1; count <= num; count++) {
                System.out.print(count * count2 + " ");
            }
            System.out.println();
        }
    }
}
