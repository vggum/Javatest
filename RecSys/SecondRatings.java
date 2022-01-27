import java.util.*;
import edu.duke.*;
/**
 * Write a description of class SecondRating here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondRatings {

    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    private HashMap<String, ArrayList<Rating>> loadRaters;
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
  public SecondRatings(String moviefile,String ratingsfile){
        FirstRatings fR=new FirstRatings();
        myMovies=fR.loadMovies(moviefile);
        myRaters=fR.loadRaters(ratingsfile);
    }
    
    public int getMovieSize(){
        return myMovies.size();
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
        for(Movie m : myMovies) {
            String id = m.getID();
            double avgr =  getAverageByID(id,minimalRaters);
            if(avgr != 0.0) {
                Rating r = new Rating(id,avgr);
                ar.add(r);
            }
        }
        return ar;
    }
    
    
    public String getTitle(String id){
   
    for (Movie m: myMovies){
    if (id.equals(m.getID())){
    return m.getTitle();
    }
    
    }
    
    return "Movie ID not found";
    }
    
    public String getID(String title){
    for(Movie m: myMovies){
    if (title.equals(m.getTitle())){
    return m.getID();
    }
    
    }
    
    return "NO SUCH TITLE";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    

