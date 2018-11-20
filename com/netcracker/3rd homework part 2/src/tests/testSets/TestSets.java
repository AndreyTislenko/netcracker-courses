package tests.testSets;

import tests.testCollections.TestCollections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TestSets<T> extends TestCollections<T> {

    public TestSets(HashSet<T> hashMap, LinkedHashSet<T> linkedHashSet, TreeSet<T> treeSet) {
        if (!hashMap.equals(linkedHashSet)|| !hashMap.equals(treeSet)|| !linkedHashSet.equals(treeSet))
            throw new RuntimeException("Sets are not equal");

        super.collections.add((HashSet<T>)hashMap.clone());//0
        super.collections.add((LinkedHashSet<T>)linkedHashSet.clone());//1
        super.collections.add((TreeSet<T>)treeSet.clone());//2
        super.size = hashMap.size();
    }

    @Override
    public void decorateTestOperation(long... durations) {
        System.out.print("HashSet = " + durations[0]+ " ns, ");
        System.out.print("LinkedHashSet = " + durations[1] + " ns, ");
        System.out.println("TreeSet = " + durations[2] + " ns.");
        System.out.print("difference1 (HashSet - LinkedHashSet) = " + (durations[0] - durations[1]));
        System.out.println(", quotient1 (HashSet/LinkedHashSet) = " + ((double)durations[0]/durations[1]) + ".");
        System.out.print("difference2 (LinkedHashSet - TreeSet) = " + (durations[1] - durations[2]));
        System.out.println(", quotient2 (LinkedHashSet/TreeSet) = " + ((double)durations[1]/durations[2]) + ".");
        System.out.print("difference3 (HashSet - TreeSet) = " + (durations[0] - durations[2]));
        System.out.println(", quotient3 (HashSet/TreeSet) = " + ((double)durations[0]/durations[2]) + ".");
    }
}
