package module.noncore.member.login;

import communal.Result;
import model.dto.LoginDTO;

public interface ILogin {

    /**
     * 登陆
     * @param loginDTO
     * @return
     */
    public Result login(LoginDTO loginDTO);
}
