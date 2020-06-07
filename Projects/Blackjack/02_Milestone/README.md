# CS111 Project - Blackjack - Milestone 2

## Project Description

Please read this document in its entirety, before you start work. Understand what you need to hand in, and ask questions early and often.

### Rules of Blackjack

For this assignment, you will implement a video card game. The game is a simplified version of [blackjack](https://en.wikipedia.org/wiki/Blackjack), where some of the more complex rules have been eliminated.

Blackjack is played with a "deck" (pile) of 52 cards. The front of each card shows symbols and numbers that identify the card. The back of each card is identical, so that you cannot tell which card it is by looking at the back. Each card has one of 4 possible "suits": spades, hearts, clubs, or diamonds. Each suit has its own special symbol. Spade and club cards have black symbols and numbers on the front, while heart and diamond cards have red symbols. Each card also has one of 13 possible "faces": ace (A), 2, 3, 4, 5, 6, 7, 8, 9, 10, jack (J), queen (Q), or king (K). The face of a card determines its numerical scoring value. Numbered cards are worth their number of points. Jacks, queens, and kings are all worth 10 points each. Aces can be worth 1 point or 11 points, depending on the circumstances.

A player's "hand" is the set of cards the player currently holds. The score of the hand is the sum of the point values of its cards. The goal in blackjack is to acquire a hand whose score is as high as possible without going over 21. The point value of an ace card is whatever is most advantageous to the player: 1 or 11, whichever would bring the score of the player's hand closer to 21 without exceeding it.

A game of blackjack may involve any number of players (but for our purposes, three or fewer), and always exactly one "dealer": the person who "deals" (hands out) the cards. Players compete against the dealer, not against each other. A player's goal in a round of blackjack is to have a higher score than the dealer, without going over 21 ("busting").

Each round of simplified blackjack proceeds as follows:

1. The dealer shuffles the deck and deals two cards "face up" (with the front of the card showing) to each player.
2. The dealer deals one card "face down" (with only the back showing) and one card "face up" to himself.
3. The dealer asks the first player whether she wishes to "hit" (receive another card) or "stand" (not receive any more cards).
   -  If she chooses to stand, she will not receive any more cards this round, so her score is fixed. The game moves on to the next player.
   -  If she chooses to hit, the dealer will deal her another card, face up, and her score increases. She will then be given the option to hit or stand again.
   -  If her score exceeds 21, she has "busted" and immediately loses this round - play will continue with the next player.
   -  Essentially, the player can continue to hit until she either decides to stand, or busts.
4. The hit-or-stand process is then repeated for each other player.
5. Once all players are done, it is the dealer's turn to play. First, he turns his face-down card over. Then he hits until his score is 17 or higher. The dealer cannot decide to hit or stand arbitrarily. If his score is less than 17, he must hit. If it is 17 or higher, he must stand.
6. If the dealer busts, any players who did not bust earlier win this round. Otherwise, each player's score is compared to that of the dealer. A player wins if he has a higher score than the dealer, loses if he has a lower score, and "pushes" (ties) if he has the same score.

At the end of each round, the group of players can decide whether they would like to play again.

### Deliverables:

At the end of the 4 week project, you will be graded on the following deliverables.

1. Source code – the code you write to accomplish the project
2. Program Demo – show your peer leader a demo of your code
3. Code Review – describe some of your code to your peer leader
4. Documentation – a 1-2 pg document that outlines the challenges you faced working on the project, the interesting lessons learned, and the thinking behind the main algorithms. Also, you are to analyze the efficiency of the various algorithms that you implement. It might be useful to keep a project diary as you move through the project

### Milestone 2

Write the program that you described in your previous milestone. Your main game loop should ask the user how many players, and allow that many players to play the game. You may assume a max of 6 players. You should allow your players to wager some amount of money on each play.

Now that you have the basics of the game play, expand your game to include a wagering system. Give each player a bankroll to start with, then allow him/her to wager on the game. You should end the game with the output of each player's ending balance.

Write a design document describing how you need to change your code to include the following features of MS3 (next week's milestone).

-  Advanced play including insurance, splitting and doubling down
   -  You can and should look to real blackjack games for inspiration and wagering rules. (Double down, splits, blackjacks, etc) (You can make one player the “dealer” and play solely by house dealer rules (hit/stand on soft 17s). Get a feel for what good strategy is and see how much you win/lose over 10 rounds.
-  A hint system
   -  Give new players some help on how to play. e.g. give the user an option to ask for a hint. The hint should be based on reality: whether to hit or stand is based on card/value probabilities as well as what is "showing" in the dealers hand.
   -  How would you devise a hinting system? Give some ideas using static probabilities. There are many resources on line that show basic blackjack strategy that you might want to investigate.
   -  The ambitious student might want to take a look at developing a hint system based on dynamic probabilities (e.g. what cards have already been dealt, what cards are face up currently, and how probability changes.

### What to submit:

-  `Blackjack.java` Your main game engine/loop. This is what your graders will run to test your game. You should comment your code enough so the grader understands what you have done.
-  `Card.java`, `Deck.java`, and any other supporting files that need to accompany your program to make it work. Uncompileable code receives NO CREDIT
-  design.txt - Your design document for the next milestone

### Point distribution for MS2:

Basic game loop functionality 20/35 pts

Basic wagering system 10/35 pts

Design Document 5/35 pts
