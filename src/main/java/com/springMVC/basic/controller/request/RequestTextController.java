package com.springMVC.basic.controller.request;

import com.springMVC.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RequestTextController {

    /**
     * 또는 @RequestBody 어노테이션을 사용해서 받을 수 있음
     * 해당 어노테이션은 객체도 바로 받을 수도 있음
     * return type 으로 사용한 class는 response body와 status code도 설정할 수 있음
     * @param data
     * @return
     */
    @PostMapping("/request-text")
    public ResponseEntity<String> text(
            @RequestBody String data
    ){
        log.debug("data = {}", data);

        return new ResponseEntity<>("ok", HttpStatusCode.valueOf(200));
    }
}
