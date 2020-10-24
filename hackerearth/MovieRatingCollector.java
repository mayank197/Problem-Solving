package hackerearth;

/*
    File Name : MovieRatingCollector.java
    
    @author Mayank Sharma
    First Created on 22-10-2020 at 00:20
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

interface RatingCollector{
    public void putNewRating(String movie, double rating);
    public double getAverageRating(String movie);
    public int getRatingCount(String movie);
}

class Pair{
    private Integer count;
    private Double sum;

    Pair(Integer x, Double y){
        this.count = x;
        this.sum = y;
    }

    public Integer getCount(){
        return count;
    }

    public Double getSum(){
        return sum;
    }

    public void setCount(Integer count){
        this.count = count;
    }

    public void setSum(Double sum){
        this.sum = sum;
    }
}

public class MovieRatingCollector {

    static Map<String, Pair> countMap = new HashMap<>();

    public static class RatingCollectorImpl implements RatingCollector {
        @Override
        public void putNewRating(String movie, double rating) {
            Pair pair = null;
            if(countMap.containsKey(movie)){
                pair = countMap.get(movie);
                pair.setCount(pair.getCount()+1);
                pair.setSum(pair.getSum()+rating);
            }else{
                pair = new Pair(1, rating);
            }
            countMap.put(movie, pair);
        }

        @Override
        public double getAverageRating(String movie) {
            Pair pair = countMap.get(movie);
            return pair.getSum()/pair.getCount();
        }

        @Override
        public int getRatingCount(String movie) {
            Pair pair = countMap.get(movie);
            return pair.getCount();
        }
    }

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(bufferedReader.readLine());

        for(int i=0;i<n;i++){
            String[] input = bufferedReader.readLine().split(",");
            String movie = input[0];
            Double rating = Double.valueOf(input[1]);
            MovieRatingCollector.RatingCollectorImpl ratingCollector = new RatingCollectorImpl();
            ratingCollector.putNewRating(movie, rating);
        }

        MovieRatingCollector.countMap.entrySet().stream().sorted(
                new Comparator<Map.Entry<String, Pair>>() {
                    @Override
                    public int compare(Map.Entry<String, Pair> o1, Map.Entry<String, Pair> o2) {
                        return (int)(o2.getValue().getSum()/o2.getValue().getCount()) -
                                (int)(o1.getValue().getSum()/o1.getValue().getCount());
                    }
                });

        countMap.forEach((k,v)->{
            System.out.println(k + "," +(v.getSum()/v.getCount()));
        });

    }

}
