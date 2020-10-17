package heaps;

/*
    File Name : HeapSort.java
    
    @author Mayank Sharma
    First Created on 17-10-2020 at 11:55
*/

import utils.SwapFunctionality;
import java.util.Arrays;

public class HeapSort {

    public static void MaxHeapify(int arr[], int n, int index){
        int leftChild = index*2 + 1;
        int rightChild = index * 2 + 2;
        int largest = index;
        if(leftChild < n && arr[leftChild] > arr[largest]){
            largest = leftChild;
        }
        if(rightChild < n && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }
        if(largest!=index){
            SwapFunctionality.swapArray(arr, index, largest);
            MaxHeapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for(int i=n/2-1;i>=0;i--){
            MaxHeapify(arr, n, i);
        }
        for(int i=n-1;i>0;i--){
            SwapFunctionality.swapArray(arr, i, 0);
            MaxHeapify(arr,  i,0);
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
        Arrays.stream(arr).boxed().forEach(a -> System.out.print(a + " "));
    }

}
