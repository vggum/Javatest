
/**
 * Write a description of class DirectorFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorFilter implements Filter {

    private String myDirectors;
    
    public DirectorFilter(String directors) {
		myDirectors = directors;
	}
	
	
	public boolean satisfies(String id) {
	    String directorArray[] = myDirectors.split(",");
	    for(String director : directorArray) {
	        if(MovieDatabase.getDirector(id).contains(director)) return true;
	    }
	    return false;
	}
    
    
    
}
