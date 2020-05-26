package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;

public class TechJobsController {

    private static HashMap<String, String> actionChoices = new HashMap<>();
    private static HashMap<String, String> columnChoices = new HashMap<>();


    public TechJobsController() {
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");

        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("positionType", "Position Type");
        columnChoices.put("coreCompetency", "Skill");
    }

    /**
     * "@ ModelAttribute("actions") annotation will cause the return value of the method
     * to be set in the model with key "actions" for every controller that extends TechJobsController."
     *
     * (i.e. instead of saying model.addAttribute("actions", actionChoices) inside every controller method)
     */
    @ModelAttribute("actions")
    public static HashMap<String, String> getActionChoices() {
        return actionChoices;
    }

    /**
     * This method and the TechJobsController-not-really-a-controller class allow:
     *
     *  -  columnChoices HashMap initialization to be moved here
     *  -  'columnChoices.put...' to take place inside 'public TechJobsController()' constructor
     *  -  'model.addAttribute("columns", columnChoices);' in every controller method
     *          to be replaced with
     *     '@ ModelAttribute("columns") ... { return columnChoices; }' in one method here
     */
    @ModelAttribute("columns")
    public static HashMap<String, String> getColumnChoices() {
        return columnChoices;
    }

}
