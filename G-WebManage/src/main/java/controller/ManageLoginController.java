package controller;

import auxiliary.loginObject.GuaranteeAuthorization;
import com.alibaba.fastjson.JSON;
import communal.Result;
import communal.util.param.ParameterUtil;
import model.dto.manage.ManageLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.manageLogin.IManageLogin;
import sys.GlobalConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ManageLoginController {

    @Autowired
    private IManageLogin manageLogin;

    /**
     * 跳转到登陆页面
     * @return
     */
    @GetMapping(value = "/login")
    public String login() {
        return "/login";
    }

    /**
     * 登陆
     * @param account
     * @param pws
     * @param request
     * @return
     */
    @PostMapping(value = "/manageLogin")
    @ResponseBody
    public String manageLogin(String account, String pws, HttpServletRequest request) {

        ManageLoginDTO manageLoginDTO = new ManageLoginDTO();
        manageLoginDTO.setAccount(ParameterUtil.stringCheck(account, null));
        manageLoginDTO.setPws(ParameterUtil.stringCheck(pws, null));
        Result result = manageLoginDTO.checkDTO();
        if (!result.isSuccess()) {return JSON.toJSONString(result);}

        result = manageLogin.login(manageLoginDTO);
        if (result.isSuccess()) {
            HttpSession session = request.getSession();
            session.setAttribute(GlobalConstants.Manage_SessionObject, result.getData());
        }
        return JSON.toJSONString(result);
    }

    /**
     * 退出登陆
     * @param request
     * @return
     */
    @GetMapping(value = "/logOut")
    public String logOut(HttpServletRequest request) {

        request.getSession().removeAttribute(GlobalConstants.Manage_SessionObject);
        request.getSession().invalidate();
        return "login";
    }

    /**
     * 返回登陆用户菜单
     * @param request
     * @return
     */
    @GetMapping(value = "/manageMenu")
    @ResponseBody
    public String manageMenu(HttpServletRequest request) {

        HttpSession session = request.getSession();
        GuaranteeAuthorization guaranteeAuthorization =
                (GuaranteeAuthorization)session.getAttribute(GlobalConstants.Manage_SessionObject);

        return guaranteeAuthorization.getMenuList();
    }
}
