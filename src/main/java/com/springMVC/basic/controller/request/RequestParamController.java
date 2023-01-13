package com.springMVC.basic.controller.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class RequestParamController {

    /**
     * RequestParam 을 사용하지 않으면 객체를 받아서 getParameter 를 이용해야돼서
     * 굉장히 불편함
     * @param request
     * @param response
     * @throws IOException
     */

    @PostMapping("/request-param-v1")
    public void requestV1(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}, age = {}", username, age);

        response.getWriter().write("ok");
    }

    /**
     * servlet 객체를 받아서 조회하는 것이 아닌 바로 값을 가져올 수 있음
     * 또한 parsing 을 진행하지 않아도 바로 변환도 가능
     * @param username
     * @param age
     * @return
     */
    @GetMapping("/request-param-v2")
    public String requestV2(
            @RequestParam("username") String username,
            @RequestParam("age") int age
    ){
        log.info("username = {}, age = {}", username, age);

        return "ok";
    }

    /**
     * 파라미터 명과 변수명이 동일하면 name 을 생략해도 됨
     * @param username
     * @param age
     * @return
     */
    @GetMapping("/request-param-v3")
    public String requestV3(
            @RequestParam String username,
            @RequestParam int age
    ){
        log.info("username = {}, age = {}", username, age);

        return "ok";
    }

    /**
     * RequestParam 을 생략해도 괜찮음
     * @param username
     * @param age
     * @return
     */
    @GetMapping("/request-param-v4")
    public String requestV4(
            String username,
            int age
    ){
        log.info("username = {}, age = {}", username, age);

        return "ok";
    }

    /**
     * required 를 통해서 필수로 필요한 값인지를 설정할 수 있음
     * defaultValue 를 통해서 값이 null 이거나 비었으면 채워줄 값을 설정할 수 있음
     * @param username
     * @param age
     * @return
     */
    @GetMapping("/request-param-attribute")
    public String requestAttribute(
            @RequestParam(defaultValue = "defaultName") String username,
            @RequestParam(required = false, defaultValue = "-1") int age
    ){
        log.info("username = {}, age = {}", username, age);

        return "ok";
    }
}
