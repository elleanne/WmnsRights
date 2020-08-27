import java.util.ArrayList;
import java.util.HashMap;

/*
 * Store results of the user search into categories: Law, Case Law, Articles
 * Allow user to save results to a download-able file
 */
public class ResultsFound {
	HashMap<Integer, String> allSearches = new HashMap<>();
	HashMap<Integer, Integer> timesSearched = new HashMap<>();
	static int numberOfKeys = 0;
	
	
	public ResultsFound() {
		
	}

	/**
	 * Add the current string searched to the HAshMap, to keep a record of searched
	 * strings and the number of times they were searched
	 * 
	 * @param searching
	 */
	public void addSearch(String searching) {
		int noStringFound = 0;
		if (searching.isEmpty())
			System.err.println("Please enter a value to search");

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
		String[] topSearches = new String[5];
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
}