package TwoSum;

import java.util.HashMap;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (temp.containsKey(other)) {
                return new int[]{temp.get(other), i};
            }
            temp.put(nums[i], i);
        }

        throw new IllegalArgumentException("argument illegal");
    }
}
