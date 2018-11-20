package tests.testCollections;

import java.util.ArrayList;
import java.util.Collection;

public abstract class TestCollections<E> {
    protected ArrayList<Collection<E>> collections = new ArrayList<>();
    protected int size;

    public int getSize() {
        return size;
    }

    /*These are some procedural methods for console, with the same names as the private returning methods below.*/
    public void testAdd(E elementToAdd) {
        System.out.println("add(element):");
        long[] durations = new long[collections.size()];
        for (int i = 0; i < durations.length; i ++) {
            durations[i] = testAdd(collections.get(i), elementToAdd);
        }
        decorateTestOperation(durations);
    }
    public void testRemove(E elementToRemove) {
        System.out.println("remove(element):");
        long[] durations = new long[collections.size()];
        for (int i = 0; i < durations.length; i ++) {
            durations[i] = testRemove(collections.get(i), elementToRemove);
        }
        decorateTestOperation(durations);
    }

    /*Some private returning methods*/
    private long testAdd(Collection<E> collection, E elementToAdd) {
        return testOperation(collection, Collection::add, elementToAdd);
    }
    private long testRemove(Collection<E> collection, E elementToRemove) {
        return testOperation(collection, Collection::remove, elementToRemove);
    }
    private long testOperation(Collection<E> collection, OperationOnCollection<E> operation, E element){
        long time = System.nanoTime();
        operation.run(collection, element);
        return System.nanoTime() - time;
    }

    //method that needs to be overridden in the subclasses.
    public abstract void decorateTestOperation(long... durations);

    @FunctionalInterface
    public interface OperationOnCollection<E> {
        void run(Collection<E> collection, E element);
    }
}
