package page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("one")
public class OneVuePage {

    @RequestMapping(value = "/lesson_1")
    public String lesson_1() {
        return "one/lesson_1";
    }

    @RequestMapping(value = "/lesson_2")
    public String lesson_2() {
        return "one/lesson_2";
    }

    @RequestMapping(value = "/lesson_3")
    public String lesson_3() {
        return "one/lesson_3";
    }

    @RequestMapping(value = "/lesson_4")
    public String lesson_4() {
        return "one/lesson_4";
    }

    @RequestMapping(value = "/lesson_5")
    public String lesson_5() {
        return "one/lesson_5";
    }

    @RequestMapping(value = "/lesson_6")
    public String lesson_6() {
        return "one/lesson_6";
    }

    @RequestMapping(value = "/lesson_7")
    public String lesson_7() {
        return "one/lesson_7";
    }

    @RequestMapping(value = "/lesson_8")
    public String lesson_8() {
        return "one/lesson_8";
    }
}
