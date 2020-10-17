package arrays;

/*
    File Name : ThreeLargestNumbers.java
    
    @author Mayank Sharma
    First Created on 12-10-2020 at 15:04
*/

public class ThreeLargestNumbers {

    private static void ThreeLargest(int arr[]){
        int firstLargest = arr[0], secondLargest = Integer.MIN_VALUE, thirdLargest = Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            if(arr[i] > firstLargest){
                thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = arr[i];
            }
            else if(arr[i] > secondLargest){
                secondLargest = arr[i];
                thirdLargest = secondLargest;
            }
            else if(arr[i] > thirdLargest){
                thirdLargest = arr[i];
            }
        }
        System.out.println("Largest = "+firstLargest + "\nSecond Largest = "+secondLargest +
                "\nThird Largest = "+thirdLargest);
    }

    public static void main(String[] args) {
        int arr[] = {141,1,17,-7,-17,-27,18,541,8,7,7};
        ThreeLargest(arr);
    }

}
