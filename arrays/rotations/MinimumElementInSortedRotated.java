package arrays.rotations;

/*
    File Name : MinimumElementInSortedRotated.java
    
    @author Mayank Sharma
    First Created on 13-10-2020 at 18:16
*/

public class MinimumElementInSortedRotated {

    private static int minimumElement(int[] arr, int start, int end) {
        if(start > end)
            return arr[0];
        if(start==end)
            return arr[start];
        int mid = start + (end - start)/2;
        if(mid < end && arr[mid] > arr[mid+1])
            return arr[mid+1];
        if(mid > start && arr[mid-1] > arr[mid])
            return arr[mid];
        if(arr[start]<=arr[mid])
            return minimumElement(arr, mid+1, end);
        return minimumElement(arr, start, mid);
    }

    public static void main(String[] args) {

        int arr[] = {5,6,1,2,3,4};
        System.out.println(minimumElement(arr, 0, arr.length-1));

    }

}
