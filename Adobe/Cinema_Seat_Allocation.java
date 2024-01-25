

class Cinema_Seat_Allocation{
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int[] res:reservedSeats)
            m.put(res[0], m.getOrDefault(res[0], 0) | 1 << res[1]);
        int ans = 0;
        for(int i:m.keySet())
        {
            int x = m.get(i);
            int count = 0;
            if((x&60)==0) count++;
            if((x&960)==0) count++;
            if((x&240)==0 && count==0) count=1;
            ans += count;
        }
        return ans + 2*(n-m.size());
    }
}
