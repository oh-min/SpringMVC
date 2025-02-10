package com.ohm.springmvc_pratice.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/http-object")
public class ObjectController {
    // < @ModelAttribute, @RequestBody 를 사용하여 HTTP 데이터를 객체로 전달하기 >

    // 객체의 필드에 데이터를 넣어주기 위해 set / get 메서드 또는 오버로딩된 생성자 필요
    // set 메서드 또는 오버로딩된 생성자가 없다면 -> 받은 데이터를 해당 객체의 필드에 담을 수 X

    // html 연결
    @GetMapping("/html")
    public String objectHtml() {
        return "objectPage";
    }

    // 1. @ModelAttribute 방식 POST
    // URI : http://localhost:8080/http-object/post/model
    @PostMapping("/post/model")
    @ResponseBody
    public String postModel(@ModelAttribute Player player) {
        // @ModelAttribute : 객체를 통해 Body 데이터를 받아옴
        // HTTP Body 에 name=Kim&age=34 형태로 담겨서 서버로 전송 -> URL 에 데이터 값 노출 X
        // @ModelAttribute 생략 가능 O
        // Spring 은 해당 매개변수가 SimpleValueType 이라면 -> @RequestParam 으로 간주
        // 아니라면 -> @ModelAttribute 가 생략되어있다 판단
        return String.format("@ModelAttribute 방식 result <br> name = %s, age = %d", player.getName(), player.getAge());
    }

    // 2. @ModelAttribute 를 사용한 Query String 방식
    // URI : http://localhost:8080/http-object/get/model?name=kim&age=34
    @GetMapping("/get/model")
    @ResponseBody
    public String getModel(@ModelAttribute Player player) {
        return String.format("@ModelAttribute 를 사용한 Query String 방식 result <br> name = %s, age = %d", player.getName(), player.getAge());
    }

    // 3. @RequestBody 방식
    @PostMapping("/post/json")
    @ResponseBody
    public String postJson(@RequestBody Player player) {
        // HTTP Body 에 {"name": "kim","age": 34} JSON 형태로 담겨서 서버로 전송 -> @RequestBody 를 통해 객체 형태로 받음
        return String.format("@RequestBody 방식 result <br> name = %s, age = %d", player.getName(), player.getAge());
    }
}
