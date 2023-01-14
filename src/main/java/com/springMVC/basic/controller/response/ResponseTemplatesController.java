package com.springMVC.basic.controller.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ResponseTemplatesController {

    /**
     * model 을 파라미터로 넘겨받아서 템플릿에 변수를 넘겨줄 수 있음.
     * 그리고 controller annotation 에 반환 타입이 String 이면 spring 이
     * view 를 찾아줌
     * @param model
     * @return
     */
    @GetMapping("/response-templates")
    public String responseV1(
            Model model
    ){
        log.debug("response static resource");

        model.addAttribute("data", "hello!!");

        return "hello";
    }

    /**
     * model 을 파라미터로 넘겨받아서 템플릿에 변수를 넘겨줄 수 있음.
     * 그리고 controller annotation 에 반환 타입이 void 이면 spring 이
     * mapping 정보에 value 값과 동일한 view 를 찾아줌
     * 하지만 이런 방법은 좋은 방법은 아닌 것 같음
     * @param model
     * @return
     */
    @GetMapping("/hello")
    public void responseV2(
            Model model
    ){
        log.debug("response static resource");

        model.addAttribute("data", "hello!!");
    }
}
