package heaps;

/*
    File Name : MergeKSortedArrays.java
    
    @author Mayank Sharma
    First Created on 22-10-2020 at 02:28
*/

import java.util.Arrays;

class MinHeapNode{
    int element;
    int arrayIndex;
    int nextElementIndex;

    public MinHeapNode(int element, int arrayIndex, int nextElementIndex) {
        this.element = element;
        this.arrayIndex = arrayIndex;
        this.nextElementIndex = nextElementIndex;
    }
}

class MinHeap{
    MinHeapNode heapElements[];
    int heapSize;

    public MinHeap(MinHeapNode[] arr, int size) {
        this.heapElements = arr;
        heapSize = size;
        int index = (heapSize-1)/2;
        while(index >= 0){
            MinHeapify(index--);
        }
    }

    MinHeapNode getMin(){
        return heapElements[0];
    }

    int Left(int index){ return 2*index + 1; }
    int Right(int index) { return 2*index + 2; }

    void MinHeapify(int index) {
        int left = Left(index);
        int right = Right(index);
        int smallest = index;

        if(left < heapSize && heapElements[left].element < heapElements[smallest].element)
            smallest = left;
        if(right < smallest && heapElements[right].element < heapElements[smallest].element)
            smallest = right;

        if(smallest!=index){
            swapHeapElements(heapElements, smallest, index);
            MinHeapify(smallest);
        }
    }

    void replaceMin(MinHeapNode root) {
        heapElements[0] = root;
        MinHeapify(0);
    }

    private void swapHeapElements(MinHeapNode[] heapElements, int smallest, int index) {
        MinHeapNode temp = heapElements[smallest];
        heapElements[smallest] = heapElements[index];
        heapElements[index] = temp;
    }
}

public class MergeKSortedArrays {

    private static void mergeKSorted(int[][] arr, int k) {
        MinHeapNode heapArr[] = new MinHeapNode[k];
        int totalNodes = 0;
        for(int i=0;i<k;i++){
            MinHeapNode minHeapNode = new MinHeapNode(arr[i][0], i, 1);
            heapArr[i] = minHeapNode;
            totalNodes += arr[i].length;
        }

        MinHeap minHeap = new MinHeap(heapArr, k);
        int sortedArray[] = new int[totalNodes];
        for(int i=0;i<totalNodes;i++){

            MinHeapNode minHeapNode = minHeap.getMin();
            sortedArray[i] = minHeapNode.element;

            if(minHeapNode.nextElementIndex < arr[minHeapNode.arrayIndex].length)
                minHeapNode.element = arr[minHeapNode.arrayIndex][minHeapNode.nextElementIndex++];
            else
                minHeapNode.element = Integer.MAX_VALUE;

            minHeap.replaceMin(minHeapNode);
        }

        Arrays.stream(sortedArray).forEach(a-> System.out.print(a + " "));

    }

    public static void main(String[] args) {
        int[][] arr= { {2, 6, 12, 34},
                       {1, 9, 20, 1000},
                       {23, 34, 90, 2000} };
        mergeKSorted(arr, arr.length);
    }

}
