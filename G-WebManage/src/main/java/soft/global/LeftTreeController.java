package soft.global;

import model.vo.MenuTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LeftTreeController {

/*    @Autowired
    private IMenuTree leftTree;

    @GetMapping(value = "getMenuList")
    @ResponseBody
    public List<MenuTreeNode> getMenuList(HttpServletRequest request) {
        return leftTree.getMenuTree();
    }*/
}
