package com.iris.dsa;

import java.util.*;

public class TargetTwoSum {
    public static void main(String[] args) {
        int [] array = {2,4,3,7,1,5};
        int target = 6;
        List<List<Integer>> subArraySum =  getSubArraySum_Optimal(array, target);
        System.out.println("Sub Arrays Sum is : " + subArraySum);
    }

    // Time Complexity O(n2)
    private static List<List<Integer>>  getSubArraySum_Brute(int [] array, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = array.length;
        for (int i = 0; i<n; i++) {
            for (int j = i ; j<n; j++) {
                if (array[i] + array[j] == target) {
                    List<Integer> temp = Arrays.asList(array[i], array[j]);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    // Time Complexity O(n) + 0(nlogn)
    //Space Complexity O(n)
    private static List<List<Integer>>  getSubArraySum_Better(int [] array, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<n; i++) {
          map.put(array[i], i);
        }
        List<Integer> duplicateCheck = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            int required = target - array[i];
            if (map.containsKey(required) && !duplicateCheck.contains(i)) {
                List<Integer> temp = Arrays.asList(array[i], array[map.get(required)]);
                ans.add(temp);
                duplicateCheck.add(i);
                duplicateCheck.add(map.get(required));
            }
        }
        return ans;
    }


    // Time Complexity O(n) + 0(nlogn)
    //No Space Complexity ,
    private static List<List<Integer>>  getSubArraySum_Optimal(int [] array, int target) {
        //Step 1 Sort the Array
        Arrays.sort(array);
        List<List<Integer>> ans = new ArrayList<>();
        int right = array.length-1;
        int left = 0;
        while (left <= right) {
            int sum = array[left] + array[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
               right--;
            } else {
                List<Integer> temp = Arrays.asList(array[left], array[right]);
                ans.add(temp);
                left++;
                right--;
             }

        }
        return ans;
    }
}
