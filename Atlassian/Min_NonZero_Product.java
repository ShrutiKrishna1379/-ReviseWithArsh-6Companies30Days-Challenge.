
// Minimum Non Zero Product of the Array Elements

package Atlassian;

public class Min_NonZero_Product {
    
    int mod=1000000007;
    public int minNonZeroProduct(int p) {
        if(p==1) return 1;
        long max=(long)(Math.pow(2,p))-1;
        long k=max/2;
        long num=max-1;
        long ans=solve(num,k);
        return (int)(ans*(max%mod)%mod);
    }
    long solve(long val,long n){
        if(n==0) return 1;
        if(n==1) return (val%mod);

        long temp = solve(val, n/2);
            temp = temp%mod;
            if(n%2!=0) {
                temp=(temp*temp)%mod;
            }
            return (temp*(val%mod))%mod;
    }

}

/*Input: p = 3
Output: 1512

Explanation: nums = [001, 010, 011, 100, 101, 110, 111]
- In the first operation we can swap the leftmost bit of the second and fifth elements.
    - The resulting array is [001, 110, 011, 100, 001, 110, 111].
- In the second operation we can swap the middle bit of the third and fourth elements.
    - The resulting array is [001, 110, 001, 110, 001, 110, 111].
The array product is 1 * 6 * 1 * 6 * 1 * 6 * 7 = 1512, which is the minimum possible product. */