package com.myblog.myblog.controller;

import com.myblog.myblog.domain.Comment;
import com.myblog.myblog.domain.Posting;
import com.myblog.myblog.dto.CommentRequestDto;
import com.myblog.myblog.repository.CommentRepository;
import com.myblog.myblog.repository.PostingRepository;
import com.myblog.myblog.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Controller
public class CommentController {

    private final CommentRepository commentRepository;
    private final PostingRepository postingRepository;


    @PostMapping("/api/postings/{id}/comment")
    public String createComment(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id, @ModelAttribute CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        Posting posting = postingRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        comment.setUser(userDetails.getUser());
        comment.setPosting(posting);
        commentRepository.save(comment);
        return "redirect:/api/postings/{id}";
    }

    @ResponseBody
    @PutMapping("/api/postings/{id}/comment/{commentId}")
    public Long editComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
//        System.out.println(comment.getPosting().getId());
//        System.out.println(comment.getUser().getUsername());
//        System.out.println(comment.getComment());
        comment.setComment(requestDto.getComment());
        commentRepository.save(comment);
        return commentId;
    }

    @ResponseBody
    @DeleteMapping("/api/postings/{id}/comment/{commentId}")
    public Long deleteComment(@PathVariable Long commentId){
        commentRepository.deleteById(commentId);
        return commentId;
    }
}
