package module10project;

/**
 * Represents the situation in which a collection is empty.
 *
/**
 * @author Dan Lewis
 * @Class: CSC205
 * @Date Written: 04/26/20
 * @Program Description: Palindrome tester using stacks and queues
 */
public class EmptyCollectionException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Sets up this exception with an appropriate message.
	 * @param collection the name of the collection
	 */
	public EmptyCollectionException(String collection)
	{
		super("The " + collection + " is empty.");
	}
}
