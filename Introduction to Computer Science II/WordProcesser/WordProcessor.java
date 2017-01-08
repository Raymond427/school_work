/**
 * Class: WordProcessor
 * Description: This class simply adds one to the static variable
 * that is called by the driver when given a word.
 * 
 * @author Raymond Ferrell
 * @version (Version 1.0 October 17, 2014)
 */
public class WordProcessor
{
    private String word;
    private static int charCount = 0; // number of characters counted
    private static int wordCount = 0; // number of words counted

    /**
     * Constructor for objects of class WordProcesser
     * 
     * Description: sets the initial value of word to unknown
     */
    public WordProcessor()
    {
        word = "unknown";
    }
    
    /**
     * Static method resetCount
     * 
     * Description: resets the word and character counter to zero, 
     * in case the user repeats the function
     */
    public static void resetCount()
    {
        charCount = 0;
        wordCount = 0;
    }
    
    /**
     * Static method charCount
     * 
     * Description: counts the number of characters present in the given word
     * 
     * @param word: the word from the input file sent from the driver.
     */
    public static void charCounter(String word)
    {
        charCount += word.length();
    }
    
    /**
     * Static method getcharCount
     * 
     * Description: returns the count to the driver
     * 
     * @return charCount: The number of characters counted
     */
    public static int getcharCount()
    {
        return charCount;
    }
    
    /**
     * Static method wordCounter
     * 
     * Description: counts the number of words in each line of the file.
     * 
     * @param word: the word from the input file sent from the driver.
     */
    public static void wordCounter(String word)
    {
        wordCount ++;
    }
    
    /**
     * Static method getwordCount
     * 
     * Description: returns the count to the driver
     * 
     * @return charCount: The number of words counted
     */
    public static int getwordCount()
    {
        return wordCount;
    }
}