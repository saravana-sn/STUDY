class Solution
{
public:
    int *findTwoElement(int *arr, int n)
    {

        int *res = new int[2];
        int ind = 0;
        for (int i = 0; i < n; i++)
        {
            ind = (arr[i]) % n;
            if (arr[ind] > n)
            {
                res[0] = arr[i] % n == 0 ? n : arr[i] % n;
            }
            else
                arr[ind] += n;
        }

        for (int i = 0; i < n; i++)
        {
            if (arr[i] <= n)
                res[1] = i == 0 ? n : i;
        }

        return res;
    }
};

/*
Find Missing And Repeating
MediumAccuracy: 37.77%Submissions: 100k+Points: 4
Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and
smallest positive missing number is 1.
Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and
smallest positive missing number is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findTwoElement() which takes the array of integers arr and n as parameters and returns an array of integers of size 2 denoting the answer ( The first index contains B and second index contains A.)

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ N
*/