package leetcode;

/*
    File Name : SearchRotatedSortedArray.java
    
    @author Mayank Sharma
    First Created on 18-10-2020 at 12:32
*/

public class Problem81 {

    public static void main(String[] args) {

        int arr[] = {1,3,1,1,1};
        int x = 3;

        System.out.println(search(arr,x));
    }

    private static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start <= end) {
            int mid=start+(end-start)/2;
            if(nums[mid]==target)
                return true;
            // First half is sorted
            if(nums[start] < nums[mid]) {
                if(nums[start]<=target && target<nums[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else if(nums[start]>nums[mid]) {
                if(target>nums[mid] && target<=nums[end]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
            else {
                start++;
            }
        }
        return false;
    }


}
