/*Binary Search Tree Validation
Medium

Given a binary tree root, return whether it's a binary search tree. A binary tree node is a binary search tree if :

All nodes on its left subtree are smaller than node.val
All nodes on its right subtree are bigger than node.val
All nodes hold the these properties.
Constraint

n ≤ 100,000 where n is the number of nodes in root
Example 1
Input
Visualize
root =
            3
           / \
          2   9
             / \
            7   12
           / \
          4   8

Output
true
Example 2
Input
Visualize
root =
            3
           / \
          1   5
             / \
            4   6
           / 
          7  

Output
false
Explanation
This is not a binary search tree because the 7 is not smaller than 5.
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
    public boolean Solution(Tree root, int min, int max) {
        if (root == null)
            return true;
        if (root.val >= min && root.val <= max && Solution(root.left, min, root.val)
            && Solution(root.right, root.val, max))
            return true;
        else
            return false;
    }
    public boolean solve(Tree root) {
        return Solution(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}