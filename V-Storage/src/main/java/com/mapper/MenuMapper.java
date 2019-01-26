package com.mapper;

import com.MyMapper;
import model.entity.Menu;

import java.util.List;

public interface MenuMapper extends MyMapper<Menu> {

    List<Menu> getMenuList();
}