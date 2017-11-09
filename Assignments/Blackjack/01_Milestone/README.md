# CS111 Project - Blackjack - Milestone 1

## Project Description

Please read this document in its entirety, before you start work. Understand what you need to hand in, and ask questions early and often.

In this project you will be using the knowledge you gained from lectures and homeworks and applying them to a lengthier programming assignment. The answers to some of your questions do not strictly reside in this document. You are encouraged to look at other sources for inspiration. 

This semester’s project will involve the casino game of blackjack. This is an individual project, and as such you will be held to the University’s academic integrity policies. You are welcome to discuss strategies and ideas with other students (and will be encouraged to in recitation), but you must code the project on your own.

This project is what you make of it. Listed below are point guidelines as to how they relate to the number of points given to the project (total 100). However, you should not be limited by what we suggest the minimum work required here is. To get the most out of this project, I urge you all to push yourselves to find your limits. You might surprise yourself! Good luck!

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

### Milestones

In order to help you make forward progress, you MUST complete one of each of these milestones every week. In fact, it is advisable to go ahead  and complete milestones earlier than the posted times. More Milestones will be released in the near future.

#### Week 1:

1. Complete the class definitions for Card.java and Deck.java. Write a main() method in a file called Blackjack.java that shows you have tested your Card.java and Deck.java code thoroughly. The description for the instance methods and fields are in the files attached to this assignment.

2. Write in a design document (text file) your general algorithm for how you would create a simple blackjack game main loop with wagering for two players (and the dealer). Describe your inputs and outputs as well as any error conditions that may occur. You should include when you would create objects and when you would call instance methods. Your algorithm should cover all of the rules listed above for the game of blackjack. You MAY include a flowchart to better describe your algorithm. You should (minimally) answer the following questions:
    * What is the condition of the main loop? When does it stop?
    * How do you figure out who has won?
    * How do you calculate earnings/losses per player?
    * How would your algorithm change to accommodate more than 2 players?

### Deliverables this week:

You should hand in the following files on sakai
* `Card.java` (completed)
* `Deck.java` (completed)
* `Blackjack.java` (completed with testing code in main())
* blackjack.txt (design document)
* Any other files you need to support the above.

### Additional resources for assignment

[Card.java]/Card.java)

[Deck.java](Deck.java)

