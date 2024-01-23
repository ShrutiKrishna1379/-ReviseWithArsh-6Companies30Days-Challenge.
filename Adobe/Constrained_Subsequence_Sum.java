
class Constrained_Subsequence_Sum {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;

        Deque<Integer> deque = new LinkedList<>();

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

			int max = Math.max(0, deque.isEmpty() ? 0 : nums[deque.peekFirst()]);

            nums[i] += max;

            ans = Math.max(ans, nums[i]);

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) { // If dp[i] >= deque.peekLast() -> Can discard the tail since it's useless

                deque.pollLast();

            }

            deque.addLast(i);

            if (i - deque.peekFirst() + 1 > k) { // remove the last element of range k

                deque.removeFirst();

            }

        }

        return ans;
    }
}
