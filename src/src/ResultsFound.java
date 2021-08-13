import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Store results of the user search into categories: Law, Case Law, Articles
 * Allow user to save results to a download-able file
 * @author eacrouther
 */
public class ResultsFound extends Crawler {
	public ResultsFound(String fName) {
		super(fName);
	}

	HashMap<Integer, String> allSearches = new HashMap<>();
	HashMap<Integer, Integer> timesSearched = new HashMap<>();
	static int numberOfKeys = 0;
	//String search ;
	//ArrayList<String> foundMatch = new ArrayList<>();
	//ArrayList<Integer> indexOfFoundWord = new ArrayList<>();
	//ArrayList<Integer> indexOfFoundLine = new ArrayList<>();
	File file = openFile();
	
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
	
	@Override
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
	 * remove all punctuation and convert all chars to lower case
	 */
	public void cleanString() {
		search = search.toLowerCase();
		search = search.replaceAll("\\p{Punct}", "");
		
	}
	
	@Override
	/**
	 * add the search string to the arrays to store them in the history
	 * clean the string
	 * @param searchS
	 */
	public void saveFormatString(String searchS) {
		if(searchS != null) {
			addSearch(searchS);
			getTop5Searches();
			cleanString();
			System.out.println(searchS);
		}
	}
	
	/**
	 * Find the search phrase in .nextLine() from file
	 * @param line
	 */
	public int findPhrase(String line) {
		if(line == null) {return 0;}
		if(line.contains(search)) {
				return 1;
		}
		return 0;
	}
	
	/**
	 * Separate the user-entered string
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
				foundAMatch++;
			}
		}
		return foundAMatch ;
	}
	@Override
	/**
	 * Scan the file:
	 * compare the whole search string to the .nextLine() in the file
	 * @param searchS
	 */
	public ArrayList<Integer> searchForPhrase(String searchS) {
		ArrayList<Integer> indexOfFoundLine = new ArrayList<>();
		int lineNum = 0;
		try {
			Scanner scanFile = new Scanner(file);
			while(scanFile.hasNextLine()) {
				String nextL = scanFile.nextLine();
				nextL = nextL.toLowerCase();
				nextL = nextL.replaceAll("\\p{Punct}", "");
				int numFound = findPhrase(nextL);
				if(numFound != 0) {
					indexOfFoundLine.add(lineNum);
				}
				lineNum++;
			}
			scanFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return indexOfFoundLine;
	}
	
	@Override
	/**
	 * Scan the file:
	 * compare each word in the search string to the .next() word in the file
	 * @param searchS
	 */
	public ArrayList<Integer> searchEachWord(String searchS) {
		ArrayList<Integer> indexOfFoundWord = new ArrayList<>();
		int charNum = 0;
		try {
			
			Scanner scanFile = new Scanner(file);
			while(scanFile.hasNext()) {
				String nextL = scanFile.next();
				nextL = nextL.toLowerCase();
				nextL = nextL.replaceAll("\\p{Punct}", "");
				int numFound = findWord(nextL);
				if(numFound != 0) {
					indexOfFoundWord.add(charNum);
				}
				charNum++;
			}
			scanFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		returargs)n indexOfFoundWord;
	}
	
	// adding main to test github actions
	public static void main(String[] args) {
		ResultsFound rf = new ResultsFound("src/roeVwade.txt");	
	}
	
}
