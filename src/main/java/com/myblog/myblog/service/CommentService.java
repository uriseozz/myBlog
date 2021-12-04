package com.myblog.myblog.service;

import com.myblog.myblog.domain.Comment;
import com.myblog.myblog.dto.CommentRequestDto;
import com.myblog.myblog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    @Transactional
    public Long update(Long commentId, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );

        comment.update(requestDto);
        commentRepository.save(comment);
        System.out.println(comment.getPosting().getId());
        System.out.println(comment.getId());
        System.out.println(comment.getUser().getUsername());
        System.out.println(comment.getComment());
        return commentId;
    }

}
