package com.thinkingapp.thinkingpad.service.comment;

import com.thinkingapp.thinkingpad.exception.comment.CommentNotFoundException;
import com.thinkingapp.thinkingpad.exception.post.PostNotFoundException;
import com.thinkingapp.thinkingpad.model.comment.Comment;
import com.thinkingapp.thinkingpad.model.comment.CommentRequest;
import com.thinkingapp.thinkingpad.model.post.Post;
import com.thinkingapp.thinkingpad.repository.CommentRepository;
import com.thinkingapp.thinkingpad.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {

        this.postRepository = postRepository;
        this.commentRepository = commentRepository;

    }

    @Override
    public String addComment(CommentRequest commentRequest, Long tweetId) throws PostNotFoundException {
        Post post = postRepository.findById(tweetId).orElseThrow(() -> new PostNotFoundException("Post with id " + tweetId + " does not exists"));
        Comment newComment = new Comment();
        newComment.setPost(post);
        newComment.setContent(commentRequest.getContent());
        commentRepository.save(newComment);
        log.info("Commented successfully");
        return "Successfully commented";
    }

    @Override
    public String deleteComment(Long commentId) throws CommentNotFoundException {

        Comment commentedTweet = commentRepository.findById(commentId).orElseThrow(() -> new CommentNotFoundException("Comment not found with id " + commentId));


        commentRepository.delete(commentedTweet);
        log.info("Comment deleted");
        return "Comment deleted";
    }
}
