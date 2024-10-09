package com.thealgorithms.datastructures.trees; 

/* Java program to perform the Boundary Traversal Binary tree
1: Initialise an empty array to store the boundary traversal nodes.
2: Create a helper function to check if a node is a leaf.Exclude the leaf nodes as they are added in leaf boundary.
3: Initialise a recursive function `addLeftBoundary` and store the left traversal.
4: Implement a recursive function `addLeafNodes` and store the bottom traversal.
5: Implement a recursive function `addRightBoundary` and store the right traversal.

Complexity Analysis:
Time complexity: O(n)
Space complexity: O(n)
where n is the number of nodes in Binary Tree.
*/
                  
import java.util.ArrayList;
import java.util.List;

// Node structure for the binary tree
class Node {
    int data;
    Node left;
    Node right;

// constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class BoundaryTraversal {
// To check if a node is leaf node
    boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    // Function to add the left boundary of the tree
    void addLeftBoundary(Node root, List<Integer> res) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

   // Function to add the right boundary of the tree
    void addRightBoundary(Node root, List<Integer> res) {
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; --i) {
            res.add(temp.get(i));
        }
    }

// Function to add leaf nodes
    void addLeaves(Node root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left, res);
        }
        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

 // Main function to perform the boundary traversal of the binary tree
    List<Integer> printBoundary(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeaf(root)) {
            res.add(root.data);
        }
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }
// function to print the order of boundary traversal
    void printResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* Creating a sample binary tree as follows:
		1
	       / \
	      2    3
	     /\    /\
	    4  5  6  7
	
	Binary Tree: 1 2 3 4 5 6 7
	Boundary Traversal: 1 2 4 5 6 7 3

	*/

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BoundaryTraversal solution = new BoundaryTraversal();

        // Get the boundary traversal
        List<Integer> result = solution.printBoundary(root);

        // Print the result
        System.out.print("Boundary Traversal: ");
        solution.printResult(result);
    }
}
                            
                        