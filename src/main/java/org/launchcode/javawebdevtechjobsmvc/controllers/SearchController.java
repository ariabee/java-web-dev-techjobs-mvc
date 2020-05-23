package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @PostMapping(value = "results") // value is same as the form action value (where the post request is sent)
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {   // name the request params according to input name fields in form

        ArrayList jobs;

        if (searchTerm.trim().toLowerCase().equals("all") || searchTerm.equals("")) {
            jobs = JobData.findAll();
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm.trim());
        }

        model.addAttribute("title", "Jobs with " + searchType + ": " + searchTerm );
        model.addAttribute("columns", columnChoices);
        model.addAttribute("jobs", jobs);
        model.addAttribute("previousSearchType", searchType);
        model.addAttribute("previousSearchTerm", searchTerm);
        return "search";
    }

    @GetMapping(value = "results")
    public String redirectReloadedResultsToSearchPage(Model model) {
        return "redirect:";
    }

}
