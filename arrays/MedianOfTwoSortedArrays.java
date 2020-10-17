package arrays;

/*
    File Name : MedianOfTwoSortedArrays.java
    
    @author Mayank Sharma
    First Created on 12-10-2020 at 21:36
*/

public class MedianOfTwoSortedArrays {

    private static int getMedian(int arr[], int start, int end){
        int len = (end-start+1);
        if(len%2==0)
            return (arr[start + len/2] + arr[start + (len/2-1)])/2;
        return arr[start + len/2];
    }

    // Same Size
    private static int medianOfArrays(int[] arr1, int[] arr2, int startA, int endA, int startB, int endB) {
        int n1 = (endA - startA + 1), n2 = (endB - startB + 1);

        // Array of size 2 is left
        if(endA - startA == 1){
            return (Math.max(arr1[startA], arr2[startB]) + Math.min(arr1[endA], arr2[endB]))/2;
        }

        int med1 = getMedian(arr1, startA, endA);
        int med2 = getMedian(arr2, startB, endB);

        // If both medians are same, return it
        if(med1==med2){
            return med1;
        }
        else if(med1 > med2){
            return medianOfArrays(arr1, arr2, startA,(startA + endA + 1)/2,
                    (startB + endB + 1)/2, endB);
        }
        else{
            return medianOfArrays(arr1, arr2, (startA + endA + 1)/2, endA,
                    startB, (startB + endB + 1)/2);
        }
    }

    public static void main(String[] args) {

        int arr1[] = {1,12,15,26,38}, arr2[] = {2,13,17,30,45};

        System.out.println(medianOfArrays(arr1,arr2,0,arr1.length-1, 0,arr2.length-1));

    }

}
