package arrays.rotations;

/*
    File Name : SearchElementInSortedRotated.java
    
    @author Mayank Sharma
    First Created on 13-10-2020 at 13:25
*/

import java.util.Arrays;

public class SearchElementInSortedRotated {

    private static int searchIndex(int[] arr, int start, int end, int x) {
        if(start > end)
            return -1;
        int mid = start + (end-start)/2;
        if(arr[mid]==x){
            return mid;
        }
        // Means till mid, its sorted
        if(arr[start]<=arr[mid]){
            // Now, if key exists in this array
            if(x >= arr[start] && x <= arr[mid]){
                return searchIndex(arr, start, mid, x);
            }
            // If it doesn't lie in between start and mid, direct it to the 2nd half
            return searchIndex(arr, mid+1, end,x);
        }
        else{
            if(x>=arr[mid] && x <= arr[end])
                return searchIndex(arr, mid+1, end, x);
        }

        return searchIndex(arr, start, mid-1, x);

    }

    public static void main(String[] args) {

        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int x = 3;
        System.out.println(searchIndex(arr,0, arr.length-1,x));

    }

}
