package com.myblog.myblog.domain;

import com.myblog.myblog.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor  //기본생성자 만들 수 있음
@Getter
@Setter
@Entity  //테이블과 연계됨을 스프링에게 알려줌
public class Comment extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Posting posting;

    public Comment(CommentRequestDto requestDto) {
        this.user = requestDto.getUser();
        this.posting = requestDto.getPosting();
        this.comment = requestDto.getComment();
    }

    public void update(CommentRequestDto requestDto) {
        this.user = requestDto.getUser();
        this.posting = requestDto.getPosting();
        this.comment = requestDto.getComment();
    }
}
