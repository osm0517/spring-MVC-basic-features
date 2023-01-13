package com.springMVC.basic;

import lombok.Data;

/**
 * 원래는 중간에 값이 바뀌는 것을 우려하여 setter를 사용하지 않는다고 함
 * 하지만 지금은 학습을 위한 프로젝트기도 하고,
 * 편의를 위해서 사용을 하도록 함
 */
@Data
public class HelloData {
    String username;
    int age;
}
