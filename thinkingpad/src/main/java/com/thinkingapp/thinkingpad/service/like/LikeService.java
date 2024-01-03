package com.thinkingapp.thinkingpad.service.like;

import com.thinkingapp.thinkingpad.exception.post.PostNotFoundException;

public interface LikeService {
    public String addLike(Long tweetId) throws PostNotFoundException;

}
