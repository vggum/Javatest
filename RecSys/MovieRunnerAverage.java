import java.util.*;
import edu.duke.*;
/**
 * Write a description of class MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerAverage {
 
   
      public void  printAverageRatings() {
        SecondRatings sr = new SecondRatings();
        System.out.println("# of movies: " + sr.getMovieSize());
        System.out.println("# of raters: " + sr.getRaterSize());
        ArrayList<Rating> ar = sr.getAverageRatings(20);
        Collections.sort(ar);
        System.out.println("Size = " + ar.size());
        for(Rating r : ar) {
            System.out.println(r.getValue() + "\t" + sr.getTitle(r.getItem()));
            break;
        }
    }
   
   
    public void getAverageRatingOneMovie(){
        SecondRatings MoviesAndRatings = new SecondRatings("ratedmoviesfull.csv", "ratings.csv");
        String movieRequest = "No Country for Old Men";
        String id = MoviesAndRatings.getID(movieRequest);
        if(id.equals("NO SUCH TITLE.")){
            System.out.println(id);
        }
        else{
        double aveRating = MoviesAndRatings.getAverageByID(id,1);
        System.out.println("The average rating for the movie " + movieRequest + " is " + aveRating);
        }
    }
}
