package stacks;

/*
    File Name : StockSpanProblem.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 15:50
*/

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    // 100, 80, 60, 70, 60, 75, 85
    private static int[] stockSpan(int arr[], int n){
        int stockSpan[] = new int[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        stockSpan[0] = 1;
        for(int i=1;i<n;i++){
            while(arr[i] > arr[stk.peek()]){
                stk.pop();
            }
            stockSpan[i] = (stk.isEmpty()) ? i+1 : i-stk.peek();
            stk.push(i);
        }
        return stockSpan;
    }

    public static void main(String[] args) {
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        int n = arr.length;
        int span[] = stockSpan(arr,n);
        Arrays.stream(span).forEach(a -> System.out.print(a + " "));
    }

}