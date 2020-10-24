package stacks;

/*
    File Name : CelebrityProblem.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 23:15
*/

import java.util.Stack;

public class CelebrityProblem {

    // Using stack
    private static int getCelebrity(int[][] mat) {
        Stack<Integer> stack = new Stack<>();
        int n = mat.length;
        for(int i=0;i<n;i++){
            stack.push(i);
        }
        while(stack.size() > 1){
            int x = stack.pop();
            int y = stack.pop();
            if(mat[x][y]==1){
                stack.push(y);
            }else{
                stack.push(x);
            }
        }
        if(stack.isEmpty())
            return -1;
        int possibleCandidate = stack.pop();
        for(int i=0;i<n;i++){
            if(i!=possibleCandidate && (mat[possibleCandidate][i]==1 || mat[i][possibleCandidate]==0))
                return -1;
        }
        return possibleCandidate;
    }

    public static void main(String[] args) {
        int mat[][] = {
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0},
                {0,0,1,0}
        };
        System.out.println(getCelebrity(mat));
    }

}
