package com.ohm.springmvc_pratice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/http-parameter")
public class ParameterController {

    // < @PathVariable 과 @RequestParam 를 사용해 URI 를 통해 값을 파라미터로 받아오기 >
    // HTTP 데이터를 개별 추출하여 매서드의 매개변수로 전달하는 방법
    // URL 경로 값 → 메서드 매개변수로 지정(@PathVariable,@RequestParam) → 응답 본문으로 반환(@ResponseBody)

    // html 연결
    @GetMapping("/html")
    public String parameterForm() {
        return "parameterPage";
    }

    // 1. @Path Variable 방식
    // URI : http://localhost:8080/http-parameter/player/kim/age/34 -> kim, 34 데이터를 서버에 보내기 위해 URL 경로에 추가
    @GetMapping("/player/{name}/age/{age}") // URL 경로에서 데이터 받으려는 경로에 중괄호{ } 사용
    @ResponseBody // 메서드가 반환하는 String 값을 그대로 HTTP 응답의 본문으로 포함시키기 위해 사용
    public String playerPathVariable(@PathVariable String name, @PathVariable int age) {
        // @PathVariable : URL 경로에서 변수를 받아오는 데 사용
        return String.format("@PathVariable 방식 result <br> name = %s, age = %d", name, age); // 지정된 포맷에 맞춰 문자열을 생성
    }

    // 2. @Request Param GET 방식
    // URI : http://localhost:8080/http-parameter/get/request-param?name=kim&age=34
    // /http-parameter/request-param : API 요청 URL
    // ? : 쿼리 파라미터 방식으로 데이터를 시작
    // name=kim : key = value
    // & : 여러 데이터 구분
    @GetMapping("/get/request-param")
    @ResponseBody
    public String playerGetRequestParam(@RequestParam String name, @RequestParam int age) {
        // @RequestParam : 쿼리 파라미터의 값을 메서드 매개변수로 가져오는 데 사용
        // @RequestParam 생략 가능 O ( String, int, Integer 와 같은 단순 타입에서만 생략)
        return String.format("@RequestParam GET 방식 result <br> name = %s, age = %d", name, age);
    }

    // 2-1. @Request Param 의 required = false 옵션
    // URI : http://localhost:8080/http-parameter/get/request-param/required?name=&age=34
    @GetMapping("/get/request-param/required")
    @ResponseBody
    public String playerGetRequestParamRequired(@RequestParam(required = false) String name, @RequestParam int age) {
        // required 옵션이 false 로 설정 -> 해당 값이 포함되지 않아도 오류 발생 X
        // @PathVariable 도 required 옵션 존재
        return String.format("@RequestParam required 옵션 result <br> name = %s, age = %d", name, age);
    }

    // 3. @Request Param POST 방식
    // URI : http://localhost:8080/http-parameter/post/request-param
    // HTTP Body 에 name=Kim&age=34 형태로 담겨서 서버로 전송 -> URL 에 데이터 값 노출 X
    @PostMapping("/post/request-param")
    @ResponseBody
    public String playerPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("@RequestParam POST 방식 result <br> name = %s, age = %d", name, age);
    }
}
