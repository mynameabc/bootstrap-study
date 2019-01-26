package module.noncore.member.login;

import com.mapper.MemberMapper;
import model.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import communal.Result;

@Service("loginImpl")
public class LoginImpl implements ILogin {

    @Autowired
    private MemberMapper memberMapper;

    public Result login(LoginDTO loginDTO) {

/*        Member member = memberMapper.getLoginByAccount(loginDTO.getAccount());
        if (null == member) {
            return new Result(false, "账号不存在!");
        }

        if (!loginDTO.getPassword().equals(member.getPws())) {
            return new Result(false, "密码错误!");
        }*/

        return new Result(true, "登陆成功!");
    }
}
