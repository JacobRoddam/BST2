package BSTClasses;

/**
 * 
 * @author Jacob Roddam
 * @author Emily Wiesler
 *
 * @param <E>
 * 
 * This class creates a binary search tree used to store comparables
 * using BSTNodes. Methods include those used to clear the tree, insert elements,
 * remove elements, delete the max elements, get the max element, find an element of
 * a certain value, get the size of the tree, get the number of leaf nodes, get the height,
 * and find the depth of a certain element.
 */
public class BST<E extends Comparable<? super E>> {
  private BSTNode<E> root; // Root of the BSTClasses.BST
  private int nodecount; // Number of nodes in the BSTClasses.BST

  // constructor
  BST() { root = null; nodecount = 0; }

  // Reinitialize tree
  public void clear() { root = null; nodecount = 0; }

  // Insert a record into the tree.
  // Records can be anything, but they must be Comparable
  // e: The record to insert.
  public void insert(E e) {
    root = inserthelp(root, e);
    nodecount++;
  }
  
  private BSTNode<E> inserthelp(BSTNode<E> rt, E value) {
	  if(rt == null) return new BSTNode<E>(value) ;
	  if (rt.value().compareTo(value) >= 0)
		  // rt value > key
		  rt.setLeft(inserthelp(rt.left(), value));
	  else // rt value <= leu
		  rt.setRight(inserthelp(rt.right(), value));
	  return rt;
  }

  // Remove a record from the tree
  // key: The key value of record to remove
  // Returns the record removed, null if there is none.
  public E remove(E key) {
    E temp = findhelp(root, key); // First find it
    if (temp != null) {
      root = removehelp(root, key); // Now remove it
      nodecount--;
    }
    return temp;
  }
  
  private BSTNode<E> removehelp(BSTNode<E> rt, E key) {
	  if (rt == null) return null;
	  if (rt.value().compareTo(key) > 0)
		  rt.setLeft(removehelp(rt.left(),key));
	  else if (rt.value().compareTo(key) < 0)
		  rt.setRight(removehelp(rt.right(), key));
	  else { // found it
		  if (rt.left() == null) return rt.right();
		  else if (rt.right() == null) return rt.left();
		  else { // two children
			  BSTNode<E> temp = getmax(rt.left());
			  rt.setValue(temp.value());
			  rt.setLeft(deletemax(rt.left()));
		  }
	  }
	  return rt;
  }
  
  private BSTNode<E> deletemax(BSTNode<E> rt){
	  if (rt.right() == null)  return rt.left();
	  rt.setRight(deletemax(rt.right()));
	  return rt;
  }
  
  private BSTNode<E> getmax(BSTNode<E> rt){
	  if (rt.right() == null) return rt;
	  return getmax(rt.right());  
  }

  // Return the record with key value k, null if none exists
  // key: The key value to find
  public E find(E key) { return findhelp(root, key); }

  private E findhelp(BSTNode<E> rt, E key) {
	  if(rt == null) return null;
	  if (rt.value().compareTo(key) > 0)
		  // rt value > key
		  return findhelp(rt.left(), key);
	  else if (rt.value().compareTo(key) == 0)
		  // rt value is key
		  return rt.value();
	  else return findhelp(rt.right(), key);
  }
  
  // Return the number of records in the dictionary
  public int size() { return nodecount; }

  /**
   * Count the number of leaf nodes in a tree
   * @return the count of leaf nodes
   */
  public int countLeafNodes() {
	  
	  
	  return countLeafNodesHelp(root);
  }
  
  /**
   * Helper method called by countLeafNodes()
   * @param rt the root of the tree subtree
   * @return the number of leaf nodes for the tree/subtree
   */
  private int countLeafNodesHelp(BSTNode<E> rt) {
	  if (rt == null) {
		  return 0;
	  }
	  else if (rt.right() == null && rt.left() == null) {
		  return 1;
	  }
	  else {
		  return countLeafNodesHelp(rt.left()) + countLeafNodesHelp(rt.right());
	  }
	  
  }
  
  /**
   * Compute tree height. The height of a tree is the length of
   * the longest path from the root to the deepest node.
   * The height of an empty tree (has no root) is -1. 
   * The height of a tree with a single node (has only a root) - no paths, is 0.
   * @return height of a tree
   */
  public int height() {

      return heightHelper(root);

  }

  /**
   * Helper method called by Height
   * @param root is the root of the tree/subtree in question
   * @return the height of the tree/subtree
   */
  protected int heightHelper ( BSTNode<E> root) {

      if (root == null) {return -1;}

      if (root.left() == null && root.right() == null) { return 0;}

      else { 

          int left = heightHelper(root.left());

          int right = heightHelper(root.right()); 

          if (left >= right) {return 1 + left;} 

          else {return 1 + right;}

      }

  }

  
  /** 
   * Given an E value, if the value is in the tree,
   * return the depth of the first occurrence of it you find,
   * or return -1
   * @param e the value searched for
   * @return the depth of e or -1 if e is not in the tree
   */
  public int depthOf(E e) {

      

      return depthOfHelper(root, e);

  }

  /**
   * Helper method for depthOf
   * @param root the root of the tree/subtree
   * @param e the value searched for
   * @return the depth of e in the tree/subtree or -1 if not in the tree
   */
  private int depthOfHelper(BSTNode<E> root, E e) {
	  
	  if (root == null) {
		  return -1;
	  }

      
	  else if(root.value().compareTo(e) == 0) return 0;

      else if (root.value().compareTo(e) > 0) {

          if (depthOfHelper(root.left(), e) == -1) {
        	  return -1;
          }
          
          else {

        	  return 1 + depthOfHelper(root.left(), e);
          }
      }

      else  {
    	  
    	  if (depthOfHelper(root.right(), e) == -1) {
    		  return -1;
    	  }
    	  
    	  else {
    		  return 1 + depthOfHelper(root.right(), e);
    	  }

      }
	  
  }
  
  
  
  
}
  
  
