class Solution
{
public:
    int trap(vector<int> &height)
    {

        int l = 0, r = height.size() - 1;
        int lmax = 0, rmax = 0, wmax = 0;

        while (l <= r)
        {
            lmax = max(lmax, height[l]);
            rmax = max(rmax, height[r]);

            if (lmax < rmax)
            {
                wmax += (lmax - height[l]);
                l++;
            }
            else
            {
                wmax += (rmax - height[r]);
                r--;
            }
        }
        return wmax;
    }
};

/*
42. Trapping Rain Water
Hard

21826

293

Add to List

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
Accepted
1,280,031
Submissions
2,210,957
*/