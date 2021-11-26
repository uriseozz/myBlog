package com.myblog.myblog.dto;


import com.myblog.myblog.domain.Posting;
import com.myblog.myblog.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CommentRequestDto {
    private String comment;
    private User user;
    private Posting posting;
}
