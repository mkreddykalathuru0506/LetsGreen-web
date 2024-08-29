package com.letsGreen.serviceImpl;

import com.letsGreen.entity.Tree;
import com.letsGreen.repository.TreeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class TreeServiceImplTest {

    @Mock
    private TreeRepository treeRepository;

    @InjectMocks
    private TreeServiceImpl treeService;

    private Tree tree;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tree = new Tree();
        tree.setId(1L);
        tree.setName("Oak");
        // Initialize other fields as needed
    }

    @Test
    void testCreateTree() {
        when(treeRepository.save(any(Tree.class))).thenReturn(tree);

        Tree createdTree = treeService.createTree(tree);

        assertNotNull(createdTree);
        assertEquals(1L, createdTree.getId());
        assertEquals("Oak", createdTree.getName());
        // Assert other fields if needed
        verify(treeRepository, times(1)).save(any(Tree.class));
    }

    @Test
    void testGetTreeById() {
        when(treeRepository.findById(anyLong())).thenReturn(Optional.of(tree));

        Tree foundTree = treeService.getTreeById(1L);

        assertNotNull(foundTree);
        assertEquals(1L, foundTree.getId());
        assertEquals("Oak", foundTree.getName());
        // Assert other fields if needed
        verify(treeRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetTreeByIdNotFound() {
        when(treeRepository.findById(anyLong())).thenReturn(Optional.empty());

        Tree foundTree = treeService.getTreeById(1L);

        assertNull(foundTree);
        verify(treeRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetAllTrees() {
        List<Tree> trees = Arrays.asList(tree);
        when(treeRepository.findAll()).thenReturn(trees);

        List<Tree> allTrees = treeService.getAllTrees();

        assertNotNull(allTrees);
        assertEquals(1, allTrees.size());
        assertEquals(1L, allTrees.get(0).getId());
        assertEquals("Oak", allTrees.get(0).getName());
        verify(treeRepository, times(1)).findAll();
    }

    @Test
    void testUpdateTree() {
        Tree updatedTree = new Tree();
        updatedTree.setId(1L);
        updatedTree.setName("Pine");
        // Set other updated fields as needed

        when(treeRepository.findById(anyLong())).thenReturn(Optional.of(tree));
        when(treeRepository.save(any(Tree.class))).thenReturn(updatedTree);

        Tree result = treeService.updateTree(1L, updatedTree);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Pine", result.getName());
        // Assert other updated fields if needed
        verify(treeRepository, times(1)).findById(anyLong());
        verify(treeRepository, times(1)).save(any(Tree.class));
    }

    @Test
    void testUpdateTreeNotFound() {
        Tree updatedTree = new Tree();
        updatedTree.setId(1L);
        updatedTree.setName("Pine");
        // Set other updated fields as needed

        when(treeRepository.findById(anyLong())).thenReturn(Optional.empty());

        Tree result = treeService.updateTree(1L, updatedTree);

        assertNull(result);
        verify(treeRepository, times(1)).findById(anyLong());
        verify(treeRepository, never()).save(any(Tree.class));
    }

    @Test
    void testDeleteTree() {
        doNothing().when(treeRepository).deleteById(anyLong());

        treeService.deleteTree(1L);

        verify(treeRepository, times(1)).deleteById(anyLong());
    }
}
