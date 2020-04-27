package module10project;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SinglyLinkedList represents a linked implementation of a list.
 * This is an unordered list. The only order it has it determined by the 
 * user. However, there is not inherit relationship between the elements. 
/**
 * @author Dan Lewis
 * @Class: CSC205
 * @Date Written: 04/26/20
 * @Program Description: Palindrome tester using stacks and queues
 */

 
 
public class SinglyLinkedList<T> implements LinkedListADT<T> {

	Node<T> head;
	Node<T> tail;
	int count;
	
	/**
	 * Creates an empty list.
	 */

	public SinglyLinkedList() {
		head = null;
		tail = null;
		count = 0;

	}

	/**
	 * 
	 * Add the first element at the front of the the LinkedList. 
	 * @param element
	 */
	public void addFirst(T element) {

		Node<T> temp = new Node<>(element);
		if (isEmpty()) {
			head = tail = temp;
		
		} else // list is empty. Let add in the front
		{
			temp.next = head;
			head = temp;
			
		}
		count++  ;//better
	}

	/**
	 * Removes the first element in this list and returns a reference
	 * to it. Throws an EmptyCollectionException if the list is empty.
	 *
	 * @return a reference to the first element of this list
	 * @throws EmptyCollectionException if the list is empty
	 */

	public T removeFirst() {

		if (isEmpty())
			throw new EmptyCollectionException("List");

		T e = head.element;
		head = head.next;
		
		count--;
		// special situation to deal with explicitly.
		// if there is no node left then set tail equals to null
		if (isEmpty())
			tail = null;

		return e;
	}
	/** 
	 * Returns true if this list contains no elements. 
	 *
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty() {
		return (count == 0);

	}
	/** 
	 * Add the specified element to the tail of this list. 
	 *
	 * @element to be added as the last element in this list
	 */
	public void addLast(T element) {
		Node<T> temp = new Node<>(element);

		if (isEmpty())  // then head and tail both are null
			head = temp;
			//tail = temp;  instead of twice do it once at the end line 102
	   else 
			tail.next = temp;
		
		
			tail = temp;
		count++;

	}
	/**
	 * Removes the last element in this list and returns a reference
	 * to it. Throws an EmptyCollectionException if the list is empty.
	 *
	 * @return the last element in this list
	 * @throws EmptyCollectionException if the list is empty    
	 */

	
	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EmptyCollectionException("List");

		T e = tail.element; //get the element and store it in e
		// Special case when there is only one node
		if (head == tail) {
			head = tail = null;
		}
		//for all others
		else { 
			  Node<T> prev = null;
			  Node<T> curr = head;

			  while (curr.next != null) {
				prev = curr;
				curr = curr.next;

			 }
			
			  tail = prev; //new tail
			  tail.next = null; //set next to null to maintain it as the last node
		    }
		
		count--;
		return e;
	}
	
	/**
	 * Returns the last element in this list without removing it. 
	 *
	 * @return the last element in this list  
	 * @throws EmptyCollectionException if the list is empty
	 */

	public T inspectLast() {

		if (isEmpty())

			throw new EmptyCollectionException("List");

		return tail.element;

	}
	

	/**
	 * Returns the first element in this list without removing it. 
	 *
	 * @return the first element in this list
	 * @throws EmptyCollectionException if the list is empty
	 */

	 @Override
	public T inspectFirst() throws EmptyCollectionException {
		
		if (isEmpty())
			throw new EmptyCollectionException("List");

		return head.element;
	}
	 /** 
		 * Returns the number of elements in this list. 
		 *
		 * @return the integer representation of number of elements in this list
		 */
	@Override
	public int size() {
		
		return count;
	}
	
	/**
	 * Removes the first instance of the specified element from this
	 * list and returns a reference to it. Throws an EmptyCollectionException 
	 * if the list is empty. Throws a ElementNotFoundException if the 
	 * specified element is not found in the list.
	 *
	 * @param  targetElement the element to be removed from the list
	 * @return a reference to the removed element
	 * @throws EmptyCollectionException if the list is empty
	 * @throws ElementNotFoundException if the target element is not found
	 */

	@Override
	public T remove(T targetElement) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EmptyCollectionException("List");

		boolean found = false;
		Node<T> previous = null;
		Node<T> current = head;

		while (current != null && !found) {
			if (targetElement.equals(current.element))  //have to use equals since comparing objects /data
				found = true;
			else
			{
				previous = current;
				current = current.next;
			}
		}
		
		if (!found)
			throw new ElementNotFoundException("List");
		
//otherwise check the special cases 
		
		if (size() == 1)  // 1. only one element in the list. There are other ways to test this as well
			head = tail = null; //we can call removeFrist() here as well. But careful about the count variable 

		else if (current == head)  // 2. target is at the head or current == head 
			head = current.next;

		else if (current== tail) // 3. target is at the tail
		{
			tail = previous;    //We can call removeLast() method here as well
			tail.next = null;  //if removeLast is called  then it is not needed
		}

		else                   //4.  target is in the middle of the list we have to update references
			previous.next = current.next;

		
		count--;
		
		return current.element;

	}
	/**
	 * Returns true if the specified element is found in this list and 
	 * false otherwise. Throws an EmptyCollectionException if the list 
	 * is empty.
	 *
	 * @param  targetElement the element that is sought in the list
	 * @return true if the element is found in this list
	 * @throws EmptyCollectionException if the list is empty
	 */

	@Override
	public boolean contains(T target) {
		// TODO Auto-generated method stub
		
		if(isEmpty())
			throw new EmptyCollectionException("List");
		
		boolean found = false;
		
		Node <T> current = head;
		
		while(current != null && !found) //loop terminates as soon as found is true
		{
			if(target.equals(current.element)) // had to use equals since comparing data
				found = true;
			else
			    current = current.next;
			
		}
		
		
		return found;
	}
	/**
	 * Adds the specified element to this list after the given target.
	 *
	 * @param  element the element to be added to this list
	 * @param  target the target element to be added after
	 * @throws ElementNotFoundException if the target is not found or the list is empty
	 */
	@Override
	public void addAfter(T element, T target) throws ElementNotFoundException {
		
		if(isEmpty())
			throw new ElementNotFoundException("List");
		
		//create a new node to be added 
		Node <T> newNode = new Node<>(element);
		
		boolean found = false;
		
		Node <T> current = head; //start from the head
		
		while(current != null && !found) {   //if current.next is tested then we will miss the last element data
			if(target.equals(current.element))
				found = true;
			else
				current = current.next;
		}
		//Deal with the special cases
		if(!found)//1. If the target is found, then we decided not to add the the element but throws exception
			throw new ElementNotFoundException(" list ");
		
		// 2. otherwise add the node. The special case will be if the target element is the tail 
		if (current== tail) // target is at the tail in this case we will have a new tail ref
		{
			current.next = newNode;
			tail = newNode;
		}
		else  // 3. Otherwise target is in the middle of the list or could be after head - same case
		{
			newNode.next = current.next;
		   current.next = newNode;
		}
		
		count ++;
		
		
	}

	/** 
	 * Returns a string representation of this list. 
	 *
	 * @return a string representation of this list
	 */
	public String toString() {
		
		Node<T> current = head;
		
		String result = "";
		while ( current!= null) {
			
			 result += current.element +"  " ;
			
			current = current.next;
			
		}
		return result;
	}
	///////////////////////////////////// Inner class Node.java/////////////////////////////////////
	public class Node<T> {

		private T element;
		private Node<T> next;

		/**
		 * No Argument or default constructor
		 */
		public Node() {
			this.element = null;
			this.next = null;

		}

		/**
		 * 
		 * @param element
		 */
		public Node(T element) {
			this.element = element;
			this.next = null;

		}

	} // end of Node class

	
	@Override
	public Iterator<T> iterator() {
		
		Iterator <T> sLLiterator; 
		sLLiterator =  new SinglyLinkedListIterator<>(head);
		
		return sLLiterator;
		
	}

	// Implementing an inner class SinglyLinkedListIterator
	//
	/**
	 * 
	 * @author Dilshad Haleem
	 *
	 * @param <T>
	 */

	private class SinglyLinkedListIterator<T> implements Iterator<T> {
		
		Node<T> current;

		public SinglyLinkedListIterator(Node<T> start) {

			current = start;
		}
		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return  true if this iterator has at least one more element to deliver
		 *          in the iteration
		 */

		@Override
		public boolean hasNext() {
			
			return (current != null);
		}
		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iterator is empty
		 */

		@Override
		public T next() {
           
			if(!hasNext())  //Just in case if someone tries to call next when there are no more elements
				throw new NoSuchElementException("No more elements");
			
			T e = current.element;
			current = current.next;

			return e;
		}
		
		/**NEW METHOD
		 * The remove operation is not supported.
		 * 
		 * @throws UnsupportedOperationException if the remove operation is called
		 */
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}


	}

	

} // end of SinglyLinkedList class
