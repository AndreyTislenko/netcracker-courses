package main;

import tests.testCollections.TestCollections;
import tests.testLists.TestLists;
import tests.testMaps.TestMaps;
import tests.testSets.TestSets;

import java.util.*;

public class Main<T, K, V> {
    private Integer[] randomIntArray = createRandomIntArray(100000);
    private String[] randomStringArray;

    public static void main(String[] args) {
        Main<Integer, Integer, String> m = new Main<>();
        m.doOneSimpleTest();
    }

    private void doOneSimpleTest() {
        //assigning random index to select random element from lists.
        int indexOfElement = (int)(Math.random()*randomIntArray.length);
        //index for set and get methods.
        int index = (int)(Math.random()*randomIntArray.length);

        doOneSimpleTestForLists(indexOfElement, index);
        /*  a)
         *
         *  As can be seen from this test, LinkedList is better than ArrayList at deleting elements and adding
         *  elements to the beginning or the end. Their different implementation of List interface causes different
         *  performance for different operations. ArrayList is implemented as a resizable array. As more elements are
         *  added to ArrayList, its size is increased dynamically. It's elements can be accessed directly by using the
         *  get and set methods, since ArrayList is essentially an array. LinkedList is implemented as a double linked
         *  list. Therefor, its performance on add and remove is better than ArrayList, but worse on get and set methods.
         *  However for insertion to the list (e.g. add(size/2, element)) this test showed that ArrayList is better, and
         *  I think it's because of traversing time of LinkedList over its elements. ArrayList gets specific index of
         *  insertion faster, whereas LinkedList iterates to get that index.
         */
        System.out.println();

        index = (int)(Math.random()*randomIntArray.length);
        doOneSimpleTestForSets(index);
        /* b)
         *
         * As we can see from this test, HashSet gives better performance than the LinkedHashSet and TreeSet. The
         * performance of LinkedHashSet is between HashSet and TreeSet. It’s performance is almost similar to HashSet.
         * HashSet is Implemented using a hash table. Elements are not ordered. The add, remove, and contains methods
         * has constant time complexity O(1). TreeSet is implemented using a tree structure(red-black tree).
         * The elements in a set are sorted, but the add, remove, and contains methods has  time complexity of
         * O(log (n)). It offers several methods to deal with the ordered set like first(), last(), headSet(),
         * tailSet(), etc.  LinkedHashSet is between HashSet and TreeSet. It is implemented as a hash table with a
         * linked list running through it, so it provides the order of insertion. The time complexity of basic methods
         * is O(1).
         */
        System.out.println();

        index = (int)(Math.random()*randomIntArray.length);
        String value = "wow";
        doOneSimpleTestForMaps(index, value);
        /* c)
         *
         * First of all let's give a precis of some implementation of Map interface.
         * 1) HashMap is implemented as a hash table, and there is no ordering on keys or values.
         * 2) TreeMap is implemented based on red-black tree structure, and it is ordered by the key.
         * 3) LinkedHashMap preserves the insertion order.
         * As the consequence we have these time complexity for maps:
         * -------------------------------------------------------------------------------
         * |   Property   |       HashMap      |      TreeMap      |     LinkedHashMap   |
         * -------------------------------------------------------------------------------
         * |   Get/put/   |                    |                   |                     |
         * |   remove     |         O(1)       |      O(log(n))    |         O(1)        |
         * |(containsKey) |                    |                   |                     |
         * -------------------------------------------------------------------------------
         * In this test we have very peculiar results. Somehow HashMap are the slowest one, and LinedHashMap and
         * TreeMap have almost the same performance. Maybe I made a mistake in their indices when started adding them
         * to ArrayList property of TestMaps class. I will check it. Anyway, I will try to figure out what is going on
         * here.
         */

    }

    private void doOneSimpleTestForLists(int indexOfElement, int index) {
        //In these lists we have the same objects on which elements of the two lists refer.
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(randomIntArray));
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(randomIntArray));

        //We create clones of the main lists in the TestLists constructor.
        TestLists<Integer> testLists = new TestLists<>(arrayList, linkedList);

        //some element to test operation.
        Integer element = randomIntArray[indexOfElement];
        //the testing begins.
        new Main<Integer, Integer, String>().startDefaultTesting(testLists, "list", element);
        testLists.testAddFirst(element);
        System.out.println();
        testLists.testAddMiddle(element);
        System.out.println();
        testLists.testAdd(index, element);
        System.out.println();
        testLists.testSet(index, element);
        System.out.println();
        testLists.testGet(index);
        System.out.println("--------------------------------------------end of list testing--------------------------------------------");
    }

    private void doOneSimpleTestForSets(int indexOfElement) {
        //In these sets we have the same objects on which elements of the three sets refer.
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(randomIntArray));
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(randomIntArray));
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(randomIntArray));

        //We create clones of the main sets in the TestSets constructor.
        TestSets<Integer> testSets = new TestSets<>(hashSet, linkedHashSet, treeSet);

        //some element to test operation.
        Integer element = randomIntArray[indexOfElement];
        //the testing begins.
        new Main<Integer, Integer, String>().startDefaultTesting(testSets, "set", element);
        System.out.println("--------------------------------------------end of set testing--------------------------------------------");
    }

    private void startDefaultTesting(TestCollections<T> testCollections, String nameOfCollection, T element) {
        System.out.println("--------------------------------------------Start " + nameOfCollection + " testing--------------------------------------------");
        System.out.println("element = " + element + ", size = " + testCollections.getSize());
        System.out.println();
        testCollections.testRemove(element);
        System.out.println();
        testCollections.testAdd(element);
        System.out.println();
    }

    private void doOneSimpleTestForMaps(int key, String value) {
        randomStringArray = createRandomStringArray(randomIntArray.length, 20);

        //All maps have identical pairs on the heap in memory.
        HashMap<Integer, String> hashMap = new HashMap<>();
        new Main<Integer, Integer, String>().putArraysIntoMap(randomIntArray, randomStringArray, hashMap);
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        new Main<Integer, Integer, String>().putArraysIntoMap(randomIntArray, randomStringArray, linkedHashMap);
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        new Main<Integer, Integer, String>().putArraysIntoMap(randomIntArray, randomStringArray, treeMap);

        //We create clones of the main maps in the TestSets constructor.
        TestMaps<Integer, String> testMaps = new TestMaps<>(hashMap, linkedHashMap, treeMap);

        //the testing begins.
        System.out.println("--------------------------------------------Start map testing--------------------------------------------");
        System.out.println("(key = " + key + ", value = " + value +"), size = " + testMaps.getSize());
        System.out.println();
        testMaps.testGet(key);
        System.out.println();
        testMaps.testRemove(key);
        System.out.println();
        testMaps.testPut(key, value);
        System.out.println("--------------------------------------------end of map testing--------------------------------------------");
    }

    private void putArraysIntoMap(K[] keyArray, V[] valueArray, Map<K, V> map) {
        for (int i = 0; i < keyArray.length; i++) {
            map.put(keyArray[i], valueArray[i]);
        }
    }

    private Integer[] createRandomIntArray(int length){
        Integer[] randomIntArray = new Integer[length];
        for(int i = 0; i < length; i++) {
            randomIntArray[i] = (int)(Math.random()*length);
        }
        return  randomIntArray;
    }

    private String[] createRandomStringArray(int length, int maxLengthOfString) {
        String[] randomStringArray = new String[length];
        for (int j = 0; j < randomStringArray.length; j++) {
            char[] randomChars = new char[maxLengthOfString];
            for (int i = 0; i < randomChars.length; i++) {
                randomChars[i] = (char)(65 + Math.random() * (123 - 65));
            }
            randomStringArray[j] = new String(randomChars);
        }
        return randomStringArray;
    }
}
