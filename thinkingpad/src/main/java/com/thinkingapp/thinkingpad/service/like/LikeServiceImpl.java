package com.thinkingapp.thinkingpad.service.like;


import com.thinkingapp.thinkingpad.exception.post.PostNotFoundException;
import com.thinkingapp.thinkingpad.model.like.Like;
import com.thinkingapp.thinkingpad.model.post.Post;
import com.thinkingapp.thinkingpad.repository.LikeRepository;
import com.thinkingapp.thinkingpad.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class LikeServiceImpl implements LikeService {


    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public LikeServiceImpl(PostRepository postRepository, LikeRepository likeRepository) {

        this.postRepository = postRepository;
        this.likeRepository = likeRepository;
    }

    @Override
    public String addLike(Long tweetId) throws PostNotFoundException {

        Post post = postRepository.findById(tweetId).orElseThrow(() -> new PostNotFoundException("Post with id " + tweetId + " does not exists"));
     //   List<Like> likeTweetId = likeRepository.findLikeByTweetId(tweetId);

        Like newLike = new Like();

        newLike.setPost(post);
        likeRepository.save(newLike);
        log.info("Liked the post");
        return "Liked";
    }
}
