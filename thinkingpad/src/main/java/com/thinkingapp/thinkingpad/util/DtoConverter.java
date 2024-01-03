package com.thinkingapp.thinkingpad.util;


import com.thinkingapp.thinkingpad.model.comment.Comment;
import com.thinkingapp.thinkingpad.model.comment.CommentResponse;
import com.thinkingapp.thinkingpad.model.like.Like;
import com.thinkingapp.thinkingpad.model.like.LikeResponse;
import com.thinkingapp.thinkingpad.model.post.Post;
import com.thinkingapp.thinkingpad.model.post.PostResponse;
import com.thinkingapp.thinkingpad.repository.CommentRepository;
import com.thinkingapp.thinkingpad.repository.LikeRepository;
import com.thinkingapp.thinkingpad.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DtoConverter {


    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;

    @Autowired
    public DtoConverter(PostRepository postRepository, CommentRepository commentRepository, LikeRepository likeRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;
    }


    //Convert to post response DTO
    public PostResponse convertToTweetResponse(Post post) {
        PostResponse postResponse = new PostResponse();
        List<CommentResponse> comments = commentRepository.findCommentByTweetId(post.getId()).stream().map(this::convertToCommentResponse).collect(Collectors.toList());
        List<LikeResponse> likes = likeRepository.findLikeByTweetId(post.getId()).stream().map(this::convertToLikeResponse).collect(Collectors.toList());
        postResponse.setComments(comments);
        postResponse.setLikes(likes);
        postResponse.setContent(post.getContent());
        postResponse.setId(post.getId());
        postResponse.setCreateTime(post.getCreateTime());
        postResponse.setUpdateTime(post.getUpdateTime());
        return postResponse;
    }



    public CommentResponse convertToCommentResponse(Comment comment) {

        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setId(comment.getId());
        commentResponse.setCommentTweetId(comment.getPost().getId());
        commentResponse.setContent(comment.getContent());
        commentResponse.setCreateTime(comment.getCreateTime());
        return commentResponse;
    }

    public LikeResponse convertToLikeResponse(Like like) {
        LikeResponse likeResponse = new LikeResponse();
        likeResponse.setId(like.getId());
        likeResponse.setLikeTweetId(like.getPost().getId());
        return likeResponse;
    }
}
