package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        HashMap<Integer, Character> indexMapChar = new HashMap<>();
        HashMap<Character, Integer> charMapIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (indexMapChar.containsValue(s.charAt(i))) {
                length = Math.max(length, indexMapChar.size());
                // 移除相同字母之前的数据
                remove(indexMapChar, charMapIndex, charMapIndex.get(s.charAt(i)));
            }
            indexMapChar.put(i, s.charAt(i));
            charMapIndex.put(s.charAt(i), i);
        }

        return Math.max(length, indexMapChar.size());
    }

    private void remove(HashMap<Integer, Character> indexMapChar, HashMap<Character, Integer> charMapIndex, int i) {
        while (indexMapChar.containsKey(i)) {
            charMapIndex.remove(indexMapChar.get(i));
            indexMapChar.remove(i);
            i--;
        }
    }
}
