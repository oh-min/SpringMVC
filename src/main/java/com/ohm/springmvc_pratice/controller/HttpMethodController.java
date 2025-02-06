package com.ohm.springmvc_pratice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//RequestMappign Annotation을 추가
@RequestMapping("/api")
@Controller
public class HttpMethodController {

//    Spring 4.3 버전 이전 방식 (현재도 사용 가능)
//    URL : http://localhost:8080/api/request
    @RequestMapping(value = "/request", method = RequestMethod.GET)
    @ResponseBody
    public String request() {
        return "RequestMapping GET Method 요청";
    }

//    @GetMapping("/api/get") -> @GetMapping("/get")
//    URL 은 http://localhost:8080/api/get 으로 동일
    @GetMapping("/get")
    @ResponseBody
    public String get() {
        return "GET Method 요청";
    }

    @PostMapping("/post")
    @ResponseBody
    public String post() {
        return "POST Method 요청";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put() {
        return "PUT Method 요청";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete() {
        return "DELETE Method 요청";
    }

    @PatchMapping("/patch")
    @ResponseBody
    public String patch() {
        return "PATCH Method 요청";
    }

}
