/*Input: secret = "1807", guess = "7810"
Output: "1A3B" */

package Microsoft;

public class Bulls_And_Cows {
    public String getHint(String secret, String guess) {
        int a=0,b=0;
        int arr[]=new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)) a++;
            else{
                if(arr[secret.charAt(i)-'0']++<0) b++;
                if(arr[guess.charAt(i)-'0']-->0) b++;
            }
        }
        return a+"A"+b+"B";
    }
}
