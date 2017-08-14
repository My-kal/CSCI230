// package csci230.hwk4;
package hwk4;
/**
 * ArrayList Data Structure
 *
 * @author CSCI 230: Data Structures and Algorithms Spring 2017
 * @author Mykal Burris
 *
 * @param <AnyType>
 */
public class ArrayList<AnyType extends Comparable> implements List<AnyType> {

    // instance variables
    private Object[] array;
    private int size = 0;
    private final static int INITIAL_CAPACITY = 10;
    private int capacity = INITIAL_CAPACITY;

    /**
     * Constructs an empty list with an initial capacity
     * (for this assignment initial capacity is 10 - see
     * constant instance variable)
     *
     */
    public ArrayList() {

    	array = new Object[ INITIAL_CAPACITY ];

    } // end constructor

    /**
     * Appends the specified element to the end of this list.
     *
     * @param t
     */
    public void add( AnyType t) {

    	if ( size >= capacity )
    		grow();

    	array[size] = t;
        size++;

    } // end add() method

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    // 5 4 1 7 3 9
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         */

        if (index > size || index < 0) throw new IndexOutOfBoundsException("Invalid index");

        if (size >= capacity)
            grow();

        for(int i = size + 1; i > index; i--) {
            array[i] = array[i -1];
        }
        array[index] = t;
        size++;


    } // end add() method

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {

        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         */

         if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");

         array[index] = t;

    } // end set() method

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @SuppressWarnings("unchecked")
	public AnyType remove( int index ) throws IndexOutOfBoundsException {

        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation
         * available in the Java API) to perform left or right
         * shift operations
         *
         */

          if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");

          Object removed = array[index];


          for (int i = index; i < size; i++) {
              array[i] = array[i + 1];
          }

          size--;
          return (AnyType) removed;
    } // end remove() method

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @SuppressWarnings("unchecked")
	public AnyType get(int index) throws IndexOutOfBoundsException {

        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         */

         if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");

        return (AnyType) array[index];
    } // end get() method

    /**
     * Returns the number of elements in this list.
     *
     * @return
     */
    public int size() {

        return size;

    } // end size() method

    /**
     * Returns true if this list contains no elements.
     *
     * @return
     */
    public Boolean isEmpty() {

        return ( size == 0 );

    } // end isEmpty() method


    /**
     * Removes all of the elements from this list.
     * and the initial capacity is set back to 10
     *
     */
    public void clear() {

        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         */

        array = new Object[ INITIAL_CAPACITY ];

        capacity = 10;
 		size = 0;
    } // end clear method

    /**
     * Double the capacity of the array
     *
     */
    private void grow() {

    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation
         * available in the Java API)
         *
         */

         Object[] growArray = new Object[capacity * 2];

         for (int i = 0; i < size; i++){
             growArray[i] = array[i];
         }
         array = growArray;
         capacity *= 2;

    } // end grow() method


    /**
     * Half the capacity of the array
     *
     */
    private void shrink() {
    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation
         * available in the Java API)
         *
         */

         Object[] shrinkArray = new Object[capacity / 2];

         for (int i = 0; i < capacity/2; i++){
             shrinkArray[i] = array[i];
         }
         array = shrinkArray;
         capacity /= 2;

    } // end shrink() method

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append(String.format("Size=%d, A = [ ", new Object[]{Integer.valueOf(this.size)}));
        if(!this.isEmpty().booleanValue()) {
            for(int var2 = 0; var2 < this.size - 1; ++var2) {
                var1.append(String.format("%d, ", new Object[]{(Comparable)this.array[var2]}));
            }

            var1.append(String.format("%d ]", new Object[]{this.array[this.size - 1]}));
        } else {
            var1.append("] ");
        }

        return var1.toString();
    }
    /**
     *
     * @param args
     */
    public static void main( String[] args ) {

        /**
         * -------------------------------------------
         * TODO: Put your test cases here
         *
         */

         ArrayList testArray = new ArrayList();

         // add
         System.out.println("\nTesting add method");
         testArray.add(0, "Java sucks");
         testArray.add(1, "RIP");
         testArray.add(2, "I just want to code in py or node for the rest of my life");
         testArray.add(3, "I would rather code in PHP than java");
         testArray.add(4, "I dont even know how to write in PHP");
         testArray.add(8, "REKT");

         for (int i = 0; i < testArray.capacity; i++){
             System.out.println(testArray.get(i));
         }

         // remove REKT
         System.out.println("\nTesting remove method");
         testArray.remove(9);

         for (int i = 0; i < testArray.capacity; i++){
             System.out.println(testArray.get(i));
         }

         // set REKT
         System.out.println("\nTesting set method");
         testArray.set(5, "JEEZ");

         for (int i = 0; i < testArray.capacity; i++){
             System.out.println(testArray.get(i));
         }

         // grow method
         System.out.println("\nTesting grow method");
         System.out.println("initial capacity: " + testArray.capacity);

         testArray.add(5);
         testArray.add(1);
         testArray.add(7);
         testArray.add(8);
         testArray.add(5);
         testArray.add(0);

         for (int i = 0; i < testArray.capacity; i++){
             System.out.println(testArray.get(i));
         }
         System.out.println("capacity after grow: " + testArray.capacity);

         for (int i = 0; i < testArray.capacity; i++){
             System.out.println(testArray.get(i));
         }

         // shrink method
         System.out.println("\nTesting shrink method");
         System.out.println("initial capacity: " + testArray.capacity);
         testArray.shrink();
         System.out.println("capacity after shrink: " + testArray.capacity);

         // clear
         System.out.println("\nTesting clear method");
         testArray.clear();
         for (int i = 0; i < testArray.capacity; i++){
             System.out.println(testArray.get(i));
         }

    } // end main() method

} // end ArrayList class definition
