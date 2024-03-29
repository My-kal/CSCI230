// package csci230.hwk6;
package hwk6;

/**
 *
 * Exception used in binary tree / binary search tree
 * coding assignment.
 *
 * This exception is thrown when a null binary node, or
 * a binary node with a null element is added to the
 * binary tree or binary search tree.
 *
 * @author CSCI 230: Data Structures and Algorithms Spring 2017
 *
 */
@SuppressWarnings("serial")
public class NullBinaryNodeException extends Exception {

	public NullBinaryNodeException() {
		super( "Null binary node" );
	}
} // end NullBinaryNodeException class
