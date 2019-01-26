package com.mapper;

import com.MyMapper;
import model.entity.Resources;
import model.entity.RoleEmployee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleEmployeeMapper {

    /**
     * 根据员工ID返回角色ID列表
     * @return
     */
    List<Integer> getRoleIDSForEmployeeID(@Param("employeeID")Long employeeID);
}
