package com.thinkingapp.thinkingpad.model.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    @Size(min = 2, message = "Post should contain at least 2 characters")
    @Size(max = 144, message = "Post should be of maximum 144 characters")
    @NotBlank(message = "Content is required")
    private String content;
}
