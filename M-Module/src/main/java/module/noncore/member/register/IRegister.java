package module.noncore.member.register;

import communal.Result;
import model.dto.RegisterDTO;

public interface IRegister {

    /**
     * 会员账号注册
     * @param registerDTO
     * @return
     */
    public Result register(RegisterDTO registerDTO);
}
