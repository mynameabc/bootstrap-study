package page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tow")
public class TwoVuePage {

    @RequestMapping(value = "/lesson_1")
    public String lesson_1() {
        return "tow/lesson_1";
    }

    @RequestMapping(value = "/lesson_2")
    public String lesson_2() {
        return "tow/lesson_2";
    }

    @RequestMapping(value = "/lesson_3")
    public String lesson_3() {
        return "tow/lesson_3";
    }

    @RequestMapping(value = "/lesson_4")
    public String lesson_4() {
        return "tow/lesson_4";
    }

    @RequestMapping(value = "/lesson_5")
    public String lesson_5() {
        return "tow/lesson_5";
    }

    @RequestMapping(value = "/lesson_6")
    public String lesson_6() {
        return "tow/lesson_6";
    }

    @RequestMapping(value = "/lesson_7")
    public String lesson_7() {
        return "tow/lesson_7";
    }

    @RequestMapping(value = "/lesson_8")
    public String lesson_8() {
        return "tow/lesson_8";
    }

    @RequestMapping(value = "/lesson_9")
    public String lesson_9() {
        return "tow/lesson_8";
    }
}
