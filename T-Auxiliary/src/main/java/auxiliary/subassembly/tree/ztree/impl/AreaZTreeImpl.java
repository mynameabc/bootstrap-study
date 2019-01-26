package auxiliary.subassembly.tree.ztree.impl;

import auxiliary.subassembly.tree.ztree.IZTree;
import communal.util.LogUtil;
import com.mapper.AreaMapper;
import model.entity.Area;
import model.vo.ZTreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("areaZTreeImpl")
public class AreaZTreeImpl implements IZTree {

    private static Logger logger = LoggerFactory.getLogger(AreaZTreeImpl.class);

    @Autowired
    private AreaMapper areaMapper;

    public List<ZTreeNode> getTree(String ... parameter) {

        List<Area> list = null;
        try {
            Example example = new Example(Area.class);
            example.orderBy("sort");
            list = areaMapper.selectByExample(example);
        } catch (Exception e) {
            LogUtil.error(logger);
        }

        List<Area> firstList = list.stream().filter(area -> area.getParentID().equals("0")).collect(Collectors.toList());
        List<Area> otherList = list.stream().filter(area -> ((!area.getParentID().equals("0")) &&  (!area.getParentID().equals("-1")))).collect(Collectors.toList());

        ZTreeNode node = null;
        List<ZTreeNode> treeNodeList = new ArrayList<>();
        for (Area area : firstList) {
            node = getNode(otherList, area);
            treeNodeList.add(node);
        }
        return treeNodeList;
    }

    private ZTreeNode getNode(List<Area> areaList, Area areaPar) {

        ZTreeNode node = this.setValues(areaPar);
        if (areaList.size() != 0) {
            List<ZTreeNode> zTreeNodeList = new ArrayList<>();
            List<Area> _tempList = areaList.stream().filter(area -> area.getParentID().equals(areaPar.getAreaID())).collect(Collectors.toList());
            for (Area area : _tempList) {
                zTreeNodeList.add(getNode(areaList, area));
            }

            if (zTreeNodeList.size() >= 1) {
                node.setChildren(zTreeNodeList);
            }

        } else {
            node.setChildren(null);
        }

        return node;
    }

    private ZTreeNode setValues(Area areaPar) {
        ZTreeNode node = new ZTreeNode();
        node.setId(Long.valueOf(areaPar.getAreaID()));
        node.setName(areaPar.getName());
        node.setpId(Long.valueOf(areaPar.getParentID()));
        return node;
    }
}
