package arrays.sorting;

/*
    File Name : InsertionSort.java
    
    @author Mayank Sharma
    First Created on 12-10-2020 at 15:31
*/

import java.util.Arrays;

public class InsertionSort {

    private static void insertionSort(int[] arr) {
        int len = arr.length;
        for(int i=1;i<len;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        Arrays.stream(arr).forEach(a-> System.out.print(a + " "));
    }

    public static void main(String[] args) {

        int arr[] = {8,5,2,9,6,3};
        insertionSort(arr);

    }

}
