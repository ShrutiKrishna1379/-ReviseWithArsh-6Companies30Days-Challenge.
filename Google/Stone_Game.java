

class Stone_Game {

    public class Pair {
        int a,b;
        Pair() {
            a = b = 0;
        }
        Pair(int a,int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Pair[] p= new Pair[n];
        for (int i = 0; i < n; i++) {
            p[i] = new Pair(aliceValues[i],bobValues[i]);
        }
        Arrays.sort(p,new Comparator<Pair>() {
            public int compare(Pair p1,Pair p2) {
                return Integer.compare(p1.a + p1.b,p2.a + p2.b);
            }
        });
        int sum1 = 0;
        int sum2 = 0;
        int t= 0;
        for (int i = n - 1; i >= 0; i--) {
            if (t== 0) {
                sum1 += p[i].a;
            } else {
                sum2 += p[i].b;
            }
            t=1-t;
        }
        return Integer.compare(sum1,sum2);
    }
}
