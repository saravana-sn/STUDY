int Search(vector<int> a, int K)
{

    int low = 0;
    int high = a.size() - 1;
    while (low <= high)
    {
        int mid = (high - low) / 2 + low;
        if (a[mid] == K)
            return mid;
        if (a[low] < a[mid])
        {
            if (a[mid] > K && a[low] <= K)
                high = mid - 1;
            else
                low = mid + 1;
        }
        else
        {
            if (a[mid] < K && a[high] >= K)
                low = mid + 1;
            else
                high = mid - 1;
        }
    }
    return -1;
}

/*
Search an element in sorted and rotated array
EasyAccuracy: 50.0%Submissions: 29437Points: 2
Given a sorted and rotated array A of N distinct elements which are rotated at some point, and given an element K. The task is to find the index of the given element K in array A.

Example 1:

Input:
N = 9
A[] = {5,6,7,8,9,10,1,2,3}
K = 10
Output: 5
Explanation: 10 is found at index 5.
Example 1:

Input:
N = 3
A[] = {3,1,2}
K = 1
Output: 1
User Task:
Complete Search() function and return the index of the element K if found in the array. If the element is not present, then return -1.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 107
0 ≤ Ai ≤ 108
1 ≤ K ≤ 108
*/