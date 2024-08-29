package com.letsGreen.controller;

import com.letsGreen.entity.Tree;
import com.letsGreen.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @PostMapping
    public ResponseEntity<String> createTree(@RequestBody Tree tree) {
        Tree createdTree = treeService.createTree(tree);
        return new ResponseEntity<>("Tree created with ID: " + createdTree.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTreeById(@PathVariable Long id) {
        Tree tree = treeService.getTreeById(id);
        if (tree != null) {
            return new ResponseEntity<>("Tree found: " + tree.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tree not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<String> getAllTrees() {
        List<Tree> trees = treeService.getAllTrees();
        return new ResponseEntity<>("All Trees: " + trees.toString(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTree(@PathVariable Long id, @RequestBody Tree tree) {
        Tree updatedTree = treeService.updateTree(id, tree);
        if (updatedTree != null) {
            return new ResponseEntity<>("Tree updated: " + updatedTree.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tree not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTree(@PathVariable Long id) {
        treeService.deleteTree(id);
        return new ResponseEntity<>("Tree deleted", HttpStatus.NO_CONTENT);
    }
}
