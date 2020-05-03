package bookClasses;

public class TurtleDropTest {
   public static void main(String[] args) {
      World   world  = new World();
      Turtle  turtle = new Turtle(world);
      Picture p      = new Picture(FileChooser.getMediaPath("flower1.jpg"));
      turtle.penUp();
      for (int i = 45; i < 360; i = i + 45) {
         turtle.drop(p);
         turtle.turn(i);
      }
   }
}
