package com.ohm.springmvc_pratice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerController {

    // < @RestController>
    // @RestController = @Controller + @ResponseBody
    // @ResponseBody : String 반환 -> String 전달 / 클래스 반환 -> JSON 전달

    @GetMapping("/rest/controller")
    public String rest() {
        return "{\"name\":\"Kim\",\"age\":34}"; // 출력 : {"name":"Kim","age":34}
    }
}
