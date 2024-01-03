package com.thinkingapp.thinkingpad.repository;

import com.thinkingapp.thinkingpad.model.like.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query(value = "select * from likes where tweet_id = :tid", nativeQuery = true)
    List<Like> findLikeByTweetId(@Param("tid") Long id);
}
