/**
 * @author npandya March 2017 The Class Node.
 */
class Node
{   
    protected int data;  // The data.    
    protected Node link;    // The link.

    /**
     * Constructor
     * Instantiates a new node.
     */
    public Node()
    {
        link = null;
        data = 0;

    }

    /* Overloaded Constructor */
    /**
     * Instantiates a new node.
     * 
     * @param d     d is the data in the node
     * @param n     n is the Node to be used to creat an element into the list
     *             
     */
    public Node(int d, Node n)
    {
        data = d;
        link = n;
    }

    /* Function to set link to next Node */

    /**
     * Sets the link.
     * 
     * @param n
     *            the new link
     */
    public void setLink(Node n)
    {
        link = n;
    }

    /* Function to set data to current Node */

    /**
     * Sets the data.
     * 
     * @param d
     *            the new data
     */
    public void setData(int d)
    {
        data = d;
    }

    /* Function to get link to next node */

    /**
     * Gets the link.
     * 
     * @return the link
     */
    public Node getLink()
    {
        return link;
    }

    /* Function to get data from current Node */

    /**
     * Gets the data.
     * 
     * @return the data
     */
    public int getData()
    {
        return data;
    }

}
