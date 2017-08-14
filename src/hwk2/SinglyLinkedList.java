//package csci230.hwk2;
package hwk2;

/**
 * Singly LinkedList Data Structure
 *
 * @author CSCI 230: Data Structures and Algorithms Spring 2017
 *
 * @param <AnyType>
 */
public class SinglyLinkedList<AnyType extends Comparable> implements List<AnyType> {
    // instance variables
    private Node<AnyType> headNode = null;
    private int size = 0;

    /**
     * Appends the specified element to the end of this list.
     *
     * @param t
     */
    public void add(AnyType t) {
        addNode(new Node<AnyType>(t));
    } // end add() method

    /**
     * implementation for public add(AnyType t) method
     *
     * @param t
     */
    private void addNode(Node<AnyType> t) {
        if (isEmpty()) headNode = t;
        else getNode(size-1).setNextNode(t);

        size++;
    } // end addNote() method

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
    	addNode(index, new Node<AnyType>(t));
    } // end add() method

    /*
     *
     * Implementation for public add(int index, AnyType t) method
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void addNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         */

            if (index < 0 || index > size()) {
			    throw new IndexOutOfBoundsException();
            } else {
                Node<AnyType> nowNode = headNode;
                if (index != 0){
                    nowNode = getNode(index - 1);
                    t.setNextNode(nowNode.getNextNode());
                    nowNode.setNextNode(t);
                } else {
                    t.setNextNode(headNode);
                    headNode = t;
                }
                size++;
            }
    } // end addNode() method

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
        setNode(index, new Node<AnyType>(t));
    } // end set() method

    /**
     *
     * Implementation for public set(int index, AnyType t) method
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void setNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         */

        if ( index >= size || index < 0 ) {
            throw new IndexOutOfBoundsException();
        } else {

            Node<AnyType> nowNode = headNode;
            Node<AnyType> prevNode = null;

            if (index == 0) {
                t.setNextNode(headNode.getNextNode());
                headNode = t;
            } else {

                nowNode = getNode(index);
                prevNode = getNode(index - 1);

                prevNode.setNextNode(t);
                t.setNextNode(nowNode.getNextNode());
            }
        }
    } // end setNode() method


    /**
     * Removes the element at the specified position in this list.
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove(int index) throws IndexOutOfBoundsException {
    	return removeNode(index).getData();
    } // end remove() method

    /**
     *
     * Implementation for public remove(int index) method
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> removeNode(int index) throws IndexOutOfBoundsException {
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         */

		if (isEmpty() || index < 0 || index >= size()) throw new IndexOutOfBoundsException();

        Node<AnyType> nowNode = headNode;
		if (index == 0){
			headNode = headNode.getNextNode();
		} else {
            nowNode = getNode(index-1);
            Node<AnyType> nextNextNode = nowNode.getNextNode().getNextNode();
            nowNode.setNextNode(nextNextNode);
        }

        size--;
        return nowNode;
    } // end removeNode() method

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get(int index) throws IndexOutOfBoundsException {
    	return getNode(index).getData();
    } // end get() method

    /**
     *
     * Implementation for public get(int index) method
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException {
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         */

         if (index < 0 || index > size())  throw new IndexOutOfBoundsException();

         Node<AnyType> nowNode = headNode;

         // cant random access
         for(int i = 0; i < index; i++){
             nowNode = nowNode.getNextNode();
         }

         return nowNode;
    } // end getNode() method

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
        return (size == 0) ? true : false;
    } // end isEmpty() method


    /**
     * Removes all of the elements from this list.
     *
     */
    public void clear() {
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         *
         */

        size = 0;
        headNode = null;
    } // end clear method


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
        SinglyLinkedList<Integer> SLinkedList = new SinglyLinkedList<Integer>();

        // add with index
        SLinkedList.add(0,0);
        SLinkedList.add(1,1);
        SLinkedList.add(2,2);

        // add node out of bounds test
        try {
            SLinkedList.add(7,7);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Add Node Error: " + e);
        }

        for (int i = 0; i < SLinkedList.size(); i++) {
            Node<Integer> nowNode = SLinkedList.getNode(i);
            System.out.println(nowNode.toString());
        }

        // test get node
        try {
           SLinkedList.get(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Get Node Error: " + e);
        }

        // check to see if all nodes were added
        for (int s = 0; s < SLinkedList.size(); s++) {
            Node<Integer> nowNode = SLinkedList.getNode(s);
            System.out.println(nowNode.toString());
        }

        // test remove node
        SLinkedList.remove(2);
        for (int i = 0; i < SLinkedList.size(); i++) {
            Node<Integer> nowNode = SLinkedList.getNode(i);
            System.out.println(nowNode.toString());
        }

        // try to remove index that doesnt exist
        try {
            SLinkedList.remove(10);
        } catch (IndexOutOfBoundsException e){
            System.out.println("Remove Node Error: " + e);
        }

        // clear list
        SLinkedList.clear();
        for (int i = 0; i < SLinkedList.size(); i++) {
            Node<Integer> nowNode = SLinkedList.getNode(i);
            System.out.println(nowNode.toString());
        }

        // add without index
        SLinkedList.add(101);
        SLinkedList.add(100);
        SLinkedList.add(99);

        for (int i = 0; i < SLinkedList.size(); i++) {
            Node<Integer> nowNode = SLinkedList.getNode(i);
            System.out.println(nowNode.toString());
        }

        // set node
        SLinkedList.set(0, 1101);
        SLinkedList.set(2, 999);

        // test set node
        try {
            SLinkedList.set(-999,8);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Set Node Error: " + e);
        }

        for (int i = 0; i < SLinkedList.size(); i++) {
            Node<Integer> nowNode = SLinkedList.getNode(i);
            System.out.println(nowNode.toString());
        }
    } // end main() method

} // end hwk2.SinglyLinkedList class definition
