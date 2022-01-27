
/**
 * Write a description of class YearFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YearFilter implements Filter {
private int year;
	
	public YearFilter(int year) {
		this.year = year;
	}
	
	
	public boolean satisfies(String id) {
		return MovieDatabase.getYear(id) >= year;
	}
    
    
    
}
