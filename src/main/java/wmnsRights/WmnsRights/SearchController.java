package wmnsRights.WmnsRights;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SearchController {
    // example of how spring-boot can be used
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Elizabeth") String name) {
        return String.format("Hello %s!", name);
    }
    // homepage of the app
    @GetMapping("/")
    public String searchForm(Model model){
        model.addAttribute("search", new SearchForm());
        return "index"; // returns the index.html page
    }
    // When 'submit' buttton is clicked, the text in the textbox in index.html id gotten and put in the results.html page
    @PostMapping("/index")
    public String searchSubmit(@ModelAttribute SearchForm search, Model model){

        if (search.getSearchString().length() > 0) {
            String searchString = search.getSearchString();

            // parse the string and run the analysis here by calling some class

        }
        model.addAttribute("search", search);
        return "result"; // returns the results.html page
        // ** TODO: need to figure out how the mapping is to index when results page is loaded ** //
    }
}
