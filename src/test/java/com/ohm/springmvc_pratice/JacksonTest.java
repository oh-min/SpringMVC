package com.ohm.springmvc_pratice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohm.springmvc_pratice.response.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JacksonTest {
    // < Jackson >

    // Jackson ? JSON 데이터 구조를 처리해주는 라이브러리
    // Object -> JSON 타입의 String / JSON 타입의 String -> Object 변환

    // Spring 3.0버전 이후 (SpringBoot 포함) -> default 로 Jackson 관련 라이브러리들을 제공
    // 직접 JSON 데이터를 처리해야할 때 -> Jackson 라이브러리의 ObjectMapper 사용

    @Test
    @DisplayName("Object To JSON")
    void test1() throws JsonProcessingException {
        Player player = new Player("Kim", 34); // 새로운 객체 생성

        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리의 ObjectMapper 객체를 생성

        System.out.println(player.toString());

        String json = objectMapper.writeValueAsString(player); // JSON 형태로 변환
        // writeValueAsString : 직렬화(Serialize) 한다. Object -> JSON
        // Object : String name = "Kim"; int age = 34;
        // JSON : { "name" : "Kim" , "age" : 34 }
        System.out.println("JSON 으로 변환 후 ==> " + json);
    }

    @Test
    @DisplayName("JSON To Object")
    void test2() throws JsonProcessingException {
        String json = "{\"name\":\"Kim\",\"age\":34}"; // JSON 타입의 String

        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리의 ObjectMapper 객체를 생성

        System.out.println("Object 으로 변환 전 ==> " + json);

        Player player = objectMapper.readValue(json, Player.class); // Object 타입으로 변환
        // readValue : 역직렬화(Deserialization) 한다. JSON -> Object
        // readValue(String content, Class<T> valueType)
        // String content : 변환하려는 JSON 형식의 텍스트, Class<T> valueType : 어떤 Java 객체로 변환할지 명시
        System.out.println("Object 으로 변환 후 ==> " + player.getName() + "," + player.getAge());

    }

}
