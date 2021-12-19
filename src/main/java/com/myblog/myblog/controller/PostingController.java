package com.myblog.myblog.controller;

import com.myblog.myblog.domain.Comment;
import com.myblog.myblog.domain.Posting;
import com.myblog.myblog.dto.PostingRequestDto;
import com.myblog.myblog.repository.CommentRepository;
import com.myblog.myblog.repository.PostingRepository;
import com.myblog.myblog.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostingController {

    private final PostingRepository postingRepository;
    private final CommentRepository commentRepository;


    //index페이지
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<Posting> posting = postingRepository.findAllByOrderByModifiedAtDesc();

        if(userDetails == null){
            model.addAttribute("user","null");
        }else{

            model.addAttribute("user",userDetails.getUser().getUsername());
        }
        model.addAttribute("posting",posting);
        return "index";
    }


    //포스팅 작성 페이지
    @GetMapping("/api/write")
    public String getNotice( Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Posting posting = new Posting();
        if(userDetails == null){
            model.addAttribute("user","null");
        }else{

            model.addAttribute("user",userDetails.getUser().getUsername());
        }
        model.addAttribute("posting", posting);
        return "write";
    }

    //포스팅작성
    @PostMapping("/api/postings")
    public String creatPosting(@AuthenticationPrincipal UserDetailsImpl userDetails, @ModelAttribute PostingRequestDto requestDto) {
        requestDto.setUser(userDetails.getUser());
        Posting posting = new Posting(requestDto);
        postingRepository.save(posting);
        return "redirect:/";
    }

    //상세페이지 보이기, 상세페이지에 username
    @GetMapping("/api/postings/{id}")
    public String detail(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){

        Posting posting = postingRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        List<Comment> comment = commentRepository.findByPostingIdOrderByModifiedAtDesc(id);
        if(userDetails == null) {
            model.addAttribute("user", "null");
        }else{
            model.addAttribute("user",userDetails.getUser().getUsername());
        }
        model.addAttribute("editcomment",new Comment());
        model.addAttribute("postcomment",new Comment());
        model.addAttribute("comment", comment);
        model.addAttribute("posting",posting);
        return "detail";
    }

    @ResponseBody
    @DeleteMapping("/api/postings/{id}")
    public Long deletePosting(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Posting findPosting = postingRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );

        if(!findPosting.getUser().getId().equals(userDetails.getId())) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다");
        }

        postingRepository.deleteById(id);
        return id;
    }
}
