package com.app.mysql.controller;

import com.app.mysql.domain.dto.MemberDTO;
import com.app.mysql.domain.enumeration.MemberType;
import com.app.mysql.mapper.MemberMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
// http://localhost:10000/swagger-ui/index.html
@Slf4j
@RequestMapping("/members/*")
@RequiredArgsConstructor
public class MemberController implements MemberControllerDocs{
    private final MemberMapper memberMapper;
//    회원가입
    @PostMapping("/api/join")
    @ResponseBody
    public void join(@RequestBody MemberDTO memberDTO){
        memberMapper.insert(memberDTO.toVO());
    }

    @GetMapping("join")
    public String goToJoinForm(MemberDTO memberDTO){
        return "member/joinForm";
    }

    @PostMapping("join")
    public RedirectView joinForm(MemberDTO memberDTO){
        memberMapper.insert(memberDTO.toVO());
        return new RedirectView("/");
    }

    @GetMapping("/test/{memberType}")
    public void test(@PathVariable MemberType memberType){
    }
}















