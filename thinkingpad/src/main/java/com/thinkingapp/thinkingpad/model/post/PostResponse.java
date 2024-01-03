package com.thinkingapp.thinkingpad.model.post;

import com.thinkingapp.thinkingpad.model.comment.CommentResponse;
import com.thinkingapp.thinkingpad.model.like.LikeResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private Long id;

    private String content;

    private List<CommentResponse> comments;

    private List<LikeResponse> likes;

    private Date createTime;

    private Date updateTime;
}
