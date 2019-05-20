package com.jk.service.impl;

import com.jk.bean.Menu;
import com.jk.mapper.MenuMapper;
import com.jk.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenu() {
        return menuMapper.getMenu();
    }
}
