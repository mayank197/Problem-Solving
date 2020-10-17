package arrays;

/*
    File Name : KthLargestElement.java
    
    @author Mayank Sharma
    First Created on 16-10-2020 at 09:36
*/

import utils.SwapFunctionality;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



class MaxHeap {
    List<Integer> heapElements;
    int heapSize;

    int Left(int index) { return 2*index + 1; }
    int Right(int index) { return 2*index + 2; }
    int Parent(int index) { return (index - 1)/2; }

    MaxHeap(int arr[]){
        heapElements = Arrays.stream(arr).boxed().collect(Collectors.toList());
        heapSize = arr.length;
        int heapIndex = (heapSize - 1)/2;
        while(heapIndex >= 0){
            MaxHeapify(heapIndex);
            heapIndex--;
        }
    }

    public int largestElement() { return heapSize==0 ? Integer.MIN_VALUE : heapElements.get(0); }

    void MaxHeapify(int index){
        int leftChild = Left(index);
        int rightChild = Right(index);
        int largest = index;
        if(leftChild < heapSize && heapElements.get(leftChild) > heapElements.get(index)){
            largest = leftChild;
        }
        if(rightChild < heapSize && heapElements.get(rightChild) > heapElements.get(largest)){
            largest = rightChild;
        }
        if(largest!=index){
            SwapFunctionality.swap(heapElements, largest, index);
            MaxHeapify(largest);
        }
    }

    // Remove max and return it
    public int extractMax(){
        if(heapSize==0){
            return Integer.MIN_VALUE;
        }
        int rootValue = heapElements.get(0);
        if(heapSize > 1){
            heapElements.set(0, heapElements.get(heapSize-1));
            MaxHeapify(0);
        }
        heapSize--;
        return rootValue;
    }

}

public class KthLargestElement {

    private static int kthLargest(int[] arr, int k) {
        MaxHeap mh = new MaxHeap(arr);
        for(int i=0;i<k-1;i++){
            mh.extractMax();
        }
        return mh.largestElement();
    }

    private static int partitionPivot(int arr[], int start, int end) {
        int x = arr[end], i = start;
        for (int j = start; j <= end - 1; j++) {
            if (arr[j] <= x) {
                // Swapping arr[i] and arr[j]
                SwapFunctionality.swapArray(arr,i,j);
                i++;
            }
        }

        // Swapping arr[i] and arr[r]
        SwapFunctionality.swapArray(arr,i,end);
        return i;
    }

    private static int kthLargestAlternative(int[] arr, int start, int end, int k) {
        if (k > 0 && k <= end - start + 1) {
            // Partition the array around last
            // element and get position of pivot
            // element in sorted array
            int pivot = partitionPivot(arr, start, end);
            System.out.println("Pivot = "+pivot);

            // If position is same as k
            if ((pivot - start) == k-1)
                return arr[pivot];

            if ((pivot - start) > k-1)
                return kthLargestAlternative(arr, pivot, end, k);

            return kthLargestAlternative(arr, start+1, pivot, (k - (end - pivot)));
        }

        // If k is more than number of elements
        // in array
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {

        int arr[] = {12, 3, 5, 7, 4, 19, 22, 11};
        int k = 3;

        System.out.println(k + "th largest : " + kthLargest(arr,k));
        System.out.println(k + "th largest : " + kthLargestAlternative(arr,0,arr.length-1,k));

    }

}
