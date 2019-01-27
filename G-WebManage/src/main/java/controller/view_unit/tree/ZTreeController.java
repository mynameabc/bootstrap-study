package controller.view_unit.tree;

import auxiliary.redis.RedisUtil;
import com.alibaba.fastjson.JSON;
import communal.util.param.ParameterUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

import model.vo.ZTreeNode;
import auxiliary.subassembly.tree.ztree.IZTree;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "ztree")
public class ZTreeController {

    @Autowired
    @Qualifier("officeZTreeImpl")
    private IZTree officeZTreeImpl;

    @Autowired
    @Qualifier("resourcesSelectProxyImpl")
    private IZTree resourcesSelectProxyImpl;

    @Autowired
    @Qualifier("areaZTreeImpl")
    private IZTree areaZTreeImpl;

    /**
     * 机构树形结构
     * @param request
     * @return
     */
    @GetMapping(value="getOfficeZTree")
    @ResponseBody
    public String getOfficeZTree(HttpServletRequest request) {
        List<ZTreeNode> zTreeNodeList = officeZTreeImpl.getTree(request.getParameter("id"));
        return JSON.toJSONString(zTreeNodeList);
    }

    /**
     * 资源树形结构
     * @param request
     * @return
     */
    @GetMapping(value="getResourcesZTree")
    @ResponseBody
    public String getResourcesZTree(HttpServletRequest request) {
        String id = request.getParameter("id");
        String roleID = ParameterUtil.stringCheck(request.getParameter("roleID"), null);
        String type = ParameterUtil.stringCheck(request.getParameter("type"), "ALL");
        List<ZTreeNode> zTreeNodeList = resourcesSelectProxyImpl.getTree(id, type, roleID);
        return JSON.toJSONString(zTreeNodeList);
    }
}
