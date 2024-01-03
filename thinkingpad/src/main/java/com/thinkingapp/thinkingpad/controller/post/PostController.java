package com.thinkingapp.thinkingpad.controller.post;

import com.thinkingapp.thinkingpad.model.post.PostRequest;
import com.thinkingapp.thinkingpad.model.post.PostResponse;
import com.thinkingapp.thinkingpad.exception.post.PostNotFoundException;
import com.thinkingapp.thinkingpad.service.post.PostServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    private final PostServiceImpl tweetService;

    @Autowired
    public PostController(PostServiceImpl tweetService) {

        this.tweetService = tweetService;
    }

    @PostMapping("/add")
    public String addTweet(@RequestBody @Valid PostRequest postRequest){
            return tweetService.addTweets(postRequest);

    }

    @PutMapping("/update/{id}")
    public String updateTweet(@PathVariable("id") long id, @RequestBody @Valid PostRequest postRequest) throws PostNotFoundException {
                 return tweetService.updateTweets(postRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTweet( @PathVariable("id") long id) throws PostNotFoundException {

            return tweetService.deleteTweet(id);

    }


    @GetMapping("/all")
    public List<PostResponse> getAllTweet() {
        return tweetService.getAllTweet();
    }
}
