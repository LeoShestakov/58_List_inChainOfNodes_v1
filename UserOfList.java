/**
 Test list features (started with work by Mr. Holmes)
 */
public class UserOfList {
  public static void main(String[] args ) {
    List_inChainOfNodes list = new List_inChainOfNodes();

    System.out.println( "number of elements: " + list.size() );
    System.out.println( "empty list:" + list);
	System.out.println();

    // Populate the list with elements
    int i = 0;
    for( ; i < 5; i++ ) {
		list.add(list.size(),-i); // differs from index, but similar
		System.out.println( "number of elements: " + list.size() );
		System.out.println(list);
		System.out.println();
    }
    
    // New additions utilizing Object type
    list.add(list.size(),"dog");
    list.add(0, true);
    list.add(1, 11.1);
    
    System.out.println("initial population of " + list.size() + " elements:");
    System.out.println( list);

    // Add more elements
    for( ; i < 15; i++ ) {
		list.add(list.size(), -i);
		System.out.println( "number of elements: " + list.size() );
    }
    System.out.println("result of second population: " + list.size() + " elements:");
    System.out.println( list);

    // Trust no one.
    for( ; i < 35; i++ )
		list.add(list.size(), -i);
    System.out.println("after third population: " + list.size() + " elements:");
    System.out.println( list);
	
    // test accessor
    System.out.println( "sample elements from list:");
    for(int elemIndex = 1; elemIndex < list.size(); elemIndex *= 2 ) {
		System.out.println("element " + elemIndex + ": "
                           + list.get( elemIndex)
                           );
    }
	
	// test set
    setTest(list, 0, "woof");
    setTest(list, 16, "ice cream");
    System.out.println("LOOK ABOVE");
	
	// test adding at a specified position
    addAtTest(list, 0, "first"); // beginning of the list

    // end of the list using the new add method
    addAtTest(list, list.size(), false);

	// middle of a small list
    addAtTest(list, 2, 22.2); 

	// more tests
	addAtTest(list, 0, 23);
	addAtTest(list, 10, 23);
	addAtTest(list, list.size(), "first");
	
	// test removing an element
    System.out.println("removing value " + list.remove( 6)
                       + ", leaving " + list.size() + " elements:");
    System.out.println( list);
  }
  
  /**
  Test the set() method, reporting and
  changing the value at index @modifyAt.
  */
  private static void setTest(List_inChainOfNodes list, int modifyAt, Object value) {
    System.out.println("changed element " + modifyAt + " from "
					   + list.set( modifyAt, value) + " to "
					   + list.get( modifyAt));
  }
	
  /**
  Test the 2-argument add( index, value) method.
  */
  private static void addAtTest(List_inChainOfNodes list, int addAt, Object value) {
    list.add( addAt, value);
	System.out.println("insert " + value
					   + " at position " + addAt
					   + ", resulting in "  + list.size() + " elements:"
					   + System.lineSeparator()
					   + list
					   + System.lineSeparator());
  }
}
