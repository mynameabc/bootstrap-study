package controller;

import BaseFacilities.MQ.unit.notify.NotifyProducer;
import auxiliary.redis.RedisUtil;
import com.alibaba.fastjson.JSON;
import notify.NotifyContact;
import notify.SMSTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("notifyProducer")
    private NotifyProducer notifyProducer;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 后台管理首页
     * @return
     */
    @GetMapping(value = "index")
    public String index() {
        return "index";
    }

    /**
     * 登陆欢迎页
     * @return
     */
    @GetMapping(value = "welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/fanout")
    @ResponseBody
    public String fanout() {

        redisUtil.set("aaa", "总额");
        System.out.println(redisUtil.get("aaa"));

        Map parameterMap = new HashMap<String, String>();
        parameterMap.put("phone", "18569937167");
        parameterMap.put("time", "2018-10-26 07:30:23");
        parameterMap.put("money1", "10.0");
        parameterMap.put("money2", "11.0");  //返现
        parameterMap.put("money3", "12.0"); //总额

        notifyProducer.sms("13559193463", SMSTemplate.Recharge_SUCCESS_NOGive_Template, parameterMap);    //发送短信
        notifyProducer.appPush();

        List aaa = new ArrayList();
        aaa.add("a1");
        aaa.add("a2");
        aaa.add("a3");

        redisUtil.setList("xxx", aaa);

        List bbb = redisUtil.getList("xxx");

        System.out.println(bbb.get(0));
        System.out.println(bbb.get(1));
        System.out.println(bbb.get(2));

        return "";
    }

    @GetMapping(value = "topic")
    public void topic() {


    }
}
