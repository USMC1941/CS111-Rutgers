public class FaceTest {

    public static void main(String[] args) {
        Face bob = new Face(10, 100);
        bob.setExpression("sad");

        Face alice = bob;
        alice.setExpression("happy");
    }
}
