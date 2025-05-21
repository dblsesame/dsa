package leetcode.practice.stack;

import java.util.Stack;

public class StackSolution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        if (! path.endsWith("/")) {
            path = path + "/";
        }
        for (char c:path.toCharArray()) {
            if (c == '/') {
                if (sb.length() == 0 || sb.charAt(sb.length()-1) != '/') { //skip the consecutive '/'
                    // . and .. are special cases
                    // ..
                    if (sb.length() > 1 && sb.charAt(sb.length()-1) == '.' && sb.charAt(sb.length()-2) == '.')  {
                        //but check for ... case as well
                        if (sb.length() > 2 && sb.charAt(sb.length()-3) != '/') {
                            sb.append(c);
                        } else {
                            //remove the last 3 characters
                            sb.deleteCharAt(sb.length()-1);
                            sb.deleteCharAt(sb.length()-1);
                            if(sb.length()!=1) sb.deleteCharAt(sb.length()-1);
                            
                            //remove the last directory
                            while (sb.length() > 0 && sb.charAt(sb.length()-1) != '/') {
                                sb.deleteCharAt(sb.length()-1);
                            }
                            
                            //remove the last directory
                            while (sb.length() > 0 && sb.charAt(sb.length()-1) != '/') {
                                sb.deleteCharAt(sb.length()-1);
                            }
                        }

                    } else if (sb.length() > 0 && sb.charAt(sb.length()-1) == '.') {
                        //only remove the last character if the previous character is a '/'
                        if (sb.length() > 1 && sb.charAt(sb.length()-2) == '/') {
                            sb.deleteCharAt(sb.length()-1);
                        }
                        else {
                            sb.append(c);
                        }
                    } else {
                        sb.append(c);
                    }
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 1 && sb.charAt(sb.length()-1) == '.') {
            //remove the last character
            sb.deleteCharAt(sb.length()-1);
        }
        if (sb.length() > 1 && sb.charAt(sb.length()-1) == '/') {
            //remove the last character
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }
    /**
     * Leetcode 1544. Make The String Great (Easy)
     * Given a string s of lower and upper case English letters.
     * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
     * 0 <= i <= s.length - 2
     * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
     * To make the string good, you can choose two adjacent characters that make the string bad and remove them.
     * You can keep doing this until the string becomes good.
     * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
     * Notice that an empty string is also good.
     * Example 1:
     * Input: s = "leEeetcode"
     * Output: "leetcode"
     * Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leetcode".
     * Example 2:
     * @param s
     * @return
     */
    public String makeGood(String s) {
        String sol = "";
        if(s.length() > 1) {
            Stack<Character> stack = new Stack<>();
            for (char c:s.toCharArray()) {
                if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            //convert stack to string fixed size char improved memory usage
            //compared to string concatenation
            char[] arr = new char[stack.size()];
            int i = 0;
            for(char c:stack) {
                arr[i] = c;
                i++;
            }
            sol = new String(arr);
        }
        return sol;
    }
}
