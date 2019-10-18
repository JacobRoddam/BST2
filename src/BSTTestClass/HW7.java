package BSTTestClass;

import BSTClasses.BST;

/**
 * 
 * @author Jacob Roddam
 * @author Emily Wiesler
 * 
 * This class tests our binary search tree class and the new methods we developed for it.
 *
 */
public class HW7 {

	public static void main(String[] args) {
		BST<Integer> tree = new BST<Integer>();
		
		System.out.println("Empty Tree:");
		
		System.out.println("Leaf nodes: " + tree.countLeafNodes());
		System.out.println("Height: " + tree.height());
		System.out.println("Depth of 1 (not in tree): " + tree.depthOf(1));
		
		System.out.println();
		
		System.out.println("Inserting nodes:");
		
		tree.insert(7);
		System.out.println("Leaf nodes: " + tree.countLeafNodes());
		
		tree.insert(3);
		System.out.println("Leaf nodes: " + tree.countLeafNodes());
		
		tree.insert(9);
		System.out.println("Leaf nodes: " + tree.countLeafNodes());
		
		System.out.println();
		
		tree.insert(8);

        tree.insert(4);

        tree.insert(2);

        tree.insert(12);

        tree.insert(10);
        
        System.out.println("Complete Tree. Height of 3, 4 leaf nodes: ");

        System.out.println("Height: " + tree.height());
        
        System.out.println("Leaf nodes: " + tree.countLeafNodes());
        
        System.out.println("Depth of 7(root): " + tree.depthOf(7));

        System.out.println("Depth of 9: " + tree.depthOf(9));
        
        System.out.println("Depth of 4: " + tree.depthOf(4));
        
        System.out.println("Depth of 10: " + tree.depthOf(10));
        
        System.out.println("Depth of 6 (not in tree): " + tree.depthOf(6));
		
		
		
		

	}

}
