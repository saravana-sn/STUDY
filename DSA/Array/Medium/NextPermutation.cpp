class Solution
{
public:
    void nextPermutation(vector<int> &nums)
    {
        int n = size(nums), k, l;
        // for finding largest k such that nums[k]<nums[k+1]
        // traverse the array from the end
        for (int i = n - 2; i >= 0; i--)
        {
            if (nums[i] < nums[i + 1])
            {
                k = i;
                break;
            }
        }
        if (k < 0)
        { // for last permutation condition
            reverse(begin(nums), end(nums));
        }
        else
        {
            // for finding largest l such that nums[k]<nums[l]
            for (int i = n - 1; i > k; i--)
            {
                if (nums[k] < nums[i])
                {
                    l = i;
                    break;
                }
            }

            // swap elements at positions k and l
            swap(nums[k], nums[l]);

            // reverse the list from nums[k+1] to nums[n]
            reverse(begin(nums) + k + 1, end(nums));
        }
    }
};

/*
31. Next Permutation
Medium

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
Accepted
909,002
Submissions
2,460,417
*/