package stacks;

/*
    File Name : KStacksInOneArray.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 14:37
*/

import java.util.Arrays;
import java.util.stream.IntStream;

public class KStacksInOneArray {

    static class KStack {
        int arr[], top[], next[];
        int n,k;
        int freeSlot;

        public KStack(int arrSize, int k) {
            this.n = arrSize;
            this.k = k;
            this.arr = new int[n];
            this.top = new int[k];
            this.next = new int[n];
            this.freeSlot = 0;
            // Initialize the top and next arrays
            Arrays.fill(top,-1);
            IntStream.range(0,n-1).forEach(i -> {next[i] = i+1;});
            next[n-1] = -1;
        }

        boolean isFull(){ return freeSlot == -1; }

        public void push(int x, int stackNumber){
            if(isFull()){
                System.err.println("Stack is full");
                return;
            }
            int i = freeSlot;
            freeSlot = next[i];
            next[i] = top[stackNumber];
            top[stackNumber] = i;
            arr[i] = x;
        }
    }

    public static void main(String[] args) {

        KStack kStack = new KStack(10, 3);


    }

}
