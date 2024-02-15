

  class Destroying_Asteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        int n = asteroids.length;
        for (int i = 0; i <n; i++) {
            if (m >= asteroids[i]) {
                m += asteroids[i];
            } else {
                return false;
            }
        }
        return true;
    }
}
