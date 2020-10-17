package utils;

/*
    File Name : SwapFunctionality.java
    
    @author Mayank Sharma
    First Created on 17-10-2020 at 12:02
*/

import java.util.List;

public class SwapFunctionality {
        public static void swap(List<Integer> arr, int i, int j){
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }

        public static void swapArray(int arr[], int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

}
