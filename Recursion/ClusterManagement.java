/*
Cluster Management
Medium

You are given two lists of integers cores and tasks. Each cores[i] represents the number of cores available in server i. And each tasks[i] represents the number of cores needed to run that task.

Each task can be run in only one server but each server can run multiple tasks. Return whether it's possible to run all the tasks with the given cores.

Constraints

n ≤ 15 where n is the length of cores
m ≤ 15 where m is the length of tasks
Example 1
Input
cores = [8, 10]
tasks = [2, 3, 3, 3, 7]
Output
true
Explanation
We can put tasks[0], tasks[1], and tasks[2] into cores[0] and the rest of the tasks into cores[1].

Example 2
Input
cores = [1, 3]
tasks = [2, 2]
Output
false
Explanation
There's no way to run the tasks on these servers.
*/

import java.util.*;

class Solution {
    public boolean solution(int[] core, int[] task, int index) {
        if (index == task.length) {
            return true;
        }
        for (int i = 0; i < core.length; i++) {
            if (core[i] - task[index] >= 0) {
                int tem1 = core[i];
                core[i] = core[i] - task[index];
                int tem2 = task[index];
                task[index] = 0;
                if (solution(core, task, index + 1)) {
                    return true;
                }
                core[i] = tem1;
                task[index] = tem2;
            }
        }

        return false;
    }
    public boolean solve(int[] cores, int[] tasks) {
        return solution(cores,tasks,0);
    }
}

