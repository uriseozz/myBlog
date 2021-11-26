package com.myblog.myblog.dto;

import com.myblog.myblog.domain.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostingRequestDto {
    private String title;
    private User user;
    private String contents;

}
