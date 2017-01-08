import java.util.*;
public class Game21
{
    public static void main(String args[])
    {
        int playerScore = 0; // players combined hand score
        int computerScore = 0;
        int playerHandScore = 0; //value of card recieved from hit
        int computerHandScore = 0; //value of card recieved from hit
        int playerHandsWon = 0; // number of hands the player won
        int computerHandsWon = 0; // number of hands the dealer won
        Cards computerTempCard; // card dealer recieves from hit
        Cards playerTempCard; // card player recieves from hit
        char hit; // choice to hit or stand
        char playAgain = 'y'; // choice to play again
        Scanner input; // instance of scanner object
        
        input = new Scanner(System.in); // creates input object
        Deck playerDeck = new Deck(); // creates a deck of cards for the player
        Deck computerDeck = new Deck(); // creates a deck of cards for the dealer
        playerDeck.shuffle(); // shuffles the players deck
        computerDeck.shuffle(); // shuffles the dealers deck
        
        System.out.println("Welcome to Blackjack! Let's begin!!");
    
        do
        {
            System.out.println("The dealer drew:");
            computerTempCard = computerDeck.getTopCard(); // draws first card from dealer's deck
            computerScore += computerTempCard.getValue(); // adds value of card to dealer's score
            System.out.println(computerTempCard.toString()); // displays dealer's card
            computerTempCard = computerDeck.getTopCard(); // draws next card from dealer's deck
            computerScore += computerTempCard.getValue(); // adds value to dealer's score
            System.out.println(computerTempCard.toString());
            System.out.println("The Dealer has: " + computerScore + " points!" + "\n"); // displays dealer's total score
            
            System.out.println("You drew:");
            playerTempCard = playerDeck.getTopCard(); // draws first card from player's deck
            playerScore += playerTempCard.getValue(); // adds value of card to player's score
            System.out.println(playerTempCard.toString()); // displays player's card
            playerTempCard = playerDeck.getTopCard(); // draws next card from player's deck
            playerScore += playerTempCard.getValue(); // adds value to player's score
            System.out.println(playerTempCard.toString());
            System.out.println("You have: " + playerScore + " points!" + "\n"); // displays player's total score
            
            System.out.print("Hit or stand? Enter 'H' or 'h' for hit, 'S' or 's' for stand: ");
            hit = input.next().charAt(0);
            while ((hit == 'H' || hit == 'h') && (playerScore <= 21 && computerScore <= 21)) // loops while player chooses to hit and both players are under 21
            {
                if(computerScore <= 16)
                {
                    computerTempCard = computerDeck.getTopCard();
                    computerHandScore = computerTempCard.getValue();
                    if ((computerTempCard.getFace() == "Ace") && (computerHandScore + computerScore >= 21)) // determines if ace will have a value of 1 or 11
                    {
                        computerHandScore = 1; // sets ace value to 1
                        computerScore += computerHandScore; // adds value to score
                        System.out.println("The dealer drew:");
                        System.out.println(computerTempCard.getFace() + " of " + computerTempCard.getSuit() + " " + 1 + " point!");
                        System.out.println("The Dealer has: " + computerScore + " points!" + "\n");
                    }
                    else
                    {
                        computerScore += computerHandScore;
                        System.out.println("The dealer drew:");
                        System.out.println(computerTempCard.toString());
                        System.out.println("The Dealer has: " + computerScore + " points!" + "\n");
                    }
                }
                
                playerTempCard = playerDeck.getTopCard();
                playerHandScore = playerTempCard.getValue();
                if ((playerTempCard.getFace() == "Ace") && (playerHandScore + playerScore >= 21)) // determines if ace will have a value of 1 or 11
                {
                    playerHandScore = 1;
                    playerScore += playerHandScore;
                    System.out.println("You drew:");
                    System.out.println(playerTempCard.getFace() + " of " + playerTempCard.getSuit() + " " + 1 + " point!");
                    System.out.println("You have: " + playerScore + " points!" + "\n");
                }
                else
                {
                    playerScore += playerHandScore;
                    System.out.println("You drew:");
                    System.out.println(playerTempCard.toString());
                    System.out.println("You have: " + playerScore + " points!" + "\n");
                }
                
                System.out.println("Hit or stand? Enter 'H' or 'h' for hit, 'S' or 's' for stand: ");
                hit = input.next().charAt(0);
            }
            
            if ((computerScore > playerScore) && (computerScore <= 21)) // determines who won the hand
            {
                System.out.println("Dealer Wins this hand!");
                computerHandsWon++; // tallies the win
                System.out.println("Play Again?: ");
                playAgain = input.next().charAt(0);
            }
            else if ((computerScore < playerScore) && (playerScore <= 21))
            {
                System.out.println("You Win this hand!");
                playerHandsWon++; // tallies the win
                System.out.println("Play Again?: ");
                playAgain = input.next().charAt(0);
            }
            else if (computerScore > 21)
            {
                System.out.println("Dealer Busts, You Win this hand!");
                playerHandsWon++; // tallies the win
                System.out.println("Play Again?: ");
                playAgain = input.next().charAt(0);
            }
            else if (computerScore == playerScore)
            {
                System.out.println("Push! No one wins this hand!");
                System.out.println("Play Again?: ");
                playAgain = input.next().charAt(0);
            }
            else if (playerScore > 21)
            {
                System.out.println("You've Bust, Dealer Wins this hand!");
                computerHandsWon++; // tallies the win
                System.out.println("Play Again?: ");
                playAgain = input.next().charAt(0);
            }
            computerScore = 0; //resets for next round
            playerScore = 0; //resets for next round
            hit = 'h'; //resets for next round
        } while(playAgain == 'y');
        
        System.out.println("Player: " + playerHandsWon + "\tDealer: " + computerHandsWon);
        if (computerHandsWon > playerHandsWon) // determines overall winner
            {
                System.out.println("Sorry, Dealer Wins!");
                System.out.println("Thanks for playing!");
            }
        else if (computerHandsWon < playerHandsWon)
            {
                System.out.println("You Win!!!");
                System.out.println("Thanks for playing!");
            }
    }
}
