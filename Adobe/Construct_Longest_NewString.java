//Construct the Longest New String

/*Input: x = 2, y = 5, z = 1
Output: 12
Explanation: We can concactenate the strings "BB", "AA", "BB", "AA", "BB", and "AB" in that order. Then, our new string is "BBAABBAABBAB". 
That string has length 12, and we can show that it is impossible to construct a string of longer length. */

package Adobe;

public class Construct_Longest_NewString {
    
    public int longestString(int x, int y, int z) {
        return (Math.min(x, y + 1) + Math.min(x + 1, y) + z) * 2;
    }
}
