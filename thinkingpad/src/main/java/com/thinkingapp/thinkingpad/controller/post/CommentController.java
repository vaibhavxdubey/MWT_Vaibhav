package com.thinkingapp.thinkingpad.controller.post;

import com.thinkingapp.thinkingpad.model.comment.CommentRequest;
import com.thinkingapp.thinkingpad.exception.comment.CommentNotFoundException;
import com.thinkingapp.thinkingpad.exception.post.PostNotFoundException;
import com.thinkingapp.thinkingpad.service.comment.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class CommentController {

    private final CommentServiceImpl commentService;


    @Autowired
    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/reply/{id}")
    public String addComment(@PathVariable("id") Long tweetId, @RequestBody @Valid CommentRequest commentRequest) throws PostNotFoundException {
            return commentService.addComment(commentRequest, tweetId);

    }

    @DeleteMapping("/reply/{id}")
    public String deleteComment(@PathVariable("id") Long tweetId) throws CommentNotFoundException {
            return commentService.deleteComment(tweetId);

    }
}
