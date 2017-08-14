// package csci230.hwk4;
package hwk4;
import java.util.EmptyStackException;
/**
 * A LIFO stack that has constant time complexity O(1) for
 * all three stack interface methods (i.e., push, pop, and
 * peek).
 *
 * This data structure was discussed in class along with the
 * operations, please review your notes.
 *
 * @author CSCI 230: Data Structures and Algorithms Spring 2017
 *
 * @param <AnyType>
 */
public class ConstantTimeStack<AnyType extends Comparable> implements Stack<AnyType>{

	/**
	 * private instance variables
	 */
	private SinglyLinkedList<AnyType> list = new SinglyLinkedList<AnyType>();

	/**
	 * Pushes an item onto the top of this stack in constant
	 * time O(1)
	 *
	 * @param t the item to be pushed onto this stack.
	 */
	public void push(AnyType t) {

		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         * Note: Your push solution must be a constant
         * time O(1) operation
         *
         */

		 list.add(0, t);
	} // end push() method

	/**
	 * Removes the object at the top of this stack and return the
	 * item in constant time O(1)
	 * .
	 * @return The item at the top of this stack
	 * @throws EmptyStackException - if this stack is empty.
	 */
	public AnyType pop() throws EmptyStackException {

		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         * Note: Your pop solution must be a constant
         * time O(1) operation
         *
         */
		 if (list.isEmpty()){
			 throw new EmptyStackException();
		 } else {
			 AnyType poppedElem = list.remove(0);
			 return poppedElem;
		 }
	} // end pop() method

	/**
	 * Looks at the item at the top of this stack without removing it
	 * from the stack in constant time O(1)
	 *
	 * @return the item at the top of this stack
	 * @throws EmptyStackException  - if this stack is empty.
	 */
	public AnyType peek() throws EmptyStackException {

		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         * Note: Your peek solution must be a constant
         * time O(1) operation
         *
         */

		 if (list.isEmpty())  throw new EmptyStackException();

		 AnyType poppedElem = list.get(0);
		 return poppedElem;

	} // end peek() method

	public String toString(){
		String str = new String();
		for (int i = 0; i < list.size(); i++){
			str +=  list.get(i).toString() + " ";
		}

		return str;
	}

	/**
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         *
         */

        ConstantTimeStack testStack = new ConstantTimeStack();

        System.out.print("Trying to peek from empty stack...");
        try {
            testStack.peek();
        } catch (EmptyStackException e){
            System.out.println("Empty Stack Exception\n");
        }

        System.out.print("Trying to pop from empty stack...");
        try{
            testStack.pop();
        } catch (EmptyStackException e){
            System.out.println("Empty Stack Exception\n");
        }

		// push method
		testStack.push("uno");
        testStack.push("dos");
        testStack.push("tres");
        testStack.push("quatro");
        testStack.push("cinco");
        testStack.push("seis");
        testStack.push("siete");

        // should be siete
        System.out.println("Peek: " + testStack.peek());

        // should be siete
        System.out.println("Pop: " + testStack.pop());

        System.out.println("Stack: " + testStack.toString());

    } // end main method

} // end ConstantTimeStack class definition
