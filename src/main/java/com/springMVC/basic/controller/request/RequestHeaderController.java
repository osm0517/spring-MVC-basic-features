package com.springMVC.basic.controller.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RequestHeaderController {

    /**
     * spring 은 controller 에 파라미터로 여러 가지 파라미터를
     * flexible 하게 받게 해줌.
     * @param request
     * @param response
     * @param cookie
     * @param headers
     * @return
     */

    @GetMapping("/header")
    public String headers(
            HttpServletRequest request,
            HttpServletResponse response,
            @CookieValue(value = "testCookie", required = false) String cookie,
            @RequestHeader MultiValueMap<String, String> headers
            ){

        log.info("request = {}", request);
        log.info("response = {}", response);
        log.info("cookie = {}", cookie);
        log.info("headers = {}", headers);

        return "ok";
    }
}
