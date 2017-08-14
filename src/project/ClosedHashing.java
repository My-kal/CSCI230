package project;

public class ClosedHashing {
    private  String[] hashTable;
    private int hashTableSz;
    public int numOfElems = 0;

    public ClosedHashing(int sz){
        this.hashTableSz = sz;
        this.hashTable = new String[sz];
    }

    public float getLoadFactor(){
        return (float) numOfElems / hashTableSz;
    }

    public int getHashTableSize(){
        return hashTableSz;
    }

    public int h(String str){
        return Math.abs(str.hashCode() % hashTableSz);
    }

    public void insert(String str){
        int spot =  h(str);
        int numOfCollisions = 0;

        if (hashTable[spot] == null){
            hashTable[spot] = (str);
        } else {

            while (hashTable[spot] != null){
                spot += (int) Math.pow(numOfCollisions, 2) % hashTableSz;
                numOfCollisions++;
            }

            hashTable[spot] = (str);

        }

        numOfElems++;
    }

    public void delete(String str){
        int index = this.search(str);
        if (index > 0)  {
            hashTable[index] = null;
            numOfElems--;
        }

    }

    public int search(String str){
        int spot = h(str);

        if (hashTable[spot] != null) {
            for (int s = 0; s < hashTableSz; s++) {
                if (hashTable[spot].equals(str)) {
                    return spot;
                }
            }
        }

        return  -1;

    }

    public long timer(){
        return System.nanoTime();
    }
}
