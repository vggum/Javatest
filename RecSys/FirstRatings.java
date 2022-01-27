import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
/**
 * Write a description of class FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstRatings{
    private ArrayList<Movie> csvmethod(CSVParser parser){
    ArrayList<Movie> MovieData = new ArrayList<Movie>();
      for (CSVRecord movie: parser){
        Movie newMovie = new Movie(movie.get("id"), movie.get("title"), movie.get("year"), movie.get("genre"), movie.get("director"), movie.get("country"),
        movie.get("poster"),Integer.parseInt(movie.get("minutes")));
        MovieData.add(newMovie);
        }
    
    return MovieData;
}
    

 public ArrayList<Movie> loadMovies(String filename){
        FileResource fr = new FileResource("C:/Users/Lenovo/Downloads/ratingsdata/data/" + filename);
        CSVParser parser = fr.getCSVParser();
        ArrayList<Movie> MovieData = csvmethod(parser);
        return MovieData;
    }

 public void testLoadMovies(){
    ArrayList<Movie> mov = loadMovies("ratedmoviesfull.csv");
    System.out.println("movies: " + mov.size());
    int countComedy = 0;
    int large = 0;
    
    HashMap<String, Integer> movcount = new HashMap<String, Integer>();
    for (Movie m: mov){
    if(m.getGenres().contains("Comedy")) countComedy++;
    if(m.getMinutes()>150) large++;
    String dir = m.getDirector();
    if (!movcount.containsKey(dir)){
    movcount.put(dir,1);
    }
    else{
    int n = movcount.get(dir);
    movcount.put(dir, n+1);
    }    
    }
    System.out.println("Comedy: " + countComedy);
    System.out.println(">150 min: " + large);
     int maxMov = 0;
     for (String dir: movcount.keySet()){
        if(movcount.get(dir)>maxMov){
        maxMov = movcount.get(dir);
        }
        }
        
        System.out.println("Max movies of a single dir: " + maxMov);
        int maxMovDir = 0;
        for(String dir: movcount.keySet()){
        if(movcount.get(dir) == maxMov){
        maxMovDir++;
        }
        
        }
     System.out.println("max movie dir : " + maxMovDir + " and: " );
     for(String dir : movcount.keySet()) {
            if( movcount.get(dir) == maxMov ) System.out.println(dir);
        }
    
    
    }


 public ArrayList<Rater> loadRaters(String filename){
    FileResource fr = new FileResource("C:/Users/Lenovo/Downloads/ratingsdata/data/" + filename);
    ArrayList<Rater> list = new ArrayList<Rater>();
    CSVParser parser = fr.getCSVParser();
    for (CSVRecord rec: parser){
    String rid = rec.get("rater_id");
    boolean set = false;
    for (int i = 0; i<list.size();i++){
    if(list.get(i).getID().equals(rid)){
    Rater r = list.get(i);
    r.addRating(rec.get("movie_id"), Double.parseDouble(rec.get("rating")));
    list.set(i,r);
    set = true;
    break;
    }
    
    }
    if (!set){
    EfficientRater r = new EfficientRater(rid);
    r.addRating(rec.get("movie_id"), Double.parseDouble(rec.get("rating")));
    list.add(r);
    }
    }
    
    
    return list;
    }
    
    public void testLoadRaters() {
        
        ArrayList<Rater> rlist = loadRaters("ratings.csv");
        System.out.println("# raters: " + rlist.size());
        int maxrat = 0;
        for(Rater r : rlist) {
            //System.out.println(r.getID() + "\t" + r.getItemsRated().size() );
            //ArrayList<String> rt = r.getItemsRated();
            //for(int i = 0; i < rt.size(); i++) {
            //    System.out.println(rt.get(i) + "\t" + r.getRating(rt.get(i)));
            // }
            int id = 193;
            if(r.getID().equals("" + id)) 
                System.out.println("# of ratings by ID " + id + " is " + r.getItemsRated().size());
            if(r.getItemsRated().size() > maxrat) maxrat = r.getItemsRated().size();
        }
        System.out.println("Max # ratings: " + maxrat);
        int maxratc = 0;
        for(Rater r : rlist) {
            if(r.getItemsRated().size() == maxrat) {
                maxratc++;
                System.out.println("Raters who rated max. movies: " + r.getID());
            }
        }
        System.out.println("# having maximum ratings: " + maxratc);
        String movID = "1798709";
        int nmovr = 0;
        for(Rater r : rlist) {
            if(r.getItemsRated().contains(movID)) nmovr++;
        }
        System.out.println("# ratings for " + movID + " is: " + nmovr);
        ArrayList<String> nmovies = new ArrayList<String>();
        for(Rater r : rlist) {
            for(int i = 0; i < r.getItemsRated().size(); i++)
                if(! nmovies.contains(r.getItemsRated().get(i)) ) 
                    nmovies.add(r.getItemsRated().get(i));
        }
        System.out.println("Diff. movies rated by all raters: " + nmovies.size());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
