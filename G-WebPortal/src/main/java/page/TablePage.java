package page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TablePage {

    @RequestMapping(value = "FatherAndChild")
    public String FatherAndChild() {
        return "/table/FatherAndChild";
    }
}
