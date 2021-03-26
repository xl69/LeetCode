1. 121 Best Time to Buy and Sell Stock

   ```java
   class Solution {
       public int maxProfit(int[] prices) {
           int min_element = Integer.MAX_VALUE;
           int max = 0;
           for (int i = 0; i < prices.length; i++) {
               if (prices[i] - min_element > max) {
                   max = prices[i] - min_element;
               }
               if (min_element > prices[i]) {
                   min_element =  prices[i];
               }
           }
           return max;
       }
   }
   ```

2. 141 Linked List Cycle

   Approach 1: Hash set

   ```java
   public class Solution {
       public boolean hasCycle(ListNode head) {
           HashSet<ListNode> visited = new HashSet<ListNode>();
           for (ListNode cur = head; cur != null; cur = cur.next) {
               if (visited.contains(cur)) {
                   return true;
               }
               visited.add(cur);
           }
           return false;
       }
   }
   ```

   Approach 2: Floyd's tortoise and hare algorithm

   ```java
   public class Solution {
       public boolean hasCycle(ListNode head) {
           ListNode fast = head;
           ListNode slow = head;
           
           while(fast != null && fast.next != null) {
               slow = slow.next;
               fast = fast.next.next;
               if (slow == fast) return true;
           }
           return false;
       }
   }
   ```

   

