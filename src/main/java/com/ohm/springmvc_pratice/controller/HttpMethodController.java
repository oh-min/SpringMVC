package com.ohm.springmvc_pratice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HttpMethodController {
//    HTTP 메소드란?
//    클라이언트 - 서버 구조에서 요청(request)과 응답(response)이 이루어지는 방식
//    서버가 수행해야 할 동작을 지정하여 요청을 보내는 방법

//    HTTP 메서드를 사용하는 이유?
//    리소스와 동작을 분리하기 위함 (HTTP 메소드를 통해 서버가 수행해야 할 동작 지정, URL은 리소스만 식별)

//    종류
//    GET, POST, PUT, DELETE, PATCH, HEAD, OPTIONS, CONNECT

    @GetMapping("/api/get")
    @ResponseBody
    public String get() {
        return "GET Method 요청";
    }

    @PostMapping("/api/post")
    @ResponseBody
    public String post() {
        return "POST Method 요청";
    }

    @PutMapping("/api/put")
    @ResponseBody
    public String put() {
        return "PUT Method 요청";
    }

    @DeleteMapping("/api/delete")
    @ResponseBody
    public String delete() {
        return "DELETE Method 요청";
    }

    @PatchMapping("/api/patch")
    @ResponseBody
    public String patch() {
        return "PATCH Method 요청";
    }

}
