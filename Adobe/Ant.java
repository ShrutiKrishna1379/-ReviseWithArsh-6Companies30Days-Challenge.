//Last Moment Before All Ants Fall Out of Plank

class Ant{
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < left.length; i++) {

            max = Math.max(max, left[i]);

        }

        for (int i = 0; i < right.length; i++) {

            max = Math.max(max, n - right[i]);

        }

        return max;
    }
}
