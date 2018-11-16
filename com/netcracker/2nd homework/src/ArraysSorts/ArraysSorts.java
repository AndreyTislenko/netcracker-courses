package ArraysSorts;

import java.util.Arrays;

public class ArraysSorts {
    private int[] intArray;

    public ArraysSorts(int[] intArray) {
        this.intArray = intArray;
    }

    public int[] getIntArray() {
        return intArray;
    }
    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    /*                     Bubble Sort
    * The algorithm works by comparing each item in the list
    * with the item next to it, and swapping them if required.
    * In other words, the largest element has bubbled to the
    * top of the array. The algorithm repeats this process until
    * it makes a pass all the way through the list without swapping
    * any items.*/
    public void bubbleSort() {
        for (int i = (intArray.length - 1); i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (intArray[j - 1] > intArray[j]) {
                    int temp = intArray[j - 1];
                    intArray[j - 1] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
    }

    /*                          Selection Sort
    * The algorithm works by selecting the smallest unsorted item and then
    * swapping it with the item in the next position to be filled.
    * The selection sort works as follows: you look through the entire array
    * for the smallest element, once you find it you swap it (the smallest element)
    * with the first element of the array. Then you look for the smallest element
    * in the remaining array (an array without the first element) and swap it with
    * the second element. Then you look for the smallest element in the remaining
    * array (an array without first and second elements) and swap it with the
    * third element, and so on.*/
    public void selectionSort() {
        for (int i = 0; i < intArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[j] < intArray[min]) min = j;
            }
            int temp = intArray[i];
            intArray[i] = intArray[min];
            intArray[min] = temp;
        }
    }

    public void arraysSort() {
        Arrays.sort(intArray);
    }
}
