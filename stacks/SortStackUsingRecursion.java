package stacks;

/*
    File Name : SortStackUsingRecursion.java
    
    @author Mayank Sharma
    First Created on 19-10-2020 at 23:09
*/

import java.util.Stack;
import java.util.stream.IntStream;

public class SortStackUsingRecursion {

    private static void pushToStack(Stack<Integer> stack, int x) {
        if(stack.isEmpty() || x > stack.peek())
            stack.push(x);
        else{
            int top = stack.pop();
            pushToStack(stack, x);
            stack.push(top);
        }
    }

    private static void sortStack(Stack<Integer> stack) {
        if(!stack.isEmpty()){
            int topEle = stack.pop();
            sortStack(stack);
            pushToStack(stack,topEle);
        }
    }

    public static void main(String[] args) {

        int arr[] = {30,-5,18,14,-3};
        Stack<Integer> stack = new Stack<>();
        IntStream.range(0, arr.length).forEach(i -> stack.add(arr[i]));

        sortStack(stack);
        while(!stack.isEmpty()){ System.out.print(stack.pop() + " "); }

    }

}
