// package csci230.hwk4;
package hwk4;

import com.sun.tools.internal.jxc.ap.Const;

import java.util.NoSuchElementException;

/**
 * A semi-constant time FIFO queue. The time complexity for
 * the interface methods are:
 * ----------------------------------
 * 1) add: O(1) - not considering capacity resize operations
 * 2) remove: O(n) - not considering capacity resize operations
 * 3) peek: O(1)
 *
 * Please note: the above time complexities do not factor in
 * capacity resize (grow and shrink) operations. Even though
 * capacity resize operations will occur, for this assignment
 * you may assume the are negligible.
 *
 * This data structure was discussed in class along with the
 * operations, please review your notes.
 *
 * @author CSCI 230: Data Structures and Algorithms Spring 2017
 *
 * @param <AnyType>
 */
public class SemiConstantTimeQueue<AnyType extends Comparable> implements Queue<AnyType> {

	/**
	 * private instance variables
	 */
	private ArrayList<AnyType> list = new ArrayList<AnyType>();


	/**
	 * Inserts the specified element at the end of the queue in
	 * constant time O(1)
	 *
	 * @param t element to add
	 * @throws NullPointerException- if the specified element is null
	 *                               (queue does not permit null elements)
	 */
	public void add(AnyType t) throws NullPointerException {

		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         * Note: Your add solution must be a constant
         * time O(1) operation (not considering capacity
         * resize operations)
         *
         */

		if (t == null) throw new NullPointerException();
		list.add(t);

	} // end add() method

	/**
	 * Retrieves and removes the head of the queue in
	 * linear time O(n).
	 *
	 * Hint: shift operations will make this a linear time
	 * operation.
	 *
	 * @return the head of the queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public AnyType remove() throws NoSuchElementException {

		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         * Note: Your push solution must be a linear
         * time O(n) operation. See hint above.
         *
         *
         */

		 if (list.isEmpty()) throw new NoSuchElementException();
         AnyType removedElem = list.remove(0);
		 return  removedElem;
	} // end remove() method

	/**
	 * Retrieves, but does not remove, the head of the queue,
	 * or returns null if this queue is empty.
	 *
	 * @return the head of this queue, or null if this queue is empty
	 */
	public AnyType peek() {

		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         * Note: Your add solution must be a constant
         * time O(1) operation
         *
         */

		 if (list.isEmpty()) return null;

         AnyType peekedElem = list.get(0);
		 return peekedElem;
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
	public static void main(String[] args) {

		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         *
         */

        SemiConstantTimeQueue testQueue = new SemiConstantTimeQueue();

         // add
         System.out.print("Trying to add null to queue...");
        try {
            testQueue.add(null);
        } catch (NullPointerException e){
            System.out.println("Null Pointer Exception\n");
        }

		System.out.print("Trying to remove from empty queue...");
        try{
            testQueue.remove();
        } catch (NoSuchElementException e){
            System.out.println("No Such Element Exception\n");
        }

        testQueue.add("uno");
        testQueue.add("dos");
        testQueue.add("tres");
        testQueue.add("quatro");
        testQueue.add("cinco");
        testQueue.add("seis");
        testQueue.add("siete");

        // should peek uno
        System.out.println("Peek: " + testQueue.peek());

        // should remove uno
        System.out.println("Remove: " + testQueue.remove());

        System.out.println("Queue: " + testQueue.toString());


	} // end main() method

} // end ConstantTimeQueue class definition
