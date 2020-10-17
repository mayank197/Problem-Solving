package leetcode;

/*
    File Name : Problem221.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 03:35
*/

import java.util.Arrays;

// Maximal Square
public class Problem221 {

    private static int maxArea(char[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        char newmat[][] = new char[rows][cols];
        newmat[0] = Arrays.copyOf(mat[0], cols);
        
    }

    public static void main(String[] args) {

        char mat[][] = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };

        System.out.println(maxArea(mat));

    }

}
