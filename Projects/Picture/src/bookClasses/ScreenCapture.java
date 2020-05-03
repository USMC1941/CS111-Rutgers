package bookClasses;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenCapture {

   public ScreenCapture() {

   }

   public static void main(String[] args) throws AWTException, IOException {
      BufferedImage screencapture = (new Robot()).createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
      File          file          = new File("screencapture.jpg");
      ImageIO.write(screencapture, "jpg", file);
   }
}
