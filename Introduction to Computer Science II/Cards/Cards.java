
/**
 * Class: Cards
 * Description: This class gives the card objects their characteristics 
 * and returns those values to the driver
 * 
 * @author Raymond Ferrell 
 * @version November 19, 2014
 */
public class Cards
{
    private String suit; // suit of card
    private String face; // face of card
    private int value; // value of card

    /**
     * Static constructor 
     * 
     * Description: Sets the fields for the card object.
     * 
     */
    public Cards()
    {
        suit = "null"; // sets all fields to zero
        face = "null";
        value = 0;
    }
    /**
     * Static Constructor
     * 
     * Description: Overloaded constructor set feilds to the values given by the driver
     * 
     * @param insuit: suit from driver
     * @param inface: face from driver
     * @param invalue: value from driver
     */
    public Cards(String insuit, String inface, int invalue)
    {
        suit = insuit; // sets fields to values recieved from driver
        face = inface;
        value = invalue;
    }
    /**
     * Static Copy Constructor
     * 
     * Description: Copy constructor to create copies of cards
     * 
     * @param other: a card from which to copy
     */
    public Cards(Cards other)
    {
        suit = other.suit; // sets fields to values of parameter object
        face = other.face;
        value = other.value;
    }
    /**
     * Static method getSuit
     * 
     * Description: returns card's suit
     * 
     * @return suit: suit of card
     */
    public String getSuit()
    {
        return suit; // returns the card's suit
    }
    /**
     * Static method getFace
     * 
     * Description: returns card's face
     * 
     * @return face: face of card
     */
    public String getFace()
    {
        return face; // reuturns the cards face
    }
    /**
     * Static method getValue
     * 
     * Description: returns card's value
     * 
     * @return value: value of card
     */
    public int getValue()
    {
        return value; // returns the cards value
    }
    /**
     * Static method toString
     * 
     * Description: prints card's fields
     * 
     * @return String: string of fields
     */
    public String toString()
    {
        return face + " of " + suit + " " + value + " points!"; // dislays the card's fields
    }
    /**
     * Static method compareTo
     * 
     * Description: returns integer based on comparison
     * 
     * @param other: a card to compare to the calling object
     * @return int: one if greater than, negative one if less then, zero if equal
     */
    public int compareTo(Cards other)
    {
        if (this.value > other.value) // compares card's values
        {
            return 1;
        }
        else if (this.value < other.value)
        {
            return -1;
        }
        else // reuturns zero if equal
        {
            return 0;
        }
    }
    /**
     * Static method equals
     * 
     * Description: returns boolean
     * 
     * @param other: a card to compare to the calling object
     * @return boolean: true if face and suit are equal, false if not
     */
    public boolean equals(Cards other)
    {
        if ((this.suit == other.suit) && (this.face == other.face)) // returns equal if card's suit and face are the same
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
