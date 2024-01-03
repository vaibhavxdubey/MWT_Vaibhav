package com.thinkingapp.thinkingpad.repository;

import com.thinkingapp.thinkingpad.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "select * from tweets order by create_time desc", nativeQuery = true)
    List<Post> findAllOrderByUpdateTime();
}
