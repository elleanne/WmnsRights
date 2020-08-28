import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Crawl the LOC Law Library for the user-inputed search words
 */
public class Crawler {
	
	/**
	 * open file
	 * @param fileName
	 */
	public File openFile(String fileName) {
		File file = new File(fileName);
		
		return file;
	}
	
	public void closeFile() {
		
	}
}
