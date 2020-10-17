package arrays.sorting;

/*
    File Name : BubbleSort.java
    
    @author Mayank Sharma
    First Created on 12-10-2020 at 15:13
*/

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {8,5,2,9,6,3};
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        int len = arr.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
    }

}
