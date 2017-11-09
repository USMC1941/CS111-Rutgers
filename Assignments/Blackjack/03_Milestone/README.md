# CS111 Project - Blackjack - Milestone 3

## Project Description

Please read this document in its entirety, before you start work. Understand what you need to hand in, and ask questions early and often.

In this project you will be using the knowledge you gained from lectures and homeworks and applying them to a lengthier programming assignment. The answers to some of your questions do not strictly reside in this document. You are encouraged to look at other sources for inspiration. 

This semester’s project will involve the casino game of blackjack. This is an individual project, and as such you will be held to the University’s academic integrity policies. You are welcome to discuss strategies and ideas with other students (and will be encouraged to in recitation), but you must code the project on your own.


### Rules of Blackjack

For this assignment, you will implement a video card game. The game is a simplified version of [blackjack](https://en.wikipedia.org/wiki/Blackjack), where some of the more complex rules have been eliminated.

Blackjack is played with a "deck" (pile) of 52 cards. The front of each card shows symbols and numbers that identify the card. The back of each card is identical, so that you cannot tell which card it is by looking at the back. Each card has one of 4 possible "suits": spades, hearts, clubs, or diamonds. Each suit has its own special symbol. Spade and club cards have black symbols and numbers on the front, while heart and diamond cards have red symbols. Each card also has one of 13 possible "faces": ace (A), 2, 3, 4, 5, 6, 7, 8, 9, 10, jack (J), queen (Q), or king (K). The face of a card determines its numerical scoring value. Numbered cards are worth their number of points. Jacks, queens, and kings are all worth 10 points each. Aces can be worth 1 point or 11 points, depending on the circumstances.

A player's "hand" is the set of cards the player currently holds. The score of the hand is the sum of the point values of its cards. The goal in blackjack is to acquire a hand whose score is as high as possible without going over 21. The point value of an ace card is whatever is most advantageous to the player: 1 or 11, whichever would bring the score of the player's hand closer to 21 without exceeding it.

A game of blackjack may involve any number of players (but for our purposes, three or fewer), and always exactly one "dealer": the person who "deals" (hands out) the cards. Players compete against the dealer, not against each other. A player's goal in a round of blackjack is to have a higher score than the dealer, without going over 21 ("busting").

Each round of simplified blackjack proceeds as follows:

1. The dealer shuffles the deck and deals two cards "face up" (with the front of the card showing) to each player.
2. The dealer deals one card "face down" (with only the back showing) and one card "face up" to himself.
3. The dealer asks the first player whether she wishes to "hit" (receive another card) or "stand" (not receive any more cards).
    * If she chooses to stand, she will not receive any more cards this round, so her score is fixed. The game moves on to the next player.
    * If she chooses to hit, the dealer will deal her another card, face up, and her score increases. She will then be given the option to hit or stand again.
    * If her score exceeds 21, she has "busted" and immediately loses this round - play will continue with the next player.
    * Essentially, the player can continue to hit until she either decides to stand, or busts.
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

### Milestone 3

#### Implement Advanced Play   18 pts (6 each)

In this Milestone, you will be implementing advanced play. You are to implement the following mechanisms:

- Splitting
- Doubling Down
- Insurance

A description of each one of these mechanisms is given in the wikipedia article on blackjack.

* [2.1 Player decisions](https://en.wikipedia.org/wiki/Blackjack#Player_decisions)
* [2.2 Insurance](https://en.wikipedia.org/wiki/Blackjack#Insurance)

#### Hints System 12 pts

The next step is to build in a hints system. Here you will advise the players what their “best” course of strategy is. You can use any strategy you choose, but be prepared to defend your decision! 

You can start off your hints system by just giving general playing advice based on the rules of the game, and maybe your feelings of what might be a good system, perhaps from your very limited experiences from your experiments above. 

Later on, it is probably a good idea to include some probability into the mix. Eventually, a card counting strategy (remembering what cards have come out) would be best.

Choose your implementation:

* Basic hints - advise the player on what to do given the basic rules of blackjack: + 6/12 pts
* Basic static probabilities based on hand values - you can look up the decision tables on many websites across the web: +8/12 pts
* Card counting + probability based on card counting - this requires keeping track of the cards that have been dealt thus far, as well as the cards that are currently face up  +12/12 pts
    * See: [4.3.1 Card counting](https://en.wikipedia.org/wiki/Blackjack#Card_counting)

#### Documentation 5 pts

Finally, you should provide documentation both in line (as comments) and external (as a text document). Comments should describe your algorithms briefly so that the grader understand what you did. 


Blackjack.txt should include your rationale for making the decisions that you did for the hint system, and should be more in depth. Describe how your implementation deviates from your design submitted in MS2. You should also describe any problems and challenges you encountered, and any lessons learned.

You should submit:
* `Blackjack.java` - full game play with advanced features, wagering, and hint system
* `Deck.java`
* `Card.java`
* Blackjack.txt - documentation file
* Any other supporting files necessary to compile and run your program.