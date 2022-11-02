package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// @RestController: dispatcherServlet이 Mapping해줄 Controller를 등록
// @RequestMapping: controller가 할당 된 후 어떤 method를 실행할지 연결해주는 어노테이션
// 로그 남기는 방법: Slf4j Annotation을 Class위에 추가 후 log.info()로 남긴다.

@Slf4j
@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("hello로 요청이 들어왔습니다.");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        log.info("getName으로 요청이 들어왔습니다.");
        return "daon";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1 (@PathVariable String variable) {
        log.info("getVariable1로 요청이 들어왔습니다.");
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2 (@PathVariable String var) {
        log.info("getVariable2로 요청이 들어왔습니다.");
        return var;
    }


    // /request1 을 받는 get endpoint 만들기
    @GetMapping(value = "/request1")
    // RequestParam으로 3개의 값 받기
    public String getVariable2(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String organization) {
        return String.format("%s %s %s", name, email, organization);
    }

    // Map으로 requestParam 받는 방법
    @GetMapping(value = "/request2")
    public String getVariable2(@RequestParam Map<String, String> param) {

        // entrySet() : key와 value 둘다 출력
        param.entrySet().forEach((map)-> { // map이 파라미터로 들어온다.
            System.out.printf("key:%s value:%s", map.getKey(), map.getValue());
        });

        return "request2가 호출 완료";
    }

    @GetMapping(value = "/request3")
    public String getRequestParam(MemberDto memberDto) {
        return memberDto.toString();
    }
}
