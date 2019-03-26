/**
 Test list features.
 */
public class UserOfList {
  public static void main( String[] args ) {
    List_inChainOfNodes list = new List_inChainOfNodes();

    System.out.println( "number of elements: " + list.size() );
    System.out.println( "empty list:" + list);

    /* Populate the list with elements, but with a small enough
       number that we expect no invocation of expand().
    */
    int i = 0;
    for( ; i < 5; i++ ) {
      list.add(list.size(),-i); // differs from index, but similar
      System.out.println( "number of elements: " + list.size() );
    }
    
    // New additions utilizing Object type
    list.add(list.size(),"dog");
    list.add(list.size(), true);
    list.add(list.size(),11.1);
    
    System.out.println("initial population of " + list.size() + " elements:");
    System.out.println( list);

    // Add enough elements that expansion is expected
    for( ; i < 15; i++ ) {
      if( i == 10) System.out.println( "expansion expected");
      list.add(list.size(), -i);
      System.out.println( "number of elements: " + list.size() );
    }
    System.out.println("result of second population: " + list.size() + " elements:");
    System.out.println( list);

    // Trust no one.
    for( ; i < 35; i++ )
    list.add(list.size(), -i);
    System.out.println("after second expansion: " + list.size() + " elements:");
    System.out.println( list);
	
    // test accessor
    System.out.println( "sample elements from list:");
    for(int elemIndex = 1; elemIndex < list.size(); elemIndex *= 2 ) {
        System.out.println("element " + elemIndex + ": "
                           + list.get( elemIndex)
                           );
    }
	
	// test set
    setTest(list, 8, "woof");
    setTest(list, 16, "ice cream");
    System.out.println();
	
	// test adding at a specified position
    addAtTest(list, 0, "first"); // beginning of the list

    // end of the list using the new add method
    addAtTest(list, list.size(), false);

    addAtTest(list, 2, 22.2); // middle of a small list

    // force an expansion
	addAtTest(list, 2, 23);
	addAtTest(list, 2, 23);
	addAtTest(list, 2, 23);
	
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
