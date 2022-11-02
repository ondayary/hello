package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    // @RequestBody 사용
    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder(); // Builder Pattern

        postData.entrySet().forEach(map->sb.append(map.getKey() + ":" + map.getValue()));
        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMember2(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
