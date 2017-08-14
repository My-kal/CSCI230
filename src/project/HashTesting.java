package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTesting {

    public static void main(String[] args) throws FileNotFoundException {

        OpenHashing OpenTable = new OpenHashing(3559);
        ClosedHashing ClosedTable = new ClosedHashing(3559);

        String path = "/Users/mykalburris/programming/java/csci230/src/project/flat.earth.info.txt";

        File myFile = new File(path);
        Scanner keyboard = new Scanner(myFile);

        List<String> wrds = new ArrayList<>();
        String wrd;
        while(keyboard.hasNext()){
            wrd = keyboard.nextLine();
            OpenTable.insert(wrd);
            ClosedTable.insert(wrd);

            wrds.add(wrd);
        }

//        System.out.println("Insertion Time: " + (OpenTable.timer() - openStartTime) + " nanosecs");

//         test search
//        openStartTime = 0;
        OpenTable.search("yb"); // word exists
//        System.out.println("Search Time: " + (OpenTable.timer() - openStartTime) + " nanosecs");

//        openStartTime = 0;
        OpenTable.search("frost"); // word does NOT exist
//        System.out.println("Search Time: " + (OpenTable.timer() - openStartTime) + " nanosecs");


        System.out.println("\nTable Size: " + OpenTable.getHashTableSize());
        System.out.println("Num of Elements: " + OpenTable.numOfElems);
        System.out.println("Load Factor: " + OpenTable.getLoadFactor());

        // delete elem
        System.out.println(OpenTable.search("yb"));

        OpenTable.delete("yb");
        OpenTable.search("yb");

//        System.out.println("\nInsertion Time: " + (ClosedTable.timer() - closedStartTime) + " nanosecs");

        // test search
//        closedStartTime = 0;
//        System.out.println("Search Time: " + (ClosedTable.timer() - closedStartTime) + " nanosecs");

//        closedStartTime = 0;
        ClosedTable.search("frost"); // false
//        System.out.println("Search Time: " + (ClosedTable.timer() - closedStartTime) + " nanosecs");

//         delete elem
        ClosedTable.search("yb");
        ClosedTable.delete("yb");
        ClosedTable.search("yb");

        System.out.println("\nSize: " + ClosedTable.getHashTableSize());
        System.out.println("Num of Elements: " + ClosedTable.numOfElems);
        System.out.println("Load Factors: " + ClosedTable.getLoadFactor());
    }

}
