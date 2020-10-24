package fareye;

/*
    File Name : Solution2.java
    
    @author Mayank Sharma
    First Created on 19-10-2020 at 01:34
*/

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    /*
     * Complete the function below.
     * Base url: https://jsonmock.hackerrank.com/api/movies/search/?Title=
     */

    static String[] getMovieTitles(String substr) {
        int pageIndex = 1;
        int totalPagesInResponse = Integer.MAX_VALUE;
        String response;
        // Taking a dynamic Data structure to begin
        List<String> movieTitles = new ArrayList<>();
        while(pageIndex <= totalPagesInResponse) {
            try {
                URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + pageIndex);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((response = bufferedReader.readLine()) != null) {
                    JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
                    totalPagesInResponse = jsonObject.get("total_pages").getAsInt();
                    JsonArray data = jsonObject.getAsJsonArray("data");
                    for(int i = 0; i < data.size(); i++) {
                        String movieTitle = data.get(i).getAsJsonObject().get("Title").getAsString();
                        movieTitles.add(movieTitle);
                    }
                }
                bufferedReader.close();
                ++pageIndex;
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
        Collections.sort(movieTitles);
        return movieTitles.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        String[] res;
        res = getMovieTitles(bw.readLine());
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}