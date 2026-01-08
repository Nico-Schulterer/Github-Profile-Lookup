package com.nicosch.githubprofilelookup.services;

import com.nicosch.githubprofilelookup.records.User;
import com.nicosch.githubprofilelookup.records.UserList;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GithubRESTService {
    private final WebClient webClient;

    public GithubRESTService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }


    public Mono<UserList> SearchUsers(String q, int per_page, int page){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("api.github.com")
                        .path("/search/users")
                        .queryParam("q", q)
                        .queryParam("per_page", per_page)
                        .queryParam("page", page)
                        .build())
                .header("accept", "application/vnd.github+json")
                .retrieve()
                .bodyToMono(UserList.class);
    }

    public Mono<User> GetUser(String username) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("api.github.com")
                        .path("/users/" + username)
                        .build())
                .header("accept", "application/vnd.github+json")
                .retrieve()
                .bodyToMono(User.class);
    }

}
