package leetcode;

/*
    File Name : Problem221.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 03:35
*/

import java.util.Arrays;

// Maximal Square
public class Problem221 {

    private static int maxArea(char[][] matrix) {
        if(matrix==null || matrix[0]==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int newmat[][] = new int[rows][cols];

        int maxValue = 0;

        for(int x=0;x<rows;x++){
            newmat[x][0] = matrix[x][0] - '0';
            maxValue = Math.max(maxValue, newmat[x][0]);
        }
        for(int y=0;y<cols;y++){
            newmat[0][y] = matrix[0][y] - '0';
            maxValue = Math.max(maxValue, newmat[0][y]);
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(matrix[i][j] == '1'){
                    newmat[i][j] += 1 + Math.min(newmat[i-1][j], Math.min(newmat[i-1][j-1] , newmat[i][j-1]));
                    maxValue = Math.max(maxValue, newmat[i][j]);
                }else{
                    newmat[i][j] = 0;
                }
            }
        }
        return maxValue*maxValue;
    }

    public static void main(String[] args) {

        char mat[][] = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        System.out.println(maxArea(mat));

    }

}
