/*Input: n = 6, delay = 2, forget = 4
Output: 5
Explanation:
Day 1: Suppose the first person is named A. (1 person)
Day 2: A is the only person who knows the secret. (1 person)
Day 3: A shares the secret with a new person, B. (2 people)
Day 4: A shares the secret with a new person, C. (3 people)
Day 5: A forgets the secret, and B shares the secret with a new person, D. (3 people)
Day 6: B shares the secret with E, and C shares the secret with F. (5 people) */


class  People_aware_secret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] t= new long[n + 1];
        t[1] = 1;
        long c= 0;

        for(int i = 2; i < t.length; i++) {
        
            if (i-forget> 0){
                c-=t[i - forget];
            }

            if (i-delay> 0) {
                c+= t[i - delay];
            }

            t[i] = c%1000000007;
        }

        long ans = 0;
        for(int i = n - forget + 1; i < t.length; i++) {
            ans += t[i];
        }

        return (int) (ans % 1000000007);
    }
}