class Solution
{
public:
    vector<vector<int>> overlappedInterval(vector<vector<int>> &intervals)
    {
        int n = intervals.size(), k = 0;
        vector<vector<int>> ans;
        sort(intervals.begin(), intervals.end());
        ans.push_back({intervals[0][0], intervals[0][1]});
        for (int i = 1; i < n; i++)
        {
            if (intervals[i][0] <= ans[k][1])
            {
                ans[k][1] = max(intervals[i][1], ans[k][1]);
            }
            else
            {
                ans.push_back({intervals[i][0], intervals[i][1]});
                k++;
            }
        }
        return ans;
    }
};

/*
Overlapping Intervals
MediumAccuracy: 51.7%Submissions: 23579Points: 4
Lamp
This problem is part of GFG SDE Sheet. Click here to view more.

Given a collection of Intervals, the task is to merge all of the overlapping Intervals.

Example 1:

Input:
Intervals = {{1,3},{2,4},{6,8},{9,10}}
Output: {{1, 4}, {6, 8}, {9, 10}}
Explanation: Given intervals: [1,3],[2,4]
[6,8],[9,10], we have only two overlapping
intervals here,[1,3] and [2,4]. Therefore
we will merge these two and return [1,4],
[6,8], [9,10].
Example 2:

Input:
Intervals = {{6,8},{1,9},{2,4},{4,7}}
Output: {{1, 9}}
Your Task:
Complete the function overlappedInterval() that takes the list N intervals as input parameters and returns sorted list of intervals after merging.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(Log(N)) or O(N).

Constraints:
1 ≤ N ≤ 100
0 ≤ x ≤ y ≤ 1000
*/