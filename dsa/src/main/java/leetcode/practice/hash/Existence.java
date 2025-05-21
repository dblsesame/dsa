package leetcode.practice.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Existence {
    /**
     * Leetcode 1832
     * @param sentence
     * @return
     */
    public boolean isPangram(String sentence){
        boolean ans = false;
        if (sentence.length() < 26 ) return ans;

        //add char to a set till it reach 26
    
        HashSet<Character> set = new HashSet<Character>();

        //iterate through the sentence and remove ch from the set as we go
        //stop when the set reach 0
        //sentence = sentence.toLowerCase();

        for(char c:sentence.toCharArray()){
            //if (Character.isLetter(c)) set.add(c);
            set.add(c);
            if (set.size() == 26) return true;
        }
        return ans;
    }

    public int getMissingNumber(int[] nums){
        int miss = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i <= nums.length; i++) {
            if(! set.contains(i)) return i;
        }

        return miss;
    }

    public int countPlusOne (int[] arr){
        int count =0;
        HashSet<Integer> set = new HashSet<>();
        for (int n:arr){
            //add n to the map. if n is in the map already, increase the occurances
            set.add(n);
        }
        for(int n:arr) {
            //check if n+1 is in the map
            if (set.contains(n+1)) count++;  

        }
        return count;
    }
    /**
     * 2225 Find Players with zero or one loss #medium
     * @param matches
     * @return
     */
    public  List<List<Integer>> findWinners(int[][] matches) {
        ArrayList<Integer> winners = new ArrayList<>();
        ArrayList<Integer> oneloss = new ArrayList<>();
        HashMap<Integer, Integer> scores = new HashMap<>();
        //find the number of times a player loses
        //iterate through matches
        for (int[] match:matches){
            //match = [winner:loser]
            scores.putIfAbsent(match[0], 0);
            scores.put(match[1], scores.getOrDefault(match[1], 0) + 1);
        }
        //now get the winners (zero loss) and one loss players
        //interate through scores
        for (Map.Entry<Integer,Integer> entry:scores.entrySet()) {
           if( entry.getValue() == 0) winners.add(entry.getKey());
           if( entry.getValue() == 1) oneloss.add(entry.getKey());
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        winners.sort(null);
        oneloss.sort(null);
        ans.add(winners);
        ans.add(oneloss);

        return ans;
    }
    /**
     * 1113 Largest Unique Number #easy
     * @param nums
     * @return
     */
    public int largestUniqueNumber(int[] nums) {
        int max=-1;
        HashMap<Integer, Integer> occurances = new HashMap<>();
        for (int n:nums){
            occurances.put(n, occurances.getOrDefault(n, 0)+1);
        }
        for (Map.Entry<Integer,Integer> entry:occurances.entrySet()) {
            if (entry.getValue() == 1) max = Math.max(max, entry.getKey());
        }
        return max;
    }
    /**
     *  1189 
     */
    public int maxNumberOfBalloons(String text) {
     //balloon 1a(0) 1b(1) 1n(2) 2l(3) 2o(4)
    int[] count = new int[5];
    
     for(int i=0;i<text.length(); i++) {
        char c = text.charAt(i);
        switch (c) {
            case 'a':
                count[0]++;
                break;
            case 'b':
                count[1]++;
                break;
            case 'l':
                count[2]++;
                break;
            case 'n':
                count[3]++;
                break;
            case 'o':
                count[4]++;
                break;
            default:
                break;
        }
     }   
     count[2] = count[2]/2;
     count[4] = count[4]/2;

     Arrays.sort(count);
     //the min of a b n l/2 o/2
     return count[0];
    }

    HashMap <Character, Integer> makeMap (String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        return map;
    }
    /**
     * 525 Continuous Array - medium
     * Find the longest continuous array of equal number of 0 and 1
     * -- why do I feel this is a sliding window question instead of hash
     * -- but it isn't - maybe this is why it is a medium
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int count = 0;
        int maxlen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1); //this I don't understsand
        //traverse the array, -1 for zeros, +1 for ones
        for (int i=0; i<nums.length; i++) {
            count = count + (nums[i]==0?-1:1);
            //put count into the hashmap
            if(map.containsKey(count)) {
                //calculate length -> i - val
                maxlen = Math.max(maxlen, i - map.get(count));
            }
            else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    /**
     * 49. Group Anagrams - medium
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //use sorted string as key for each group of anagrams
        HashMap<String, List<String>> map = new HashMap<>();
        //how to sort a string
        for (String s:strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key= String.valueOf(c);
            if(map.containsKey(key)){
                List<String> anagrams = map.get(key);
                anagrams.add(s);
            }
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }
    /**
     * 
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        HashSet<Character> jewelset = new HashSet<>();
        for(char j:jewels.toCharArray()){
            jewelset.add(j);
        }
        for(char s:stones.toCharArray()){
            if(jewelset.contains(s)) count++;
        }
        return count;
    }
    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxlen=0;
        HashSet<Character> appearedCharacters = new HashSet<>();
        for(int startc=0; startc < s.length(); startc++) {
            
            int endc=0;
            for (int i=startc; i<s.length(); i++) {
                char c =s.charAt(i);
                endc=i;
                if(appearedCharacters.contains(c)) {
                    //the substring ends here
                    endc--;
                    break;
                }
                appearedCharacters.add(c);
            }
            int length = endc-startc +1;
            maxlen = Math.max(maxlen, length);
            appearedCharacters.clear();
        }
        return maxlen;
    }

    /**
     * 2352. Equal Row and Column Pairs - medium
     */
}
