package module.noncore.member.register;

import com.mapper.MemberMapper;
import model.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import communal.Result;

@Service("registerImpl")
public class RegisterImpl implements IRegister {

    @Autowired
    private MemberMapper memberMapper;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Result register(RegisterDTO registerDTO) {

/*        Member member = loginMapper.getLoginByAccount(registerDTO.getMobile());
        if (null != login) {
            return new Result(false, "账号已存在!");
        }

        Date nowDate = new Date();

        //登陆表
        {
            login.setName(registerDTO.getName());               //呢称
            login.setEmail(registerDTO.getEmail());             //邮箱
            login.setMobile(registerDTO.getMobile());           //手机号码
            login.setPws(registerDTO.getPassword());            //登陆密码
            login.setLoginLock(LoginContact.LOGIN_Lock_N);      //登陆锁, 默认不锁
            login.setRegisterTime(nowDate);                     //注册时间
            loginMapper.insertSelective(login);
        }

        //资金表
        {
            CapitalAccount capitalAccount = new CapitalAccount();
            capitalAccount.setMemberID(login.getMemberID());
            capitalAccount.setTotal(new BigDecimal(0));
            capitalAccount.setUseMoney(new BigDecimal(0));
            capitalAccount.setFreezeMoney(new BigDecimal(0));
            capitalAccount.setVersion(1L);
            capitalAccountMapper.insertSelective(capitalAccount);
        }

        //积分表
        {
            IntegralAccount integralAccount = new IntegralAccount();
            integralAccount.setMemberID(login.getMemberID());
            integralAccount.setTotal(new BigDecimal(0));
            integralAccount.setUseMoney(new BigDecimal(0));
            integralAccount.setFreezeMoney(new BigDecimal(0));
            integralAccount.setVersion(1L);
            integralAccountMapper.insertSelective(integralAccount);
        }

        //个人信表
        {

        }

        //安全信息表
        {

        }*/

        return new Result(true, "注册成功!", null);
    }
}
