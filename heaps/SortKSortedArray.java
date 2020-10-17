package heaps;

/*
    File Name : SortNearlySortedArray.java
    
    @author Mayank Sharma
    First Created on 17-10-2020 at 12:51
*/

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class SortKSortedArray {

    // O(nk)
    private static void insertionSort(int arr[]){
        int i, j ,n = arr.length;
        for(i=1;i<n;i++){
            int key = arr[i];
            j = i-1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    // Using heap
    private static void sortUsingHeap(int arr[], int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<k+1;i++)
            priorityQueue.add(arr[i]);
        int index = 0;
        for(int i=k+1;i<arr.length;i++){
            arr[index++] = priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
        Iterator iterator = priorityQueue.iterator();
        while(iterator.hasNext()){
            arr[index++] = priorityQueue.poll();
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        // Approach 1
//        insertionSort(arr);

        // Approach 2
        sortUsingHeap(arr,k);
        Arrays.stream(arr).boxed().forEach(a -> System.out.print(a + " "));
    }

}
