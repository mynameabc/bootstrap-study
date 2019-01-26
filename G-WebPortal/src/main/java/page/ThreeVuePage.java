package page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("three")
public class ThreeVuePage {

    @RequestMapping(value = "/lesson_1")
    public String lesson_1() {
        return "three/lesson_1";
    }

    @RequestMapping(value = "/lesson_2")
    public String lesson_2() {
        return "three/lesson_2";
    }

    @RequestMapping(value = "/lesson_3")
    public String lesson_3() {
        return "three/lesson_3";
    }

    @RequestMapping(value = "/lesson_4")
    public String lesson_4() {
        return "three/lesson_4";
    }

    @RequestMapping(value = "/lesson_5")
    public String lesson_5() {
        return "three/lesson_5";
    }

    @RequestMapping(value = "/lesson_6")
    public String lesson_6() {
        return "three/lesson_6";
    }
}
