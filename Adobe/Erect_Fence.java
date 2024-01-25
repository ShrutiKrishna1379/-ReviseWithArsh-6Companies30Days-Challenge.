// https://leetcode.com/problems/erect-the-fence/

class Erect_Fence{
    public int[][] outerTrees(int[][] trees) {
        
        Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
	
		int n = trees.length;
		int[][] stack = new int[2*n][];
		int s = 0;

		for (int i = 0; i < n; i++) {
			while (s > 1 && cross(stack[s - 2], stack[s - 1], trees[i]) > 0) {
				s --;
			}
			stack[s++] = trees[i];
		}

		for (int i = n -2 ; i >= 0; i--) {
			while (s > 1 && cross(stack[s - 2], stack[s - 1], trees[i]) > 0) {
				s --;
			}
			stack[s++] = trees[i];
		}
	
		Arrays.sort(stack, 0 , s, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]));
		int m = 1;
		for (int i = 1; i < s; i ++) {
			if (stack[i][0] != stack[i-1][0] || stack[i][1] != stack[i-1][1]) {
				stack[m++] = stack[i];
			}
		}
		return Arrays.copyOf(stack, m);
	}

	public static int cross(int[] a, int[] b, int[] c) {
		return (b[1] - a[1])*(c[0] - b[0]) - (b[0] - a[0])*(c[1] - b[1]);
    }
}
