package com.java.bst.controller;

import java.util.ArrayList;
import java.util.LinkedList;

import com.java.bst.model.TreeNode;

public class BSTController {
	 ArrayList<LinkedList<Long>> result; //stores all unique sequence
	    TreeNode head;	
	    public TreeNode insert(TreeNode root, long val) {
	        if (root ==null) {
	            return new TreeNode(val);
	        }
	        if (root.val < val) {
	            root.right = insert(root.right,val);
	        } else {
	            root.left = insert(root.left,val);
	        }
	        return root;
	    }
	    
	    /*Return the children of a node */
	    ArrayList<TreeNode> getChilden(TreeNode parent) {
	        ArrayList<TreeNode> child = new ArrayList<TreeNode>();
	        if(parent.left != null) child.add(parent.left);
	        if(parent.right != null) child.add(parent.right);
	        return child;
	    }

	    void getPermutations(ArrayList<TreeNode> permutations, LinkedList<Long> current) {
	        if(permutations.size() == 0) {
	            result.add(current);
	            return;
	        }
	        int length = permutations.size();
	        for(int i = 0; i < length; i++) {
	            TreeNode node = permutations.get(i);
	            permutations.remove(i);
	            ArrayList<TreeNode> newPossibilities = new ArrayList<TreeNode>();
	            newPossibilities.addAll(permutations);
	            newPossibilities.addAll(getChilden(node));
	            LinkedList<Long> newCur = new LinkedList<Long>();
	            newCur.addAll(current);
	            newCur.add(node.val);
	            getPermutations(newPossibilities, newCur);
	            permutations.add(i,node);
	        }
	    }

	 
	    public ArrayList<LinkedList<Long>> inputSequencesForBst(TreeNode node) { 
	        result = new ArrayList<LinkedList<Long>>();
	        if(node == null)
	            return result;
	        ArrayList<TreeNode> permutations = getChilden(node);
	        LinkedList<Long> current = new LinkedList<Long>();
	        current.add(node.val);
	        getPermutations(permutations, current);
	        return result;
	    }
}
