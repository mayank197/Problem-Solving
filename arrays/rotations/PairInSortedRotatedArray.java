package arrays.rotations;

/*
    File Name : PairInSortedRotatedArray.java
    
    @author Mayank Sharma
    First Created on 13-10-2020 at 14:15
*/

public class PairInSortedRotatedArray {

    // 11, 15, 6, 8, 9, 10
    private static int Pivot(int[] arr, int start, int end) {
        if(start > end)
            return -1;
        int mid = start + (end-start)/2;
        if(arr[mid-1] > arr[mid])
            return mid-1;
        if(arr[mid] > arr[mid+1])
            return mid;
        // Means first half is sorted
        if(arr[start] <= arr[mid])
            return Pivot(arr, mid+1, end);
        return Pivot(arr, start, mid);
    }

    // 11, 15, 6, 8, 9, 10
    private static boolean searchPair(int[] arr, int sum) {
        int n = arr.length;
        // Find Pivot - Returns 1 (index of 15)
        int pivot = Pivot(arr, 0, n-1);
        int smallElementIndex = (pivot+1)%n;
        int largeElementIndex = pivot;

        while(smallElementIndex != largeElementIndex) {

            if(arr[smallElementIndex] + arr[largeElementIndex]==sum){
                return true;
            }
            else if(arr[smallElementIndex] + arr[largeElementIndex] > sum){
                // Reduce the large element index
                largeElementIndex = (largeElementIndex - 1 + n)%n;
            }
            else{
                smallElementIndex = (smallElementIndex + 1)%n;
            }

        }
        return false;
    }

    // Count all pairs
    private static boolean countPairs(int[] arr, int sum) {
        int n = arr.length;
        // Find Pivot - Returns 1 (index of 15)
        int pivot = Pivot(arr, 0, n-1);
        int smallElementIndex = (pivot+1)%n;
        int largeElementIndex = pivot;

        while(smallElementIndex != largeElementIndex) {

            if(arr[smallElementIndex] + arr[largeElementIndex]==sum){
                return true;
            }
            else if(arr[smallElementIndex] + arr[largeElementIndex] > sum){
                // Reduce the large element index
                largeElementIndex = (largeElementIndex - 1 + n)%n;
            }
            else{
                smallElementIndex = (smallElementIndex + 1)%n;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {11, 15, 6, 8, 9, 10};
        int sum = 21;
        System.out.println(searchPair(arr, sum));

    }

}
