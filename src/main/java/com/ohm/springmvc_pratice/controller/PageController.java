package com.ohm.springmvc_pratice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // < 정적 페이지 >

    // 1. 직접 접근
    // URL : http://localhost:8080/staticPage.html
    // html 파일을 바로 반환 (Controller 사용 X)

    // 2. Controller 를 사용하여 접근
    // thymleaf 주석 처리 후 진행
    @GetMapping("/static")
    public String staticPage() {
        return "staticPage2.html";
    }

    // 3. Redirect
    // 템플릿 엔진을 적용한 상태에서 static 폴더의 html 파일을 Controller 를 통해서 처리하고 싶은 경우 사용
    // 템플릿 엔진 : 지정된 템플릿 양식과 데이터가 함께 HTML 문서출력하는 SW (ex. JSP, Thymeleaf)
    // Request URL: http://localhost:8080/redirect
    // location : http://localhost:8080/staticPage3.html

    // static 폴더에 위치한 html 파일
    @GetMapping("/redirect/static")
    public String redirectStatic() {
        return "redirect:/staticPage3.html";
    }

    // 4. Template engine 에 View 전달
    // thymleaf 사용
    // 타임리프 Default 설정 -> prefix : classpath:/templates/ , suffix : .html
    @GetMapping("/html/templates")
    public String htmlTemplates() {
        return "staticPage4"; // .html 은 생략가능
    }

    // < 동적 페이지 >
    private static int visitCount = 0; // 클래스 변수 선언

    @GetMapping("/html/dynamic")
    // Model 객체를 사용 -> DB 작업 후 처리한 데이터 Model에 저장 -> 컨트롤러에서 뷰로 데이터 전달
    public String dynamicPage(Model model) {
        visitCount++; // 페이지가 요청될 때마다 visitCount 변수 +1
        model.addAttribute("visits",visitCount);
        // addAttribute(String name, Object value) : model에 데이터를 추가하는 메서드
        // name : HTML에서 참조할 수 있느 이름 / value : 그 값
        return "dynamicPage.html";
    }
}