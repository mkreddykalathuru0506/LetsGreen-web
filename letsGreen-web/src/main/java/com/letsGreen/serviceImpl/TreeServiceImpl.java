package com.letsGreen.serviceImpl;


import com.letsGreen.entity.Tree;
import com.letsGreen.repository.TreeRepository;
import com.letsGreen.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeRepository treeRepository;

    @Override
    public Tree createTree(Tree tree) {
        return treeRepository.save(tree);
    }

    @Override
    public Tree getTreeById(Long id) {
        return treeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tree> getAllTrees() {
        return treeRepository.findAll();
    }

    @Override
    public Tree updateTree(Long id, Tree tree) {
        Tree existingTree = treeRepository.findById(id).orElse(null);
        if (existingTree != null) {
            // Update fields
            existingTree.setName(tree.getName());
            // other fields
            return treeRepository.save(existingTree);
        }
        return null;
    }

    @Override
    public void deleteTree(Long id) {
        treeRepository.deleteById(id);
    }
}
