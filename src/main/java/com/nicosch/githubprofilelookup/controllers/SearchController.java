package com.nicosch.githubprofilelookup.controllers;

import com.nicosch.githubprofilelookup.records.User;
import com.nicosch.githubprofilelookup.records.UserList;
import com.nicosch.githubprofilelookup.services.GithubRESTService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SearchController {

    private final GithubRESTService githubRESTService;

    public SearchController(GithubRESTService githubRESTService) {
        this.githubRESTService = githubRESTService;
    }

    @GetMapping("/hello")
    public String index () {
        return "Hello";
    }

    @GetMapping("/query")
    public Mono<UserList> QueryUsers(@RequestParam(name = "q") String q, @RequestParam(name = "per_page", defaultValue = "30") int per_page, @RequestParam(name = "page", defaultValue = "1") int page) {
        return githubRESTService.SearchUsers(q, per_page, page);
    }

    @GetMapping("/user")
    public Mono<User> GetUser(@RequestParam(name = "username") String username) {
        return githubRESTService.GetUser(username);
    }

}
