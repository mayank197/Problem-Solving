package arrays.sorting;

/*
    File Name : SortArray0s1s.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 10:31
*/

import utils.SwapFunctionality;

import java.util.Arrays;
import java.util.stream.Stream;

public class SortArray0s1s {

    private static void sortArray(int[] arr, int n) {
        int i=0,j=0,k=n-1;
        while(j<=k){
            switch(arr[j]){
                case 0:
                    SwapFunctionality.swapArray(arr, i, j);
                    i++; j++;
                    break;
                case 1:
                    j++;
                    break;
                case 2:
                    SwapFunctionality.swapArray(arr, j, k);
                    k--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0,2,1,2,0};
        int n = arr.length;
        sortArray(arr,n);
        Arrays.stream(arr).boxed().forEach(a -> System.out.print(a + " "));
    }

}
