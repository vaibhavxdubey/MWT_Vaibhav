package com.thinkingapp.thinkingpad.service.post;

import com.thinkingapp.thinkingpad.exception.post.PostNotFoundException;
import com.thinkingapp.thinkingpad.model.comment.Comment;
import com.thinkingapp.thinkingpad.model.like.Like;
import com.thinkingapp.thinkingpad.model.post.Post;
import com.thinkingapp.thinkingpad.model.post.PostRequest;
import com.thinkingapp.thinkingpad.model.post.PostResponse;
import com.thinkingapp.thinkingpad.repository.CommentRepository;
import com.thinkingapp.thinkingpad.repository.LikeRepository;
import com.thinkingapp.thinkingpad.repository.PostRepository;
import com.thinkingapp.thinkingpad.util.DtoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;
    private final DtoConverter dtoConverter;

    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository, LikeRepository likeRepository, DtoConverter dtoConverter) {

        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;

        this.dtoConverter = dtoConverter;
    }

    @Override
    public String addTweets(PostRequest postRequest) {

        Post newPost = new Post();
        newPost.setContent(postRequest.getContent());
        postRepository.save(newPost);
        log.info("Post added");
        return "Tweeted successfully";
    }

    @Override
    public String updateTweets(PostRequest postRequest, Long id) throws PostNotFoundException {


        Post updatePost = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post does not exists with id " + id));

        updatePost.setContent(postRequest.getContent());
        postRepository.save(updatePost);
        log.info("Post updated");
        return "Post updated successfully";
    }

    @Override
    public String deleteTweet( Long id) throws PostNotFoundException {

        Post deletePost = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post does not exists with id " + id));

        List<Comment> comments = commentRepository.findCommentByTweetId(id);
        List<Like> likes = likeRepository.findLikeByTweetId(id);
        commentRepository.deleteAll(comments);
        likeRepository.deleteAll(likes);
        log.info("comment and likes deleted");

        postRepository.delete(deletePost);
        log.info("Post deleted");

        return "Post deleted successfully";

    }
    @Override
    public List<PostResponse> getAllTweet() {
        return postRepository.findAllOrderByUpdateTime().stream().map(dtoConverter::convertToTweetResponse).collect(Collectors.toList());
    }

}
