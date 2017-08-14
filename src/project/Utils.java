//package csci230.hwk7;
package project;

/**
 * Utilities class that will sort the elements of a list.
 *
 * The sorting algorithms supported in this class are:
 *	1. selection sort (increasing order)
 *	2. bubble sort (increasing order)
 *	3. insertion sort (increasing order)
 *  4. heap sort (increasing and decreasing order)
 *
 * @author CSCI 230: Data Structures and Algorithms Fall 2016
 *
 */
public class Utils {

	/**
	 *
	 */
	private Utils() {

	} // end private constructor

	/**
	 *
	 * @param list
	 */
	public static <AnyType extends Comparable> void selectionSort( List<AnyType> list ) throws IndexOutOfBoundsException {

		int min = 0;

		for ( int i=0; i< list.size()-1; i++ ) {

			min = i;

			for ( int j=i+1; j<list.size(); j++ ) {

				if ( list.get( j ).compareTo( list.get( min ) ) < 0 ) {

					min = j;

				}

			}

			list.swap( i, min );

		}

	} // end selectionSort() method

	/**
	 *
	 * @param list
	 */
	public static <AnyType extends Comparable> void bubbleSort( List<AnyType> list ) throws IndexOutOfBoundsException {

		for ( int i=0; i<list.size()-1; i++ ) {

			for ( int j=0; j<list.size()-1-i; j++ ) {

				if (  list.get( j+1 ).compareTo( list.get( j ) ) < 0 ) {

					list.swap( j, j+1 );

				}

			}

		}

	} // end bubbleSort() method

	/**
	 *
	 * @param list
	 */
	public static <AnyType extends Comparable> void insertionSort( List<AnyType> list ) throws IndexOutOfBoundsException {

		AnyType v = null;

		int j = 0;

		for ( int i=1; i< list.size(); i++ ) {

			v = list.get( i );

			j = i - 1;

			while( j >= 0 && ( list.get( j ).compareTo( v ) > 0 ) ) {

				list.set( j+1, list.get( j ) );
				j--;

			}

			list.set( j+1, v );

		}


	} // end insertionSort() method

	/**
	 *
	 * @param list
	 * @throws IndexOutOfBoundsException
	 */
	public static <AnyType extends Comparable> void maxHeapify( List<AnyType> list ) throws IndexOutOfBoundsException {

		/*
		 * TODO:
		 * ---------------------------------------------
		 * Implement max heapify algorithm as
		 * described in class and in supplemental
		 * course textbook. The pseudo-code for this
		 * algorithm can also be found in
		 * the content section on OAKS.
		 *
		 */

		if (list.size() < 1) throw new IndexOutOfBoundsException();

		for(int p = (int)((list.size()-2)/2.0); p >= 0; p--){
			boolean heap = false;

			int parentNode = p;
			AnyType val = list.get(parentNode);

			while(!heap && (2 * parentNode + 2 <= list.size())){
				int childNode = 2 * parentNode + 1;

				if (childNode + 1 < list.size()){
					if (list.get(childNode).compareTo(list.get(childNode + 1)) < 0){
						childNode += 1;
					}
				}

				if(val.compareTo(list.get(childNode)) < 0){
					list.swap(parentNode, childNode);  // swap parent node and child node
					parentNode = childNode;
				} else {
					heap = true;
				}
			}
		}
	} // end maxHeapify() method


	/**
	 *
	 * @param list
	 * @throws IndexOutOfBoundsException
	 */
	public static <AnyType extends Comparable> void minHeapify( List<AnyType> list ) throws IndexOutOfBoundsException {

		/*
		 * TODO:
		 * ---------------------------------------------
		 * Implement min heapify algorithm as
		 * described in class and in the supplemental
		 * course textbook. The pseudo-code for this
		 * algorithm can also be found in
		 * the content section on OAKS.
		 *
		 */

		if (list.size() < 1) throw new IndexOutOfBoundsException();

		for (int p = (int)((list.size() - 2) / 2); p >= 0; p--) {
			boolean heap = false;

			int parentNode = p;
			AnyType val = list.get(parentNode);

			while (!heap && (2 * parentNode + 2  <= list.size())){
				int childNode = 2 * parentNode  + 1;

				if (childNode + 1 < list.size()){
					if (list.get(childNode).compareTo(list.get(childNode + 1 )) >= 0){
						childNode += 1;
					}
				}

				if (val.compareTo(list.get(childNode)) < 0){
					heap = true;
				} else {
					list.swap(parentNode, childNode);

					parentNode = childNode;
				}
			}
		}

	} // end minHeapify() method

	/**
	 *
	 * @param sorted_list
	 * @param list
	 * @param increasing
	 * @throws IndexOutOfBoundsException
	 */
	public static <AnyType extends Comparable> void heapSort( List<AnyType> sorted_list, List<AnyType> list, Boolean increasing ) throws IndexOutOfBoundsException {

		/*
		 * TODO:
		 *
		 * ---------------------------------------------
		 * Implement heap sort algorithm as
		 * described in class and in the supplemental
		 * course textbook. The pseudo-code for this
		 * algorithm can also be found in
		 * the content section on OAKS.
		 *
		 */


		if (!increasing){
			while(list.size() > 0){
				maxHeapify(list);
				sorted_list.add(list.remove(0));
			}
		} else {
			while(list.size() > 0){
				minHeapify(list);
				sorted_list.add(list.remove(0));
			}
		}
	} // end heapSort() method


} // end Utils class definition
