import java.util.*;

import static javafx.scene.input.KeyCode.L;

/**
 * Created by Р on 01.06.2016.
 */

public class Main {
    public static void main(String[] args) {

        final int ITERCONST = 10000;
        ArrayList<Integer> myArrayList = new ArrayList();
        LinkedList<Integer> myLinkedList = new LinkedList();

        System.out.println(" количество итерации ITERATIONCONSTANT = " +ITERCONST+ "\n");

        System.out.println("sequentialAddition выполнялась " +sequentialAddition(myArrayList,ITERCONST)+  " мс для ArrayList");
        System.out.println("sequentialAddition выполнялась " +sequentialAddition(myLinkedList,ITERCONST)+ " мс для LinkedList");

        System.out.println("randomAddition выполнялась     " +randomAddition(myArrayList,ITERCONST)+      " мс для ArrayList");
        System.out.println("randomAddition выполнялась     " +randomAddition(myLinkedList,ITERCONST)+     " мс для LinkedList");

        System.out.println("randomGet выполнялась          " +randomGet(myArrayList,ITERCONST)+           " мс для ArrayList");
        System.out.println("randomGet выполнялась          " +randomGet(myLinkedList,ITERCONST)+          " мс для LinkedList");

        System.out.println("randomRemove выполнялась       " +randomRemove(myArrayList,ITERCONST)+        " мс для ArrayList");
        System.out.println("randomRemove выполнялась       " +randomRemove(myLinkedList,ITERCONST)+       " мс для LinkedList");

        System.out.println("sort выполнялась               " +sort(myArrayList)+      " мс для ArrayList");
        System.out.println("sort выполнялась               " +sort(myLinkedList)+     " мс для LinkedList");

        System.out.println("iterator выполнялась           " +iterator(myArrayList)+  " мс для ArrayList");
        System.out.println("iterator выполнялась           " +iterator(myLinkedList)+ " мс для LinkedList");
    }
    static <L extends List> long sequentialAddition(L myList, int iterationNumber) {

        Random r = new Random();
        long startTime;
        long spentTime = 0;

        for(int i=0; i<iterationNumber; i++) {
            startTime = System.currentTimeMillis();
            myList.add(r.nextInt());
            spentTime = spentTime + (System.currentTimeMillis() - startTime);
        }
        return spentTime;
    }

    static long randomAddition(List myList, int iterationNumber) {
        Random r = new Random();
        long startTime= 0;
        long spentTime = 0;

        for(int i=0; i<iterationNumber; i++) {
            startTime = System.currentTimeMillis();
            myList.add(r.nextInt(iterationNumber),r.nextInt());
            spentTime = spentTime + (System.currentTimeMillis() - startTime);
        }
        //System.out.println("size = "+ myList.size());
        return spentTime;
    }
    static long randomGet (List myList, int iterationNumber) {
        Random r = new Random();
        long startTime= 0;
        long spentTime = 0;

        for(int i=0; i<iterationNumber; i++) {
            startTime = System.currentTimeMillis();
            myList.get(r.nextInt(iterationNumber));
            spentTime = spentTime + (System.currentTimeMillis() - startTime);
        }
        //System.out.println("size = "+ myList.size());
        return spentTime;
    }

    static long randomRemove (List myList, int iterationNumber) {
        Random r = new Random();
        long startTime= 0;
        long spentTime = 0;

        for(int i=0; i<iterationNumber; i++) {
            startTime = System.currentTimeMillis();
            myList.remove(r.nextInt(iterationNumber));
            spentTime = spentTime + (System.currentTimeMillis() - startTime);
        }
        //System.out.println("size = "+ myList.size());
        return spentTime;
    }

    static long sort(List myList) {
        long startTime= 0;
        long spentTime = 0;

        startTime = System.currentTimeMillis();
        Collections.sort(myList);
        spentTime = System.currentTimeMillis() - startTime;
        //System.out.println("size = "+ myList.size());
        return spentTime;
    }

    static <L extends List> long iterator (L myList) {

        Iterator myIterator = myList.iterator();
        long startTime;
        long spentTime = 0;

        startTime = System.currentTimeMillis();
        while(myIterator.hasNext()) {
            myIterator.next();
        }
        spentTime = spentTime + (System.currentTimeMillis() - startTime);
        return spentTime;
    }
}


