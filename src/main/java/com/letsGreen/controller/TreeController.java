package com.letsGreen.controller;

import com.google.gson.Gson;
import com.letsGreen.domain.TreeDomain;
import com.letsGreen.entity.Tree;
import com.letsGreen.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tree")
public class TreeController {
	
	private final Gson gson = new Gson();

    @Autowired
    private TreeService treeService;

    @PostMapping()
    public ResponseEntity<String> createTree(@RequestBody TreeDomain treeDomain) {
    	String jsonTree=gson.toJson(treeDomain);
    	Tree tree = gson.fromJson(jsonTree, Tree.class);
        Tree createdTree = treeService.createTree(tree);
        return new ResponseEntity<>("Tree created with ID: " + createdTree.getId(), HttpStatus.CREATED);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTreeById(@PathVariable Long id) {
    	System.out.println("******Inside get tree method*****");
    	
		 Tree tree = treeService.getTreeById(id); 
		 String jsonTree=gson.toJson(tree);
        if (tree != null) {
            return new ResponseEntity<>("Tree created: " + jsonTree, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tree not created", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllTrees() {
        List<Tree> trees = treeService.getAllTrees();
        String jsonTree=gson.toJson(trees);
        return new ResponseEntity<>("All Trees: " + jsonTree, HttpStatus.OK);
    }

    @PutMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateTree(@PathVariable Long id, @RequestBody TreeDomain treeDomain) {
        Tree updatedTree = treeService.updateTree(id, treeDomain);
        String jsonTree=gson.toJson(updatedTree);
        if (updatedTree != null) {
            return new ResponseEntity<>("Tree updated: " + jsonTree, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tree not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteTree(@PathVariable Long id) {
        treeService.deleteTree(id);
        return new ResponseEntity<>("Tree deleted", HttpStatus.NO_CONTENT);
    }
}
