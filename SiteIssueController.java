package com.erapp23.controller;

import com.erapp23.entity.SiteIssue;
import com.erapp23.repository.SiteIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SiteIssueController {

    @Autowired
    private SiteIssueRepository issueRepo;

    @GetMapping("/issue")
    public String issuePage() {
        return "issue";
    }

    @PostMapping("/issue/save")
    public String saveIssue(@RequestParam String issueDescription) {

        SiteIssue issue = new SiteIssue();
        issue.setIssueDescription(issueDescription);

        issueRepo.save(issue);
        return "dashboard";
    }
}
