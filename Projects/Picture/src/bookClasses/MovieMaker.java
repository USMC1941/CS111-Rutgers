package bookClasses;

import java.awt.*;

public class MovieMaker {
   public static void main(String[] args) {
      MovieMaker maker = new MovieMaker();
      maker.makeRectangleMovie("c:/temp/rect/");
   }

   public void makeRectangleMovie(String directory) {
      int            framesPerSec   = 30;
      Picture        p              = null;
      Graphics       g              = null;
      FrameSequencer frameSequencer = new FrameSequencer(directory);
      frameSequencer.setShown(true);

      // loop through the first second
      for (int i = 0; i < framesPerSec; i++) {
         // draw a filled rectangle
         p = new Picture(640, 480);
         g = p.getGraphics();
         g.setColor(Color.RED);
         g.fillRect(i * 10, i * 5, 50, 50);

         // add frame to sequencer
         frameSequencer.addFrame(p);
      }

      // play the movie
      frameSequencer.play(framesPerSec);
   }
}
