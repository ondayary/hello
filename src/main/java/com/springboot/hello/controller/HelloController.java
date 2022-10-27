package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController // dispatcherServlet이 Mapping해줄 Controller를 등록
@RequestMapping("/api/v1/get-api")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    // controller가 할당 된 후 어떤 method를 실행할지 연결해주는 어노테이션
    public String hello() {
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "daon";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1 (@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2 (@PathVariable String var) {
        return var;
    }


    // /request1 을 받는 get endpoint만들기
    @GetMapping(value = "/request1")
    // RequestParam으로 3개의 값 받기
    public String getVariable2(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String organization) {
        return String.format("%s %s %s", name, email, organization);
    }

}
