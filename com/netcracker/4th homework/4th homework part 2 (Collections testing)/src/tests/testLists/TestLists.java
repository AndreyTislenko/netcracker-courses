package tests.testLists;

import tests.testCollections.TestCollections;

import java.util.*;

public class TestLists<T> extends TestCollections<T> {

    public TestLists(ArrayList<T> arrayList, LinkedList<T> linkedList) {
        if (!arrayList.equals(linkedList)) throw new RuntimeException("Lists are not equal");

        super.collections.add((ArrayList<T>)arrayList.clone());//0
        super.collections.add((LinkedList<T>)linkedList.clone());//1
        super.size = arrayList.size();
    }

    /*These are some procedural methods for console, with the same names as the private returning methods below.*/
    public void testGet(int index) {
        System.out.println("get(" + index + ", element):");
        decorateTestOperation(testGetWith(index));
    }
    public void testSet(int index, T element) {
        System.out.println("set(" + index + ", element):");
        decorateTestOperation(testSetWith(index, element));
    }
    public void testAddMiddle(T element) {
        testAdd(super.size/2, element);
    }
    public void testAddFirst(T element) {
        testAdd(0, element);
    }
    public void testAdd(int index, T element) {
        System.out.println("add(" + index + ", element):");
        decorateTestOperation(testAddWith(index, element));
    }
    public void testLists(OperationOnList<T> operation, T element) {
        decorateTestOperation(testListsWith(operation, element));
    }

    /*Some private returning methods*/
    private long[] testGetWith(int index) {
        return testListsWith((list, item) -> list.get(index), null);
    }
    private long[] testSetWith(int index, T element) {
        return testListsWith((list, item) -> list.set(index, item), element);
    }
    private long[] testAddWith(int index, T element) {
        return  testListsWith((list, item) -> list.add(index, item), element);
    }
    private long[] testListsWith(OperationOnList<T> operation, T element) {
        long durationOfArrayList = testOperation((ArrayList<T>)collections.get(0), operation, element);
        long durationOfLinkedList = testOperation((LinkedList<T>)collections.get(1), operation, element);
        return new long[]{durationOfArrayList, durationOfLinkedList};
    }
    private long testOperation(List<T> list, OperationOnList<T> operation, T element) {
       long time = System.nanoTime();
       operation.run(list, element);
       return System.nanoTime() - time;
    }

    @Override
    public void decorateTestOperation(long... durations) {
        System.out.print("ArrayList = " + durations[0]+ " ns, ");
        System.out.println("LinkedList = " + durations[1] + " ns.");
        System.out.print("The difference (ArrayList - LinkedList) = " + (durations[0] - durations[1]));
        System.out.println(", the quotient (ArrayList/LinkedList) = " + ((double)durations[0]/durations[1]) + ".");
    }

    @FunctionalInterface
    public interface OperationOnList<T> {
        void run(List<T> list, T element);
    }
}
