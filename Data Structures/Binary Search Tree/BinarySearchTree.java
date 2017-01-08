
/**
 * Write a description of class BinarySearchTree here.
 * 
 * @author Raymond Ferrell
 * @version (a version number or a date)
 */
public class BinarySearchTree
{
    // Creates the tree that holds the nodes
    private Node root;
    private int size;

    /**
     * Constructor for objects of class BinarySearchTree
     */
    public BinarySearchTree()
    {
        root = null; // sets the current node as null
        size = 0; // sets size to zero
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void insert(String word)
    {
        Node n = new Node(word); // creates new node
        if (root == null) { //if tree is empty
          root = n; // sets root to current node
          size++;} // increases size by one
        else {
        if(root.add(n)) {size++;} // calls add method and increases size by one
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void search(String word)
    {
        if (root == null) {return;} // returns a blank string if the tree is empty
        else 
        {
            if(root.search(word) == null) {return ;} // returns null if the word is not found
            else if (root.search(word).getWord() == word) // if the word in the node equals the word sought after
            {System.out.println(root.search(word).toString());} // prints the toString method for the node
        }
    }
    
    public void printPreOrder()
    {
        if (root == null) {return;} // prints " " if the tree is empty
        printPreOrderRecursive(root); // calls the recursive printer
    }
    
    public void printInOrder()
    {
        if (root == null) {return;}
        printInOrderRecursive(root);
    }
    
    public void printPostOrder()
    {
        if (root == null) {return;}
        printPostOrderRecursive(root);
    }
    
    public void printPreOrderRecursive(Node root)
    {
        if(root == null) {return;} // returns " " is tree is empty
        System.out.print(root.toString()); // prints current node
        printPreOrderRecursive(root.getLeftChild()); // print left branch
        printPreOrderRecursive(root.getRightChild()); // print right branch
    }
    
    public void printInOrderRecursive(Node root)
    {
        if (root == null) {return;}
        printInOrderRecursive(root.getLeftChild()); // prints left branch
        System.out.print(root.toString()); // prints current node
        printInOrderRecursive(root.getRightChild()); // prints right branch
    }
    
    public void printPostOrderRecursive(Node root)
    {
        if (root == null) {return;}
        printPostOrderRecursive(root.getLeftChild()); // prints left branch
        printPostOrderRecursive(root.getRightChild()); // prints right branch
        System.out.print(root.toString()); // prints current node
    }
    
    public int getSize()
    {return size;} // returns size
}
