package Lab;

public class DoubleLink<E extends Comparable<E>> {
	
	    private Node head;
	    private Node tail;
	    private int size;
	     
	    public DoubleLink(){
	        size = 0;
	        head = null;
	        tail = null;
	    }
	    public void add(E value){
    	    if (size==0)
    	    {
    	        head = new Node(value, null, null);
    	        tail = head;
    	        size++;
    	        return;
    	    }
		    else
		    {
		        if (value.compareTo(head.getElement()) < 0)
		        {
		            Node newNode = new Node(value, head, null);
		           
		            head.setPrev(newNode);
		            head = newNode;
		            size++;
		            return;
		        }
		        else
		        {
		            Node current = head.getNext();
		            while (current != null)
		            {
		                if (value.compareTo(current.getElement()) <= 0)
		                {
		                    Node newNode = new Node(value, current, current.getPrev());
		                    
		                    current.getPrev().setNext(newNode);
		                    current.setPrev(newNode);
		                    size++;
		                    return;
		                }
		                current = current.getNext();
		            }
		            Node newNode = new Node(value, null, tail);
		            tail.setNext(newNode);
		            tail = newNode;
		            size++;
		            return;
		        }
		    }
	    }
	    public boolean isEmpty(){
	    	return head == null;
	    }
	    public int getSize(){
	    	return size;
	    }
	    public String toString()
	    {
	        String result = "";
	        Node current = head;
	        
	        while (current != null)
	        {
	            result += "" + current.getElement().toString() + "\r\n";
	            current = current.getNext();
	        }
	        return result;
	    }
	    private class Node {
	        E element;
	        Node next;
	        Node prev;
	        
	        public Node(E element, Node next, Node prev) {
	            this.element = element;
	            this.next = next;
	            this.prev = prev;
	        }
			public Node getPrev() {
				return prev;
			}
			public Node getNext() {
				return next;
			}
			public void setPrev(Node prev) {
				this.prev = prev;
			}
			 public void setNext(Node next){
		        this.next = next;
		    }
			public E getElement() {
				return element;
			}
			public void setElement(E element) {
				this.element = element;
			}
	   }
}


