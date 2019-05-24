package com.jk.service;

import com.jk.mapper.TreeMapper;
import com.jk.bean.TreeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService{

    @Autowired
    TreeMapper treeMapper;


    @Override
    public List<TreeBean> findTreeList() {
        Integer id = 0;
        return queryTree(id);
    }
    private List<TreeBean> queryTree(Integer id) {
        List<TreeBean> trees = treeMapper.findTreeList(id);
        for (TreeBean treeBean : trees) {
            List<TreeBean> queryTree = queryTree(treeBean.getId());
            if (queryTree != null && queryTree.size() > 0) {
                treeBean.setNodes(queryTree);
                treeBean.setSelectable(false);
            } else {
                treeBean.setSelectable(true);
            }
        }
        return trees;
    }
}
