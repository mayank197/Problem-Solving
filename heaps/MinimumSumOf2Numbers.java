package heaps;

/*
    File Name : MinimumSumOf2Numbers.java
    
    @author Mayank Sharma
    First Created on 17-10-2020 at 23:33
*/

import java.util.PriorityQueue;

public class MinimumSumOf2Numbers {

    private static int minimumSum(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        while(!pq.isEmpty()){
            s1.append(String.valueOf(pq.poll()));
            if(!pq.isEmpty())
                s2.append(String.valueOf(pq.poll()));
        }
        return Integer.valueOf(s1.toString()) + Integer.valueOf(s2.toString());
    }

    public static void main(String[] args) {

        int arr[] = {6, 8, 4, 5, 2, 3};
        System.out.println("The required sum is "+ minimumSum(arr));

    }

}
