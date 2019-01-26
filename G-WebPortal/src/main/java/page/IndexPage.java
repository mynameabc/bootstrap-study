package page;

import module.test.ITest;
import module.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexPage {

    private ThreadLocal<String> t1 = new ThreadLocal<String>();

    @Autowired
    private ITest test;

    @RequestMapping(value = "/index")
    public String index() {

        if (null == t1.get()) {
            t1.set("1");
        }

        test.redisTransaction();

        return "index";
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }

    @GetMapping(value = "getDataList")
    @ResponseBody
    public List<Test> getDataList(int pageSize, int offset) {
        return test.getDataList();
    }

    @GetMapping(value = "getDataList2")
    @ResponseBody
    public List<Test> getDataList() {
        return test.getDataList();
    }

}
