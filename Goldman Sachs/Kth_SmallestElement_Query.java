
class Kth_SmallestElement_Query{
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length, j = 0;
        int[] t= new int[n];
        Map<Integer, String[][]> trimmed = new HashMap<>();
        for (int[] q : queries) {
            int k = q[0] - 1;
            int trim = q[1];
            if (!trimmed.containsKey(trim)) {
                String[][] arr = new String[nums.length][2];
                int i = 0;
                for (String num : nums) {
                    int sz = num.length();
                    arr[i] = new String[]{num.substring(sz - trim), "" + i++};
                }
                Arrays.sort(arr, Comparator.comparing(a -> a[0]));
                trimmed.put(trim, arr);
            }
            t[j++] = Integer.parseInt(trimmed.get(trim)[k][1]);
        }
        return t; 
    }
}

//https://leetcode.com/problems/query-kth-smallest-trimmed-number/
