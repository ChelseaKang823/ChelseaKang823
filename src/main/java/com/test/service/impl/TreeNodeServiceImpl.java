package com.test.service.impl;

import com.test.mapper.TreeNodeMapper;
import com.test.model.TreeNode;
import com.test.service.ITreeNodeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TreeNodeServiceImpl implements ITreeNodeService {
    @Autowired
    private TreeNodeMapper treeNodeMapper;
    @Override
    public List<TreeNode> createMenu(Integer parentId) {
        //找到所有的跟节点
        List<TreeNode> parent = treeNodeMapper.createMenu(parentId);
        if(null!=parent&&parent.size()>0){
            for (TreeNode t : parent) {
                if(t.getTreeNodeType()!=2){
                    List<TreeNode> children = createMenu(t.getTreeNodeId());
                    t.setChildren(children);
                }
            }
        }
        return parent;
    }

}
