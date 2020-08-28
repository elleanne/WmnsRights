import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Store results of the user search into categories: Law, Case Law, Articles
 * Allow user to save results to a download-able file
 */
public class ResultsFound {
	HashMap<Integer, String> allSearches = new HashMap<>();
	HashMap<Integer, Integer> timesSearched = new HashMap<>();
	static int numberOfKeys = 0;
	String search ;
	ArrayList<String> foundMatch = new ArrayList<>();
	ArrayList<Integer> indexOfFound = new ArrayList<>();
	
	public ResultsFound() {
		
	}

	/**
	 * Add the current string searched to the HAshMap, to keep a record of searched
	 * strings and the number of times they were searched
	 * @param searching
	 */
	public void addSearch(String searching) {
		search = searching ;
		int noStringFound = 0;
		if (searching.isEmpty()) System.err.println("Please enter a value to search");

		for (int i = 0; i < allSearches.size(); i++) {
			if (allSearches.get(i).equals(searching)) {
				int addCount = timesSearched.get(i);
				addCount++;
				timesSearched.put(i, addCount);
				noStringFound = 1;
			}
		}
		if ((allSearches.size() == 0) || (noStringFound == 0)) {
			allSearches.put(numberOfKeys, searching);
			timesSearched.put(numberOfKeys, 1);
			numberOfKeys++;
		}
	}

	/**
	 * Find the top five searches save them to an Array
	 * @return String[]
	 */
	public String[] getTop5Searches() {
		String[] topSearches = {"abortion", "sexual harassment", "birth control", "workplace discrimination", "labor and delivery"};
		Integer[] keysToSearches = new Integer[5];

		if (timesSearched.size() <= 5) {
			for (int i = 0; i < timesSearched.size(); i++) {
				topSearches[i] = allSearches.get(i);
			}
		} else {
			for (int i = 0; i < timesSearched.size(); i++) {
				int tempCount = timesSearched.get(i);
				for (int j = 0; j < 5; j++) {
					if (tempCount > timesSearched.get(keysToSearches[j])) {
						keysToSearches[j] = i;
					}
				}
			}
			for (int i = 0; i < 5; i++) {
				topSearches[i] = allSearches.get(keysToSearches[i]);
			}
		}
		return topSearches;
	}
	
	/**
	 * Separate the user enetered string
	 * @return String[]
	 */
	public String[] sepSearchString(String searchStr) {
		if(searchStr == null) {System.err.println("no string to split in sepSerachString()"); return null;}
		String[] splited = searchStr.split(" ");
		
		for (int i = 0; i < splited.length; i++) {
			String split = splited[i];
			split = split.toLowerCase();
			split = split.replaceAll("\\p{Punct}", "");
			splited[i] = split ;
		}
		return splited ;
	}
	
	/**
	 * Check the current word to every word in the search string
	 * if the wordInFile is found in the search string, return the number of times it is found
	 * @param wordInFile
	 * @return int
	 */
	public int findWord(String wordInFile) {
		int foundAMatch = 0;
		String[] splited = sepSearchString(search);
		if(splited == null) {System.err.println("no string to split in sepSerachString()"); return -1;}

		for(String string : splited) {
			if(string.equals(wordInFile)) {
				System.out.println(string);
				foundAMatch++;
			}
		}
		return foundAMatch ;
	}
	
	
	public void gatherResults(String searchS ) {
		int charNum = 0;
		try {
			Crawler crawl = new Crawler();
			File file = crawl.openFile("roeVwade.txt");
			Scanner scanFile = new Scanner(file);
			if(searchS != null) {
				addSearch(searchS);
				getTop5Searches();
				//sepSearchString(searchS);
			}
			while(scanFile.hasNext()) {
				String nextL = scanFile.next();
				//System.out.println(nextL);
				int numFound = findWord(nextL);
				if(numFound != 0) {
					//System.out.println(numFound + " num found");
					indexOfFound.add(charNum);
					//System.out.println("index line" + indexOfFound.get(lineNum));
				}
				charNum++;
			}
			scanFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}