package strings;

/*
    File Name : LongestPalindromicSubstring.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 18:31
*/

public class LongestPalindromicSubstring {

    // Approach 1 - Using DP
    private static int longestPalindromicSubstr(String str) {
        int len = str.length();
        int longestPalindromeLength = 0;
        String longestSubstring = "";
        boolean dp[][] = new boolean[len][len];
        for(int col=0;col<len;col++){
            for(int row=0;row<=col;row++){
                if(row==col){
                    dp[row][col] = true;
                }else if((col-row)==1){
                    dp[row][col] = (str.charAt(row)==str.charAt(col));
                }else{
                    dp[row][col] = (str.charAt(row)==str.charAt(col) && dp[row+1][col-1]==true);
                }
                if(dp[row][col]==true) {
                    if((col-row+1) > longestPalindromeLength){
                        longestPalindromeLength = (col-row+1);
                        longestSubstring = str.substring(row, col+1);
                    }
                }
            }
        }
        System.out.println("Longest Palindromic Substring : "+longestSubstring + " of length ");
        return longestPalindromeLength;
    }

    // Approach 2
    private static int LongestPalindromicSubstr2(String str){
        if(str.isEmpty())
            return 0;
        int maxLength = 1;
        int startIndex = 0, low, high;
        int len = str.length();
        for(int i=1;i<len;i++){
            // Odd Length
            low = i-1;
            high = i;
            while(low>=0 && high<len && str.charAt(low)==str.charAt(high)){
                if((high-low+1) > maxLength){
                    maxLength = high - low + 1;
                    startIndex = low;
                }
                --low; ++high;
            }
            // Even Length
            low = i-1;
            high = i+1;
            while(low>=0 && high<len && str.charAt(low)==str.charAt(high)){
                if((high - low + 1) > maxLength) {
                    maxLength = high - low + 1;
                    startIndex = low;
                }
                --low; ++high;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abccbc";
        System.out.println(longestPalindromicSubstr(str));
        System.out.println(LongestPalindromicSubstr2(str));

    }

}
