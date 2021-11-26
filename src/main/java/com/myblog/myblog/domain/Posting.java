package com.myblog.myblog.domain;

import com.myblog.myblog.dto.PostingRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor  //기본생성자 만들 수 있음
@Getter
@Setter
@Entity  //테이블과 연계됨을 스프링에게 알려줌
public class Posting extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(nullable=false)
    private User user;

    @OneToMany(mappedBy = "posting",cascade = CascadeType.REMOVE)
    List<Comment> comment = new ArrayList<>();

    public Posting(PostingRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.user = requestDto.getUser();
        this.contents = requestDto.getContents();
    }

}