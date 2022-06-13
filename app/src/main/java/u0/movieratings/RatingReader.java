package u0.movieratings;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.units.qual.s;

public class RatingReader {
    public String filename ;
    public static int countRater;
      

    public RatingReader(String filename) {
        this.filename = filename;
       
    }

    public int getRaterCount(){
        return countRater;
    }
    

    public List<Rating> getAllRatings() throws IOException  {
        List<Rating> ratings = new ArrayList<>();

        //Read filename
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(filename);
        BufferedReader csv = new BufferedReader(new InputStreamReader(input));
        

        String line;
        int iteration = 0;
        ArrayList<String> headerLine= new ArrayList<>() ;
        ArrayList<String[]> raterLine = new ArrayList<>();
        while ( (line = csv.readLine()) != null) {
            
            //TODO: process the line
            // Get First line and put that into a headerLine ArrayList
            if(iteration == 0) {
                System.out.println("header line: " + line);
                    iteration++;
                    String[] headerArray = line.split(",");
                    for (String s : headerArray) {
                        headerLine.add(s);
                    }    
                    headerLine.remove(0) ;               
                }
                else {
                //Everthing else goes into the raterLine ArrayList
                    System.out.println("line: " + line);
                    String[] raterArray = line.split(",");
                    raterLine.add(raterArray);
                    iteration++;
                }           
        }
        csv.close();   

        // TODO create the Rating and add to list
              
        int raterIndex = 0;
            //while(headerIndex<headerLine.size() ){//Looping through HEADER MOVIE NAMES
            for(String movieName : headerLine){
                for(String[] raterName: raterLine){
                    //System.out.println(movieName+ " " + raterName[0] + " " + Integer.valueOf(raterName[raterIndex+1]));
                    
                    ratings.add(new Rating(movieName,raterName[0], Integer.valueOf(raterName[raterIndex+1])));                                       
                }
                raterIndex++;
            }
            countRater = iteration;
            //System.out.println(countRater);
        return ratings;           
    } 

   
}