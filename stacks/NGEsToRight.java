package stacks;

/*
    File Name : NGEsToRight.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 20:26
*/

import java.util.Stack;

public class NGEsToRight {

    private static void nextGreaterElements(int[] arr, int[] queries) {
        int n = arr.length, q = queries.length;
        int nextGreater[] = new int[n];
        nextGreater[n-1] = -1;
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for(int i=1;i<n;i++){
            if(!stk.isEmpty() && arr[i] > arr[stk.peek()]){
                while(!stk.isEmpty() && arr[i] > arr[stk.peek()]){
                    nextGreater[stk.peek()] = i;
                    stk.pop();
                }
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            nextGreater[stk.peek()] = -1;
            stk.pop();
        }
        // Fill count
        int dp[] = new int[n];
        dp[n-1] = 0;
        for(int i=n-1;i>=0;i--){
            if(nextGreater[i]==-1)
                dp[i] = 0;
            else
                dp[i] = 1 + dp[nextGreater[i]];
        }
        for(int i=0;i<q;i++){
            System.out.println("Number of NGEs for "+queries[i] + " : " +dp[queries[i]]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 7, 5, 8, 10, 6};
        // Indexes
        int queries[] = {0,5,2};
        nextGreaterElements(arr,queries);
    }

}
