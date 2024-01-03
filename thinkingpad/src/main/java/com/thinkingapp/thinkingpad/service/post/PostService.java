package com.thinkingapp.thinkingpad.service.post;

import com.thinkingapp.thinkingpad.exception.post.PostNotFoundException;
import com.thinkingapp.thinkingpad.model.post.PostRequest;
import com.thinkingapp.thinkingpad.model.post.PostResponse;

import java.util.List;

public interface PostService {

    public String addTweets(PostRequest postRequest);

    public String updateTweets(PostRequest postRequest, Long id) throws PostNotFoundException;

    public String deleteTweet(Long id) throws PostNotFoundException;


    public List<PostResponse> getAllTweet();
}
