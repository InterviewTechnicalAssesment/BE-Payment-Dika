package com.project.payment.service;

import java.time.Duration;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.project.payment.model.Post;

@Service
public class RestService {
	
	@Value("${request_time_out:500}")
	private int timeoutInSecond;
	
	@Value("${base_url:https://jsonplaceholder.typicode.com/posts}")
	private String baseURL;
	
    private RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(timeoutInSecond))
                .setReadTimeout(Duration.ofSeconds(timeoutInSecond))
                .build();
    }
    
    public Post[] getPostsAsObject() {
        String url = baseURL;
        return this.restTemplate.getForObject(url, Post[].class);
    }
    
    public Post getPostWithUrlParameters() {
        String url = baseURL+"/{id}";
        return this.restTemplate.getForObject(url, Post.class, 1);
    }
    
    public Post getPostWithResponseHandling() {
        String url = baseURL+"/{id}";
        ResponseEntity<Post> response = this.restTemplate.getForEntity(url, Post.class, 1);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
    
    public Post getPostWithCustomHeaders() {
        String url = baseURL+"/{id}";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // set custom header
        headers.set("x-request-source", "desktop");

        // build the request
        HttpEntity request = new HttpEntity<>(headers);

        // use `exchange` method for HTTP call
        ResponseEntity<Post> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Post.class, 1);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
    
    public Post createPostWithObject(Post newPost) {
        String url = baseURL;

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // create a post object

        // build the request
        HttpEntity<Post> entity = new HttpEntity<>(newPost, headers);

        // send POST request
        return restTemplate.postForObject(url, entity, Post.class);
    }
    
    public Post updatePostWithResponse() {
        String url = baseURL+"/{id}";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // create a post object
        Post post = new Post(4, "New Title", "New Body");

        // build the request
        HttpEntity<Post> entity = new HttpEntity<>(post, headers);

        // send PUT request to update post with `id` 10
        ResponseEntity<Post> response = this.restTemplate.exchange(url, HttpMethod.PUT, entity, Post.class, 10);

        // check response status code
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
    
    public void deletePost() {
        String url = baseURL+"/{id}";

        // send DELETE request to delete post with `id` 10
        this.restTemplate.delete(url, 10);
    }
    
    public String unknownRequest() {
        try {
            String url = "https://jsonplaceholder.typicode.com/404";
            return this.restTemplate.getForObject(url, String.class);
        } catch (HttpStatusCodeException ex) {
            // raw http status code e.g `404`
            System.out.println(ex.getRawStatusCode());
            // http status code e.g. `404 NOT_FOUND`
            System.out.println(ex.getStatusCode().toString());
            // get response body
            System.out.println(ex.getResponseBodyAsString());
            // get http headers
            HttpHeaders headers= ex.getResponseHeaders();
            System.out.println(headers.get("Content-Type"));
            System.out.println(headers.get("Server"));
        }

        return null;
    }
}