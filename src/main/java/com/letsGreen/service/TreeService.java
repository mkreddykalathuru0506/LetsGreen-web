package com.letsGreen.service;

import java.util.List;

import com.letsGreen.domain.TreeDomain;
import com.letsGreen.entity.Tree;

public interface TreeService {
    Tree getTreeById(Long id);
    List<Tree> getAllTrees();
    Tree updateTree(Long id, TreeDomain treeDomain);
    void deleteTree(Long id);
	Tree createTree(Tree tree);
}
