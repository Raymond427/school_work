import java.util.Random;
public class Deck
{
    public Cards [] deck = new Cards [52]; // allocates data for 52 card objects
    private int topCard = 0; // sets index for first card
    public Deck()
    {
        String [] Suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String [] Faces = {"Ace", "King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two"};
        int [] Values = { 11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
        for (int a = 0; a < 13; a++)
        {
            deck[a] = new Cards(Suits[0], Faces[a], Values[a]); // creates Hearts
            deck[a+13] = new Cards(Suits[1], Faces[a], Values[a]); // creates Diamonds
            deck[a+26] = new Cards(Suits[2], Faces[a], Values[a]); // creates Clubs
            deck[a+39] = new Cards(Suits[3], Faces[a], Values[a]); // creates Spades
        }
    }
    public Cards getTopCard()
    {
        Cards copyCard;
        copyCard = new Cards(deck[topCard]); // creates a copy of the first card
        topCard++; // makes the next card the first card
        return copyCard; // returns the card
    }
    public void shuffle()
    {
        Random rn = new Random(); // creates a number generator
        for (int a = 0; a < 1000; a++)
        {
            int i = 0;
            int k = 0;
            Cards temp; // creates a temporary holder for a card
            i = rn.nextInt(52);
            k = rn.nextInt(52);
            temp = deck[i]; // holds card in temp slot
            deck[i] = deck[k]; // replaces card i with card k
            deck[k] = temp; // replaces card k with temp card
        }
    }
}
