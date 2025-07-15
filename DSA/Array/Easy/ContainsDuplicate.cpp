class Solution
{
public:
    bool containsDuplicate(vector<int> &nums)
    {

        int n = nums.size();
        unordered_set<int> s(begin(nums), end(nums));
        int ns = s.size();
        if (n != ns)
            return true;
        return false;
    }
};

/*
217. Contains Duplicate
Easy

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
Accepted
2,030,765
Submissions
3,319,920
*/