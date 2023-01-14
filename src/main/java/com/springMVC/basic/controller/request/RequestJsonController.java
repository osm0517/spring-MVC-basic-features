package com.springMVC.basic.controller.request;

import com.springMVC.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RequestJsonController {

    /**
     * request data type 으로 json 을 받을 때에도 text 를 받는 것과 비슷하다.
     * 하지만 반드시 요청하는 쪽에서
     * header 정보에 Content-type 이 application/json 이여야함
     * @param helloData
     * @return
     */
    @PostMapping("/request-body-json-v1")
    public String jsonV1(
            @RequestBody HelloData helloData
    ){
        log.debug("helloData = {}", helloData);
        return "ok";
    }

    /**
     * return type 을 ResponseEntity 를 사용하면 message body 와
     * httpStatusCode 도 동적으로 설정해서 넘겨줄 수 있음
     * @param helloData
     * @return
     */
    @PostMapping("/request-body-json-v2")
    public ResponseEntity<String> jsonV2(
            @RequestBody HelloData helloData
    ){
        log.debug("helloData = {}", helloData);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    /**
     * return type 을 ResponseEntity 를 사용하지 않고
     * httpStatusCode 를 설정해주려면 @ResponseStatus 를 사용한다.
     * 하지만 해당 annotation 은 정적으로 설정밖에 못해준다.
     * @param helloData
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/request-body-json-v3")
    public String jsonV3(
            @RequestBody HelloData helloData
    ){
        log.debug("helloData = {}", helloData);
        return "ok";
    }
}
