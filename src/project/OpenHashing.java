package project;

/**
 * Created by mykalburris on 4/25/17.
 */

public class OpenHashing {
	private ArrayList [] hashTable;
	private int hashTableSz;
	public int numOfElems = 0;

	public OpenHashing(int sz){
		this.hashTableSz = sz;
		this.hashTable = new ArrayList[sz];
	}

	public float getLoadFactor(){
		return (float) numOfElems / hashTableSz;
	}

	public int getHashTableSize(){
		return hashTableSz;
	}


	public int h(String K){
		return Math.abs(K.hashCode() % hashTableSz);
	}

	public void insert(String str){
		int spot = h(str);

        if (hashTable[spot] != null){ // if there is an array at the index
            hashTable[spot].add(str);
        } else {  //  if there is NOT an array at the index
            hashTable[spot] = new ArrayList();
            hashTable[spot].add(str);
        }

        numOfElems++;
	}

	public void delete(String str){
		int[] indices = this.search(str);
        System.out.println(indices.toString());

		if (indices[0] > -1 && indices[1] > -1)  {
			hashTable[indices[0]].remove(indices[1]);
			numOfElems--;
		}

	}

	public int[] search(String str){
		int probe = 0;
		int spot = h(str);

        int arr[] = new int[2];
		int index = -1;
		int s = -1;

        if (hashTable[spot] != null){
			for (s = 0; s < hashTable[spot].size(); s++){
				if (hashTable[spot].get(s).equals(str)){
					index = spot;
					break;
				} else {
                    probe ++;
                }
			}
		}

		arr[0] = index;
		arr[1] = s;

		return arr;

	}

	public long timer(){
		return System.nanoTime();
	}
}
