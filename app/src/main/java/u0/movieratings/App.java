/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package u0.movieratings;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.util.List; 

public class App {
    public String getGreeting() {
        return "Welcome To Movie Ratings";
    }
 
    public static void main(String[] args) throws IOException {
        System.out.println(new App().getGreeting());
        RatingReader reader = new RatingReader("movie-ratings-test.csv");
        List<Rating> rating = reader.getAllRatings();
        

        for(Rating value : rating){
            System.out.println("Movie Name: " + value.getMovieName());
            System.out.println("Movie Rater: " + value.getRaterName());
            System.out.println("Movie Rating: " + value.getRating());
            //myMap.add(value.getMovieName(), value.getRating());
        }
        
        averageRatings(rating);
    }

    public static Map <String, Integer>  averageRatings(List<Rating> rating) {
        //TODO Get average ratings
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();
        HashMap<String, Integer> averageMap = new HashMap<String, Integer>();
        

        for(Rating value: rating){ //Totalling up the ratings
            int total = 0;
            if(!myMap.containsKey(value.getMovieName())){
                myMap.put(value.movieName, value.movieRating);
            }
            else{                
                myMap.put(value.movieName, myMap.get(value.movieName) + value.movieRating);
            }
            //System.out.println(myMap.toString());
        }    
        	
        for (String s : myMap.keySet()) {
            // process each key in turn 
            averageMap.put(s, myMap.get(s)/myMap.size());           
        } 

        System.out.println(averageMap.toString());
        return averageMap;       
    }

}
