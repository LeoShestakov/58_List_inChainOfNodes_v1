/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    /**
      Construct an empty list
     */
    public List_inChainOfNodes() {
	}

    /**
      @return the number of elements in this list
     */
    public int size() {
		int filledElements;
		Node nextNode = headReference;
		for (filledElements = 0; nextNode != null; filledElements++)
			nextNode = nextNode.getReferenceToNextNode();
		return filledElements;
    }


     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
    public String toString() {
		String ans = "[";
		Node nextNode = headReference;
		for (int i = 0; i < size(); i++) {
			ans += nextNode.getCargoReference() + ",";
			nextNode = nextNode.getReferenceToNextNode();
		}
		ans += "]";
		return ans;
    }


    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
    public boolean addAsHead( Object val) {
		Node oldHead = headReference;
		headReference = new Node(val);
		headReference.setReferenceToNextNode(oldHead);
		return true;
    }

	public Object set(int index, Object newValue) {
        Node nextNode = headReference;
		Node referenceNode = headReference;
		for (int i = index; i > 0; i--) {
			nextNode = nextNode.getReferenceToNextNode();
			referenceNode = nextNode.getReferenceToNextNode();
		}
		Object ans = nextNode.getCargoReference();
		nextNode = new Node(newValue, referenceNode);
		return ans;
	}

	public Object get(int index) {
		Node nextNode = headReference;
		for (int i = index; i > 0; i--)
			nextNode = nextNode.getReferenceToNextNode();
		return nextNode.getCargoReference();
    }

	public void add(int index, Object value) {
		Node nextNode = headReference;
		if (index == 0) {
			addAsHead(value);
		}
		else {
			for (int i = index; i > 1; i--)
				nextNode = nextNode.getReferenceToNextNode();
			Node oldRef = nextNode.getReferenceToNextNode();
			nextNode.setReferenceToNextNode(new Node(value, oldRef));
		}
	}

	public Object remove(int index) {
		Node nextNode = headReference;
		for (int i = index; i > 1; i--)
			nextNode = nextNode.getReferenceToNextNode();
		Node oldRef = nextNode.getReferenceToNextNode();
		nextNode.setReferenceToNextNode(nextNode.getReferenceToNextNode().getReferenceToNextNode());
		return oldRef.getCargoReference();
	}
}
