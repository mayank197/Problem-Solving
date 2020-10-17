package arrays.rotations;

/*
    File Name : MultipleLeftRotations.java
    
    @author Mayank Sharma
    First Created on 13-10-2020 at 17:57
*/

public class MultipleLeftRotations {

    private static void FindKthRotation(int[] arr, int[] kValues) {
        int len = arr.length;
        int newarr[] = new int[len * 2];
        for(int i=0;i<(len*2);i++){
            newarr[i] = arr[i%len];
        }
        for(int j=0;j<kValues.length;j++){
            System.out.print("\nRotation by "+kValues[j] + " : ");
            int start = kValues[j] % len;
            for(int k=start; k<start+len; k++)
                System.out.print(newarr[k] + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = {1, 3, 5, 7, 9};
        int kValues[] = {1,3,4,6};
        FindKthRotation(arr, kValues);


    }

}
