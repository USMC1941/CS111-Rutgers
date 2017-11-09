# CS111 Project - Blackjack - Milestone 4 (Extra Credit)

## Project Description

Attached is a GUI Framework and documentation on how to use it. You will get a maximum of 20 pts for your implementation. Much of the code can be refactored from your implementation in MS3. (Especially BlackJack.main() and the Deck/Player/Hand classes
 

You will be given a shell of a GUI. Here you can fill in as much or as little of your game engine that you wish. 20 pts is only for the base GUI (meaning the player can choose to hit/stand, and you report the result of the round). If you implement any of the other features you’ve developed in the sections above as a GUI, you are welcome to, but it is for your own enjoyment and sense of fulfillment.

## Suggested Implementation

Given the attached skeleton, below is the suggested way of completing the skeleton methods. Again, you can choose to ignore all of this and just use what you need for your project. It is entirely up to you.

For each class, define fields to store the information that each object of that class needs.

Each method in each file is commented to explain what it should do, what its arguments mean, and what it should return (if anything). Complete all required methods.

It is highly recommended that you complete the code in the following order, testing each class individually using your own driver:

1. Card
2. Deck
3. Hand
4. Player
5. Blackjack

Use the following algorithms:

**Deck constructor**

```
create an array to hold cards
for each possible suit (spades, hearts, clubs, diamonds)
	for each possible face (ace through king)
		create a card with the current suit and face and add it to the array
record that there are 52 cards in the deck
```

**Deck.shuffle**
```
for each card c in deck d:
	choose a random position p in the deck (how to use Random)
	swap c with the card at position p
```

**Hand.getScore**

```
add up the values of the cards in the hand
determine whether the hand contains an ace
if there is an ace and changing the ace's value from 1 to 11 would increase the player's score (without exceeding 21)
	increase the score by 10
```

**Player.startRound**
```
if the player is the dealer,
	deal one card FACE UP and one card FACE DOWN to the player
else
	deal two cards FACE UP to the player
```

**Player.playRound**
```
if the player is the dealer,
	draw cards until score is at least 17
else
	until user "busts" (goes over 21) or wants to "stand" (stop drawing cards)
		ask the user if he or she wants to "hit" (draw another card)
		if the user wants to hit
			draw a card
	if the user busted
		display message that user busted and therefore lost this round
```

**Player.finishRound**
```
if the player is not the dealer,
	if busted
		display message that player lost
	else if dealer busted
		display message that player won
	else
		display message win, lose, or push (depending on player's score relative to dealer)
discard all cards
```

**Blackjack.main**
```
ask the user how many players want to play
create Player objects for each player (ask user for player's name) and the dealer
create a BlackjackWindow
until the user wants to quit
	play a round
close the window
```

**Blackjack.playRound**

```
create and shuffle a deck
for each player
	start round (deal first two cards)
for dealer, start round (deal first two cards)
for each player
	let player play round
for dealer, play round
for each player
	finish round (announce results, discard cards)
for dealer, finish round (discard cards)
```

## Additional resources for assignment

* [Card.java](Card.java)
* [Deck.java](Deck.java)
* [blackjack.zip](blackjack.zip)
* [GIO.html](GIO.html)
* [BlackjackWindow.html](BlackjackWindow.html)
