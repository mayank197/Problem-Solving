package arrays.rotations;

/*
    File Name : MaxValueSumLeftSideRotation.java
    
    @author Mayank Sharma
    First Created on 13-10-2020 at 15:14
*/

public class MaxValueSumLeftSideRotation {

    private static int MaxValue(int[] arr, int length) {
        int maxValue = Integer.MIN_VALUE;

        int arrSum = 0, productSum = 0;

        for(int i=0;i<length;i++){
            arrSum += arr[i];
            productSum += i *arr[i];
        }

        maxValue = productSum;

        for(int j=1;j<length;j++){
            productSum = productSum + arrSum - length*arr[length-j];
            maxValue = Math.max(maxValue, productSum);
        }

        return maxValue;
    }

    public static void main(String[] args) {

        int arr[] = {1,20,2,10};
        System.out.println(MaxValue(arr,arr.length));

    }

}
