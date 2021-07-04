/*
Tree Traversal

Medium

You are given a tree root and a list of strings moves consisting of "RIGHT", "LEFT" and "UP". Starting from root, traverse the tree by performing each move in moves where:

"RIGHT" means to traverse to the right child.
"LEFT" means to traverse to the left child.
"UP" means to traverse to its parent.
Return the value of the last node after all moves. You can assume that the moves are valid.

Constraints

n ≤ 100,000 where n is the number of nodes in root
Example 1
Input
Visualize
root =

            9
           / \
          1    8
              / \
             6   0
            / \
           3   2

moves = ["RIGHT", "RIGHT", "UP", "LEFT", "RIGHT"]
Output
2
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
    public int solve(Tree root, String[] moves) {
        int ans = 0,index=0;
        int n=moves.length;
        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        while (index<n) {
            if (moves[index].equals("RIGHT")) {
                stack.push(root.right);
                root=root.right;
            } else if(moves[index].equals("LEFT")) {
                stack.push(root.left);
                root=root.left;
            }
            else{
                stack.pop();
                root = stack.pop();
                stack.push(root);
            }
            index++;
        }
        return stack.pop().val;
    }
}