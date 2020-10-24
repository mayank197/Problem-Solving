package strings;

/*
    File Name : LongestPalindromicSubstring.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 17:03
*/

public class CountPalindromicSubstrings {

    private static int totalPalindromicSubstr(String str) {
        int len = str.length();
        int totalPalindromes = 0;

        // dp[i][j] -> true if substring(i,j) is palindrome
        boolean dp[][] = new boolean[len][len];
        // Traverse diagonal wise
        // Traverse each column
        for(int j=0;j<len;j++){
            for(int i=0;i<=j;i++){
                if(i==j){
                    dp[i][j] = true;
                }else if((j-i)==1){
                    if(str.charAt(i)==str.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j]==true){
                    totalPalindromes++;
                }
            }
        }
        return totalPalindromes;
    }

    public static void main(String[] args) {

        String str = "abccbc";
        System.out.println(totalPalindromicSubstr(str));

    }

}
