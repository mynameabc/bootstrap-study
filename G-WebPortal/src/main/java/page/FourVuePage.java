package page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("four")
public class FourVuePage {

    @RequestMapping(value = "/lesson_1")
    public String lesson_1() {
        return "four/lesson_1";
    }

    @RequestMapping(value = "/lesson_2")
    public String lesson_2() {
        return "four/lesson_2";
    }

    @RequestMapping(value = "/lesson_3")
    public String lesson_3() {
        return "four/lesson_3";
    }

    @RequestMapping(value = "/lesson_4")
    public String lesson_4() {
        return "four/lesson_4";
    }
}
