package sys.employee.storage;

import model.dto.manage.EmployeeDTO;
import model.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtendEmployeeMapper {

    List<Employee> getEmployeeList(@Param("employeeDTO") EmployeeDTO employeeDTO, @Param("officeIDSList")List<String> officeIDSList);
}
