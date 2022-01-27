import java.util.*;
import edu.duke.*;
/**
 * Write a description of class MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerWithFilters {
    
    public void  printAverageRatings() {
        ThirdRatings tr = new ThirdRatings("ratings.csv");
        int tt = tr.getRaterSize();
        System.out.println("# of raters: " + tt);
        MovieDatabase.initialize("ratedmoviesfull.csv");
        int movsize = MovieDatabase.size();
        System.out.println("count of movies = " + movsize);
        ArrayList<Rating> ar = tr.getAverageRatings(35);
        Collections.sort(ar);
        System.out.println("Size = " + ar.size());
        for(Rating r : ar) {
            System.out.println(r.getValue() + "\t" + MovieDatabase.getTitle(r.getItem()));
            break;
        }

}


   public void printAverageRatingsByGenre(){
      ThirdRatings trat = new ThirdRatings("ratings.csv");
      System.out.println("read data for " + trat.getRaterSize() + " raters");
      MovieDatabase.initialize("ratedmoviesfull.csv");
      System.out.println("read data for " + MovieDatabase.size() + " movies");
      GenreFilter genf = new GenreFilter("Comedy");
      ArrayList<Rating> ar = trat.getAverageRatingsByFilter(20, genf);
      System.out.println("count movies of genre: " + ar.size());
      Collections.sort(ar);
      for(Rating r : ar) {
            System.out.println(r.getValue() + "\t" + MovieDatabase.getTitle(r.getItem())
                               + "\n\t" + MovieDatabase.getGenres(r.getItem()));
                               
        }

    
    }

    public void printAverageRatingsByMinutes(){
    ThirdRatings trat = new ThirdRatings("ratings.csv");
      System.out.println("read data for " + trat.getRaterSize() + " raters");
      MovieDatabase.initialize("ratedmoviesfull.csv");
      System.out.println("read data for " + MovieDatabase.size() + " movies");
      MinutesFilter minf = new MinutesFilter(105,135);
      ArrayList<Rating> ar = trat.getAverageRatingsByFilter(5, minf);
      System.out.println("count movies of minutes: " + ar.size());
      Collections.sort(ar);
      for(Rating r : ar) {
            System.out.println(r.getValue() + "\t" + MovieDatabase.getMinutes(r.getItem())
                               + "\n\t" + MovieDatabase.getTitle(r.getItem()));
                               
        }

    }
    
    public void printAverageRatingsByDirectors(){
    ThirdRatings trat = new ThirdRatings("ratings.csv");
      System.out.println("read data for " + trat.getRaterSize() + " raters");
      MovieDatabase.initialize("ratedmoviesfull.csv");
      System.out.println("read data for " + MovieDatabase.size() + " movies");
      DirectorFilter dirf = new DirectorFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
      ArrayList<Rating> ar = trat.getAverageRatingsByFilter(4, dirf);
      System.out.println("count movies of director filter: " + ar.size());
      Collections.sort(ar);
      for(Rating r : ar) {
            System.out.println(r.getValue() + "\t" + MovieDatabase.getTitle(r.getItem())
                               + "\n\t" + MovieDatabase.getDirector(r.getItem()));
                               
        }
    
    }
    
    
    public void printAverageRatingsByYearAfterAndGenre(){
    ThirdRatings tr = new ThirdRatings("ratings.csv");
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        YearFilter yf = new YearFilter(1990);
        GenreFilter gf = new GenreFilter("Drama");
        AllFilters af = new AllFilters();
        af.addFilter(yf);
        af.addFilter(gf);
        ArrayList<Rating> ar = tr.getAverageRatingsByFilter(8, af);
        System.out.println("found " + ar.size());
        Collections.sort(ar);
        for(Rating r : ar) {
            System.out.println(r.getValue() + "\t" + MovieDatabase.getYear(r.getItem())
                               + "\t" + MovieDatabase.getTitle(r.getItem()) + "\n\t"
                               + MovieDatabase.getGenres(r.getItem()));
                               
        }
    
   
    
    }
    
    public void printAverageRatingsByDirectorsAndMinutes() {
        ThirdRatings tr = new ThirdRatings("ratings.csv");
        System.out.println("read data for " + tr.getRaterSize() + " raters");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        DirectorFilter df = new DirectorFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack");
        MinutesFilter mf = new MinutesFilter(90, 180);
        AllFilters af = new AllFilters();
        af.addFilter(df);
        af.addFilter(mf);
        ArrayList<Rating> ar = tr.getAverageRatingsByFilter(3, af);
        System.out.println("found " + ar.size() + " movies");
        Collections.sort(ar);
        for(Rating r : ar) {
            System.out.println(r.getValue() + "\t" + MovieDatabase.getMinutes(r.getItem()) + " min"
                               + "\t" + MovieDatabase.getTitle(r.getItem())
                               + "\n\t" + MovieDatabase.getDirector(r.getItem()));
                               
        }
    }
    
    
    
}