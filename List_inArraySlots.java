/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

public class List_inArraySlots {

     private Object[] elements;
     private int filledElements; // the number of elements in this list

     private static final int INITIAL_CAPACITY = 10;

     /**
      Construct an empty list with a small initial capacity.
     */
     public List_inArraySlots() {
        elements = new Object[INITIAL_CAPACITY];
        // filledElements is already initialized to 0.
     }


     /**
      @return the number of elements in this list
     */
     public int size() {
        return filledElements;
     }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
     public String toString() {
		String ans = new String();
		ans += "[";
		for (Object element : elements)
			ans += element + ",";
		ans += "]";
		return ans;
	}


     /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add(Object value) {
		if (filledElements == elements.length)
			expand();
		elements[filledElements++] = value;
		return true;
     }


     /**
      Double the capacity of the List_inelementsSlots,
      preserving existing data.
     */
     private void expand() {
		// System.out.println( "expand... (for debugging)");
		Object[] temp = elements;
		elements = new Object[temp.length * 2];
		for (int i = 0; i < temp.length; i++)
			elements[i] = temp[i];
     }
	 
	public Object get(int index) {
		return elements[index];
     }
	
	public Object set(int index, Object newValue) {
        Object saveForReturn = get(index);
        elements[index] = newValue;
        return saveForReturn;
	}
	
	public void add(int index, Object value) {
		if(index == filledElements) // adding at end of list
			add(value);
		else {
			add(elements[filledElements-1]);

			// move the hole left / shift "subsequent elements" right
			for(int hole = filledElements-1; hole > index; hole--)
				elements[hole] = elements[ hole-1];

			elements[index] = value; // store new value
          }
	}
	
	public Object remove(int index) {
		Object result = elements[index];  // save for returning

		for(int put = index; put < filledElements-1; put++)
			elements[put] = elements[put+1];

		filledElements--;
		return result;
	}
	
	public boolean addAsHead( Object val) {
		add(0, val);
		return true;
    }
}
