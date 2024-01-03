package com.thinkingapp.thinkingpad.service.comment;

import com.thinkingapp.thinkingpad.exception.comment.CommentNotFoundException;
import com.thinkingapp.thinkingpad.exception.post.PostNotFoundException;
import com.thinkingapp.thinkingpad.model.comment.CommentRequest;

public interface CommentService {

    public String addComment(CommentRequest commentRequest, Long tweetId) throws PostNotFoundException;

    public String deleteComment(Long tweetId) throws PostNotFoundException, CommentNotFoundException;
}
