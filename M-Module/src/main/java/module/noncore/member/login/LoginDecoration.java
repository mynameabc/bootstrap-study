package module.noncore.member.login;

import auxiliary.MemberInfo;
import communal.Result;
import model.dto.LoginDTO;
import notify.LogContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("loginDecoration")
public class LoginDecoration implements ILogin {

    @Autowired
    @Qualifier("loginImpl")
    private ILogin loginImpl;

/*    @Autowired
    private LogProducer logProducer;*/

    public Result login(LoginDTO loginDTO) {

        return this.newMethod(loginDTO);
    }

    public Result newMethod(LoginDTO loginDTO) {

        Result result = loginImpl.login(loginDTO);
        if (result.isSuccess()) {
            this.otherMethod();
        }

        return result;
    }

    public void otherMethod() {

        //写入登陆日志
        //写入登陆日
/*        logProducer.recordLog(LogContact.LOGINLOG, null);*/

        //填充用户信息
        MemberInfo memberInfo = null;
    }
}
