package heaps;

/*
    File Name : MedianRunningNumbersStream.java
    
    @author Mayank Sharma
    First Created on 17-10-2020 at 18:04
*/

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianRunningNumbersStream {

    private static void median(int[] arr) {
        double median = arr[0];
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> greater = new PriorityQueue<>();
        smaller.add(arr[0]);
        System.out.println(median);

        for(int i=1;i<arr.length;i++){
            int x = arr[i];
            if(smaller.size() > greater.size()){
                if(x > median){
                    greater.add(x);
                }else{
                    greater.add(smaller.remove());
                    smaller.add(x);
                }
                median = (double)(smaller.peek() + greater.peek())/2;
            }
            else if(smaller.size() == greater.size()){
                if(x > median){
                    greater.add(x);
                    median = (double) greater.peek();
                }else{
                    smaller.add(x);
                    median = (double) smaller.peek();
                }
            }
            else{
                if(x > median){
                    smaller.add(greater.remove());
                    greater.add(x);
                } else{
                    smaller.add(x);
                }
                median = (double) (smaller.peek() + greater.peek())/2;
            }
            System.out.println(median);
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 15, 10, 20, 3};
        median(arr);

    }

}
