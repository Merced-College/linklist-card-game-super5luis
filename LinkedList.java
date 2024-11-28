public class LinkList {

    private Link first;  // ref to first link on list

    //-------------------------------------------------------------
    public LinkList()    // constructor
    {
        first = null;  // no links on list yet
    }
    //-------------------------------------------------------------
    public void insertFirst(Card card) 
    {
        Link newLink = new Link(card);  
        newLink.next = first;           // it points to old first link
        first = newLink;                // now first points to this
    }
    public void add(Card card) 
    {                          // make new link
        Link newLink = new Link(card);  
        newLink.next = first;           // it points to old first link
        first = newLink;                // now first points to this
    }
    //-------------------------------------------------------------
    public Link find(Card cardToFind)     // find link with given key
    {                            // (assumes non-empty list)
        Link current = first;            // start at 'first'
        while (current != null) {  // Traverse the list
            if (current.cardLink.equals(cardToFind)) {  // If the card matches
                return current;  // Return the link containing the card
            }
            current = current.next;  // Move to the next link
        }
        return null;  // Return null if the card is not found
    }

    //-------------------------------------------------------------
    public Link delete(Card cardToFind)   // delete link with given key
    {                            // (assumes non-empty list)
        Link current = first;  // Start at the first link
        Link previous = null;  // Keep track of the previous link

        while (current != null)  {  // Traverse the list
            if (current.cardLink.equals(cardToFind)) {  // If the card matches
                if (previous == null) {  // If it's the first card in the list
                    first = current.next;  // Set the first link to the next one
                } else {
                    previous.next = current.next;  // Bypass the current link
                }
                return current;  // Return the deleted link
            }
            previous = current;  // Move to the next link
            current = current.next;  // Move to the next link
        }
        return null;  // Return null if the card is not found
    }

    //-------------------------------------------------------------
    public void displayList()     // display the list
    {
        Link current = first;  // Start at the first link
        System.out.print("List (first-->last): ");
        while (current != null) {  // Traverse the list
            current.displayLink();  // Display the current card
            current = current.next;  // Move to the next link
        }
        System.out.println("");  // Print a newline after displaying the list
    }

    //-------------------------------------------------------------
    public Card getFirst() // Method to get the first link in the list
    {
        if (first != null) {
            Card firstCard = first.cardLink;  // Get the card from the first link
            first = first.next;  // Move the first link to the next one
            return firstCard;  // Return the card
        }
        return null;  // Return null if the list is empty
    }

    //-------------------------------------------------------------
    public Link getFirstLink()  // Method to get the first link for iteration (used in shuffle)
    {
        return first;  // Return the first link
    }

    //-------------------------------------------------------------
    public void clear() // Method to clear the entire list
    {
        first = null;  // Set the first link to null, effectively clearing the list
    }

    //-------------------------------------------------------------
    public int size() // Method to get the size of the list (i.e., the number of cards)
    {
        int size = 0;
        Link current = first;  // Start at the first link
        while (current != null) {  // Traverse the list
            size++;  // Increment the size for each link
            current = current.next;  // Move to the next link
        }
        return size;  // Return the size of the list
    }
}  // end class LinkList
////////////////////////////////////////////////////////////////
/*class LinkedLists
{
	public static void main(String[] args)
	{
		LinkList theList = new LinkList();  // make list

		theList.insertFirst(new Card("heart", "ace", 11,"ah.gif"));      // insert 4 items
		theList.insertFirst(new Card("Spade", "ace", 11,"as.gif"));
		//theList.insertFirst(66, 6.99);
		//theList.insertFirst(88, 8.99);

		theList.displayList();              // display list

		Link f = theList.find(new Card("heart", "ace", 11,"ah.gif"));          // find item
		if( f != null)
			System.out.println("Found link with key " + f.cardLink);
		else
			System.out.println("Can't find link");

		Link d = theList.delete(new Card("heart", "ace", 11,"ah.gif"));        // delete item
		if( d != null )
			System.out.println("Deleted link with key " + d.cardLink);
		else
			System.out.println("Can't delete link");

		theList.displayList();              // display list
	}  // end main()
}  // end class LinkList2App
////////////////////////////////////////////////////////////////
/// */
