package dynamicprogramming;

/*
    File Name : PartitionIntoSubsets.java
    
    @author Mayank Sharma
    First Created on 21-10-2020 at 15:51
*/

public class PartitionIntoSubsets {

    private static int partitionWays(int n, int k) {
        if(n==0 || k==0)
            return 0;
        if(n==k)
            return 1;
        if(n < k)
            return 0;
        int dp[][] = new int[n+1][k+1];

        return 0;
    }

    public static void main(String[] args) {
        int n = 3, k = 2;
        System.out.println(partitionWays(n,k));
    }

}
