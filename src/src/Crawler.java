import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Currently: open file
 * Future: Crawl the LOC Law Library for the user-inputed search words
 * @author eacrouther
 */
public class Crawler {
	String filename;
	public String search;
	//protected Object indexOfFoundLine;
	//protected Object indexOfFoundWord;

	public Crawler(String fName) {
		this.filename = fName;
	}
	/**
	 * open file
	 * @param fileName
	 */
	public File openFile() {
		File file = new File(this.filename);
		return file;
	}
	/**
	 * close file? 
	 */
	public void closeFile() {
		
	}
	public String[] getTop5Searches() {
		// TODO Auto-generated method stub
		return null;
	}
	public void saveFormatString(String searching) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<Integer> searchForPhrase(String searching) {
		return null;
		// TODO Auto-generated method stub
		
	}
	public ArrayList<Integer> searchEachWord(String searching) {
		return null;
		// TODO Auto-generated method stub
		
	}
	
	// adding main to test github actions
	public static void main(String[] args) {
		Crawler cw = new Crawler("roevwade.txt");
	}

}
