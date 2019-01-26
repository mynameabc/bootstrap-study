package page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("element")
public class ElementPage {

    @RequestMapping(value = "/test1")
    public String test1() {
        return "element-ui/test1";
    }
}
