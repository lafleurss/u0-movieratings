package u0.movieratings;

public class Rating {
    public  String movieName;
    public  String raterName;
    public  int movieRating;



    public  Rating(String movieName, String raterName, int movieRating){
        this.movieName = movieName;
        this.raterName = raterName;
        this.movieRating = movieRating;
    }

    public  String getMovieName(){
        return movieName;
    }

    public  String getRaterName(){
        return raterName;
    }

    public  int getRating(){
        return movieRating;
    }


} 
