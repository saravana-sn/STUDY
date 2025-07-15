class Solution
{
public:
    int longSubarrWthSumDivByK(int arr[], int n, int k)
    {
        // Complete the function
        int sum = 0;
        int length = 0;
        // k=3;
        int rem[k];
        fill(rem, rem + k, -2);
        rem[0] = -1;

        for (int i = 0; i < n; i++)
        {
            sum += arr[i];
            int r = sum % k;
            if (r < 0)
            {
                r = r + k;
            }

            if (rem[r] != -2)
            {
                int l = i - rem[r];
                if (l > length)
                {
                    length = l;
                }
            }
            else
            {
                rem[r] = i;
            }
        }

        return length;
    }
};

/*
Longest subarray with sum divisible by K
MediumAccuracy: 48.28%Submissions: 24463Points: 4
Given an array containing N integers and a positive integer K, find the length of the longest sub array with sum of the elements divisible by the given value K.

Example 1:

Input:
A[] = {2, 7, 6, 1, 4, 5}
K = 3
Output: 4
Explanation:The subarray is {7, 6, 1, 4}
with sum 18, which is divisible by 3.
Example 2:

Input:
A[] = {-2, 2, -5, 12, -11, -1, 7}
K = 3
Output: 5
Explanation:
The subarray is {2,-5,12,-11,-1} with
sum -3, which is divisible by 3.


Your Task:
The input is already taken care of by the driver code. You only need to complete the function longSubarrWthSumDivByK() that takes an array (arr), sizeOfArray (n), positive integer K, and return the length of the longest subarray which has sum divisible by K. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1<=N,K<=106
-105<=A[i]<=105
*/