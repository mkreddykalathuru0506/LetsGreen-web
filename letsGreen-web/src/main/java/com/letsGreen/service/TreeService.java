package com.letsGreen.service;

import com.letsGreen.entity.Tree;
import java.util.List;

public interface TreeService {
    Tree createTree(Tree tree);
    Tree getTreeById(Long id);
    List<Tree> getAllTrees();
    Tree updateTree(Long id, Tree tree);
    void deleteTree(Long id);
}
