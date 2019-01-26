package auxiliary.subassembly.tree.ztree.impl;

import auxiliary.subassembly.tree.ztree.IZTree;
import com.mapper.RoleResourcesMapper;
import communal.util.LogUtil;
import model.entity.Resources;
import model.vo.ZTreeNode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("resourcesSelectProxyImpl")
public class ResourcesSelectProxyImpl implements IZTree {

    private static Logger logger = LoggerFactory.getLogger(ResourcesSelectProxyImpl.class);

    @Autowired
    @Qualifier("resourcesZTreeImpl")
    private IZTree resourcesZTreeImpl;

    @Autowired
    private RoleResourcesMapper roleResourcesMapper;

    public List<ZTreeNode> getTree(String ... parameter) {

        List<ZTreeNode> list = resourcesZTreeImpl.getTree(parameter);
        List<Integer> integerList = null;

        {
            //如果roleID是空直接返回list
            if (StringUtils.isEmpty(parameter[2])) {
                return list;
            }

            //如果该角色没有权限直接返回list
            {
                int count = 0;
                try {
                    count = roleResourcesMapper.getCountForRoleID(Integer.valueOf(parameter[2]));
                } catch (Exception e) {
                    logger.error(e.toString());
                    return null;
                }

                if (count <= 0) {
                    return list;
                }
            }

            try {
                integerList = roleResourcesMapper.getResourcesIDSForRoleID(Integer.valueOf(parameter[2]));
            } catch (Exception e) {
                LogUtil.error(logger);
                return null;
            }
        }

        for (int resourcesID : integerList) {
            getNode(list, resourcesID);
        }

        return list;
    }

    private void getNode(List<ZTreeNode> list, int resourcesID) {

        if (list.size() != 0) {
            for (ZTreeNode _zTreeNode : list) {
                if (resourcesID == _zTreeNode.getId()) {_zTreeNode.setChecked(true);}
                if (null != _zTreeNode.getChildren()) {
                    getNode(_zTreeNode.getChildren(), resourcesID);
                }
            }
        }
    }
}
