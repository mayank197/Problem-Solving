package arrays.arrangement;

/*
    File Name : RearrangeArray2.java
    
    @author Mayank Sharma
    First Created on 13-10-2020 at 22:56
*/

import utils.SwapFunctionality;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

// Rearrange positive and negative numbers in O(n) time and O(1) extra space
public class RearrangeArray2 {

    private static void rearrange(int arr[], int len){
        int i = -1;
        for(int j=0;j<len;j++){
            if(arr[j] < 0){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int positive = i+1, negative = 0;
        while(positive < len && negative < positive && arr[negative] < 0){
            SwapFunctionality.swapArray(arr, negative, positive);
            positive++;
            negative+=2;
        }
    }

    public static void main(String[] args) {

        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = arr.length;
        rearrange(arr, n);
        IntStream.range(0,n).forEach(i -> System.out.print(arr[i] + " "));

    }

}
