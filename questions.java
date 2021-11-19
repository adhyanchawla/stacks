import java.util.LinkedList;
import java.util.Arrays;

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


}
