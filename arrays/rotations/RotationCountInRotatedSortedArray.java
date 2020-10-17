package arrays.rotations;

/*
    File Name : RotationCountInRotatedSortedArray.java
    
    @author Mayank Sharma
    First Created on 13-10-2020 at 17:31
*/

public class RotationCountInRotatedSortedArray {

    private static int rotationCount(int[] arr, int length) {
        int pivot = findPivot(arr, 0, arr.length-1);
        return pivot;
    }

    // 12, 15, 18, 2, 3, 6
    private static int findPivot(int[] arr, int start, int end) {
        if(start > end)
            return 0;
        if(start==end)
            return start;
        int mid = start + (end-start)/2;
        if(mid > start && arr[mid-1] > arr[mid])
            return mid;
        if(mid < end && arr[mid] > arr[mid+1])
            return mid+1;
        // Means first half is sorted
        if(arr[start]<=arr[mid])
            return findPivot(arr, start, mid);
        return findPivot(arr, mid+1, end);
    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 6, 12, 18, 19};
        System.out.println(rotationCount(arr, arr.length-1));

    }

}
