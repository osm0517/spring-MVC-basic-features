package com.springMVC.basic.controller.request;

import com.springMVC.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RequestModelController {

    /**
     * 요청 파라미터를 받을 때 @modelAttribute 라는 annotation 을 제공함
     * @param username
     * @param age
     * @return
     */
    @GetMapping("/request-model-v1")
    public String modelV1(
            @ModelAttribute String username,
            @ModelAttribute String age
    ){
        log.debug("username = {}, age = {}", username, age);
        return "ok";
    }

    /**
     * 요청으로 들어온 @modelAttribute는 사용자가 만든 객체도 바로 값을 넣어줌
     * @param data
     * @return
     */
    @GetMapping("/request-model-v2")
    public String modelV2(
            @ModelAttribute HelloData data
            ){
        log.debug("username = {}, age = {}", data.getUsername(), data.getAge());
        return "ok";
    }

    /**
     * 요청으로 들어온 @modelAttribute는 생략도 가능함
     * java 기본 타입이면 @RequestParam이 붙는 것
     * 사용자가 만든 타입이면 @ModelAttribute가 붙는 것
     * @param data
     * @return
     */
    @GetMapping("/request-model-v3")
    public String modelV3(
            HelloData data
    ){
        log.debug("username = {}, age = {}", data.getUsername(), data.getAge());
        return "ok";
    }
}
