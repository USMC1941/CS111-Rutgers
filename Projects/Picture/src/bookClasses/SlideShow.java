package bookClasses;

public class SlideShow {
   private Picture[] pictureArray;
   private int       waitTime = 2000;

   public SlideShow() {
   }

   public SlideShow(Picture[] pictArray) {
      this.pictureArray = pictArray;
   }

   public int getWaitTime() {
      return this.waitTime;
   }

   public void setWaitTime(int theWaitTime) {
      if (theWaitTime >= 500) {
         this.waitTime = theWaitTime;
      }

   }

   public Picture getPicture(int index) {
      return this.pictureArray != null && index >= 0 && index < this.pictureArray.length ? this.pictureArray[index] : null;
   }

   public void setPicture(Picture aPict, int index) {
      if (this.pictureArray != null && index >= 0 && index < this.pictureArray.length && aPict != null) {
         this.pictureArray[index] = aPict;
      }

   }

   public String toString() {
      return this.pictureArray == null
              ? "A slide show with no pictures and a wait time of " + this.waitTime
              : "A slide show with " + this.pictureArray.length + " pictures and " + "a wait time of " + this.waitTime;
   }

   public void show() throws Exception {
      if (this.pictureArray != null) {
         Picture[] arr = this.pictureArray;
         int       length = arr.length;

         for (int i = 0; i < length; ++i) {
            Picture pictObj = arr[i];
            pictObj.show();
            Thread.sleep(this.waitTime);
            pictObj.hide();
         }
      }

   }

   public static void main(String[] args) throws Exception {
      Picture[] pictArray = new Picture[]{new Picture(FileChooser.getMediaPath("beach.jpg")), new Picture(
              FileChooser.getMediaPath("blueShrub.jpg")), new Picture(FileChooser.getMediaPath("church.jpg")), new Picture(
              FileChooser.getMediaPath("eiffel.jpg")), new Picture(FileChooser.getMediaPath("greece.jpg"))};
      SlideShow vacShow   = new SlideShow(pictArray);
      System.out.println(vacShow);
      vacShow.show();
   }
}
