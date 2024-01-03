package com.thinkingapp.thinkingpad.controller.post;

import com.thinkingapp.thinkingpad.exception.post.PostNotFoundException;
import com.thinkingapp.thinkingpad.service.like.LikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LikeController {
    private final LikeServiceImpl likeService;

    @Autowired
    public LikeController(LikeServiceImpl likeService) {
        this.likeService = likeService;

    }

    @PostMapping("/like/{id}")
    public String addLike(@PathVariable("id") Long tweetId) throws PostNotFoundException {
        return likeService.addLike(tweetId);

    }
}
