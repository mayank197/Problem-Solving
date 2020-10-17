package arrays.arrangement;

/*
    File Name : RearrangeArray.java
    
    @author Mayank Sharma
    First Created on 13-10-2020 at 21:59
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Rearrange array such that arr[i] = i
public class RearrangeArray {

    private static void rearrange(int arr[], int len){
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(a -> set.add(a));

        for(int i=0;i<len;i++){
            arr[i] = (set.contains(i)) ? i : -1;
        }
    }

    public static void main(String[] args) {

        int arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        rearrange(arr, arr.length);
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

    }

}
