package module10project;

/**
* LinkedListADT defines the interface to a general list collection. Specific
* types of lists will extend this interface to complete the
* set of necessary operations.
/**
 * @author Dan Lewis
 * @Class: CSC205
 * @Date Written: 04/26/20
 * @Program Description: Palindrome tester using stacks and queues
 */
public interface LinkedListADT<T> extends Iterable <T>
{
	/** 
	 * Add the first element at the front of the the LinkedList. 
	 * @param element the element to be added to the list
	*/
	public void addFirst(T element);

/** 
	 * Removes and returns the first element from this list. 
	 * 
	 * @return the first element from this list
	 */
	public T removeFirst();

	/** 
	 * Add to the end of the this list. 
	 *
	 * @element to be added as the last element in this list
	 */
	public void addLast(T element);

	
	/** 
	 * Returns a reference to the first element in this list. 
	 *
	 * @return a reference to the first element in this list
	 */
	public T inspectFirst();

	/** 
	 * Remove the last element in this list 
	 *
	 * @return the removed element 
	 */
	public T removeLast();

	/** 
	 * Returns a reference to the last element in this list. 
	 *
	 * @return a reference to the last element in this list
	 */
	public T inspectLast();
	/** 
	 * Returns true if this list contains no elements. 
	 *
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty();
	

	/**  
	 * Removes and returns the specified element from this list. 
	 *
	 * @param targetElement the element to be removed from the list
	 */
	public T remove(T targetElement);

	/**  
	 * Returns true if this list contains the specified target element. 
	 *
	 * @param target the target that is being sought in the list
	 * @return true if the list contains this element
	 */
	public boolean contains(T target);
	
	/**
	 * Adds the specified element to this list after the given target.
	 *
	 * @param  element the element to be added to this list
	 * @param  target the target element to be added after
	 * @throws ElementNotFoundException if the target is not found
	 */
	public void addAfter(T element, T target);


	/** 
	 * Returns the number of elements in this list. 
	 *
	 * @return the integer representation of number of elements in this list
	 */
	public int size();

	/** 
	 * Returns a string representation of this list. 
	 *
	 * @return a string representation of this list
	 */
	public String toString();
}