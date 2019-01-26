package model.vo;

import model.entity.Menu;

import java.util.List;

public class MenuTreeNode implements java.io.Serializable {

    private Menu menu;
    private List<MenuTreeNode> childrenList;

    public MenuTreeNode(Menu menu) {
        this.menu = menu;
    }

    public MenuTreeNode(Menu menu, List<MenuTreeNode> childrenList) {
        this.menu = menu;
        this.childrenList = childrenList;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<MenuTreeNode> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<MenuTreeNode> childrenList) {
        this.childrenList = childrenList;
    }
}
