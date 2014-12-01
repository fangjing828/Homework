package leetCode;

import java.util.ArrayList;
import java.util.List;

public class TreeDepth {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {val = x;}
	}
    public int maxDepth(TreeNode root) {
        int depth = 0;
        List<TreeNode> layers = new ArrayList<TreeNode>();
        
        if (root != null) {
            layers.add(root);
        }
        
        while (layers.size() > 0) {
        	depth ++;
        	
        	int max = layers.size();
        	while (max > 0) {
        		TreeNode node = layers.remove(0);
        		max --;
        		
        		if (node.right != null) {
        			layers.add(node.right);
        		} 
        		
        		if (node.left != null) {
        			layers.add(node.left);
        		}
        	}
        }
        
        return depth;
    }
}