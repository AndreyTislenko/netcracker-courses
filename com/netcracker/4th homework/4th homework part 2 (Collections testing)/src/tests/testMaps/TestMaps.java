package tests.testMaps;

import tests.testLists.TestLists;

import java.util.*;

public class TestMaps<K,V> {
    private ArrayList<Map<K,V>> maps = new ArrayList<>();
    private int size;

    public TestMaps(HashMap<K,V> hashMap, LinkedHashMap<K,V> LinkedHashMap, TreeMap<K,V> treeMap) {
        maps.add((HashMap<K,V>)hashMap.clone());
        maps.add((LinkedHashMap<K,V>)LinkedHashMap.clone());
        maps.add((TreeMap<K,V>)treeMap.clone());
        size = hashMap.size();
    }

    public int getSize() {
        return size;
    }

    public void testPut(K key, V value) {
        System.out.println("put(key, value):");
        long[] durations = new long[maps.size()];
        for (int i = 0; i < durations.length; i ++) {
            durations[i] = testPut(maps.get(i), key, value);
        }
        decorateTestOperation(durations);
    }
    public void testGet(K key) {
        System.out.println("get(key):");
        long[] durations = new long[maps.size()];
        for (int i = 0; i < durations.length; i ++) {
            durations[i] = testGet(maps.get(i), key);
        }
        decorateTestOperation(durations);
    }
    public void testRemove(K key) {
        System.out.println("remove(key):");
        long[] durations = new long[maps.size()];
        for (int i = 0; i < durations.length; i ++) {
            durations[i] = testRemove(maps.get(i), key);
        }
        decorateTestOperation(durations);
    }

    private long testPut(Map<K,V> map, K key, V value) {
        OperationOnMap<K,V> operation = Map::put;
        long time = System.nanoTime();
        operation.run(map, key, value);
        return System.nanoTime() - time;
    }
    private long testGet(Map<K,V> map, K key) {
        return testOperationOnlyWithKey(map, Map::get, key);
    }
    private long testRemove(Map<K,V> map, K key) {
        return testOperationOnlyWithKey(map, Map::remove, key);
    }
    private long testOperationOnlyWithKey(Map<K,V> map, OperationOnMapOnlyWithKey<K,V> operation, K key) {
        long time = System.nanoTime();
        operation.run(map, key);
        return System.nanoTime() - time;
    }

    public void decorateTestOperation(long... durations) {
        System.out.print("HashMap = " + durations[0]+ " ns, ");
        System.out.print("LinkedHashMap = " + durations[1] + " ns, ");
        System.out.println("TreeMap = " + durations[2] + " ns.");
        System.out.print("difference1 (HashMap - LinkedHashMap) = " + (durations[0] - durations[1]));
        System.out.println(", quotient1 (HashMap/LinkedHashMap) = " + ((double)durations[0]/durations[1]) + ".");
        System.out.print("difference2 (LinkedHashMap - TreeMap) = " + (durations[1] - durations[2]));
        System.out.println(", quotient2 (LinkedHashMap/TreeMap) = " + ((double)durations[1]/durations[2]) + ".");
        System.out.print("difference3 (HashMap - TreeMap) = " + (durations[0] - durations[2]));
        System.out.println(", quotient3 (HashMap/TreeMap) = " + ((double)durations[0]/durations[2]) + ".");
    }

    @FunctionalInterface
    public interface OperationOnMapOnlyWithKey<K,V> {
        void run(Map<K,V> map, K key);
    }
    @FunctionalInterface
    public interface OperationOnMap<K,V> {
        void run(Map<K,V> map, K key, V value);
    }
}
