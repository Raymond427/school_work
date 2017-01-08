
/**
 * Write a description of class Node here.
 * 
 * @author Raymond Ferrell
 * @version (a version number or a date)
 */
public class Node
{
    // instance variables - replace the example below with your own
    private String word; // the word
    private int frequency; // the number of times the word appears
    private Node RightChild; // the reference to the right child
    private Node LeftChild; // the reference to the left child

    /**
     * Constructor for objects of class Node
     */
    public Node(String Word)
    {
        // initialise instance variables
        word = Word; // sets the word recieved as the word for the node
        frequency = 1; // lables the new node as appeared once
        RightChild = null; // leaves the right child empty
        LeftChild = null; // leaves the left child empty
    }

    /**
     * Overloaded Constructor for objects of class Node
     */
    public Node( String Word, int frequency, Node rightchild, Node leftchild)
    {
        // initialise instance variables
        word = Word;
        frequency = 1;
        RightChild = rightchild;
        LeftChild = leftchild;
    }
    
    public void increaseFrequency()
    {
        frequency++; // increases the frequency by 1
    }
    
    public boolean add (Node n)
    {
        int compare = word.compareTo(n.getWord()); // compares the word recieved and the node value
        boolean added = false; // checks of a new element was created
        if (compare == 0) // if the given word matched the current node
        {this.increaseFrequency();} // increase frequency by one
        else{
                added = true; // new element added
                if (compare > 0) // if word if less alphabetically
                {
                    if (LeftChild == null) // if left branch is empty
                    {LeftChild = n;} // set left branch to current node
                    else
                    {LeftChild.add(n);} // add left node to tree
                }
                else
                {
                    if (RightChild == null) // if right branch is empty
                    {RightChild = n;} // set right branch to current node
                    else
                    {RightChild.add(n);} // add right node to tree
                }
            }
        return added; // tell the tree if a new element was added
    }
   
    public Node search (String w)
    {
        int compare = word.compareTo(w); // compares the sought after word with the node value
        if (compare == 0) // if the sought word equals the node word
        {return this;} // return this node
        else{
                if (compare > 0) // if the soguht word is less alphabetically
                {
                    if (LeftChild != null) // if there is a node
                    {return LeftChild.search(w);} // set the node as the left branch
                    else
                    {return null;} // word not found
                }
                else
                {
                    if (RightChild != null) // if there is a right node
                    {return RightChild.search(w);} // return right branch
                    else
                    {return null;} // word not found
                }
            }
    }
    
    public int getFrequency() {return frequency;} // returns frequency
    
    public String getWord() {return word;} // returns word
    
    public Node getRightChild() {return RightChild;} // returns right branch
    
    public Node getLeftChild() {return LeftChild;} // returns left branch
    
    public String toString() // displays the nodes attributes
    {
        return "Word: " + word + "\nFrequency: " + frequency + "\n";
    }
}