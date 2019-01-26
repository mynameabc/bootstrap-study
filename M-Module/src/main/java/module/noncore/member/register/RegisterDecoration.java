package module.noncore.member.register;


import auxiliary.MemberInfo;
import model.dto.RegisterDTO;
import notify.LogContact;
import notify.NotifyContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import communal.Result;

@Service("registerDecoration")
public class RegisterDecoration implements IRegister {

    @Autowired
    @Qualifier("registerImpl")
    private IRegister registerImpl;

/*    @Autowired
    private LogProducer logProducer;

    @Autowired
    private NotifyProducer notifyProducer;*/

    @Transactional
    public Result register(RegisterDTO registerDTO) {

        return this.newMethod(registerDTO);
    }

    @Transactional
    public Result newMethod(RegisterDTO registerDTO) {

        Result result = registerImpl.register(registerDTO);
        if (result.isSuccess()) {
            this.otherMethod(result);
        }

        return result;
    }

    @Transactional
    public void otherMethod(Result result) {

        //写登陆日志
        {
//            logProducer.recordLog(LogContact.LOGINLOG, null);
        }

        //发送短信
        {
//            notifyProducer.newsNotify(1, NotifyContact.SMS_MODE, 1L, null);
        }

        //发送邮件
        {
//            notifyProducer.newsNotify(2, NotifyContact.EMAIL_MODE, 1L, null);
        }

        //填充用户信息
        MemberInfo memberInfo = new MemberInfo();
    }
}
