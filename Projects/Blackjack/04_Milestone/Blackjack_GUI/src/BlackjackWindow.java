import javax.swing.*;
import java.awt.*;

/**
 * A BlackjackWindow is a graphical window designed for the game of blackjack.
 * It knows how to display cards, hands, and players' names.
 */
public class BlackjackWindow extends JFrame {
   private static Image[]  cardImages;
   private final  Player[] players;

   /**
    * Create a BlackjackWindow for the given set of players.
    * Entry 0 of the input array should represent the dealer.
    */
   public BlackjackWindow(Player[] p) {
      if (p.length < 1 || p.length > 4) {
         throw new IllegalArgumentException("Player array length " + p.length + ", must be between 2 and 4.");
      }
      this.players = p;

      loadCardImages(this);

      this.setTitle("Blackjack");
      this.setSize(860, 480);

      Container content = getContentPane();
      content.setLayout(null);

      BlackjackPanel panel = new BlackjackPanel();
      content.add(panel);
      panel.setBounds(0, 0, 850, 450);
      panel.setBackground(Color.lightGray);

      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      this.setVisible(true);
   }

   private static void loadCardImages(BlackjackWindow window) {
      if (cardImages != null) {
         return;
      }

      final String[] faces = {"a", "2", "3", "4", "5", "6", "7", "8", "9", "t", "j", "q", "k"};
      final String[] suits = {"s", "h", "c", "d"};

      MediaTracker mt = new MediaTracker(window);
      Toolkit      tk = Toolkit.getDefaultToolkit();

      cardImages = new Image[54];
      int i = 0;
      for (int s = 0; s < 4; s++) {
         for (int f = 0; f < 13; f++) {
            cardImages[i] = tk.getImage("cards/" + faces[f] + suits[s] + ".gif");
            mt.addImage(cardImages[i], i);
            i++;
         }
      }
      cardImages[52] = tk.getImage("cards/b.gif");
      cardImages[53] = tk.getImage("cards/u.gif");
      mt.addImage(cardImages[52], 52);
      mt.addImage(cardImages[53], 53);

      for (i = 0; i < 54; i++) {
         try {
            mt.waitForID(i);
         }
         catch (InterruptedException e) {
            // should never happen
         }
      }
   }

   //////////////////////////////////////////////////////////////////////////////////////////////
   // inner classes
   //////////////////////////////////////////////////////////////////////////////////////////////

   /**
    * Re-draw the window -
    * this method should be called whenever there is a change to any player's cards.
    */
   public void redraw() {
      this.repaint();
      try {
         Thread.sleep(500);
      }
      catch (InterruptedException e) {
         // should never happen
      }
   }

   //////////////////////////////////////////////////////////////////////////////////////////////
   // static elements
   //////////////////////////////////////////////////////////////////////////////////////////////

   /**
    * Close the window (remove it from the screen) -
    * this method should be called when the game ends.
    */
   public void close() {
      this.setVisible(false);
      this.dispose();
   }

   private class BlackjackPanel extends JPanel {
      public void paintComponent(Graphics g) {
         super.paintComponent(g);

         if (BlackjackWindow.this.players == null) {
            return;
         }

         int numplayers = BlackjackWindow.this.players.length - 1;
         if (numplayers < 1 || numplayers > 3) {
            GIO.displayMessage("Error: invalid Player array length " + (numplayers + 1));
            System.exit(1);
         }

         for (int p = 0; p <= numplayers; p++) {
            Player player = BlackjackWindow.this.players[p];
            if (player == null) {
               GIO.displayMessage("Error: player[" + p + "] is null");
               System.exit(1);
            }

            Hand hand = player.getHand();
            if (hand == null) {
               GIO.displayMessage("Error: player.getHand() returned null");
               System.exit(1);
            }

            String name = "" + player.getName();

            g.setColor(Color.black);
            g.drawString(name, 50 + (p % 2 * 400), 50 + (p / 2 * 200));
            paintHand(g, 50 + (p % 2 * 400), 70 + (p / 2 * 200), hand);
         }
      }

      void paintHand(Graphics g, int x, int y, Hand hand) {
         if (hand == null) {
            return;
         }

         int numcards = hand.getNumberOfCards();
         if (numcards < 0 || numcards > 12) {
            GIO.displayMessage("Error: hand.getNumberOfCards() returned " + numcards);
            System.exit(1);
         }

         for (int i = 0; i < numcards; i++) {
            paintCard(g, x + i * 25, y, hand.getCard(i));
         }
      }

      void paintCard(Graphics g, int x, int y, Card card) {
         Image cardImage;

         if (card == null) {
            cardImage = cardImages[53];
         }
         else {
            int suit = card.getSuit();
            int face = card.getFace();

            if (card.isFaceUp()) {
               if (suit < 0 || suit > 3 || face < 1 || face > 13) {
                  cardImage = cardImages[53];
               }
               else {
                  cardImage = cardImages[suit * 13 + face - 1];
               }
            }
            else {
               cardImage = cardImages[52];
            }
         }

         g.drawImage(cardImage, x, y, null);
      }
   }
}
