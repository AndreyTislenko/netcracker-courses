package main;

import myLinkedList.MyLinkedList;
import testClasses.coordinateSystems.points.MyPoint;
import testClasses.coordinateSystems.triangles.MyTriangle;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        //m.doTest1();

        //the size of both linked lists is 10000;
        //m.doTest2();
        m.doAdditionalTestingForIndexOf(100);
    }

    private void doAdditionalTestingForIndexOf(int amountOfRepeat) {
        System.out.println();
        System.out.println("indexOf(element) additional tasting");
        int index = (int)(Math.random()*10000);
        System.out.println("The index of element is " + index);
        doTest3(amountOfRepeat, index);
        /*
         * conclusion: the performance of indexOf(element) method for MyLinkedList is somewhat worse than the
         * performance for CustomLinkedList (doAdditionalTestingForIndexOf(100) shows that the average quotient
         * is about 2 or less). The methods have almost identical implementation, though. And it's very strange for them
         * to have that difference in performance. Tests for indexOf(null) gives us the average quotient of 1 (same
         * performance), witch means that the problem affecting performance is within the else condition of method(see
         * indexOf src). However I failed to figure out what this problem is: iterations are the same, equals methods
         * are also the same, the distinction in Node classes is minimal, so it shouldn't affect on performance.
         * Therefore, I believe that the performance gain is nothing more than an internal optimization of JVM for
         * LinkedList.
         */
    }

    private void doTest3(int amountOfRepeat, int index) {
        long[] averageTime = new long[2];
        for(int i = 0; i < amountOfRepeat; i++) {
            averageTime[0]+=doTestForIndexOf(index)[0];
            averageTime[1]+=doTestForIndexOf(index)[1];
        }
        long averageTimeOfCustomList = averageTime[0]/amountOfRepeat;
        long averageTimeOfMyList = averageTime[1]/amountOfRepeat;
        System.out.println("The average time: myList = " + averageTimeOfMyList + ", customList = " + averageTimeOfCustomList);
        double difference = averageTimeOfCustomList - averageTimeOfMyList;
        String s0 = "The average difference(CustomList - MyList) = " + difference;
        double quotient = (double)averageTimeOfCustomList/averageTimeOfMyList;
        String s1 = ", the average quotient(CustomList/MyList) = " + quotient;
        System.out.println(s0 + s1);
    }

    private long[] doTestForIndexOf(int index) {
        MyTriangle[] myTrianglesArray = setArrayOfRandomTriangles(10000);
        MyLinkedList<MyTriangle> myLinkedList = new MyLinkedList<>();
        LinkedList<MyTriangle> customLinkedList = new LinkedList<>();

        long timeOfMyList;
        long timeOfCustomList;

        addToList(myTrianglesArray, myLinkedList);
        addToList(myTrianglesArray, customLinkedList);

        MyTriangle triangleFromMyList;
        MyTriangle triangleFromCustomList;
        triangleFromMyList = myLinkedList.get(index);
        triangleFromCustomList = customLinkedList.get(index);

        timeOfMyList = System.nanoTime();
        int index1 = myLinkedList.indexOf(triangleFromMyList);
        timeOfMyList = System.nanoTime() - timeOfMyList;
        timeOfCustomList = System.nanoTime();
        int index2 = customLinkedList.indexOf(triangleFromCustomList);
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        //System.out.println(timeOfMyList - timeOfCustomList);
        return new long[]{timeOfCustomList, timeOfMyList};
    }

    private void doTest2() {
        MyTriangle[] myTrianglesArray = setArrayOfRandomTriangles(10000);

        MyLinkedList<MyTriangle> myLinkedList = new MyLinkedList<>();
        LinkedList<MyTriangle> customLinkedList = new LinkedList<>();

        long timeOfMyList;
        long timeOfCustomList;
        long difference;
        double quotient;

        //time of adding 10000 elements at the end
        System.out.println("add(element)");
        timeOfMyList = System.nanoTime();
        addToList(myTrianglesArray, myLinkedList);
        timeOfMyList = System.nanoTime() - timeOfMyList;
        timeOfCustomList = System.nanoTime();
        addToList(myTrianglesArray, customLinkedList);
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        System.out.println("The size of lists: MyList.size() = " + myLinkedList.size() + ", CustomLinkedList.size() = " + customLinkedList.size());
        System.out.println("The time of adding 10000 elements at the end: MyList = " + timeOfMyList + ", CustomList = " + timeOfCustomList);
        //time of adding one element at the end
        timeOfMyList = System.nanoTime();
        myLinkedList.add(new MyTriangle(0.0, 1.0, 10.0, 20.0, 0.0, 9.0));
        timeOfMyList = System.nanoTime() - timeOfMyList;
        timeOfCustomList = System.nanoTime();
        customLinkedList.add(new MyTriangle(0.0, 1.0, 10.0, 20.0, 0.0, 9.0));
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        System.out.println("The time of adding 1 element at the end: MyList = " + timeOfMyList + ", CustomList = " + timeOfCustomList);
        difference = timeOfCustomList - timeOfMyList;
        quotient = (double)timeOfCustomList/timeOfMyList;
        System.out.println("The difference (timeOfCustomList - timeOfMyList) = " + difference + ", the quotient (timeOfCustomList/timeOfMyList) = " + quotient);
       /*
        * conclusion: the time of MyLinkedList adding is worse than the time of custom LinkedList adding. I think it's because the custom
        * LinkedList is double-linked and has property Node<E> last, which makes it faster to get last element and "append"
        * another item to the list, than to iterate over the whole list from the beginning.
        */
        System.out.println();

        //time of adding one element and 10000 elements at the beginning
        System.out.println("add(0, element)");
        timeOfMyList = System.nanoTime();
        myLinkedList.add(0, new MyTriangle(100.0, 21.0, 130.0, 20.0, 4.0, 9.0));
        timeOfMyList = System.nanoTime() - timeOfMyList;
        timeOfCustomList = System.nanoTime();
        customLinkedList.add(0, new MyTriangle(100.0, 21.0, 130.0, 20.0, 4.0, 9.0));
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        System.out.println("The time of adding 1 element at the beginning: MyList = " + timeOfMyList + ", CustomList = " + timeOfCustomList);
        timeOfMyList = System.nanoTime();
        addToList(myTrianglesArray, myLinkedList, 0);
        timeOfMyList = System.nanoTime() - timeOfMyList;
        timeOfCustomList = System.nanoTime();
        addToList(myTrianglesArray, customLinkedList, 0);
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        System.out.println("The time of adding 10000 elements at the beginning: MyList = " + timeOfMyList + ", CustomList = " + timeOfCustomList);
        System.out.println("The size of lists: MyList.size() = " + myLinkedList.size() + ", CustomLinkedList.size() = " + customLinkedList.size());
        difference = timeOfCustomList - timeOfMyList;
        quotient = (double)timeOfCustomList/timeOfMyList;
        System.out.println("The difference (timeOfCustomList - timeOfMyList) = " + difference + ", the quotient (timeOfCustomList/timeOfMyList) = " + quotient);
        /*
         * conclusion: the time of MyLinkedList adding at the beginning is better than the time of custom LinkedList
         * adding at the same place. I think it's because the custom LinkedList has a lot of checking stuff and also
         * more methods put on the stack.
         */
        System.out.println();

        //time of getting element by index and time getting index by element.
        int index = 1488;
        System.out.println("get(index)");
        MyTriangle triangleFromMyList;
        MyTriangle triangleFromCustomList;
        timeOfMyList = System.nanoTime();
        triangleFromMyList = myLinkedList.get(index);
        timeOfMyList = System.nanoTime() - timeOfMyList;
        timeOfCustomList = System.nanoTime();
        triangleFromCustomList = customLinkedList.get(index);
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        System.out.println("The time of getting 1 element: MyList = " + timeOfMyList + ", CustomList = " + timeOfCustomList);
        difference = timeOfCustomList - timeOfMyList;
        quotient = (double)timeOfCustomList/timeOfMyList;
        System.out.println("The difference (timeOfCustomList - timeOfMyList) = " + difference + ", the quotient (timeOfCustomList/timeOfMyList) = " + quotient);
        /*
         * conclusion: the time of get(index) method for MyLinkedList is worse than time for custom LinkedList due to
         * double linked nature of LinkedList. There is Node<E> node(int index) method in LinkedList, which, depending
         * on the index (if index > size/2 or not), starts iteration from the head or from the tail of the list.
         * It gives a twice better time performance at least.
         */
        System.out.println();

        int index1, index2;
        System.out.println("indexOf(element)");
        timeOfMyList = System.nanoTime();
        index1 = myLinkedList.indexOf(triangleFromMyList);
        timeOfMyList = System.nanoTime() - timeOfMyList;
        timeOfCustomList = System.nanoTime();
        index2 = customLinkedList.indexOf(triangleFromCustomList);
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        System.out.print("The time of getting index: MyList = " + timeOfMyList + ", CustomList = " + timeOfCustomList);
        System.out.println(". The indices: " + index1 + ", " + index2 + ".");
        difference = timeOfCustomList - timeOfMyList;
        quotient = (double)timeOfCustomList/timeOfMyList;
        System.out.println("The difference (timeOfCustomList - timeOfMyList) = " + difference + ", the quotient (timeOfCustomList/timeOfMyList) = " + quotient);
        /*
         * the conclusion is in the doAdditionalTestingForIndexOf method.
         */
        System.out.println();

        System.out.println("remove(index)");
        timeOfMyList = System.nanoTime();
        MyTriangle triangle1 = myLinkedList.remove(10000);
        timeOfMyList = System.nanoTime() - timeOfMyList;
        timeOfCustomList = System.nanoTime();
        MyTriangle triangle2 = customLinkedList.remove(10000);
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        System.out.print("The time of removing: MyList = " + timeOfMyList + ", CustomList = " + timeOfCustomList);
        System.out.println(". Are elements the same? -> " + triangle1.equals(triangle2));
        difference = timeOfCustomList - timeOfMyList;
        quotient = (double)timeOfCustomList/timeOfMyList;
        System.out.println("The difference (timeOfCustomList - timeOfMyList) = " + difference + ", the quotient (timeOfCustomList/timeOfMyList) = " + quotient);
        /*
         * conclusion: the time of remove(index) method for MyLinkedList is worse then time for custom LinkedList due to
         * double linked nature of LinkedList. There is Node<E> node(int index) method in LinkedList, which, depending
         * on the index (if index > size/2 or not), starts iteration from the head or from the tail of the list.
         * It gives a twice better time performance at least.
         */
    }

    private void addToList(MyTriangle[] myTrianglesArray, MyLinkedList<MyTriangle> list) {
        for (MyTriangle triangle: myTrianglesArray) {
            list.add(triangle);
        }
    }
    private void addToList(MyTriangle[] myTrianglesArray, LinkedList<MyTriangle> list) {
        for (MyTriangle triangle: myTrianglesArray) {
            list.add(triangle);
        }
    }
    private void addToList(MyTriangle[] myTrianglesArray, MyLinkedList<MyTriangle> list, int index) {
        for (MyTriangle triangle: myTrianglesArray) {
            list.add(index, triangle);
        }
    }
    private void addToList(MyTriangle[] myTrianglesArray, LinkedList<MyTriangle> list, int index) {
        for (MyTriangle triangle: myTrianglesArray) {
            list.add(index, triangle);
        }
    }

    private MyTriangle[] setArrayOfRandomTriangles(int amountOfElements) {
        MyTriangle[] arrayOfTriangles = new MyTriangle[amountOfElements];
        for (int i = 0; i < amountOfElements; i++){
            double distinction = amountOfElements/10.0;
            MyPoint v1 = new MyPoint((Math.random() + 1.0)*distinction, (Math.random() + 1.0)*distinction);
            MyPoint v2 = new MyPoint((Math.random() + 1.0)*distinction, (Math.random() + 1.0)*distinction);
            MyPoint v3 = new MyPoint((Math.random() + 1.0)*distinction, (Math.random() + 1.0)*distinction);
            arrayOfTriangles[i] = new MyTriangle(v1, v2, v3);
        }
        return arrayOfTriangles;
    }

    private void doTest1() {
        MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>();
        integerMyLinkedList.add(1);
        integerMyLinkedList.add(2);
        integerMyLinkedList.add(17);

        System.out.print("Our list is "); printlnMyLinkedList(integerMyLinkedList);
        System.out.println("checking size():");
        System.out.println("And his size is " + integerMyLinkedList.size());
        System.out.println();

        System.out.println("checking add(index, element) and get(index):");
        integerMyLinkedList.add(3, 1488);
        System.out.println("His size now is " + integerMyLinkedList.size() + ", because we added new element " + integerMyLinkedList.get(integerMyLinkedList.size() - 1));
        printlnMyLinkedList(integerMyLinkedList);
        System.out.println();

        System.out.println("Checking indexOf(element):");
        int element = 127;
        System.out.println("Index of " + element + " is " + integerMyLinkedList.indexOf(element));
        System.out.println();

        System.out.println("Checking toArray(E[] youArray):");
        Integer[] integerArray = integerMyLinkedList.toArray(new Integer[6]);
        System.out.println("Array obtained from the list is " + Arrays.toString(integerArray));
        System.out.println();

        System.out.println("Checking remove(index):");
        System.out.println("We are removing " + integerMyLinkedList.remove(3) + " from the list");
        System.out.print("Now list is "); printlnMyLinkedList(integerMyLinkedList);
        System.out.println();

        System.out.println("Checking set(index, element):");
        int index = 1;
        System.out.println("We are changing " + integerMyLinkedList.set(index, 420) + " element to " + integerMyLinkedList.get(index) + " element");
        printlnMyLinkedList(integerMyLinkedList);
        System.out.println();

        System.out.println("Checking equals(MyLinkedList anotherList):");
        MyLinkedList<Integer> anotherIntegerList = new MyLinkedList<>();
        anotherIntegerList.add(1);
        anotherIntegerList.add(420);
        anotherIntegerList.add(17);
        //anotherIntegerList.add(null);
        System.out.println(integerMyLinkedList.equals(anotherIntegerList));
        System.out.println();

        System.out.println("Checking toString():");
        System.out.println("{" + integerMyLinkedList + "}");
    }

    private void printlnMyLinkedList(MyLinkedList linkedList) {
        int length = linkedList.size() - 1;
        System.out.print("{");
        for(int i = 0; i < length; i++) {
            System.out.print(linkedList.get(i) + ", ");
        }
        System.out.println(linkedList.get(length==-1 ? 0 : length) + "}");
    }

    /*private void doIntTest5(int index, int length) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        LinkedList<Integer> customLinkedList = new LinkedList<>();

        long timeOfMyList;
        long timeOfCustomList;
        int index1;
        int index2;

        for (int i=0; i < length; i++) {
            int randomNumber = (int)(Math.random()*length);
            myLinkedList.add(randomNumber);
            customLinkedList.add(randomNumber);
        }

        int n1 = myLinkedList.get(index);
        int n2 = customLinkedList.get(index);

        timeOfMyList = System.nanoTime();
        index1 = myLinkedList.indexOf(n1);
        timeOfMyList = System.nanoTime() - timeOfMyList;

        timeOfCustomList = System.nanoTime();
        index2 = customLinkedList.indexOf(n2);
        timeOfCustomList = System.nanoTime() - timeOfCustomList;

        long difference = timeOfCustomList - timeOfMyList;
        double quotient = (double)timeOfCustomList/timeOfMyList;
        System.out.println("The time of getting index: MyList = " + timeOfMyList + ", CustomList = " + timeOfCustomList);
        System.out.println("The difference (timeOfCustomList - timeOfMyList) = " + difference + ", the quotient (timeOfCustomList/timeOfMyList) = " + quotient);
    }

    private void doTest4(int index) {
        MyTriangle[] myTrianglesArray = setArrayOfRandomTriangles(10000);
        MyLinkedList<MyTriangle> myLinkedList = new MyLinkedList<>();
        LinkedList<MyTriangle> customLinkedList = new LinkedList<>();

        long timeOfMyList;
        long timeOfCustomList;
        int index1;
        int index2;

        addToList(myTrianglesArray, myLinkedList);
        addToList(myTrianglesArray, customLinkedList);

        MyTriangle triangleFromMyList;
        MyTriangle triangleFromCustomList;
        triangleFromMyList = myLinkedList.get(index);
        triangleFromCustomList = customLinkedList.get(index);

        timeOfMyList = System.nanoTime();
        index1 = myLinkedList.indexOf(triangleFromMyList);
        timeOfMyList = System.nanoTime() - timeOfMyList;

        timeOfCustomList = System.nanoTime();
        index2 = customLinkedList.indexOf(triangleFromCustomList);
        timeOfCustomList = System.nanoTime() - timeOfCustomList;

        long difference = timeOfCustomList - timeOfMyList;
        double quotient = (double)timeOfCustomList/timeOfMyList;
        System.out.println("The time of getting index: MyList = " + timeOfMyList + ", CustomList = " + timeOfCustomList);
        System.out.println("The difference (timeOfCustomList - timeOfMyList) = " + difference + ", the quotient (timeOfCustomList/timeOfMyList) = " + quotient);

    }*/
}
