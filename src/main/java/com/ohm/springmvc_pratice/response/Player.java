package com.ohm.springmvc_pratice.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
    String name;
    int age;

    // JSON To Object 를 할 때
    // 1) 기본 생성자를 통해 JSON 을 가져오고
    // 2) Setter 또는 매개변수 있는 메서드를 사용하여 필드에 값을 넣어
    // 3) Getter 로 값을 반환
    // * 여기서 Setter 또는 매개변수 있는 메서드가 필요하다


    // 매개변수 있는 메서드
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 기본 생성자
    public Player() {
    }

    @Override
    public String toString() {
        return "JSON 으로 변환 전 ==> " + name + "," + age;
    }
}
