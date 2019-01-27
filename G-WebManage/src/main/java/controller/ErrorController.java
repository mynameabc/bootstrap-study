package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    /**
     * 跳到404页面
     * @return
     */
    @GetMapping(value = "/404")
    public String Exception_404() {
        return "/error/404";
    }
}
