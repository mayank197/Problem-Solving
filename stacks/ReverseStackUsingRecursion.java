package stacks;

/*
    File Name : ReverseStackUsingRecursion.java
    
    @author Mayank Sharma
    First Created on 19-10-2020 at 04:00
*/

import java.util.Arrays;
import java.util.Stack;

public class ReverseStackUsingRecursion {

    private static void addToStack(Stack<Integer> stack, Integer x) {
        if(stack.isEmpty())
            stack.push(x);
        else{
            Integer topEle = stack.pop();
            addToStack(stack, x);
            stack.push(topEle);
        }
    }

    private static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty())
            return;
        Integer topEle = stack.peek();
        stack.pop();
        reverseStack(stack);
        addToStack(stack, topEle);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(1,2,3,4));
        reverseStack(stack);
        System.out.print("\nReversed Stack Contents : ");
        while(!stack.isEmpty()){ System.out.print(stack.pop() + " "); }
    }

}
