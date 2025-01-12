/*
 * package com.letsGreen.controller;
 * 
 * import com.letsGreen.entity.Tree; import com.letsGreen.service.TreeService;
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * import org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.MockitoAnnotations; import org.springframework.http.HttpStatus;
 * import org.springframework.http.ResponseEntity;
 * 
 * import java.util.Arrays; import java.util.List;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.mockito.ArgumentMatchers.any; import static
 * org.mockito.ArgumentMatchers.anyLong; import static org.mockito.Mockito.*;
 * 
 * class TreeControllerTest {
 * 
 * @Mock private TreeService treeService;
 * 
 * @InjectMocks private TreeController treeController;
 * 
 * private Tree tree;
 * 
 * @BeforeEach void setUp() { MockitoAnnotations.openMocks(this); tree = new
 * Tree(); tree.setId(1L); tree.setType("Oak"); tree.setName("Mighty Oak");
 * tree.setCost(100); // Initialize other fields if necessary }
 * 
 * @Test void testCreateTree() {
 * when(treeService.createTree(any(Tree.class))).thenReturn(tree);
 * 
 * ResponseEntity<String> response = treeController.createTree(tree);
 * 
 * assertEquals(HttpStatus.CREATED, response.getStatusCode());
 * assertEquals("Tree created with ID: " + tree.getId(), response.getBody());
 * verify(treeService, times(1)).createTree(any(Tree.class)); }
 * 
 * @Test void testGetTreeById() {
 * when(treeService.getTreeById(anyLong())).thenReturn(tree);
 * 
 * ResponseEntity<String> response = treeController.getTreeById(1L);
 * 
 * assertEquals(HttpStatus.OK, response.getStatusCode());
 * assertEquals("Tree found: " + tree.toString(), response.getBody());
 * verify(treeService, times(1)).getTreeById(anyLong()); }
 * 
 * @Test void testGetTreeByIdNotFound() {
 * when(treeService.getTreeById(anyLong())).thenReturn(null);
 * 
 * ResponseEntity<String> response = treeController.getTreeById(1L);
 * 
 * assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
 * assertEquals("Tree not found", response.getBody()); }
 * 
 * @Test void testGetAllTrees() { List<Tree> treeList = Arrays.asList(tree);
 * when(treeService.getAllTrees()).thenReturn(treeList);
 * 
 * ResponseEntity<String> response = treeController.getAllTrees();
 * 
 * assertEquals(HttpStatus.OK, response.getStatusCode());
 * assertEquals("All Trees: " + treeList.toString(), response.getBody());
 * verify(treeService, times(1)).getAllTrees(); }
 * 
 * @Test void testUpdateTree() { when(treeService.updateTree(anyLong(),
 * any(Tree.class))).thenReturn(tree);
 * 
 * ResponseEntity<String> response = treeController.updateTree(1L, tree);
 * 
 * assertEquals(HttpStatus.OK, response.getStatusCode());
 * assertEquals("Tree updated: " + tree.toString(), response.getBody());
 * verify(treeService, times(1)).updateTree(anyLong(), any(Tree.class)); }
 * 
 * @Test void testUpdateTreeNotFound() { when(treeService.updateTree(anyLong(),
 * any(Tree.class))).thenReturn(null);
 * 
 * ResponseEntity<String> response = treeController.updateTree(1L, tree);
 * 
 * assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
 * assertEquals("Tree not found", response.getBody()); }
 * 
 * @Test void testDeleteTree() {
 * doNothing().when(treeService).deleteTree(anyLong());
 * 
 * ResponseEntity<String> response = treeController.deleteTree(1L);
 * 
 * assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
 * assertEquals("Tree deleted", response.getBody()); verify(treeService,
 * times(1)).deleteTree(anyLong()); } }
 */