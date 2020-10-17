package arrays;

/*
    File Name : MedianSortedArraysDiffSize.java
    
    @author Mayank Sharma
    First Created on 12-10-2020 at 23:32
*/

public class MedianSortedArraysDiffSize {

    // Median of arrays of different sizes
    private static double medianOfArrays(int[] arr1,int[] arr2,int len1, int len2) {
        // Swap arrays if arr1 is larger than arr2
        if(len1 > len2){
            return medianOfArrays(arr2, arr1, len2, len1);
        }

        int i = 0, j = len1;
        while(i <= j){

            // If partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            // If partitionX is length of input then there is nothing on right side. Use +INF for minRightX

            int partitionX = (i+j)/2;
            int partitionY = (len1 + len2 + 1)/2 - partitionX;

            int maxLeftX = (partitionX==0) ? Integer.MIN_VALUE : arr1[partitionX-1];
            int minRightX = (partitionX==len1) ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = (partitionY==0) ? Integer.MIN_VALUE : arr2[partitionY-1];
            int minRightY = (partitionY==len2) ? Integer.MAX_VALUE : arr2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((len1+len2)%2==0){
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                }
                else{
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }
            else if(maxLeftX > minRightY){
                j = partitionX - 1;
            }
            else{
                i = partitionX + 1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {

        int arr1[] = {2,3,5,8}, arr2[] = {10,12,14,16,18,20};

        System.out.println(medianOfArrays(arr1,arr2,arr1.length, arr2.length));

    }

}
