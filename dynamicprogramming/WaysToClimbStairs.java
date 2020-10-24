package dynamicprogramming;

/*
    File Name : WaysToClimbStairs.java
    
    @author Mayank Sharma
    First Created on 20-10-2020 at 13:08
*/

public class WaysToClimbStairs {

    private static int numberOfWays(int n){
        if(n==0 || n==1)
            return 1;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 2;
        System.out.println(numberOfWays(n));

    }

}
