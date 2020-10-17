package heaps;

/*
    File Name : KthLargestInAStream.java
    
    @author Mayank Sharma
    First Created on 17-10-2020 at 20:40
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class KthLargestInAStream {

    private static void kthLargest(int k) throws IOException {
        int count = 0;
        int arr[] = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>();     // Min Heap
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Enter next element (Press N to exit) : ");
            String input = bufferedReader.readLine();
            if(input.compareTo("N")==0){
                break;
            }
            Integer x = Integer.parseInt(input);
            if(count < k-1){
                arr[count++] = x;
            }else{
                if(count == k-1){
                    arr[count] = x;
                    IntStream.rangeClosed(0,count).forEach(i -> pq.add(arr[i]));
                }
                else{
                    if(x > pq.peek()){
                        pq.poll();
                        pq.add(x);
                    }
                }
                System.out.println(k + "th largest element : " +pq.peek());
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int k = 3;
        kthLargest(k);

    }

}
