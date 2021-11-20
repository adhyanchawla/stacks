import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class questions {
    
    public int[] NGOR(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        Arrays.fill(ans, n);

        for(int i = 0; i < n; i++) {
            while(st.getFirst() != -1 && arr[st.getFirst()] < arr[i]) {
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }

    public int[] NSOR(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        Arrays.fill(ans, n);

        for(int i = 0; i < n; i++) {
            while(st.getFirst() != -1 && arr[st.getFirst()] > arr[i]) {
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }

    public int[] NGOL(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        Arrays.fill(ans, -1);

        for(int i = n - 1; i >= 0; i--) {
            while(st.getFirst() != -1 && arr[st.getFirst()] < arr[i]) {
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }

    public int[] NSOL(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        Arrays.fill(ans, -1);

        for(int i = n - 1; i >= 0; i--) {
            while(st.getFirst() != -1 && arr[st.getFirst()] > arr[i]) {
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }

    //lc 503
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        
        Arrays.fill(ans, -1);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        
        for(int i = 0; i < 2 * n; i++) {
            while(st.getFirst() != -1 && arr[st.getFirst()] < arr[i % n]) {
                ans[st.removeFirst()] = arr[i % n];
            }
            
            st.addFirst(i % n);
        }
        
        return ans;
    }

    // https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1#
    public static int[] calculateSpan(int arr[], int n)
    {
        int[] ans = new int[n];
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        
        for(int i = 0; i < n; i++) {
            while(st.getFirst() != -1 && arr[st.getFirst()] <= arr[i]) {
                st.removeFirst();
            }
            
            ans[i] = i - st.getFirst();
            st.addFirst(i);
        }
        
        return ans;
        // Your code here
    }

    //lc 901
    class StockSpanner {
    
        int day = 0;
        LinkedList<int[]> st = new LinkedList<>();
        public StockSpanner() {
            // idx, val
            st.addFirst(new int[] {-1, -1});
        }
        
        public int next(int price) {
            while(st.getFirst()[0] != -1 && st.getFirst()[1] <= price) {
                st.removeFirst();
            }    
            
            int span = day - st.getFirst()[0];
            st.addFirst(new int[]{day++, price});
            return span;
        }
    }
    

    //lc 739
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        LinkedList<Integer>st = new LinkedList<>();
        st.addFirst(-1);
        for(int i = 0; i < n; i++) {
            while(st.getFirst() != -1 && arr[st.getFirst()] < arr[i]) {
                ans[st.getFirst()] = i - st.getFirst();
                st.removeFirst();
            }
            
            st.addFirst(i);
        }
        return ans;
    }

    //lc 20
    public boolean isValid(String s) {
        int n = s.length();
        LinkedList<Character>st = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch == '(') {
                st.addFirst(ch);
            } else {
                if(ch == '}') {
                    while(st.size() != 0 && st.getFirst() != '{') {
                        if(st.getFirst() == '(' || st.getFirst() == '[') {
                            return false;
                        } 
                        if(st.size() != 0)
                        st.removeFirst();
                    }
                    if(st.size() != 0 && st.getFirst() == '{')
                        st.removeFirst();
                    else return false;
                }
                else if(ch == ']') {
                    while(st.size() != 0 && st.getFirst() != '[') {
                        if(st.size() != 0 && st.getFirst() == '{' || st.getFirst() == '(') {
                            return false;
                        } 
                        if(st.size() != 0)
                        st.removeFirst();
                    }
                    if(st.size() != 0 && st.getFirst() == '[')
                        st.removeFirst();
                    else return false;
                }
                else if(ch == ')') {
                    while(st.size() != 0 && st.getFirst() != '(') {
                        if(st.getFirst() == '{' || st.getFirst() == '[') {
                            return false;
                        } 
                        if(st.size() != 0)
                        st.removeFirst();
                    }
                    if(st.size() != 0 && st.getFirst() == '(')
                        st.removeFirst();
                    else return false;
                }
            }
        }
        return st.size() == 0;
    }

    //lc 735 Astroid Collission

    public int[] asteroidCollision(int[] arr) {
        int n = arr.length;
        LinkedList<Integer>st = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                st.addFirst(arr[i]);
            }
            
            while(st.size() != 0 && st.getFirst() > 0 && st.getFirst() < -arr[i]) {
                st.removeFirst();
            }
            
            if(st.size() != 0 && st.getFirst() == -arr[i]) st.removeFirst();
            
            else if(st.size() == 0 || st.getFirst() < 0) st.addFirst(arr[i]);
        }
        
        int[] ans = new int[st.size()];
        int c = 0;
        while(st.size() != 0) {
            ans[c++] = st.removeLast();
        }
        
        return ans;
    }

    //lc 946
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int idx = 0;
        int n = pushed.length;
        LinkedList<Integer>st = new LinkedList<>();
        for(int ele : pushed) {
            st.addFirst(ele);
            
            while(st.size() != 0 && st.getFirst() == popped[idx]) {
                st.removeFirst();
                idx++;
            }
        }
        
        return st.size() == 0;
    }

    //lc 856
    public int scoreOfParentheses(String s) {
        int n = s.length();
        LinkedList<Integer>st = new LinkedList<>();
        st.addFirst(0);
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.addFirst(0);
            } else {
                int a = st.removeFirst();
                int b = st.removeFirst();
                
                int val = b + Math.max(2 * a, 1);
                st.addFirst(val);
            }
        }
        return st.removeFirst();
    }

    //lc 921
    public int minAddToMakeValid(String s) {
        int n = s.length();
        LinkedList<Character>st = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.addFirst(ch);
            } else {
                while(st.size() != 0 && st.getFirst() != '(') {
                    st.removeFirst();
                }
                
                if(st.size() != 0 && st.getFirst() == '(') {
                    st.removeFirst();
                } else count++;
            }
        }
        
        return st.size() + count;
    }

    // 84
    //7n
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        //nsor
        int[] ans1 = new int[n];
        Arrays.fill(ans1, n);
        
        LinkedList<Integer>st1 = new LinkedList<>();
        st1.addFirst(-1);
        
        for(int i = 0; i < n; i++) {
            while(st1.getFirst() != -1 && heights[st1.getFirst()] > heights[i]) {
                ans1[st1.removeFirst()] = i;
            }
            
            st1.addFirst(i);
        }
        
        //nsol
        int[] ans2 = new int[n];
        Arrays.fill(ans2, -1);
        
        LinkedList<Integer>st2 = new LinkedList<>();
        st2.addFirst(-1);
        
        for(int i = n - 1; i >= 0; i--) {
            while(st2.getFirst() != -1 && heights[st2.getFirst()] > heights[i]) {
                ans2[st2.removeFirst()] = i;
            }
            
            st2.addFirst(i);
        }
        
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (ans1[i] - ans2[i] - 1));
        }
        
        return maxArea;
    }

    //2n
    public int largestRectangleArea_01(int[] heights) {
        LinkedList<Integer>st = new LinkedList<>();
        st.addFirst(-1);
        int maxArea = 0, n = heights.length;
        
        for(int i = 0; i < n; i++) {
            while(st.getFirst() != -1 && heights[st.getFirst()] > heights[i]) {
                int h = heights[st.removeFirst()];
                int w = i - st.getFirst() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            
            st.addFirst(i);
        }
        
        while(st.getFirst() != -1) {
                int h = heights[st.removeFirst()];
                int w = n - st.getFirst() - 1;
                maxArea = Math.max(maxArea, h * w);
        }
        
        return maxArea;       
    }

    //85
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        
        int[] height = new int[m];
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }
        return maxArea;
    }

    //32
    public int longestValidParentheses(String s) {
        int n = s.length();
        LinkedList<Integer>st = new LinkedList<>();
        st.addFirst(-1);
        int max = 0;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == ')' && st.getFirst() != -1 && s.charAt(st.getFirst()) == '(') {
                st.removeFirst();
                max = Math.max(max, i - st.getFirst());
            }
            else st.addFirst(i);
        }
        return max;
    }

    //lc 402
    public String removeKdigits(String s, int k) {
        
        int n = s.length();
        ArrayList<Character>st = new ArrayList<>();
    
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
        while(st.size() != 0 && st.get(st.size() - 1) > ch && k > 0) {
            st.remove(st.size() - 1);
                k--;
            }
            st.add(ch);
        }
        
        while(k-- != 0) {
            st.remove(st.size() - 1);
        }
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(Character ch : st) {
            if(ch == '0' && !flag) continue;
            flag = true;
            sb.append(ch);
        }
        
        String ans = sb.length() != 0 ? sb.toString() : "0";
        return ans;
        
    }

    //316, 1081
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        
        int[] freq = new int[26];
        
        for(int i = 0; i < n; i++) freq[s.charAt(i) - 'a']++;
        
        boolean[] vis = new boolean[26];
        LinkedList<Character>st = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if(vis[ch - 'a']) continue;
            
            while(st.size() != 0 && st.getFirst() > ch && freq[st.getFirst() - 'a'] > 0) {
                vis[st.getFirst() - 'a'] = false;
                st.removeFirst();
            }
            
            vis[ch - 'a'] = true;
            st.addFirst(ch);   
            

        }
        
        StringBuilder ans = new StringBuilder();
        while(st.size() != 0) {
            ans.append(st.removeLast()); 
        }
        return ans.toString();
    }

    //1249
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        LinkedList<Integer>st = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.addFirst(i);
            } else if(ch == ')') {
                if(st.size() > 0 && s.charAt(st.getFirst()) == '(') {
                    st.removeFirst();
                } else if(st.size() > 0 && s.charAt(st.getFirst()) == ')') {
                    st.addFirst(i);
                } else if(st.size() == 0) {
                    st.addFirst(i);
                } 
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(st.size() > 0 && st.getLast() == i) {
                st.removeLast();
                continue;
            }
            
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }

    //895
    class FreqStack {
    
        private PriorityQueue<pair>pq;
        private HashMap<Integer, Integer> map;
        private int idx = 0;
        
        public class pair implements Comparable<pair>{
            int val = 0;
            int idx = 0;
            int freq = 0;
            
            pair(int val, int idx, int freq) {
                this.val = val;
                this.idx = idx;
                this.freq = freq;
            }
            
            public int compareTo(pair o) {
                if(this.freq == o.freq)
                return o.idx - this.idx;
                else return o.freq - this.freq;
            }
        }
        
        public FreqStack() {
            pq = new PriorityQueue<>();
            map = new HashMap<>();
        }
        
        public void push(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            pq.add(new pair(val, idx++, map.get(val)));
        }
        
        public int pop() {
            pair rp = pq.remove();
            map.put(rp.val, map.get(rp.val) - 1);
            if(map.get(rp.val) == 0) {
                map.remove(rp.val);
            }
            return rp.val;
        }
    }

    class FreqStack_ {

        private ArrayList<LinkedList<Integer>> freqMap;
             private HashMap<Integer, Integer> map;
             private int maxFreq = 0;
     
             public FreqStack_() {
                 freqMap = new ArrayList<>();
                 map = new HashMap<>();
     
                 freqMap.add(new LinkedList<>());
             }
     
             public void push(int val) {
                 map.put(val, map.getOrDefault(val, 0) + 1);
                 maxFreq = Math.max(maxFreq, map.get(val));
     
                 if (maxFreq == freqMap.size())
                     freqMap.add(new LinkedList<>());
     
                 freqMap.get(map.get(val)).addFirst(val);
             }
     
             public int pop() {
                 int rv = freqMap.get(maxFreq).removeFirst();
                 if (freqMap.get(maxFreq).size() == 0) {
                     freqMap.remove(maxFreq--);
                 }
     
                 map.put(rv, map.get(rv) - 1);
                 if (map.get(rv) == 0)
                     map.remove(rv);
     
                 return rv;
             }
     }

     //155
     class MinStack {
    
        private LinkedList<Long>st;
        private long minSoFar = 0;
        
        public MinStack() {
            st = new LinkedList<>();
        }
        
        public void push(int val) {
            long x = val;
            if(st.size() == 0) {
                st.addFirst(x);
                minSoFar = x;
                return;
            }
            
            if(x < minSoFar) {
                st.addFirst(2 * x - minSoFar);
                minSoFar = x;
            } else {
                st.addFirst(x);
            }
        }
        
        public void pop() {
            if(st.getFirst() < minSoFar) {
                minSoFar = 2 * minSoFar - st.getFirst();
            }
            st.removeFirst();
        }
        
        public int top() {
            if(st.getFirst() < minSoFar) {
                return (int)minSoFar;
            }
            
            return (int)(long)st.getFirst();
        }
        
        public int getMin() {
            return (int)minSoFar;
        }
    }
     

}
