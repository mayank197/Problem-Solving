package matrices;

/*
    File Name : MaximumPathSum.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 00:34
*/

public class MaximumPathSum {

    private static int maximumPathSum(int[][] mat, int rows, int cols) {
        int maximumSum = 0;
        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(j>0 && j<cols-1)
                    mat[i][j] += Math.max(mat[i-1][j-1], Math.max(mat[i-1][j], mat[i-1][j+1]));
                else if(j>0)
                    mat[i][j] += Math.max(mat[i-1][j-1], mat[i-1][j]);
                else if(j<cols-1)
                    mat[i][j] += Math.max(mat[i-1][j], mat[i-1][j+1]);
            }
        }
        // Check in last row
        for(int x=0;x<cols;x++)
            maximumSum = Math.max(mat[rows-1][x], maximumSum);
        return maximumSum;
    }

    public static void main(String[] args) {

        int mat[][] = { {10, 10, 2, 0, 20, 4},
                        {1, 0, 0, 30, 2, 5},
                        {0, 10, 4, 0, 2, 0},
                        {1, 0, 2, 20, 0, 4} };
        int rows = mat.length, cols = mat[0].length;
        System.out.println(maximumPathSum(mat, rows, cols));
    }

}
