// package csci230.hwk6;
package hwk6;

/**
 *
 * Exception used in binary search tree coding assignment.
 *
 * This exception is thrown when an operation is applied to
 * an binary search tree that is empty.
 *
 * @author CSCI 230: Data Structures and Algorithms Spring 2017
 *
 */
@SuppressWarnings("serial")
public class EmptyBSTException extends Exception {

	public EmptyBSTException() {

		super( "Empty Binary Search Tree Exception" );

	}

} // end
