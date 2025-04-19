package com.example.community.controller;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        // Java의 Optional 값이 있을 수도, 없을 수도 있음. 명확하게 표현해주기 위한 클래스
        // NullpointerException 방지 하기 위해.

        String name = "승민";
        if (name != null) {
            System.out.println(name.length());
        }

        // Optional<String> 문자가 있을 수 있고, 없을 수 있다.
        //
        Optional<String> name2 = Optional.of("승민");
        name2.ifPresent(n -> System.out.println(n.length()));

        // null이어도 예외 처리 안남.
        String test = null;
        Optional<String> name3 = Optional.ofNullable(test);

        // of();
        // 값이 있으면 실행

        Optional<String> name4 = Optional.of("값이 있을 때 실행");
        name4.ifPresent(n -> System.out.println(name4 + "안녕하세요."));

        // orElse();
        // 값이 없으면 기본값 사용
        String result = (String) Optional.ofNullable(null).orElse("기본값 사용");
        System.out.println(result);

        // isPresent();
        // 값이 있는지 boolean으로 판정하는 방법
        Optional<String> name5 = Optional.ofNullable("승민");

        if (name5.isPresent()) {
            System.out.println("이름이 있습니다.");
        }
    }
}
