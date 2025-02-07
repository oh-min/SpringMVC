package com.ohm.springmvc_pratice.response;

import lombok.Getter;

@Getter // 3) 값을 반환
public class Player {
    String name;
    int age;

    // 2) jsonClass 메서드에 있는 kim, 34 값을 할당
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
