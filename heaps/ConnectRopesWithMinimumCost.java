package heaps;

/*
    File Name : ConnectRopesWithMinimumCost.java
    
    @author Mayank Sharma
    First Created on 17-10-2020 at 13:54
*/

import java.util.PriorityQueue;

public class ConnectRopesWithMinimumCost {

    private static int minimumCost(int[] ropeLengths, int n) {
        PriorityQueue priorityQueue = new PriorityQueue<Integer>();
        for(int i=0;i<n;i++){
            priorityQueue.add(ropeLengths[i]);
        }
        int minCost = 0;
        while(priorityQueue.size()>1){
            Integer firstRope = (Integer) priorityQueue.poll();
            Integer secondRope = (Integer) priorityQueue.poll();
            minCost += (firstRope + secondRope);
            System.out.println(minCost);
            priorityQueue.add(firstRope + secondRope);
        }
        return minCost;
    }

    public static void main(String[] args) {

        int ropeLengths[] = {4,3,2,6};
        int n = ropeLengths.length;

        System.out.println(minimumCost(ropeLengths, n));

    }

}
