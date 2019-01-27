package service.member.detailed.storage;

import com.MyMapper;
import model.dto.RechargeDTO;
import org.apache.ibatis.annotations.Param;
import service.member.detailed.storage.extend.RechargePagination;

import java.util.List;

public interface RechargeStorageMapper extends MyMapper<RechargePagination> {

    List<RechargePagination> getPaginationList(@Param("rechargeDTO")RechargeDTO rechargeDTO);

    List getList();
}
