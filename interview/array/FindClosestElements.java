 package interview.array;
/**
658. Find K Closest Elements
DescriptionHintsSubmissionsDiscussSolution
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104
*/
/*
Thoughts
Approach 1
Create Priority Queue with the size of k and with comparator a[i]-x
until size of k add the items then remove elements 

Approach 2:
Binary Search
start=0, end=array.length-1-k;
since the range of indicies would 0->k to array.length-1-k->array.length-1 ->this becomes the search space
we calculate mid=(start+end)/2
then compare if the abs|x-a[mid]|>abs|x-a[mid+k]| then start=mid+1 else end=mid-1

then we get the starting indices start
then from a[start]->a[start+k-1] would be the result
Time Complexity:O(nlogn)
Space :O(1)
*/
 public class FindClosestElements{
 public List<Integer> findClosestElements(int[] a, int k, int x) {
        int s=0,e=a.length-1-k;
        while(s<=e){
            int mid=(s+e)/2;
            if(Math.abs(x-a[mid])>Math.abs(x-a[mid+k]))
                s=mid+1;
            else e=mid-1;
        }
    List<Integer> res= new ArrayList<Integer>();
        for(int i=0;i<k;i++) res.add(a[s++]);
        return res;
            
    }
}