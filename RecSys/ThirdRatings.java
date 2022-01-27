import java.util.*;
import edu.duke.*;
/**
 * Write a description of class ThirdRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThirdRatings {
    private ArrayList<Rater> myRaters;
  
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    
  public ThirdRatings(String ratingsfile){
        FirstRatings fR=new FirstRatings();
        myRaters=fR.loadRaters(ratingsfile);
    }
    
   

    public int getRaterSize(){
        return myRaters.size();
    }

    public void print(){
        System.out.println(myRaters);
    }

    public double getAverageByID(String movie_id, Integer minRaters){
    double numOfRat = 0.0;
    double sum = 0.0;
    for (Rater rater: myRaters){
    if (rater.hasRating(movie_id)){
    numOfRat++;    
    }
    }
    if(numOfRat>=minRaters){
    for(Rater rater:myRaters){
                if(rater.hasRating(movie_id)){
                    sum+=rater.getRating(movie_id);
                }
            }
            double ave=sum/numOfRat;
            return ave;
        }
        else{
            return 0.0;
        }
    
    
    }
    
   public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> ar = new ArrayList<Rating>();
         ArrayList<String> myMovies = MovieDatabase.filterBy(new TrueFilter());
         Rating rat= new Rating("",0.0);
        for(String movieId: myMovies) {
         if (getAverageByID(movieId,minimalRaters)!=0){
            rat = new Rating(movieId,getAverageByID(movieId,minimalRaters)); 
            ar.add(rat);
            } 
    }
    Collections.sort(ar);
    return ar;
    
}
    
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCinema){
    ArrayList<String> movies = MovieDatabase.filterBy(filterCinema);
    ArrayList<Rating> ar = new ArrayList<Rating>();
    for (String id: movies){
     double avg =  getAverageByID(id,minimalRaters);
            if(avg != 0.0) {
                Rating r = new Rating(id,avg);
                ar.add(r);
            }
        }
        return ar;
    
    
    }
    
    
    
    }
    
    
    


