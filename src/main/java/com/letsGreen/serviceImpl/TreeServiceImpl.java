package com.letsGreen.serviceImpl;

import com.google.gson.Gson;
import com.letsGreen.domain.TreeDomain;
import com.letsGreen.entity.Tree;
import com.letsGreen.repository.TreeRepository;
import com.letsGreen.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

	private final Gson gson = new Gson();
	
	@Autowired
	private TreeRepository treeRepository;

	@Override
	public Tree getTreeById(Long id) {
		return treeRepository.findById(id).orElse(null);
	}

	@Override
	public List<Tree> getAllTrees() {
		return treeRepository.findAll();
	}

	@Override
	public void deleteTree(Long id) {
		treeRepository.deleteById(id);
	}

	@Override
	public Tree createTree(Tree tree) {
		return treeRepository.save(tree);
	}

	@Override
	public Tree updateTree(Long id, TreeDomain treeDomain) {

        Tree existingTree = treeRepository.findById(id).orElse(null);
        String jsonTree=gson.toJson(treeDomain);
    	
    	
        if (existingTree != null) {
            // Update fields
        	Tree tree = gson.fromJson(jsonTree, Tree.class);
        	tree.setId(existingTree.getId());
            return treeRepository.save(tree);
        }
        return null;
    
	}
}
