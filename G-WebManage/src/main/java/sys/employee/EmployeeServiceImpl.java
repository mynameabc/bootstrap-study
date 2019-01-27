package sys.employee;

import auxiliary.redis.RedisUtil;
import communal.util.LogUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mapper.EmployeeMapper;
import communal.Result;
import model.dto.manage.EmployeeDTO;
import model.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import sys.employee.storage.ExtendEmployeeMapper;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployee {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ExtendEmployeeMapper employeeStorageMapper;

    private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    /**
     * 保存
     * @param employee
     * @param handlerType
     * @return
     */
    @Transactional
    public Result save(Employee employee, String handlerType) {

        try {
            int count = 0;
            String result = "员工保存成功!";
            if (handlerType.equals("add")) {
                employee.setCreateTime(new Date());
                count = employeeMapper.insertSelective(employee);
            } else if (handlerType.equals("edit")) {
                count = employeeMapper.updateByPrimaryKey(employee);
            }
            return new Result(true, result, employee);
        } catch (Exception e) {
            LogUtil.error(logger);
            return new Result(false, "机构员工失败:数据库异常!", employee);
        }
    }

    /**
     * 删除
     * @param employeeID
     * @return
     */
    @Transactional
    public Result delete(Long employeeID) {

        if (StringUtils.isEmpty(employeeID)) {
            return new Result(false, "id参数为空!");
        }

        Employee employee = null;
        {
            try {
                employee = employeeMapper.selectByPrimaryKey(employeeID);
            } catch (Exception e) {
                LogUtil.error(logger);
                return new Result(false, "员工删除失败:数据库异常!");
            }

            if (StringUtils.isEmpty(employee))
                return new Result(false, "该员工不存在!");
        }

        {
            try {
                employee.setDelFlag(false);
                employeeMapper.updateByPrimaryKeySelective(employee);
            } catch (Exception e) {
                LogUtil.error(logger);
                return new Result(false, "员工删除失败:数据库异常!");
            }
        }

        return new Result(true, "删除成功!");
    }

    /**
     * 根据id返回查询
     * @param employeeID
     * @return
     */
    public Result get(Long employeeID) {

        if (StringUtils.isEmpty(employeeID)) {
            return new Result(false, "id参数为空!");
        }

        Employee employee = null;
        try {
            employee = employeeMapper.selectByPrimaryKey(employeeID);
        } catch (Exception e) {
            LogUtil.error(logger);
            return new Result(false, "返回员工失败:数据库异常!");
        }

        if (null != employee) {
            return new Result(true, "查询成功!", employee);
        } else {
            return new Result(false, "没有找到相应记录!", employeeID);
        }
    }

    /**
     * 分页
     * @param offset
     * @param limit
     * @param employeeDTO
     * @return
     */
    /*
    public String pagination(Integer offset, Integer limit, EmployeeDTO employeeDTO) {

        PageHelper.offsetPage(offset, limit);
        Page<Employee> employeeList = null;
        try {
            Example example = new Example(Employee.class);
            Example.Criteria criteria = example.createCriteria();

            {
                //登陆呢称
                if (!StringUtils.isEmpty(employeeDTO.getName())) {criteria.andEqualTo("name",employeeDTO.getName());}

                //邮箱
                if (!StringUtils.isEmpty(employeeDTO.getEmail())) {criteria.andEqualTo("email",employeeDTO.getEmail());}

                //手机号码
                if (!StringUtils.isEmpty(employeeDTO.getMobile())) {criteria.andEqualTo("mobile",employeeDTO.getMobile());}

                //工号
                if (!StringUtils.isEmpty(employeeDTO.getJobNumber())) {criteria.andEqualTo("jobNumber",employeeDTO.getJobNumber());}

                //真实姓名
                if (!StringUtils.isEmpty(employeeDTO.getRealName())) {criteria.andEqualTo("realName",employeeDTO.getRealName());}

                //机构ID
                if (!StringUtils.isEmpty(employeeDTO.getOfficeID())) {criteria.andEqualTo("officeID",employeeDTO.getOfficeID());}

                //登陆锁
                if (employeeDTO.getLoginLock() != -1) {criteria.andEqualTo("loginLock",employeeDTO.getLoginLock());}

                //删除标识
                if (employeeDTO.getDelFlag() != -1) {criteria.andEqualTo("delFlag",employeeDTO.getDelFlag());}
            }

            example.orderBy("createTime");
            employeeList = (Page<Employee>)employeeMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.error(logger);
        }

        JSONObject result = new JSONObject();
        result.put("rows", ((null != employeeList) ? (employeeList.getResult()) : (null)));
        result.put("total", ((null != employeeList) ? (employeeList.getTotal()) : (null)));
        return result.toJSONString();
    }
*/

    public String pagination(Integer offset, Integer limit, EmployeeDTO employeeDTO) {

        List officeIDSList = null;
        if (null != employeeDTO.getOfficeID()) {
            officeIDSList = Arrays.asList(employeeDTO.getOfficeID().split(","));
        }

        PageHelper.offsetPage(offset, limit);
        Page<Employee> memberList =
                (Page<Employee>)employeeStorageMapper.getEmployeeList(employeeDTO, officeIDSList);

        JSONObject result = new JSONObject();
        result.put("rows", memberList.getResult());
        result.put("total", memberList.getTotal());
        return result.toJSONString();
    }
}
