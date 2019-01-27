package sys.resources.permission;

import model.entity.Resources;

import java.util.List;
import java.util.stream.Collectors;

public class Permission {

    private List<Resources> menuList;
    private List<Resources> buttonList;

    public Permission(List<Resources> resourcesList) {

        menuList = resourcesList.stream().filter(object -> object.getType() == 1).collect(Collectors.toList());
        buttonList = resourcesList.stream().filter(object -> object.getType() == 2).collect(Collectors.toList());
    }

    public List<Resources> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Resources> menuList) {
        this.menuList = menuList;
    }

    public List<Resources> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<Resources> buttonList) {
        this.buttonList = buttonList;
    }
}
