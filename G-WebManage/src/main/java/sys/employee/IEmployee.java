package sys.employee;

import communal.Result;
import model.dto.manage.EmployeeDTO;
import model.entity.Employee;

import java.util.List;

public interface IEmployee {

    /**
     * 保存
     * @param employee
     * @param handlerType
     * @return
     */
    Result save(Employee employee, String handlerType);

    /**
     * 删除
     * @param employeeID
     * @return
     */
    Result delete(Long employeeID);

    /**
     * 根据id返回查询
     * @param employeeID
     * @return
     */
    Result get(Long employeeID);

    /**
     * 分页
     * @param offset
     * @param limit
     * @param employeeDTO
     * @return
     */
    String pagination(Integer offset, Integer limit, EmployeeDTO employeeDTO);
}
