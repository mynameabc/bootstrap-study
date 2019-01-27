
import auxiliary.subassembly.tree.treeview.ITreeView;
import model.vo.TreeViewNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:ActiveMQ.xml", "classpath:spring-redis.xml", "classpath:persistent-MyBatis.xml"})
public class SpringMVCJUnit {

    @Autowired
    @Qualifier("officeTreeViewImpl")
    private ITreeView officeTreeViewImpl;

    @Test
    public void test() {

        List<TreeViewNode> officeTreeViewNode = officeTreeViewImpl.getTree();
        System.out.println(officeTreeViewNode.size());

    }
}
