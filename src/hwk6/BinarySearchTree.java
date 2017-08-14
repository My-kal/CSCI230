//package csci230.hwk6;
package hwk6;

/**
 *
 * Binary search that does not allow two (or more) binary nodes
 * in the search tree to have the same element value.
 *
 * @author CSCI 230: Data Structures and Algorithms Spring 2017
 *
 * @param <AnyType>
 */
public class BinarySearchTree <AnyType extends Comparable> {

	// --------------------------------------
	// instance variable
	private BinaryNode<AnyType> root;

	/**
	 * Constructor with one parameter that
	 * sets the root node of the BST.
	 *
	 * @param root
	 */
	public BinarySearchTree( AnyType rootElement ) throws NullBinaryNodeException {

		if ( rootElement == null ) {
			throw new NullBinaryNodeException();
		}

		this.root = new BinaryNode<AnyType>( rootElement ) ;

	} // end constructor

	/**
	 * If the BST does not have a root node, then the BST is empty.
	 *
	 * @return
	 */
	public boolean isEmpty() {

		return ( root == null );

	} // end isEmpty() method

	/**
	 * Make the BST empty, i.e. a BST that has
	 * no nodes (including a root node).
	 *
	 */
	public void makeEmpty() {

		root = null;

	} // end makeEmpty() method

	/**
	 * Method that adds a new node with the specified element
	 * value in the BST.
	 *
	 * This method has one parameter:
	 *  1) The element value to be added
	 *
	 * If the BST has an existing node with the same element
	 * value, throw an duplicate element exception.
	 *
	 * @param element
	 * @throws NullBinaryNodeException
	 * @throws DuplicateElementException
	 */
	public void add( AnyType element ) throws DuplicateElementException, NullBinaryNodeException {

		if ( element == null ) {

			throw new NullBinaryNodeException();

		} if ( root == null ) {

			this.root = new BinaryNode<AnyType>( element );

		} else {

			add( root, element );

		}

	} // end add() method

	/**
	 * Private recursive method that adds a new node (with the
	 * specified element value) in the BST.
	 *
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value to be added
	 *
	 * If the BST has an existing node with the same element
	 * value, throw an duplicate element exception.
	 *
	 * @param node
	 * @param element
	 */
	private void add( BinaryNode<AnyType> node, AnyType element )  throws DuplicateElementException {

		int compare = element.compareTo( node.getElement() );

		if ( compare == 0 ) {

			throw new DuplicateElementException();

		} else if ( compare < 0 ) {

			if ( node.getLeft() == null ) {

				node.setLeft( new BinaryNode<AnyType>( element ) );
				node.getLeft().setParent( node );

			} else {

				add( node.getLeft(), element );

			}

		} else if ( compare > 0 ) {

			if ( node.getRight() == null ) {

				node.setRight( new BinaryNode<AnyType>( element ) );
				node.getRight().setParent( node );

			} else {

				add( node.getRight(), element );

			}

		}

	} // end add() overloaded method

	/**
	 * Method that determines if a node with the specified element value
	 * exists in the BST.
	 *
	 * This method has one parameter:
	 *  1) The element value that is being searched.
	 *
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 *
	 * @param element
	 * @return
	 * @throws NullBinaryNodeException
	 * @throws EmptyBSTException
	 *
	 */
	public boolean hasElement( AnyType element ) throws EmptyBSTException, NullBinaryNodeException {

		if ( isEmpty() )
			throw new EmptyBSTException();
		else if ( element == null )
			throw new NullBinaryNodeException();

		return hasElement( root, element );

	} // end hasElement() method

	/**
	 * Private recursive method that determines if the element is
	 * currently stored in the BST.
	 *
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value that is being searched.
	 *
	 *  Hint: use the compareTo() method
	 *
	 * @param element
	 * @param node
	 * @return
	 */
	private boolean hasElement( BinaryNode<AnyType> node, AnyType element ) {

		if ( node == null )
			return false;

		int compare = element.compareTo( node.getElement() );

		if ( compare == 0 ) {

			return true;

		} else if ( compare < 0 ) {

			return hasElement( node.getLeft(), element );

		} else {

			return hasElement( node.getRight(), element );

		}

	} // end hasElement() overloaded method

	/**
	 * Find the node with the minimum element value in the BST.
	 *
	 * This method has no parameters.
	 *
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 *
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType findMin() throws EmptyBSTException {

		if ( isEmpty() )
			throw new EmptyBSTException();

		return findMin( root ).getElement();

	} // end findMin() method

	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the minimum element value.
	 *
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 *
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> findMin( BinaryNode<AnyType> node ) {

		if ( node.getLeft() == null ) {

			return node;

		} else {

			return findMin( node.getLeft() );
		}

	} // end findMin() method

	/**
	 * Find the node with the maximum element value in the BST.
	 *
	 * This method has no parameters.
	 *
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 *
	 * @return
	 * @throws EmptyBSTException
	 */
	public AnyType findMax() throws EmptyBSTException {

		if ( isEmpty() )
			throw new EmptyBSTException();

		return findMax( root ).getElement();

	} // end findMax() method

	/**
	 * Private recursive method that walks the BST searching
	 * for the node with the maximum element value.
	 *
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 *
	 * @param node
	 * @return
	 */
	private BinaryNode<AnyType> findMax( BinaryNode<AnyType> node ) {

		if ( node.getRight() == null ) {

			return node;

		} else {

			return findMax( node.getRight() );
		}

	} // end findMax() method

	/**
	 * Delete the node with the specified element value in the BST.
	 *
	 * This method has one parameter:
	 * 	1) the element value to be deleted
	 *
	 * This method performs the following delete operations
	 * 	1) delete node with no children (case 1)
	 * 	2) delete node with one child (case 2)
	 * 	3) delete node with two children (case 3)
	 *
	 * If the BST is empty, throw an empty binary search tree
	 * exception.
	 *
	 * If the element is null, throw a null binary node
	 * exception
	 *
	 * @param element
	 * @throws EmptyBSTException
	 * @throws NullBinaryNodeException
	 */
	public void delete( AnyType element ) throws EmptyBSTException, NullBinaryNodeException {

		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 *
		 * Note: Your solution must use recursion
		 *
		 */


        if (isEmpty()) {
            throw new EmptyBSTException();
        } else if (element == null) {
            throw new NullBinaryNodeException();
        } else {
            if (root.getLeft() == null && root.getRight() == null){
                makeEmpty();
            } else {
                delete(root, element);
            }
        }

	} // end delete() method

	/**
	 * Private recursive method that walk the BST looking for
	 * the specified element value to be removed.
	 *
	 * This method has two parameters:
	 *  1) The node visited while recursively walking the BST
	 *  2) The element value that is being removed.
	 *
	 * @param node
	 * @param element
	 */
	private void delete( BinaryNode<AnyType> node, AnyType element ) {

		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 *
		 * Note: Your solution must use recursion
		 *
		 */

        int c = element.compareTo( (AnyType) node.getElement());

        if (c < 0){
            delete(node.getLeft(), element);
        }

        else if (c > 0){
            delete(node.getRight(), element);
        } else {
            //Case 1 - no children
            if (node.getLeft() == null && node.getRight() == null) {
                BinaryNode<AnyType> parent = node.getParent();

                if (parent.getLeft() != null && parent.getLeft().getElement().compareTo(element) == 0){
                    parent.setLeft(null);
                } else if (parent.getRight() != null & parent.getRight().getElement().compareTo(element) == 0){
                    parent.setRight(null);
                }
            }

            // node has one child
            else if (node.getLeft() != null && node.getRight() == null) {
                BinaryNode<AnyType> temp = findMax(node.getLeft());

                node.setElement(temp.getElement());
                delete(temp, temp.getElement());

            } else if (node.getRight () != null && node.getLeft() == null) {
                BinaryNode<AnyType> rightMin = findMin(node.getRight());

                node.setElement(rightMin.getElement());
                delete(rightMin, rightMin.getElement());
            }

            // node has two children
            else {
                BinaryNode<AnyType> rightTreeMin = findMin(node.getRight());

                node.setElement(rightTreeMin.getElement());
                delete(rightTreeMin, rightTreeMin.getElement());
            }
        }
    } // end delete() method

	/**
	 * Recursive method that traverses the BST
	 * dynamically creating a string with the
	 * element values stored in an post-order
	 * tree traversal format.
	 *
	 * The return string MUST be formated as follows:
	 * <element>,<element>,<element>,<element>, .... <element>
	 * where <element> is the element value
	 * For example,
	 * 	1,3,2
	 * Hint: you may want to use regular expressions
	 *
	 * Discussed in class, please review
	 * your notes
	 *
	 * This method has no parameters.
	 *
	 * If the BST is empty, throw an empty binary search
	 * tree exception
	 *
	 * @throws EmptyBSTException
	 * @return
	 *
	 */
	public String postOrder() throws EmptyBSTException {

		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 *
		 * Note: Your solution must use recursion
		 *
		 */

        if (root == null)
            throw new EmptyBSTException();
        String str = postOrder(root);
        return str.substring(0, str.length() - 1);

//
//		if (root == null) {
//		    throw new EmptyBSTException();
//        } else {
//            String post = postOrder(root);
//
//            return post.substring(0, post.length() - 1);
//        }

	} // end postOrder() method

	/**
	 * Private recursive method that traverses the BST
	 * dynamically creating a string with the
	 * element values stored in an post-order
	 * tree traversal format.
	 *
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 *
	 * @param node
	 * @return
	 *
	 */
	private String postOrder( BinaryNode<AnyType> node ) {

		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 *
		 * Note: Your solution must use recursion
		 *
		 */

		if (node != null){

			 return String.format("%s%s%s,",
				postOrder(node.getLeft()),
				postOrder(node.getRight()),
				node.getElement());

		} else {
            return "";
        }

	} // end postOrder() method

	/**
	 * Recursive method that traverses the BST
	 * dynamically creating a string with the
	 * element values stored in an pre-order
	 * tree traversal format.
	 *
	 * The return string MUST be formated as follows:
	 * <element>,<element>,<element>,<element>, .... <element>
	 * where <element> is the element value
	 * For example,
	 * 	2,1,3
	 * Hint: you may want to use regular expressions
	 *
	 * Discussed in class, please review
	 * your notes
	 *
	 * If the BST is empty, throw an empty binary search
	 * tree exception
	 *
	 * @throws EmptyBSTException
	 * @return
	 *
	 */
	public String preOrder() throws EmptyBSTException {

		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 *
		 * Note: Your solution must use recursion
		 *
		 */

        if (root == null) throw new EmptyBSTException();

        String pre = preOrder(root);
        return pre.substring(0, pre.length() - 1);

	} // end preOrder() method

	/**
	 * Private recursive method that traverses the BST
	 * dynamically creating a string with the
	 * element values stored in an pre-order
	 * tree traversal format.
	 *
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 *
	 * @param node
	 * @return
	 *
	 */
	private String preOrder( BinaryNode<AnyType> node ) {

		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 *
		 * Note: Your solution must use recursion
		 *
		 */

        String pre = "";
        if (node != null) {

            pre =  String.format("%s,%s%s",
                    node.getElement(),
                    preOrder(node.getLeft()),
                    preOrder(node.getRight()));
        }

        return pre;

	} // end preOrder() method

	/**
	 * Recursive method that traverses the BST
	 * dynamically creating a string with the
	 * element values stored in an in-order
	 * tree traversal format.
	 *
	 * The return string MUST be formated as follows:
	 * <element>,<element>,<element>,<element>, .... <element>
	 * where <element> is the element value
	 * For example,
	 * 	1,2,3
	 * Hint: you may want to use regular expressions
	 *
	 * Discussed in class, please review
	 * your notes
	 *
	 * If the BST is empty, throw an empty binary search
	 * tree exception
	 *
	 * @throws EmptyBSTException
	 * @return
	 *
	 */
	public String inOrder() throws EmptyBSTException {

		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 *
		 * Note: Your solution must use recursion
		 *
		 */

        if (root == null)
            throw new EmptyBSTException();

        String in = inOrder(root);
        return in.substring(0, in.length() - 1);

	} // end inOrder() method


	/**
	 * Private recursive method that traverses the BST
	 * dynamically creating a string with the element
	 * values stored in an in-order tree traversal format.
	 *
	 * This method has one parameter:
	 *  1) The node visited while recursively walking the BST
	 *
	 * @param node
	 * @return
	 *
	 */
	private String inOrder( BinaryNode<AnyType> node ) {

		/**
		 * ------------------------------------
		 * TODO: You complete the code.
		 *
		 * Note: Your solution must use recursion
		 *
		 */

        String in = "";
        if (node != null){

            in = String.format("%s%s,%s",
                    inOrder(node.getLeft()),
                    node.getElement(),
                    inOrder(node.getRight()));
        }

        return in;

	} // end inOrder() method

	/**
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		/**
		 * ------------------------------------
		 * TODO: You put your test cases here
		 *
		 *
		 */

		try {
			BinarySearchTree BST = new BinarySearchTree(4);

			// add
			BST.add(2);
            BST.add(5);
			BST.add(3);
            BST.add(1);

            // post order
			System.out.println("Post order: " + BST.postOrder()); // 13254

            // pre order
            System.out.println("Pre order: " + BST.preOrder()); // 42135

            // in order
            System.out.println("In order: " + BST.inOrder()); // 12345

            System.out.println();

            // delete node with no children
            System.out.println("BST min before delete method w/ no children: " + BST.findMin()); // 1
            BST.delete(1);

            System.out.println("BST min after delete method w/ no children: " + BST.findMin()); // 2
            System.out.println();

            // delete node with 1 child
            System.out.println("BST max before delete method w/ 1 child: " + BST.findMax()); // 5
            BST.delete(5);

            System.out.println("BST min after delete method w/ 1 child: " + BST.findMax()); // 4

            System.out.println();

            // delete node with 2 children
            System.out.println("BST min before delete method w/ 3 children: " + BST.findMin()); // 2
            BST.delete(2);

            System.out.println("BST min after delete method w/ 3 children: " + BST.findMin()); // 3

        } catch (NullBinaryNodeException e) {
		 	 System.out.println("Null Binary Node Exception\n");
		  } catch (DuplicateElementException e) {
		 	 System.out.println("Duplicate Element Exception\n");
		 } catch (EmptyBSTException e) {
			 System.out.println("Binary Search Tree is Empty\n");
		 }

	} // end main method


} // end BinarySearchTree class
