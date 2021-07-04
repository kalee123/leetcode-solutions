/*
Convert to Full Binary Tree
Medium

Given a binary tree root, remove all nodes with only one child.

Constraints

n ≤ 100,000 where n is the number of nodes in root
Example 1
Input
Visualize
root =
                4

            3

        1

    0

2

Output
Visualize
        1
      /  \
    0      2
        

*/

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    
    public Tree Solution(Tree root){
        if(root==null)
            return root;
        root.left = Solution(root.left);
        root.right = Solution(root.right);
        if ((root.left != null && root.right != null) || (root.left==null&&root.right==null)) {
            return root;
        }
        Tree sub; 
        if(root.left != null){
            sub = root.left;
         }
         else
            sub = root.right;
        return sub;
       
    }
    public Tree solve(Tree root) {
        return Solution(root);
    }
}
