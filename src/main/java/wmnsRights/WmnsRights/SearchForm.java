package wmnsRights.WmnsRights;

import java.util.List;

/**
 * Save data - Current User search and results -
 */
public class SearchForm {

    private String searchString;
    private List<String> listOfFoundResults;

    //setter
    public void setSearchString(String searchS) {
        this.searchString =  searchS;
    }
    //getter
    public String getSearchString() {
        return searchString;
    }
    //setter
    public void setResultsList(List<String> results) {
        this.listOfFoundResults =  results;
    }
    //getter
    public List<String> getSearchResults() {
        return listOfFoundResults;
    }
}
