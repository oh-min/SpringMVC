package com.ohm.springmvc_pratice.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
    // < JSON 데이터 반환 방법 >

    // 템플릿 엔진이 적용된 SpringBoot에서는 Controller에서 문자열을 반환하면 templates 폴더에서 해당 문자열의 .html 파일을 찾아서 반환
    // 따라서, JSON 파일을 반환 -> 해당 메서드에 @ResponseBody 어노테이션을 추가

    // 1. 반환값 : String
    // Java는 JSON 타입 지원 X -> JSON 형태의 String 타입으로 변환하여 사용
    @GetMapping("/response/json/string")
    @ResponseBody
    public String jsonString() {
        return "{\"name\":\"Kim\",\"age\":34}"; // 출력 : {"name":"Kim","age":34}
    }

    // 2. 반환값 : 자바 클래스
    @GetMapping("/response/json/class")
    @ResponseBody // 4) JSON 형태로 변환
    public Player jsonClass() {
        return new Player("Kim", 34); // 1) kim, 34 값을 가지는 새로운 Player 객체 생성
    }
}
