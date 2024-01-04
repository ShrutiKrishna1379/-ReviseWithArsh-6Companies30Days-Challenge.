/* Input:  str = aaaabbbccc
   Output: a4b3c3

   Time Complexity: O(N), N = length of given string.
   Auxiliary Space: O(1)
   */
  class Run_Length_Encoding
 {
	String encode(String str)
	{
        //Your code here
        int N=str.length();
        int i=0,c=1;
        String ans="";
        while(i<N){
            ans+=str.charAt(i);
            while(i<N-1&&str.charAt(i)==str.charAt(i+1)){
                c++;i++;
            }
            ans+=c;
            c=1;
            i++;
        }
        return ans;
	}
	
 }