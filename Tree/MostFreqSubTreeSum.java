/*
    Most Frequent Subtree Sum
Medium

Given a binary tree root, find the most frequent subtree sum. The subtree sum of a node is the sum of all values under a node, including the node itself. You can assume there is one unique solution.

Constraints

n ≤ 100,000 where n is the number of nodes in root
Example 1
Input
Visualize
root =
        5

    2      -5

Output
2
Explanation
2 occurs twice: once as the left leaf, and once as the sum of 2 + 5 - 5.
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
    public int frequent=0;
    public HashMap<Integer,Integer> map=new HashMap<>();

    public int solution(Tree root,int sum){
        if(root==null)
            return sum;
        sum+=solution(root.left,sum)+solution(root.right,sum)+root.val;
        
        map.put(sum,map.getOrDefault(sum,0)+1);
        if(map.get(sum)>map.getOrDefault(frequent,0))
            frequent=sum;

        return sum;
    }
    public int solve(Tree root) {
        solution(root,0);
        return frequent;
    }
}