package fareye;

/*
    File Name : Solution.java
    
    @author Mayank Sharma
    First Created on 19-10-2020 at 00:58
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        List<String> products = Arrays.asList("yellowShirt","redHat","blackShirt","bluePants","redHat",
                "pinkHat","blackShirt","yellowShirt","greenPants","greenPants");
        Map<String, Integer> countMap = new HashMap<>();

        products.stream().forEach(p -> {
            if(countMap.containsKey(p)){
                countMap.put(p, countMap.get(p)+1);
            }else{
                countMap.put(p,1);
            }
        });

        Integer maxValue = Collections.max(countMap.values());

        List<String> filtered = new ArrayList<>();
        countMap.forEach((k,v)->{
            if(v==maxValue){
                filtered.add(k);
            }
        });

        Collections.sort(filtered, Comparator.naturalOrder());
        System.out.println(filtered.get(filtered.size()-1));

    }

}
