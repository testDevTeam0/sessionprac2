package com.springboot.sessionprac2.controller;
import com.springboot.sessionprac2.dto.MemberRequestDto;
import com.springboot.sessionprac2.dto.MemberResponseDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/session/v1/")
public class MyController {
    Member member;
    @PostMapping("/post/member")
    public MemberResponseDto createMember(@RequestBody MemberRequestDto memberRequestDto){
        member = new Member(
                memberRequestDto.getName(),
                memberRequestDto.getAge(),
                memberRequestDto.getEmail(),
                memberRequestDto.getAddress(),
                memberRequestDto.getPhoneNumber());
        return new MemberResponseDto(
                member.getName(),
                member.getEmail(),
                member.getAge(),
                member.getAddress(),
                member.getPhoneNumber());
    }

    @GetMapping("/get/member")
    public MemberResponseDto getMember() {
        return new MemberResponseDto(
                member.getName(),
                member.getEmail(),
                member.getAge(),
                member.getAddress(),
                member.getPhoneNumber()
        );
    }

    @PutMapping("/put/member")
    public MemberResponseDto updateMember(@RequestBody MemberRequestDto memberRequestDto){
        member = new Member(
                memberRequestDto.getName(),
                memberRequestDto.getAge(),
                memberRequestDto.getEmail(),
                memberRequestDto.getAddress(),
                memberRequestDto.getPhoneNumber()
        );

        return new MemberResponseDto(
                member.getName(),
                member.getEmail(),
                member.getAge(),
                member.getAddress(),
                member.getPhoneNumber());
    }

    @DeleteMapping("/delete/member")
    public String deleteMember() {
        member = null;
        return "회원 정보가 삭제되었습니다.";
    }
}

