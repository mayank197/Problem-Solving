package dynamicprogramming;

/*
    File Name : CoinChange.java
    
    @author Mayank Sharma
    First Created on 21-10-2020 at 00:26
*/

public class CoinChange {

    // Permutations
    private static int coinChangePermutations(int[] coins, int sum) {
        int len = coins.length;
        int dp[] = new int[sum+1];
        dp[0] = 1;
        for(int i=1;i<=sum;i++){
            for(int coin:coins){
                if(coin <= i){
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[sum];
    }

    // Ways
    private static int coinChangeWays(int[] coins, int sum) {
        int len = coins.length;
        int dp[] = new int[sum+1];
        dp[0] = 1;
        for(int i=0;i<len;i++){
            for(int j=coins[i];j<=sum;j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {

        int coins[] = {2,3,5,6};
        int sum = 10;

        System.out.println(coinChangeWays(coins, sum));
        System.out.println(coinChangePermutations(coins, sum));

    }

}
