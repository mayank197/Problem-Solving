package arrays.rotations;

/*
    File Name : MaxValueRightSideRotation.java
    
    @author Mayank Sharma
    First Created on 13-10-2020 at 17:11
*/

public class MaxValueRightSideRotation {

    private static int MaxValue(int arr[], int len){
        int maxValue = Integer.MIN_VALUE;

        int arrSum = 0, productSum = 0;

        for(int i=0;i<len;i++){
            arrSum += arr[i];
            productSum += i*arr[i];
        }

        maxValue = productSum;

        for(int j=1;j<len;j++){
            productSum = (productSum - arrSum) + len * arr[j-1];
            maxValue = Math.max(productSum, maxValue);
        }

        return maxValue;
    }

    public static void main(String[] args) {

        int arr[] = {8,3,1,2};
        System.out.println(MaxValue(arr, arr.length));

    }

}
