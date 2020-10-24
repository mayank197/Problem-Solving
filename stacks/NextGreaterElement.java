package stacks;

/*
    File Name : NextGreaterElement.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 20:04
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

public class NextGreaterElement {

    private static void nextGreater(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        IntStream.range(0,n).forEach(i -> indexMap.put(arr[i],i));
        int nextGr[] = new int[n];
        nextGr[n-1] = -1;
        stack.push(arr[0]);

        for(int i=1;i<n;i++){
            if(!stack.isEmpty() && arr[i] > stack.peek()){
                while(!stack.isEmpty() && arr[i] > stack.peek()){
                    nextGr[indexMap.get(stack.peek())] = arr[i];
                    stack.pop();
                }
            }
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            nextGr[indexMap.get(stack.peek())] = -1;
            stack.pop();
        }
        Arrays.stream(nextGr).boxed().forEach(a -> System.out.print(a + " "));
    }

    public static void main(String[] args) {

        int arr[] = {4,5,2,25,19,22,29};
        nextGreater(arr,arr.length);

    }

}
